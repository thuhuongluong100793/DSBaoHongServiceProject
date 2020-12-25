package ctu.cit;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

import sun.misc.BASE64Decoder;

@Path("/WebService")
public class DSBaoHongService {

	@GET
	@Path("/GetDSBaoHong")
	@Produces("application/json")
	public String GetDSBaoHong(@HeaderParam("authorization") String authString) throws Exception {
		String baoHong = null;
		DbConnection db = new DbConnection();
		Connection conn = db.GetConnection();
		if (Authorize.authRoleView(authString, conn)) {

			try {
				ArrayList<BaoHong> baoHongData = null;
				ProjectManager projectManager = new ProjectManager();
				baoHongData = projectManager.GetDSBaoHong();
				Gson gson = new Gson();
				System.out.println(gson.toJson(baoHongData));
				baoHong = gson.toJson(baoHongData);
			}

			catch (Exception e) {
				System.out.println(e); // Console
			}
			return baoHong;
		} else
			return "Ban khong co quyen";
	}

	@GET
	@Path("/GetDSBaoHong/{keyWord}")
	@Produces("application/json")
	public String GetDSBaoHong(@HeaderParam("authorization") String authString, @PathParam("keyWord") String keyWord)
			throws Exception {
		String baoHong = null;
		DbConnection db = new DbConnection();
		Connection conn = db.GetConnection();
		if (Authorize.authRoleView(authString, conn)) {

			try {
				ArrayList<BaoHong> baoHongData = null;
				ProjectManager projectManager = new ProjectManager();
				baoHongData = projectManager.GetDSBaoHong(keyWord);
				Gson gson = new Gson();
				System.out.println(gson.toJson(baoHongData));
				baoHong = gson.toJson(baoHongData);
			}

			catch (Exception e) {
				System.out.println(e); // Console
			}
			return baoHong;
		} else
			return "Ban khong co quyen";
	}

	@GET
	@Path("/GetChiTietBaoHong/{maBaoHong}")
	@Produces("application/json")
	public String GetChiTietBaoHong(@HeaderParam("authorization") String authString,
			@PathParam("maBaoHong") String maBaoHong) throws Exception {
		String baoHong = null;
		DbConnection db = new DbConnection();
		Connection conn = db.GetConnection();
		if (Authorize.authRoleView(authString, conn)) {
			try {
				BaoHong baoHongData = null;
				ProjectManager projectManager = new ProjectManager();
				baoHongData = projectManager.GetChiTietBaoHong(maBaoHong);
				Gson gson = new Gson();
				System.out.println(gson.toJson(baoHongData));
				baoHong = gson.toJson(baoHongData);
			}

			catch (Exception e) {
				System.out.println(e); // Console
			}
			return baoHong;
		} else
			return "Ban khong co quyen";
	}

	@GET
	@Path("/XoaBaoHong/{maBaoHong}")
	@Produces("application/json")
	public String XoaBaoHong(@HeaderParam("authorization") String authString,
			@PathParam("maBaoHong") String maBaoHong) throws Exception {
		int result = 0;
		String resCode = "";
		String resMessage = "";
		String result_string = "";
		DbConnection db = new DbConnection();
		Connection conn = db.GetConnection();
		if (Authorize.authRoleModify(authString, conn)) {
			try {
				ProjectManager projectManager = new ProjectManager();
				result = projectManager.XoaBaoHong(maBaoHong);
				Gson gson = new Gson();
				System.out.println(gson.toJson(result));
				if (result >= 1) {
					resCode = "1";
					resMessage = "Xóa thành công!";
				} else if (result == 0) {
					resCode = "-1";
					resMessage = "Không thể xóa thông tin này!";
				}

				result_string = "{ \"resCode\" : \"" + resCode + "\",  \"resMessage\" : \"" + resMessage + "\"  }";
				// baoHong = gson.toJson(baoHongData);
				System.out.println(gson.toJson(result_string));
			}

			catch (Exception e) {
				System.out.println(e); // Console
			}
			return result_string;
		} else
			return "Ban khong co quyen";
	}

	@GET
	@Path("/SuaBaoHong/{maBaoHong}/{maSuCo}/{maKhachHang}/{ngay}/{gio}/{nguyenNhan:.*?}/{xuLy:.*?}/{trangThai}")
	@Produces("application/json")
	public String SuaBaoHong(@HeaderParam("authorization") String authString, @PathParam("maBaoHong") String maBaoHong,
			@PathParam("maSuCo") String maSuCo, @PathParam("maKhachHang") String maKhachHang,
			@PathParam("ngay") Date ngay, @PathParam("gio") Time gio, @PathParam("nguyenNhan") String nguyenNhan,
			@PathParam("xuLy") String xuLy, @PathParam("trangThai") Boolean trangThai) throws Exception {
		int result = 0;
		String resCode = "";
		String resMessage = "";
		String result_string = "";
		DbConnection db = new DbConnection();
		Connection conn = db.GetConnection();
		if (Authorize.authRoleModify(authString, conn)) {
			try {
				ProjectManager projectManager = new ProjectManager();
				result = projectManager.SuaBaoHong(maBaoHong, maSuCo, maKhachHang, ngay, gio, nguyenNhan, xuLy,
						trangThai);
				Gson gson = new Gson();
				System.out.println(gson.toJson(result));
				if (result >= 1) {
					resCode = "1";
					resMessage = "Cập nhật thành công!";
				} else if (result == 0) {
					resCode = "-1";
					resMessage = "Không thể cập nhật thông tin này!";
				}

				result_string = "{ \"resCode\" : \"" + resCode + "\",  \"resMessage\" : \"" + resMessage + "\"  }";
				System.out.println(gson.toJson(result_string));
			}

			catch (Exception e) {
				System.out.println(e); // Console
			}
			return result_string;
		} else
			return "Ban khong co quyen";
	}

	@GET
	@Path("/ThemBaoHong/{maBaoHong}/{maSuCo}/{maKhachHang}/{ngay}/{gio}/{nguyenNhan:.*?}/{xuLy:.*?}/{trangThai}")
	@Produces("application/json")
	public String ThemBaoHong(@HeaderParam("authorization") String authString, @PathParam("maBaoHong") String maBaoHong,
			@PathParam("maSuCo") String maSuCo, @PathParam("maKhachHang") String maKhachHang,
			@PathParam("ngay") Date ngay, @PathParam("gio") Time gio, @PathParam("nguyenNhan") String nguyenNhan,
			@PathParam("xuLy") String xuLy, @PathParam("trangThai") Boolean trangThai) throws Exception {
		int result = 0;
		String resCode = "";
		String resMessage = "";
		String result_string = "";
		DbConnection db = new DbConnection();
		Connection conn = db.GetConnection();
		if (Authorize.authRoleModify(authString, conn)) {
			try {
				ProjectManager projectManager = new ProjectManager();
				result = projectManager.ThemBaoHong(maBaoHong, maSuCo, maKhachHang, ngay, gio, nguyenNhan, xuLy,
						trangThai);
				Gson gson = new Gson();
				System.out.println(gson.toJson(result));
				if (result >= 1) {
					resCode = "1";
					resMessage = "Thêm mới thành công!";
				} else if (result == 0) {
					resCode = "-1";
					resMessage = "Không thể thêm mới thông tin này!";
				}

				result_string = "{ \"resCode\" : \"" + resCode + "\",  \"resMessage\" : \"" + resMessage + "\"  }";
				System.out.println(gson.toJson(result_string));
			}

			catch (Exception e) {
				System.out.println(e); // Console
			}
			return result_string;
		} else
			return "Ban khong co quyen";

	}

}