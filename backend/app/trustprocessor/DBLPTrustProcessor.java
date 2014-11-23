package trustprocessor;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;

import models.CoAuthorShip;
import models.DBLPUser;
import models.Publication;

import org.xml.sax.SAXException;
import org.apache.commons.lang3.StringUtils;

import play.db.DB;

public class DBLPTrustProcessor {
	//Commented by Jisha :HashMap<String,DBLPUser> dblp;
	TrustModelWeights trustModelWeights;

	public DBLPTrustProcessor() throws SAXException, ParserConfigurationException{
		trustModelWeights = new TrustModelWeights();
//		DatasetInterface dblpDataset = new DBLPDataSource();
//	dblp = dblpDataset.getDataset("dblp_example.xml");
		
		
		// TODO: Mustafa - Select from DB
	}

	public DBLPTrustProcessor(String fileName) throws SAXException, ParserConfigurationException {
		trustModelWeights = new TrustModelWeights();
//		DatasetInterface dblpDataset = new DBLPDataSource();
	//	dblp = dblpDataset.getDataset(fileName);
	}

	/*
	 * This method would return take as input all the developers names D =
	 * {D1,D2,D3....DN} along with the context and return a Map of developer
	 * names to DBLP Trust Values
	 */

	public HashMap<String, DBLPTrustModel> calculateDeveloperTrustMatrix(
			List<String> developerList, String context) throws Exception {

		HashMap<String, DBLPTrustModel> developerNameMappedToTrustModelValue = new HashMap<String, DBLPTrustModel>();

		//Commented by Jisha
		//ArrayList<DBLPUser> contextFilteredDBLPUserList = getAuthorsFromContext(context);

		//SOLRQueries
		//.DBLPSourceContextMiner(context);

		HashMap<String, DBLPUser> contextFilteredDBLPUserNameToObject = new HashMap<String, DBLPUser>();
		//Commented by Jisha
		/*for (DBLPUser contextFilteredDBLPUser : contextFilteredDBLPUserList) {
			contextFilteredDBLPUserNameToObject.put(
					contextFilteredDBLPUser.getName(), contextFilteredDBLPUser);
		}*/

		/*
		 * Take each Software then get the set of developers on that
		 */

		for (String developerName : developerList) {
			DBLPUser matchedDeveloper = contextFilteredDBLPUserNameToObject
					.get(developerName);
			DBLPTrustModel dblpTrustModel = null;
			if (matchedDeveloper != null) {
				dblpTrustModel = calculateDBLPTrustFactor(matchedDeveloper);
				dblpTrustModel.setDblpUser(matchedDeveloper);
			}
			developerNameMappedToTrustModelValue.put(developerName,
					dblpTrustModel);
		}
		return developerNameMappedToTrustModelValue;

	}

	public ArrayList<DBLPTrustModel> expertTrustMatrix(List<String> expertNames) throws Exception {

		ArrayList<DBLPTrustModel> expertTrustModelList = new ArrayList<DBLPTrustModel>();

		//		ArrayList<DBLPUser> expertDBLPObjects = SOLRQueries
		//				.parseDBLPUserInfoFromName(expertNames);

		ArrayList<DBLPUser> expertDBLPObjects = new ArrayList<DBLPUser>();

		for(String name: expertNames) {
			expertDBLPObjects.add(getDBLPUserFromName(name));
		}

		DBLPTrustModel dblpTrustModel = null;
		for (DBLPUser expertUser : expertDBLPObjects) {
			dblpTrustModel = calculateDBLPTrustFactor(expertUser);
			dblpTrustModel.setDblpUser(expertUser);			
			expertTrustModelList.add(dblpTrustModel);
		}
		return expertTrustModelList;

	}

