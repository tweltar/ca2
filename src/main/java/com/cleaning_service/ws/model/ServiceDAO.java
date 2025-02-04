package com.cleaning_service.ws.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ServiceDAO {

	public ArrayList<Service> listAllServices() throws SQLException {
		ArrayList<Service> serviceList = new ArrayList<Service>();
		
		Connection conn = null;
		
		try {
			conn = DBConnection.getConnection();
			
			String sqlStr = "SELECT * FROM services";
			
			PreparedStatement ps = conn.prepareStatement(sqlStr);
			ResultSet rs = ps.executeQuery();
			
			System.out.println("SQL Query Executed: " + sqlStr);
			System.out.println("Connection: " + conn);
			System.out.println("ResultSet: " + rs);
			
			while(rs.next()) {
				Service service = new Service();
				System.out.println("Service Found: " + rs.getString("name"));
				service.setServiceId(rs.getInt("service_id"));
				service.setName(rs.getString("name"));
				service.setDescription(rs.getString("description"));
				service.setPrice(rs.getDouble("price"));
				service.setImgPath(rs.getString("image_path"));
				service.setCategoryId(rs.getInt("category_id"));
				serviceList.add(service);
			}
			
		} catch (Exception e) {
			System.out.print("In ServiceDAO..."+e);		
		} finally {
			conn.close();
		}
		return serviceList;
	}
}
