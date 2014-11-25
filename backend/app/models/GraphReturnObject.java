package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

import play.db.*;


// The model representation of the graph containing a list of nodes and a list of links.
public class GraphReturnObject {
	
	public List<Node> nodes;
	public List<Link> links;

	public GraphReturnObject() {
		// TODO Auto-generated constructor stub
	}
	
	public void reset()
	{
		nodes = null;
		links = null;
	}
	
	// Sets the nodes and links to reflect Co-Authorship of the topic being queried. Topic 'All' returns all data  
	public void CoAuthorGraphData(String parameter) throws SQLException
	{
		Connection connection = DB.getConnection();
		PreparedStatement preparedStatement = null;
		String[] topics = null;
		
		String[] parameters = parameter.split("&");
		
		if(parameters[0].contains(","))
		{
			topics = parameters[0].split(",");
			preparedStatement = util.SQLQueries.getCoAuthorshipMultipleTopicsNodeInfo(connection, topics, parameters[1], Integer.parseInt(parameters[2])/topics.length);
		}
		else
		{
			preparedStatement = util.SQLQueries.getCoAuthorshipNodeInfo(connection, (parameters[0].matches("All") ? "" : parameters[0]), parameters[1], Integer.parseInt(parameters[2]));
		}		
		
		ResultSet resultSet = preparedStatement.executeQuery();
		
		while(resultSet.next())
		{
			if(nodes==null)
			{
				nodes = new ArrayList<Node>();
			}
			Node node = new Node("", topics == null ? parameters[0] : topics[resultSet.getInt("Topic")], resultSet.getString("AuthorName"), resultSet.getString("PublicationList"), resultSet.getString("authorId"), "Author", resultSet.getLong(topics == null ? "PublicationCount" : "citationCount"));
			nodes.add(node);
		}
		
		if(topics != null)
		{
			preparedStatement = util.SQLQueries.getCoAuthorshipLinkInfoMultipleTopic(connection, topics, parameters[1], Integer.parseInt(parameters[2])/topics.length);
		}
		else
		{
			preparedStatement = util.SQLQueries.getCoAuthorshipLinkInfo(connection, (parameters[0].matches("All") ? "" : parameters[0]), parameters[1], Integer.parseInt(parameters[2]));
		}
		
		resultSet = preparedStatement.executeQuery();
		
		
		HashMap<String, Long> coAuthorLinks = new HashMap<String, Long>();
		String edge = "";
		String mirrorEdge = "";
		while(resultSet.next())
		{
			if(links == null)
			{
				links = new ArrayList<Link>();
			}
			String[] authors = resultSet.getString("Authors").split(",");
			for(int i = 0; i < authors.length - 1; i++)
			{
				for(int j = i + 1; j < authors.length; j++)
				{
					edge = authors[i].trim() + "," + authors[j].trim();
					mirrorEdge = authors[j].trim() + "," + authors[i].trim();
					if(coAuthorLinks.containsKey(edge))
					{
						coAuthorLinks.put(edge, coAuthorLinks.get(edge).longValue() + 1);
					}
					else if (coAuthorLinks.containsKey(mirrorEdge))
					{
						coAuthorLinks.put(mirrorEdge, coAuthorLinks.get(mirrorEdge).longValue() + 1);
					}
					else
					{
						coAuthorLinks.put(edge.toString(), 1L);
					}
					edge = "";
					mirrorEdge = "";
				}
			}
		}
		
		preparedStatement.close();
		
		for(String key: coAuthorLinks.keySet())
		{
			String[] link = key.split(",");
			links.add(new Link(link[0], link[1], coAuthorLinks.get(key)));
		}
	}
}
