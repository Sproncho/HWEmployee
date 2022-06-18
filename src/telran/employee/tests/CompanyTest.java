package telran.employee.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.employee.dao.Company;
import telran.employee.dao.CompanyImpl;
import telran.employee.model.Employee;
import telran.employee.model.Manager;
import telran.employee.model.SalesManager;
import telran.employee.model.WageEmployee;

class CompanyTest {
	Company company;
	Employee[] firm;

	@BeforeEach
	void setUp() throws Exception {
		company = new CompanyImpl(5);
		firm = new Employee[4];
		firm[0] = new Manager(1000, "John", "Smith", 182, 20_000, 20);
		firm[1] = new WageEmployee(2000, "Mary", "Smith", 182, 40);
		firm[2] = new SalesManager(3000, "Peter", "Jackson", 182, 40_000, 0.1);
		firm[3] = new SalesManager(4000, "Tigran", "Petrosian", 91, 80_000, 0.1);
		for (int i = 0; i < firm.length; i++) {
			company.addEmployee(firm[i]);
		}
	}

	@Test
	void testAddEmployee() {
		assertFalse(company.addEmployee(firm[3]));
		Employee employee = new SalesManager(5000, "Peter", "Jackson", 182, 40_000, 0.1);
		assertTrue(company.addEmployee(employee));
		assertEquals(5, company.size());
		employee = new SalesManager(6000, "Peter", "Jackson", 182, 40_000, 0.1);
		assertFalse(company.addEmployee(employee));
	}

	@Test
	void testRemoveEmployee() {
		assertEquals(firm[0],company.removeEmployee(1000));;
		assertEquals(3,company.size());
	}

	@Test
	void testFindEmployee() {
		assertEquals(firm[0],company.findEmployee(1000));
		assertNull(company.findEmployee(123));
		company.removeEmployee(1000);
		assertNull(company.findEmployee(1000));
	}

	@Test
	void testTotalSalary() {
		Company company1 = new CompanyImpl(2);
		company1.addEmployee(new WageEmployee(1,"vasya","pupkin",2,40));
		company1.addEmployee(new WageEmployee(2,"vasya","pupkin",2,40));
		assertEquals(160,company1.totalSalary());
	}

	@Test
	void testAverageSalary() {
		Company company1 = new CompanyImpl(2);
		company1.addEmployee(new WageEmployee(1,"vasya","pupkin",2,40));
		company1.addEmployee(new WageEmployee(2,"vasya","pupkin",2,40));
		assertEquals(80,company1.averageSalary());
	}

	@Test
	void testTotalSales() {
		assertEquals(120000,company.totalSales());
	}

	@Test
	void testSize() {
		assertEquals(4, company.size());
	}


	//как тестировать воид метод?
	@Test
	void testPrintEmployees() {
		fail("Not yet implemented");
	}

}
