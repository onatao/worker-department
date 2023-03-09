package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat spdf = new SimpleDateFormat("dd/MM/yyyy"); 
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Departamento: ");
		String department = scan.nextLine();
		System.out.println("Dados do trabalhador ");
		System.out.println("Nome: ");
		String name = scan.next();
		System.out.println("Level: ");
		String level = scan.next();
		System.out.println("Salário Base: ");
		Double salary = scan.nextDouble();

		Worker worker = new Worker(name,
				WorkerLevel.valueOf(level), salary, new Department(department));
		
		System.out.println("Quantos contratos serão atribuídos? ");
		int n = scan.nextInt();
		
		for (int i = 1; i <= n; i++) {
			System.out.println("Contrato #" + i + " ");
			System.out.println("Data (DD/MM/AAAA): ");
			Date contractDate = spdf.parse(scan.next());
			System.out.println("Valor por hora: ");
			double valuePerHour = scan.nextDouble();
			System.out.println("Duração do contrato (horas)");
			int hours = scan.nextInt();
			
			HourContract contract = new HourContract(contractDate, valuePerHour, hours);
			worker.addContract(contract);
		}
		
		System.out.println("Insira o mês e o ano para calcular o valor (MM/AAAA)");
		String monthAndYear = scan.next();
		int month = Integer.parseInt(monthAndYear.substring(0,2));
		int year = Integer.parseInt(monthAndYear.substring(3));
		
		System.out.println("Nome: " + worker.getName());
		System.out.println("Departamento: " + worker.getDepartment().getName());
		System.out.print("Valor total: " + worker.income(year, month));
		

		scan.close();
		
	}
}