package controllers;

import play.*;
import play.mvc.*;
import play.data.*;
import play.data.Form;
import play.data.DynamicForm;
import play.libs.Json;

import controllers.Publications;

import models.Publication;
import models.ConferencePublication;

import views.html.*;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ConferencePublications extends Controller {
  final static Form<ConferencePublication> cpublicationForm = Form.form(ConferencePublication.class);

  public static Result display() {
    return ok(conferencePublications.render(ConferencePublication.getAll()));
  }

  public static Result addPage() {
    return ok(addConference.render(cpublicationForm));
  }

  public static Result add() {
    Form form = cpublicationForm.bindFromRequest();

    ObjectNode on = Json.newObject();

    try {
      Publications.formToJson(form, on);

      on.put("publicationChannel", Publication.Channel.Conference.toString()); 
      Publications.formField(form, on, "conferenceName");
      Publications.formField(form, on, "confereneLocation");
      Publications.formField(form, on, "time");
      Publications.formField(form, on, "pages");

      JsonNode response = ConferencePublication.add(on);
    } 
    catch (Exception e) {
      e.printStackTrace();
    }
  
    return redirect("/add/conferencePublication");
  }

  public static Result updatePage() {
    DynamicForm df = DynamicForm.form().bindFromRequest();
    String id = df.field("idHolder").value();

    ConferencePublication cp = ConferencePublication.get(id);
    if (cp != null) {
      Map<String, String> map = new TreeMap<String, String>();
      Publications.bindFields(map, cp);

      map.put("conferenceName", cp.getConferenceName());
      map.put("conferenceLocation", cp.getConferenceLocation());
      map.put("time", cp.getTime());
      map.put("pages", cp.getPages());
      return ok(updateConference.render(cp, cpublicationForm.bind(map)));
    }

    return notFound("Unable to update publication");
  }

  public static Result update() {
    Form form = cpublicationForm.bindFromRequest();
    String id = form.field("idHolder").value();

    ObjectNode on = Json.newObject();

    try {
      on.put("paperId", id);
      Publications.formToJson(form, on);

      on.put("publicationChannel", Publication.Channel.Conference.toString());
      Publications.formField(form, on, "conferenceName");
      Publications.formField(form, on, "conferenceLocation");
      Publications.formField(form, on, "time");
      Publications.formField(form, on, "pages");

      JsonNode response = ConferencePublication.update(on);
    }
    catch (Exception e) {
      e.printStackTrace();
    }

    return redirect("/conferencePublications");
  }
}

