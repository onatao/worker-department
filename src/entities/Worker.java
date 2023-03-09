package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.WorkerLevel;

public class Worker {
	
	private String name;
	private WorkerLevel level;
	private Double baseSalary;
	
	private Department department;
	private List<HourContract> contracts = new ArrayList<>();
	
	public Worker() {
		
	}
	
	public Worker(String name, WorkerLevel level, double baseSalary, Department department) {
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.department = department;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public WorkerLevel getLevel() {
		return this.level;
	}
	
	public void setLevel(WorkerLevel level) {
		this.level = level;
	}
	
	public Double getSalary() {
		return this.baseSalary;
	}
	
	public void setSalary(Double salary) {
		this.baseSalary = salary;
	}
	
	public Department getDepartment() {
		return this.department;
	}
	
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	public List<HourContract> getContract() {
		return this.contracts;
	}
	
	public void addContract(HourContract contract) {
		contracts.add(contract);
	}
	
	public void removeContract(HourContract contract) {
		contracts.remove(contract);
	}
	
	public Double income(int year, int month) {
		Double sum = baseSalary;
		// Instacia um obj Calendar
		Calendar cal = Calendar.getInstance();
		
		for (HourContract c: contracts) {
			int c_year  = cal.get(Calendar.YEAR); // Define a data de c com base no Calendar
			int c_month = cal.get(Calendar.MONTH); // Define a data de c com base no Calendar
			
			if (year == c_year && month == c_month) {
				sum+=c.totalValue();
			}
		}
		
		return sum;
	}
}	

	
