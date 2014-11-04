package models;

import models.Publication;

import util.*;

import com.fasterxml.jackson.databind.*;
import com.google.gson.Gson;

import java.util.*;

public class JournalPublication extends Publication {

  private String journalName;
  private String volume;
  private String column;
  private String pages;

  public String getJournalName() {
    return this.journalName;
  }

  public String getVolume() {
    return this.volume;
  }

  public String getColumn() {
    return this.column;
  }

  public String getPages() {
    return this.pages;
  }

  private static final String GET_JOURNAL_PUBLICATION = util.Constants.HOSTNAME + util.Constants.GET_JOURNAL_PUBLICATION_ROUTE;
  private static final String GET_ALL_JOURNAL_PUBLICATIONS = util.Constants.HOSTNAME + util.Constants.ALL_JOURNAL_PUBLICATIONS_ROUTE; 
  private static final String ADD_JOURNAL_PUBLICATION = util.Constants.HOSTNAME + util.Constants.ADD_JOURNAL_PUBLICATION_ROUTE; 
  private static final String UPDATE_JOURNAL_PUBLICATION = util.Constants.HOSTNAME + util.Constants.UPDATE_JOURNAL_PUBLICATION_ROUTE; 

  public static JournalPublication get(String id) {
    final JsonNode publicationNode = APICall.callAPI(GET_JOURNAL_PUBLICATION + "/" + id);

    if (publicationNode == null || publicationNode.has("error")) {
      return null;
    }

    JournalPublication jpublication = new Gson().fromJson(publicationNode.toString(), JournalPublication.class);

    return jpublication;
  }

  public static List<JournalPublication> getAll() {
    List<JournalPublication> publicationList = new ArrayList<JournalPublication>();

    final JsonNode publicationsNode = APICall.callAPI(GET_ALL_JOURNAL_PUBLICATIONS);

    if (publicationsNode == null || publicationsNode.has("error") || !publicationsNode.isArray()) {
      return publicationList;
    }

    JournalPublication[] jpublicationArray = new Gson().fromJson(publicationsNode.toString(), JournalPublication[].class);

    return Arrays.asList(jpublicationArray);
  }

  public static JsonNode add(JsonNode jsonData) {
    return APICall.postAPI(ADD_JOURNAL_PUBLICATION, jsonData);
  }

  public static JsonNode update(JsonNode jsonData) {
    return APICall.postAPI(UPDATE_JOURNAL_PUBLICATION, jsonData);
  }
}
