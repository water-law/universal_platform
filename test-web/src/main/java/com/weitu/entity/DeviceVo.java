package com.weitu.entity;

import com.weitu.commons.page.PageVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import lombok.Data;

/**
 * 设备信息
 */
@ApiModel(value = "设备信息")
@Data
public class DeviceVo extends PageVo {
    private static final long serialVersionUID = 1L;
    /**
     *
     * 主键id
     */
    @ApiModelProperty(value = "主键id")
    private String id;
    /**
     *
     * 设备编号
     */
    @ApiModelProperty(value = "设备编号")
    private String deviceNo;
    /**
     *
     * 设备名称
     */
    @ApiModelProperty(value = "设备名称")
    private String deviceName;
    /**
     *
     * 设备类型
     */
    @ApiModelProperty(value = "设备类型")
    private String deviceType;
    /**
     *
     * 设备状态
     */
    @ApiModelProperty(value = "设备状态")
    private String deviceStatus;
    /**
     *
     * 子类型
     */
    @ApiModelProperty(value = "子类型")
    private String deviceSonType;
    /**
     *
     * 设备ip
     */
    @ApiModelProperty(value = "设备ip")
    private String ipUrl;
    /**
     *
     * 通信协议
     */
    @ApiModelProperty(value = "通信协议")
    private String comProtocol;
    /**
     *
     * 设备端口
     */
    @ApiModelProperty(value = "设备端口")
    private String devicePort;
    /**
     *
     * 设备账号
     */
    @ApiModelProperty(value = "设备账号")
    private String accountName;
    /**
     *
     * 设备密码
     */
    @ApiModelProperty(value = "设备密码")
    private String password;
    /**
     *
     * 机构名称
     */
    @ApiModelProperty(value = "机构名称")
    private String orgName;
    /**
     *
     * 关联机构ID
     */
    @ApiModelProperty(value = "关联机构ID")
    private String orgId;
    /**
     *
     * 经营主体编号
     */
    @ApiModelProperty(value = "经营主体编号")
    private String mainNo;
    /**
     *
     * 经营主体名称
     */
    @ApiModelProperty(value = "经营主体名称")
    private String mainMerchantName;
    /**
     *
     * 区域码
     */
    @ApiModelProperty(value = "区域码")
    private String areaCode;
    /**
     *
     * 详细地址
     */
    @ApiModelProperty(value = "详细地址")
    private String address;
    /**
     *
     * 经度
     */
    @ApiModelProperty(value = "经度")
    private String longitude;
    /**
     *
     * 纬度
     */
    @ApiModelProperty(value = "纬度")
    private String latitude;
    /**
     *
     * 是否重点设备
     */
    @ApiModelProperty(value = "是否重点设备")
    private Boolean isImportant;
    /**
     *
     * 负责人
     */
    @ApiModelProperty(value = "负责人")
    private String leader;
    /**
     *
     * 负责人联系方式
     */
    @ApiModelProperty(value = "负责人联系方式")
    private String leaderTel;
    /**
     *
     * 产商
     */
    @ApiModelProperty(value = "产商")
    private String makeCompany;
    /**
     *
     * 采购时间
     */
    @ApiModelProperty(value = "采购时间")
    private Date purchaseTime;
    /**
     *
     * 使用到期时间
     */
    @ApiModelProperty(value = "使用到期时间")
    private Date useExpireTime;
    /**
     *
     * 设备型号
     */
    @ApiModelProperty(value = "设备型号")
    private String deviceModel;
    /**
     *
     * 供应商
     */
    @ApiModelProperty(value = "供应商")
    private String supplier;
    /**
     *
     * 供应商联系人
     */
    @ApiModelProperty(value = "供应商联系人")
    private String supplierContact;
    /**
     *
     * 供应商联系电话
     */
    @ApiModelProperty(value = "供应商联系电话")
    private String supplierTel;
    /**
     *
     * 设备url
     */
    @ApiModelProperty(value = "设备url")
    private String deviceUrl;
    /**
     *
     * 设备默认图片地址，可传 mongoid
     */
    @ApiModelProperty(value = "设备默认图片地址，可传 mongoid")
    private String deviceDefaultUrl;
    /**
     *
     * 创建人
     */
    @ApiModelProperty(value = "创建人")
    private String createdBy;
    /**
     *
     * 修改人
     */
    @ApiModelProperty(value = "修改人")
    private String updatedBy;
    /**
     *
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date gmtCreated;
    /**
     *
     * 修改时间
     */
    @ApiModelProperty(value = "修改时间")
    private Date gmtModified;
    /**
     *
     * 数据版本号
     */
    @ApiModelProperty(value = "数据版本号")
    private Integer dataVersion;
    /**
     *
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remark;
    /**
     *
     * 删除标志
     */
    @ApiModelProperty(value = "删除标志")
    private Boolean deleteFlag;
}