package ctu.cit;

import java.sql.Time;
import java.util.Date;

public class BaoHong {
	
	private String BH_MA;
	private String SC_MA;
	private String SC_TEN;
	private String KH_MA;
	private String KH_TEN;
	private Date BH_NGAY;
	private Time BH_GIO;
	private String BH_NGUYENNHAN;
	private String BH_XULY;
	private Boolean BH_TRANGTHAI;
	
	//Get
	public String getMaBaoHong (String maBaoHong)
	{
		return BH_MA;
	}
	public String getMaSuCo (String maSuCo)
	{
		return SC_MA;
	}
	public String getTenSuCo (String tenSuCo)
	{
		return SC_TEN;
	}
	public String getMaKhachHang (String maKhachHang)
	{
		return KH_MA;
	}
	public String getTenKhachHang (String tenKhachHang)
	{
		return KH_TEN;
	}
	public Date getNgay (String ngayBaoHong)
	{
		return BH_NGAY;
	}
	public Date getGio (String gioBaoHong)
	{
		return BH_GIO;
	}
	public String getNguyenNhan (String nguyenNhan)
	{
		return BH_NGUYENNHAN;
	}
	public String getXuLy (String xuLy)
	{
		return BH_XULY;
	}
	public Boolean getTrangThai (String trangThai)
	{
		return BH_TRANGTHAI;
	}
	
	//Set
	public void setMaBaoHong (String maBaoHong)
	{
		this.BH_MA = maBaoHong;
	}
	public void setMaSuCo (String maSuCo)
	{
		this.SC_MA = maSuCo;
	}
	public void setTenSuCo (String tenSuCo)
	{
		this.SC_TEN = tenSuCo;
	}
	public void setTenKhachHang (String tenKhachHang)
	{
		this.KH_TEN = tenKhachHang;
	}
	public void setMaKhachHang (String maKhachHang)
	{
		this.KH_MA = maKhachHang;
	}
	public void setNgay (Date ngayBaoHong)
	{
		this.BH_NGAY = ngayBaoHong;
	}
	public void setGio (Time gioBaoHong)
	{
		this.BH_GIO = gioBaoHong;
	}
	public void setNguyenNhan (String nguyenNhan)
	{
		this.BH_NGUYENNHAN = nguyenNhan;
	}
	public void setXuLy (String xuLy)
	{
		this.BH_XULY = xuLy;
	}
	public void setTrangThai (boolean trangThai)
	{
		this.BH_TRANGTHAI = trangThai;
	}
	

}
