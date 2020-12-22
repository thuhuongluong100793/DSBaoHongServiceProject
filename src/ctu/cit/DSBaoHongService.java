package ctu.cit;



import java.util.ArrayList;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;


@Path("/WebService")
public class DSBaoHongService {

	@GET
	@Path("/GetBaoHong")
	@Produces("application/json")
	public String baoHong()
	{
		String baoHong = null;
		try
		{
			ArrayList<BaoHong> baoHongData = null;
			ProjectManager projectManager= new ProjectManager();
			baoHongData = projectManager.GetBaoHong();
			Gson gson = new Gson();
			System.out.println(gson.toJson(baoHongData));
			baoHong = gson.toJson(baoHongData);
		}
		
		catch (Exception e)
		{
			System.out.println(e); //Console 
		}
		return baoHong;
	}

}