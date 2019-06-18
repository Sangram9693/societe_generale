package com.sg.societe_generale;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.sg.societe_generale.bo.EmployeeBo;
import com.sg.societe_generale.dao.IEmployeeDao;
import com.sg.societe_generale.model.Employee;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SocieteGeneraleApplicationTests {
	
	@Autowired
	private EmployeeBo service;
	
	@MockBean
	private IEmployeeDao repository;
	
	@Test
	public void getEmployeeTest() {
		when(repository.getAll()).thenReturn(Stream.of(new Employee(1L, "Sangram", "Badi", "Male", new Date(2000, 8, 9), "IT & C")).collect(Collectors.toList()));
		assertEquals(1, service.getAll().size());
	}
	
	@Test
	public void saveUserTest() {
		Employee emp = new Employee(1L, "Sangram", "Badi", "Male", new Date(2000, 8, 9), "IT & C");
		when(repository.save(emp)).thenReturn(emp);
		assertEquals(emp, service.createEmployee(emp).get("info"));
		
	}

}
