package test;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMybatis {

    public static void main(String[] args) throws IOException {
        // 读取配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("classpath:sqlMapConfig.xml");
        // 通过SqlSessionFactoryBuilder创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        // 获取到SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 调用Mapper中的指定方法 com.wyh.mapper.UserMapper.queryAll是statementId
        List<BIConversion.User> userList = sqlSession.selectList("com.wyh.mapper.UserMapper.queryAll");
        System.out.println(userList);
    }

}
