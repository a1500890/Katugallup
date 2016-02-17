package katugallup.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import katugallup.model.Vastaus;

public class VastausDAO extends DataAccessObject {
	
	public void addVastaus(Vastaus vastaus) throws SQLException {
		Connection connection = null;
		PreparedStatement stmtInsert = null;
	

		try {
			connection = getConnection();
			String sqlInsert = "INSERT INTO vastaus(vastaus_id, vastausteksti, vastausaika, vastaaja) VALUES (?, ?, ?, ?)";
			stmtInsert = connection.prepareStatement(sqlInsert);
			stmtInsert.setInt(1, vastaus.getId());
			stmtInsert.setString(2, vastaus.getVastausteksti());
			stmtInsert.setString(3, vastaus.getVastausaika());
			stmtInsert.setString(4, vastaus.getVastaaja());
			stmtInsert.executeUpdate();
		}catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			close(stmtInsert, connection); 
		}
		}
	
	public ArrayList<Vastaus> findAll() {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Vastaus> vastaukset = new ArrayList<Vastaus>();
		Vastaus vastaus=null;
		try {
			conn = getConnection();
			String sqlSelect ="SELECT vastaus_id, kysymysteksti FROM kysymys;";
			stmt=conn.prepareStatement(sqlSelect);
			rs=stmt.executeQuery(sqlSelect);
			while(rs.next()) {
				vastaus = readVastaus(rs);
				vastaukset.add(vastaus);
			}
		} catch(SQLException e) {
			throw new RuntimeException(e);
		} finally {
			close(rs,stmt,conn);
		}
		
		return vastaukset;
	}
	private Vastaus readVastaus(ResultSet rs) {
		try {
			int id=rs.getInt("vastaus_id");
			String vastausteksti=rs.getString("vastausteksti");
			String vastausaika=rs.getString("vastausaika");
			String vastaaja=rs.getString("vastaaja");
			return new Vastaus(id, vastausteksti, vastausaika, vastaaja);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}



