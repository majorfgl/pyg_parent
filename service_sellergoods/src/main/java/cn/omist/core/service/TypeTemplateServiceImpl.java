package cn.omist.core.service;

import cn.omist.core.dao.template.TypeTemplateDao;
import cn.omist.core.pojo.entity.PageResult;
import cn.omist.core.pojo.template.TypeTemplate;
import cn.omist.core.pojo.template.TypeTemplateQuery;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Mr_Fan
 * @Date 2019/9/3 14:36
 */
@Service
public class TypeTemplateServiceImpl implements TypeTemplateService {

    @Autowired
    private TypeTemplateDao typeTemplateDao;

    @Override
    public PageResult findPage(TypeTemplate template, Integer page, Integer rows) {
        TypeTemplateQuery typeTemplateQuery = new TypeTemplateQuery();
        TypeTemplateQuery.Criteria criteria = typeTemplateQuery.createCriteria();
        if (StringUtils.isNotBlank(template.getName())) {
            criteria.andNameLike("%" + template.getName() + "%");
        }
        PageHelper.startPage(page, rows);
        Page<TypeTemplate> templatePage = (Page<TypeTemplate>) typeTemplateDao.selectByExample(typeTemplateQuery);
        return new PageResult(templatePage.getTotal(), templatePage.getResult());
    }

    @Override
    public TypeTemplate findOne(Long id) {
        return typeTemplateDao.selectByPrimaryKey(id);
    }

    @Override
    public void insert(TypeTemplate template) {
        typeTemplateDao.insertSelective(template);
    }

    @Override
    public void update(TypeTemplate template) {
        typeTemplateDao.updateByPrimaryKeySelective(template);
    }

    @Override
    public void delete(Long[] ids) {
        for (Long id : ids) {
            typeTemplateDao.deleteByPrimaryKey(id);
        }
    }
}
