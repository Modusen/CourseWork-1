public class Main {
    public static int counter = 1;
    public static Employee[] arr = new Employee[10];
    public static int overallSalary = 0;

    public static void main(String[] args) {


        arr[0] = new Employee("Сергей", "Сергеевич", "Сергеев", 1, 10000);
        arr[1] = new Employee("Иван", "Иванович", "Иванов", 4, 10000);
        arr[2] = new Employee("Дмитрий", "Дмитриевич", "Дмитриев", 3, 20000);
        arr[3] = new Employee("Константин", "Константинович", "Константинов", 5, 40000);
        arr[4] = new Employee("Ольга", "Сергеевна", "Соколова", 2, 1000);
        arr[5] = new Employee("Елена", "Владимировна", "Воробьева", 4, 60000);
        arr[6] = new Employee("Светлана", "Леонидовна", "Летова", 1, 50000);
        arr[7] = new Employee("Семен", "Сергеевич", "Лютоев", 3, 700000);
        arr[8] = new Employee("Ирина", "Александровна", "Ливнева", 2, 30000);
        arr[9] = new Employee("Павел", "Ибдурахманович", "Фамильев", 5, 90000);

        typeEmployeeList();


        System.out.println("Общая месячная зарплата: " + getOverallSalaryPerMonth());

        getAndPrintMinimumSalary();

        getAndPrintMaximumSalary();

        getAndPrintAverageSalary();

        getAndPrintFullNameList();
    }

    public static void typeEmployeeList() {
        for (int i = 0; i < 10; i++) {
            System.out.println(arr[i]);
        }
    }

    public static int getOverallSalaryPerMonth() {

        for (int i = 0; i < arr.length; i++) {
            overallSalary += arr[i].getSalary();
        }
        return overallSalary;
    }

    public static void getAndPrintMinimumSalary() {
        int minSalary = arr[0].getSalary();
        for (int i = 0; i < arr.length; i++) {
            if (minSalary > arr[i].getSalary()) {
                minSalary = arr[i].getSalary();
            }
        }
        System.out.println("Минимальная зарплата: " + minSalary);
    }

    public static void getAndPrintMaximumSalary() {
        int maxSalary = arr[0].getSalary();
        for (int i = 0; i < arr.length; i++) {
            if (maxSalary < arr[i].getSalary()) {
                maxSalary = arr[i].getSalary();
            }
        }
        System.out.println("Максимальная зарплата: " + maxSalary);
    }

    public static void getAndPrintAverageSalary() {
        int averageSalary = overallSalary / arr.length;
        System.out.println("Среднее значение зарплаты: " + averageSalary);
    }

    public static void getAndPrintFullNameList() {
        for (int i = 0; i < 10; i++) {
            System.out.println(arr[i].getName() + " " + arr[i].getSurname() + " " + arr[i].getLastname());
        }
    }


}