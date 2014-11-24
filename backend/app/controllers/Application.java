package controllers;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import play.*;
import play.mvc.*;
import trustprocessor.DBLPTrustProcessor;
import views.html.*;

public class Application extends Controller {

  public static Result index() {
    return ok(index.render("Your new application is ready."));
  }
  
  public static Result testFor(){
	  try {
		DBLPTrustProcessor prc = new DBLPTrustProcessor();
		try {
			prc.testIt();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("de");
	} catch (SAXException | ParserConfigurationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	    return ok(index.render("Your new application is ready."));
	  
  }

}
