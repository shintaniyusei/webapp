package rest.v1;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import org.json.JSONObject;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import model.CaluclateModel;

/**
 * Sample program of WebAPI (REST) service using Jersey
 * @version 2020-05-12
 * @since 2019-05-13
 * @author nakano@cc.kumamoto-u.ac.jp
 */

@Path("caluclation")
public class CaluclateTable {
	private static CaluclateModel model = new CaluclateModel();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<LinkedHashMap<String, Object>> getArray() {
		System.out.println("test_caluc:"+model.getHistoryJSON());
		return model.getHistoryJSON();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response postComment(String jsonString, @Context HttpServletRequest request) {
		JSONObject data = new JSONObject(jsonString);
		model.setCaluclate(data.optString("name"), data.optString("atime"), data.optString("elapsed_time"));
		System.out.println((new Date()) + ": " + data.optString("name") + "," + data.optString("atime") + "," + data.optString("elapsed_time"));
		return Response.ok().build();
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteAll() {
		model.init();
		return Response.ok().build();
	}
}