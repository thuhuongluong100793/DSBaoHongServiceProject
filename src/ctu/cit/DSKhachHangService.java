package ctu.cit;

import java.sql.Connection;
import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.google.gson.Gson;

@Path("/WebService")
public class DSKhachHangService {
	@GET
	@Path("/GetDSKhachHang")
	@Produces("application/json")
	public String GetDSKhachHang(@HeaderParam("authorization") String authString) throws Exception {
		String khachHang = null;
		DbConnection db = new DbConnection();
		Connection conn = db.GetConnection();
		if (Authorize.authRoleView(authString, conn)) {
			try {
				ArrayList<KhachHang> khachHangData = null;
				ProjectManager projectManager = new ProjectManager();
				khachHangData = projectManager.GetDSKhachHang();
				Gson gson = new Gson();
				System.out.println(gson.toJson(khachHangData));
				khachHang = gson.toJson(khachHangData);
			}

			catch (Exception e) {
				System.out.println(e); // Console
			}
			return khachHang;
		} else
			return "Ban khong co quyen";
	}

}
