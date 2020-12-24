package ctu.cit;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Authorize {

	public static Boolean authorAdmin(String user, String pass, Connection conn) throws SQLException {
		Boolean access = false;
		TaiKhoan account = Authorize.getUser(user, conn);
		if (account != null) {
			if (pass.equals(account.getMatKhau())) {
				if (account.getLoaiTaiKhoan().equals("QL")) {
					access = true;
				}
			}
		}
		System.out.println("AuthorAdmin " + access);
		return access;

	}
	
	public static Boolean authorAdmin(String decode, Connection conn) throws SQLException {
		String user="", pass="";
		Boolean access = false;
		String[] tmp = decode.split(":");
		user = tmp[0];
		pass = tmp[1];
		TaiKhoan account = Authorize.getUser(user, conn);
		if (account != null) {
			if (pass.equals(account.getMatKhau())) {
				if (account.getLoaiTaiKhoan().equals("QL")) {
					access = true;
				}
			}
		}
		System.out.println("AuthorAdmin " + access);
		return access;

	}


	public static Boolean authorView(String user, String pass, Connection conn) throws SQLException {
		Boolean access = false;
		TaiKhoan account = Authorize.getUser(user, conn);
		if (account != null) {
			if (pass.equals(account.getMatKhau())) {
				access = true;
			}
		}
		System.out.println("AuthorView " + access);
		return access;

	}
	
	public static Boolean authorView(String decode, Connection conn) throws SQLException {
		String user = "", pass = "";
		Boolean access = false;
		String[] tmp = decode.split(":");
		user = tmp[0];
		pass = tmp[1];
		TaiKhoan account = Authorize.getUser(user, conn);
		if (account != null) {
			if (pass.equals(account.getMatKhau())) {
				access = true;
			}
		}
		System.out.println("AuthorView " + access);
		return access;

	}

	public static Boolean authorModify(String user, String pass, Connection conn) throws SQLException {

		Boolean access = false;
		TaiKhoan account = Authorize.getUser(user, conn);
		if (account != null) {
			if (pass.equals(account.getMatKhau())) {
				if ((account.getLoaiTaiKhoan().equals("QL")) || (account.getLoaiTaiKhoan().equals("KT"))) {
					access = true;
				}
			}
		}
		System.out.println("AuthorModify " + access);
		return access;

	}
	
	public static Boolean authorModify(String decode, Connection conn) throws SQLException {
		String user="", pass="";
		String[] tmp = decode.split(":");
		user = tmp[0];
		pass = tmp[1];
		Boolean access = false;
		TaiKhoan account = Authorize.getUser(user, conn);
		if (account != null) {
			if (pass.equals(account.getMatKhau())) {
				if ((account.getLoaiTaiKhoan().equals("QL")) || (account.getLoaiTaiKhoan().equals("KT"))) {
					access = true;
				}
			}
		}
		System.out.println("AuthorModify " + access);
		return access;

	}
	

	public static TaiKhoan getUser(String user, Connection conn) throws SQLException {
		TaiKhoan account = null;
		String sql = "SELECT A.TK_MATKHAU, A.TK_LOAI FROM taikhoan A WHERE TK_TENDANGNHAP =\"" + user + "\"; ";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);

		while (rs.next()) {
			account = new TaiKhoan();
			account.setMatKhau(rs.getString("TK_MATKHAU"));
			account.setLoaiTaiKhoan(rs.getString("TK_LOAI"));

		}

		return account;
	}

}
