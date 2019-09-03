package cn.omist.core.service;

import cn.omist.core.pojo.entity.PageResult;
import cn.omist.core.pojo.entity.SpecEntity;
import cn.omist.core.pojo.specification.Specification;

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
}
