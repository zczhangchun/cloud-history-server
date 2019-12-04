package com.zhangchun.history.server.typehandlers;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.*;

/**
 * @author zhangchun
 */
public class DateTypeHandler implements TypeHandler<Long> {


    @Override
    public void setParameter(PreparedStatement ps, int i, Long parameter, JdbcType jdbcType) throws SQLException {


        ps.setTimestamp(i,new Timestamp(parameter));

    }

    @Override
    public Long getResult(ResultSet rs, String columnName) throws SQLException {
        Date date = rs.getDate(columnName);
        return date.getTime();
    }

    @Override
    public Long getResult(ResultSet rs, int columnIndex) throws SQLException {
        Date date = rs.getDate(columnIndex);
        return date.getTime();
    }

    @Override
    public Long getResult(CallableStatement cs, int columnIndex) throws SQLException {
        Date date = cs.getDate(columnIndex);
        return date.getTime();
    }
}
