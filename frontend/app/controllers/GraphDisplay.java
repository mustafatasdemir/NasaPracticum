package controllers;

import com.fasterxml.jackson.databind.JsonNode;

import play.mvc.*;
import util.APICall;
import views.html.graphDisplay;

public class GraphDisplay extends Controller {
	
	public static Result graphDisplay() 
	{
	  final JsonNode graphData = APICall.callAPI(util.Constants.HOSTNAME + util.Constants.GET_COAUTHOR_GRAPH_DATA + "/" + "demo");
	  
	  return ok(graphDisplay.render(graphData.toString()));
	}
	  
	  public static Result getCoAuthorGraphData()
	  {		  
		  final JsonNode graphData = APICall.callAPI(util.Constants.HOSTNAME + util.Constants.GET_COAUTHOR_GRAPH_DATA + "/" + "demo");
		  
		  return ok(graphDisplay.render(graphData.toString()));
	  }

}
