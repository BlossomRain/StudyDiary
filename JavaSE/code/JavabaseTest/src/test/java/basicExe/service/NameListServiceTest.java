package basicExe.service;

import basicExe.domain.Employee;
import org.junit.Test;

/**
 * @Auther: lxz
 * @Date: 2020/3/16 0016
 * @Description: 测试basicExer的NamelistService
 */
public class NameListServiceTest {

    @Test
    public void getAllEmployees() {
        NameListService service = new NameListService();
        Employee[] employees = service.getAllEmployees();
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i]);
        }
    }

    @Test
    public void getEmployee() {
        NameListService service = new NameListService();
        Employee employee = null;
        try {
            employee = service.getEmployee(17);
            System.out.println(employee);
        } catch (TeamException e) {
            e.getMessage();
        }
    }
}