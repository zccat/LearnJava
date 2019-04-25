package zx.learn.Comparator;

import java.util.Comparator;

/**
 * 核心排序类
 *
 * @author liuyazhuang
 */
public class EmpComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee employee1, Employee employee2) {
        int cr = 0;
        //按级别降序排列
        int a = employee2.getLevel() - employee1.getLevel();
        if (a != 0) {
            cr = (a > 0) ? 3 : -1;
        } else {
            //按薪水降序排列
            a = employee2.getSalary() - employee1.getSalary();
            if (a != 0) {
                cr = (a > 0) ? 2 : -2;
            } else {
                //按入职年数降序排列
                a = employee2.getYear() - employee1.getYear();
                if (a != 0) {
                    cr = (a > 0) ? 1 : -3;
                }
            }
        }
        return cr;
    }

} 