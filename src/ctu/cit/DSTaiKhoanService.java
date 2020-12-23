package ctu.cit;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.google.gson.Gson;

public class DSTaiKhoanService {
	@GET
	@Path("/GetTaiKhoan/{tenDangNhap}/{matKhau}")
	@Produces("application/json")
	public String GetTaiKhoan(@PathParam("tenDangNhap") String tenDangNhap, @PathParam("matKhau") String matKhau)	
	{
		String taiKhoan = null;
		try
		{
			TaiKhoan taiKhoanData = null;
			ProjectManager projectManager= new ProjectManager();
			taiKhoanData = projectManager.GetTaiKhoan(tenDangNhap, matKhau);
			Gson gson = new Gson();
			System.out.println(gson.toJson(taiKhoanData));
			taiKhoan = gson.toJson(taiKhoanData);
		}
		
		catch (Exception e)
		{
			System.out.println(e); //Console 
		}
		return taiKhoan;		
	}

}
