package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

import models.Publication;
import models.WebPagePublication;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.*;


public class WebPagePublications extends Controller {

  public static Result get(String id) {
    if (id == null){
      return badRequest("Invalid request to get publication");
    }

    response().setHeader("Access-Control-Allow-Origin", "*");

    WebPagePublication wpublication = WebPagePublication.get(id);

    if (wpublication == null) {
      return notFound("No publication found");
    }

    String ret = new Gson().toJson(wpublication);

    return ok(ret);
  }

  public static Result getAll() {
    response().setHeader("Access-Control-Allow-Origin", "*");

    List<WebPagePublication> wpublications = WebPagePublication.getAll();
    
    if (wpublications.isEmpty()) {
      return notFound("No publications found");
    }

    String ret = new Gson().toJson(wpublications);

    return ok(ret);
  }

  public static Result add() {
    JsonNode jsonRequest = request().body().asJson();
    if (jsonRequest == null) {
      return badRequest("Invalid request to add publication");
    }

    Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();

    WebPagePublication pubReq = gson.fromJson(jsonRequest.toString(), WebPagePublication.class);
    WebPagePublication result = WebPagePublication.add(pubReq.getTitle(), pubReq.getAuthors(), pubReq.getKeywords(),
                                                       pubReq.getSystemTags(), pubReq.getCrowdTags(), pubReq.getYear(),
                                                       pubReq.getURL(), pubReq.getDate());

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

    Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
    
    WebPagePublication pubReq = gson.fromJson(jsonRequest.toString(), WebPagePublication.class);
    WebPagePublication result = WebPagePublication.update(pubReq);

    if (result == null) {
      return badRequest("Publication could not be updated");
    }

    return ok("Updated publication");
  }
}
