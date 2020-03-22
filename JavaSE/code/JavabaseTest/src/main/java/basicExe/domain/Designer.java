package basicExe.domain;

/**
 * @Auther: lxz
 * @Date: 2020/3/16 0016
 * @Description:
 */
public class Designer extends Programmer {

    private double bonus;//奖金

    public Designer() {
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public Designer(int id, String name, int age, double salary, Equipment equipment, double bonus) {
        super(id, name, age, salary, equipment);
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return getDetails() + "\t设计师\t" + getStatus() + "\t" + getBonus() + "\t\t\t" + getEquipment().getDescription();
    }
}
