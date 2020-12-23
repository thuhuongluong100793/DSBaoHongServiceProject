package ctu.cit;
import java.sql.Connection;
import java.sql.Date;
import java.sql.Statement;
import java.sql.Time;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;





public class Project {
	//BaoHong
	//The hien DS Bao hong
	public ArrayList<BaoHong> GetDSBaoHong(Connection connection) throws Exception
	{
		ArrayList<BaoHong> baoHongData = new ArrayList<BaoHong>();
		String sql = "SELECT BH_MA, A.SC_MA, SC_TEN, A.KH_MA, KH_TEN, BH_NGAY, BH_GIO, BH_NGUYENNHAN, BH_XULY, BH_TRANGTHAI"
				+ " FROM BAOHONG A, KHACHHANG B,  SUCO C "
				+ "WHERE A.KH_MA = B.KH_MA AND A.SC_MA = C.SC_MA ORDER BY BH_MA DESC";
		try
		{
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				BaoHong baoHong = new BaoHong();
				
				baoHong.setMaBaoHong(rs.getString("BH_MA"));
				baoHong.setMaSuCo(rs.getString("SC_MA"));
				baoHong.setTenSuCo(rs.getString("SC_TEN"));
				baoHong.setMaKhachHang(rs.getString("KH_MA"));
				baoHong.setTenKhachHang(rs.getString("KH_TEN"));
				baoHong.setNgay(rs.getDate("BH_NGAY"));
				baoHong.setGio(rs.getTime("BH_GIO"));
				baoHong.setNguyenNhan(rs.getString("BH_NGUYENNHAN"));
				baoHong.setXuLy(rs.getString("BH_XULY"));
				baoHong.setTrangThai(rs.getBoolean("BH_TRANGTHAI"));
				
				baoHongData.add(baoHong);
			}
		return baoHongData;
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	// The hien DS Bao hong co kem keyword de loc dieu kien tim kiem
	public ArrayList<BaoHong> GetDSBaoHong(Connection connection, String keyWord) throws Exception
	{
		ArrayList<BaoHong> baoHongData = new ArrayList<BaoHong>();
		
		String sql = "";
		if (!keyWord.equals("") || keyWord != null)
			sql = "SELECT BH_MA, A.SC_MA, SC_TEN, A.KH_MA, KH_TEN, BH_NGAY, BH_GIO, BH_NGUYENNHAN, BH_XULY, BH_TRANGTHAI"
				+ " FROM BAOHONG A, KHACHHANG B,  SUCO C "
				+ " WHERE A.KH_MA = B.KH_MA AND A.SC_MA = C.SC_MA " 
				+ " AND (UPPER(KH_TEN) LIKE UPPER('%"+keyWord+"%') OR UPPER(BH_NGUYENNHAN) LIKE UPPER('%"+keyWord+"%') "
				+ " OR UPPER(A.KH_MA) LIKE UPPER('%"+keyWord+"%') OR UPPER(SC_TEN) LIKE UPPER('%"+keyWord+"%') "
				+ " OR UPPER(BH_XULY) LIKE UPPER('%"+keyWord+"%') OR UPPER(BH_MA) LIKE UPPER('%"+keyWord+"%') " 
				+ " OR UPPER(A.SC_MA) LIKE UPPER('%"+keyWord+"%'))"
				+ " ORDER BY BH_MA DESC";
		else sql = "SELECT BH_MA, A.SC_MA, SC_TEN, A.KH_MA, KH_TEN, BH_NGAY, BH_GIO, BH_NGUYENNHAN, BH_XULY, BH_TRANGTHAI"
				+ " FROM BAOHONG A, KHACHHANG B,  SUCO C "
				+ " WHERE A.KH_MA = B.KH_MA AND A.SC_MA = C.SC_MA ORDER BY BH_MA DESC";
		try
		{
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				BaoHong baoHong = new BaoHong();
				
				baoHong.setMaBaoHong(rs.getString("BH_MA"));
				baoHong.setMaSuCo(rs.getString("SC_MA"));
				baoHong.setTenSuCo(rs.getString("SC_TEN"));
				baoHong.setMaKhachHang(rs.getString("KH_MA"));
				baoHong.setTenKhachHang(rs.getString("KH_TEN"));
				baoHong.setNgay(rs.getDate("BH_NGAY"));
				baoHong.setGio(rs.getTime("BH_GIO"));
				baoHong.setNguyenNhan(rs.getString("BH_NGUYENNHAN"));
				baoHong.setXuLy(rs.getString("BH_XULY"));
				baoHong.setTrangThai(rs.getBoolean("BH_TRANGTHAI"));
				
				baoHongData.add(baoHong);
			}
		return baoHongData;
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	// The hien thong tin cua 1 Bao hong co ma cu the
	public BaoHong GetChiTietBaoHong(Connection connection, String maBaoHong) throws Exception
	{
		BaoHong baoHongData = new BaoHong();
		String sql2 = "SELECT BH_MA, A.SC_MA, SC_TEN, A.KH_MA, KH_TEN, BH_NGAY, BH_GIO, BH_NGUYENNHAN, BH_XULY, BH_TRANGTHAI "
				
				+ " FROM BAOHONG A, KHACHHANG B, SUCO C "
				+ " WHERE BH_MA = '" + maBaoHong + "'"
				+ " AND A.KH_MA = B.KH_MA AND A.SC_MA = C.SC_MA "
				+ " ORDER BY BH_MA DESC";
		try
		{
			PreparedStatement ps = connection.prepareStatement(sql2);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{	
				baoHongData.setMaBaoHong(rs.getString("BH_MA"));
				baoHongData.setMaSuCo(rs.getString("SC_MA"));
				baoHongData.setTenSuCo(rs.getString("SC_TEN"));
				baoHongData.setMaKhachHang(rs.getString("KH_MA"));
				baoHongData.setTenKhachHang(rs.getString("KH_TEN"));
				baoHongData.setNgay(rs.getDate("BH_NGAY"));
				baoHongData.setGio(rs.getTime("BH_GIO"));
				baoHongData.setNguyenNhan(rs.getString("BH_NGUYENNHAN"));
				baoHongData.setXuLy(rs.getString("BH_XULY"));
				baoHongData.setTrangThai(rs.getBoolean("BH_TRANGTHAI"));		
			}
			return baoHongData;
			
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	// Xoa bo 1 Bao hong co ma cu the
	public int XoaBaoHong (Connection connection, String maBaoHong) throws Exception
	{
		String sql = "DELETE FROM BAOHONG WHERE BH_MA = '" +maBaoHong+ "'";
		int result = 0;
		try
		{
			Statement ps = connection.createStatement();
			int rs = ps.executeUpdate(sql);	
			result = rs;
		}
		catch(Exception e)
		{
			throw e;
		}
		return result;
	}
	
	// Sua Bao hong voi cac thong tin dinh kem
	public int SuaBaoHong (Connection connection, String maBaoHong, String maSuCo, String maKhachHang, 
			Date ngay, Time gio, String nguyenNhan, String xuLy, boolean trangThai) throws Exception
	{
		String sql = "UPDATE BAOHONG SET SC_MA = ?, KH_MA = ?, BH_NGAY = ?, BH_GIO = ?,"
				+ "BH_NGUYENNHAN = ?, BH_XULY = ?, BH_TRANGTHAI = ?  WHERE BH_MA = ?;";
				//+maBaoHong+ "'";
		int result = 0;
		try
		{
			if (!maBaoHong.equals("") || !maSuCo.equals("") || !maKhachHang.equals("") || ngay != null || gio != null  )
			{
				PreparedStatement ps = connection.prepareStatement(sql);
				
				ps.setString(1, maSuCo);
				ps.setString(2, maKhachHang);
				ps.setDate(3, ngay);
				ps.setTime(4, gio);
				ps.setString(5, nguyenNhan);
				ps.setString(6, xuLy);
				ps.setBoolean(7, trangThai);
				ps.setString(8, maBaoHong);
				int rs = ps.executeUpdate();	
				result = rs;
				//return 1;
			}
			
		}
		catch(Exception e)
		{
			throw e;
		}
		return result;
	}
	
	// Them moi 1 Bao hong
	
	public int ThemBaoHong (Connection connection, String maSuCo, String maKhachHang, 
			Date ngay, Time gio, String nguyenNhan, String xuLy, boolean trangThai) throws Exception
	{
		String sql = "INSERT INTO BAOHONG VALUES((SELECT MAX(CONVERT(BH_MA, INT)) + 1 FROM BAOHONG BH),?,?,?,?,?,?,?);";
		int result = 0;
		try
		{
			if (!maSuCo.equals("") || !maKhachHang.equals("") || ngay != null || gio != null  )
			{
				PreparedStatement ps = connection.prepareStatement(sql);
				
				ps.setString(1, maSuCo);
				ps.setString(2, maKhachHang);
				ps.setDate(3, ngay);
				ps.setTime(4, gio);
				ps.setString(5, nguyenNhan);
				ps.setString(6, xuLy);
				ps.setBoolean(7, trangThai);
				int rs = ps.executeUpdate();	
				result = rs;
				//return 1;
			}
			
		}
		catch(Exception e)
		{
			throw e;
		}
		return result;
	}
	
	//KhachHang
	// The hien DS Khach hang
	
	public ArrayList<KhachHang> GetDSKhachHang(Connection connection) throws Exception
	{
		ArrayList<KhachHang> khachHangData = new ArrayList<KhachHang>();
		String sql = "SELECT KH_MA, KH_TEN, KH_DIACHI, KH_SDT "
				+ " FROM KHACHHANG ";
		try
		{
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				KhachHang khachHang = new KhachHang();
				
				khachHang.setMaKhachHang(rs.getString("KH_MA"));
				khachHang.setTenKhachHang(rs.getString("KH_TEN"));
				khachHang.setSDT(rs.getString("KH_SDT"));
				khachHang.setDiaChi(rs.getString("KH_DIACHI"));
				
				khachHangData.add(khachHang);
			}
		return khachHangData;
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	//SuCo
	// The hien DS Su co
	public ArrayList<SuCo> GetDSSuCo(Connection connection) throws Exception
	{
		ArrayList<SuCo> suCoData = new ArrayList<SuCo>();
		String sql = "SELECT SC_MA, SC_TEN "
				+ " FROM SUCO ";
		try
		{
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				SuCo suCo = new SuCo();
				
				suCo.setMaSuCo(rs.getString("SC_MA"));
				suCo.setTenSuCo(rs.getString("SC_TEN"));
				
				suCoData.add(suCo);
			}
			return suCoData;
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	

}
