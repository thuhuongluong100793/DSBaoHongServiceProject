package ctu.cit;

public class KhachHang {
	private String KH_MA;
	private String KH_TEN;
	private String KH_SDT;
	private String KH_DIACHI;
	
	//Get
	public String getMaKhachHang (String maKhachHang)
	{
		return KH_MA;
	}
	public String getTenKhachHang (String tenKhachHang)
	{
		return KH_TEN;
	}
	public String getSDT (String sdt)
	{
		return KH_SDT;
	}
	public String getDiaChi (String diaChi)
	{
		return KH_DIACHI;
	}
	//Set
	public void setTenKhachHang (String tenKhachHang)
	{
		this.KH_TEN = tenKhachHang;
	}
	public void setMaKhachHang (String maKhachHang)
	{
		this.KH_MA = maKhachHang;
	}
	public void setSDT (String sdt)
	{
		this.KH_SDT = sdt;
	}
	public void setDiaChi (String diaChi)
	{
		this.KH_DIACHI = diaChi;
	}

}
