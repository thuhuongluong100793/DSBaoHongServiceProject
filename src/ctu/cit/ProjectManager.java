package ctu.cit;
import java.sql.Connection;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;


public class ProjectManager {
	//BaoHong
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
	public ArrayList<BaoHong> GetDSBaoHong(String keyWord)throws Exception {
		ArrayList<BaoHong> baoHong = null;
		try {
			DbConnection database= new DbConnection();
			Connection connection = database.GetConnection();
			Project project= new Project();
			baoHong = project.GetDSBaoHong(connection, keyWord);
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
	public int XoaBaoHong(String maBaoHong)throws Exception {
		int result = 0;
		try {
			DbConnection database= new DbConnection();
			Connection connection = database.GetConnection();
			Project project= new Project();
			result = project.XoaBaoHong(connection, maBaoHong);
		}
		catch (Exception e) {
			throw e;
		}
		return result;
	}
	public int SuaBaoHong(String maBaoHong, String maSuCo, String maKhachHang, 
			Date ngay, Time gio, String nguyenNhan, String xuLy, boolean trangThai) throws Exception {
		int result = 0;
		try {
			DbConnection database= new DbConnection();
			Connection connection = database.GetConnection();
			Project project= new Project();
			result = project.SuaBaoHong(connection, maBaoHong, maSuCo, maKhachHang, ngay,  gio, nguyenNhan, xuLy, trangThai );
		}
		catch (Exception e) {
			throw e;
		}
		return result;
	}
	public int ThemBaoHong(String maSuCo, String maKhachHang, 
			Date ngay, Time gio, String nguyenNhan, String xuLy, boolean trangThai) throws Exception {
		int result = 0;
		try {
			DbConnection database= new DbConnection();
			Connection connection = database.GetConnection();
			Project project= new Project();
			result = project.ThemBaoHong(connection, maSuCo, maKhachHang, ngay,  gio, nguyenNhan, xuLy, trangThai );
		}
		catch (Exception e) {
			throw e;
		}
		return result;
	}
	//KhachHang
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
	//SuCo
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
