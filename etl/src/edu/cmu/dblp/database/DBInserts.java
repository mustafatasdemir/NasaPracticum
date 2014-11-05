package edu.cmu.dblp.database;

import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import edu.cmu.dblp.model.*;//Importing all the models

public class DBInserts {
	/*
	 * This method inserts the data into database tables based on the type of the publication object
	 */
	private static final Logger logger = Logger.getLogger( DBInserts.class.getName() );

	public DBInserts(){
		FileHandler fh;  
		try {  
			fh = new FileHandler("logs/etl.log");
			logger.addHandler(fh);
			SimpleFormatter formatter = new SimpleFormatter();  
			fh.setFormatter(formatter);
			logger.setUseParentHandlers(false);
		} catch (SecurityException e) {  
			e.printStackTrace();  
		} catch (IOException e) {  
			e.printStackTrace();  
		} 
	}

	private static DBInserts instance = null;
	public static DBInserts getInstance() {
		if(instance == null) {
			instance = new DBInserts();
		}
		return instance;
	}

	public static DBConnection dBConnection = new MySQLConnection();
	public static List < String > explicitColumnNames = new ArrayList < String > ();
	//	public static explicitColumnNames = null;




	public void DBInserts(Publication publication, MetaData metadata) throws Exception {

		List < Publication > publicationList = new ArrayList < Publication > ();
		/*--------------Insert into master table publication starts here ----------------------*/

		publicationList.add(publication);

		DBInsertQueries < Publication > dBInsertQueries = new DBInsertQueries < Publication > (Publication.class, dBConnection, explicitColumnNames);
		publicationList = dBInsertQueries.insertItems(publicationList);

		int publicationId = publicationList.get(0).getPublicationId();

		/*-------------Insert into master table publication ends here ----------------------------*/



		for (int i = 0; i < publication.getAuthorNames().size(); i++) {
			//List < Author > author = new DBSelectQueries < Author > (Author.class, dBConnection, explicitColumnNames, "authorName='" + publication.getAuthorNames().get(i).replace("'", "\\'") + "'").getResults();
			int authorId = 0;

			//if (author.isEmpty()) {
			/*-------Insert into author table starts here -----------*/
			Author authorInsert = new Author();
			List < Author > authorList = new ArrayList < Author > ();

			authorInsert.setAuthorName(publication.getAuthorNames().get(i));
			authorInsert.setInstitution("");//Need to assign actual value if in future we start getting institution from the dataset

			authorList.add(authorInsert);

			try {
				DBInsertQueries < Author > authorInsertQueries = new DBInsertQueries < Author > (Author.class, dBConnection, explicitColumnNames);
				authorList = authorInsertQueries.insertItems(authorList);
				authorId = authorList.get(0).getAuthorId();
			} catch (SQLIntegrityConstraintViolationException e) {
				logger.info(e.getMessage());
				List < Author > author = new DBSelectQueries < Author > (Author.class, dBConnection, explicitColumnNames, "authorName='" + publication.getAuthorNames().get(i).replace("'", "\\'") + "'").getResults();
				authorId = author.get(0).getAuthorId();
			}
			/*-------Insert into author table ends here-----------*/

			/*
			//DBInsertQueries < Author > authorInsertQueries = new DBInsertQueries < Author > (Author.class, dBConnection, explicitColumnNames);
			//authorList = authorInsertQueries.insertItems(authorList);

			//authorId = authorList.get(0).getAuthorId();
			-------Insert into author table ends here-----------
			//} else {
			//authorId = author.get(0).getAuthorId();
			//}

			Commenting to handle SQLExceptions in case of duplicate authorName*/
			
			
			
			/*-----Insert into map table starts here--------*/

			AuthorPublicationMap map = new AuthorPublicationMap();
			List < AuthorPublicationMap > mapList = new ArrayList < AuthorPublicationMap > ();
			map.setAuthorId(authorId);
			map.setPublicationId(publicationId);
			
			mapList.add(map);

			DBInsertQueries < AuthorPublicationMap > mapInsertQueries = new DBInsertQueries < AuthorPublicationMap > (AuthorPublicationMap.class, dBConnection, explicitColumnNames);
			mapList = mapInsertQueries.insertItems(mapList);

			/*-----Insert into map table ends here--------*/

		}

		if (publication instanceof Book) {
			List < String > editors = new ArrayList < String > ();
			insertBook(publicationId, editors,
				((Book) publication).getPages(),
				((Book) publication).getMonth(),
				publication.getUrl(),
				publication.getPublisher(),
				((Book) publication).getIsbn(),
				((Book) publication).getSeries());
		} 
		else if (publication instanceof BookChapter) {
			insertBookChapter(
				((BookChapterData) metadata).getBookChapterName() ,
				((BookChapterData) metadata).getRelevance(),
				((BookChapter) publication).getPages(),
				publicationId);
		} 
		else if (publication instanceof ConferencePaper) {
			insertConferencePaper( 
				((Conference) metadata).getConferenceName() ,
				((Conference) metadata).getConferenceLocation()  ,
				((Conference) metadata).getRelevance()  , 
				publicationId,
				((ConferencePaper) publication).getPages(),
				publication.getUrl());
		} 
		else if (publication instanceof JournalArticle) {
			insertJournalArticle( 
				((Journal) metadata).getJournalName()  , 
				((Journal) metadata).getRelevance(),
				publicationId,
				((JournalArticle) publication).getPages(),
				((JournalArticle) publication).getVolume(),
				((JournalArticle) publication).getColumns(),
				((JournalArticle) publication).getUrl()
				);		
		} 
		else if (publication instanceof PhdThesis) {
			insertPhDThesis( 
				((School) metadata).getSchoolName() ,
				((School) metadata).getSchoolLocation(), 
				((School) metadata).getRelevance(),
				publicationId,
				((PhdThesis) publication).getDepartment() , 
				((PhdThesis) publication).getAdvisorName() );

		} 
		else if (publication instanceof WebPage) {
			insertWebpage(
				publicationId,
				publication.getUrl(),
				((WebPage) publication).getAccessDate());
		}
	}

