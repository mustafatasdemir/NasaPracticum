package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

import models.Publication;
import models.BookChapterPublication;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.gson.Gson;

import java.util.*;


public class BookChapterPublications extends Controller {

  public static Result get(String id) {
    if (id == null){
      return badRequest("Invalid request to get publication");
    }

    response().setHeader("Access-Control-Allow-Origin", "*");

    BookChapterPublication bcpublication = BookChapterPublication.get(id);

    if (bcpublication == null) {
      return notFound("No publication found");
    }

    String ret = new Gson().toJson(bcpublication);

    return ok(ret);
  }

  public static Result getAll() {
    response().setHeader("Access-Control-Allow-Origin", "*");

    List<BookChapterPublication> bcpublications = BookChapterPublication.getAll();
    
    if (bcpublications.isEmpty()) {
      return notFound("No publications found");
    }

    String ret = new Gson().toJson(bcpublications);

    return ok(ret);
  }

  public static Result add() {
    JsonNode jsonRequest = request().body().asJson();
    if (jsonRequest == null) {
      return badRequest("Invalid request to add publication");
    }

    BookChapterPublication pubReq = new Gson().fromJson(jsonRequest.toString(), BookChapterPublication.class);
    BookChapterPublication result = BookChapterPublication.add(pubReq.getTitle(), pubReq.getAuthors(), pubReq.getKeywords(),
                                                               pubReq.getSystemTags(), pubReq.getCrowdTags(), pubReq.getYear(),
                                                               pubReq.getBookName(), pubReq.getChapter(), pubReq.getEditorNames(), pubReq.getTime());

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

    BookChapterPublication pubReq = new Gson().fromJson(jsonRequest.toString(), BookChapterPublication.class);
    BookChapterPublication result = BookChapterPublication.update(pubReq);

    if (result == null) {
      return badRequest("Publication could not be updated");
    }

    return ok("Updated publication");
  }
}
