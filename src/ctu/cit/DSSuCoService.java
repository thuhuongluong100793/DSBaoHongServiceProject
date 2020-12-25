package ctu.cit;

import java.sql.Connection;
import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.google.gson.Gson;

@Path("/WebService")
public class DSSuCoService {
	@GET
	@Path("/GetDSSuCo")
	@Produces("application/json")
	public String GetDSSuCo(@HeaderParam("authorization") String authString) throws Exception	
	{
		String suCo = null;
		DbConnection db = new DbConnection();
		Connection conn = db.GetConnection();
		if (Authorize.authRoleModify(authString, conn)) {
		try
		{
			ArrayList<SuCo> suCoData = null;
			ProjectManager projectManager= new ProjectManager();
			suCoData = projectManager.GetDSSuCo();
			Gson gson = new Gson();
			System.out.println(gson.toJson(suCoData));
			suCo = gson.toJson(suCoData);
		}
		
		catch (Exception e)
		{
			System.out.println(e); //Console 
		}
		return suCo;
		} else
			return "Ban khong co quyen";
		
	}	

}
