package basicExe.service;

import basicExe.domain.*;

import static basicExe.service.Data.*;

/**
 * @Auther: lxz
 * @Date: 2020/3/16 0016
 * @Description:负责将Data中的数据封装到Employee[]中
 */
public class NameListService {

    private Employee[] employees;

    /**
     * @Description 根据Data类构建相应的数组
     *              再根据数据构建不同的对象
     **/
    public NameListService() {
        employees = new Employee[EMPLOYEES.length];

        for (int i = 0; i < employees.length; i++) {
            //获取类型
            int type = Integer.parseInt(EMPLOYEES[i][0]);
            //获取Employee的四个基本信息
            int id = Integer.parseInt(EMPLOYEES[i][1]);
            String name = EMPLOYEES[i][2];
            int age = Integer.parseInt(EMPLOYEES[i][3]);
            double salary = Double.parseDouble(EMPLOYEES[i][4]);

            Equipment equipment = null;
            double bonus;
            int stock;

            switch (type) {
                case EMPLOYEE:
                    employees[i] = new Employee(id, name, age, salary);
                    break;
                case PROGRAMMER:
                    equipment = createEquipment(i);
                    employees[i] = new Programmer(id, name, age, salary, equipment);
                    break;
                case DESIGNER:
                    equipment = createEquipment(i);
                    bonus = Double.parseDouble(EMPLOYEES[i][5]);
                    employees[i] = new Designer(id, name, age, salary, equipment, bonus);
                    break;
                case ARCHITECT:
                    equipment = createEquipment(i);
                    bonus = Double.parseDouble(EMPLOYEES[i][5]);
                    stock = Integer.parseInt(EMPLOYEES[i][6]);
                    employees[i] = new Architect(id, name, age, salary, equipment, bonus, stock);
                    break;

            }
        }
    }

    /**
     * @param index: 设备索引
     * @Description: 获取指定位置的员工设备
     * @create: 2020/3/16 0016 14:25
     * @return: Equipment
     */

    private Equipment createEquipment(int index) {

        int type = Integer.parseInt(EQUIPMENTS[index][0]);
        switch (type) {

            case PC:
                return new PC(EQUIPMENTS[index][1], EQUIPMENTS[index][2]);
            case NOTEBOOK:
                return new NoteBook(EQUIPMENTS[index][1], Double.parseDouble(EQUIPMENTS[index][2]));
            case PRINTER:
                return new Printer(EQUIPMENTS[index][1], EQUIPMENTS[index][2]);
        }

        return null;
    }

    /**
    * @Description: 获取所有员工
    * @create: 2020/3/16 0016 14:39
    * @return: Employee[]
    */
    public Employee[] getAllEmployees() {
        return employees;
    }

    //获取指定id的员工
    public Employee getEmployee(int id) throws TeamException {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getId() == id){
                return employees[i];
            }
        }
        throw  new TeamException("找不到指定员工");
    }
}
