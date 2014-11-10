package controllers;

import java.sql.SQLException;
import play.libs.Json;
import play.mvc.*;

public class GraphReturnObject extends Controller{

	public GraphReturnObject() {
		// TODO Auto-generated constructor stub
	}
	
	public static Result getCoAuthorGraphData(String topic) throws SQLException
	{
		models.GraphReturnObject gro = new models.GraphReturnObject();
	    gro.CoAuthorGraphData(topic);
	    
	    if (gro.nodes == null) {
	      return notFound("No data found");
	    }

	    return ok(Json.toJson(gro));
	}

}
