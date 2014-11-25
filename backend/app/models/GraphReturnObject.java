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
	public void CoAuthorGraphData(String topic) throws SQLException
	{
		Connection connection = DB.getConnection();
		PreparedStatement preparedStatement = util.SQLQueries.getCoAuthorshipNodeInfo(connection, (topic.matches("All") ? "" : topic));
		ResultSet resultSet = preparedStatement.executeQuery();
		
		while(resultSet.next())
		{
			if(nodes==null)
			{
				nodes = new ArrayList<Node>();
			}
			Node node = new Node("", topic, resultSet.getString("AuthorName"), resultSet.getString("PublicationList"), resultSet.getString("authorId"), "Author", resultSet.getLong("PublicationCount"));
			nodes.add(node);
		}
		
		preparedStatement = util.SQLQueries.getCoAuthorshipLinkInfo(connection, (topic.matches("All") ? "" : topic));
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
		
		for(String key: coAuthorLinks.keySet())
		{
			String[] link = key.split(",");
			links.add(new Link(link[0], link[1], coAuthorLinks.get(key)));
		}
	}

	

	
	// Sets the nodes and links to reflect Co-Authorship of the topic being queried. Topic 'All' returns all data  
	public void CoAuthorGraphDataMultipleTopic(String[] topic) throws SQLException
	{
		Connection connection = DB.getConnection();
		PreparedStatement preparedStatement = util.SQLQueries.getCoAuthorshipMultipleTopicsNodeInfo(connection, topic);
		ResultSet resultSet = preparedStatement.executeQuery();
		
		while(resultSet.next())
		{
			if(nodes==null)
			{
				nodes = new ArrayList<Node>();
			}
			Node node = new Node("", topic[0] + topic[1], resultSet.getString("AuthorName"), resultSet.getString("PublicationList"), resultSet.getString("authorId"), "Author", resultSet.getLong("PublicationCount"));
			nodes.add(node);
		}
		
		preparedStatement = util.SQLQueries.getCoAuthorshipLinkInfoMultipleTopic(connection, topic);
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
		
		for(String key: coAuthorLinks.keySet())
		{
			String[] link = key.split(",");
			links.add(new Link(link[0], link[1], coAuthorLinks.get(key)));
		}
	}
}
