package ctu.cit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;



public class Project {
	public ArrayList<BaoHong> GetBaoHong(Connection connection) throws Exception
	{
		ArrayList<BaoHong> baoHongData = new ArrayList<BaoHong>();
		String sql = "SELECT BH_MA, SC_MA, KH_MA, BH_NGAY, BH_GIO, BH_NGUYENNHAN, BH_XULY, BH_TRANGTHAI"
				+ " FROM BAOHONG ORDER BY BH_MA DESC";
		try
		{
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				BaoHong baoHong = new BaoHong();
				
				baoHong.setMaBaoHong(rs.getString("BH_MA"));
				baoHong.setMaSuCo(rs.getString("SC_MA"));
				baoHong.setMaKhachHang(rs.getString("KH_MA"));
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

}
