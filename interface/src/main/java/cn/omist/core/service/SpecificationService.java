package cn.omist.core.service;

import cn.omist.core.pojo.entity.PageResult;
import cn.omist.core.pojo.entity.SpecEntity;
import cn.omist.core.pojo.specification.Specification;

import java.util.List;
import java.util.Map;

/**
 * @author Mr_Fan
 * @Date 2019/9/2 16:18
 */
public interface SpecificationService {
    public PageResult findPage(Specification spec, Integer page, Integer rows);

    void add(SpecEntity specEntity);

    SpecEntity findOne(Long id);

    void update(SpecEntity specEntity);

    void delete(Long[] ids);

    /**
     * 查询规格选项
     *
     * @return 规格选项列表
     */
    List<Map> selectOptionList();
}
