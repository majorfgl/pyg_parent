package cn.omist.core.service;

import cn.omist.core.dao.specification.SpecificationDao;
import cn.omist.core.dao.specification.SpecificationOptionDao;
import cn.omist.core.pojo.entity.PageResult;
import cn.omist.core.pojo.entity.SpecEntity;
import cn.omist.core.pojo.specification.Specification;
import cn.omist.core.pojo.specification.SpecificationOption;
import cn.omist.core.pojo.specification.SpecificationOptionQuery;
import cn.omist.core.pojo.specification.SpecificationQuery;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * 规格服务
 *
 * @author Mr_Fan
 * @Date 2019/9/2 16:19
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class SpecificationServiceImpl implements SpecificationService {

    @Autowired
    private SpecificationDao specificationDao;

    @Autowired
    private SpecificationOptionDao specificationOptionDao;

    @Override
    public PageResult findPage(Specification spec, Integer page, Integer rows) {
        //创建查询对象
        SpecificationQuery specificationQuery = new SpecificationQuery();
        SpecificationQuery.Criteria criteria = specificationQuery.createCriteria();
        if (StringUtils.isNotBlank(spec.getSpecName())) {
            criteria.andSpecNameLike("%" + spec.getSpecName() + "%");
        }
        //分页
        PageHelper.startPage(page, rows);
        Page<Specification> specificationPage = (Page<Specification>) specificationDao.selectByExample(specificationQuery);
        return new PageResult(specificationPage.getTotal(), specificationPage.getResult());

    }

    @Override
    public void add(SpecEntity specEntity) {
        Specification specification = specEntity.getSpecification();
        //插入后返回id
        specificationDao.insertSelective(specification);
        for (SpecificationOption specificationOption : specEntity.getSpecificationOptionList()) {
            specificationOption.setSpecId(specification.getId());
            specificationOptionDao.insertSelective(specificationOption);
        }
    }

    @Override
    public SpecEntity findOne(Long id) {
        SpecEntity specEntity = new SpecEntity();
        //通过id查询规格
        Specification specification = specificationDao.selectByPrimaryKey(id);
        //通过id查询规格项
        SpecificationOptionQuery specificationOptionQuery = new SpecificationOptionQuery();
        SpecificationOptionQuery.Criteria criteria = specificationOptionQuery.createCriteria();
        criteria.andSpecIdEqualTo(id);
        List<SpecificationOption> specificationOptions = specificationOptionDao.selectByExample(specificationOptionQuery);
        //封装查询的数据
        specEntity.setSpecification(specification);
        specEntity.setSpecificationOptionList(specificationOptions);
        return specEntity;
    }

    @Override
    public void update(SpecEntity specEntity) {
        //更新规格
        specificationDao.updateByPrimaryKeySelective(specEntity.getSpecification());
        //更新规格项
        //1.删除原来的规格项
        SpecificationOptionQuery specificationOptionQuery = new SpecificationOptionQuery();
        SpecificationOptionQuery.Criteria criteria = specificationOptionQuery.createCriteria();
        criteria.andSpecIdEqualTo(specEntity.getSpecification().getId());
        specificationOptionDao.deleteByExample(specificationOptionQuery);
        //2.插入新的规格项
        for (SpecificationOption specificationOption : specEntity.getSpecificationOptionList()) {
            specificationOption.setSpecId(specEntity.getSpecification().getId());
            specificationOptionDao.insertSelective(specificationOption);
        }
    }

    @Override
    public void delete(Long[] ids) {
        for (Long id : ids) {
            //删除规格
            specificationDao.deleteByPrimaryKey(id);
            //删除规格项
            SpecificationOptionQuery specificationOptionQuery = new SpecificationOptionQuery();
            SpecificationOptionQuery.Criteria criteria = specificationOptionQuery.createCriteria();
            criteria.andSpecIdEqualTo(id);
            specificationOptionDao.deleteByExample(specificationOptionQuery);
        }
    }

    @Override
    public List<Map> selectOptionList() {
        return specificationDao.selectOptionList();
    }
}
