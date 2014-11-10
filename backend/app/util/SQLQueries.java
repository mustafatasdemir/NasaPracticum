package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SQLQueries {
	
	public static PreparedStatement getCoAuthorshipNodeInfo(String topic, Connection connection) throws SQLException
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
	
	public static PreparedStatement getCoAuthorshipLinkInfo(String topic, Connection connection) throws SQLException
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
