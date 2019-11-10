package di.yang.utils;

import di.yang.enumList.DataSourceEnvironment;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class DataBaseUtil {
    public static SqlSession getSqlSession(String DataBasexml) throws IOException {
        //获取配置的资源文件
        Reader reader = Resources.getResourceAsReader(DataBasexml);
        //得到SqlSessionFactory，使用类加载器加载xml文件
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
        //得到sqlsession对象，这个对象就能执行配置文件中的sql语句啦
        SqlSession session = factory.openSession(true);

        return session;
    }

    public static SqlSession getSqlSession(String DataBasexml, String environment) {
        DataSourceEnvironment environ = DataSourceEnvironment.getEnviron(environment);
        if (null==environment){
            environ = DataSourceEnvironment.ZHANGWU_245;
        }
        Reader readerFrom = null;
        try {
            readerFrom = Resources.getResourceAsReader(DataBasexml);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sessionFactoryFrom = new SqlSessionFactoryBuilder().build(readerFrom,environ.name());
        return sessionFactoryFrom.openSession(true);
    }
}
