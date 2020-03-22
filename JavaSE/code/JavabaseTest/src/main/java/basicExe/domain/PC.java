package basicExe.domain;

/**
 * @Auther: lxz
 * @Date: 2020/3/16 0016
 * @Description:
 */
public class PC implements Equipment {

    private String model;   //机器型号
    private String display; //显示器名称

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public PC() {
    }

    public PC(String model, String display) {
        this.model = model;
        this.display = display;
    }

    @Override
    public String getDescription() {
        return model + "(" + display + ")";
    }
}
