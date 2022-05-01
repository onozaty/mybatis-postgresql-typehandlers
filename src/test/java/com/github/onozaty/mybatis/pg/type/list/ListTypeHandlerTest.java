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
