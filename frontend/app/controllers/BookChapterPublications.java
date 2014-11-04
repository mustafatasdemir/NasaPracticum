package controllers;

import play.*;
import play.mvc.*;
import play.data.*;
import play.data.Form;
import play.data.DynamicForm;
import play.libs.Json;

import controllers.Publications;

import models.Publication;
import models.BookChapterPublication;

import views.html.*;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class BookChapterPublications extends Controller {
  final static Form<BookChapterPublication> bcpublicationForm = Form.form(BookChapterPublication.class);

  public static Result display() {
    return ok(bookChapterPublications.render(BookChapterPublication.getAll()));
  }

  public static Result addPage() {
    return ok(addBookChapter.render(bcpublicationForm));
  }

  public static Result add() {
    Form form = bcpublicationForm.bindFromRequest();

    ObjectNode on = Json.newObject();

    try {
      Publications.formToJson(form, on);

      on.put("publicationChannel", Publication.Channel.BookChapter.toString()); 
      Publications.formField(form, on, "bookName");
      Publications.formField(form, on, "chapter");
      Publications.formFieldArray(form, on, "editorNames");
      Publications.formField(form, on, "time");

      JsonNode response = BookChapterPublication.add(on);
    } 
    catch (Exception e) {
      e.printStackTrace();
    }
  
    return redirect("/add/bookChapterPublication");
  }

  public static Result updatePage() {
    DynamicForm df = DynamicForm.form().bindFromRequest();
    String id = df.field("idHolder").value();

    BookChapterPublication bcp = BookChapterPublication.get(id);
    if (bcp != null) {
      Map<String, String> map = new TreeMap<String, String>();
      Publications.bindFields(map, bcp);

      map.put("bookName", bcp.getBookName());
      map.put("chapter", "" + bcp.getChapter());
      map.put("editorNames", bcp.formatStringArray(bcp.getEditorNames()));
      map.put("time", bcp.getTime());
      return ok(updateBookChapter.render(bcp, bcpublicationForm.bind(map)));
    }

    return notFound("Unable to update publication");
  }

  public static Result update() {
    Form form = bcpublicationForm.bindFromRequest();
    String id = form.field("idHolder").value();

    ObjectNode on = Json.newObject();

    try {
      on.put("paperId", id);
      Publications.formToJson(form, on);

      on.put("publicationChannel", Publication.Channel.BookChapter.toString());
      Publications.formField(form, on, "bookName");
      Publications.formField(form, on, "chapter");
      Publications.formFieldArray(form, on, "editorNames");
      Publications.formField(form, on, "time");

      JsonNode response = BookChapterPublication.update(on);
    }
    catch (Exception e) {
      e.printStackTrace();
    }

    return redirect("/bookChapterPublications");
  }
}

