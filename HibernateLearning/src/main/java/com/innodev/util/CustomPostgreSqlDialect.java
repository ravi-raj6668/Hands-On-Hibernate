package com.innodev.util;

import org.hibernate.dialect.PostgreSQL94Dialect;
import org.hibernate.type.descriptor.sql.SqlTypeDescriptor;
import org.hibernate.type.descriptor.sql.VarcharTypeDescriptor;

import java.sql.Types;

public class CustomPostgreSqlDialect extends PostgreSQL94Dialect {

    @Override
    public SqlTypeDescriptor remapSqlTypeDescriptor(SqlTypeDescriptor sqlTypeDescriptor) {
        return switch (sqlTypeDescriptor.getSqlType()) {
            case Types.CLOB, Types.BLOB, 1111 -> VarcharTypeDescriptor.INSTANCE;
            default -> super.remapSqlTypeDescriptor(sqlTypeDescriptor);
        };
    }

    public CustomPostgreSqlDialect() {
        super();
        registerHibernateType(1111, "string");
    }
}