	private DBLPUser getDBLPUserFromName(String name) throws Exception {
		DBLPUser user = new DBLPUser();
		List<Publication> publicationList = new ArrayList<Publication>();
		
		Connection connection = DB.getConnection();
		PreparedStatement preparedStatement = util.SQLQueries.getUserInfo(connection, name );// Query to get all userInformation and set the user object
		ResultSet resultSet = preparedStatement.executeQuery();
		
		
		while(resultSet.next()){
			
			Integer.parseInt(resultSet.getString("citationCount"));
			
			user.setId(Integer.parseInt(resultSet.getString("authorId")));
			user.setName(name);
			String[] publications = resultSet.getString("publications").split(",");
			for(int i=0;i<publications.length;i++)
			{
				publicationList.add( new Publication(Integer.parseInt(publications[i])));
			}
			
			user.setPublicationList(publicationList);
			
			
		}

		return user;
	}

	public ArrayList<DBLPTrustModel> trustModelForAuthorIds(ArrayList<Long> authorIdList) throws Exception {

		ArrayList<DBLPTrustModel> expertTrustModelList = new ArrayList<DBLPTrustModel>();

		//ArrayList<DBLPUser> expertDBLPObjects = SOLRQueries.parseDBLPUserInfoFromId(authorIdList);

		ArrayList<DBLPUser> expertDBLPObjects = new ArrayList<DBLPUser>();

		for(Long id: authorIdList) {
			//Commented by Jisha expertDBLPObjects.add(getDBLPUserFromID(id));
		}

		DBLPTrustModel dblpTrustModel = null;
		for (DBLPUser expertUser : expertDBLPObjects) {
			dblpTrustModel = calculateDBLPTrustFactor(expertUser);
			dblpTrustModel.setDblpUser(expertUser);			
			expertTrustModelList.add(dblpTrustModel);
		}
		return expertTrustModelList;

	}

	//Commented by Jisha
	/*private DBLPUser getDBLPUserFromID(Long id) throws SAXException, ParserConfigurationException {
		DBLPUser result;

		for(String key : dblp.keySet()) {
			if(dblp.get(key).getId() == id) {
				result = dblp.get(key);
				return result;
			}
		}

		return null;
	}*/
	/*
	 * Method to calculate trust factor for a user
	 * Need to consider topic also
	 * need to change the input to String if only the name is passed from front end
	 */
	public DBLPTrustModel calculateDBLPTrustFactor(DBLPUser dblpUser) throws Exception {
		DBLPTrustModel dblpTrustModel = new DBLPTrustModel();

		// ///// Knowledge Factor ///////////
		KPaperPublished kPaperPublished = calculateKPaperPublished(dblpUser);
		DBLPKnowledgeFactor dblpKnowledgeFactor = new DBLPKnowledgeFactor();
		dblpKnowledgeFactor.setkPaperPublished(kPaperPublished);

		// ///////////////////////////////////
		dblpTrustModel.setDblpKnowledgeFactor(dblpKnowledgeFactor);
		// //// Social Factor ///////////
		DBLPSocialFactor dblpSocialFactor = new DBLPSocialFactor();
		//KCoauthorship kCoauthorship = calculateKCoauthorship(dblpUser.getId());


		//dblpSocialFactor.setkCoauthorship(kCoauthorship);
		//dblpTrustModel.setDblpSocialFactor(dblpSocialFactor);
		// //////////////////////////////////

		dblpTrustModel.setTrustValue(dblpSocialFactor.getkCoauthorship()
				.getTimeScaledCoauthorship()
				+ dblpKnowledgeFactor.getkPaperPublished()
				.getFinalKPaperPublished());

		return dblpTrustModel;
	}

