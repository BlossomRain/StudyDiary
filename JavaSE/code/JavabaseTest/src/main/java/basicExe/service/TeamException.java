package basicExe.service;

/**
 * @Auther: lxz
 * @Date: 2020/3/16 0016
 * @Description:自定义异常,用于Employee查找不到的情况
 */
public class TeamException extends Exception {

    static final long serialVersionUID = -33875993124229948L;

    public TeamException(String message) {
        super(message);
    }

    public TeamException() {
    }
}
