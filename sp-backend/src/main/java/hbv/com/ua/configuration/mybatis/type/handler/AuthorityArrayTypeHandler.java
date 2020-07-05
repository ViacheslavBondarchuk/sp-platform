package hbv.com.ua.configuration.mybatis.type.handler;

import hbv.com.ua.model.Authority;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * author: viacheslavbondarchuk
 * date: 7/4/20
 * time: 9:42 PM
 **/
public class AuthorityArrayTypeHandler extends BaseTypeHandler<Collection<Authority>> {

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Collection<Authority> authorities, JdbcType jdbcType) throws SQLException {
        preparedStatement.setArray(i, (Array) authorities);
    }

    @Override
    public Collection<Authority> getNullableResult(ResultSet resultSet, String s) throws SQLException {
        return this.createAuthorities(resultSet.getArray(s).getArray());
    }

    @Override
    public Collection<Authority> getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return this.createAuthorities(resultSet.getArray(i).getArray());
    }

    @Override
    public Collection<Authority> getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return this.createAuthorities(callableStatement.getArray(i).getArray());
    }

    protected Collection<Authority> createAuthorities(Object o) {
        final String[] authoritiesString = (String[]) o;
        if (authoritiesString.length > 0) {
            Collection<Authority> authorityCollection = new ArrayList<>();
            for (String s : authoritiesString) {
                authorityCollection.add(Enum.valueOf(Authority.class, s));
            }
            return authorityCollection;
        }
        return null;
    }
}
