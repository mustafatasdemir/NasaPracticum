package controllers;

import play.*;
import play.mvc.*;
import play.data.*;
import play.data.Form;
import play.data.DynamicForm;

import models.*;

import views.html.*;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.util.Map;

public class Publications extends Controller {
  final static Form<Publication> publicationForm = Form.form(Publication.class);

  public static void formField(Form form, ObjectNode on, String field) {
    String formField = form.field(field).value();
    if (formField != null && !formField.isEmpty()) {
      on.put(field, formField);
    }
  }

  public static void formFieldArray(Form form, ObjectNode on, String field) {
    String formField = form.field(field).value();

    if (formField != null && !formField.isEmpty()) {
      String[] split = formField.trim().split(",");
      ArrayNode an = on.arrayNode();

      for (int i = 0; i < split.length; i++) {
        an.add(split[i].trim());  
      }

      on.put(field, an);
    }
  }

  public static void formToJson(Form<Publication> form, ObjectNode on) {
    formField(form, on, "paperTitle");
    formFieldArray(form, on, "paperAuthors");
    formFieldArray(form, on, "keywords");
    formFieldArray(form, on, "systemTags");
    formFieldArray(form, on, "crowdTags");
    formField(form, on, "year");
  }

  public static void bindFields(Map<String, String> map, Publication p) {
    map.put("paperTitle", p.getTitle());
    map.put("paperAuthors", p.formatStringArray(p.getAuthors()));
    map.put("keywords", p.formatStringArray(p.getKeywords()));
    map.put("systemTags", p.formatStringArray(p.getSystemTags()));
    map.put("crowdTags", p.formatStringArray(p.getCrowdTags()));
    map.put("year", "" + p.getYear()); 
  }

  public static Result display() {
    return ok(publications.render(Publication.getAllPublications()));
  }

  public static Result delete() {
    DynamicForm df = DynamicForm.form().bindFromRequest();
    String id = df.field("idHolder").value();

    Publication.delete(id);

    return redirect("/publications");
  } 
}

