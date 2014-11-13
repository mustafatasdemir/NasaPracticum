package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// Class to contain various sql queries to fetch relevant data to support the graphs at the front end 
// until a more elegant solution can be implemented. Generally takes a connection object and parameters 
// to construct and return a prepared statement
public class SQLQueries {
	
	public static PreparedStatement getCoAuthorshipNodeInfo(Connection connection, String topic) throws SQLException
	{
		String statement = "select rel.authorId,"
				+ "(select au.authorName from dblp.Author as au where au.authorId = rel.authorId) as AuthorName,"
				+ "GROUP_CONCAT((select CONCAT(p.publicationTitle, ' (', p.Year, ')') from dblp.Publication as p where p.publicationId = rel.publicationId) SEPARATOR '~') as PublicationList,"
				+ "COUNT(rel.publicationId) as PublicationCount "
				+ "from dblp.AuthorPublicationMap as rel "
				+ "where rel.publicationId in ("
				+ "select pub.publicationId from dblp.Publication as pub where pub.publicationTitle like ? "
				+ ") group by rel.authorId order by rel.authorId;";
		
		PreparedStatement returnStatement = connection.prepareStatement(statement);
		
		returnStatement.setString(1, (topic.isEmpty() ? "%%" : ("%"+topic+"%")));
		
		return returnStatement;
	}
	
	public static PreparedStatement getCoAuthorshipLinkInfo(Connection connection, String topic) throws SQLException
	{
		String statement = "select rel.publicationId, GROUP_CONCAT(rel.authorId) as Authors "
				+ "from dblp.AuthorPublicationMap as rel where rel.publicationId in ("
				+ "select pub.publicationId from dblp.Publication as pub where pub.publicationTitle like ? "
				+ ") group by rel.publicationId";
		
		PreparedStatement returnStatement = connection.prepareStatement(statement);
		
		returnStatement.setString(1, (topic.isEmpty() ? "%%" : ("%"+topic+"%")));
		
		return returnStatement;
	}
}
