package cn.omist.core.service;

import cn.omist.core.pojo.entity.PageResult;
import cn.omist.core.pojo.template.TypeTemplate;

/**
 * @author Mr_Fan
 * @Date 2019/9/3 14:36
 */
public interface TypeTemplateService {
    /**
     * typeTemplate的分页查询
     *
     * @param template 查询调价对象
     * @param page     页码
     * @param rows     数量
     * @return 分页后的结果
     */
    PageResult findPage(TypeTemplate template, Integer page, Integer rows);
}
