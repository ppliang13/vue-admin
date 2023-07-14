package com.ppl.vueadmin.pojo.db;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * Created by pisiliang on 2023/7/14 15:37
 */
@TableName("str_flow_step")
@Data
public class StrFlowStepDb {
    private Long id;
    private Long flowId;
    private Long stepId;
    private Integer stepOrder;
    private String stepName;
}
