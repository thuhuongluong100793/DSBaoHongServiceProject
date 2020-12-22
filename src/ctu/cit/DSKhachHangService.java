package ctu.cit;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.google.gson.Gson;

@Path("/WebService")
public class DSKhachHangService {
	@GET
	@Path("/GetDSKhachHang")
	@Produces("application/json")
	public String GetDSKhachHang()	
	{
		String khachHang = null;
		try
		{
			ArrayList<KhachHang> khachHangData = null;
			ProjectManager projectManager= new ProjectManager();
			khachHangData = projectManager.GetDSKhachHang();
			Gson gson = new Gson();
			System.out.println(gson.toJson(khachHangData));
			khachHang = gson.toJson(khachHangData);
		}
		
		catch (Exception e)
		{
			System.out.println(e); //Console 
		}
		return khachHang;
		
	}	

}
