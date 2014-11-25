package controllers;

import java.sql.SQLException;

import play.libs.Json;
import play.mvc.*;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class GraphReturnObject extends Controller{

	public GraphReturnObject() {
		// TODO Auto-generated constructor stub
	}
	
	// Controller to receive request for data required to render Co-Author graph. Receives the topic as a 
	// String parameter encoded as a URL in UTF-8. Calls on the model by the same name to contact the database 
	// for data and returns the model as a Json object
	public static Result getCoAuthorGraphData(String parameter) throws SQLException, UnsupportedEncodingException
	{
		parameter = URLDecoder.decode(parameter, "UTF-8");
		models.GraphReturnObject graphReturnObject = new models.GraphReturnObject();
		graphReturnObject.CoAuthorGraphData(parameter);
	    
	    if (graphReturnObject.nodes == null) {
	      return notFound("No data found");
	    }

	    return ok(Json.toJson(graphReturnObject));
	}

}
