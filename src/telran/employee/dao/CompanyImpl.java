package telran.employee.dao;

import telran.employee.model.Employee;
import telran.employee.model.SalesManager;

import java.util.Arrays;

public class CompanyImpl implements Company{
	Employee[] employees;
	int size = 0;
	
	public CompanyImpl(int capacity) {
		employees = new Employee[capacity];
	}

	@Override
	public boolean addEmployee(Employee employee) {
		if(size == employees.length)
			return false;
		for (int i = 0; i < size; i++) {
			if(employees[i].getId() == employee.getId()){
				return false;
			}
		}
		employees[size] = employee;
		size++;
		return true;
	}

	@Override
	public Employee removeEmployee(int id) {
		for (int i = 0; i < size; i++) {
			if(employees[i].getId() == id) {
				Employee imp = employees[i];
				employees[i] = employees[size-1];
				employees[size-1] = null;
				size--;
				return imp;
			}
		}
		return null;
	}

	@Override
	public Employee findEmployee(int id) {
		for (int i = 0; i < size; i++) {
			if(employees[i].getId() == id)
				return employees[i];
		}
		return null;
	}

	@Override
	public double totalSalary() {
		double total = 0;
		for (int i = 0; i < size; i++) {
			total += employees[i].calcSalary();
		}
		return total;
	}

	@Override
	public double averageSalary() {
		double sum = totalSalary();
		return sum/size;
	}

	@Override
	public double totalSales() {
		double total = 0;
		for (int i = 0; i < size; i++) {
			if(employees[i] instanceof SalesManager)
				total += ((SalesManager) employees[i]).getSalesValue();
		}
		return total;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void printEmployees() {
		for (int i = 0; i < size; i++) {
			System.out.println(employees[i]);
		}
	}

}
