package com.sg.societe_generale.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.sg.societe_generale.model.Employee;

public interface IEmployeeDao extends CrudRepository<Employee, Long>{

	@Query("select e from Employee e order by e.firstName ASC")
	public List<Employee> getAll();
}
