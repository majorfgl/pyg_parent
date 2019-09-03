package cn.omist.core.controller;

import cn.omist.core.pojo.entity.PageResult;
import cn.omist.core.pojo.entity.Result;
import cn.omist.core.pojo.good.Brand;
import cn.omist.core.service.BrandService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author Mr_Fan
 * @Date 2019/8/30 16:24
 */
@RestController
@RequestMapping("/brand")
public class BrandController {
    @Reference
    private BrandService brandService;

    @RequestMapping("/findAll")
    public List<Brand> findAll() {
        List<Brand> all = brandService.findAll();
        return all;
    }

    /**
     * 分页查询品牌 支持模糊查询
     *
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/search")
    public PageResult search(@RequestBody Brand brand, Integer page, Integer rows) {

        return brandService.findPage(brand, page, rows);
    }

    @RequestMapping("/add")
    public Result add(@RequestBody Brand brand) {
        try {
            brandService.add(brand);
            return new Result(true, "保存成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "保存失败！");
        }
    }

    @RequestMapping("/findOne")
    public Brand findOne(Long id) {
        return brandService.findOne(id);
    }

    /**
     * 修改
     *
     * @param brand
     * @return
     */
    @RequestMapping("/update")
    public Result update(@RequestBody Brand brand) {
        try {
            brandService.update(brand);
            return new Result(true, "修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "修改失败");
        }
    }

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    @RequestMapping("/delete")
    public Result delete(Long[] ids) {
        try {
            brandService.delete(ids);
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

        //查找brand列表
        return null;
    }

}
