package ctu.cit;
import java.sql.Connection;
import java.util.ArrayList;


public class ProjectManager {
	public ArrayList<BaoHong> GetBaoHong()throws Exception {
		ArrayList<BaoHong> baoHong = null;
		try {
			DbConnection database= new DbConnection();
			Connection connection = database.GetConnection();
			Project project= new Project();
			baoHong = project.GetBaoHong(connection);
		}
		catch (Exception e) {
			throw e;
		}
		return baoHong;
	}
}
