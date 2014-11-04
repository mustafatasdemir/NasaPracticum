package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

import models.Publication;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.gson.Gson;

import java.util.*;


public class Publications extends Controller {

  public static Result test() {

    return ok("hi");
  }

  public static Result get(String id) {
    if (id == null){
      return badRequest("Invalid request to get publication");
    }

    response().setHeader("Access-Control-Allow-Origin", "*");

    Publication publication = Publication.getPublication(id);

    if (publication == null) {
      return notFound("No publication found");
    }

    String ret = new Gson().toJson(publication);

    return ok(ret);
  }

  public static Result getAll() {
    response().setHeader("Access-Control-Allow-Origin", "*");

    List<Publication> publications = Publication.getAllPublications();
    
    if (publications.isEmpty()) {
      return notFound("No publications found");
    }

    String ret = new Gson().toJson(publications);

    return ok(ret);
  }

  public static Result delete(String id) {
    if (id == null) {
      return badRequest("Invalid request to delete publication");
    }

    Publication result = Publication.deletePublication(id);

    if (result == null) {
      return badRequest("Publication could not be deleted");
    }

    return ok("Publication deleted");
  }
}
