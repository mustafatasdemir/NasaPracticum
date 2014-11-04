package controllers;

import play.*;
import play.mvc.*;
import play.data.*;
import play.data.Form;
import play.data.DynamicForm;
import play.libs.Json;

import controllers.Publications;

import models.Publication;
import models.BookPublication;

import views.html.*;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class BookPublications extends Controller {
  final static Form<BookPublication> bpublicationForm = Form.form(BookPublication.class);

  public static Result display() {
    return ok(bookPublications.render(BookPublication.getAll()));
  }

  public static Result addPage() {
    return ok(addBook.render(bpublicationForm));
  }

  public static Result add() {
    Form form = bpublicationForm.bindFromRequest();

    ObjectNode on = Json.newObject();

    try {
      Publications.formToJson(form, on);

      on.put("publicationChannel", Publication.Channel.Book.toString()); 
      Publications.formField(form, on, "bookName");
      Publications.formField(form, on, "publisherName");
      Publications.formField(form, on, "publisherLocation");
      Publications.formField(form, on, "time");
      Publications.formField(form, on, "pages");

      JsonNode response = BookPublication.add(on);
    } 
    catch (Exception e) {
      e.printStackTrace();
    }
  
    return redirect("/add/bookPublication");
  }
  public static Result updatePage() {
    DynamicForm df = DynamicForm.form().bindFromRequest();
    String id = df.field("idHolder").value();

    BookPublication bp = BookPublication.get(id);
    if (bp != null) {
      Map<String, String> map = new TreeMap<String, String>();
      Publications.bindFields(map, bp);

      map.put("bookName", bp.getBookName());
      map.put("publisherName", bp.getPublisherName());
      map.put("publisherLocation", bp.getPublisherLocation());
      map.put("time", bp.getTime());
      map.put("pages", bp.getPages());
      return ok(updateBook.render(bp, bpublicationForm.bind(map)));
    }

    return notFound("Unable to update publication");
  }

  public static Result update() {
    Form form = bpublicationForm.bindFromRequest();
    String id = form.field("idHolder").value();

    ObjectNode on = Json.newObject();

    try {
      on.put("paperId", id);
      Publications.formToJson(form, on);

      on.put("publicationChannel", Publication.Channel.Book.toString());
      Publications.formField(form, on, "bookName");
      Publications.formField(form, on, "publisherName");
      Publications.formField(form, on, "publisherLocation");
      Publications.formField(form, on, "time");
      Publications.formField(form, on, "pages");

      JsonNode response = BookPublication.update(on);
    }
    catch (Exception e) {
      e.printStackTrace();
    }

    return redirect("/bookPublications");
  }
}

