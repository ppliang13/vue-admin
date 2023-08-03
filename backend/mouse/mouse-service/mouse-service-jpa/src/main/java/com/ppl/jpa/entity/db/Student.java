package com.ppl.jpa.entity.db;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by pisiliang on 2023/8/2 14:53
 */
@Entity
@Data
@Table(name = "student")
public class Student {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name="age")
    private Integer age;

    /**
     * 创建时间
     * updatable = false: 该字段不可更新
     * nullable = false: 该字段不可为空
     * CreatedDate: 该注解会在创建时自动填充当前时间
     */
    @CreatedDate
    @Column(name = "create_time" ,updatable = false,nullable = false)
    private Date createTime;
}
