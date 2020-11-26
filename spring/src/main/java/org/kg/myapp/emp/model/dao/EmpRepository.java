package org.kg.myapp.emp.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.kg.myapp.emp.model.vo.EmpVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class EmpRepository implements IEmpRepository {

   @Autowired
   JdbcTemplate jdbcTemplate;
   
   //내부클래스
   public class EmpMapper implements RowMapper<EmpVO>{

      @Override
      public EmpVO mapRow(ResultSet rs, int rowNum) throws SQLException {
         EmpVO emp = new EmpVO();
         emp.setEmployeeId(rs.getInt("employee_id"));
         emp.setFirstName(rs.getString("first_name"));
         emp.setLastName(rs.getString(3));
         emp.setEmail(rs.getString(4));
         emp.setPhoneNumber(rs.getString(5));
         emp.setHireDate(rs.getDate(6));
         emp.setJobId(rs.getString(7));
         emp.setSalary(rs.getDouble(8));
         emp.setCommissionPct(rs.getDouble(9));
         emp.setManagerId(rs.getInt(10));
         emp.setDepartmentId(rs.getInt(11));
         
         return emp;
      }
      
      
   }
   //익명클래스
         RowMapper<EmpVO> empMapper = new RowMapper<EmpVO>() {

            @Override
            public EmpVO mapRow(ResultSet rs, int rowNum) throws SQLException {
               EmpVO emp = new EmpVO();
               emp.setEmployeeId(rs.getInt("employee_id"));
               emp.setFirstName(rs.getString("first_name"));
               emp.setLastName(rs.getString(3));
               emp.setEmail(rs.getString(4));
               emp.setPhoneNumber(rs.getString(5));
               emp.setHireDate(rs.getDate(6));
               emp.setJobId(rs.getString(7));
               emp.setSalary(rs.getDouble(8));
               emp.setCommissionPct(rs.getDouble(9));
               emp.setManagerId(rs.getInt(10));
               emp.setDepartmentId(rs.getInt(11));
               
               return emp;
            }
            
         };
   
   @Override
   public int getEmpCount() {
      String sql ="SELECT COUNT(*) FROM employees";
      
      return jdbcTemplate.queryForObject(sql, Integer.class);
   }

   @Override
   public int getEmpCount(int deptId) {
      String sql = "select count(*) from employees where department_id=?";
      
      return jdbcTemplate.queryForObject(sql, Integer.class, deptId);
   }

   @Override
   public List<EmpVO> getEmpList() {
      String sql = "SELECT * FROM employees";
      return jdbcTemplate.query(sql, empMapper);
   }

   @Override
   public EmpVO getEmpInfo(int empId) {
      String sql = "SELECT * FROM employees WHERE employee_id=?";
      return jdbcTemplate.queryForObject(sql, empMapper, empId);
   }

   @Override
   public void updateEmp(EmpVO emp) {
      String sql ="UPDATE employees SET first_name=?, last_name=?,\"\r\n" + 
            "+ \"email=?, phone_number=?, hire_date=?, job_id=?,\"\r\n" + 
            "+ \"salary=?, commission_pct=?, manager_id=?,\"\r\n" + 
            "+ \"department_id=? where employee_id=?";
      
      jdbcTemplate.update(sql,emp.getFirstName(),
            emp.getLastName(),emp.getEmail(),emp.getPhoneNumber(),
            emp.getHireDate(),emp.getJobId(),emp.getSalary(),
            emp.getCommissionPct(),emp.getManagerId(),emp.getDepartmentId(),
            emp.getEmployeeId());
   }

   @Override
   public void insertEmp(EmpVO emp) {
   String sql = "insert into employees "
   + "values(?,?,?,?,?,sysdate,?,?,?,?,?)";
   jdbcTemplate.update(sql,emp.getEmployeeId(),
   emp.getFirstName(),emp.getLastName(),emp.getEmail(),
   emp.getPhoneNumber(),emp.getJobId(),emp.getSalary(),
   emp.getCommissionPct(),emp.getManagerId(),emp.getDepartmentId()
   );

      

   }

   @Override
   public void deleteEmp(int empId) {
      String sql ="DELETE FROM employees WHERE employee_id=?";
      jdbcTemplate.update(sql, empId);

   }

   @Override
   public void deleteJobHistory(int empId) {
      String sql = "delete from job_history where employee_id=?";
      jdbcTemplate.update(sql, empId);

   }

   @Override
   public List<Map<String, Object>> getAllDeptId() {
      String sql = "select department_id as departmentId,"
            + "department_name as departmentName from departments";
            return jdbcTemplate.queryForList(sql);
   }

   @Override
   public List<Map<String, Object>> getAllJobId() {
         String sql = "select job_id as jobId, job_title as jobTitle "
         + "from jobs";
         return jdbcTemplate.queryForList(sql);
   }

   @Override
   public List<Map<String, Object>> getAllManagerId() {
      String sql = "select employee_id as managerId, "
            + "first_name||' '||last_name as managerName "
            + "from employees "
            + "where employee_id in "
            + "(select distinct manager_id from employees)";
            return jdbcTemplate.queryForList(sql);
   }

	@Override
	public List<EmpVO> getSearchList(String name) {
		
		String sql ="SELECT * FROM employees WHERE first_name LIKE ? or last_name LIKE ?";
		return jdbcTemplate.query(sql, empMapper,name,name);
		
	
	}

	//1. 부서 번호 입력 - 해당 부서 사원들 목록으로 조회
	@Override
	public List<EmpVO> getListByDept(int deptId) {
		String sql ="SELECT * FROM employees WHERE department_id = ?";
		
		return jdbcTemplate.query(sql, empMapper, deptId);
	}

	//2. 부서별 최고 급여 받는 사람들 목록으로 조회
	@Override
	public List<EmpVO> getMaxEmployeeByDept() {
		String sql = "SELECT * FROM employees "
				+ "WHERE (department_id, salary) in "
				+ "(SELECT department_id, max(salary) FROM employees group by department_id)";
		return jdbcTemplate.query(sql, empMapper);
	}

   
	
	
   

}