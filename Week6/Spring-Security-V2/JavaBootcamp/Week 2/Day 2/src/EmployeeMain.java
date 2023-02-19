public class EmployeeMain {
    public static void main(String[] args) {
        Employee e1 = new Employee("1", "abdulaziz", 7000);

        System.out.println("information of the first Employee: \n" + e1.toString());
        System.out.println("the annual salary: " + e1.getAnnualSalary());
        System.out.println("the salary after the raise" + e1.raisedSalary(30));

    }
}