	/*Commented by Jisha
	 * private KCoauthorship calculateKCoauthorship(int authorId) throws Exception {
		double coauthorshipCount = 0;

		TimeScale timeScale = new TimeScale();
		KCoauthorship kCoauthorship = new KCoauthorship();
		double socialCoathorshipFactorForaCoauthor = 0;

		List<CoauthorshipEdge> coauthorshipDetailsList = getCoAuthorshipEdgeList(authorId);

		int currentYear = Calendar.getInstance().get(Calendar.YEAR);

		double maxCoauth = 0;

		/////
		for (CoauthorshipEdge coauthorshipEdge : coauthorshipDetailsList) {
			List<Integer> coauthorshipDatesList = coauthorshipEdge
					.getCoauthorshipDates();
			int numberOfRecentCoauthorships = 0;
			int numberOfIntermediateCoauthorships = 0;
			int numberOfOldCoauthorships = 0;
			for (int coauthorshipYear : coauthorshipDatesList) {
				if (coauthorshipYear >= (currentYear - timeScale
						.getRecentYears())) {
					numberOfRecentCoauthorships++;
				} else if (coauthorshipYear >= (currentYear - timeScale
						.getIntermediateYears())
						&& (coauthorshipYear < currentYear
								- timeScale.getRecentYears())) {
					numberOfIntermediateCoauthorships++;
				} else {
					numberOfOldCoauthorships++;
				}
			}
			socialCoathorshipFactorForaCoauthor = timeScale.gettRecent()
					* numberOfRecentCoauthorships
					+ timeScale.gettIntermediate()
					* numberOfIntermediateCoauthorships + timeScale.gettOld()
					* numberOfOldCoauthorships;
			HashMap<Integer, Double> coauthorIdToSocialFactorFromCoauthor = kCoauthorship
					.getCoauthorIdToSocialFactorFromCoauthor();
			coauthorIdToSocialFactorFromCoauthor.put(
					(int) coauthorshipEdge.getCoauthorId(),
					socialCoathorshipFactorForaCoauthor);
			kCoauthorship
			.setCoauthorIdToSocialFactorFromCoauthor(coauthorIdToSocialFactorFromCoauthor);
		}
		HashMap<Integer, Double> coauthorIdToSocialFactorFromCoauthor = kCoauthorship
				.getCoauthorIdToSocialFactorFromCoauthor();
		Set<Integer> coauthoridSet = coauthorIdToSocialFactorFromCoauthor
				.keySet();
		for (Integer coauthorid : coauthoridSet) {
			coauthorshipCount = coauthorshipCount
					+ coauthorIdToSocialFactorFromCoauthor.get(coauthorid);
		}
		kCoauthorship.setTimeScaledCoauthorship(Math.ceil(coauthorshipCount));

		return kCoauthorship;
	}*/

