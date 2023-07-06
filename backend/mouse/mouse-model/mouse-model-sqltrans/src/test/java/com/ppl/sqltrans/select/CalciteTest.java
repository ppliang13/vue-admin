package com.ppl.sqltrans.select;

import org.apache.calcite.config.Lex;
import org.apache.calcite.sql.SqlDialect;
import org.apache.calcite.sql.SqlNode;
import org.apache.calcite.sql.parser.SqlParseException;
import org.apache.calcite.sql.parser.SqlParser;
import org.apache.calcite.sql.util.SqlString;
import org.junit.Test;

/**
 * Created by pisiliang on 2023/7/6 10:09
 */
public class CalciteTest {

    @Test
    public void testSql() throws SqlParseException {

        String sql = "SELECT * FROM myTable WHERE id = 1";

        SqlParser parser = SqlParser.create(sql);
        SqlNode sqlNode = parser.parseQuery();

        // 将SqlNode对象转换为JSON字符串

    }

    @Test
    public void jsonToSql() throws SqlParseException {
        String sql = "SELECT * FROM myTable WHERE id = 1";
        SqlParser parser2 = SqlParser.create(sql);
        SqlNode sqlNode2 = parser2.parseQuery();
        String json = sqlNode2.toString();

        System.out.println("json = " + json);
        // 设置解析器配置
        SqlParser.Config config = SqlParser.configBuilder()
                .setLex(Lex.MYSQL)
                .build();

        SqlParser parser = SqlParser.create(json, config);
        SqlNode sqlNode = parser.parseQuery();

        // 设置所使用的 SQL 方言，例如 MySQL
        SqlDialect dialect = SqlDialect.DatabaseProduct.MYSQL.getDialect();

        SqlString sqlString = sqlNode.toSqlString(dialect);
        System.out.println(sqlString.getSql());
    }

}
