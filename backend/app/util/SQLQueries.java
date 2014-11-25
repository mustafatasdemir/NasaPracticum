package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// Class to contain various sql queries to fetch relevant data to support the graphs at the front end 
// until a more elegant solution can be implemented. Generally takes a connection object and parameters 
// to construct and return a prepared statement
public class SQLQueries {

	public static PreparedStatement getCoAuthorshipNodeInfo(Connection connection, String topic, String sort, int limit) throws SQLException
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

		returnStatement.setString(1, (topic.isEmpty() ? "%%" : ("%"+topic.trim()+"%")));

		return returnStatement;
	}



	public static PreparedStatement getCoAuthorshipMultipleTopicsNodeInfo(Connection connection, String[] topic, String sort, int limit) throws SQLException
	{
		String statement = "select po.authorId, po.authorName, po.citationCount, po.topic, GROUP_CONCAT(po.publicationTitle, '@@@') as PublicationList from ("
				+ "(select p.publicationTitle, a.authorId, a.authorName, p.citationCount, 0 as topic from dblp.Publication p, dblp.Author a, dblp.AuthorPublicationMap m where p.publicationTitle like ? "
				+ "and m.publicationId = p.publicationId and a.authorId = m.authorId order by ? limit ?) "
				+ "union all "
				+ "(select p.publicationTitle, a.authorId, a.authorName, p.citationCount, 1 as topic from dblp.Publication p, dblp.Author a, dblp.AuthorPublicationMap m where p.publicationTitle like ? "
				+ "and m.publicationId = p.publicationId and a.authorId = m.authorId order by ? limit ?) "
				+ ") as po "
				+ "group by po.authorId "
				+ "order by ?;";

		PreparedStatement returnStatement = connection.prepareStatement(statement);

		if(topic != null && topic.length >=2){
			returnStatement.setString(1, (topic[0].isEmpty() ? "%%" : ("%"+topic[0].trim()+"%")));
			returnStatement.setString(2, (sort.equals("Citation") ? "p.citationCount desc" : "p.citationCount desc"));
			returnStatement.setInt(3, limit);
			returnStatement.setString(4, (topic[1].isEmpty() ? "%%" : ("%"+topic[1].trim()+"%")));
			returnStatement.setString(5, (sort.equals("Citation") ? "p.citationCount desc" : "p.citationCount desc"));
			returnStatement.setInt(6, limit);
			returnStatement.setString(7, (sort.equals("Citation") ? "po.citationCount desc" : "po.citationCount desc"));
		}

		return returnStatement;
	}

	public static PreparedStatement getCoAuthorshipLinkInfo(Connection connection, String topic, String sort, int limit) throws SQLException
	{
		String statement = "select rel.publicationId, GROUP_CONCAT(rel.authorId) as Authors "
				+ "from dblp.AuthorPublicationMap as rel where rel.publicationId in ("
				+ "select pub.publicationId from dblp.Publication as pub where pub.publicationTitle like ? "
				+ ") group by rel.publicationId";

		PreparedStatement returnStatement = connection.prepareStatement(statement);

		returnStatement.setString(1, (topic.isEmpty() ? "%%" : ("%"+topic.trim()+"%")));

		return returnStatement;
	}


	public static PreparedStatement getCoAuthorshipLinkInfoMultipleTopic(Connection connection, String[] topic, String sort, int limit) throws SQLException
	{
		String statement = "select links.publicationId, GROUP_CONCAT(links.authorId) as Authors from ( "
				+"(select rel.publicationId, rel.authorId from dblp.AuthorPublicationMap as rel " 
				+"inner join dblp.Publication as pub on rel.publicationId = pub.publicationId "
				+"where pub.publicationTitle like ? "
				+"order by ? "
				+"limit ?) "
				+"union all "
				+"(select rel.publicationId, rel.authorId from dblp.AuthorPublicationMap as rel " 
				+"inner join dblp.Publication as pub on rel.publicationId = pub.publicationId "
				+"where pub.publicationTitle like ? "
				+"order by ? "
				+"limit ?)"
				+") as links group by links.publicationId;";

		PreparedStatement returnStatement = connection.prepareStatement(statement);

		if(topic != null && topic.length >=2)
		{
			returnStatement.setString(1, (topic[0].isEmpty() ? "%%" : ("%"+topic[0].trim()+"%")));
			returnStatement.setString(2, sort.equals("") ? "pub.citationCount desc" : "pub.citationCount desc");
			returnStatement.setInt(3, limit);
			returnStatement.setString(4, (topic[1].isEmpty() ? "%%" : ("%"+topic[1].trim()+"%")));
			returnStatement.setString(5, sort.equals("") ? "pub.citationCount desc" : "pub.citationCount desc");
			returnStatement.setInt(6, limit);
		}

		return returnStatement;
	}

	/*
	 * SQL to get all the publications of the  author in a particular topic.
	 */
	public static PreparedStatement getPublicationInfo(Connection connection, String authorName, String topic) throws Exception{
		String statement = "";

		if(topic.isEmpty() || topic == null){//Calls this query if topic is null
			statement ="select ja.type, p.* from dblp.Author a, dblp.Publication p," 
					+"dblp. AuthorPublicationMap map," 
					+"(select dblp.JournalArticle.publicationId id,'article' type  from dblp.JournalArticle" 
					+" union all "
					+"select dblp.Book.publicationId id,'book' type  from dblp.Book" 
					+" union all "
					+"select dblp.BookChapter.publicationId id,'bookchapter' type  from dblp.BookChapter" 
					+" union all "
					+"select dblp.ConferencePaper.publicationId id,'conferencepaper' type  from dblp.ConferencePaper"
					+" union all "
					+"select dblp.PhDThesis.publicationId id,'phdthesis' type  from dblp.PhDThesis"
					+" union all "
					+"select dblp.WebPage.publicationId id,'webpage' type  from dblp.WebPage" 
					+") ja"
					+" where a.authorName= 'Þórir Harðarson' "
					+" and a.authorId = map.authorId"
					+" and map.publicationId = p.publicationId"
					+" and ja.id = p.publicationId"
					+" limit 100"
					;

			//statement = "select * from dblp.Author a where a.authorName='Þórir Harðarson'";

			PreparedStatement returnStatement = connection.prepareStatement(statement);
			//returnStatement.setString(1, (authorName.isEmpty() ? "%%" : ("%"+authorName+"%")));
			return returnStatement;
		}
		else{
			statement ="select ja.type, p.* from dblp.Author a, dblp.Publication p," 
					+"dblp. AuthorPublicationMap map," 
					+"(select dblp.JournalArticle.publicationId id,'article' type  from dblp.JournalArticle" 
					+" union all "
					+"select dblp.Book.publicationId id,'book' type  from dblp.Book" 
					+" union all "
					+"select dblp.BookChapter.publicationId id,'bookchapter' type  from dblp.BookChapter" 
					+" union all "
					+"select dblp.ConferencePaper.publicationId id,'conferencepaper' type  from dblp.ConferencePaper"
					+" union all "
					+"select dblp.PhDThesis.publicationId id,'phdthesis' type  from dblp.PhDThesis"
					+" union all "
					+"select dblp.WebPage.publicationId id,'webpage' type  from dblp.WebPage" 
					+") ja"
					+" where a.authorName=?"
					+" and a.authorId = map.authorId"
					+" and map.publicationId = p.publicationId"
					+" and ja.id = p.publicationId"
					+" and p.publicationTitle like ?"
					;

			PreparedStatement returnStatement = connection.prepareStatement(statement);
			returnStatement.setString(1, (authorName.isEmpty() ? "%%" : ("%"+authorName+"%")));
			returnStatement.setString(2, (topic.isEmpty() ? "%%" : ("%"+topic+"%")));
			return returnStatement;
		}

	}

	/*
	 * SQL to get all user parameters
	 */



	public static PreparedStatement getUserInfo(Connection connection, String authorName) throws Exception{
		String statement ="select a.authorId,a.authorName, GROUP_CONCAT( p.PublicationId) publications from "
				+"dblp.author a,"
				+"dblp.AuthorPublicationMap m,"
				+"dblp.Publication p "
				+"where a.authorName like ? "
				+"and a.authorId = m.authorId "
				+"and m.publicationId = p.publicationId "
				+"group by a.authorId,a.authorName "
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
	
	public static PreparedStatement getSchoolsByTopic(Connection connection, String topic) throws SQLException
	{
		String statement = "select sch.schoolId, sch.schoolName, sch.schoolLocation, COUNT(*) as count from dblp.Publication as pub " + 
						   "inner join dblp.PhdThesis as thesis on pub.publicationId = thesis.publicationId " +
						   "inner join dblp.school as sch on thesis.schoolId = sch.schoolId " +
						   "where pub.publicationTitle like ? " +
						   "group by sch.schoolId, sch.schoolName, sch.schoolLocation";
		
		PreparedStatement returnStatement = connection.prepareStatement(statement);
		returnStatement.setString(1, (topic.isEmpty() ? "%%" : ("%"+topic+"%")));
		
		return returnStatement;
	}
}