	/*private List<CoauthorshipEdge> getCoAuthorshipEdgeList(int authorId) throws Exception {
		DBLPUser author = getDBLPUserFromID((long) authorId);
		List<CoauthorshipEdge> result = new ArrayList<CoauthorshipEdge>();
		List<CoAuthorShip> coauthors = author.getCoauthors();
		ListIterator<CoAuthorShip> iterator = coauthors.listIterator();

		while(iterator.hasNext()) {
			CoAuthorShip c = iterator.next();
			CoauthorshipEdge singleEdge = new CoauthorshipEdge();
			singleEdge.setUserId(authorId);
			singleEdge.setCoauthorId(c.getCoauthorid());
			singleEdge.setMappingId(c.getCoauthorshipid());

			List<String> stringDates = c.getDate();
			List<Integer> intDates = new ArrayList<Integer>(); 

			if(stringDates != null)
				for(String date: stringDates) {
					if(date != null)
						intDates.add(Integer.parseInt(date));
				}

			singleEdge.setCoauthorshipDates(intDates);

			result.add(singleEdge);
		}	
		return result;
	}*/

	
	/*
	 * 
	 */
	private KPaperPublished calculateKPaperPublished(DBLPUser dblpUser) throws Exception {
		double kPaperPublished = 0;

		KPaperPublished publishingConstants = new KPaperPublished();
	//	int publicationYear;
		int year = Calendar.getInstance().get(Calendar.YEAR);
		TimeScale timeScale = new TimeScale();
		//List<Publication> publicationList = dblpUser.getPublicationList();//TODO: Need to fetch publications on the basis of topic
		KCitePower kCitePower = new KCitePower();
		String author = dblpUser.getName();//This user is the author who's trust value has to be calculated
		String topic = "";//TODO:Need to pass this as a parameter
		
		Connection connection = DB.getConnection();
		PreparedStatement preparedStatement = util.SQLQueries.getPublicationInfo(connection, author,topic );
		ResultSet resultSet = preparedStatement.executeQuery();
		
		while(resultSet.next()){//Looping over all publications
			int numberOfCitations = Integer.parseInt(resultSet.getString("citationCount"));
			
			int publicationYear = Integer.parseInt(resultSet.getString("year"));
			
			/*-----------Calculation of Number of citations for article starts here ----------*/
			if(resultSet.getString("type").equals("article")){
			
						if (publicationYear >= year - timeScale.getRecentYears()) {
							publishingConstants
							.setNumOfArticleRecentNOX((publishingConstants
									.getNumOfArticleRecentNOX() + 1));
						} else if (publicationYear >= year
								- timeScale.getIntermediateYears()
								&& publicationYear < year - timeScale.getRecentYears()) {
							publishingConstants
							.setNumOfArticleIntermediateNXY(publishingConstants
									.getNumOfArticleIntermediateNXY() + 1);
						} else {
							publishingConstants
							.setNumOfArticleOldNYZ(publishingConstants
									.getNumOfArticleOldNYZ() + 1);
						}
						kCitePower.setNumberOfCitationsA(kCitePower
								.getNumberOfCitationsA() + numberOfCitations);
			
			}
			/*-----------Calculation of Number of citations for article ends here----------*/
			/*-----------Calculation of Number of citations for book starts here ----------*/
			if(resultSet.getString("type").equals("book")){
				if (publicationYear >= year - timeScale.getRecentYears()) {
					publishingConstants
					.setNumOfBooksRecentNOX((publishingConstants
							.getNumOfBooksRecentNOX() + 1));
				} else if (publicationYear >= year
						- timeScale.getIntermediateYears()
						&& publicationYear < year - timeScale.getRecentYears()) {
					publishingConstants
					.setNumOfBooksIntermediateNXY(publishingConstants
							.getNumOfBooksIntermediateNXY() + 1);
				} else {
					publishingConstants.setNumOfBooksOldNYZ(publishingConstants
							.getNumOfBooksOldNYZ() + 1);
				}
				kCitePower.setNumberOfCitationsB(kCitePower
						.getNumberOfCitationsB() + numberOfCitations);
			}
			/*-----------Calculation of Number of citations for book ends here----------*/
			/*-----------Calculation of Number of citations for www starts here----------*/
			if(resultSet.getString("type").equals("webpage")){

				if (publicationYear >= year - timeScale.getRecentYears()) {
					publishingConstants
					.setNumOfWWWRecentNOX(publishingConstants
							.getNumOfWWWRecentNOX() + 1);
				} else if (publicationYear >= year
						- timeScale.getIntermediateYears()
						&& publicationYear < year - timeScale.getRecentYears()) {
					publishingConstants
					.setNumOfWWWIntermediateNXY(publishingConstants
							.getNumOfWWWIntermediateNXY() + 1);
				} else {
					publishingConstants.setNumOfWWWOldNYZ(publishingConstants
							.getNumOfWWWOldNYZ() + 1);
				}
				kCitePower.setNumberOfCitationsW(kCitePower
						.getNumberOfCitationsW() + numberOfCitations);
			}
			/*-----------Calculation of Number of citations for www ends here----------*/
			/*-----------Calculation of Number of citations for bookchpater(Incollection) starts here----------*/

			
			if (resultSet.getString("type").equals("bookchapter")) {

				if (publicationYear >= year - timeScale.getRecentYears()) {
					publishingConstants
					.setNumOfIncollectionRecentNOX(publishingConstants
							.getNumOfIncollectionRecentNOX() + 1);
				} else if (publicationYear >= year
						- timeScale.getIntermediateYears()
						&& publicationYear < year - timeScale.getRecentYears()) {
					publishingConstants
					.setNumOfIncollectionIntermediateNXY(publishingConstants
							.getNumOfIncollectionIntermediateNXY() + 1);
				} else {
					publishingConstants
					.setNumOfIncollectionOldNYZ(publishingConstants
							.getNumOfIncollectionOldNYZ() + 1);
				}
				kCitePower.setNumberOfCitationsIC(kCitePower
						.getNumberOfCitationsIC() + numberOfCitations);
			}
			/*-----------Calculation of Number of citations for bookchpater(Incollection) ends here----------*/
			/*-----------Calculation of Number of citations for conferencepaper(Inproceedings) ends here----------*/

			if (resultSet.getString("type").equals("conferencepaper")) {

				if (publicationYear >= year - timeScale.getRecentYears()) {
					publishingConstants
					.setNumOfInProceedingRecentNOX(publishingConstants
							.getNumOfInProceedingRecentNOX() + 1);
				} else if (publicationYear >= year
						- timeScale.getIntermediateYears()
						&& publicationYear < year - timeScale.getRecentYears()) {
					publishingConstants
					.setNumOfInProceedingIntermediateNXY(publishingConstants
							.getNumOfInProceedingIntermediateNXY() + 1);
				} else {
					publishingConstants
					.setNumOfInProceedingOldNYZ(publishingConstants
							.getNumOfInProceedingOldNYZ());
				}
				kCitePower.setNumberOfCitationsIP(kCitePower
						.getNumberOfCitationsIP() + numberOfCitations);

			}
			/*-----------Calculation of Number of citations for conferencepaper(Inproceedings) ends here----------*/
			/*-----------Calculation of Number of citations for phdthesis starts here----------*/

			if (resultSet.getString("type").equals("phdthesis")) {

				if (publicationYear >= year - timeScale.getRecentYears()) {
					publishingConstants
					.setNumOfPhdThesisRecentNOX(publishingConstants
							.getNumOfPhdThesisRecentNOX() + 1);
				} else if (publicationYear >= year
						- timeScale.getIntermediateYears()
						&& publicationYear < year - timeScale.getRecentYears()) {
					publishingConstants
					.setNumOfPhdThesisIntermediateNXY(publishingConstants
							.getNumOfPhdThesisIntermediateNXY() + 1);
				} else {
					publishingConstants
					.setNumOfPhdThesisOldNYZ(publishingConstants
							.getNumOfPhdThesisOldNYZ() + 1);
				}
				kCitePower.setNumberOfCitationsP(kCitePower
						.getNumberOfCitationsP() + numberOfCitations);
			}
			/*-----------Calculation of Number of citations for phdthesis ends here----------*/

			
			
		
	
			/*if (publication.getType().equalsIgnoreCase("masterthesis")) {

				if (publicationYear >= year - timeScale.getRecentYears()) {
					publishingConstants
					.setNumOfMasterThesisRecentNOX(publishingConstants
							.getNumOfMasterThesisRecentNOX());
				} else if (publicationYear >= year
						- timeScale.getIntermediateYears()
						&& publicationYear < year - timeScale.getRecentYears()) {
					publishingConstants
					.setNumOfMasterThesisIntermediateNXY(publishingConstants
							.getNumOfMasterThesisIntermediateNXY() + 1);
				} else {
					publishingConstants
					.setNumOfMasterThesisOldNYZ(publishingConstants
							.getNumOfMasterThesisOldNYZ() + 1);
				}
				kCitePower.setNumberOfCitationsM(kCitePower
						.getNumberOfCitationsM() + numberOfCitations);
			}*/
			
		}

		kPaperPublished = publishingConstants.getAlphaArticle()
				* (timeScale.gettRecent()
						* publishingConstants.getNumOfArticleRecentNOX()
						+ timeScale.gettIntermediate()
						* publishingConstants.getNumOfArticleIntermediateNXY() + timeScale
						.gettOld()
						* publishingConstants.getNumOfArticleOldNYZ())
						+ publishingConstants.getAlphaBook()
						* (timeScale.gettRecent()
								* publishingConstants.getNumOfBooksRecentNOX()
								+ timeScale.gettIntermediate()
								* publishingConstants.getNumOfBooksIntermediateNXY() + timeScale
								.gettOld() * publishingConstants.getNumOfBooksOldNYZ())
								+ publishingConstants.getAlphaInCollection()
								* (timeScale.gettRecent()
										* publishingConstants.getNumOfIncollectionRecentNOX()
										+ timeScale.gettIntermediate()
										* publishingConstants
										.getNumOfIncollectionIntermediateNXY() + timeScale
										.gettOld()
										* publishingConstants.getNumOfIncollectionOldNYZ())
										+ publishingConstants.getAlphaInProceeding()
										* (timeScale.gettRecent()
												* publishingConstants.getNumOfInProceedingRecentNOX()
												+ timeScale.gettIntermediate()
												* publishingConstants
												.getNumOfInProceedingIntermediateNXY() + timeScale
												.gettOld()
												* publishingConstants.getNumOfInProceedingOldNYZ())
												/*+ publishingConstants.getAlphaMasterThesis()
												* (timeScale.gettRecent()
														* publishingConstants.getNumOfMasterThesisRecentNOX()
														+ timeScale.gettIntermediate()
														* publishingConstants
														.getNumOfMasterThesisIntermediateNXY() + timeScale
														.gettOld()
														* publishingConstants.getNumOfMasterThesisOldNYZ())*/
														+ publishingConstants.getAlphaPhdThesis()
														* (timeScale.gettRecent()
																* publishingConstants.getNumOfPhdThesisRecentNOX()
																+ timeScale.gettIntermediate()
																* publishingConstants
																.getNumOfPhdThesisIntermediateNXY() + timeScale
																.gettOld()
																* publishingConstants.getNumOfPhdThesisOldNYZ())
																+ publishingConstants.getAlphaProceeding()
																* (timeScale.gettRecent()
																		* publishingConstants.getNumOfProceedingRecentNOX()
																		+ timeScale.gettIntermediate()
																		* publishingConstants
																		.getNumOfProceedingIntermediateNXY() + timeScale
																		.gettOld()
																		* publishingConstants.getNumOfProceedingOldNYZ())
																		+ publishingConstants.getAlphaWWW()
																		* (timeScale.gettRecent()
																				* publishingConstants.getNumOfWWWRecentNOX()
																				+ timeScale.gettIntermediate()
																				* publishingConstants.getNumOfWWWIntermediateNXY() + timeScale
																				.gettOld() * publishingConstants.getNumOfWWWOldNYZ())
																				+ publishingConstants.getAlphaArticle()
																				* kCitePower.getNumberOfCitationsA()
																				+ publishingConstants.getAlphaBook()
																				* kCitePower.getNumberOfCitationsB()
																				+ publishingConstants.getAlphaInCollection()
																				* kCitePower.getNumberOfCitationsIC()
																				+ publishingConstants.getAlphaInProceeding()
																				* kCitePower.getNumberOfCitationsIP()
																				//+ publishingConstants.getAlphaMasterThesis()
																				//* kCitePower.getNumberOfCitationsM()
																				+ publishingConstants.getAlphaPhdThesis()
																				* kCitePower.getNumberOfCitationsPH()
																				+ publishingConstants.getAlphaProceeding()
																				* kCitePower.getNumberOfCitationsP()
																				+ publishingConstants.getAlphaWWW()
																				* kCitePower.getNumberOfCitationsW();

		publishingConstants.setFinalKPaperPublished(Math.ceil(kPaperPublished));
		return publishingConstants;
	}
	
