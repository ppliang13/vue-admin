
package th.lmoc.generate.modular.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import th.lmoc.common.annotion.BusinessLog;
import th.lmoc.common.annotion.Permission;
import th.lmoc.common.enums.LogAnnotionOpTypeEnum;
import th.lmoc.common.pojo.base.param.BaseParam;
import th.lmoc.common.pojo.response.ResponseData;
import th.lmoc.common.pojo.response.SuccessResponseData;
import th.lmoc.generate.modular.param.SysCodeGenerateConfigParam;
import th.lmoc.generate.modular.service.SysCodeGenerateConfigService;

import javax.annotation.Resource;

/**
 * 代码生成详细配置控制器
 *
 * @author laifuxing
 * @date 2021-02-06 20:19:49
 */
@RestController
public class SysCodeGenerateConfigController {

    @Resource
    private SysCodeGenerateConfigService sysCodeGenerateConfigService;

    /**
     * 编辑代码生成详细配置
     *
     * @author laifuxing
     * @date 2021-02-06 20:19:49
     */
    @Permission
    @PostMapping("/sysCodeGenerateConfig/edit")
    @BusinessLog(title = "代码生成详细配置_编辑", opType = LogAnnotionOpTypeEnum.EDIT)
    public ResponseData edit(@RequestBody @Validated(BaseParam.edit.class) SysCodeGenerateConfigParam sysCodeGenerateConfigParam) {
            sysCodeGenerateConfigService.edit(sysCodeGenerateConfigParam.getSysCodeGenerateConfigParamList());
        return new SuccessResponseData();
    }

    /**
     * 查看代码生成详细配置
     *
     * @author laifuxing
     * @date 2021-02-06 20:19:49
     */
    @Permission
    @GetMapping("/sysCodeGenerateConfig/detail")
    @BusinessLog(title = "代码生成详细配置_查看", opType = LogAnnotionOpTypeEnum.DETAIL)
    public ResponseData detail(@Validated(SysCodeGenerateConfigParam.detail.class) SysCodeGenerateConfigParam sysCodeGenerateConfigParam) {
        return new SuccessResponseData(sysCodeGenerateConfigService.detail(sysCodeGenerateConfigParam));
    }

    /**
     * 代码生成详细配置列表
     *
     * @author laifuxing
     * @date 2021-02-06 20:19:49
     */
    @Permission
    @GetMapping("/sysCodeGenerateConfig/list")
    @BusinessLog(title = "代码生成详细配置_列表", opType = LogAnnotionOpTypeEnum.QUERY)
    public ResponseData list(SysCodeGenerateConfigParam sysCodeGenerateConfigParam) {
        return new SuccessResponseData(sysCodeGenerateConfigService.list(sysCodeGenerateConfigParam));
    }

}