	//	public static void main(String args[]) throws Exception {
	//		//DBInserts("Journal");
	//		Book book = new Book();
	//		book.getAuthorNames().add("Mustafa Tasdemir");
	//		book.setIsbn("asamdmas");
	//		book.setMonth("June");
	//		//book.getTags().add("sanane");
	//		book.setPages("123");
	//		book.setPublisher("Ben");
	//		book.setUrl("saa");
	//		book.setYear("1990");
	//		book.setPublicationChannel("channel");
	//		book.setPublicationTitle("Deneme");
	//		DBInserts(book);
	//	}


	
	
	/*
	 * Method to insert Book into the table Book
	 */
	public static void insertBook(int publicationId, List < String > editors, String pages, String month, String url, String publisher, String isbn, String series) throws Exception {
		Book bookInsert = new Book();
		List < Book > bookList = new ArrayList < Book > ();
		bookInsert.setPublicationId(publicationId); //Publication Id that just got created


		bookInsert.setEditors(editors);
		bookInsert.setPages(pages);
		bookInsert.setMonth(month);
		bookInsert.setUrl(url);
		bookInsert.setPublisher(publisher);
		bookInsert.setIsbn(isbn);
		bookInsert.setSeries(series);
		bookList.add(bookInsert);

		DBInsertQueries < Book > bookInsertQueries = new DBInsertQueries < Book > (Book.class, dBConnection, explicitColumnNames);
		bookList = bookInsertQueries.insertItems(bookList);
	}


	
	/*
	 * Method to insert into bookChapter and BookChapterdata tables
	 */
	public static void insertBookChapter(String BookChapterName, double relevance, String Pages, int publicationId) throws Exception {
		//List < BookChapterData > bookChapterdata = new DBSelectQueries < BookChapterData > (BookChapterData.class, dBConnection, explicitColumnNames, "bookChapterName=" + BookChapterName).getResults();
		int bookChapterDataId = 0;

		//if (bookChapterdata.isEmpty()) { //Checking if bookChapterName already exists in the table bookChapterName

		
		
		/*-----------Insert into BookChapterData starts here ------*/
		BookChapterData bookChapterData = new BookChapterData();
		List < BookChapterData > bookChapterDataList = new ArrayList < BookChapterData > ();

		bookChapterData.setBookChapterName(BookChapterName);
		bookChapterData.setRelevance(relevance);

		bookChapterDataList.add(bookChapterData);
		
		try{
			DBInsertQueries < BookChapterData > bcdInsertQueries = new DBInsertQueries < BookChapterData > (BookChapterData.class, dBConnection, explicitColumnNames);
			bookChapterDataList = bcdInsertQueries.insertItems(bookChapterDataList);
			bookChapterDataId = bookChapterDataList.get(0).getBookChapterData();
		}catch (SQLIntegrityConstraintViolationException e) {
			List < BookChapterData > bookChapterdata = new DBSelectQueries < BookChapterData > (BookChapterData.class, dBConnection, explicitColumnNames, "bookChapterName=" + BookChapterName).getResults();
			bookChapterDataId = bookChapterdata.get(0).getBookChapterData();	
		}

		
		/*-----------Insert into BookChapterData ends here ------*/
		
		
		
		
			//	} else {
			//		bookChapterDataId = bookChapterdata.get(0).getBookChapterData();
			//	}


		
		
		
		/*-----------Insert into BookChapter starts here ------*/
		BookChapter bookChapter = new BookChapter();
		List < BookChapter > bookChapterList = new ArrayList < BookChapter > ();
		bookChapter.setBookChapterDataId(bookChapterDataId);
		bookChapter.setPublicationId(publicationId);
		bookChapter.setPages(Pages);
		bookChapterList.add(bookChapter);

		DBInsertQueries < BookChapter > bcInsertQueries = new DBInsertQueries < BookChapter > (BookChapter.class, dBConnection, explicitColumnNames);
		bookChapterList = bcInsertQueries.insertItems(bookChapterList);
		/*-----------Insert into BookChapter ends here ------*/
	}



