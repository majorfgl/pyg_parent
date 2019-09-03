package cn.omist.core.controller;

import cn.omist.core.pojo.entity.PageResult;
import cn.omist.core.pojo.template.TypeTemplate;
import cn.omist.core.service.TypeTemplateService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mr_Fan
 * @Date 2019/9/3 14:32
 */
@RestController
@RequestMapping("/typeTemplate")
public class TypeTempleteController {

    @Reference
    private TypeTemplateService typetemplateService;

    /**
     * typeTemplate的分页查询
     *
     * @param template 查询调价对象
     * @param page     页码
     * @param rows     数量
     * @return 分页后的结果
     */
    @RequestMapping("/search")
    public PageResult search(@RequestBody TypeTemplate template, Integer page, Integer rows) {
        return typetemplateService.findPage(template, page, rows);
    }

}
