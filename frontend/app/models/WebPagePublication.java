package models;

import models.Publication;

import util.*;

import com.fasterxml.jackson.databind.*;
import com.google.gson.Gson;

import java.util.*;

public class WebPagePublication extends Publication {

  private String URL;
  private Date date;

  public String getURL() {
    return this.URL;
  }

  public Date getDate() {
    return this.date;
  }

  private static final String GET_WEBPAGE_PUBLICATION = util.Constants.HOSTNAME + util.Constants.GET_WEBPAGE_PUBLICATION_ROUTE;
  private static final String GET_ALL_WEBPAGE_PUBLICATIONS = util.Constants.HOSTNAME + util.Constants.ALL_WEBPAGE_PUBLICATIONS_ROUTE; 
  private static final String ADD_WEBPAGE_PUBLICATION = util.Constants.HOSTNAME + util.Constants.ADD_WEBPAGE_PUBLICATION_ROUTE; 
  private static final String UPDATE_WEBPAGE_PUBLICATION = util.Constants.HOSTNAME + util.Constants.UPDATE_WEBPAGE_PUBLICATION_ROUTE; 

  public static WebPagePublication get(String id) {
    final JsonNode publicationNode = APICall.callAPI(GET_WEBPAGE_PUBLICATION + "/" + id);

    if (publicationNode == null || publicationNode.has("error")) {
      return null;
    }

    WebPagePublication wpublication = new Gson().fromJson(publicationNode.toString(), WebPagePublication.class);

    return wpublication;
  }

  public static List<WebPagePublication> getAll() {
    List<WebPagePublication> publicationList = new ArrayList<WebPagePublication>();

    final JsonNode publicationsNode = APICall.callAPI(GET_ALL_WEBPAGE_PUBLICATIONS);

    if (publicationsNode == null || publicationsNode.has("error") || !publicationsNode.isArray()) {
      return publicationList;
    }

    WebPagePublication[] wpublicationArray = new Gson().fromJson(publicationsNode.toString(), WebPagePublication[].class);

    return Arrays.asList(wpublicationArray);
  }

  public static JsonNode add(JsonNode jsonData) {
    return APICall.postAPI(ADD_WEBPAGE_PUBLICATION, jsonData);
  }

  public static JsonNode update(JsonNode jsonData) {
    return APICall.postAPI(UPDATE_WEBPAGE_PUBLICATION, jsonData);
  }
}
