package cn.omist.core.pojo.entity;

import cn.omist.core.pojo.specification.Specification;
import cn.omist.core.pojo.specification.SpecificationOption;

import java.io.Serializable;
import java.util.List;

/**
 * 自定义实体类接收
 *
 * @author Mr_Fan
 * @Date 2019/9/2 20:07
 */
public class SpecEntity implements Serializable {
    /**
     * 待添加的规格对象
     */
    private Specification specification;
    /**
     * 待添加的规格项list
     */
    private List<SpecificationOption> specificationOptionList;

    public SpecEntity() {
    }

    public SpecEntity(Specification specification, List<SpecificationOption> specificationOptionList) {
        this.specification = specification;
        this.specificationOptionList = specificationOptionList;
    }

    public Specification getSpecification() {
        return specification;
    }

    public void setSpecification(Specification specification) {
        this.specification = specification;
    }

    public List<SpecificationOption> getSpecificationOptionList() {
        return specificationOptionList;
    }

    public void setSpecificationOptionList(List<SpecificationOption> specificationOptionList) {
        this.specificationOptionList = specificationOptionList;
    }
}
