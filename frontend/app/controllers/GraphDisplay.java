package controllers;

import com.fasterxml.jackson.databind.JsonNode;

import java.io.UnsupportedEncodingException;
import play.mvc.*;
import util.APICall;
import views.html.graphDisplay;
import views.html.mapInstituteLocation;

public class GraphDisplay extends Controller {
	
	//Renders the graph display page initially with default settings.
	public static Result graphDisplay() throws UnsupportedEncodingException 
	{
		return ok(graphDisplay.render());
	}
	
	// Called to render Co-Author graph directly from the javascript. Takes a string parameter as the topic to be searched.
	// Calls the transform encoding helper as the topic parameter uses javascripts encodeuricomponent which outputs a 
	// different format when compared to Java's URLEncoding/Decoding, which the frontend - backend applications use to transfer parameters 
	public static Result getCoAuthorGraphData(String topic) throws UnsupportedEncodingException
	{
		topic = util.Helper.TransformEncoding(topic);
		final JsonNode graphData = APICall.callAPI(util.Constants.HOSTNAME + util.Constants.GET_COAUTHOR_GRAPH_DATA + "/" + topic);
		  
		return ok(graphData);
	}
	
	public static Result mapInstituteLocation()
	{
		return ok(mapInstituteLocation.render());
	}

}
