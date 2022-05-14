package test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import com.study.mybatis.pojo.Customer;
import utils.MybatisUtils;

import java.io.InputStream;
import java.util.List;

/**
 * @author LY
 * @create 2022-04-16 20:02
 */
public class MybatisTest {
    @Test
    //测试查询相应id的某条数据
    public void findCustomerByIdTest() throws Exception{
        String resource = "mybatis-config.xml";

        InputStream is = Resources.getResourceAsStream(resource);

        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(is);

        SqlSession sqlSession = ssf.openSession();

        Customer customer = sqlSession.selectOne("mapper.CustomerMapper.findCustomerById", 1);

        System.out.println(customer.toString());

        sqlSession.close();

    }

    @Test
    //将创建sqlSession方法封装到MybatisUtils工具类
    public void findCustomerByIdTest1() {

        SqlSession sqlSession = MybatisUtils.createSqlSession();

        Customer customer = sqlSession.selectOne("mapper.CustomerMapper.findCustomerById", 1);

        System.out.println(customer.toString());

        sqlSession.close();

    }

    @Test
    //测试查询表中所有
    public void findAllCustomerByIdTest() throws Exception{

        SqlSession sqlSession = MybatisUtils.createSqlSession();

        List<Customer> customer = sqlSession.selectList("mapper.CustomerMapper.findAllCustomerById");

        for(Customer cust :customer){
            System.out.println(cust);
        }

        sqlSession.close();

    }

    @Test
    //测试添加数据到数据库
    public void addCustomerByIdTest(){

        SqlSession sqlSession = MybatisUtils.createSqlSession();

        Customer customer1 = new Customer("yisoy","student","12345678910");


        int num = sqlSession.insert("mapper.CustomerMapper.addCustomer",customer1);

        System.out.println(num);

//        sqlSession.commit();

        sqlSession.close();

    }

    @Test
    //测试添加数据到数据库
    public void findAllUserTest(){

        SqlSession sqlSession = MybatisUtils.createSqlSession();

        Customer customer1 = new Customer(4,"jackson","student","12345678910");


        int num = sqlSession.update("mapper.CustomerMapper.updateCustomer",customer1);

        System.out.println("更新了"+num+"条数据");

//        sqlSession.commit();

        sqlSession.close();

    }
}
