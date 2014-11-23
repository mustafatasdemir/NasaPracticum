package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	
	/*
	 * SQL to get all the publications of the  author in a particular topic.
	 */
	public static PreparedStatement getPublicationInfo(Connection connection, String authorName, String topic) throws Exception{
		 String statement = "";
		
		if(topic.isEmpty()){//Calls this query if topic is null
			 statement ="select ja.type, p.* from dblp.Author a, dblp.Publication p," 
					+"dblp. AuthorPublicationMap map," 
					+"(select dblp.JournalArticle.publicationId id,'article' type  from dblp.JournalArticle" 
					+"union all"
					+"select dblp.Book.publicationId id,'book' type  from dblp.Book" 
					+"union all"
					+"select dblp.BookChapter.publicationId id,'bookchapter' type  from dblp.BookChapter" 
					+"union all"
					+"select dblp.ConferencePaper.publicationId id,'conferencepaper' type  from dblp.ConferencePaper"
					+"union all"
					+"select dblp.PhDThesis.publicationId id,'phdthesis' type  from dblp.PhDThesis"
					+"union all"
					+"select dblp.WebPage.publicationId id,'webpage' type  from dblp.WebPage" 
					+") ja"
					+"where a.authorName=?"
					+" and a.authorId = map.authorId"
					+" and map.publicationId = p.publicationId"
					+"and ja.id = p.publicationId"
					+"limit 100"
					;
		}
		else{
			 statement ="select ja.type, p.* from dblp.Author a, dblp.Publication p," 
					+"dblp. AuthorPublicationMap map," 
					+"(select dblp.JournalArticle.publicationId id,'article' type  from dblp.JournalArticle" 
					+"union all"
					+"select dblp.Book.publicationId id,'book' type  from dblp.Book" 
					+"union all"
					+"select dblp.BookChapter.publicationId id,'bookchapter' type  from dblp.BookChapter" 
					+"union all"
					+"select dblp.ConferencePaper.publicationId id,'conferencepaper' type  from dblp.ConferencePaper"
					+"union all"
					+"select dblp.PhDThesis.publicationId id,'phdthesis' type  from dblp.PhDThesis"
					+"union all"
					+"select dblp.WebPage.publicationId id,'webpage' type  from dblp.WebPage" 
					+") ja"
					+"where a.authorName=?"
					+" and a.authorId = map.authorId"
					+" and map.publicationId = p.publicationId"
					+"and ja.id = p.publicationId"
					+"and p.publicationTitle like ?"
					;
		}
		
		
		PreparedStatement returnStatement = connection.prepareStatement(statement);
		
		//Setting the parameters
		returnStatement.setString(1, (authorName.isEmpty() ? "%%" : ("%"+authorName+"%")));
		returnStatement.setString(2, (topic.isEmpty() ? "%%" : ("%"+topic+"%")));
		
		
		return returnStatement;
	}
	
	/*
	 * SQL to get all user parameters
	 */
	
	
	
	public static PreparedStatement getUserInfo(Connection connection, String authorName) throws Exception{
		String statement ="select a.authorId,a.authorName, GROUP_CONCAT( p.PublicationId) publications from "
			+"dblp.author a,"
			+"dblp.AuthorPublicationMap m,"
			+"dblp.Publication p"
			+"where a.authorName like ?"
			+"and a.authorId = m.authorId"
			+"and m.publicationId = p.publicationId"
			+"group by a.authorId,a.authorName"
		;
		
		PreparedStatement returnStatement = connection.prepareStatement(statement);
		
		//Setting the parameters
		returnStatement.setString(1, (authorName.isEmpty() ? "%%" : ("%"+authorName+"%")));
		return returnStatement;
	
}
	/*
	 * getting publication details
	 */
	public static PreparedStatement getPublicationObject(Connection connection, int id) throws Exception{
		String statement ="select * from dblp.Publication where publicationId = ? "
			;
		

		PreparedStatement returnStatement = connection.prepareStatement(statement);
		
		//Setting the parameters
		returnStatement.setLong(1, id);
		return returnStatement;
	}
}
