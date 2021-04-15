package com.weitu.model.gen;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 设备信息
 */
@Data
public class Device implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     *
     * 主键id
     */
    private String id;
    /**
     *
     * 设备编号
     */
    private String deviceNo;
    /**
     *
     * 设备名称
     */
    private String deviceName;
    /**
     *
     * 设备类型
     */
    private String deviceType;
    /**
     *
     * 设备状态
     */
    private String deviceStatus;
    /**
     *
     * 子类型
     */
    private String deviceSonType;
    /**
     *
     * 设备ip
     */
    private String ipUrl;
    /**
     *
     * 通信协议
     */
    private String comProtocol;
    /**
     *
     * 设备端口
     */
    private String devicePort;
    /**
     *
     * 设备账号
     */
    private String accountName;
    /**
     *
     * 设备密码
     */
    private String password;
    /**
     *
     * 机构名称
     */
    private String orgName;
    /**
     *
     * 关联机构ID
     */
    private String orgId;
    /**
     *
     * 经营主体编号
     */
    private String mainNo;
    /**
     *
     * 经营主体名称
     */
    private String mainMerchantName;
    /**
     *
     * 区域码
     */
    private String areaCode;
    /**
     *
     * 详细地址
     */
    private String address;
    /**
     *
     * 经度
     */
    private String longitude;
    /**
     *
     * 纬度
     */
    private String latitude;
    /**
     *
     * 是否重点设备
     */
    private Boolean isImportant;
    /**
     *
     * 负责人
     */
    private String leader;
    /**
     *
     * 负责人联系方式
     */
    private String leaderTel;
    /**
     *
     * 产商
     */
    private String makeCompany;
    /**
     *
     * 采购时间
     */
    private Date purchaseTime;
    /**
     *
     * 使用到期时间
     */
    private Date useExpireTime;
    /**
     *
     * 设备型号
     */
    private String deviceModel;
    /**
     *
     * 供应商
     */
    private String supplier;
    /**
     *
     * 供应商联系人
     */
    private String supplierContact;
    /**
     *
     * 供应商联系电话
     */
    private String supplierTel;
    /**
     *
     * 设备url
     */
    private String deviceUrl;
    /**
     *
     * 设备默认图片地址，可传 mongoid
     */
    private String deviceDefaultUrl;
    /**
     *
     * 创建人
     */
    private String createdBy;
    /**
     *
     * 修改人
     */
    private String updatedBy;
    /**
     *
     * 创建时间
     */
    private Date gmtCreated;
    /**
     *
     * 修改时间
     */
    private Date gmtModified;
    /**
     *
     * 数据版本号
     */
    private Integer dataVersion;
    /**
     *
     * 备注
     */
    private String remark;
    /**
     *
     * 删除标志
     */
    private Boolean deleteFlag;
}