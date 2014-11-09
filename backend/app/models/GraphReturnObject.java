package models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

import play.db.*;

public class GraphReturnObject {
	
	public List<Node> nodes;
	public List<Link> links;

	public GraphReturnObject() {
		// TODO Auto-generated constructor stub
	}
	
	public void CoAuthorGraphData() throws SQLException
	{
		String QUERY = "select rel.authorId,"
				+ "(select au.authorName from dblp.Author as au where au.authorId = rel.authorId) as AuthorName,"
				+ "GROUP_CONCAT((select CONCAT(p.publicationTitle, ' (', p.Year, ')') from dblp.Publication as p where p.publicationId = rel.publicationId) SEPARATOR '~') as PublicationList,"
				+ "COUNT(rel.publicationId) as PublicationCount "
				+ "from dblp.AuthorPublicationMap as rel "
				+ "where rel.publicationId in ("
				+ "select pub.publicationId from dblp.Publication as pub" /*where pub.publicationTitle like '%Cloud Computing%'*/
				+ ") group by rel.authorId order by rel.authorId;";
		
		String QUERY2 = "select rel.publicationId, GROUP_CONCAT(rel.authorId) as Authors "
				+ "from dblp.AuthorPublicationMap as rel where rel.publicationId in ("
				+ "select pub.publicationId from dblp.Publication as pub" /*where pub.publicationTitle like '%Cloud Computing%'*/
				+ ") group by rel.publicationId";
		
		Connection connection = DB.getConnection();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(QUERY);
		
		while(resultSet.next())
		{
			if(nodes==null)
			{
				nodes = new ArrayList<Node>();
			}
			Node node = new Node("", "Cloud Computing", resultSet.getString("AuthorName"), resultSet.getString("PublicationList"), resultSet.getString("authorId"), "Author", resultSet.getLong("PublicationCount"));
			nodes.add(node);
		}
		
		statement = connection.createStatement();
		resultSet = statement.executeQuery(QUERY2);
		
		
		HashMap<String, Long> coAuthorLinks = new HashMap<String, Long>();
		StringBuilder edge = new StringBuilder();
		while(resultSet.next())
		{
			if(links == null)
			{
				links = new ArrayList<Link>();
			}
			String[] authors = resultSet.getString("Authors").split(",");
			for(int i = 0; i < authors.length - 2; i++)
			{
				for(int j = i + 1; j < authors.length - 1; j++)
				{
					edge.append(authors[i].trim() + "," + authors[j].trim());
					if(coAuthorLinks.containsKey(edge.toString()))
					{
						coAuthorLinks.put(edge.toString(), coAuthorLinks.get(edge.toString()).longValue() + 1);
					}
					else if (coAuthorLinks.containsKey(edge.reverse().toString()))
					{
						coAuthorLinks.put(edge.reverse().toString(), coAuthorLinks.get(edge.reverse().toString()).longValue() + 1);
					}
					else
					{
						coAuthorLinks.put(edge.toString(), 1L);
					}
					edge.setLength(0);
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