	//Commented by Jisha as the use of the method is not clear
	/*public ArrayList<DBLPUser> getAuthorsFromContext(String context) throws Exception {
		ArrayList<DBLPUser> result = new ArrayList<DBLPUser>();

		for(String key : dblp.keySet()) {
			DBLPUser user = dblp.get(key);
			List<Publication> publications = user.getPublicationList();

			for(Publication p : publications) {
				if(StringUtils.containsIgnoreCase(p.getTitle(), context)) {
					result.add(user);
					break;
				}
			}
		}
		return result;
	}*/

	public Double getTrustValueFromName(String name) throws Exception {
		DBLPTrustProcessor dblpTrustProcessor = new DBLPTrustProcessor();
		List<String> expertNames = new ArrayList<String>();
		expertNames.add(name);
		DBLPTrustModel dblpTrustModel = dblpTrustProcessor
				.expertTrustMatrix(expertNames).get(0);
		DBLPKnowledgeFactor dblpKnowledgeFactor = dblpTrustModel
				.getDblpKnowledgeFactor();
		DBLPSocialFactor dblpSocialFactor = dblpTrustModel.getDblpSocialFactor();

		KPaperPublished kPaperPublished = dblpKnowledgeFactor
				.getkPaperPublished();
		KCoauthorship kCoauthorship = dblpSocialFactor.getkCoauthorship();
		return dblpTrustModel.getTrustValue();
	}

