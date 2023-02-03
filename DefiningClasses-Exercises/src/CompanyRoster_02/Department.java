package CompanyRoster_02;

import java.util.List;

public class Department {
   String departmentName;
   List<Employee> employeeList;

   public void setDepartmentName(String departmentName) {
      this.departmentName = departmentName;
   }

   public void setEmployeeList(List<Employee> employeeList) {
      this.employeeList = employeeList;
   }

   public String getDepartmentName() {
      return departmentName;
   }

   public List<Employee> getEmployeeList() {
      return employeeList;
   }
}
