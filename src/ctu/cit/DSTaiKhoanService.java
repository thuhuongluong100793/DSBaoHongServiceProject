package ctu.cit;

import java.util.Base64;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

import com.google.gson.Gson;

@Path("/WebService")
public class DSTaiKhoanService {
	@Context
    private HttpServletRequest request;
	@GET
	@Path("/GetTaiKhoan/{authString}")
	@Produces("application/json")
	public String GetTaiKhoan(@PathParam("authString") String authString)	
	{
		
		
		String resCode = "-1";
		String resMessage = "Vui lòng kiểm tra lại thông tin đăng nhập";
		String taiKhoan = "{ \"resCode\" : \""+ resCode +"\",  \"resMessage\" : \""+ resMessage +"\"  }";
				
		DecodeBase64 decode = new DecodeBase64();
		String[] auth_splits = decode.DecodeBase64(authString);
		String tenDangNhap = auth_splits[0];
		
		
		try
		{
			TaiKhoan taiKhoanData = null;
			ProjectManager projectManager= new ProjectManager();
			taiKhoanData = projectManager.GetTaiKhoan(authString);
			Gson gson = new Gson();
			System.out.println(gson.toJson(taiKhoanData));			
			if (taiKhoanData.getTenDangNhap(tenDangNhap) != null)
			{
				taiKhoan = gson.toJson(taiKhoanData);
				HttpSession session = request.getSession();
			}			
				
		}
		
		catch (Exception e)
		{
			System.out.println(e); //Console 
		}
		return taiKhoan;		
	}

}