	public HashMap<String, Double> getIndividualTrustComponentsByName(String name) throws Exception {
		HashMap<String, Double> result = new HashMap<String, Double>();

		DBLPTrustProcessor dblpTrustProcessor = new DBLPTrustProcessor();
		List<String> expertNames = new ArrayList<String>();
		expertNames.add(name);
		DBLPTrustModel dblpTrustModel = dblpTrustProcessor
				.expertTrustMatrix(expertNames).get(0);
		DBLPKnowledgeFactor dblpKnowledgeFactor = dblpTrustModel
				.getDblpKnowledgeFactor();
		DBLPSocialFactor dblpSocialFactor = dblpTrustModel.getDblpSocialFactor();

		KPaperPublished kPaperPublished = dblpKnowledgeFactor
				.getkPaperPublished();
		KCoauthorship kCoauthorship = dblpSocialFactor.getkCoauthorship();
		// KCitePower kCitePower = kPaperPublished.getkCitePower();
		/**System.out.println("Trust Value for Charles: "
				+ dblpTrustModel.getTrustValue());
		System.out.println("Value of KPaperPublished: "
				+ kPaperPublished.getFinalKPaperPublished());
		System.out.println("Value of coauthorships: "
				+ kCoauthorship.getTimeScaledCoauthorship());
		System.out.println("Set of coauthorship edges: "
				+ kCoauthorship.getCoauthorIdToSocialFactorFromCoauthor()
						.values());*/

		result.put("KPaperPublished", kPaperPublished.getFinalKPaperPublished());
		result.put("KCoAuthorship", kCoauthorship.getTimeScaledCoauthorship());
		result.put("TotalTrust", dblpTrustModel.getTrustValue());

		return result;
	}
	
