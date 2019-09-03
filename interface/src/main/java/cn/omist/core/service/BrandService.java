package cn.omist.core.service;

import cn.omist.core.pojo.entity.PageResult;
import cn.omist.core.pojo.good.Brand;

import java.util.List;

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
    public List<Brand> findAll();

    /**
     * 分页查询返回品牌
     * @param brand 查询条件
     * @param page 页码
     * @param rows 每页数量
     * @return pageresult
     */
    PageResult findPage(Brand brand,Integer page, Integer rows);

    /**
     * 保存品牌
     *
     * @param brand
     */
    void add(Brand brand);

    /**
     * 通过id查询品牌id
     *
     * @param id
     * @return
     */
    Brand findOne(Long id);

    /**
     * 修改品牌id
     *
     * @param brand
     */
    void update(Brand brand);

    /**
     * 通过id删除品牌
     * @param ids
     */
    void delete(Long[] ids);

}
