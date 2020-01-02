package com.enjoyxstudy.mybatis.postgresql.typehandler.json;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

/**
 * @author onozaty
 */
public class JsonTypeHandlerTest {

    @Test
    public void test() throws IOException {

        String resource = "com/enjoyxstudy/mybatis/postgresql/typehandler/json/test.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        try (SqlSession session = sqlSessionFactory.openSession()) {

            JsonMapper mapper = session.getMapper(JsonMapper.class);

            mapper.createTable();

            User user = new User(10, "taro", new Other(20, "address1"));
            mapper.insert(user);

            User result = mapper.select();

            assertThat(result).isEqualTo(user);

            mapper.dropTable();
        }
    }

}
