package ctu.cit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Authorize {

	public static Boolean authRoleAdmin(String authStrings, Connection conn) throws Exception {
		String[] authStringPart = authStrings.split("\\s+");
		String authString = authStringPart[1];
		Project project = new Project();
		Boolean access = false;
		TaiKhoan account = project.GetTaiKhoan(conn, authString);
		if (account != null) {

			if (account.getLoaiTaiKhoan().equals("QL")) {
				access = true;
			}
		}
		return access;
	}

	public static Boolean authRoleModify(String authStrings, Connection conn) throws Exception {
		String[] authStringPart = authStrings.split("\\s+");
		String authString = authStringPart[1];
		Project project = new Project();
		Boolean access = false;
		TaiKhoan account = project.GetTaiKhoan(conn, authString);
		if (account != null) {
			String role = account.getLoaiTaiKhoan();

			if ((role.equals("QL")) || (role.equals("KT"))) {
				access = true;
			}
		}
		return access;
	}

	public static Boolean authRoleView(String authStrings, Connection conn) throws Exception {
		String[] authStringPart = authStrings.split("\\s+");
		String authString = authStringPart[1];
		Project project = new Project();
		Boolean access = false;
		TaiKhoan account = project.GetTaiKhoan(conn, authString);
		if (account != null) {
			access = true;
		}
		return access;
	}
}
