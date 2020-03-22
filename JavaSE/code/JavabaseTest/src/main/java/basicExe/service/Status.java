package basicExe.service;

/**
 * @Auther: lxz
 * @Date: 2020/3/16 0016
 * @Description:表示员工的状态
 */
public class Status {

    private final String NAME;

    private Status(String NAME) {
        this.NAME = NAME;
    }

    public String getNAME() {
        return NAME;
    }

    public static final Status FREE = new Status("FREE");
    public static final Status BUSY = new Status("BUSY");
    public static final Status VOCATION = new Status("VOCATION");

    @Override
    public String toString() {
        return NAME;
    }
}
