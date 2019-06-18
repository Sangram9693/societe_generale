package com.sg.societe_generale.bo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sg.societe_generale.dao.IEmployeeDao;
import com.sg.societe_generale.model.Employee;
import com.sg.societe_generale.utils.ConstantsUtil;
import com.sg.societe_generale.utils.StringUtils;

/**
 * @author <b>Sangram Badi</b>
 * @since 2019-06-12 07:51pm
 * 
 * Class use to serve the business logic
 */
@Service
public class EmployeeBo {

	@Autowired
	private IEmployeeDao employeeDao;
	
	/**
	 * @param emp
	 * @return Map<String, Object>
	 * 
	 * <p>Takes employee modal to save in database. 
	 * It will check fields are emity or not, 
	 * if field is empty then it will return to controller.</p>
	 */
	public Map<String, Object> createEmployee(Employee emp) {
		Map<String, Object> rsMap = new HashMap<>();
		rsMap.put("message", ConstantsUtil.FALED);
		
		try {
			
			if(!StringUtils.isValid(emp.getFirstName())) {
				rsMap.put("info", "First name should have atleast 3 characters");
				rsMap.put("message", ConstantsUtil.BADREQUEST);
				return rsMap;
			}
			
			if(!StringUtils.isValid(emp.getLastName())) {
				rsMap.put("info", "Last name should have atleast 3 characters");
				rsMap.put("message", ConstantsUtil.BADREQUEST);
				return rsMap;
			}
			
			if(!StringUtils.isValid(emp.getGender())) {
				rsMap.put("info", "Gender is required");
				rsMap.put("message", ConstantsUtil.BADREQUEST);
				return rsMap;
			}
			
			if(!StringUtils.isValid(emp.getDob().toString())) {
				rsMap.put("info", "Date of birth is required");
				rsMap.put("message", ConstantsUtil.BADREQUEST);
				return rsMap;
			}
			
			if(!StringUtils.isValid(emp.getDepartment())) {
				rsMap.put("info", "Department should have atleast 3 characters");
				rsMap.put("message", ConstantsUtil.BADREQUEST);
				return rsMap;
			}
			
			Employee e = employeeDao.save(emp);
			if(e != null) {
				rsMap.put("message", ConstantsUtil.SUCCESS);
				rsMap.put("info", e);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return rsMap;
	}
	
	/**
	 * @return List<Employee>
	 * 
	 * <p>In Repository layer it is using a custome query to filter Employee in assending order</p>
	 */
	public List<Employee> getAll() {
		List<Employee> emps = new ArrayList<>();
		
		try {
			emps = employeeDao.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return emps;
	}
	
}
