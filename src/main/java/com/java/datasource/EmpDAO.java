package com.java.datasource;

import java.util.List;

public interface EmpDAO {
	public void insert(Employee e);
	public List<Employee> fetch();
	public void update(Employee e);
	public void delete(Employee e);
}
