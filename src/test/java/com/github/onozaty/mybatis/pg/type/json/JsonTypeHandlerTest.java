package com.github.onozaty.mybatis.pg.type.json;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.github.onozaty.mybatis.pg.type.TestUtils;

/**
 * @author onozaty
 */
public class JsonTypeHandlerTest {

    @Test
    public void test() throws IOException {

        try (SqlSession session = TestUtils.createSession(this.getClass(), "json-test.xml")) {

            JsonMapper mapper = session.getMapper(JsonMapper.class);

            mapper.createTable();

            JsonRecord record = new JsonRecord(2, new JsonData(20, "hoge"));
            mapper.insert(record);

            JsonRecord result = mapper.select();

            assertThat(result).isEqualTo(record);

            mapper.dropTable();
        }
    }

    @Test
    public void testNull() throws IOException {

        try (SqlSession session = TestUtils.createSession(this.getClass(), "json-test.xml")) {

            JsonMapper mapper = session.getMapper(JsonMapper.class);

            mapper.createTable();

            JsonRecord jsonRecord = new JsonRecord(2, null);
            mapper.insert(jsonRecord);

            JsonRecord result = mapper.select();

            assertThat(result).isEqualTo(jsonRecord);

            mapper.dropTable();
        }
    }
}
