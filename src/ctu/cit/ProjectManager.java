package ctu.cit;
import java.sql.Connection;
import java.util.ArrayList;


public class ProjectManager {
	public ArrayList<BaoHong> GetDSBaoHong()throws Exception {
		ArrayList<BaoHong> baoHong = null;
		try {
			DbConnection database= new DbConnection();
			Connection connection = database.GetConnection();
			Project project= new Project();
			baoHong = project.GetDSBaoHong(connection);
		}
		catch (Exception e) {
			throw e;
		}
		return baoHong;
	}
	public BaoHong GetChiTietBaoHong(String maBaoHong)throws Exception {
		BaoHong baoHong = null;
		try {
			DbConnection database= new DbConnection();
			Connection connection = database.GetConnection();
			Project project= new Project();
			baoHong = project.GetChiTietBaoHong(connection, maBaoHong);
		}
		catch (Exception e) {
			throw e;
		}
		return baoHong;
	}
	public ArrayList<KhachHang> GetDSKhachHang()throws Exception {
		ArrayList<KhachHang> khachHang = null;
		try {
			DbConnection database= new DbConnection();
			Connection connection = database.GetConnection();
			Project project= new Project();
			khachHang = project.GetDSKhachHang(connection);
		}
		catch (Exception e) {
			throw e;
		}
		return khachHang;
	}
	public ArrayList<SuCo> GetDSSuCo()throws Exception {
		ArrayList<SuCo> suCo = null;
		try {
			DbConnection database= new DbConnection();
			Connection connection = database.GetConnection();
			Project project= new Project();
			suCo = project.GetDSSuCo(connection);
		}
		catch (Exception e) {
			throw e;
		}
		return suCo;
	}
}
