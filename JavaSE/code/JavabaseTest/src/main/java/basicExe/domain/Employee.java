package basicExe.domain;

/**
 * @Auther: lxz
 * @Date: 2020/3/16 0016
 * @Description:
 */
public class Employee {
    private int id;
    private String name;
    private int age;
    private double salary;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Employee(int id, String name, int age, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getDetails(){
        return id + "\t" + name + " \t" + age + "\t" + salary;
    }

    @Override
    public String toString() {
        return getDetails();
    }

    public Employee() {
    }
}
