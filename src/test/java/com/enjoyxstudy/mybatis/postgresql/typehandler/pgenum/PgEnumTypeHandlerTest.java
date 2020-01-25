package com.enjoyxstudy.mybatis.postgresql.typehandler.pgenum;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.enjoyxstudy.mybatis.postgresql.typehandler.TestUtils;

/**
 * @author onozaty
 */
public class PgEnumTypeHandlerTest {

    @Test
    public void test() throws IOException {

        try (SqlSession session = TestUtils.createSession(this.getClass(), "pgenum-test.xml")) {

            PgEnumMapper mapper = session.getMapper(PgEnumMapper.class);

            mapper.createTable();

            PgEnumRecord record = new PgEnumRecord(2, Day.WEDNESDAY);
            mapper.insert(record);

            PgEnumRecord result = mapper.select();

            assertThat(result).isEqualTo(record);

            mapper.dropTable();
        }
    }

    @Test
    public void testNull() throws IOException {

        try (SqlSession session = TestUtils.createSession(this.getClass(), "pgenum-test.xml")) {

            PgEnumMapper mapper = session.getMapper(PgEnumMapper.class);

            mapper.createTable();

            PgEnumRecord record = new PgEnumRecord(2, null);
            mapper.insert(record);

            PgEnumRecord result = mapper.select();

            assertThat(result).isEqualTo(record);

            mapper.dropTable();
        }
    }

}
