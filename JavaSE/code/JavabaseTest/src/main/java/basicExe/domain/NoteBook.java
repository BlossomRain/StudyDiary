package basicExe.domain;

/**
 * @Auther: lxz
 * @Date: 2020/3/16 0016
 * @Description:
 */
public class NoteBook implements Equipment {

    private String model;   //机器型号
    private double price;   //价格

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public NoteBook() {
    }

    public NoteBook(String model, double price) {
        this.model = model;
        this.price = price;
    }

    @Override
    public String getDescription() {
        return model + "(" + price + ")";
    }
}
