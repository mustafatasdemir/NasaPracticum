package controllers;

import play.*;
import play.mvc.*;
import play.data.*;
import play.data.Form;
import play.data.DynamicForm;
import play.libs.Json;

import controllers.Publications;

import models.Publication;
import models.WebPagePublication;

import views.html.*;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.text.SimpleDateFormat;


public class WebPagePublications extends Controller {
  final static Form<WebPagePublication> wpublicationForm = Form.form(WebPagePublication.class);
  final static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

  public static Result display() {
    return ok(webPagePublications.render(WebPagePublication.getAll()));
  }

  public static Result addPage() {
    return ok(addWebPage.render(wpublicationForm));
  }

  public static Result add() {
    Form form = wpublicationForm.bindFromRequest();

    ObjectNode on = Json.newObject();

    try {
      Publications.formToJson(form, on);

      on.put("publicationChannel", Publication.Channel.WebPage.toString()); 
      Publications.formField(form, on, "URL");
      Publications.formField(form, on, "date");

      JsonNode response = WebPagePublication.add(on);
    } 
    catch (Exception e) {
      e.printStackTrace();
    }
  
    return redirect("/add/webPagePublication");
  }

  public static Result updatePage() {
    DynamicForm df = DynamicForm.form().bindFromRequest();
    String id = df.field("idHolder").value();

    WebPagePublication wp = WebPagePublication.get(id);
    if (wp != null) {
      Map<String, String> map = new TreeMap<String, String>();
      Publications.bindFields(map, wp);

      map.put("URL", wp.getURL());
      map.put("date", dateFormat.format(wp.getDate()));
      return ok(updateWebPage.render(wp, wpublicationForm.bind(map)));
    }

    return notFound("Unable to update publication");
  }

  public static Result update() {
    Form form = wpublicationForm.bindFromRequest();
    String id = form.field("idHolder").value();

    ObjectNode on = Json.newObject();

    try {
      on.put("paperId", id);
      Publications.formToJson(form, on);

      on.put("publicationChannel", Publication.Channel.WebPage.toString());
      Publications.formField(form, on, "URL");
      Publications.formField(form, on, "date");

      JsonNode response = WebPagePublication.update(on);
    }
    catch (Exception e) {
      e.printStackTrace();
    }

    return redirect("/webPagePublications");
  }
}

