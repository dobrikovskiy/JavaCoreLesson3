import java.util.Arrays;

class Employee {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    // Метод для сравнения двух дат без использования условного оператора
    public static int compareDates(int year1, int month1, int day1, int year2, int month2, int day2) {
        return (year1 - year2) * 365 + (month1 - month2) * 30 + (day1 - day2);
    }

    @Override
    public String toString() {
        return name + " (Salary: " + salary + ")";
    }
}

class Manager extends Employee {
    public Manager(String name, double salary) {
        super(name, salary);
    }

    // Статический метод для повышения зарплаты всем сотрудникам, кроме руководителей
    public static void raiseSalaries(Employee[] employees, double percentage) {
        for (Employee employee : employees) {
            if (!(employee instanceof Manager)) {
                double newSalary = employee.getSalary() * (1 + percentage / 100);
                employee.setSalary(newSalary);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[5];
        employees[0] = new Employee("Alice", 50000);
        employees[1] = new Employee("Bob", 60000);
        employees[2] = new Manager("Charlie", 80000);
        employees[3] = new Employee("David", 55000);
        employees[4] = new Manager("Eve", 90000);

        System.out.println("Before salary raise:");
        System.out.println(Arrays.toString(employees));

        // Повышаем зарплату всем сотрудникам на 10%
        Manager.raiseSalaries(employees, 10);

        System.out.println("After salary raise:");
        System.out.println(Arrays.toString(employees));

        // Пример сравнения дат
        int comparisonResult = Employee.compareDates(2023, 10, 1, 2023, 10, 2);
        System.out.println("Date comparison result: " + comparisonResult); // -1 (первый меньше второго)
    }
}