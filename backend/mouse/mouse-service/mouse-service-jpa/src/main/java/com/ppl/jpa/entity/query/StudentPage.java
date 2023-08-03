package com.ppl.jpa.entity.query;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by pisiliang on 2023/8/2 16:08
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class StudentPage extends BasePageQuery {
    private String name;

    private Integer maxAge;
    private Integer minAge;
}
