package edu.eci.arem.springAWS.Repositories;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.eci.arem.springAWS.Models.Entity;



@Component
public class DataBaseRepository implements IDataBaseRepository {
	
	
	@Autowired
	private DataSource dataSource;
	
	@Override
	public List<Entity> query() throws SQLException {
		String query = "TODO: QUERY";
		List<Entity> entities = new ArrayList<Entity>();
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				Entity entity = new Entity();
				entities.add(entity);
			}
			connection.close();
			return entities;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new RuntimeException(e);
		}
	
	}
}