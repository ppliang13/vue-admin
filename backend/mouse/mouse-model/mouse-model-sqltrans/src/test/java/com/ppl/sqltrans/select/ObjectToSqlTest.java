package com.ppl.sqltrans.select;


import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;
import net.sf.jsqlparser.expression.Alias;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.LongValue;
import net.sf.jsqlparser.expression.operators.conditional.AndExpression;
import net.sf.jsqlparser.expression.operators.conditional.OrExpression;
import net.sf.jsqlparser.expression.operators.relational.EqualsTo;
import net.sf.jsqlparser.expression.operators.relational.GreaterThan;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.schema.Table;
import net.sf.jsqlparser.statement.select.*;
import org.junit.Test;

import java.util.ArrayList;


/**
 * 对象转换成sql test类
 * Created by pisiliang on 2023/6/30 8:46
 */
public class ObjectToSqlTest {


    /**
     * 查询 字段设置
     * 查询所有字段 *
     * 查询指定字段 column
     * 查询指定字段 column 并设置别名
     * 查询指定字段 column 并设置别名 并设置表名
     */
    @Test
    public void selectCol() {
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
        Limit limit = new Limit();
        limit.setOffset(new LongValue(0));
        limit.setRowCount(new LongValue(10));
        plainSelect.withSelectItems(selectItems).withFromItem(studentTable).setLimit(limit);

        String sql = plainSelect.toString();
        System.out.println(sql);
    }


    /**
     * 查询条件设置
     */
    @Test
    public void selectWhere() throws JsonProcessingException {
        PlainSelect plainSelect = new PlainSelect();
        Table studentTable = new Table("student");

        ArrayList<SelectItem> selectItems = new ArrayList<>();
        /**
         * 查询所有字段
         */
        selectItems.add(new SelectExpressionItem(new AllColumns()));


        Column ageColumn = new Column("age");
        /**
         * 查询条件 左边值 查询条件 右边值
         * @see net.sf.jsqlparser.expression.operators.relational
         * GreaterThan > 大于
         * GreaterThanEquals >= 大于等于
         * MinorThan < 小于
         * MinorThanEquals <= 小于等于
         */
        Expression condition1 = new GreaterThan().withLeftExpression(ageColumn).withRightExpression(new LongValue(18));
        Column sexColumn = new Column("sex");
        Expression condition2 = new EqualsTo(sexColumn, new LongValue(1));

        /**
         * 查询条件 与
         */
        Expression finalCondition = new AndExpression(condition1, condition2);

        /**
         * 查询条件 或
         */
        OrExpression orExpression = new OrExpression(condition1, condition2);

        /**
         * 查询条件 与 或
         */
        AndExpression andExpression = new AndExpression(orExpression, finalCondition);

        plainSelect.withSelectItems(selectItems).withFromItem(studentTable).withWhere(andExpression);
        String sql = plainSelect.toString();
        String jsonString = JSON.toJSONString(plainSelect);


        System.out.println("jsonString = " + jsonString);
        ObjectMapper objectMapper = new ObjectMapper();


       PlainSelect plainSelect1 = objectMapper.readValue(jsonString, PlainSelect.class);
       System.out.println("plainSelect1 = " + plainSelect1);

        System.out.println(sql);
    }


    @Test
    public void groupBy() {
        PlainSelect plainSelect = new PlainSelect();
        Table studentTable = new Table("student");
        ArrayList<SelectItem> selectItems = new ArrayList<>();
        selectItems.add(new SelectExpressionItem(new Column("name")));
        selectItems.add(new SelectExpressionItem(new Column("count(1)")).withAlias(new Alias("count")));
        /**
         * group by
         */
        GroupByElement groupByElement = new GroupByElement();
        groupByElement.addGroupByExpressions(new Column("name"));


        plainSelect.withSelectItems(selectItems).withFromItem(studentTable).setGroupByElement(groupByElement);

        String sql = plainSelect.toString();
        System.out.println(sql);
    }


    @Test
    public void orderBy() {
        PlainSelect plainSelect = new PlainSelect();
        Table studentTable = new Table("student");
        ArrayList<SelectItem> selectItems = new ArrayList<>();
        selectItems.add(new SelectExpressionItem(new Column("name")));
        selectItems.add(new SelectExpressionItem(new Column("count(1)")).withAlias(new Alias("count")));

        /**
         * order by
         */
        OrderByElement orderByElement = new OrderByElement();
        orderByElement.setExpression(new Column("name"));
        orderByElement.setAsc(true);

        ArrayList<OrderByElement> orderByElements = new ArrayList<>();
        orderByElements.add(orderByElement);

        plainSelect.withSelectItems(selectItems).withFromItem(studentTable)
                .setOrderByElements(orderByElements);

        String sql = plainSelect.toString();
        System.out.println(sql);
    }

    @Test
    public void page() {
        PlainSelect plainSelect = new PlainSelect();
        Table studentTable = new Table("student");
        ArrayList<SelectItem> selectItems = new ArrayList<>();
        selectItems.add(new SelectExpressionItem(new Column("name")));
        selectItems.add(new SelectExpressionItem(new Column("count(1)")).withAlias(new Alias("count")));
        /**
         * postgresql 分页
         */
        Limit limit = new Limit();
        limit.setRowCount(new LongValue(10));
        Offset offset = new Offset();
        offset.setOffset(new LongValue(0));

        plainSelect.withSelectItems(selectItems).withFromItem(studentTable).withLimit(limit).withOffset(offset);

        String sql = plainSelect.toString();
        System.out.println(sql);
    }

    @Test
    public void having() {

    }


    @Test
    public void writeJson() throws JsonProcessingException {
        PlainSelect plainSelect = new PlainSelect();
        Table studentTable = new Table("gcxk_jsdwjbqk");

        ArrayList<SelectItem> selectItems = new ArrayList<>();
        selectItems.add(new SelectExpressionItem(new AllColumns()));

        plainSelect.withSelectItems(selectItems).withFromItem(studentTable);
        String jsonString = JSON.toJSONString(plainSelect);
        System.out.println( jsonString);

        ObjectMapper objectMapper = new ObjectMapper();
        PlainSelect plainSelect2 = objectMapper.readValue(jsonString, PlainSelect.class);

        System.out.println("plainSelect2 = " + plainSelect2);
    }
}