	/*
	 * Method to insert into ConferencePaper and Conference tables
	 */
	public static void insertConferencePaper(String conferenceName, String conferenceLocation, double relevance, int publicationId, String pages, String url) throws Exception {
		//List < Conference > conferenceListInfo = new DBSelectQueries < Conference > (Conference.class, dBConnection, explicitColumnNames, "ConferenceName=" + conferenceName).getResults();
		int conferenceId = 0;

		//if (conferenceListInfo.isEmpty()) { //Checking if conferenceName already exists in the table Conference

		/*-----------Insert into Conference starts here ------*/
		Conference conference = new Conference();
		List < Conference > conferenceList = new ArrayList < Conference > ();

		conference.setConferenceLocation(conferenceLocation);
		conference.setConferenceName(conferenceName);
			conference.setRelevance(relevance); //Setting the relevance score as 1 temporarily 

			conferenceList.add(conference);
			
			try{
				DBInsertQueries < Conference > conferenceInsertQueries = new DBInsertQueries < Conference > (Conference.class, dBConnection, explicitColumnNames);
				conferenceList = conferenceInsertQueries.insertItems(conferenceList);

				conferenceId = conferenceList.get(0).getConferenceId();
			}
			catch (SQLIntegrityConstraintViolationException e) {
				List < Conference > conferenceListInfo = new DBSelectQueries < Conference > (Conference.class, dBConnection, explicitColumnNames, "ConferenceName=" + conferenceName).getResults();
				conferenceId = conferenceListInfo.get(0).getConferenceId();
			}

			
			/*-----------Insert into Conference ends here ------*/
			
			
			
			
				//} else {
				//conferenceId = conferenceListInfo.get(0).getConferenceId();
				//}
			
			
			
			
			/*-----------Insert into ConferencePaper starts here ------*/
			ConferencePaper conferencePaper = new ConferencePaper();
			List < ConferencePaper > conferencePaperList = new ArrayList < ConferencePaper > ();

			conferencePaper.setPublicationId(publicationId);
			conferencePaper.setConferenceId(conferenceId);
			conferencePaper.setPages(pages);
			conferencePaper.setUrl(url);


			conferencePaperList.add(conferencePaper);

			DBInsertQueries < ConferencePaper > cpInsertQueries = new DBInsertQueries < ConferencePaper > (ConferencePaper.class, dBConnection, explicitColumnNames);
			conferencePaperList = cpInsertQueries.insertItems(conferencePaperList);
			/*-----------Insert into ConferencePaper ends here ------*/
		}

