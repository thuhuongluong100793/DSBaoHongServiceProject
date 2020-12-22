package ctu.cit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;



public class Project {
	//BaoHong
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
				+ " OR UPPER(BH_XULY) LIKE UPPER('%"+keyWord+"%'))" 
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
	//KhachHang
	
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
