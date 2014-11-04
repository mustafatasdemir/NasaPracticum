package models;

import models.Publication;

import util.*;

import com.fasterxml.jackson.databind.*;
import com.google.gson.Gson;

import java.util.*;

public class BookPublication extends Publication {

  private String bookName;
  private String publisherName;
  private String publisherLocation;
  private String time;
  private String pages;

  public String getBookName() {
    return this.bookName;
  }

  public String getPublisherName() {
    return this.publisherName;
  }

  public String getPublisherLocation() {
    return this.publisherLocation;
  }

  public String getTime() {
    return this.time;
  }

  public String getPages() {
    return this.pages;
  }

  private static final String GET_BOOK_PUBLICATION = util.Constants.HOSTNAME + util.Constants.GET_BOOK_PUBLICATION_ROUTE;
  private static final String GET_ALL_BOOK_PUBLICATIONS = util.Constants.HOSTNAME + util.Constants.ALL_BOOK_PUBLICATIONS_ROUTE; 
  private static final String ADD_BOOK_PUBLICATION = util.Constants.HOSTNAME + util.Constants.ADD_BOOK_PUBLICATION_ROUTE; 
  private static final String UPDATE_BOOK_PUBLICATION = util.Constants.HOSTNAME + util.Constants.UPDATE_BOOK_PUBLICATION_ROUTE; 

  public static BookPublication get(String id) {
    final JsonNode publicationNode = APICall.callAPI(GET_BOOK_PUBLICATION + "/" + id);

    if (publicationNode == null || publicationNode.has("error")) {
      return null;
    }

    BookPublication bpublication = new Gson().fromJson(publicationNode.toString(), BookPublication.class);

    return bpublication;
  }

  public static List<BookPublication> getAll() {
    List<BookPublication> publicationList = new ArrayList<BookPublication>();

    final JsonNode publicationsNode = APICall.callAPI(GET_ALL_BOOK_PUBLICATIONS);

    if (publicationsNode == null || publicationsNode.has("error") || !publicationsNode.isArray()) {
      return publicationList;
    }

    BookPublication[] bpublicationArray = new Gson().fromJson(publicationsNode.toString(), BookPublication[].class);

    return Arrays.asList(bpublicationArray);
  }

  public static JsonNode add(JsonNode jsonData) {
    return APICall.postAPI(ADD_BOOK_PUBLICATION, jsonData);
  }

  public static JsonNode update(JsonNode jsonData) {
    return APICall.postAPI(UPDATE_BOOK_PUBLICATION, jsonData);
  }
}
