
public class Employee {

    int id;
    String name;
    String surname;
    String lastname;
    int department;
    int salary;

    public Employee(String name, String surname, String lastname, int department, int salary) {
        this.id = Main.counter;
        this.name = name;
        this.surname = surname;
        this.lastname = lastname;
        this.department = department;
        this.salary = salary;
        Main.counter++;
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
    public String toStringWithoutDepartment() {
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
