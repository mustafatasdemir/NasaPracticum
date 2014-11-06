package controllers;


import play.mvc.*;

import views.html.*;
 
import java.util.Map;
 
public class GraphByTopic extends Controller {
   
  public static void getTopic() {
 
    final Map<String, String[]> values = request().body().asFormUrlEncoded();
    final String name = values.get("java_name")[0];
    final String surname = values.get("java_surname")[0];
     
    return ok(index.render(String.format("Selected %s, %s",surname, name)));
  }
   
}