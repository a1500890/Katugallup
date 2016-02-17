package katugallup.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import katugallup.model.Kysymys;
import katugallup.model.dao.DataAccessObject;

public class KysymysDAO extends DataAccessObject {

	
	
	public void addKysymys(Kysymys kysymys) throws SQLException {
		Connection connection = null;
		PreparedStatement stmtInsert = null;
	

		try {
			connection = getConnection();
			String sqlInsert = "INSERT INTO kysymys(kysymys_id, Kysymysteksti) VALUES (?, ?)";
			stmtInsert = connection.prepareStatement(sqlInsert);
			stmtInsert.setInt(1, kysymys.getId());
			stmtInsert.setString(2, kysymys.getKysymysteksti());
			stmtInsert.executeUpdate();
		}catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			close(stmtInsert, connection); 
		}
		}
	
	public ArrayList<Kysymys> findAll() {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Kysymys> kysymykset = new ArrayList<Kysymys>();
		Kysymys kysymys=null;
		try {
			conn = getConnection();
			String sqlSelect ="SELECT kysymys_id, Kysymysteksti FROM kysymys;";
			stmt=conn.prepareStatement(sqlSelect);
			rs=stmt.executeQuery(sqlSelect);
			while(rs.next()) {
				kysymys = readKysymys(rs);
				kysymykset.add(kysymys);
			}
		} catch(SQLException e) {
			throw new RuntimeException(e);
		} finally {
			close(rs,stmt,conn);
		}
		
		return kysymykset;
	}
	private Kysymys readKysymys(ResultSet rs) {
		try {
			int id=rs.getInt("Kysymys_id");
			String kysymysteksti=rs.getString("Kysymysteksti");
			return new Kysymys(id, kysymysteksti);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
