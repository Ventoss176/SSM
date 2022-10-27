import com.ventoss.crud.bean.Department;
import com.ventoss.crud.bean.Employee;
import com.ventoss.crud.dao.DepartmentMapper;
import com.ventoss.crud.dao.EmployeeMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

/**
 * Date:2022/7/5
 * Author:Vent
 * Description:
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MapperTest {
    @Autowired
    DepartmentMapper departmentMapper;
    @Autowired
    EmployeeMapper employeeMapper;
    @Autowired
    SqlSession sqlSession;

    @Test
    public void test1(){
        // System.out.println(departmentMapper);
    //     // departmentMapper.insertSelective(new Department(null,"开发部"));
    //     // departmentMapper.insertSelective(new Department(null,"测试部"));
    //
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        for (int i = 0; i < 999; i++) {
            String uid = UUID.randomUUID().toString().substring(0,5) + i;
            mapper.insertSelective(new Employee(null, uid, "M", uid+"@vent.com", new Department(1,"开发部")));

        }
        System.out.println("批量导入完成");
    }
}
