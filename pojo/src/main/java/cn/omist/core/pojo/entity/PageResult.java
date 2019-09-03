package cn.omist.core.pojo.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @author Mr_Fan
 * @Date 2019/9/1 21:43
 */
public class PageResult implements Serializable {
    /**
     * 总数
     */
    private Long total;
    /**
     * 数据集合
     */
    private List rows;

    public PageResult(Long total, List rows) {
        this.total = total;
        this.rows = rows;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "PageResult{" +
                "total=" + total +
                ", rows=" + rows +
                '}';
    }
}
