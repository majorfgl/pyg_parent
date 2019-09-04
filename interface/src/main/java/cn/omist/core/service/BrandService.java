package cn.omist.core.service;

import cn.omist.core.pojo.entity.PageResult;
import cn.omist.core.pojo.good.Brand;

import java.util.List;
import java.util.Map;

/**
 * @author Mr_Fan
 * @Date 2019/8/30 16:11
 */
public interface BrandService {

    /**
     * 查询所有品牌
     *
     * @return 返回所有品牌
     */
    List<Brand> findAll();

    /**
     * 分页查询返回品牌
     *
     * @param brand 查询条件
     * @param page  页码
     * @param rows  每页数量
     * @return pageResult
     */
    PageResult findPage(Brand brand, Integer page, Integer rows);

    /**
     * 保存品牌
     *
     * @param brand 查询条件
     */
    void add(Brand brand);

    /**
     * 通过id查询品牌id
     *
     * @param id id
     * @return 品牌
     */
    Brand findOne(Long id);

    /**
     * 修改品牌id
     *
     * @param brand 更新值
     */
    void update(Brand brand);

    /**
     * 通过id删除品牌
     *
     * @param ids ids
     */
    void delete(Long[] ids);

    /**
     * 查询所有品牌作为前台页面选项
     *
     * @return 所有品牌的list
     */
    List<Map> selectOptionList();

}
