package com.github.onozaty.mybatis.pg.type.json;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author onozaty
 */
public class JsonTypeHandler<T> extends BaseTypeHandler<T> {

    private final ObjectMapper mapper = new ObjectMapper();

    private final Class<T> javaType;

    public JsonTypeHandler(Class<T> javaType) {
        this.javaType = javaType;
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, T parameter, JdbcType jdbcType)
            throws SQLException {

        try {
            ps.setObject(i, mapper.writeValueAsString(parameter), Types.OTHER);
        } catch (JsonProcessingException e) {
            throw new SQLException(e);
        }
    }

    @Override
    public T getNullableResult(ResultSet rs, String columnName) throws SQLException {

        return toJavaTypeObject(rs.getObject(columnName));
    }

    @Override
    public T getNullableResult(ResultSet rs, int columnIndex) throws SQLException {

        return toJavaTypeObject(rs.getObject(columnIndex));
    }

    @Override
    public T getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {

        return toJavaTypeObject(cs.getObject(columnIndex));
    }

    private T toJavaTypeObject(Object value) throws SQLException {

        if (value == null) {
            return null;
        }

        try {
            return mapper.readValue(value.toString(), javaType);
        } catch (IOException e) {
            throw new SQLException(e);
        }
    }
}
