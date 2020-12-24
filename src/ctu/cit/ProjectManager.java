package ctu.cit;
import java.sql.Connection;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;


public class ProjectManager {
	//BaoHong
	//The hien DS Bao hong
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
	// The hien DS Bao hong co kem keyword de loc dieu kien tim kiem
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
	// The hien thong tin cua 1 Bao hong co ma cu the
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
	// Xoa bo 1 Bao hong co ma cu the
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
	// Sua Bao hong voi cac thong tin dinh kem
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
	// Them moi 1 Bao hong
	public int ThemBaoHong(String maBaoHong, String maSuCo, String maKhachHang, 
			Date ngay, Time gio, String nguyenNhan, String xuLy, boolean trangThai) throws Exception {
		int result = 0;
		try {
			DbConnection database= new DbConnection();
			Connection connection = database.GetConnection();
			Project project= new Project();
			result = project.ThemBaoHong(connection, maBaoHong, maSuCo, maKhachHang, ngay,  gio, nguyenNhan, xuLy, trangThai );
		}
		catch (Exception e) {
			throw e;
		}
		return result;
	}
	//KhachHang
	// The hien DS Khach hang
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
	// The hien DS Su co
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
	
	//TaiKhoan
	// The hien Tai khoan
	public TaiKhoan GetTaiKhoan(String authString)throws Exception {
		TaiKhoan taiKhoan = null;
		try {
			DbConnection database= new DbConnection();
			Connection connection = database.GetConnection();
			Project project= new Project();
			taiKhoan = project.GetTaiKhoan(connection, authString);
		}
		catch (Exception e) {
			throw e;
		}
		return taiKhoan;
	}
}
