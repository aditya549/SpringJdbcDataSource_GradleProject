package com.java.datasource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class EmpDAOImpl implements EmpDAO {
	private DataSource datasource;
	
	public DataSource getDatasource() {
		return datasource;
	}

	public void setDatasource(DataSource datasource) {
		this.datasource = datasource;
	}

	public void insert(Employee e) {
		try {
		Connection con=datasource.getConnection();
		PreparedStatement pstmt=con.prepareStatement("insert into springdatasource(username,password,email,id) values(?,?,?,?)");
		pstmt.setString(1, e.getUsername());
		pstmt.setString(2, e.getPassword());
		pstmt.setString(3, e.getEmail());
		pstmt.setString(4, e.getId());
		int i=pstmt.executeUpdate();
		if(i==1) {
			System.out.println("Insert Success");
		}else
			System.out.println("Insert fail");
		}
		catch (Exception exp) {
			System.out.println(exp);
		}	
	}

	public List<Employee> fetch() {
		List<Employee> ls=new ArrayList<Employee>();
		try {
			Connection con=datasource.getConnection();
			PreparedStatement pstmt=con.prepareStatement("select * from springdatasource");
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				Employee e=new Employee();
				e.setUsername(rs.getString("username"));
				e.setPassword(rs.getString("password"));
				e.setEmail(rs.getString("email"));
				e.setId(rs.getString("id"));
				ls.add(e);
			}
			System.out.println(ls);
		}catch (Exception e) {
			System.out.println(e);
		}
		return ls;
	}

	public void update(Employee e) {
		
		try {
			Connection con=datasource.getConnection();
			PreparedStatement pstmt=con.prepareStatement("update springdatasource set email=? where username=?");
			pstmt.setString(1, e.getEmail());
			pstmt.setString(2, e.getUsername());
			int i=pstmt.executeUpdate();
			if(i==1) {
				System.out.println("Update Success");
			}else
				System.out.println("Update fail");
			}
			catch (Exception exp) {
				System.out.println(exp);
			}
	}

	public void delete(Employee e) {
		try {
			Connection con=datasource.getConnection();
			PreparedStatement pstmt=con.prepareStatement("delete from springdatasource where username=?");
			pstmt.setString(1, e.getUsername());
			int i=pstmt.executeUpdate();
			if(i==1) {
				System.out.println("Delete Success");
			}else
				System.out.println("Delete fail");
			}
			catch (Exception exp) {
				System.out.println(exp);
			}
	}
}
