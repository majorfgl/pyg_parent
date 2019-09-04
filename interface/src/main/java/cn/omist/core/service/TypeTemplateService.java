package cn.omist.core.service;

import cn.omist.core.pojo.entity.PageResult;
import cn.omist.core.pojo.template.TypeTemplate;

import java.util.List;
import java.util.Map;

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

    /**
     * 通过id查询一个模板
     *
     * @param id id
     * @return 模板
     */
    TypeTemplate findOne(Long id);

    /**
     * 添加一个模板
     *
     * @param template 待添加的模板
     */
    void insert(TypeTemplate template);

    /**
     * 更新一个模板
     *
     * @param template 待更新的模板
     */
    void update(TypeTemplate template);

    /**
     * 通过ids删除模板
     *
     * @param ids ids
     */
    void delete(Long[] ids);



}
