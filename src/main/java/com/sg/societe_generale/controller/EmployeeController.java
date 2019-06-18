package com.sg.societe_generale.controller;

/**
 * @author Sangram Badi
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sg.societe_generale.bo.EmployeeBo;
import com.sg.societe_generale.model.Employee;
import com.sg.societe_generale.utils.ConstantsUtil;

@RestController
@RequestMapping("/api/emp")
public class EmployeeController {
	
	@Autowired
	private EmployeeBo employeeBo;
	
	/**
	 * @param emp
	 * @return ResponseEntity<Map<String, Object>>
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> create(@RequestBody Employee emp) {
		Map<String, Object> rsMap = new HashMap<>();
		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
		
		try {
			rsMap = employeeBo.createEmployee(emp);
			if(rsMap.get("message").equals(ConstantsUtil.SUCCESS)) {
				status = HttpStatus.OK;
			} else if(rsMap.get("message").equals(ConstantsUtil.BADREQUEST)) {
				status = HttpStatus.BAD_REQUEST;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<Map<String, Object>>(rsMap, status);
	}
	
	/**
	 * @return ResponseEntity<List<Employee>>
	 */
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<Employee>> findAll() {
		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
		List<Employee> list = new ArrayList<>();
		
		try {
			list = employeeBo.getAll();
			status = HttpStatus.OK;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<List<Employee>>(list, status);
	}

}