	public static Double getTrustOfAuthorBeforeYear (String name, int inputyear) throws Exception {
		//DBLPParser.getPriorPublicationsXML("Modified_dblp_example.xml", inputyear, "modified_dblp.xml");
		DBLPTrustProcessor trustProcessor = new DBLPTrustProcessor("modified_dblp.xml");
		return trustProcessor.getTrustValueFromName(name);
	}
	
	public static void main(String args[]) throws Exception {
		DBLPTrustProcessor dblpTrustProcessor = new DBLPTrustProcessor();
		List<String> expertNames = new ArrayList<String>();
		expertNames.add("Werner John");
		DBLPTrustModel dblpTrustModel = dblpTrustProcessor
				.expertTrustMatrix(expertNames).get(0);
		DBLPKnowledgeFactor dblpKnowledgeFactor = dblpTrustModel
				.getDblpKnowledgeFactor();
		DBLPSocialFactor dblpSocialFactor = dblpTrustModel.getDblpSocialFactor();

		KPaperPublished kPaperPublished = dblpKnowledgeFactor
				.getkPaperPublished();
		KCoauthorship kCoauthorship = dblpSocialFactor.getkCoauthorship();
		// KCitePower kCitePower = kPaperPublished.getkCitePower();
		System.out.println("Trust Value for Charles: "
				+ dblpTrustModel.getTrustValue());

		System.out.println("Value of KPaperPublished: "
				+ kPaperPublished.getFinalKPaperPublished());
		System.out.println("Value of coauthorships: "
				+ kCoauthorship.getTimeScaledCoauthorship());
		System.out.println("Set of coauthorship edges: "
				+ kCoauthorship.getCoauthorIdToSocialFactorFromCoauthor()
				.values());

	}
}
