package com.enjoyxstudy.mybatis.postgresql.typehandler.list;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

public class ListTypeHandlerTest {

    @Test
    public void test() throws IOException {

        String resource = "com/enjoyxstudy/mybatis/postgresql/typehandler/list/list-test.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        try (SqlSession session = sqlSessionFactory.openSession()) {

            ListMapper mapper = session.getMapper(ListMapper.class);

            mapper.createTable();

            ListRecord record = ListRecord.builder()
                    .booleans(Arrays.asList(true, false, true))
                    .shorts(Arrays.asList((short) 0, (short) 1))
                    .integers(Arrays.asList(1, 2, 3))
                    .longs(Arrays.asList(1L, 2L))
                    .floats(Arrays.asList(0.1f, 0.2f, 0.3f))
                    .doubles(Arrays.asList(0.2, 0.3))
                    .strings(Arrays.asList("あ", "A"))
                    .build();

            mapper.insert(record);

            ListRecord result = mapper.select();

            assertThat(result).isEqualTo(record);

            mapper.dropTable();
        }

    }

}
