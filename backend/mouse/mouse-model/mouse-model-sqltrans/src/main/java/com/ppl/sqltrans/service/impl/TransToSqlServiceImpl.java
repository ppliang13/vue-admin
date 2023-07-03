package com.ppl.sqltrans.service.impl;

import com.ppl.sqltrans.service.TransToSqlService;
import jdk.nashorn.internal.parser.JSONParser;
import net.sf.jsqlparser.expression.Alias;
import net.sf.jsqlparser.expression.LongValue;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.schema.Table;
import net.sf.jsqlparser.statement.select.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by pisiliang on 2023/6/30 10:37
 */
@Service
public class TransToSqlServiceImpl implements TransToSqlService {


    @Override
    public String toSql(PlainSelect plainSelect) {

        return plainSelect.toString();
    }



    public String toSql2() {
        PlainSelect plainSelect = new PlainSelect();
        Table studentTable = new Table("student");

        ArrayList<SelectItem> selectItems = new ArrayList<>();
        /**
         * 查询所有字段
         */
        selectItems.add(new SelectExpressionItem(new AllColumns()));
        /**
         * 字段设置别名
         */
        selectItems.add(new SelectExpressionItem(new Column("count(1)")).withAlias(new Alias("count")));
        /**
         * 表.字段设置别名
         */
        selectItems.add(new SelectExpressionItem(new Column(studentTable, "count(1)")).withAlias(new Alias("count")));
        Offset offset = new Offset();
        offset.setOffset(new LongValue(10));

        Limit limit = new Limit();
        limit.setRowCount(new LongValue(10));
        plainSelect.withSelectItems(selectItems).withFromItem(studentTable).withOffset(offset).withLimit(limit);
        SelectVisitorAdapter selectVisitorAdapter = new SelectVisitorAdapter() {
            @Override
            public void visit(PlainSelect plainSelect) {
                super.visit(plainSelect);

            }
        };
        plainSelect.accept(selectVisitorAdapter);
        String sql = plainSelect.toString();

        return sql;
    }
}
