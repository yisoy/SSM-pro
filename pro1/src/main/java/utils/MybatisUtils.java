package utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author LY
 * @create 2022-04-16 20:44
 */
public class MybatisUtils {
    public static SqlSession createSqlSession(){
        try {
            String resource = "mybatis-config.xml";

            InputStream is = Resources.getResourceAsStream(resource);

            SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(is);

            SqlSession sqlSession = ssf.openSession();

            return sqlSession;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
