package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

import models.Publication;
import models.JournalPublication;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.gson.Gson;

import java.util.*;


public class JournalPublications extends Controller {

  public static Result get(String id) {
    if (id == null){
      return badRequest("Invalid request to get publication");
    }

    response().setHeader("Access-Control-Allow-Origin", "*");

    JournalPublication jpublication = JournalPublication.get(id);

    if (jpublication == null) {
      return notFound("No publication found");
    }

    String ret = new Gson().toJson(jpublication);

    return ok(ret);
  }

  public static Result getAll() {
    response().setHeader("Access-Control-Allow-Origin", "*");

    List<JournalPublication> jpublications = JournalPublication.getAll();
    
    if (jpublications.isEmpty()) {
      return notFound("No publications found");
    }

    String ret = new Gson().toJson(jpublications);

    return ok(ret);
  }

  public static Result add() {
    JsonNode jsonRequest = request().body().asJson();
    if (jsonRequest == null) {
      return badRequest("Invalid request to add publication");
    }

    JournalPublication pubReq = new Gson().fromJson(jsonRequest.toString(), JournalPublication.class);
    JournalPublication result = JournalPublication.add(pubReq.getTitle(), pubReq.getAuthors(), pubReq.getKeywords(),
                                                       pubReq.getSystemTags(), pubReq.getCrowdTags(), pubReq.getYear(),
                                                       pubReq.getJournalName(), pubReq.getVolume(), pubReq.getColumn(), pubReq.getPages());

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

    JournalPublication pubReq = new Gson().fromJson(jsonRequest.toString(), JournalPublication.class);
    JournalPublication result = JournalPublication.update(pubReq);

    if (result == null) {
      return badRequest("Publication could not be updated");
    }

    return ok("Updated publication");
  }
}
