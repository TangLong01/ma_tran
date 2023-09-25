public class Sep09Exam2 {
    static abstract class Employee {
        String name, birthday;

        Employee(String name, String birthday) {
            this.name = name;
            this.birthday = birthday;
        }
    }
    
    class FactoryEmployee extends Employee {
        int products;
        final double BASIC_SALARY = 4000000;
        final int BONUS_PER_PRODUCT = 5000;

        FactoryEmployee(String name, String birthday, int products) {
            super(name, birthday);
            this.products = products;
        }

        double totalSalary() {
            return BASIC_SALARY + products * BONUS_PER_PRODUCT;
        }
    }

    class OfficeEmployee extends Employee {
        int totalWorkday;
        final int SALARY_PER_DAY = 100000;

        OfficeEmployee(String name, String birthday, int totalWorkday) {
            super(name, birthday);
            this.totalWorkday = totalWorkday;
        }

        double totalSalary() {
            return totalWorkday * SALARY_PER_DAY;
        }
    }

    public static void main(String[] args) {
        FactoryEmployee Alice = new Sep09Exam2().new FactoryEmployee("Alice", "15/07/1985", 100);
        OfficeEmployee Dave = new Sep09Exam2().new OfficeEmployee("Dave", "12/02/1987", 25);

        System.out.printf("Lương của Alice là: " + Alice.totalSalary());
        System.out.println();
        System.out.printf("Lương của Dave là: " + Dave.totalSalary());
    }
}
