package application;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Enter department's name: ");
        String departmentName = sc.nextLine();
        System.out.println("Enter worker data: ");
        System.out.println("Name: ");
        String workerName = sc.nextLine();
        System.out.println("Level: ");
        String workerLevel = sc.nextLine();
        System.out.println("Base Salary: ");
        double baseSalary = sc.nextDouble();
        Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel),baseSalary,new Department(departmentName));
        System.out.println();
        System.out.print("How many contract for this worker?: ");
        int n = sc.nextInt();
        for(int i = 1; i <= n; i++) {
            System.out.println("Enter contract #" +i+ " data:");
            System.out.print("Date: ");
            Date contractDate = sdf.parse(sc.next());
            System.out.print("Value per hour");
            double valuePerHour = sc.nextDouble();
            System.out.print("Duration (hours): ");
            double hour = sc.nextDouble();
            HourContract contract = new HourContract(contractDate, valuePerHour, hour);
            worker.addContract(contract);
        }
        System.out.println();
        System.out.println("Enter month and year to calculate income (MM/yyyy): ");
        String monthAndYear = sc.next();
        int month = Integer.parseInt(monthAndYear.substring(0,2));
        int year = Integer.parseInt(monthAndYear.substring(3));
        System.out.println("Name: " + worker.getName());
        System.out.println("Department: " + worker.getDepartment());
        System.out.println("Income for: " + monthAndYear + ": " + worker.income(month, year) );

        sc.close();
    }
}
