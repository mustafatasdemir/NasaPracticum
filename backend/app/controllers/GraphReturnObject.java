package controllers;

import java.sql.SQLException;
import java.util.List;

import com.google.gson.Gson;

import play.mvc.*;
import models.*;

public class GraphReturnObject extends Controller{

	public GraphReturnObject() {
		// TODO Auto-generated constructor stub
	}
	
	public static Result getCoAuthorGraphData() throws SQLException
	{
		response().setHeader("Access-Control-Allow-Origin", "*");

	    models.GraphReturnObject gro = new models.GraphReturnObject();
	    gro.CoAuthorGraphData();
	    
	    if (gro.nodes == null) {
	      return notFound("No data found");
	    }

	    String ret = new Gson().toJson(gro);

	    return ok(ret);
	}

}
