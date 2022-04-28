package com.atguigu.springcloud.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 接口注册信息表
 * </p>
 *
 * @author wuxx
 * @since 2022-04-25
 */
@TableName("t_api_register")
public class ApiRegister extends Model<ApiRegister> {

    private static final long serialVersionUID = 1L;

    /**
     * 接口编码
     */
    @TableId(value = "api_id", type = IdType.AUTO)
    private Long apiId;
    /**
     * 接口名称
     */
    private String apiName;
    /**
     * 服务类型：1账户中心，2商品中心，3订单中心 , 4仓库管理,（3000-3999）  5客户管理（4000-4999），6报表，7支付（5000-5999）
     */
    private Integer serviceType;
    /**
     * 请求uri
     */
    private String requestUri;
    /**
     * 是否签名：1是，0否
     */
    private Integer isSign;
    /**
     * 备注
     */
    private String remark;
    /**
     * 新接口编码，用于兼容老接口
     */
    private Long newApiId;
    /**
     * 创建人编码
     */
    private String createUid;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改人编码
     */
    private String updateUid;
    /**
     * 修改时间
     */
    private Date updateTime;
    /**
     * 删除标识：0未删除，1删除
     */
    private Integer deleted;


    public Long getApiId() {
        return apiId;
    }

    public void setApiId(Long apiId) {
        this.apiId = apiId;
    }

    public String getApiName() {
        return apiName;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName;
    }

    public Integer getServiceType() {
        return serviceType;
    }

    public void setServiceType(Integer serviceType) {
        this.serviceType = serviceType;
    }

    public String getRequestUri() {
        return requestUri;
    }

    public void setRequestUri(String requestUri) {
        this.requestUri = requestUri;
    }

    public Integer getIsSign() {
        return isSign;
    }

    public void setIsSign(Integer isSign) {
        this.isSign = isSign;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getNewApiId() {
        return newApiId;
    }

    public void setNewApiId(Long newApiId) {
        this.newApiId = newApiId;
    }

    public String getCreateUid() {
        return createUid;
    }

    public void setCreateUid(String createUid) {
        this.createUid = createUid;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateUid() {
        return updateUid;
    }

    public void setUpdateUid(String updateUid) {
        this.updateUid = updateUid;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    @Override
    protected Serializable pkVal() {
        return this.apiId;
    }

    @Override
    public String toString() {
        return "ApiRegister{" +
        ", apiId=" + apiId +
        ", apiName=" + apiName +
        ", serviceType=" + serviceType +
        ", requestUri=" + requestUri +
        ", isSign=" + isSign +
        ", remark=" + remark +
        ", newApiId=" + newApiId +
        ", createUid=" + createUid +
        ", createTime=" + createTime +
        ", updateUid=" + updateUid +
        ", updateTime=" + updateTime +
        ", deleted=" + deleted +
        "}";
    }
}