	/*
	 * Method to insert into journalArticle and Journal Tables
	 */
	public static void insertJournalArticle(String journalName, double relevance, int publicationId, String pages, String volume, String columns, String url) throws Exception {

		//List < Journal > journalInfo = new DBSelectQueries < Journal > (Journal.class, dBConnection, explicitColumnNames, "journalName=" + journalName).getResults();
		int journalId = 0;

		//if (journalInfo.isEmpty()) { //Checking if journal already exists in the table Conference

		/*-----------Insert into JOurnal starts here ------*/
		Journal journal = new Journal();
		List < Journal > journalList = new ArrayList < Journal > ();


		journal.setJournalName(journalName);
			journal.setRelevance(relevance); //Setting the relevance score as 1 temporarily 

			journalList.add(journal);
			
			try{
				DBInsertQueries < Journal > jInsertQueries = new DBInsertQueries < Journal > (Journal.class, dBConnection, explicitColumnNames);
				journalList = jInsertQueries.insertItems(journalList);

				journalId = journalList.get(0).getJournalId();
			}
			catch (SQLIntegrityConstraintViolationException e) {
				List < Journal > journalInfo = new DBSelectQueries < Journal > (Journal.class, dBConnection, explicitColumnNames, "journalName=" + journalName).getResults();
				journalId = journalInfo.get(0).getJournalId();
			}

			
			/*-----------Insert into Conference ends here ------*/
			
			
			
			
		//} else {
		//	journalId = journalInfo.get(0).getJournalId();
		//}

			
			
			
			
			/*-----------Insert into JOurnalArticle starts here ------*/
			JournalArticle journalArticle = new JournalArticle();
			List < JournalArticle > journalArticleList = new ArrayList < JournalArticle > ();


			journalArticle.setJournalId(journalId);
			journalArticle.setPublicationId(publicationId);
			journalArticle.setPages(pages);
			journalArticle.setVolume(volume);
			journalArticle.setColumns(columns);
			journalArticle.setUrl(url);



			journalArticleList.add(journalArticle);

			DBInsertQueries < JournalArticle > jaInsertQueries = new DBInsertQueries < JournalArticle > (JournalArticle.class, dBConnection, explicitColumnNames);
			journalArticleList = jaInsertQueries.insertItems(journalArticleList);
			/*-----------Insert into JOurnalArticle ends here ------*/

		}

	/*
	 * Method to insert into PhdThesis and School tables
	 */
	public static void insertPhDThesis(String schoolName, String location, double relevance, int publicationId, String department, String advisorName) throws Exception {



		//List < School > schoolInfo = new DBSelectQueries < School > (School.class, dBConnection, explicitColumnNames, "schoolName=" + schoolName).getResults();
		int schoolId = 0;

		//if (schoolInfo.isEmpty()) { //Checking if school already exists in the table School

		/*-----------Insert into school starts here ------*/
		School school = new School();
		List < School > schoolList = new ArrayList < School > ();

		school.setSchoolName(schoolName);
		school.setSchoolLocation(location);
		school.setRelevance(relevance);

		schoolList.add(school);
		
		try{
			DBInsertQueries < School > InsertQueries = new DBInsertQueries < School > (School.class, dBConnection, explicitColumnNames);
			schoolList = InsertQueries.insertItems(schoolList);

			schoolId = schoolList.get(0).getSchoolId();
			
		}
		catch (SQLIntegrityConstraintViolationException e) {
			List < School > schoolInfo = new DBSelectQueries < School > (School.class, dBConnection, explicitColumnNames, "schoolName=" + schoolName).getResults();
			schoolId = schoolInfo.get(0).getSchoolId();
			
		}			
		/*-----------Insert into school ends here ------*/
		
		
		
		//} else {
		//	schoolId = schoolInfo.get(0).getSchoolId();
		//}

		
		
		/*-----------Insert into phDThesis starts here ------*/
		PhdThesis phdthesis = new PhdThesis();
		List < PhdThesis > phdthesisList = new ArrayList < PhdThesis > ();


		phdthesis.setSchoolId(schoolId);
		phdthesis.setPublicationId(publicationId);
		phdthesis.setDepartment(department);
		phdthesis.setAdvisorName(advisorName);




		phdthesisList.add(phdthesis);

		DBInsertQueries < PhdThesis > InsertQueries = new DBInsertQueries < PhdThesis > (PhdThesis.class, dBConnection, explicitColumnNames);
		phdthesisList = InsertQueries.insertItems(phdthesisList);
		/*-----------Insert into phDThesis ends here ------*/

	}
	
	/*
	 * Method to insert records into the webPage table
	 */
	public static void insertWebpage(int publicationId, String url, String accessDate) throws Exception {


		WebPage webpage = new WebPage();
		List < WebPage > webpagelist = new ArrayList < WebPage > ();


		webpage.setPublicationId(publicationId);
		webpage.setUrl(url);
		webpage.setAccessDate(accessDate);


		webpagelist.add(webpage);

		DBInsertQueries < WebPage > bookInsertQueries = new DBInsertQueries < WebPage > (WebPage.class, dBConnection, explicitColumnNames);
		webpagelist = bookInsertQueries.insertItems(webpagelist);

	}
}