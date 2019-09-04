package cn.omist.core.controller;

import cn.omist.core.pojo.entity.PageResult;
import cn.omist.core.pojo.entity.Result;
import cn.omist.core.pojo.template.TypeTemplate;
import cn.omist.core.service.TypeTemplateService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

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


    /**
     * 通过id查询一个模板
     *
     * @param id id
     * @return 模板
     */
    @RequestMapping("/findOne")
    public TypeTemplate findOne(Long id) {
        return typetemplateService.findOne(id);
    }

    /**
     * 添加一个模板
     *
     * @param template 待添加的模板
     * @return 添加结果
     */
    @RequestMapping("/add")
    public Result add(@RequestBody TypeTemplate template) {
        typetemplateService.insert(template);
        return new Result(true, "");
    }

    /**
     * 更新一个模板
     *
     * @param template 待更新的模板
     * @return 更新结果
     */
    @RequestMapping("/update")
    public Result update(@RequestBody TypeTemplate template) {
        typetemplateService.update(template);
        return new Result(true, "");
    }

    /**
     * 通过ids删除模板
     *
     * @param ids ids
     * @return 删除结果
     */
    @RequestMapping("/delete")
    public Result delete(Long[] ids) {
        typetemplateService.delete(ids);
        return new Result(true, "");
    }


}
