package models;

import models.Publication;

import util.*;

import com.fasterxml.jackson.databind.*;
import com.google.gson.Gson;

import java.util.*;

public class ConferencePublication extends Publication {

  private String conferenceName;
  private String conferenceLocation;
  private String time;
  private String pages;

  public String getConferenceName() {
    return this.conferenceName;
  }

  public String getConferenceLocation() {
    return this.conferenceLocation;
  }

  public String getTime() {
    return this.time;
  }

  public String getPages() {
    return this.pages;
  }

  private static final String GET_CONFERENCE_PUBLICATION = util.Constants.HOSTNAME + util.Constants.GET_CONFERENCE_PUBLICATION_ROUTE;
  private static final String GET_ALL_CONFERENCE_PUBLICATIONS = util.Constants.HOSTNAME + util.Constants.ALL_CONFERENCE_PUBLICATIONS_ROUTE; 
  private static final String ADD_CONFERENCE_PUBLICATION = util.Constants.HOSTNAME + util.Constants.ADD_CONFERENCE_PUBLICATION_ROUTE; 
  private static final String UPDATE_CONFERENCE_PUBLICATION = util.Constants.HOSTNAME + util.Constants.UPDATE_CONFERENCE_PUBLICATION_ROUTE; 

  public static ConferencePublication get(String id) {
    final JsonNode publicationNode = APICall.callAPI(GET_CONFERENCE_PUBLICATION + "/" + id);
    
    if (publicationNode == null || publicationNode.has("error")) {
      return null;
    }

    ConferencePublication cpublication = new Gson().fromJson(publicationNode.toString(), ConferencePublication.class);

    return cpublication;
  }

  public static List<ConferencePublication> getAll() {
    List<ConferencePublication> publicationList = new ArrayList<ConferencePublication>();

    final JsonNode publicationsNode = APICall.callAPI(GET_ALL_CONFERENCE_PUBLICATIONS);

    if (publicationsNode == null || publicationsNode.has("error") || !publicationsNode.isArray()) {
      return publicationList;
    }

    ConferencePublication[] cpublicationArray = new Gson().fromJson(publicationsNode.toString(), ConferencePublication[].class);

    return Arrays.asList(cpublicationArray);
  }

  public static JsonNode add(JsonNode jsonData) {
    return APICall.postAPI(ADD_CONFERENCE_PUBLICATION, jsonData);
  }

  public static JsonNode update(JsonNode jsonData) {
    return APICall.postAPI(UPDATE_CONFERENCE_PUBLICATION, jsonData);
  }
}
