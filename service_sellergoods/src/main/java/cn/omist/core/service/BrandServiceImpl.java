package cn.omist.core.service;

import cn.omist.core.dao.good.BrandDao;
import cn.omist.core.pojo.entity.PageResult;
import cn.omist.core.pojo.good.Brand;
import cn.omist.core.pojo.good.BrandQuery;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author Mr_Fan
 * @Date 2019/8/30 16:11
 * 阿里巴巴的service 不容项目中通过dubbo调用
 */
@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandDao brandDao;

    @Override
    public List<Brand> findAll() {
        List<Brand> brands = brandDao.selectByExample(null);
        return brands;
    }

    @Override
    public PageResult findPage(Brand brand, Integer page, Integer rows) {
        PageHelper.startPage(page, rows);
        BrandQuery brandQuery = new BrandQuery();
        BrandQuery.Criteria criteria = brandQuery.createCriteria();
        if (StringUtils.isNotBlank(brand.getName())) {
            criteria.andNameLike("%" + brand.getName() + "%");
        }
        if (StringUtils.isNotBlank(brand.getFirstChar())) {
            criteria.andFirstCharLike("%" + brand.getFirstChar() + "%");
        }
        Page<Brand> brandPage = (Page<Brand>) brandDao.selectByExample(brandQuery);
        return new PageResult(brandPage.getTotal(), brandPage.getResult());
    }

    @Override
    public void add(Brand brand) {
        brandDao.insertSelective(brand);
    }

    @Override
    public Brand findOne(Long id) {
        return brandDao.selectByPrimaryKey(id);
    }

    @Override
    public void update(Brand brand) {
        brandDao.updateByPrimaryKeySelective(brand);
    }

    @Override
    public void delete(Long[] ids) {
        for (Long id : ids) {
            brandDao.deleteByPrimaryKey(id);
        }
    }
}
