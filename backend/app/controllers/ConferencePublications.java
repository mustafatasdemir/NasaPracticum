package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

import models.Publication;
import models.ConferencePublication;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.gson.Gson;

import java.util.*;


public class ConferencePublications extends Controller {

  public static Result get(String id) {
    if (id == null){
      return badRequest("Invalid request to get publication");
    }

    response().setHeader("Access-Control-Allow-Origin", "*");

    ConferencePublication cpublication = ConferencePublication.get(id);

    if (cpublication == null) {
      return notFound("No publication found");
    }

    String ret = new Gson().toJson(cpublication);

    return ok(ret);
  }

  public static Result getAll() {
    response().setHeader("Access-Control-Allow-Origin", "*");

    List<ConferencePublication> cpublications = ConferencePublication.getAll();
    
    if (cpublications.isEmpty()) {
      return notFound("No publications found");
    }

    String ret = new Gson().toJson(cpublications);

    return ok(ret);
  }

  public static Result add() {
    JsonNode jsonRequest = request().body().asJson();
    if (jsonRequest == null) {
      return badRequest("Invalid request to add publication");
    }

    ConferencePublication pubReq = new Gson().fromJson(jsonRequest.toString(), ConferencePublication.class);
    ConferencePublication result = ConferencePublication.add(pubReq.getTitle(), pubReq.getAuthors(), pubReq.getKeywords(),
                                                             pubReq.getSystemTags(), pubReq.getCrowdTags(), pubReq.getYear(),
                                                             pubReq.getConferenceName(), pubReq.getConferenceLocation(), pubReq.getTime(), pubReq.getPages());

    if (result == null) {
      return badRequest("Publication could not be added");
    }
    
    return created("Added new publication");
  }

  public static Result update() {
    JsonNode jsonRequest = request().body().asJson();
    if (jsonRequest == null) {
      return badRequest("Invalid request to update publication");
    }

    ConferencePublication pubReq = new Gson().fromJson(jsonRequest.toString(), ConferencePublication.class);
    ConferencePublication result = ConferencePublication.update(pubReq);

    if (result == null) {
      return badRequest("Publication could not be updated");
    }

    return ok("Updated publication");
  }
}
