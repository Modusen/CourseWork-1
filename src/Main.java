import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static Employee[] employeeBook = new Employee[10];
    public static int overallSalary = 0;
    public static int maxSalary;
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static int department;
    public static int indexSalaryInDepartment;

    public static int salarySorting;

    public static void main(String[] args) throws IOException {

//Basic level

        employeeBook[0] = new Employee("Сергей", "Сергеевич", "Сергеев", 1, 10000);
        employeeBook[1] = new Employee("Иван", "Иванович", "Иванов", 4, 10000);
        employeeBook[2] = new Employee("Дмитрий", "Дмитриевич", "Дмитриев", 3, 20000);
        employeeBook[3] = new Employee("Константин", "Константинович", "Константинов", 5, 40000);
        employeeBook[4] = new Employee("Ольга", "Сергеевна", "Соколова", 2, 1000);
        employeeBook[5] = new Employee("Елена", "Владимировна", "Воробьева", 4, 60000);
        employeeBook[6] = new Employee("Светлана", "Леонидовна", "Летова", 1, 50000);
        employeeBook[7] = new Employee("Семен", "Сергеевич", "Лютоев", 3, 700000);
        employeeBook[8] = new Employee("Ирина", "Александровна", "Ливнева", 2, 30000);
        employeeBook[9] = new Employee("Павел", "Ибдурахманович", "Фамильев", 5, 90000);

        printEmployeeList(); //было TYPE (глагол) Employee List = НАПЕЧАТАТЬ список сотрудников

        System.out.println("Общая месячная зарплата: " + getOverallSalaryPerMonth());

        printMinimumSalaryWorker();

        printMaximumSalaryWorker();

        printAverageSalary();

        printFullNameList();

//Medium level

        System.out.println("Введите процент (от -100 до 100), на который необходимо проиндексировать зарплату:"); //например, так?

        indexSalaryForAll();

        System.out.println("Общая месячная зарплата c индексацией: " + getOverallSalaryPerMonth());

        System.out.println("Введите номер отдела от 1 до 5:");
        department = Integer.parseInt(reader.readLine());

        printMinimumSalaryInDepartment();

        printMaximumSalaryInDepartment();

        System.out.println("Общая сумма затрат на зарплату по отделу: " + getOverallSalaryInDepartment());

        System.out.println("Средняя зарплата по отделу: " + getAverageSalaryInDepartment());

        System.out.println("Введите процент (от -100 до 100), на который индексировать зарплату по отделу:");
        indexSalaryInDepartment = Integer.parseInt(reader.readLine());
        indexSalaryInDepartmentAndPrintEmployeeWithoutDepartmentNumber();

        System.out.println("Введите зарплату (любое int число) для сортировки сотрудников:");
        salarySorting = Integer.parseInt(reader.readLine());
        salarySorting();

// Advanced level Task#6
        System.out.println("\n" + "Сортируем сотрудников по отделам." + "\n");

        findAndPrintEmployeeByDepartment();
        reader.close();
    }

    public static void printEmployeeList() { //было TYPE (глагол) Employee List = НАПЕЧАТАТЬ список сотрудников
        for (int i = 0; i < 10; i++) {
            System.out.println(employeeBook[i]);
        }
    }

    public static int getOverallSalaryPerMonth() {
        overallSalary = 0;
        for (int i = 0; i < employeeBook.length; i++) {
            if (employeeBook[i] != null) {
                overallSalary += employeeBook[i].getSalary();
            } else {
                throw new RuntimeException("Сотрудника не существует"); /*не уверен насчет корректности и необходимости
                 вывода этоко эксепшна, поэтому дальше просто буду вводить проверку работника на null*/
            }
        }
        return overallSalary;
    }

    public static void printMinimumSalaryWorker() {
        int minSalary = employeeBook[0].getSalary();
        String minimumSalaryWorker = "";
        for (int i = 0; i < employeeBook.length; i++) {
            if (employeeBook[i] != null) {
                if (minSalary > employeeBook[i].getSalary()) {
                    minSalary = employeeBook[i].getSalary();
                    minimumSalaryWorker = employeeBook[i].toString();
                }
            }
        }
        System.out.println("Минимальная зарплата: " + minimumSalaryWorker);
    }

    public static void printMaximumSalaryWorker() {
        maxSalary = employeeBook[0].getSalary();
        String maxSalaryWorker = "";
        for (int i = 0; i < employeeBook.length; i++) {
            if (maxSalary < employeeBook[i].getSalary()) {
                maxSalary = employeeBook[i].getSalary();
                maxSalaryWorker = employeeBook[i].toString();
            }
        }
        System.out.println("Максимальная зарплата: " + maxSalaryWorker);
    }

    public static void printAverageSalary() {
        System.out.println("Среднее значение зарплаты: " + overallSalary / employeeBook.length);
    }

    public static void printFullNameList() {
        for (int i = 0; i < employeeBook.length; i++) {
            System.out.println(employeeBook[i].getName() + " " + employeeBook[i].getSurname() + " " + employeeBook[i].getLastname());
        }
    }

    public static void indexSalaryForAll() throws IOException {
        int salaryIndexation = Integer.parseInt(reader.readLine());
        for (int i = 0; i < employeeBook.length; i++) {
            employeeBook[i].setSalary(employeeBook[i].getSalary() + employeeBook[i].getSalary() * salaryIndexation / 100);
        }
    }

    public static void printMaximumSalaryInDepartment() {
        int maxDepartmentSalary = 0;
        int i = 0;
        while (i < employeeBook.length) {
            if (employeeBook != null) {
                if (department == employeeBook[i].getDepartment()) {
                    if (maxDepartmentSalary < employeeBook[i].getSalary()) {
                        maxDepartmentSalary = employeeBook[i].getSalary();
                    }
                }
            }
            i++;
        }
        System.out.println("Максимальная зарплата в отделе: " + maxDepartmentSalary);
    }

    public static void printMinimumSalaryInDepartment() {
        int i = 0;
        int minDepartmentSalary = employeeBook[0].getSalary();
        while (i < employeeBook.length) {
            if (employeeBook != null) {
                if (department == employeeBook[i].getDepartment()) {
                    if (minDepartmentSalary > employeeBook[i].getSalary()) {
                        minDepartmentSalary = employeeBook[i].getSalary();
                    }
                }
            }
            i++;
        }
        System.out.println("Минимальная зарплата в отделе: " + minDepartmentSalary);
    }

    public static int getOverallSalaryInDepartment() {
        int i = 0;
        int overallSalaryInDepartment = 0;
        while (i < employeeBook.length) {
            if (employeeBook != null) {
                if (department == employeeBook[i].getDepartment()) {

                    overallSalaryInDepartment += employeeBook[i].getSalary();
                }
            }
            i++;
        }
        return overallSalaryInDepartment;
    }

    public static int getAverageSalaryInDepartment() {
        int i = 0;
        int counter = 0;
        int overallSalaryInDepartment = 0;
        while (i < employeeBook.length) {
            if (employeeBook != null) {
                if (department == employeeBook[i].getDepartment()) {

                    overallSalaryInDepartment += employeeBook[i].getSalary();
                    counter++;
                }
            }
            i++;
        }
        return overallSalaryInDepartment / counter;
    }

    public static void indexSalaryInDepartmentAndPrintEmployeeWithoutDepartmentNumber() {
        int i = 0;
        int salaryInDepartment = 0;
        while (i < employeeBook.length) {
            if (department == employeeBook[i].getDepartment()) {

                employeeBook[i].setSalary(employeeBook[i].getSalary() + employeeBook[i].getSalary() * indexSalaryInDepartment / 100);
                System.out.println(employeeBook[i].toStringWithoutDepartment());
            }
            i++;
        }
    }

    public static void salarySorting() {
        System.out.println("\n" + "Зарплта больше или равна " + salarySorting + " у следующих работников:" + "\n");
        for (int i = 0; i < employeeBook.length; i++) {
            if (salarySorting <= employeeBook[i].getSalary()) {
                System.out.println(employeeBook[i].toStringWithoutDepartment());
            }
        }
        System.out.println("\n" + "Зарплта меньше " + salarySorting + " у следующих работников:" + "\n");
        for (int i = 0; i < employeeBook.length; i++) {
            if (salarySorting > employeeBook[i].getSalary()) {
                System.out.println(employeeBook[i].toStringWithoutDepartment());
            }
        }
    }// честно говоря, не понял сути замечания) по-моему достаточно просто написано:) вроде ж работает, вроде ж достаточно шустро считает :)


    public static void findAndPrintEmployeeByDepartment() {
        int f;
        for (int i = 1; i < 6; i++) {
            System.out.println("В отделе №" + i + " работают следующие сотрудники: ");
            for (f = 0; f < employeeBook.length; f++) {
                if (employeeBook[f].getDepartment() == i) {
                    System.out.print(employeeBook[f].getName() + " " + employeeBook[f].getLastname());
                    break;
                }
            }
            for (int j = f + 1; j < employeeBook.length; j++) {
                if (employeeBook[j].getDepartment() == i) {
                    System.out.print(", " + employeeBook[j].getName() + " " + employeeBook[j].getLastname());
                }
            }
            System.out.println(".");
        }
    }

}