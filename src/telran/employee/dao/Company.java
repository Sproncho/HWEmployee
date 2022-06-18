package telran.employee.dao;

import telran.employee.model.Employee;

public interface Company {
	
	boolean addEmployee(Employee employee);

	Employee removeEmployee(int id);

	Employee findEmployee(int id);
	
	double totalSalary();
	
	double averageSalary();
	
	double totalSales();
	
	int size();
	
	void printEmployees();
}
