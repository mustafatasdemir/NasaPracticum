package controllers;

import play.mvc.*;
import trustprocessor.DBLPTrustProcessor;
import views.html.*;

public class Application extends Controller {

  public static Result index() {
	  
	try{
		DBLPTrustProcessor dblp =  new DBLPTrustProcessor();
		 dblp.testIt();
	}catch(Exception e){
		 e.printStackTrace();;
	}
	
    return ok(index.render("Your new application is ready."));
  }

}
