package models;

import util.*;

import com.fasterxml.jackson.databind.*;
import com.google.gson.Gson;

import java.util.*;

public class Publication {

  public enum Channel {
    Book, BookChapter, Conference, Journal, WebPage
  }

  private String paperId;
  private String paperTitle;
  private String[] paperAuthors;
  private String[] keywords;
  private String[] systemTags;
  private String[] crowdTags;
  private Channel publicationChannel;
  private int year;

  public String getId() {
    return this.paperId;
  }

  public String getTitle() {
    return this.paperTitle;
  }

  public String[] getAuthors() {
    return this.paperAuthors;
  }

  public String[] getKeywords() {
    return this.keywords;
  }

  public String[] getSystemTags() {
    return this.systemTags;
  }

  public String[] getCrowdTags() {
    return this.crowdTags;
  }

  public Channel getChannel() {
    return this.publicationChannel;
  }

  public String getChannelString() { 
    String ret = "";

    if (this.publicationChannel == Channel.Journal) {
      ret = "Journal";
    }
    else if (this.publicationChannel == Channel.Conference) {
      ret = "Conference";
    }
    else if (this.publicationChannel == Channel.WebPage) {
      ret = "Web Page";
    }
    else if (this.publicationChannel == Channel.Book) {
      ret = "Book";
    }
    else if (this.publicationChannel == Channel.BookChapter) {
      ret = "Book Chapter";
    }

    return ret;
  }

  public int getYear() {
    return this.year;
  }

  public String formatStringArray(String[] arr) {
	  if(arr!=null)
	  {
		  String listString = Arrays.asList(arr).toString();
		  return listString.substring(1, listString.length()-1);
	  }
	  else return "";    
  }

  private static final String GET_PUBLICATION = util.Constants.HOSTNAME + util.Constants.GET_PUBLICATION_ROUTE;
  private static final String GET_ALL_PUBLICATIONS = util.Constants.HOSTNAME + util.Constants.ALL_PUBLICATIONS_ROUTE; 
  private static final String DELETE_PUBLICATION = util.Constants.HOSTNAME + util.Constants.DELETE_PUBLICATION_ROUTE;

  public static Publication get(String id) {
    final JsonNode publicationNode = APICall.callAPI(GET_PUBLICATION + "/" + id);

    if (publicationNode == null || publicationNode.has("error")) {
      return null;
    }

    Publication publication = new Gson().fromJson(publicationNode.toString(), Publication.class);

    return publication;
  }

  public static List<Publication> getAllPublications() {
    List<Publication> publicationList = new ArrayList<Publication>();

    final JsonNode publicationsNode = APICall.callAPI(GET_ALL_PUBLICATIONS);

    if (publicationsNode == null || publicationsNode.has("error") || !publicationsNode.isArray()) {
      return publicationList;
    }

    Publication[] publicationArray = new Gson().fromJson(publicationsNode.toString(), Publication[].class);

    return Arrays.asList(publicationArray);
  }

  public static JsonNode delete(String id) {
    return APICall.deleteAPI(DELETE_PUBLICATION + "/" + id);
  }
}
