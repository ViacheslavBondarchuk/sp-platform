package hbv.com.ua.configuration.mybatis.handler;

import hbv.com.ua.model.Authority;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorityEnumTypeHandler extends BaseTypeHandler<Authority> {
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Authority authority, JdbcType jdbcType) throws SQLException {
        preparedStatement.setString(i, authority.name());
    }

    @Override
    public Authority getNullableResult(ResultSet resultSet, String s) throws SQLException {
        return Enum.valueOf(Authority.class, resultSet.getString(s));
    }

    @Override
    public Authority getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return Enum.valueOf(Authority.class, resultSet.getString(i));
    }

    @Override
    public Authority getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return Enum.valueOf(Authority.class, callableStatement.getString(i));
    }
}
