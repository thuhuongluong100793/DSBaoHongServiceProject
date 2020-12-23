package ctu.cit;

public class TaiKhoan {
	private String TK_TENDANGNHAP;
	private String TK_MATKHAU;
	private String TK_LOAI;
	
	//Get
	public String getTenDangNhap (String tenDangNhap)
	{
		return TK_TENDANGNHAP;
	}
	public String getTenDangNhap ()
	{
		return TK_TENDANGNHAP;
	}
	public String getMatKhau (String matKhau)
	{
		return TK_MATKHAU;
	}
	public String getMatKhau ()
	{
		return TK_MATKHAU;
	}
	public String getLoaiTaiKhoan (String loaiTaiKhoan)
	{
		return TK_LOAI;
	}
	public String getLoaiTaiKhoan ()
	{
		return TK_LOAI;
	}
	//Set
	public void setTenDangNhap (String tenDangNhap)
	{
		this.TK_TENDANGNHAP = tenDangNhap;
	}
	public void setMatKhau (String matKhau)
	{
		this.TK_MATKHAU = matKhau;
	}
	public void setLoaiTaiKhoan (String loaiTaiKhoan)
	{
		this.TK_LOAI = loaiTaiKhoan;
	}

}
