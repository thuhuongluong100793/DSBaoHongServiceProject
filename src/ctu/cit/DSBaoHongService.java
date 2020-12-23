package ctu.cit;



import java.sql.Date;
import java.sql.Time;
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
	@GET
	@Path("/XoaBaoHong/{maBaoHong}")
	@Produces("application/json")
	public String XoaBaoHong(@PathParam("maBaoHong") String maBaoHong)	
	{
		int result = 0;
		String resCode = "";
		String resMessage = "";
		String result_string = "";
		try
		{
			ProjectManager projectManager= new ProjectManager();
			result = projectManager.XoaBaoHong(maBaoHong);
			Gson gson = new Gson();
			System.out.println(gson.toJson(result));
			if (result >= 1) {
				resCode = "1";
				resMessage = "Xóa thành công!";
			}
			else if (result == 0)
			{
				resCode = "-1";
				resMessage = "Không thể xóa thông tin này!";
			}
			
			
			result_string = "{ \"resCode\" : \""+ resCode +"\",  \"resMessage\" : \""+ resMessage +"\"  }";
			//baoHong = gson.toJson(baoHongData);
			System.out.println(gson.toJson(result_string));
		}
		
		catch (Exception e)
		{
			System.out.println(e); //Console 
		}
		return result_string;
		
	}
	
	@GET
	@Path("/SuaBaoHong/{maBaoHong}/{maSuCo}/{maKhachHang}/{ngay}/{gio}/{nguyenNhan}/{xuLy}/{trangThai}")
	@Produces("application/json")
	public String  SuaBaoHong(@PathParam("maBaoHong") String maBaoHong, @PathParam("maSuCo") String maSuCo,
			@PathParam("maKhachHang") String maKhachHang, @PathParam("ngay") Date ngay, 
			@PathParam("gio") Time gio,
			@PathParam("nguyenNhan") String nguyenNhan, @PathParam("xuLy") String xuLy,
			@PathParam("trangThai") Boolean trangThai)	
	{
		int result = 0;
		String resCode = "";
		String resMessage = "";
		String result_string = "";
		try
		{
			ProjectManager projectManager= new ProjectManager();
			result = projectManager.SuaBaoHong(maBaoHong, maSuCo, maKhachHang, ngay, gio, nguyenNhan, xuLy, trangThai);
			Gson gson = new Gson();
			System.out.println(gson.toJson(result));
			if (result >= 1) {
				resCode = "1";
				resMessage = "Cập nhật thành công!";
			}
			else if (result == 0)
			{
				resCode = "-1";
				resMessage = "Không thể cập nhật thông tin này!";
			}
			
			
			result_string = "{ \"resCode\" : \""+ resCode +"\",  \"resMessage\" : \""+ resMessage +"\"  }";
			System.out.println(gson.toJson(result_string));
		}
		
		catch (Exception e)
		{
			System.out.println(e); //Console 
		}
		return result_string;
		
	}

}