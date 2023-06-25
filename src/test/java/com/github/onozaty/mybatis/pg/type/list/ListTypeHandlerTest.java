package com.github.onozaty.mybatis.pg.type.list;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.util.Arrays;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.github.onozaty.mybatis.pg.type.TestUtils;

public class ListTypeHandlerTest {

    @Test
    public void test() throws IOException {

        try (SqlSession session = TestUtils.createSession(this.getClass(), "list-test.xml")) {

            ListMapper mapper = session.getMapper(ListMapper.class);

            mapper.createTable();

            ListRecord record = ListRecord.builder()
                    .id(1)
                    .booleans(Arrays.asList(Boolean.FALSE, Boolean.TRUE, null))
                    .shorts(Arrays.asList(null, Short.MIN_VALUE, Short.MAX_VALUE))
                    .integers(Arrays.asList(Integer.MIN_VALUE, Integer.MAX_VALUE, null))
                    .longs(Arrays.asList(null, Long.MIN_VALUE, Long.MAX_VALUE))
                    .floats(Arrays.asList(Float.MIN_VALUE, Float.MAX_VALUE, null))
                    .doubles(Arrays.asList(Double.MIN_VALUE, Double.MAX_VALUE, null))
                    .strings(Arrays.asList("あ", "A", "", null))
                    .build();

            mapper.insert(record);

            ListRecord result = mapper.select();

            assertThat(result).isEqualTo(record);

            mapper.dropTable();
        }
    }

    @Test
    public void testNull() throws IOException {

        try (SqlSession session = TestUtils.createSession(this.getClass(), "list-test.xml")) {

            ListMapper mapper = session.getMapper(ListMapper.class);

            mapper.createTable();

            ListRecord record = ListRecord.builder()
                    .id(2)
                    .build();

            mapper.insert(record);

            ListRecord result = mapper.select();

            assertThat(result).isEqualTo(record);

            mapper.dropTable();
        }
    }

}
