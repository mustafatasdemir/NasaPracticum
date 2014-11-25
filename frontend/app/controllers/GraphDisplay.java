package controllers;

import com.fasterxml.jackson.databind.JsonNode;

import java.io.UnsupportedEncodingException;
import play.mvc.*;
import util.APICall;
import views.html.graphDisplay;
import views.html.mapSchoolsLocation;

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
	
	// Called to render Co-Author graph when multiple topics are provided. Comments for getCoAuthorGraphData explains more in details
	public static Result getCoAuthorGraphDataMultipleTopic(String topic) throws UnsupportedEncodingException
	{
		topic = util.Helper.TransformEncoding(topic);
		final JsonNode graphData = APICall.callAPI(util.Constants.HOSTNAME + util.Constants.GET_COAUTHOR_GRAPH_DATA_MULTIPLE_TOPIC + "/" + topic);
		  
		return ok(graphData);
	}
	
	public static Result mapSchoolsLocation()
	{
		return ok(mapSchoolsLocation.render());
	}

	//Called to get school details relevant to the topic being searched.
	public static Result getSchoolsByTopic(String topic) throws UnsupportedEncodingException
	{
		topic = util.Helper.TransformEncoding(topic);
		final JsonNode addressData = APICall.callAPI(util.Constants.HOSTNAME + util.Constants.GET_SCHOOLS_BY_TOPIC + "/" + topic);
		  
		return ok(addressData);
	}
	
	
}
