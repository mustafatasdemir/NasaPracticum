package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

import models.Publication;
import models.BookPublication;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.gson.Gson;

import java.util.*;


public class BookPublications extends Controller {

  public static Result get(String id) {
    if (id == null){
      return badRequest("Invalid request to get publication");
    }

    response().setHeader("Access-Control-Allow-Origin", "*");

    BookPublication bpublication = BookPublication.get(id);

    if (bpublication == null) {
      return notFound("No publication found");
    }

    String ret = new Gson().toJson(bpublication);

    return ok(ret);
  }

  public static Result getAll() {
    response().setHeader("Access-Control-Allow-Origin", "*");

    List<BookPublication> bpublications = BookPublication.getAll();
    
    if (bpublications.isEmpty()) {
      return notFound("No publications found");
    }

    String ret = new Gson().toJson(bpublications);

    return ok(ret);
  }

  public static Result add() {
    JsonNode jsonRequest = request().body().asJson();
    if (jsonRequest == null) {
      return badRequest("Invalid request to add publication");
    }

    BookPublication pubReq = new Gson().fromJson(jsonRequest.toString(), BookPublication.class);
    BookPublication result = BookPublication.add(pubReq.getTitle(), pubReq.getAuthors(), pubReq.getKeywords(),
                                                 pubReq.getSystemTags(), pubReq.getCrowdTags(), pubReq.getYear(),
                                                 pubReq.getBookName(), pubReq.getPublisherName(), pubReq.getPublisherLocation(), pubReq.getTime(), pubReq.getPages());

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

    BookPublication pubReq = new Gson().fromJson(jsonRequest.toString(), BookPublication.class);
    BookPublication result = BookPublication.update(pubReq);

    if (result == null) {
      return badRequest("Publication could not be updated");
    }

    return ok("Updated publication");
  }
}
