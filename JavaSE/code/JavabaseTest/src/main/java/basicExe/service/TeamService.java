package basicExe.service;

import basicExe.domain.Architect;
import basicExe.domain.Designer;
import basicExe.domain.Employee;
import basicExe.domain.Programmer;

/**
 * @Auther: lxz
 * @Date: 2020/3/16 0016
 * @Description:关于开发团队成员的管理,添加,删除
 */
public class TeamService {

    private static int counter = 1;     //团队成员id
    private final int MAX_MENBER = 5;   //最大成员数
    private Programmer[] team = new Programmer[MAX_MENBER];
    private int total = 0;              //成员实际人数

    public TeamService() {
    }

    /**
     * @Description: 获取开发团队中的所有成员
     * @create: 2020/3/16 0016 17:51
     * @return: Programmer[]
     */
    public Programmer[] getTeam() {
        Programmer[] team = new Programmer[total];
        for (int i = 0; i < team.length; i++) {
            team[i] = this.team[i];
        }
        return team;
    }

    /**
     * @param e: 员工
     * @Description: 添加指定的员工
     * @create: 2020/3/16 0016 17:54
     * @return: void
     */
    public void addMember(Employee e) throws TeamException {
        //添加失败的情况
        //成员已满
        if (total >= MAX_MENBER) throw new TeamException("成员已满,无法添加");
        //不是程序员
        if (!(e instanceof Programmer)) throw new TeamException("不是程序员,无法添加");
        //已经存在
        if (isExist(e)) throw new TeamException("已经存在,无法添加");
        //已是某团队成员 或者 正在休假
        Programmer p = (Programmer) e;
        if ("BUSY".equals(p.getStatus().getNAME())) throw new TeamException("已是某团队成员,无法添加");
        else if ("VOCATION".equals(p.getStatus().getNAME())) throw new TeamException("正在休假,无法添加");
        //至多一名架构师,两名设计师,三名程序员
        //获取数目
        int archNum = 0, desNum = 0, proNum = 0;
        for (int i = 0; i < total; i++) {
            if (team[i] instanceof Architect) archNum++;
            else if (team[i] instanceof Designer) desNum++;
            else if (team[i] instanceof Programmer) proNum++;
        }

        //这样是不可以的,因为进入第一个if不满足后还会进入第二个if
        /*if (p instanceof Architect && archNum >= 1) throw new TeamException("架构师多于1名,无法添加");
        else if (p instanceof Designer && desNum >= 2) throw new TeamException("设计师多于2名,无法添加");
        else if (p instanceof Programmer && proNum >= 3) throw new TeamException("程序员多于3名,无法添加");*/

        if (p instanceof Architect)
            if (archNum >= 1)
                throw new TeamException("架构师多于1名,无法添加");
            else if (p instanceof Designer)
                if (desNum >= 2)
                    throw new TeamException("设计师多于2名,无法添加");
                else if (p instanceof Programmer)
                    if (proNum >= 3)
                        throw new TeamException("程序员多于3名,无法添加");

        //可以添加
        team[total++] = p;
        p.setStatus(Status.BUSY);
        p.setMemberId(counter++);
    }

    /**
     * @param e:
     * @Description: 判断制定员工是否存在于数组中
     * @create: 2020/3/16 0016 18:03
     * @return: boolean
     */
    private boolean isExist(Employee e) {
        for (int i = 0; i < total; i++) {
            if (team[i].getId() == (e).getId()) return true;
        }
        return false;
    }

    public void removeMember(int memberId) throws TeamException {
        int i;
        for (i = 0; i < total; i++) {
            if (team[i].getMemberId() == memberId) {
                team[i].setStatus(Status.FREE);
                break;
            }
        }
        if (i == total) throw new TeamException("未找到指定位置");

        //前移,覆盖
        for (int j = i + 1; j < total; j++) {
            team[j - 1] = team[j];
        }

        team[--total] = null;
    }
}
