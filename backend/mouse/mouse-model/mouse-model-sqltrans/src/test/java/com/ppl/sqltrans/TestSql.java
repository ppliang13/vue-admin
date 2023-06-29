package com.ppl.sqltrans;

import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.expression.*;
import net.sf.jsqlparser.expression.operators.conditional.OrExpression;
import net.sf.jsqlparser.expression.operators.relational.EqualsTo;
import net.sf.jsqlparser.expression.operators.relational.GreaterThan;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.schema.Table;
import net.sf.jsqlparser.statement.select.*;
import net.sf.jsqlparser.util.SelectUtils;
import net.sf.jsqlparser.util.deparser.ExpressionDeParser;
import net.sf.jsqlparser.util.deparser.LimitDeparser;
import net.sf.jsqlparser.util.deparser.SelectDeParser;
import net.sf.jsqlparser.util.deparser.StatementDeParser;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pisiliang on 2023/6/28 10:40
 */

public class TestSql {

    /**
     * 测试单表查询
     * select * from
     * @throws JSQLParserException 转换异常
     */
    @Test
    public void testCreateSelect1 () throws JSQLParserException {
        Table studentTable = new Table("student");
        Table teacherTable = new Table("teacher");

        EqualsTo joinCondition = new EqualsTo();
        joinCondition.setLeftExpression(new Column("student.age"));
        joinCondition.setRightExpression(new Column("teacher.age"));

        Join join = new Join();
        join.setRightItem(teacherTable);
        join.setOnExpression(joinCondition);



        PlainSelect select = new PlainSelect()
                .addSelectItems(new SelectExpressionItem(new Column("student.name")).withAlias(new Alias("studentName")))
                .addJoins(join)
                .withFromItem(studentTable);


        System.out.println("Generated PlainSelect object: " + select.toString());

    }

    @Test
    public void testCount(){
        PlainSelect plainSelect = new PlainSelect();
        List<SelectItem> selectItems = new ArrayList<>();
        Table studentTable = new Table("student");
        // 添加 SelectItem 到列表中
        selectItems.add(new SelectExpressionItem(new Column("COUNT(*)")));


        StringBuilder builder = new StringBuilder();
        Offset offset = new Offset();
        offset.setOffset(10);




        StringBuilder buffer = new StringBuilder();
        ExpressionDeParser expressionDeParser = new ExpressionDeParser();


        PostgresLimitDeparser limitDeparser = new PostgresLimitDeparser(buffer);

        SelectDeParser deparser = new SelectDeParser( expressionDeParser,buffer);
        expressionDeParser.setSelectVisitor(deparser);
        expressionDeParser.setBuffer(buffer);

        plainSelect.accept(deparser);

        Limit limit = new Limit();
        limit.setRowCount(new LongValue(10));
        limit.setOffset(new LongValue(0));
        plainSelect.setLimit(limit);
        limitDeparser.deParse(limit);

        System.out.println(plainSelect.toString());
    }


    private String toSQL(PlainSelect plainSelect) {
        System.out.println("expression = " + plainSelect);
        return plainSelect.toString();
    }


    @Test
    public void replace() throws JSQLParserException {
        String sql ="SELECT NAME, ADDRESS, COL1 FROM USER WHERE SSN IN ('11111111111111', '22222222222222') limit 1000;";
        Select select = (Select) CCJSqlParserUtil.parse(sql);

//Start of value modification
        StringBuilder buffer = new StringBuilder();
        ExpressionDeParser expressionDeParser = new ExpressionDeParser() {

            @Override
            public void visit(StringValue stringValue) {
                this.getBuffer().append("XXXX");
            }

        };
        SelectDeParser deparser = new SelectDeParser(expressionDeParser,buffer);
        expressionDeParser.setSelectVisitor(deparser);
        expressionDeParser.setBuffer(buffer);

        select.getSelectBody().accept(deparser);
        //End of value modification
        

        System.out.println(buffer.toString());
//Result is: SELECT NAME, ADDRESS, COL1 FROM USER WHERE SSN IN (XXXX, XXXX)
    }


}

