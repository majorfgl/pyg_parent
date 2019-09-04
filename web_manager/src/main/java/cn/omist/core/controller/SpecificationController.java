package cn.omist.core.controller;

import cn.omist.core.pojo.entity.PageResult;
import cn.omist.core.pojo.entity.Result;
import cn.omist.core.pojo.entity.SpecEntity;
import cn.omist.core.pojo.specification.Specification;
import cn.omist.core.service.SpecificationService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author Mr_Fan
 * @Date 2019/9/2 16:17
 */
@RequestMapping("/specification")
@RestController
public class SpecificationController {

    @Reference
    private SpecificationService specificationService;


    /**
     * 通过条件分页查询
     *
     * @param spec 查询条件对象
     * @param page 页码
     * @param rows 每页数量
     * @return 查询结果
     */
    @RequestMapping("/search")
    public PageResult search(@RequestBody Specification spec, Integer page, Integer rows) {
        return specificationService.findPage(spec, page, rows);
    }

    /**
     * 通过封装的自定义实体类增加规格以及规格项
     *
     * @param specEntity 自定义实体类
     * @return 结果
     */
    @RequestMapping("/add")
    public Result add(@RequestBody SpecEntity specEntity) {
        try {
            specificationService.add(specEntity);
            return new Result(true, "保存成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "保存失败！");
        }
    }

    /**
     * 通过id查询一个规格
     *
     * @param id id
     * @return 规格实体类
     */
    @RequestMapping("/findOne")
    public SpecEntity findOne(Long id) {
        return specificationService.findOne(id);
    }

    /**
     * 更新规格
     *
     * @param specEntity 更改提交的数据
     * @return 结果
     */
    @RequestMapping("/update")
    public Result update(@RequestBody SpecEntity specEntity) {
        try {
            specificationService.update(specEntity);
            return new Result(true, "保存成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "保存失败！");
        }
    }

    @RequestMapping("/delete")
    public Result delete(Long[] ids) {
        try {
            specificationService.delete(ids);
            return new Result(true, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "删除失败");
        }
    }

    /**
     * 查询规格选项
     *
     * @return 规格选项列表
     */
    @RequestMapping("/selectOptionList")
    public List<Map> selectOptionList() {
        return specificationService.selectOptionList();
    }
}
