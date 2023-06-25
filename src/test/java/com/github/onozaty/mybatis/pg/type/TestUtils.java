package com.github.onozaty.mybatis.pg.type;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * @author onozaty
 */
public class TestUtils {

    public static SqlSession createSession(Class<?> clazz, String name) throws IOException {

        try (InputStream inputStream = clazz.getResourceAsStream(name)) {

            String dbhost = System.getProperty("dbhost");
            if (dbhost == null || dbhost == "") {
                dbhost = "localhost";
            }

            Properties properties = new Properties();
            properties.setProperty("dbhost", dbhost);

            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream, properties);
            return sqlSessionFactory.openSession();
        }
    }
}
