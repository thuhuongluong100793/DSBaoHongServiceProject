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
	@Path("/GetDSBaoHong")
	@Produces("application/json")
	public String GetDSBaoHong()	
	{
		String baoHong = null;
		try
		{
			ArrayList<BaoHong> baoHongData = null;
			ProjectManager projectManager= new ProjectManager();
			baoHongData = projectManager.GetDSBaoHong();
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
	
	@GET
	@Path("/GetDSBaoHong/{keyWord}")
	@Produces("application/json")
	public String GetDSBaoHong(@PathParam("keyWord") String keyWord)	
	{
		String baoHong = null;
		try
		{
			ArrayList<BaoHong> baoHongData = null;
			ProjectManager projectManager= new ProjectManager();
			baoHongData = projectManager.GetDSBaoHong(keyWord);
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
	
	@GET
	@Path("/GetChiTietBaoHong/{maBaoHong}")
	@Produces("application/json")
	public String GetChiTietBaoHong(@PathParam("maBaoHong") String maBaoHong)	
	{
		String baoHong = null;
		try
		{
			BaoHong baoHongData = null;
			ProjectManager projectManager= new ProjectManager();
			baoHongData = projectManager.GetChiTietBaoHong(maBaoHong);
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