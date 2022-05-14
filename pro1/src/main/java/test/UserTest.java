package test;

import com.study.mybatis.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import com.study.mybatis.pojo.User;
import utils.MybatisUtils;

import java.util.List;

/**
 * @author LY
 * @create 2022-04-17 22:43
 */
public class UserTest {
    @Test

    public void FindAllUserTest(){

        SqlSession sqlSession = MybatisUtils.createSqlSession();

//        User user = new User();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> list = mapper.findAllUser();

        list.forEach(user -> System.out.println(user));

//        List user1 = sqlSession.selectList("mapper.UserMapper.findAllUser");

//        user1.forEach(System.out::println);

        sqlSession.close();

    }

    @Test
    public void addUserByIdTest(){

        SqlSession sqlSession = MybatisUtils.createSqlSession();

        User user = new User();

        user.setUsername("yisoy");
        user.setPassword("123456");

        int num = sqlSession.insert("mapper.UserMapper.addUserById",user);

        System.out.println("成功插入了" + num + "条数据！");

        sqlSession.commit();

        sqlSession.close();

    }

    @Test
    public void updateInfoByIdTest(){

        SqlSession sqlSession = MybatisUtils.createSqlSession();

        User user = new User(4,"Tom","787878");

        int num = sqlSession.update("mapper.UserMapper.updateInfoById",user);

        System.out.println("成功修改了"+ num +"条数据！");

        sqlSession.commit();

        sqlSession.close();

    }

    @Test
    public void deleteInfoByIdTest(){

        SqlSession sqlSession = MybatisUtils.createSqlSession();

        User user = new User();

        user.setId(4);

        int num = sqlSession.delete("mapper.UserMapper.deleteInfoById",user);

        System.out.println("成功删除了"+ num +"条数据！");

        sqlSession.commit();

        sqlSession.close();

    }
}
