package com.enjoyxstudy.mybatis.postgresql.typehandler.list;

import java.sql.Array;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

/**
 * @author onozaty
 */
public abstract class ListTypeHandler<T> extends BaseTypeHandler<List<T>> {

    private final String arrayType;

    public ListTypeHandler(String arrayType) {
        this.arrayType = arrayType;
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, List<T> parameter, JdbcType jdbcType)
            throws SQLException {

        ps.setArray(i, ps.getConnection().createArrayOf(arrayType, parameter.toArray(new Object[parameter.size()])));
    }

    @Override
    public List<T> getNullableResult(ResultSet rs, String columnName) throws SQLException {

        return toList(rs.getArray(columnName));
    }

    @Override
    public List<T> getNullableResult(ResultSet rs, int columnIndex) throws SQLException {

        return toList(rs.getArray(columnIndex));
    }

    @Override
    public List<T> getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {

        return toList(cs.getArray(columnIndex));
    }

    @SuppressWarnings("unchecked")
    private List<T> toList(Array value) throws SQLException {

        if (value == null) {
            return null;
        }

        return Arrays.asList((T[]) value.getArray());
    }
}
