package controllers;

import play.*;
import play.mvc.*;
import play.data.*;
import play.data.Form;
import play.data.DynamicForm;
import play.libs.Json;

import controllers.Publications;

import models.Publication;
import models.JournalPublication;

import views.html.*;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class JournalPublications extends Controller {
  final static Form<JournalPublication> jpublicationForm = Form.form(JournalPublication.class);

  public static Result display() {
    return ok(journalPublications.render(JournalPublication.getAll()));
  }

  public static Result addPage() {
    return ok(addJournal.render(jpublicationForm));
  }

  public static Result add() {
    Form form = jpublicationForm.bindFromRequest();

    ObjectNode on = Json.newObject();

    try {
      Publications.formToJson(form, on);

      on.put("publicationChannel", Publication.Channel.Journal.toString()); 
      Publications.formField(form, on, "journalName");
      Publications.formField(form, on, "volume");
      Publications.formField(form, on, "column");
      Publications.formField(form, on, "pages");

      JsonNode response = JournalPublication.add(on);
    } 
    catch (Exception e) {
      e.printStackTrace();
    }

    return redirect("/add/journalPublication");
  }

  public static Result updatePage() {
    DynamicForm df = DynamicForm.form().bindFromRequest();
    String id = df.field("idHolder").value();

    JournalPublication jp = JournalPublication.get(id);
    if (jp != null) {
      Map<String, String> map = new TreeMap<String, String>();
      Publications.bindFields(map, jp);

      map.put("journalName", jp.getJournalName());
      map.put("volume", jp.getVolume());
      map.put("column", jp.getColumn());
      map.put("pages", jp.getPages());
      return ok(updateJournal.render(jp, jpublicationForm.bind(map)));
    }

    return notFound("Unable to update publication");
  }

  public static Result update() {
    Form form = jpublicationForm.bindFromRequest();
    String id = form.field("idHolder").value();

    ObjectNode on = Json.newObject();

    try {
      on.put("paperId", id);
      Publications.formToJson(form, on);

      on.put("publicationChannel", Publication.Channel.Journal.toString()); 
      Publications.formField(form, on, "journalName");
      Publications.formField(form, on, "volume");
      Publications.formField(form, on, "column");
      Publications.formField(form, on, "pages");

      JsonNode response = JournalPublication.update(on);
    } 
    catch (Exception e) {
      e.printStackTrace();
    }

    return redirect("/journalPublications");
  }
}

