package models;

import models.Publication;

import util.*;

import com.fasterxml.jackson.databind.*;
import com.google.gson.Gson;

import java.util.*;

public class BookChapterPublication extends Publication {

  private String bookName;
  private int chapter;
  private String[] editorNames;
  private String time;

  public String getBookName() {
    return this.bookName;
  }

  public int getChapter() {
    return this.chapter;
  }

  public String[] getEditorNames() {
    return this.editorNames;
  }

  public String getTime() {
    return this.time;
  }

  private static final String GET_BOOKCHAPTER_PUBLICATION = util.Constants.HOSTNAME + util.Constants.GET_BOOKCHAPTER_PUBLICATION_ROUTE;
  private static final String GET_ALL_BOOKCHAPTER_PUBLICATIONS = util.Constants.HOSTNAME + util.Constants.ALL_BOOKCHAPTER_PUBLICATIONS_ROUTE; 
  private static final String ADD_BOOKCHAPTER_PUBLICATION = util.Constants.HOSTNAME + util.Constants.ADD_BOOKCHAPTER_PUBLICATION_ROUTE; 
  private static final String UPDATE_BOOKCHAPTER_PUBLICATION = util.Constants.HOSTNAME + util.Constants.UPDATE_BOOKCHAPTER_PUBLICATION_ROUTE; 

  public static BookChapterPublication get(String id) {
    final JsonNode publicationNode = APICall.callAPI(GET_BOOKCHAPTER_PUBLICATION + "/" + id);

    if (publicationNode == null || publicationNode.has("error")) {
      return null;
    }

    BookChapterPublication bcpublication = new Gson().fromJson(publicationNode.toString(), BookChapterPublication.class);

    return bcpublication;
  }

  public static List<BookChapterPublication> getAll() {
    List<BookChapterPublication> publicationList = new ArrayList<BookChapterPublication>();

    final JsonNode publicationsNode = APICall.callAPI(GET_ALL_BOOKCHAPTER_PUBLICATIONS);

    if (publicationsNode == null || publicationsNode.has("error") || !publicationsNode.isArray()) {
      return publicationList;
    }

    BookChapterPublication[] bcpublicationArray = new Gson().fromJson(publicationsNode.toString(), BookChapterPublication[].class);

    return Arrays.asList(bcpublicationArray);
  }

  public static JsonNode add(JsonNode jsonData) {
    return APICall.postAPI(ADD_BOOKCHAPTER_PUBLICATION, jsonData);
  }

  public static JsonNode update(JsonNode jsonData) {
    return APICall.postAPI(UPDATE_BOOKCHAPTER_PUBLICATION, jsonData);
  }
}
