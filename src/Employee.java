
public class Employee {

    private int id;
    private String name;
    private String surname;
    private String lastname;
    private int department;
    private int salary;
    private static int counter = 1;

    public Employee(String name, String surname, String lastname, int department, int salary) {
        this.id = counter;
        this.name = name;
        this.surname = surname;
        this.lastname = lastname;
        this.department = department;
        this.salary = salary;
        counter++;
    }

    @Override
    public String toString() {
        return "Работник:" +
                "id = " + id +
                ", ФИО: " + name + " " + surname + " " + lastname +
                ", Отдел: " + department +
                ", Зарплата: " + salary
                ;
    }

    public String toStringWithoutDepartment() {  //В задании написано, что надо вывести все данные, КРОМЕ отдела.
        return "Работник:" +
                "id = " + id +
                ", ФИО: " + name + " " + surname + " " + lastname +
                ", Зарплата: " + salary
                ;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getLastname() {
        return lastname;
    }

    public int getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    public void setDepartment(int department) {
        if (department < 1 || department > 5) {
            System.out.println("Invalid department (1-5): " + department);
            return;
        }
        this.department = department;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
