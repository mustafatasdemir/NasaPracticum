package controllers;

import java.sql.SQLException;

import play.libs.Json;
import play.mvc.*;
import trustprocessor.DBLPTrustProcessor;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class GraphReturnObject extends Controller{

	public GraphReturnObject() {
		// TODO Auto-generated constructor stub
	}
	
	// Controller to receive request for data required to render Co-Author graph. Receives the topic as a 
	// String parameter encoded as a URL in UTF-8. Calls on the model by the same name to contact the database 
	// for data and returns the model as a Json object
	public static Result getCoAuthorGraphDataByTopic(String parameter) throws SQLException, UnsupportedEncodingException
	{
		parameter = URLDecoder.decode(parameter, "UTF-8");
		models.GraphReturnObject graphReturnObject = new models.GraphReturnObject();
		
		String[] params = parameter.split("&");
		
		if(params[3].equals("true")){
			try {
				DBLPTrustProcessor proc = new DBLPTrustProcessor();
				proc.setTrustRelatedObjects(params[0], Integer.parseInt(params[2]));
				graphReturnObject = proc.retrieveTrustBasedGraph(params[0]);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else{
			graphReturnObject.CoAuthorGraphDataByTopic(parameter);
		}
	    
	    if (graphReturnObject.nodes == null) {
	      return notFound("No data found");
	    }

	    return ok(Json.toJson(graphReturnObject));
	}

}
