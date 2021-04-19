package com.weitu.mpsplatform.commons.constants;

import com.weitu.mpsplatform.commons.utils.SString;

/**
 * 核心业务层常量类
 *
 * @author senhuaF
 * @version $Id: SaasConstants.java, v 0.1 2016年9月19日 上午10:18:34 senhuaF Exp $
 */
public class SaasBusinessConstants {
    private SaasBusinessConstants() {

    }

    /**
     * 分页常量
     */
    public static class SaasPage {
        public static final Integer PAGE_NUM_INT = 1;
        public static final Integer PAGE_SIZE_INT = 10;
    }

    /**
     * 系统用户常量
     */
    public static class SysUserConstants {
        /**
         * 帐号级别-超级管理员
         */
        public static final String ACCOUNT_RANK_SUPER = "99";
        /**
         * 帐号级别-普通用户
         */
        public static final String ACCOUNT_RANK_COMMON = "01";
    }



    /**
     * 系统菜单，父级ID默认值
     */
    public static final String SYS_MENU_PARENT_ID_DEFAULT = "1";
    /**
     * 系统菜单，父级ID默认值
     */
    public static final String SYS_AREA_CODE_PARENT_ID_DEFAULT = "0";

    /**
     * 当事人身份证加密因子
     */
    public static final String PARTER_PD_SALT= "fZ6w6T";

    /**
     * 业务文件常量
     */
    public static class FileBusiConstants {
        /**
         * 文件业务类型-调解材料
         */
        public static final String BUSINESS_TYPE_MEDIATION_MATERIAL = "mediation_material";
    }

    /**
     * 文件通用常量类
     */
    public static class FileCommonsConstants {
        /**
         * 内容编码类型
         */
        public static final String FILE_CONTENT_TYPE_PDF = "application/pdf";

        public static final String FILE_CONTENT_TYPE_PNG = "application/x-png";
    }

    /**
     * 业务流水号类型常量
     */
    public static class bizFlowSeqType {
        /**
         * 调解
         */
        public static final String BIZ_TYPE_MEDIATION_MATERIAL = "mediation_material";
        /**
         * 默认
         */
        public static final String BIZ_TYPE_DEFAULT = "default";
    }

    /**
     * 微信端常量
     */
    public static class WechatConstants {
        /**
         * "预约调解
         */
        public static final String ROUTER_NAME_MEDIATIONAPPOINT = "MediationAppoint";
        /**
         * 我的调解案件
         */
        public static final String ROUTER_NAME_MEDIATION = "Mediation";
        /**
         * 我的司法确认
         */
        public static final String ROUTER_NAME_MYJUDICIAL = "MyJudicial";
        /**
         * 标准新增案件
         */
        public static final String ROUTER_NAME_NEWCASE = "NewCase";
        /**
         * 快速新增案件
         */
        public static final String ROUTER_NAME_NEWCASEQUICK = "NewCaseQuick";
        /**
         * 法官-案件调解
         */
        public static final String ROUTER_NAME_JUDICIAL = "Judicial";
        /**
         * 调解员-案件调解
         */
        public static final String ROUTER_NAME_JUDICIALMEDIATOR = "JudicialMediator";
        /**
         * 当事人-视频页面
         */
        public static final String ROUTER_NAME_VIDEOPARTER = "VideoParter";
        /**
         * 机构人员-视频页面
         */
        public static final String ROUTER_NAME_VIDEO = "Video";
        /**
         * 管理入口
         */
        public static final String ROUTER_NAME_MANAGEMENT_CENTER = "ManagementCenter";
        /**
         * 当事人
         */
        public static final String ROUTER_NAME_MANAGEMENT_CENTER_FOR_PERSON = "ManagementCenterForPerson";

    }

    /**
     * 微信用户权限路由地址
     */
    public enum WechatUserPermissionRouterPath {
        PublicUser("PublicUser", new String[]{WechatConstants.ROUTER_NAME_MEDIATIONAPPOINT, WechatConstants.ROUTER_NAME_MEDIATION, WechatConstants.ROUTER_NAME_MYJUDICIAL, WechatConstants.ROUTER_NAME_VIDEOPARTER, WechatConstants.ROUTER_NAME_MANAGEMENT_CENTER_FOR_PERSON}),
        Mediator("Mediator", new String[]{WechatConstants.ROUTER_NAME_NEWCASE, WechatConstants.ROUTER_NAME_JUDICIALMEDIATOR, WechatConstants.ROUTER_NAME_VIDEO, WechatConstants.ROUTER_NAME_MANAGEMENT_CENTER}),
        Judge("Judge", new String[]{WechatConstants.ROUTER_NAME_JUDICIAL, WechatConstants.ROUTER_NAME_VIDEO, WechatConstants.ROUTER_NAME_MANAGEMENT_CENTER}),
        Police("Police", new String[]{WechatConstants.ROUTER_NAME_NEWCASEQUICK, WechatConstants.ROUTER_NAME_NEWCASE, WechatConstants.ROUTER_NAME_MANAGEMENT_CENTER});
        private String roleType;
        private String[] routerSet;

        WechatUserPermissionRouterPath(String roleType, String[] routerSet) {
            this.roleType = roleType;
            this.routerSet = routerSet;
        }

        public String getRoleType() {
            return roleType;
        }

        public void setRoleType(String roleType) {
            this.roleType = roleType;
        }

        public String[] getRouterSet() {
            return routerSet;
        }

        public void setRouterSet(String[] routerSet) {
            this.routerSet = routerSet;
        }

        /**
         * 通过角色类型获取路由集合
         *
         * @param roleType
         * @return
         */
        public static String[] getRouterSetByType(String roleType) {
            if (SString.isNotBlank(SString.getTrimString(roleType))) {
                for (WechatUserPermissionRouterPath tmpEnum : WechatUserPermissionRouterPath.values()) {
                    if (tmpEnum.roleType.equalsIgnoreCase(roleType)) {
                        return tmpEnum.getRouterSet();
                    }
                }
            }
            return null;
        }
    }

    /**
     * 卷宗类目常量
     */
    public static class FileCategoryConstants {
        /**
         * 卷宗类目类型编码-当事人证据材料
         */
        public static final String CATEGORY_CODE_PARTER = "1001";
        /**
         * 卷宗类目类型编码-调解文书材料
         */
        public static final String CATEGORY_CODE_MEDIATION = "1002";
        /**
         * 卷宗类目类型编码-司法确认材料
         */
        public static final String CATEGORY_CODE_JUDICIAL = "1003";
        /**
         * 卷宗类目类型编码-平台流转材料
         */
        public static final String CATEGORY_CODE_CIRCULATION = "1004";
    }

    /**
     * 消息业务常量
     */
    public static class MsgBusiConstants {
        /**
         * 消息业务类型-调解
         */
        public static final String BUSINESS_TYPE_MEDIATION = "mediation";
    }

    /**
     * 数据字典类型常量
     */
    public static class StandCodeTypeConstants {

        /**
         * 文件类型
         */
        public static final String FILE_TYPE = "fileType";
        /**
         * 性别
         */
        public static final String SEX = "sex";
        /**
         * 是否
         */
        public static final String YES_OR_NO = "yesOrNo";

        /**
         * 卷宗材料-材料类型
         */
        public static final String FILE_MATERIAL_ARCHIVE_TYPE = "fileMaterialArchiveType";

        /**
         * 卷宗材料-调解文书材料类型
         */
        public static final String FILE_MATERIAL_BOOK_ARCHIVE_TYPE = "fileMaterialBookArchiveType";

        /**
         * 卷宗材料-司法确认材料类型
         */
        public static final String FILE_MATERIAL_JUDICIAL_ARCHIVE_TYPE = "fileMaterialJudicialArchiveType";

        /**
         * 卷宗材料-材料来源
         */
        public static final String FILE_MATERIAL_DATA_SOURCE = "fileMaterialDataSource";

        /**
         * 菜单栏目所属
         */
        public static final String MENU_HEAD_BELONG = "menuHeadBelong";
        /**
         * 菜单链接属性
         */
        public static final String MENU_LINK_ATTR = "menuLinkAttr";
        /**
         * 菜单窗口打开方式
         */
        public static final String MENU_WINDOW_OPEN_TYPE = "menuWindowOpenType";

        /**
         * 身份证件类别
         */
        public static final String ID_CARD_PD_TYPE = "idCardPdType";

        /**
         * 学历
         */
        public static final String EDUCATION = "education";

        /**
         * 当事人学历
         */
        public static final String PARTER_EDUCATION = "parterEducation";

        /**
         * 预警事项
         */
        public static final String HIGH_RISK_MATTER = "highRiskMatter";

        /**
         * 业务类型
         */
        public static final String CASE_INFO_BUSI_TYPE = "caseInfoBusiType";

        /**
         * 民族
         */
        public static final String NATION = "nation";

        /**
         * 国籍
         */
        public static final String NATIONALITY = "nationality";

        /**
         * 业务当事人快照信息-当事人类型
         */
        public static final String PARTY_USER_INFO_IDENTITY_TYPE = "partyUserInfoIdentityType";
        /**
         * 业务当事人快照信息-业务角色
         */
        public static final String PARYT_USER_INFO_BIZ_TYPE_BIZ_JOB_TYPE = "partyUserInfoBizTypeBizJobType";

        /**
         * 消息推送-消息类型
         */
        public static final String PUSH_MSG_MASSAGE_TYPE = "pushMsgMassageType";
        /**
         * 消息推送-发送状态
         */
        public static final String PUSH_MSG_SEND_STATUS = "pushMsgSendStatus";

        /**
         * 司法确认-调解编号类型
         */
        public static final String CASE_INFO_JUDICIAL_NUMBER_TYPE = "caseInfoJudicialNumberType";
        /**
         * 司法确认-调解编号年份
         */
        public static final String CASE_INFO_JUDICIAL_NUMBER_YEAR = "caseInfoMediateNumberYear";

        /**
         * 调解业务-调解编号类型
         */
        public static final String CASE_INFO_MEDIATE_NUMBER_TYPE = "caseInfoMediateNumberType";
        /**
         * 调解业务-调解编号年份
         */
        public static final String CASE_INFO_MEDIATE_NUMBER_YEAR = "caseInfoMediateNumberYear";

        /**
         * 调解业务-纠纷类型
         */
        public static final String CASE_INFO_DISPUTE_TYPE = "caseInfoDisputeType";

        /**
         * 纠纷类型-民事求助类纠纷类型
         */
        public static final String CASE_INFO_CIVIL_DISPUTE_TYPE = "caseInfoCivilDisputeType";

        /**
         * 纠纷类型-治安类纠纷类型
         */
        public static final String CASE_INFO_PUBLIC_SECURITY_DISPUTE_TYPE = "caseInfoPublicSecurityDisputeType";

        /**
         * 调解业务-案件来源
         */
        public static final String CASE_INFO_CASE_SOURCE = "caseInfoCaseSource";
        /**
         * 案件状态
         */
        public static final String CASE_INFO_CASE_STATE = "caseInfoCaseState";

        /**
         * 操作平台
         */
        public static final String CASE_OPERATE_TERMINAL_TYPE = "caseOperateTerminalType";
        /**
         * 机构管理-机构类型
         */
        public static final String ORG_INFO_TYPE = "orgInfoType";
        /**
         * 人员管理-人员类型
         */
        public static final String ORG_USER_PERSON_TYPE = "orgUserPersonType";

        /**
         * 案件业务-警情类别
         */
        public static final String CASE_INFO_POLICE_TYPE = "caseInfoPoliceType";

        /**
         * 案件业务-案件纠错状态
         */
        public static final String CASE_CORRECTION_STATION = "caseCorrectionStation";

        /**
         * 案件业务-申请调解方式
         */
        public static final String CASE_INFO_MEDIATE_APPLY_METHOD = "caseInfoMediationApplyMethod";
        /**
         * 案件业务-上传方式
         */
        public static final String CASE_INFO_UPLOAD_APPLY_METHOD = "caseInfoUploadApplyMethod";
        /**
         * 案件业务-申请司法确认方式
         */
        public static final String CASE_INFO_APPLY_jUDICIAL_CONFIRM_MODE = "caseInfoApplyJudicialConfirmMode";
        /**
         * 案件业务-后续处理方式
         */
        public static final String CASE_INFO_FOLLOW_HANDLE_METHOD = "caseInfoFollowHandleMethod";
        /**
         * 案件业务-评价类型
         */
        public static final String CASE_INFO_EVALUATION_TYPE = "caseInfoEvaluationType";
        /**
         * 司法确认不予受理原因
         */
        public static final String CASE_INFO_jUDICIAL_NOT_ACCEPTANCE_REASON = "caseInfoJudicialNotAcceptanceReason";
        /**
         * 申请调解记录
         */
        public static final String MEDIATION_APPLY_RECORD_APPLY_STATE = "mediationApplyRecordApplyState";
        /**
         * 案件环节
         */
        public static final String CASE_PROCESS_TYPE = "caseProcessType";

        /**
         * 当事人采集信息-采集信息类别
         */
        public static final String PARYT_COLLECTION_INFO_TYPE = "partyCollectionInfoType";

        /**
         * 当事人信息-委托权限
         */
        public static final String PARTY_USER_INFO_ENTRUST_PWOER = "partyUserInfoEntrustPower";

        /**
         * 当事人信息-被代理人类型
         */
        public static final String PARTY_USER_INFO_BE_AGENT_ID = "partyUserInfoBeAgentId";
        /**
         * 当事人信息-与当事人的关系
         */
        public static final String PARTY_USER_INFO_WITH_PARTY_REL = "partyUserInfoWithPartyRel";
        /**
         * 当事人信息-与当事人的关系类型
         */
        public static final String PARTY_WITH_PARTY_REL_TYPE = "partyWithPartyRelType";

        /**
         * 人员花名册-擅长领域
         */
        public static final String ORG_USER_GOOD_ASPECT_TYPE = "orgUserGoodAspectType";
        /**
         * 人员花名册-值班类型
         */
        public static final String ORG_USER_RESTIME_TYPE = "orgUserRestTimeType";

        /**
         * 人员花名册-每周固定不工作
         */
        public static final String WEEK = "week";
        /**
         * 人员花名册-每月固定不工作
         */
        public static final String MONTH = "month";

        /**
         * 人员花名册-职业
         */
        public static final String ORG_USER_PREFESSION = "orgUserPrefession";
        /**
         * 人员花名册-身份
         */
        public static final String ORG_USER_IDENTITY = "orgUserIdentity";

        /**
         * 模板管理-名称类型
         */
        public static final String DOCUMENT_TYPE = "documentType";

        /**
         * 登录-人员类型
         */
        public static final String LOGIN_USER_TYPE = "loginUserType";

        /**
         * 案件视频房间权限-用户类型
         */
        public static final String CASE_VIDEO_ROOM_PERMISSION_USER_TYPE = "caseVideoRoomPermissionUserType";
        /**
         * 菜单类型级别
         */
        private static final String SYS_MENU_TYPE_RANK = "sysMenuTypeRank";
        /**
         * 工作台时间类型
         */
        private static final String WORK_BENCH = "workBenchType";
        /**
         * 用户属性（01 调解员 02 当事人 03 协助专家）
         */
        public static final String CASE_VIDEO_ROOM_PERMISSION_USER_ATTRIBUTE = "caseVideoRoomPermissionUserAttribute";


        /**
         * 调解-消息发送-发送客户端类型(01 短信 02 微信消息)
         */
        public static final String MEDIATION_MSG_CENTER_CLIENT = "mediationMsgCenterClient";

        /**
         * 调解-远程视频调解-提示 01 分钟 02 小时 03 天
         */
        public static final String REMINDER_TIME_TYPE = "reminderTimeType";
        /**
         * 流转案件状态
         */
        public static final String CASE_CIRCULATION_STATE = "caseCirculationState";

        /**
         * 流转途径
         */
        public static final String CIRCULATION_WAY = "circulationWay";

        /**
         * 分色预警-纠纷场所
         */
        public static final String DISPUTE_PLACE = "disputePlace";

        /**
         * 事件-事件类型
         */
        public static final String CRS_EVENT_EVENT_TYPE = "crsEventEventType";

        /**
         * 事件-事件状态
         */
        public static final String CRS_EVENT_EVENT_STATUS = "crsEventEventStatus";

        /**
         * 事件-事件参与类型
         */
        public static final String CRS_EVENT_EVENT_JOIN_TYPE = "crsEventEventJoinType";

        /**
         * 事件-事件参与角色
         */
        public static final String CRS_EVENT_EVENT_JOIN_ROLE = "crsEventEventJoinRole";

        /**
         * 事件-事件接入方式
         */
        public static final String CRS_EVENT_EVENT_DEVICE_TYPE = "crsEventEventDeviceType";

        /**
         * 投诉事件-事件来源
         */
        public static final String CRS_COMPLAINT_EVENT_SOURCE = "crsComplaintEventSource";

        /**
         * 投诉事件-投诉事件-被投诉对象分类
         */
        public static final String CRS_COMPLAINT_EVENT_MERCHANT_TYPE = "crsComplaintEventMerchantType";

        /**
         * 投诉事件-投诉事件-旅游方式
         */
        public static final String CRS_COMPLAINT_EVENT_TOURISM_WAY = "crsComplaintEventTourismWay";

        /**
         * 投诉事件-状态
         */
        public static final String CRS_COMPLAINT_EVENT_STATE = "crsComplaintEventState";

        /**
         * 举报事件-任务状态
         */
        public static final String CRS_REPORT_EVENT_TASK_STATE = "crsReportEventTaskState";

        /**
         * 地图-显示级别
         */
        public static final String CRS_MAP_DISPLAY_LEVEL = "crsMapDisplayLevel";

        /**
         * 设备-设备类型
         */
        public static final String CRS_DEVICE_DEVICE_TYPE = "crsDeviceDeviceType";

        /**
         * 专项行动-行动类型
         */
        public static final String CRS_SPECIALACTION_ACTION_TYPE = "crsSpecialActionActionType";

        /**
         * 专项行动-行动状态
         */
        public static final String CRS_SPECIALACTION_ACTION_STATUS = "crsSpecialActionActionStatus";

        /**
         * 人员状态-设备使用状态
         */
        public static final String CRS_ORG_USER_STATUS_DEVICE_USE_STATUS = "crsOrgUserStatusDeviceUseStatus";

        /**
         * 人员状态-事件处理状态
         */
        public static final String CRS_ORG_USER_STATUS_EVENT_DEAL_STATUS = "crsOrgUserStatusEventDealStatus";

        /**
         * 法度云数据同步类型
         */
        public static final String FADUYUN_SYNCHRONIZE_TYPE = "faDuYunSynchronizeType";

        /**
         * 调度-调度类型
         */
        public static final String CRS_MEETING_MEETING_TYPE = "crsMeetingMeetingType";

    }

    /**
     * 数据字典值常量
     */
    public static class StandCodeValueConstants {
        /**
         * 流转途径-12348厦门法网
         */
        public static final String CIRCULATION_WAY_01 = "01";

        /**
         * 文件类型-图文
         */
        public static final String FILE_TYPE_01 = "01";
        /**
         * 文件类型-音频
         */
        public static final String FILE_TYPE_02 = "02";

        /**
         * 性别-男
         */
        public static final String SEX_01 = "01";
        /**
         * 性别-女
         */
        public static final String SEX_02 = "02";
        /**
         * 是否-是
         */
        public static final String YES_OR_NO_1 = "1";
        /**
         * 是否-否
         */
        public static final String YES_OR_NO_0 = "0";


        /**
         * 卷宗材料-材料类型-调解笔录
         */
        public static final String FILE_MATERIAL_ARCHIVE_TYPE_01 = "01";
        /**
         * 卷宗材料-材料类型-调查笔录
         */
        public static final String FILE_MATERIAL_ARCHIVE_TYPE_02 = "02";
        /**
         * 卷宗材料-材料类型-回访记录
         */
        public static final String FILE_MATERIAL_ARCHIVE_TYPE_03 = "03";
        /**
         * 卷宗材料-材料类型-调解协议书
         */
        public static final String FILE_MATERIAL_ARCHIVE_TYPE_04 = "04";
        /**
         * 卷宗材料-材料类型-调解建议书
         */
        public static final String FILE_MATERIAL_ARCHIVE_TYPE_05 = "05";
        /**
         * 卷宗材料-材料类型-调解申请书
         */
        public static final String FILE_MATERIAL_ARCHIVE_TYPE_06 = "06";
        /**
         * 卷宗材料-材料类型-调解报告
         */
        public static final String FILE_MATERIAL_ARCHIVE_TYPE_07 = "07";

        /**
         * 卷宗材料-材料类型-司法确认申请书
         */
        public static final String FILE_MATERIAL_ARCHIVE_TYPE_08 = "08";
        /**
         * 卷宗材料-材料类型-司法确认裁定书
         */
        public static final String FILE_MATERIAL_ARCHIVE_TYPE_09 = "09";
        /**
         * 卷宗材料-材料类型-驳回申请裁定书
         */
        public static final String FILE_MATERIAL_ARCHIVE_TYPE_10 = "10";
        /**
         * 卷宗材料-材料类型-不予受理告知书
         */
        public static final String FILE_MATERIAL_ARCHIVE_TYPE_11 = "11";
        /*
         * 卷宗材料-材料类型-当事人证据
         */
        public static final String FILE_MATERIAL_ARCHIVE_TYPE_12 = "12";
        /*
         * 卷宗材料-材料类型-受理通知书
         */
        public static final String FILE_MATERIAL_ARCHIVE_TYPE_13 = "13";
        /*
         * 卷宗材料-材料类型-送达地址确认书
         */
        public static final String FILE_MATERIAL_ARCHIVE_TYPE_14 = "14";
        /*
         * 卷宗材料-材料类型-审查笔录（司法）

         */
        public static final String FILE_MATERIAL_ARCHIVE_TYPE_15 = "15";

        /*
         * 卷宗材料-材料类型-调解终止告知书
         */
        public static final String FILE_MATERIAL_ARCHIVE_TYPE_19 = "19";
        /**
         * 卷宗材料-材料类型-其他
         */
        public static final String FILE_MATERIAL_ARCHIVE_TYPE_99 = "99";

        /**
         * 卷宗材料-调解文书材料类型-调解笔录
         */
        public static final String FILE_MATERIAL_BOOK_ARCHIVE_TYPE_01 = "01";
        /**
         * 卷宗材料-调解文书材料类型-调查笔录
         */
        public static final String FILE_MATERIAL_BOOK_ARCHIVE_TYPE_02 = "02";
        /**
         * 卷宗材料-调解文书材料类型-回访记录
         */
        public static final String FILE_MATERIAL_BOOK_ARCHIVE_TYPE_03 = "03";
        /**
         * 卷宗材料-调解文书材料类型-调解协议书
         */
        public static final String FILE_MATERIAL_BOOK_ARCHIVE_TYPE_04 = "04";
        /**
         * 卷宗材料-调解文书材料类型-调解建议书
         */
        public static final String FILE_MATERIAL_BOOK_ARCHIVE_TYPE_05 = "05";
        /**
         * 卷宗材料-调解文书材料类型-调解申请书
         */
        public static final String FILE_MATERIAL_BOOK_ARCHIVE_TYPE_06 = "06";
        /**
         * 卷宗材料-调解文书材料类型-调解报告
         */
        public static final String FILE_MATERIAL_BOOK_ARCHIVE_TYPE_07 = "07";
        /**
         * 卷宗材料-调解文书材料类型-调解终止告知书
         */
        public static final String FILE_MATERIAL_BOOK_ARCHIVE_TYPE_19 = "19";
        /**
         * 卷宗材料-调解文书材料类型-其他
         */
        public static final String FILE_MATERIAL_BOOK_ARCHIVE_TYPE_08 = "99";

        /**
         * 卷宗材料-司法确认材料类型-司法确认申请书
         */
        public static final String FILE_MATERIAL_JUDICIAL_ARCHIVE_TYPE_01 = "08";
        /**
         * 卷宗材料-司法确认材料类型-司法确认裁定书
         */
        public static final String FILE_MATERIAL_JUDICIAL_ARCHIVE_TYPE_02 = "09";
        /**
         * 卷宗材料-司法确认材料类型-驳回申请裁定书
         */
        public static final String FILE_MATERIAL_JUDICIAL_ARCHIVE_TYPE_03 = "10";
        /**
         * 卷宗材料-司法确认材料类型-不予受理告知书
         */
        public static final String FILE_MATERIAL_JUDICIAL_ARCHIVE_TYPE_04 = "11";
        /*
         * 卷宗材料-司法确认材料类型-当事人证据
         */
        public static final String FILE_MATERIAL_JUDICIAL_ARCHIVE_TYPE_05 = "12";
        /*
         * 卷宗材料-司法确认材料类型-受理通知书
         */
        public static final String FILE_MATERIAL_JUDICIAL_ARCHIVE_TYPE_06 = "13";
        /*
         * 卷宗材料-司法确认材料类型-送达地址确认书
         */
        public static final String FILE_MATERIAL_JUDICIAL_ARCHIVE_TYPE_07 = "14";
        /*
         * 卷宗材料-司法确认材料类型-审查笔录（司法）

         */
        public static final String FILE_MATERIAL_JUDICIAL_ARCHIVE_TYPE_08 = "15";
        /**
         * 卷宗材料-司法确认材料类型-其他
         */
        public static final String FILE_MATERIAL_JUDICIAL_ARCHIVE_TYPE_99 = "99";

        /**
         * 菜单栏目所属-前端
         */
        public static final String MENU_HEAD_BELONG_01 = "01";
        /**
         * 菜单栏目所属-移动端
         */
        public static final String MENU_HEAD_BELONG_02 = "02";
        /**
         * 菜单栏目所属-移动端
         */
        public static final String MENU_HEAD_BELONG_03 = "03";
        /**
         * 菜单链接属性-内部链接
         */
        public static final String MENU_LINK_ATTR_01 = "01";
        /**
         * 菜单链接属性-外部链接
         */
        public static final String MENU_LINK_ATTR_02 = "02";
        /**
         * 菜单窗口打开方式-新窗口打开
         */
        public static final String MENU_WINDOW_OPEN_TYPE_01 = "01";
        /**
         * 菜单窗口打开方式-原窗口打开
         */
        public static final String MENU_WINDOW_OPEN_TYPE_02 = "02";

        /**
         * 身份证件类别-身份证
         */
        public static final String ID_CARD_PD_TYPE_01 = "01";
        /**
         * 身份证件类别-护照
         */
        public static final String ID_CARD_PD_TYPE_02 = "02";
        /**
         * 身份证件类别-军官证
         */
        public static final String ID_CARD_PD_TYPE_03 = "03";

        /**
         * 当事人-学历-小学
         */
        public static final String PARTER_EDUCATION_01 = "01";

        /**
         * 当事人-学历-初中
         */
        public static final String PARTER_EDUCATION_02 = "02";

        /**
         * 当事人-学历-高中
         */
        public static final String PARTER_EDUCATION_03 = "03";

        /**
         * 当事人-学历-大专
         */
        public static final String PARTER_EDUCATION_04 = "04";

        /**
         * 当事人-学历-本科
         */
        public static final String PARTER_EDUCATION_05 = "05";

        /**
         * 当事人-学历-硕士
         */
        public static final String PARTER_EDUCATION_06 = "06";

        /**
         * 当事人-学历-博士
         */
        public static final String PARTER_EDUCATION_07 = "07";

        /**
         * 当事人-学历-文盲
         */
        public static final String PARTER_EDUCATION_08 = "08";

        /**
         * 预警事项-辱骂调解员
         */
        public static final String HIGH_RISK_MATTER_01 = "01";

        /**
         * 预警事项-=攻击对方当事人
         */
        public static final String HIGH_RISK_MATTER_02 = "02";

        /**
         * 预警事项-欺诈
         */
        public static final String HIGH_RISK_MATTER_03 = "03";

        /**
         * 预警事项-隐瞒调解员
         */
        public static final String HIGH_RISK_MATTER_04 = "04";

        /**
         * 预警事项-调戏调解员
         */
        public static final String HIGH_RISK_MATTER_05 = "05";

        /**
         * 预警事项-危险性言语
         */
        public static final String HIGH_RISK_MATTER_06 = "06";

        /**
         * 预警事项-其他
         */
        public static final String HIGH_RISK_MATTER_07 = "07";

        /**
         * 业务类型-案件合并暂存
         */
        public static final String CASE_INFO_BUSI_TYPE_01 = "01";

        /**
         * 学历-研究生教育
         */
        public static final String EDUCATION_01 = "01";
        /**
         * 学历-博士研究生毕业
         */
        public static final String EDUCATION_02 = "02";
        /**
         * 学历-博士研究生结业
         */
        public static final String EDUCATION_03 = "03";
        /**
         * 学历-博士研究生肄业
         */
        public static final String EDUCATION_04 = "04";
        /**
         * 学历-硕士研究生毕业
         */
        public static final String EDUCATION_05 = "05";
        /**
         * 学历-硕士研究生结业
         */
        public static final String EDUCATION_06 = "06";
        /**
         * 学历-硕士研究生肄业
         */
        public static final String EDUCATION_07 = "07";
        /**
         * 学历-研究生班毕业
         */
        public static final String EDUCATION_08 = "08";
        /**
         * 学历-研究生班结业
         */
        public static final String EDUCATION_09 = "09";
        /**
         * 学历-研究生班肄业
         */
        public static final String EDUCATION_10 = "10";
        /**
         * 学历-大学本科/专科教育
         */
        public static final String EDUCATION_11 = "11";
        /**
         * 学历-大学本科毕业
         */
        public static final String EDUCATION_12 = "12";
        /**
         * 学历-大学本科结业
         */
        public static final String EDUCATION_13 = "13";
        /**
         * 学历-大学本科肄业
         */
        public static final String EDUCATION_14 = "14";
        /**
         * 学历-大学普通班毕业
         */
        public static final String EDUCATION_15 = "15";
        /**
         * 学历-大学专科毕业
         */
        public static final String EDUCATION_16 = "16";
        /**
         * 学历-大学专科结业
         */
        public static final String EDUCATION_17 = "17";
        /**
         * 学历-大学专科肄业
         */
        public static final String EDUCATION_18 = "18";
        /**
         * 学历-中等职业教育
         */
        public static final String EDUCATION_19 = "19";
        /**
         * 学历-中等专科毕业
         */
        public static final String EDUCATION_20 = "20";
        /**
         * 学历-中等专科结业
         */
        public static final String EDUCATION_21 = "21";
        /**
         * 学历-中等专科肄业
         */
        public static final String EDUCATION_22 = "22";
        /**
         * 学历-职业高中毕业
         */
        public static final String EDUCATION_23 = "23";
        /**
         * 学历-职业高中结业
         */
        public static final String EDUCATION_24 = "24";
        /**
         * 学历-职业高中肆业
         */
        public static final String EDUCATION_25 = "25";
        /**
         * 学历-技工学校毕业
         */
        public static final String EDUCATION_26 = "26";
        /**
         * 学历-技工学校结业
         */
        public static final String EDUCATION_27 = "27";
        /**
         * 学历-技工学校肄业
         */
        public static final String EDUCATION_28 = "28";
        /**
         * 学历-普通高级中学教育
         */
        public static final String EDUCATION_29 = "29";
        /**
         * 学历-普通高中毕业
         */
        public static final String EDUCATION_30 = "30";
        /**
         * 学历-普通高中结业
         */
        public static final String EDUCATION_31 = "31";
        /**
         * 学历-普通高中肄业
         */
        public static final String EDUCATION_32 = "32";
        /**
         * 学历-初级中学教育
         */
        public static final String EDUCATION_33 = "33";
        /**
         * 学历-初中毕业
         */
        public static final String EDUCATION_34 = "34";
        /**
         * 学历-初中肄业
         */
        public static final String EDUCATION_35 = "35";
        /**
         * 学历-小学教育
         */
        public static final String EDUCATION_36 = "36";
        /**
         * 学历-小学毕业
         */
        public static final String EDUCATION_37 = "37";
        /**
         * 学历-小学肆业
         */
        public static final String EDUCATION_38 = "38";
        /**
         * 学历-其他
         */
        public static final String EDUCATION_39 = "39";
        /**
         * 民族-汉族
         */
        public static final String NATION_01 = "01";
        /**
         * 民族-蒙古族
         */
        public static final String NATION_02 = "02";

        /**
         * 民族-回族
         */
        public static final String NATION_03 = "03";

        /**
         * 民族-藏族
         */
        public static final String NATION_04 = "04";

        /**
         * 民族-维吾尔族
         */
        public static final String NATION_05 = "05";

        /**
         * 民族-苗族
         */
        public static final String NATION_06 = "06";

        /**
         * 民族-彝族
         */
        public static final String NATION_07 = "07";

        /**
         * 民族-壮族
         */
        public static final String NATION_08 = "08";

        /**
         * 民族-布依族
         */
        public static final String NATION_09 = "09";

        /**
         * 民族-朝鲜族
         */
        public static final String NATION_10 = "10";

        /**
         * 民族-满族
         */
        public static final String NATION_11 = "11";

        /**
         * 民族-侗族
         */
        public static final String NATION_12 = "12";

        /**
         * 民族-瑶族
         */
        public static final String NATION_13 = "13";

        /**
         * 民族-白族
         */
        public static final String NATION_14 = "14";

        /**
         * 民族-土家族
         */
        public static final String NATION_15 = "15";

        /**
         * 民族-哈尼族
         */
        public static final String NATION_16 = "16";

        /**
         * 民族-哈萨克族
         */
        public static final String NATION_17 = "17";

        /**
         * 民族-傣族
         */
        public static final String NATION_18 = "18";

        /**
         * 民族-黎族
         */
        public static final String NATION_19 = "19";

        /**
         * 民族-僳僳族
         */
        public static final String NATION_20 = "20";

        /**
         * 民族-佤族
         */
        public static final String NATION_21 = "21";

        /**
         * 民族-畲族
         */
        public static final String NATION_22 = "22";

        /**
         * 民族-高山族
         */
        public static final String NATION_23 = "23";

        /**
         * 民族-拉祜族
         */
        public static final String NATION_24 = "24";

        /**
         * 民族-水族
         */
        public static final String NATION_25 = "25";

        /**
         * 民族-东乡族
         */
        public static final String NATION_26 = "26";

        /**
         * 民族-纳西族
         */
        public static final String NATION_27 = "27";

        /**
         * 民族-景颇族
         */
        public static final String NATION_28 = "28";

        /**
         * 民族-柯尔克孜族
         */
        public static final String NATION_29 = "29";

        /**
         * 民族-土族
         */
        public static final String NATION_30 = "30";

        /**
         * 民族-达斡尔族
         */
        public static final String NATION_31 = "31";

        /**
         * 民族-仫佬族
         */
        public static final String NATION_32 = "32";

        /**
         * 民族-羌族
         */
        public static final String NATION_33 = "33";

        /**
         * 民族-布朗族
         */
        public static final String NATION_34 = "34";

        /**
         * 民族-撒拉族
         */
        public static final String NATION_35 = "35";

        /**
         * 民族-毛难族
         */
        public static final String NATION_36 = "36";

        /**
         * 民族-仡佬族
         */
        public static final String NATION_37 = "37";

        /**
         * 民族-锡伯族
         */
        public static final String NATION_38 = "38";

        /**
         * 民族-阿昌族
         */
        public static final String NATION_39 = "39";

        /**
         * 民族-普米族
         */
        public static final String NATION_40 = "40";

        /**
         * 民族-塔吉克族
         */
        public static final String NATION_41 = "41";

        /**
         * 民族-怒族
         */
        public static final String NATION_42 = "42";

        /**
         * 民族-乌孜别克族
         */
        public static final String NATION_43 = "43";

        /**
         * 民族-俄罗斯族
         */
        public static final String NATION_44 = "44";

        /**
         * 民族-鄂温克族
         */
        public static final String NATION_45 = "45";

        /**
         * 民族-崩龙族
         */
        public static final String NATION_46 = "46";

        /**
         * 民族-保安族
         */
        public static final String NATION_47 = "47";

        /**
         * 民族-裕固族
         */
        public static final String NATION_48 = "48";

        /**
         * 民族-京族
         */
        public static final String NATION_49 = "49";

        /**
         * 民族-塔塔尔族
         */
        public static final String NATION_50 = "50";

        /**
         * 民族-独龙族
         */
        public static final String NATION_51 = "51";

        /**
         * 民族-鄂伦春族
         */
        public static final String NATION_52 = "52";

        /**
         * 民族-赫哲族
         */
        public static final String NATION_53 = "53";

        /**
         * 民族-门巴族
         */
        public static final String NATION_54 = "54";

        /**
         * 民族-珞巴族
         */
        public static final String NATION_55 = "55";

        /**
         * 民族-基诺族
         */
        public static final String NATION_56 = "56";

        /**
         * 民族-其它
         */
        public static final String NATION_57 = "57";

        /**
         * 民族-外国血统
         */
        public static final String NATION_58 = "58";

        /**
         * 国籍-中华人民共和国
         */
        public static final String NATIONALITY_01 = "01";
        /**
         * 国籍-中国香港
         */
        public static final String NATIONALITY_02 = "02";
        /**
         * 国籍-中国澳门
         */
        public static final String NATIONALITY_03 = "03";
        /**
         * 国籍-中国台湾
         */
        public static final String NATIONALITY_04 = "04";
        /**
         * 国籍-美国
         */
        public static final String NATIONALITY_05 = "05";
        /**
         * 国籍-俄罗斯
         */
        public static final String NATIONALITY_06 = "06";
        /**
         * 国籍-加拿大
         */
        public static final String NATIONALITY_07 = "07";
        /**
         * 国籍-日本
         */
        public static final String NATIONALITY_08 = "08";
        /**
         * 国籍-英国
         */
        public static final String NATIONALITY_09 = "09";
        /**
         * 国籍-法国
         */
        public static final String NATIONALITY_10 = "10";
        /**
         * 国籍-德国
         */
        public static final String NATIONALITY_11 = "11";
        /**
         * 国籍-意大利
         */
        public static final String NATIONALITY_12 = "12";
        /**
         * 国籍-爱尔兰
         */
        public static final String NATIONALITY_13 = "13";
        /**
         * 国籍-荷兰
         */
        public static final String NATIONALITY_14 = "14";
        /**
         * 国籍-比利时
         */
        public static final String NATIONALITY_15 = "15";
        /**
         * 国籍-卢森堡
         */
        public static final String NATIONALITY_16 = "16";
        /**
         * 国籍-西班牙
         */
        public static final String NATIONALITY_17 = "17";
        /**
         * 国籍-葡萄牙
         */
        public static final String NATIONALITY_18 = "18";
        /**
         * 国籍-希腊
         */
        public static final String NATIONALITY_19 = "19";
        /**
         * 国籍-瑞典
         */
        public static final String NATIONALITY_20 = "20";
        /**
         * 国籍-芬兰
         */
        public static final String NATIONALITY_21 = "21";
        /**
         * 国籍-奥地利
         */
        public static final String NATIONALITY_22 = "22";
        /**
         * 国籍-丹麦
         */
        public static final String NATIONALITY_23 = "23";
        /**
         * 国籍-波兰
         */
        public static final String NATIONALITY_24 = "24";
        /**
         * 国籍-马耳他
         */
        public static final String NATIONALITY_25 = "25";
        /**
         * 国籍-斯洛文尼亚
         */
        public static final String NATIONALITY_26 = "26";
        /**
         * 国籍-匈牙利
         */
        public static final String NATIONALITY_27 = "27";
        /**
         * 国籍-立陶宛
         */
        public static final String NATIONALITY_28 = "28";
        /**
         * 国籍-斯洛伐克
         */
        public static final String NATIONALITY_29 = "29";
        /**
         * 国籍-捷克
         */
        public static final String NATIONALITY_30 = "30";
        /**
         * 国籍-爱沙尼亚
         */
        public static final String NATIONALITY_31 = "31";
        /**
         * 国籍-拉脱维亚
         */
        public static final String NATIONALITY_32 = "32";
        /**
         * 国籍-塞浦路斯
         */
        public static final String NATIONALITY_33 = "33";
        /**
         * 国籍-罗马尼亚
         */
        public static final String NATIONALITY_34 = "34";
        /**
         * 国籍-保加利亚
         */
        public static final String NATIONALITY_35 = "35";
        /**
         * 国籍-澳大利亚
         */
        public static final String NATIONALITY_36 = "36";
        /**
         * 国籍-韩国
         */
        public static final String NATIONALITY_37 = "37";
        /**
         * 国籍-印度
         */
        public static final String NATIONALITY_38 = "38";
        /**
         * 国籍-朝鲜
         */
        public static final String NATIONALITY_39 = "39";
        /**
         * 国籍-蒙古
         */
        public static final String NATIONALITY_40 = "40";
        /**
         * 国籍-老挝
         */
        public static final String NATIONALITY_41 = "41";
        /**
         * 国籍-越南
         */
        public static final String NATIONALITY_42 = "42";
        /**
         * 国籍-柬埔寨
         */
        public static final String NATIONALITY_43 = "43";
        /**
         * 国籍-缅甸
         */
        public static final String NATIONALITY_44 = "44";
        /**
         * 国籍-泰国
         */
        public static final String NATIONALITY_45 = "45";
        /**
         * 国籍-马来西亚
         */
        public static final String NATIONALITY_46 = "46";
        /**
         * 国籍-新加坡
         */
        public static final String NATIONALITY_47 = "47";
        /**
         * 国籍-文莱
         */
        public static final String NATIONALITY_48 = "48";
        /**
         * 国籍-菲律宾
         */
        public static final String NATIONALITY_49 = "49";
        /**
         * 国籍-印度尼西亚
         */
        public static final String NATIONALITY_50 = "50";
        /**
         * 国籍-东帝汶
         */
        public static final String NATIONALITY_51 = "51";
        /**
         * 国籍-尼泊尔
         */
        public static final String NATIONALITY_52 = "52";
        /**
         * 国籍-不丹
         */
        public static final String NATIONALITY_53 = "53";
        /**
         * 国籍-孟加拉
         */
        public static final String NATIONALITY_54 = "54";
        /**
         * 国籍-斯里兰卡
         */
        public static final String NATIONALITY_55 = "55";
        /**
         * 国籍-马尔代夫
         */
        public static final String NATIONALITY_56 = "56";
        /**
         * 国籍-巴基斯坦
         */
        public static final String NATIONALITY_57 = "57";
        /**
         * 国籍-阿富汗
         */
        public static final String NATIONALITY_58 = "58";
        /**
         * 国籍-伊朗
         */
        public static final String NATIONALITY_59 = "59";
        /**
         * 国籍-科威特
         */
        public static final String NATIONALITY_60 = "60";
        /**
         * 国籍-沙特阿拉伯
         */
        public static final String NATIONALITY_61 = "61";
        /**
         * 国籍-巴林
         */
        public static final String NATIONALITY_62 = "62";
        /**
         * 国籍-卡达尔
         */
        public static final String NATIONALITY_63 = "63";
        /**
         * 国籍-阿拉伯联合酋长国
         */
        public static final String NATIONALITY_64 = "64";
        /**
         * 国籍-阿曼
         */
        public static final String NATIONALITY_65 = "65";
        /**
         * 国籍-也门
         */
        public static final String NATIONALITY_66 = "66";
        /**
         * 国籍-伊拉克
         */
        public static final String NATIONALITY_67 = "67";
        /**
         * 国籍-叙利亚
         */
        public static final String NATIONALITY_68 = "68";
        /**
         * 国籍-黎巴嫩
         */
        public static final String NATIONALITY_69 = "69";
        /**
         * 国籍-约旦
         */
        public static final String NATIONALITY_70 = "70";
        /**
         * 国籍-巴勒斯坦
         */
        public static final String NATIONALITY_71 = "71";
        /**
         * 国籍-以色列
         */
        public static final String NATIONALITY_72 = "72";
        /**
         * 国籍-土耳其
         */
        public static final String NATIONALITY_73 = "73";
        /**
         * 国籍-乌兹别克斯坦
         */
        public static final String NATIONALITY_74 = "74";
        /**
         * 国籍-哈萨克斯坦
         */
        public static final String NATIONALITY_75 = "75";
        /**
         * 国籍-吉尔吉斯
         */
        public static final String NATIONALITY_76 = "76";
        /**
         * 国籍-塔吉克斯坦
         */
        public static final String NATIONALITY_77 = "77";
        /**
         * 国籍-亚美尼亚
         */
        public static final String NATIONALITY_78 = "78";
        /**
         * 国籍-土库曼斯坦
         */
        public static final String NATIONALITY_79 = "79";
        /**
         * 国籍-阿塞拜疆
         */
        public static final String NATIONALITY_80 = "80";
        /**
         * 国籍-格鲁吉亚
         */
        public static final String NATIONALITY_81 = "81";
        /**
         * 国籍-埃及
         */
        public static final String NATIONALITY_82 = "82";
        /**
         * 国籍-利比亚
         */
        public static final String NATIONALITY_83 = "83";
        /**
         * 国籍-突尼斯
         */
        public static final String NATIONALITY_84 = "84";
        /**
         * 国籍-阿尔及利亚
         */
        public static final String NATIONALITY_85 = "85";
        /**
         * 国籍-摩洛哥
         */
        public static final String NATIONALITY_86 = "86";
        /**
         * 国籍-撒哈拉
         */
        public static final String NATIONALITY_87 = "87";
        /**
         * 国籍-毛里塔尼亚
         */
        public static final String NATIONALITY_88 = "88";
        /**
         * 国籍-塞内加尔
         */
        public static final String NATIONALITY_89 = "89";
        /**
         * 国籍-冈比亚
         */
        public static final String NATIONALITY_90 = "90";
        /**
         * 国籍-马里
         */
        public static final String NATIONALITY_91 = "91";
        /**
         * 国籍-布基纳法索
         */
        public static final String NATIONALITY_92 = "92";
        /**
         * 国籍-佛得角
         */
        public static final String NATIONALITY_93 = "93";
        /**
         * 国籍-几内亚比绍
         */
        public static final String NATIONALITY_94 = "94";
        /**
         * 国籍-几内亚
         */
        public static final String NATIONALITY_95 = "95";
        /**
         * 国籍-塞拉利昂
         */
        public static final String NATIONALITY_96 = "96";
        /**
         * 国籍-利比里亚
         */
        public static final String NATIONALITY_97 = "97";
        /**
         * 国籍-科特迪瓦
         */
        public static final String NATIONALITY_98 = "98";
        /**
         * 国籍-加纳
         */
        public static final String NATIONALITY_99 = "99";
        /**
         * 国籍-多哥
         */
        public static final String NATIONALITY_100 = "100";
        /**
         * 国籍-贝宁
         */
        public static final String NATIONALITY_101 = "101";
        /**
         * 国籍-尼日尔
         */
        public static final String NATIONALITY_102 = "102";
        /**
         * 国籍-尼日利亚
         */
        public static final String NATIONALITY_103 = "103";
        /**
         * 国籍-喀麦隆
         */
        public static final String NATIONALITY_104 = "104";
        /**
         * 国籍-赤道几内亚
         */
        public static final String NATIONALITY_105 = "105";
        /**
         * 国籍-乍得
         */
        public static final String NATIONALITY_106 = "106";
        /**
         * 国籍-中非
         */
        public static final String NATIONALITY_107 = "107";
        /**
         * 国籍-苏丹
         */
        public static final String NATIONALITY_108 = "108";
        /**
         * 国籍-埃塞俄比亚
         */
        public static final String NATIONALITY_109 = "109";
        /**
         * 国籍-吉布提
         */
        public static final String NATIONALITY_110 = "110";
        /**
         * 国籍-索马里
         */
        public static final String NATIONALITY_111 = "111";
        /**
         * 国籍-肯尼亚
         */
        public static final String NATIONALITY_112 = "112";
        /**
         * 国籍-乌干达
         */
        public static final String NATIONALITY_113 = "113";
        /**
         * 国籍-坦桑尼亚
         */
        public static final String NATIONALITY_114 = "114";
        /**
         * 国籍-卢旺达
         */
        public static final String NATIONALITY_115 = "115";
        /**
         * 国籍-布隆迪
         */
        public static final String NATIONALITY_116 = "116";
        /**
         * 国籍-民主刚果
         */
        public static final String NATIONALITY_117 = "117";
        /**
         * 国籍-刚果
         */
        public static final String NATIONALITY_118 = "118";
        /**
         * 国籍-加蓬
         */
        public static final String NATIONALITY_119 = "119";
        /**
         * 国籍-圣多美和普林西比
         */
        public static final String NATIONALITY_120 = "120";
        /**
         * 国籍-安哥拉
         */
        public static final String NATIONALITY_121 = "121";
        /**
         * 国籍-赞比亚
         */
        public static final String NATIONALITY_122 = "122";
        /**
         * 国籍-马拉维
         */
        public static final String NATIONALITY_123 = "123";
        /**
         * 国籍-莫桑比克
         */
        public static final String NATIONALITY_124 = "124";
        /**
         * 国籍-科摩罗伊斯兰
         */
        public static final String NATIONALITY_125 = "125";
        /**
         * 国籍-马达加斯加
         */
        public static final String NATIONALITY_126 = "126";
        /**
         * 国籍-塞舌尔
         */
        public static final String NATIONALITY_127 = "127";
        /**
         * 国籍-毛里求斯
         */
        public static final String NATIONALITY_128 = "128";
        /**
         * 国籍-津巴布韦
         */
        public static final String NATIONALITY_129 = "129";
        /**
         * 国籍-博茨瓦纳
         */
        public static final String NATIONALITY_130 = "130";
        /**
         * 国籍-纳米比亚
         */
        public static final String NATIONALITY_131 = "131";
        /**
         * 国籍-南非
         */
        public static final String NATIONALITY_132 = "132";
        /**
         * 国籍-斯威士兰
         */
        public static final String NATIONALITY_133 = "133";
        /**
         * 国籍-莱索托
         */
        public static final String NATIONALITY_134 = "134";
        /**
         * 国籍-厄立特尼亚
         */
        public static final String NATIONALITY_135 = "135";
        /**
         * 国籍-冰岛
         */
        public static final String NATIONALITY_136 = "136";
        /**
         * 国籍-挪威
         */
        public static final String NATIONALITY_137 = "137";
        /**
         * 国籍-乌克兰
         */
        public static final String NATIONALITY_138 = "138";
        /**
         * 国籍-白俄罗斯
         */
        public static final String NATIONALITY_139 = "139";
        /**
         * 国籍-摩尔多瓦
         */
        public static final String NATIONALITY_140 = "140";
        /**
         * 国籍-列支敦士登公国
         */
        public static final String NATIONALITY_141 = "141";
        /**
         * 国籍-瑞士
         */
        public static final String NATIONALITY_142 = "142";
        /**
         * 国籍-摩纳哥公国
         */
        public static final String NATIONALITY_143 = "143";
        /**
         * 国籍-安道尔公国
         */
        public static final String NATIONALITY_144 = "144";
        /**
         * 国籍-梵蒂冈
         */
        public static final String NATIONALITY_145 = "145";
        /**
         * 国籍-圣马利诺
         */
        public static final String NATIONALITY_146 = "146";
        /**
         * 国籍-克罗地亚
         */
        public static final String NATIONALITY_147 = "147";
        /**
         * 国籍-波斯尼亚和黑塞哥维那
         */
        public static final String NATIONALITY_148 = "148";
        /**
         * 国籍-马其顿
         */
        public static final String NATIONALITY_149 = "149";
        /**
         * 国籍-塞尔维亚和黑山
         */
        public static final String NATIONALITY_150 = "150";
        /**
         * 国籍-阿尔巴尼亚
         */
        public static final String NATIONALITY_151 = "151";
        /**
         * 国籍-新西兰
         */
        public static final String NATIONALITY_152 = "152";
        /**
         * 国籍-巴布亚新几内亚独立国
         */
        public static final String NATIONALITY_153 = "153";
        /**
         * 国籍-所罗门群岛
         */
        public static final String NATIONALITY_154 = "154";
        /**
         * 国籍-瓦努阿图
         */
        public static final String NATIONALITY_155 = "155";
        /**
         * 国籍-斐济群岛
         */
        public static final String NATIONALITY_156 = "156";
        /**
         * 国籍-基里巴斯
         */
        public static final String NATIONALITY_157 = "157";
        /**
         * 国籍-瑙鲁
         */
        public static final String NATIONALITY_158 = "158";
        /**
         * 国籍-密克罗尼西亚联邦
         */
        public static final String NATIONALITY_159 = "159";
        /**
         * 国籍-马绍尔群岛
         */
        public static final String NATIONALITY_160 = "160";
        /**
         * 国籍-图瓦卢
         */
        public static final String NATIONALITY_161 = "161";
        /**
         * 国籍-萨摩亚独立国
         */
        public static final String NATIONALITY_162 = "162";
        /**
         * 国籍-纽埃
         */
        public static final String NATIONALITY_163 = "163";
        /**
         * 国籍-帕劳
         */
        public static final String NATIONALITY_164 = "164";
        /**
         * 国籍-库克群岛
         */
        public static final String NATIONALITY_165 = "165";
        /**
         * 国籍-汤加
         */
        public static final String NATIONALITY_166 = "166";
        /**
         * 国籍-墨西哥
         */
        public static final String NATIONALITY_167 = "167";
        /**
         * 国籍-危地马拉
         */
        public static final String NATIONALITY_168 = "168";
        /**
         * 国籍-伯里兹
         */
        public static final String NATIONALITY_169 = "169";
        /**
         * 国籍-萨尔瓦多
         */
        public static final String NATIONALITY_170 = "170";
        /**
         * 国籍-洪都拉斯
         */
        public static final String NATIONALITY_171 = "171";
        /**
         * 国籍-尼加拉瓜
         */
        public static final String NATIONALITY_172 = "172";
        /**
         * 国籍-哥斯达黎加
         */
        public static final String NATIONALITY_173 = "173";
        /**
         * 国籍-巴拿马
         */
        public static final String NATIONALITY_174 = "174";
        /**
         * 国籍-巴哈马
         */
        public static final String NATIONALITY_175 = "175";
        /**
         * 国籍-古巴
         */
        public static final String NATIONALITY_176 = "176";
        /**
         * 国籍-牙买加
         */
        public static final String NATIONALITY_177 = "177";
        /**
         * 国籍-海地
         */
        public static final String NATIONALITY_178 = "178";
        /**
         * 国籍-多米尼加
         */
        public static final String NATIONALITY_179 = "179";
        /**
         * 国籍-圣基茨和尼维斯联邦
         */
        public static final String NATIONALITY_180 = "180";
        /**
         * 国籍-安提瓜和巴布达
         */
        public static final String NATIONALITY_181 = "181";
        /**
         * 国籍-多米尼克国
         */
        public static final String NATIONALITY_182 = "182";
        /**
         * 国籍-圣卢西亚
         */
        public static final String NATIONALITY_183 = "183";
        /**
         * 国籍-圣文森特和格林纳丁斯
         */
        public static final String NATIONALITY_184 = "184";
        /**
         * 国籍-巴巴多斯
         */
        public static final String NATIONALITY_185 = "185";
        /**
         * 国籍-格林纳达
         */
        public static final String NATIONALITY_186 = "186";
        /**
         * 国籍-特立尼达和多巴哥
         */
        public static final String NATIONALITY_187 = "187";
        /**
         * 国籍-哥伦比亚
         */
        public static final String NATIONALITY_188 = "188";
        /**
         * 国籍-委内瑞拉玻利瓦尔
         */
        public static final String NATIONALITY_189 = "189";
        /**
         * 国籍-圭亚那合作
         */
        public static final String NATIONALITY_190 = "190";
        /**
         * 国籍-苏里南
         */
        public static final String NATIONALITY_191 = "191";
        /**
         * 国籍-厄瓜多尔
         */
        public static final String NATIONALITY_192 = "192";
        /**
         * 国籍-秘鲁
         */
        public static final String NATIONALITY_193 = "193";
        /**
         * 国籍-巴西联邦
         */
        public static final String NATIONALITY_194 = "194";
        /**
         * 国籍-玻利维亚
         */
        public static final String NATIONALITY_195 = "195";
        /**
         * 国籍-智利
         */
        public static final String NATIONALITY_196 = "196";
        /**
         * 国籍-阿根廷
         */
        public static final String NATIONALITY_197 = "197";
        /**
         * 国籍-巴拉圭
         */
        public static final String NATIONALITY_198 = "198";
        /**
         * 国籍-乌拉圭东岸
         */
        public static final String NATIONALITY_199 = "199";

        /**
         * 操作平台-PC端
         */
        public static final String MEDIATION_OPERATE_TERMINAL_TYPE_01 = "01";
        /**
         * 操作平台-微信端
         */
        public static final String MEDIATION_OPERATE_TERMINAL_TYPE_02 = "02";

        /**
         * 业务当事人快照信息-当事人类型-自然人
         */
        public static final String PARTY_USER_INFO_IDENTITY_TYPE_01 = "01";
        /**
         * 业务当事人快照信息-当事人类型-法人
         */
        public static final String PARTY_USER_INFO_IDENTITY_TYPE_02 = "02";
        /**
         * 业务当事人快照信息-当事人类型-非法人组织
         */
        public static final String PARTY_USER_INFO_IDENTITY_TYPE_03 = "03";

        /**
         * 业务当事人快照信息-业务角色-甲方
         */
        public static final String PARYT_USER_INFO_BIZ_TYPE_BIZ_JOB_TYPE_01 = "01";
        /**
         * 业务当事人快照信息-业务角色-乙方
         */
        public static final String PARYT_USER_INFO_BIZ_TYPE_BIZ_JOB_TYPE_02 = "02";
        /**
         * 业务当事人快照信息-业务角色-代理人
         */
        public static final String PARYT_USER_INFO_BIZ_TYPE_BIZ_JOB_TYPE_03 = "03";

        /**
         * 消息推送-消息类型-短信
         */
        public static final String PUSH_MSG_MASSAGE_TYPE_01 = "01";
        /**
         * 消息推送-消息类型-微信
         */
        public static final String PUSH_MSG_MASSAGE_TYPE_02 = "02";
        /**
         * 消息推送-发送状态-未发送
         */
        public static final String PUSH_MSG_SEND_STATUS_01 = "01";
        /**
         * 消息推送-发送状态-发送中
         */
        public static final String PUSH_MSG_SEND_STATUS_02 = "02";
        /**
         * 消息推送-发送状态-发送成功
         */
        public static final String PUSH_MSG_SEND_STATUS_03 = "03";
        /**
         * 消息推送-发送状态-发送失败
         */
        public static final String PUSH_MSG_SEND_STATUS_04 = "04";
        /**
         * 司法确认-调解编号类型-民特
         */
        public static final String CASE_INFO_JUDICIAL_NUMBER_TYPE_01 = "01";
        /**
         * 司法确认-调解编号年份-2019
         */
        public static final String CASE_INFO_JUDICIAL_NUMBER_YEAR_01 = "01";
        /**
         * 司法确认-调解编号年份-2018
         */
        public static final String CASE_INFO_JUDICIAL_NUMBER_YEAR_02 = "02";
        /**
         * 司法确认-调解编号年份-2017
         */
        public static final String CASE_INFO_JUDICIAL_NUMBER_YEAR_03 = "03";

        /**
         * 调解业务-调解编号类型-公调
         */
        public static final String CASE_INFO_MEDIATE_NUMBER_TYPE_01 = "01";
        /**
         * 调解业务-调解编号年份-2019
         */
        public static final String CASE_INFO_MEDIATE_NUMBER_YEAR_01 = "01";
        /**
         * 调解业务-调解编号年份-2018
         */
        public static final String CASE_INFO_MEDIATE_NUMBER_YEAR_02 = "02";
        /**
         * 调解业务-调解编号年份-2017
         */
        public static final String CASE_INFO_MEDIATE_NUMBER_YEAR_03 = "03";

        /**
         * 调解业务-纠纷类型-交通事故纠纷
         */
        public static final String CASE_INFO_DISPUTE_TYPE_01 = "01";
        /**
         * 调解业务-纠纷类型-家庭婚恋纠纷
         */
        public static final String CASE_INFO_DISPUTE_TYPE_02 = "02";
        /**
         * 调解业务-纠纷类型-邻居纠纷
         */
        public static final String CASE_INFO_DISPUTE_TYPE_03 = "03";
        /**
         * 调解业务-纠纷类型-消费纠纷
         */
        public static final String CASE_INFO_DISPUTE_TYPE_04 = "04";
        /**
         * 调解业务-纠纷类型-劳务、劳资纠纷
         */
        public static final String CASE_INFO_DISPUTE_TYPE_05 = "05";
        /**
         * 调解业务-纠纷类型-经济纠纷
         */
        public static final String CASE_INFO_DISPUTE_TYPE_06 = "06";
        /**
         * 调解业务-纠纷类型-医疗纠纷
         */
        public static final String CASE_INFO_DISPUTE_TYPE_07 = "07";
        /**
         * 调解业务-纠纷类型-征地拆迁纠纷
         */
        public static final String CASE_INFO_DISPUTE_TYPE_08 = "08";
        /**
         * 调解业务-纠纷类型-租凭纠纷
         */
        public static final String CASE_INFO_DISPUTE_TYPE_09 = "09";
        /**
         * 调解业务-纠纷类型-路上水域权属纠纷
         */
        public static final String CASE_INFO_DISPUTE_TYPE_10 = "10";
        /**
         * 调解业务-纠纷类型-执法纠纷
         */
        public static final String CASE_INFO_DISPUTE_TYPE_11 = "11";
        /**
         * 调解业务-纠纷类型-其他纠纷
         */
        public static final String CASE_INFO_DISPUTE_TYPE_12 = "12";
        /**
         * 调解业务-案件来源-现场登记
         */
        public static final String CASE_INFO_CASE_SOURCE_01 = "01";
        /**
         * 调解业务-案件来源-警情平台指派
         */
        public static final String CASE_INFO_CASE_SOURCE_02 = "02";
        /**
         * 调解业务-案件来源-当事人预约
         */
        public static final String CASE_INFO_CASE_SOURCE_03 = "03";

        /**
         * 调解业务-案件状态-待分配
         */
        public static final String CASE_INFO_CASE_STATE_01 = "01";
        /**
         * 调解业务-案件状态-待申请调解
         */
        public static final String CASE_INFO_CASE_STATE_02 = "02";
        /**
         * 调解业务-案件状态-待接收
         */
        public static final String CASE_INFO_CASE_STATE_03 = "03";
        /**
         * 调解业务-案件状态-调解中
         */
        public static final String CASE_INFO_CASE_STATE_04 = "04";
        /**
         * 调解业务-案件状态-调解不成功(原名-调解失败)
         */
        public static final String CASE_INFO_CASE_STATE_05 = "05";
        /**
         * 调解业务-案件状态-调解成功
         */
        public static final String CASE_INFO_CASE_STATE_06 = "06";
        /**
         * 调解业务-案件状态- 其他原因终止(原名-调解终止）
         */
        public static final String CASE_INFO_CASE_STATE_07 = "07";
        /**
         * 调解业务-案件状态-不接收
         */
        public static final String CASE_INFO_CASE_STATE_08 = "08";
        /**
         * 司法确认-案件状态-待申请司法确认
         */
        public static final String CASE_INFO_CASE_STATE_50 = "50";

        /**
         * 司法确认-案件状态-待受理
         */
        public static final String CASE_INFO_CASE_STATE_51 = "51";
        /**
         * 司法确认-案件状态-待审查
         */
        public static final String CASE_INFO_CASE_STATE_52 = "52";
        /**
         * 司法确认-案件状态-确认有效
         */
        public static final String CASE_INFO_CASE_STATE_53 = "53";
        /**
         * 司法确认-案件状态-不予确认
         */
        public static final String CASE_INFO_CASE_STATE_54 = "54";
        /**
         * 司法确认-案件状态-不予受理
         */
        public static final String CASE_INFO_CASE_STATE_55 = "55";
        /**
         * 司法确认-案件状态-超时
         */
        public static final String CASE_INFO_CASE_STATE_56 = "56";

        /**
         * 机构管理-机构类型-公证调解
         */
        public static final String ORG_INFO_TYPE_01 = "01";
        /**
         * 机构管理-机构类型-人民调解
         */
        public static final String ORG_INFO_TYPE_02 = "02";
        /**
         * 机构管理-机构类型-司法调解
         */
        public static final String ORG_INFO_TYPE_03 = "03";
        /**
         * 机构管理-机构类型-法院
         */
        public static final String ORG_INFO_TYPE_04 = "04";
        /**
         * 机构管理-机构类型-公安机关
         */
        public static final String ORG_INFO_TYPE_05 = "05";
        /**
         * 机构管理-机构类型-执法队伍
         */
        public static final String ORG_INFO_TYPE_06 = "06";
        /**
         * 人员管理-人员类型-调解员
         */
        public static final String ORG_USER_PERSON_TYPE_01 = "01";
        /**
         * 人员管理-人员类型-法官
         */
        public static final String ORG_USER_PERSON_TYPE_02 = "02";
        /**
         * 人员管理-人员类型-警官
         */
        public static final String ORG_USER_PERSON_TYPE_03 = "03";
        /**
         * 人员管理-人员类型-书记员
         */
        public static final String ORG_USER_PERSON_TYPE_04 = "04";
        /**
         * 人员管理-人员类型-审核法官
         */
        public static final String ORG_USER_PERSON_TYPE_05 = "05";
        /**
         * 人员管理-人员类型-调解法官
         */
        public static final String ORG_USER_PERSON_TYPE_06 = "06";
        /**
         * 人员管理-人员类型-文旅局执法人员
         */
        public static final String ORG_USER_PERSON_TYPE_07 = "07";

        /**
         * 案件业务-警情类别-民事
         */
        public static final String CASE_INFO_POLICE_TYPE_01 = "01";
        /**
         * 案件业务-警情类别-治安
         */
        public static final String CASE_INFO_POLICE_TYPE_02 = "02";

        /**
         * 案件业务-申请调解方式-在线签名
         */
        public static final String CASE_INFO_MEDIATE_APPLY_METHOD_01 = "01";
        /**
         * 案件业务-申请调解方式-线下签名
         */
        public static final String CASE_INFO_MEDIATE_APPLY_METHOD_02 = "02";

        /**
         * 案件业务-上传方式-手动添加
         */
        public static final String CASE_INFO_UPLOAD_APPLY_METHOD_01 = "01";
        /**
         * 案件业务-上传方式-高扫上传
         */
        public static final String CASE_INFO_UPLOAD_APPLY_METHOD_02 = "02";
        /**
         * 案件业务-上传方式-自动生成
         */
        public static final String CASE_INFO_UPLOAD_APPLY_METHOD_03 = "03";
        /**
         * 案件业务-申请司法确认方式-在线签署
         */
        public static final String CASE_INFO_APPLY_jUDICIAL_CONFIRM_MODE_01 = "01";

        /**
         * 案件业务-申请司法确认方式-线下接受
         */
        public static final String CASE_INFO_APPLY_jUDICIAL_CONFIRM_MODE_02 = "02";
        /**
         * 案件业务-后续处理方式-法院诉讼
         */
        public static final String CASE_INFO_FOLLOW_HANDLE_METHOD_01 = "01";
        /**
         * 案件业务-后续处理方式-人民调解
         */
        public static final String CASE_INFO_FOLLOW_HANDLE_METHOD_02 = "02";
        /**
         * 案件业务-后续处理方式-其他职能部门
         */
        public static final String CASE_INFO_FOLLOW_HANDLE_METHOD_03 = "03";
        /**
         * 案件业务-后续处理方式-尚未处理
         */
        public static final String CASE_INFO_FOLLOW_HANDLE_METHOD_04 = "04";
        /**
         * 案件业务-评价类型-机构评价
         */
        public static final String CASE_INFO_EVALUATION_TYPE_01 = "01";
        /**
         * 案件业务-评价类型-当事人评价
         */
        public static final String CASE_INFO_EVALUATION_TYPE_02 = "02";

        /**
         * 案件业务-纠错状态-待审核
         */
        public static final String CASE_CORRECTION_WAITING_REVIEWER = "0";
        /**
         * 案件业务-纠错状态-审核不通过
         */
        public static final String CASE_CORRECTION_REVIEWER_NO_THROUGH = "1";
        /**
         * 案件业务-纠错状态-待纠错
         */
        public static final String CASE_CORRECTION_REVIEWER_THROUGH = "2";
        /**
         * 案件业务-纠错状态-纠错完成
         */
        public static final String CASE_CORRECTION_COMPLETE = "3";

        /**
         * 司法确认不予受理原因-不属于人民法院受理范围
         */
        public static final String CASE_INFO_jUDICIAL_NOT_ACCEPTANCE_REASON_01 = "01";
        /**
         * 司法确认不予受理原因-不属于收到申请的人民法院管辖
         */
        public static final String CASE_INFO_jUDICIAL_NOT_ACCEPTANCE_REASON_02 = "02";
        /**
         * 司法确认不予受理原因-申请确认婚姻关系、亲子关系、收养关系等身份关系无效、有效或者解除
         */
        public static final String CASE_INFO_jUDICIAL_NOT_ACCEPTANCE_REASON_03 = "03";
        /**
         * 司法确认不予受理原因-涉及适用其他特别程序、公示催告程序、破产程序审理
         */
        public static final String CASE_INFO_jUDICIAL_NOT_ACCEPTANCE_REASON_04 = "04";
        /**
         * 司法确认不予受理原因-调解协议内容涉及物权、知识产权确认的
         */
        public static final String CASE_INFO_jUDICIAL_NOT_ACCEPTANCE_REASON_05 = "05";
        /**
         * 司法确认不予受理原因-材料不足，需补充材料
         */
        public static final String CASE_INFO_jUDICIAL_NOT_ACCEPTANCE_REASON_06 = "06";
        /**
         * 司法确认不予受理原因-自定义
         */
        public static final String CASE_INFO_jUDICIAL_NOT_ACCEPTANCE_REASON_07 = "07";

        /**
         * 申请调解记录-同意
         */
        public static final String MEDIATION_APPLY_RECORD_APPLY_STATE_01 = "01";
        /**
         * 申请调解记录-不同意
         */
        public static final String MEDIATION_APPLY_RECORD_APPLY_STATE_02 = "02";
        /**
         * 案件环节-调解
         */
        public static final String CASE_PROCESS_TYPE_01 = "01";
        /**
         * 案件环节-司法
         */
        public static final String CASE_PROCESS_TYPE_02 = "02";
        /**
         * 当事人采集信息-采集信息类别-电子签名
         */
        public static final String PARYT_COLLECTION_INFO_TYPE_01 = "01";
        /**
         * 当事人信息-委托权限-一般代理
         */
        public static final String PARTY_USER_INFO_ENTRUST_PWOER_01 = "01";

        /**
         * 当事人信息-委托权限-特别授权代理
         */
        public static final String PARTY_USER_INFO_ENTRUST_PWOER_02 = "02";
        /**
         * 当事人信息-被代理人类型-未成年人
         */
        public static final String PARTY_USER_INFO_BE_AGENT_ID_01 = "01";
        /**
         * 当事人信息-被代理人类型-无民事行为能力、限制民事行为能力的精神病人
         */
        public static final String PARTY_USER_INFO_BE_AGENT_ID_02 = "02";

        /**
         * 当事人信息-与当事人的关系-近亲属-配偶
         */
        public static final String PARTY_USER_INFO_WITH_PARTY_REL_01 = "01";
        /**
         * 当事人信息-与当事人的关系-近亲属-父亲
         */
        public static final String PARTY_USER_INFO_WITH_PARTY_REL_02 = "02";
        /**
         * 当事人信息-与当事人的关系-近亲属-母亲
         */
        public static final String PARTY_USER_INFO_WITH_PARTY_REL_03 = "03";
        /**
         * 当事人信息-与当事人的关系-近近亲属-儿子
         */
        public static final String PARTY_USER_INFO_WITH_PARTY_REL_04 = "04";
        /**
         * 当事人信息-与当事人的关系-近亲属-女儿
         */
        public static final String PARTY_USER_INFO_WITH_PARTY_REL_05 = "05";
        /**
         * 当事人信息-与当事人的关系-近亲属-哥哥
         */
        public static final String PARTY_USER_INFO_WITH_PARTY_REL_06 = "06";
        /**
         * 当事人信息-与当事人的关系-近亲属-弟弟
         */
        public static final String PARTY_USER_INFO_WITH_PARTY_REL_07 = "07";
        /**
         * 当事人信息-与当事人的关系-近亲属-姐姐
         */
        public static final String PARTY_USER_INFO_WITH_PARTY_REL_08 = "08";
        /**
         * 当事人信息-与当事人的关系-近亲属-妹妹
         */
        public static final String PARTY_USER_INFO_WITH_PARTY_REL_09 = "09";
        /**
         * 当事人信息-与当事人的关系-近亲属-祖父
         */
        public static final String PARTY_USER_INFO_WITH_PARTY_REL_11 = "11";
        /**
         * 当事人信息-与当事人的关系-近亲属-祖母
         */
        public static final String PARTY_USER_INFO_WITH_PARTY_REL_12 = "12";
        /**
         * 当事人信息-与当事人的关系-近亲属-外祖父
         */
        public static final String PARTY_USER_INFO_WITH_PARTY_REL_13 = "13";
        /**
         * 当事人信息-与当事人的关系-近亲属-孙子
         */
        public static final String PARTY_USER_INFO_WITH_PARTY_REL_14 = "14";
        /**
         * 当事人信息-与当事人的关系-近亲属-外孙子
         */
        public static final String PARTY_USER_INFO_WITH_PARTY_REL_15 = "15";
        /**
         * 当事人信息-与当事人的关系-近亲属-外孙女
         */
        public static final String PARTY_USER_INFO_WITH_PARTY_REL_16 = "16";
        /**
         * 当事人信息-与当事人的关系-律师
         */
        public static final String PARTY_USER_INFO_WITH_PARTY_REL_17 = "17";
        /**
         * 当事人信息-与当事人的关系-推选公民-团体推荐
         */
        public static final String PARTY_USER_INFO_WITH_PARTY_REL_18 = "18";
        /**
         * 当事人信息-与当事人的关系-推选公民-单位推荐
         */
        public static final String PARTY_USER_INFO_WITH_PARTY_REL_19 = "19";
        /**
         * 当事人信息-与当事人的关系-推选公民-社区推荐
         */
        public static final String PARTY_USER_INFO_WITH_PARTY_REL_20 = "20";
        /**
         * 当事人信息-与当事人的关系-其他-基层法律服务工作者
         */
        public static final String PARTY_USER_INFO_WITH_PARTY_REL_21 = "21";
        /**
         * 当事人信息-与当事人的关系-其他-公司员工
         */
        public static final String PARTY_USER_INFO_WITH_PARTY_REL_22 = "22";

        /**
         * 人员花名册-擅长领域-交通事故纠纷
         */
        public static final String ORG_USER_GOOD_ASPECT_TYPE_01 = "01";

        /**
         * 人员花名册-擅长领域-婚姻家庭
         */
        public static final String ORG_USER_GOOD_ASPECT_TYPE_02 = "02";
        /**
         * 人员花名册-擅长领域-邻居纠纷
         */
        public static final String ORG_USER_GOOD_ASPECT_TYPE_03 = "03";
        /**
         * 人员花名册-擅长领域-消费纠纷
         */
        public static final String ORG_USER_GOOD_ASPECT_TYPE_04 = "04";
        /**
         * 人员花名册-擅长领域-劳务、劳资纠纷
         */
        public static final String ORG_USER_GOOD_ASPECT_TYPE_05 = "05";
        /**
         * 人员花名册-擅长领域-经济纠纷
         */
        public static final String ORG_USER_GOOD_ASPECT_TYPE_06 = "06";
        /**
         * 人员花名册-擅长领域-医疗纠纷
         */
        public static final String ORG_USER_GOOD_ASPECT_TYPE_07 = "07";
        /**
         * 人员花名册-擅长领域-征地拆迁纠纷
         */
        public static final String ORG_USER_GOOD_ASPECT_TYPE_08 = "08";
        /**
         * 人员花名册-擅长领域-租凭纠纷
         */
        public static final String ORG_USER_GOOD_ASPECT_TYPE_09 = "09";
        /**
         * 人员花名册-擅长领域-路上水域权属纠纷
         */
        public static final String ORG_USER_GOOD_ASPECT_TYPE_10 = "10";
        /**
         * 人员花名册-擅长领域-执法纠纷
         */
        public static final String ORG_USER_GOOD_ASPECT_TYPE_11 = "11";
        /**
         * 人员花名册-擅长领域-继承纠纷
         */
        public static final String ORG_USER_GOOD_ASPECT_TYPE_12 = "12";
        /**
         * 人员花名册-擅长领域-买卖合同纠纷
         */
        public static final String ORG_USER_GOOD_ASPECT_TYPE_13 = "13";

        /**
         * 人员花名册-值班类型-每月
         */
        public static final String ORG_USER_RESTIME_TYPE_01 = "01";
        /**
         * 人员花名册-值班类型-每周
         */
        public static final String ORG_USER_RESTIME_TYPE_02 = "02";
        /**
         * 人员花名册-每周固定不工作-周一
         */
        public static final String WEEK_01 = "01";
        /**
         * 人员花名册-每周固定不工作-周二
         */
        public static final String WEEK_02 = "02";
        /**
         * 人员花名册-每周固定不工作-周三
         */
        public static final String WEEK_03 = "03";
        /**
         * 人员花名册-每周固定不工作-周四
         */
        public static final String WEEK_04 = "04";
        /**
         * 人员花名册-每周固定不工作-周五
         */
        public static final String WEEK_05 = "05";
        /**
         * 人员花名册-每周固定不工作-周六
         */
        public static final String WEEK_06 = "06";
        /**
         * 人员花名册-每周固定不工作-周日
         */
        public static final String WEEK_07 = "07";

        /**
         * 人员花名册-每月类型
         */
        public static final String MONTH = "01";

        /**
         * 人员花名册-每月固定不工作-1号
         */
        public static final String MONTH_01 = "01";
        /**
         * 人员花名册-每月固定不工作-2号
         */
        public static final String MONTH_02 = "02";
        /**
         * 人员花名册-每月固定不工作-3号
         */
        public static final String MONTH_03 = "03";
        /**
         * 人员花名册-每月固定不工作-4号
         */
        public static final String MONTH_04 = "04";
        /**
         * 人员花名册-每月固定不工作-5号
         */
        public static final String MONTH_05 = "05";
        /**
         * 人员花名册-每月固定不工作-6号
         */
        public static final String MONTH_06 = "06";
        /**
         * 人员花名册-每月固定不工作-7号
         */
        public static final String MONTH_07 = "07";
        /**
         * 人员花名册-每月固定不工作-8号
         */
        public static final String MONTH_08 = "08";
        /**
         * 人员花名册-每月固定不工作-9号
         */
        public static final String MONTH_09 = "09";
        /**
         * 人员花名册-每月固定不工作-10号
         */
        public static final String MONTH_10 = "10";
        /**
         * 人员花名册-每月固定不工作-11号
         */
        public static final String MONTH_11 = "11";
        /**
         * 人员花名册-每月固定不工作-12号
         */
        public static final String MONTH_12 = "12";
        /**
         * 人员花名册-每月固定不工作-13号
         */
        public static final String MONTH_13 = "13";
        /**
         * 人员花名册-每月固定不工作-14号
         */
        public static final String MONTH_14 = "14";
        /**
         * 人员花名册-每月固定不工作-15号
         */
        public static final String MONTH_15 = "15";
        /**
         * 人员花名册-每月固定不工作-16号
         */
        public static final String MONTH_16 = "16";
        /**
         * 人员花名册-每月固定不工作-17号
         */
        public static final String MONTH_17 = "17";
        /**
         * 人员花名册-每月固定不工作-18号
         */
        public static final String MONTH_18 = "18";
        /**
         * 人员花名册-每月固定不工作-19号
         */
        public static final String MONTH_19 = "19";
        /**
         * 人员花名册-每月固定不工作-20号
         */
        public static final String MONTH_20 = "20";
        /**
         * 人员花名册-每月固定不工作-21号
         */
        public static final String MONTH_21 = "21";
        /**
         * 人员花名册-每月固定不工作-22号
         */
        public static final String MONTH_22 = "22";
        /**
         * 人员花名册-每月固定不工作-23号
         */
        public static final String MONTH_23 = "23";
        /**
         * 人员花名册-每月固定不工作-24号
         */
        public static final String MONTH_24 = "24";
        /**
         * 人员花名册-每月固定不工作-25号
         */
        public static final String MONTH_25 = "25";
        /**
         * 人员花名册-每月固定不工作-26号
         */
        public static final String MONTH_26 = "26";
        /**
         * 人员花名册-每月固定不工作-27号
         */
        public static final String MONTH_27 = "27";
        /**
         * 人员花名册-每月固定不工作-28号
         */
        public static final String MONTH_28 = "28";
        /**
         * 人员花名册-每月固定不工作-29号
         */
        public static final String MONTH_29 = "29";
        /**
         * 人员花名册-每月固定不工作-30号
         */
        public static final String MONTH_30 = "30";
        /**
         * 人员花名册-每月固定不工作-31号
         */
        public static final String MONTH_31 = "31";

        /**
         * 人员花名册身份信息职业-科学研究人员
         */
        public static final String ORG_USER_PREFESSION_01 = "01";
        /**
         * 人员花名册身份信息职业-工程技术人员和农林技术人员
         */
        public static final String ORG_USER_PREFESSION_02 = "02";
        /**
         * 人员花名册身份信息职业-科学技术管理人员和辅助人员
         */
        public static final String ORG_USER_PREFESSION_03 = "03";
        /**
         * 人员花名册身份信息职业-飞机和船舶技术人员
         */
        public static final String ORG_USER_PREFESSION_04 = "04";
        /**
         * 人员花名册身份信息职业-卫生技术人员
         */
        public static final String ORG_USER_PREFESSION_05 = "05";
        /**
         * 人员花名册身份信息职业-经济业务人员
         */
        public static final String ORG_USER_PREFESSION_06 = "06";
        /**
         * 人员花名册身份信息职业-法律工作人员
         */
        public static final String ORG_USER_PREFESSION_07 = "07";
        /**
         * 人员花名册身份信息职业-教学人员
         */
        public static final String ORG_USER_PREFESSION_08 = "08";
        /**
         * 人员花名册身份信息职业-文艺、体育工作人员
         */
        public static final String ORG_USER_PREFESSION_09 = "09";
        /**
         * 人员花名册身份信息职业-文化工作人员
         */
        public static final String ORG_USER_PREFESSION_10 = "10";
        /**
         * 人员花名册身份信息职业-宗教职业者
         */
        public static final String ORG_USER_PREFESSION_11 = "11";
        /**
         * 人员花名册身份信息职业-国家机关及其工作机构负责人
         */
        public static final String ORG_USER_PREFESSION_12 = "12";
        /**
         * 人员花名册身份信息职业-党群组织负责人
         */
        public static final String ORG_USER_PREFESSION_13 = "13";
        /**
         * 人员花名册身份信息职业-企、事业单位及其工作机构负责人
         */
        public static final String ORG_USER_PREFESSION_14 = "14";
        /**
         * 人员花名册身份信息职业-行政办事人员
         */
        public static final String ORG_USER_PREFESSION_15 = "15";
        /**
         * 人员花名册身份信息职业-政治保卫工作人员
         */
        public static final String ORG_USER_PREFESSION_16 = "16";
        /**
         * 人员花名册身份信息职业-邮电工作人员
         */
        public static final String ORG_USER_PREFESSION_17 = "17";
        /**
         * 人员花名册身份信息职业-其他办事人员和有关人员
         */
        public static final String ORG_USER_PREFESSION_18 = "18";
        /**
         * 人员花名册身份信息职业-售货人员
         */
        public static final String ORG_USER_PREFESSION_19 = "19";
        /**
         * 人员花名册身份信息职业-采购员和供销人员
         */
        public static final String ORG_USER_PREFESSION_20 = "20";
        /**
         * 人员花名册身份信息职业-收购人员
         */
        public static final String ORG_USER_PREFESSION_ = "21";
        /**
         * 人员花名册身份信息职业-其他商业工作人员
         */
        public static final String ORG_USER_PREFESSION_22 = "22";
        /**
         * 人员花名册身份信息职业-服务性工作人员
         */
        public static final String ORG_USER_PREFESSION_23 = "23";
        /**
         * 人员花名册身份信息职业-农林牧渔劳动者
         */
        public static final String ORG_USER_PREFESSION_24 = "24";
        /**
         * 人员花名册身份信息职业-生产工人、运输工人和有关人员
         */
        public static final String ORG_USER_PREFESSION_25 = "25";
        /**
         * 人员花名册身份信息职业-现役军人
         */
        public static final String ORG_USER_PREFESSION_26 = "26";
        /**
         * 人员花名册身份信息职业-不便分类的其他劳动者
         */
        public static final String ORG_USER_PREFESSION_27 = "27";
        /**
         * 人员花名册-身份-专家
         */
        public static final String ORG_USER_IDENTITY_01 = "01";
        /**
         * 人员花名册-身份-资深律师
         */
        public static final String ORG_USER_IDENTITY_02 = "02";
        /**
         * 人员花名册-身份-资深法官
         */
        public static final String ORG_USER_IDENTITY_03 = "03";
        /**
         * 人员花名册-身份-其他
         */
        public static final String ORG_USER_IDENTITY_04 = "04";

        /**
         * 当事人信息-与当事人的关系类型-近亲属
         */
        public static final String PARTY_WITH_PARTY_REL_TYPE_01 = "01";
        /**
         * 当事人信息-与当事人的关系类型-律师
         */
        public static final String PARTY_WITH_PARTY_REL_TYPE_02 = "02";
        /**
         * 当事人信息-与当事人的关系类型-推选公民
         */
        public static final String PARTY_WITH_PARTY_REL_TYPE_03 = "03";
        /**
         * 当事人信息-与当事人的关系类型-其他
         */
        public static final String PARTY_WITH_PARTY_REL_TYPE_04 = "04";
        /**
         * 模板管理-名称类型-驳回申请裁定书（司法）
         */
        public static final String DOCUMENT_TYPE_01 = "01";
        /**
         * 模板管理-名称类型-不予受理告知书（司法）
         */
        public static final String DOCUMENT_TYPE_02 = "02";
        /**
         * 模板管理-名称类型-公证调解协议书（调解）
         */
        public static final String DOCUMENT_TYPE_03 = "03";
        /**
         * 模板管理-名称类型-审查笔录（司法）
         */
        public static final String DOCUMENT_TYPE_04 = "04";
        /**
         * 模板管理-名称类型-受理告知书（司法）
         */
        public static final String DOCUMENT_TYPE_05 = "05";
        /**
         * 模板管理-名称类型-司法确认裁定书（司法）
         */
        public static final String DOCUMENT_TYPE_06 = "06";
        /**
         * 模板管理-名称类型-司法确认申请书（司法）
         */
        public static final String DOCUMENT_TYPE_07 = "07";
        /**
         * 模板管理-名称类型-送达地址确认书（司法）
         */
        public static final String DOCUMENT_TYPE_08 = "08";
        /**
         * 模板管理-名称类型-调查笔录（调解）
         */
        public static final String DOCUMENT_TYPE_09 = "09";
        /**
         * 模板管理-名称类型-调解笔录（调解）
         */
        public static final String DOCUMENT_TYPE_10 = "10";
        /**
         * 模板管理-名称类型-调解回访笔录
         */
        public static final String DOCUMENT_TYPE_11 = "11";
        /**
         * 模板管理-名称类型-调解申请书（调解）
         */
        public static final String DOCUMENT_TYPE_12 = "12";

        /**
         * 卷宗材料-材料来源-手动上传
         */
        public static final String FILE_MATERIAL_DATA_SOURCE_01 = "01";
        /**
         * 卷宗材料-材料来源-自动生成
         */
        public static final String FILE_MATERIAL_DATA_SOURCE_02 = "02";
        /**
         * 卷宗材料-材料来源-高扫上传
         */
        public static final String FILE_MATERIAL_DATA_SOURCE_03 = "03";
        /**
         * 申请情况-未全部申请
         */
        public static final String IS_ALL_APPLY_MEDIATE_01 = "01";
        /**
         * 申请情况-申请情况
         */
        public static final String IS_ALL_APPLY_MEDIATE_02 = "02";

        /**
         * 登录-人员类型-公众人员
         */
        public static final String LOGIN_USER_TYPE_01 = "01";

        /**
         * 登录-人员类型-机构人员
         */
        public static final String LOGIN_USER_TYPE_02 = "02";

        /**
         * 案件视频房间权限-用户属性-调解员
         */
        public static final String CASE_VIDEO_ROOM_PERMISSION_USER_ATTRIBUTE_01 = "01";

        /**
         * 案件视频房间权限-用户属性-当事人
         */
        public static final String CASE_VIDEO_ROOM_PERMISSION_USER_ATTRIBUTE_02 = "02";

        /**
         * 案件视频房间权限-用户属性-协助专家
         */
        public static final String CASE_VIDEO_ROOM_PERMISSION_USER_ATTRIBUTE_03 = "03";

        /**
         * 案件视频房间权限-用户属性-法官
         */
        public static final String CASE_VIDEO_ROOM_PERMISSION_USER_ATTRIBUTE_04 = "04";

        /**
         * 案件视频房间权限-用户类型-发起人
         */
        public static final String CASE_VIDEO_ROOM_PERMISSION_USER_TYPE_01 = "01";
        /**
         * 案件视频房间权限-用户类型-被邀请人
         */
        public static final String CASE_VIDEO_ROOM_PERMISSION_USER_TYPE_02 = "02";
        /**
         *菜单类型级别-菜单
         */
        public static final String SYS_MENU_TYPE_RANK_01 = "01";
        /**
         * 菜单类型级别-按钮
         */
        public static final String SYS_MENU_TYPE_RANK_02 = "02";
        /**
         * 案件视频房间信息-房间状态-待使用
         */
        public static final String CASE_VIDEO_ROOM_INFO_ROOM_STATUS_00 = "00";
        /**
         * 案件视频房间信息-房间状态-使用中
         */
        public static final String CASE_VIDEO_ROOM_INFO_ROOM_STATUS_01 = "01";
        /**
         * 案件视频房间信息-房间状态-占线
         */
        public static final String CASE_VIDEO_ROOM_INFO_ROOM_STATUS_02 = "02";
        /**
         * 案件视频房间信息-房间状态-结束
         */
        public static final String CASE_VIDEO_ROOM_INFO_ROOM_STATUS_03 = "03";
        /**
         * 案件视频房间信息-房间状态-强制关闭
         */
        public static final String CASE_VIDEO_ROOM_INFO_ROOM_STATUS_04 = "04";

        /**
         * 纠纷类型-治安类-飞车掠夺
         */
        public static final String CASE_INFO_PUBLIC_SECURITY_DISPUTE_TYPE_13 = "13";
        /**
         * 纠纷类型-治安类-徒步夺车
         */
        public static final String CASE_INFO_PUBLIC_SECURITY_DISPUTE_TYPE_14 = "14";
        /**
         * 纠纷类型-治安类-入室入店抢夺
         */
        public static final String CASE_INFO_PUBLIC_SECURITY_DISPUTE_TYPE_15 = "15";
        /**
         * 纠纷类型-治安类-其他抢夺
         */
        public static final String CASE_INFO_PUBLIC_SECURITY_DISPUTE_TYPE_16 = "16";
        /**
         * 纠纷类型-治安类-盗窃摩托车、电动车、助力车、自行车
         */
        public static final String CASE_INFO_PUBLIC_SECURITY_DISPUTE_TYPE_17 = "17";
        /**
         * 纠纷类型-治安类-盗窃机动车、非机动车配件
         */
        public static final String CASE_INFO_PUBLIC_SECURITY_DISPUTE_TYPE_18 = "18";
        /**
         * 纠纷类型-治安类-盗窃车内财物
         */
        public static final String CASE_INFO_PUBLIC_SECURITY_DISPUTE_TYPE_19 = "19";
        /**
         * 纠纷类型-治安类-盗窃生产物资、生活物资、公共设施
         */
        public static final String CASE_INFO_PUBLIC_SECURITY_DISPUTE_TYPE_20 = "20";
        /**
         * 纠纷类型-治安类-其他盗窃
         */
        public static final String CASE_INFO_PUBLIC_SECURITY_DISPUTE_TYPE_21 = "21";
        /**
         * 纠纷类型-治安类-其他诈骗
         */
        public static final String CASE_INFO_PUBLIC_SECURITY_DISPUTE_TYPE_22 = "22";
        /**
         * 纠纷类型-治安类-赌博
         */
        public static final String CASE_INFO_PUBLIC_SECURITY_DISPUTE_TYPE_23 = "23";
        /**
         * 纠纷类型-治安类-引诱、容留、介绍卖淫
         */
        public static final String CASE_INFO_PUBLIC_SECURITY_DISPUTE_TYPE_24 = "24";
        /**
         * 纠纷类型-治安类-制作运输复制出售出租淫秽物品
         */
        public static final String CASE_INFO_PUBLIC_SECURITY_DISPUTE_TYPE_25 = "25";
        /**
         * 纠纷类型-治安类-传播、播放淫秽信息
         */
        public static final String CASE_INFO_PUBLIC_SECURITY_DISPUTE_TYPE_26 = "26";
        /**
         * 纠纷类型-治安类-组织、进行淫秽表演
         */
        public static final String CASE_INFO_PUBLIC_SECURITY_DISPUTE_TYPE_27 = "27";
        /**
         * 纠纷类型-治安类-聚众淫乱
         */
        public static final String CASE_INFO_PUBLIC_SECURITY_DISPUTE_TYPE_28 = "28";
        /**
         * 纠纷类型-治安类-为淫秽活动提供条件
         */
        public static final String CASE_INFO_PUBLIC_SECURITY_DISPUTE_TYPE_29 = "29";
        /**
         * 纠纷类型-治安类-其他卖淫嫖娼活动行为
         */
        public static final String CASE_INFO_PUBLIC_SECURITY_DISPUTE_TYPE_30 = "30";
        /**
         * 纠纷类型-治安类-提供、持有毒品
         */
        public static final String CASE_INFO_PUBLIC_SECURITY_DISPUTE_TYPE_31 = "31";
        /**
         * 纠纷类型-治安类-容留、教唆、欺骗吸毒
         */
        public static final String CASE_INFO_PUBLIC_SECURITY_DISPUTE_TYPE_32 = "32";
        /**
         * 纠纷类型-治安类-介绍买卖毒品
         */
        public static final String CASE_INFO_PUBLIC_SECURITY_DISPUTE_TYPE_33 = "33";
        /**
         * 纠纷类型-治安类-种植买卖储运使用毒品原植物
         */
        public static final String CASE_INFO_PUBLIC_SECURITY_DISPUTE_TYPE_34 = "34";
        /**
         * 纠纷类型-治安类-其他有关毒品行为
         */
        public static final String CASE_INFO_PUBLIC_SECURITY_DISPUTE_TYPE_35 = "35";
        /**
         * 纠纷类型-治安类-其他行政治安警情
         */
        public static final String CASE_INFO_PUBLIC_SECURITY_DISPUTE_TYPE_36 = "36";
        /**
         * 纠纷类型-治安类-违反治安管理的经营活动
         */
        public static final String CASE_INFO_PUBLIC_SECURITY_DISPUTE_TYPE_37 = "37";
        /**
         * 纠纷类型-治安类-结伙斗殴
         */
        public static final String CASE_INFO_PUBLIC_SECURITY_DISPUTE_TYPE_38 = "38";
        /**
         * 纠纷类型-治安类-寻衅滋事
         */
        public static final String CASE_INFO_PUBLIC_SECURITY_DISPUTE_TYPE_39 = "39";
        /**
         * 纠纷类型-治安类-非法侵入、破坏、改变计算机系统、制作、传播计算机破坏性程序
         */
        public static final String CASE_INFO_PUBLIC_SECURITY_DISPUTE_TYPE_40 = "40";
        /**
         * 纠纷类型-治安类-非法制造、买卖、储运、邮寄、携带、使用、提供、处置危险物质
         */
        public static final String CASE_INFO_PUBLIC_SECURITY_DISPUTE_TYPE_41 = "41";
        /**
         * 纠纷类型-治安类-敲诈勒索
         */
        public static final String CASE_INFO_PUBLIC_SECURITY_DISPUTE_TYPE_42 = "42";
        /**
         * 纠纷类型-治安类-损毁公私财物
         */
        public static final String CASE_INFO_PUBLIC_SECURITY_DISPUTE_TYPE_43 = "43";
        /**
         * 纠纷类型-治安类-其他侵犯财产权利
         */
        public static final String CASE_INFO_PUBLIC_SECURITY_DISPUTE_TYPE_44 = "44";
        /**
         * 纠纷类型-治安类-殴打他人、故意伤害
         */
        public static final String CASE_INFO_PUBLIC_SECURITY_DISPUTE_TYPE_45 = "45";
        /**
         * 纠纷类型-治安类-非法限制人身自由
         */
        public static final String CASE_INFO_PUBLIC_SECURITY_DISPUTE_TYPE_46 = "46";
        /**
         * 纠纷类型-治安类-非法侵入住宅
         */
        public static final String CASE_INFO_PUBLIC_SECURITY_DISPUTE_TYPE_47 = "47";
        /**
         * 纠纷类型-治安类-侮辱、诽谤
         */
        public static final String CASE_INFO_PUBLIC_SECURITY_DISPUTE_TYPE_48 = "48";
        /**
         * 纠纷类型-治安类-猥亵、裸露身体
         */
        public static final String CASE_INFO_PUBLIC_SECURITY_DISPUTE_TYPE_49 = "49";
        /**
         * 纠纷类型-治安类-利用他人乞讨、恐怖残忍表演
         */
        public static final String CASE_INFO_PUBLIC_SECURITY_DISPUTE_TYPE_50 = "50";
        /**
         * 纠纷类型-治安类-其他侵犯人身权利
         */
        public static final String CASE_INFO_PUBLIC_SECURITY_DISPUTE_TYPE_51 = "51";
        /**
         * 纠纷类型-治安类-非法集会、游行、示威
         */
        public static final String CASE_INFO_PUBLIC_SECURITY_DISPUTE_TYPE_52 = "52";
        /**
         * 纠纷类型-治安类-违反水上作业人员和船舶治安管理规定
         */
        public static final String CASE_INFO_PUBLIC_SECURITY_DISPUTE_TYPE_53 = "53";
        /**
         * 纠纷类型-治安类-违反企事业单位内部治安保卫管理规定
         */
        public static final String CASE_INFO_PUBLIC_SECURITY_DISPUTE_TYPE_54 = "54";

        /**
         * 纠纷类型-民事求助类-交通纠纷
         */
        public static final String CASE_INFO_CIVIL_DISPUTE_TYPE_01 = "44";
        /**
         * 纠纷类型-民事求助类-家庭婚恋纠纷
         */
        public static final String CASE_INFO_CIVIL_DISPUTE_TYPE_02 = "45";
        /**
         * 纠纷类型-民事求助类-邻居纠纷
         */
        public static final String CASE_INFO_CIVIL_DISPUTE_TYPE_03 = "03";
        /**
         * 纠纷类型-民事求助类-消费纠纷
         */
        public static final String CASE_INFO_CIVIL_DISPUTE_TYPE_04 = "47";
        /**
         * 纠纷类型-民事求助类-劳务、劳资纠纷
         */
        public static final String CASE_INFO_CIVIL_DISPUTE_TYPE_05 = "48";
        /**
         * 纠纷类型-民事求助类-经济纠纷
         */
        public static final String CASE_INFO_CIVIL_DISPUTE_TYPE_06 = "49";
        /**
         * 纠纷类型-民事求助类-医疗纠纷
         */
        public static final String CASE_INFO_CIVIL_DISPUTE_TYPE_07 = "50";
        /**
         * 纠纷类型-民事求助类-征地拆迁纠纷
         */
        public static final String CASE_INFO_CIVIL_DISPUTE_TYPE_08 = "51";
        /**
         * 纠纷类型-民事求助类-租赁纠纷
         */
        public static final String CASE_INFO_CIVIL_DISPUTE_TYPE_09 = "52";
        /**
         * 纠纷类型-民事求助类-路上水域权属纠纷
         */
        public static final String CASE_INFO_CIVIL_DISPUTE_TYPE_10 = "53";
        /**
         * 纠纷类型-民事求助类-执法纠纷
         */
        public static final String CASE_INFO_CIVIL_DISPUTE_TYPE_11 = "54";
        /**
         * 纠纷类型-民事求助类-财产权益纠纷
         */
        public static final String CASE_INFO_CIVIL_DISPUTE_TYPE_55 = "55";
        /**
         * 纠纷类型-民事求助类-劳动争议纠纷
         */
        public static final String CASE_INFO_CIVIL_DISPUTE_TYPE_56 = "56";
        /**
         * 纠纷类型-民事求助类-人身权利纠纷
         */
        public static final String CASE_INFO_CIVIL_DISPUTE_TYPE_57 = "57";
        /**
         * 纠纷类型-民事求助类-损害赔偿纠纷
         */
        public static final String CASE_INFO_CIVIL_DISPUTE_TYPE_58 = "58";
        /**
         * 纠纷类型-民事求助类-生成经营纠纷
         */
        public static final String CASE_INFO_CIVIL_DISPUTE_TYPE_59 = "59";
        /**
         * 纠纷类型-民事求助类-其他纠纷
         */
        public static final String CASE_INFO_CIVIL_DISPUTE_TYPE_12 = "12";
        /**
         * 工作台-按日
         */
        public static final String WORKBENCH_TIME_01 = "1";
        /**
         * 工作台-按月
         */
        public static final String WORKBENCH_TIME_02 = "2";
        /**
         * 工作台-按年
         */
        public static final String WORKBENCH_TIME_03 = "3";

        /**
         * 消息中心-业务类型-调解
         */
        public static final String SMS_CENTER_INFO_BIZ_TYPE_01 = "01";

        /**
         * 消息中心-业务类型-咨询
         */
        public static final String SMS_CENTER_INFO_BIZ_TYPE_02 = "02";
        /**
         * 消息中心-业务类型-机构
         */
        public static final String SMS_CENTER_INFO_BIZ_TYPE_03 = "03";
        /**
         * 消息中心-业务类型-系统用户
         */
        public static final String SMS_CENTER_INFO_BIZ_TYPE_04 = "04";

        /**
         * 消息中心-人员类别-申请人
         */
        public static final String SMS_CENTER_INFO_SENDER_TYPE_01 = "01";

        /**
         * 消息中心-人员类别-被申请人
         */
        public static final String SMS_CENTER_INFO_SENDER_TYPE_02 = "02";

        /**
         * 消息中心-人员类别-代理人
         */
        public static final String SMS_CENTER_INFO_SENDER_TYPE_03 = "03";

        /**
         * 消息中心-人员类别-机构负责人
         */
        public static final String SMS_CENTER_INFO_SENDER_TYPE_04 = "04";

        /**
         * 消息中心-人员类别-调解员
         */
        public static final String SMS_CENTER_INFO_SENDER_TYPE_05 = "05";

        /**
         * 消息中心-人员类别-当事人
         */
        public static final String SMS_CENTER_INFO_SENDER_TYPE_06 = "06";

        /**
         * 消息中心-人员类别-远程视频-协助人员
         */
        public static final String SMS_CENTER_INFO_SENDER_TYPE_07 = "07";

        /**
         * 消息中心-消息类型-调解-24小时预警
         */
        public static final String SMS_CENTER_INFO_SMS_TYPE_01 = "01";

        /**
         * 消息中心-消息类型-调解-30天反馈预警
         */
        public static final String SMS_CENTER_INFO_SMS_TYPE_02 = "02";

        /**
         * 消息中心-消息类型-调解-结案预警
         */
        public static final String SMS_CENTER_INFO_SMS_TYPE_03 = "03";

        /**
         * 消息中心-消息类型-调解-预约提醒时间
         */
        public static final String SMS_CENTER_INFO_SMS_TYPE_04 = "04";

        /**
         * 调解-消息发送-发送客户端类型-短信
         */
        public static final String MEDIATION_MSG_CENTER_CLIENT_01 = "01";

        /**
         * 调解-消息发送-发送客户端类型-微信消息
         */
        public static final String MEDIATION_MSG_CENTER_CLIENT_02 = "02";

        /**
         * 调解-远程视频调解-提示 01 分钟
         */
        public static final String REMINDER_TIME_TYPE_01 = "01";

        /**
         * 调解-远程视频调解-提示  02 小时
         */
        public static final String REMINDER_TIME_TYPE_02 = "02";

        /**
         * 调解-远程视频调解-提示 03 天
         */
        public static final String REMINDER_TIME_TYPE_03 = "03";

        /**
         * 有
         */
        public static final String YES_YES = "01";

        /**
         * 没有
         */
        public static final String NO_NO = "02";

        /**
         * 流转案件状态-待接收
         */
        public static final String CASE_CIRCULATION_STATE_01 = "01";

        /**
         * 流转案件状态-调解中
         */
        public static final String CASE_CIRCULATION_STATE_02 = "02";

        /**
         * 流转案件状态-终止调解
         */
        public static final String CASE_CIRCULATION_STATE_03 = "03";

        /**
         * 流转案件状态-调解成功
         */
        public static final String CASE_CIRCULATION_STATE_04 = "04";

        /**
         * 流转案件状态-退回
         */
        public static final String CASE_CIRCULATION_STATE_05 = "05";

        /**
         * 分色预警-纠纷场所-娱乐场所
         */
        public static final String DISPUTE_PLACE_01 = "01";
        /**
         * 分色预警-纠纷场所-洗浴按摩场所
         */
        public static final String DISPUTE_PLACE_02 = "02";
        /**
         * 分色预警-纠纷场所-餐饮场所
         */
        public static final String DISPUTE_PLACE_03 = "03";
        /**
         * 分色预警-纠纷场所-其他
         */
        public static final String DISPUTE_PLACE_99 = "99";
        /**
         * 前置机操作文件状态-未操作
         */
        public static final String JUDICIAL_PLATFORM_CASE_FILE_OPERATION_STATUS_01 = "01";
        /**
         * 前置机操作文件状态-失败
         */
        public static final String JUDICIAL_PLATFORM_CASE_FILE_OPERATION_STATUS_02 = "02";
        /**
         * 前置机操作文件状态-成功
         */
        public static final String JUDICIAL_PLATFORM_CASE_FILE_OPERATION_STATUS_03 = "03";
        /**
         * 前置机操作文件状态-拉取
         */
        public static final String JUDICIAL_PLATFORM_CASE_FILE_OPERATION_METHOD_01 = "01";
        /**
         * 前置机操作文件状态-推送
         */
        public static final String JUDICIAL_PLATFORM_CASE_FILE_OPERATION_METHOD_02 = "02";
        /**
         * 事件-事件类型-投诉事件
         */
        public static final String CRS_EVENT_EVENT_TYPE_01 = "01";
        /**
         * 事件-事件类型-举报事件
         */
        public static final String CRS_EVENT_EVENT_TYPE_02 = "02";
        /**
         * 事件-事件类型-应急处置
         */
        public static final String CRS_EVENT_EVENT_TYPE_03 = "03";
        /**
         * 事件-事件类型-临时调度
         */
        public static final String CRS_EVENT_EVENT_TYPE_04 = "04";
        /**
         * 事件-事件类型-执法检查
         */
        public static final String CRS_EVENT_EVENT_TYPE_05 = "05";
        /**
         * 事件-事件类型-行政处罚
         */
        public static final String CRS_EVENT_EVENT_TYPE_06 = "06";
        /**
         * 投诉事件-事件来源-厦门市政务热线12345
         */
        public static final String CRS_COMPLAINT_EVENT_SOURCE_01 = "01";
        /**
         * 投诉事件-事件来源-厦门城市公共安全平台110
         */
        public static final String CRS_COMPLAINT_EVENT_SOURCE_02 = "02";
        /**
         * 投诉事件-事件来源-全国旅游监督管理平台12301
         */
        public static final String CRS_COMPLAINT_EVENT_SOURCE_03 = "03";
        /**
         * 投诉事件-事件来源-福建省旅游投诉服务平台12315
         */
        public static final String CRS_COMPLAINT_EVENT_SOURCE_04 = "04";
        /**
         * 投诉事件-事件来源-其他旅游投诉渠道
         */
        public static final String CRS_COMPLAINT_EVENT_SOURCE_05 = "05";
        /**
         * 投诉事件-被投诉对象分类-旅行社
         */
        public static final String CRS_COMPLAINT_EVENT_MERCHANT_TYPE_01 = "01";
        /**
         * 投诉事件-被投诉对象分类-星际饭店
         */
        public static final String CRS_COMPLAINT_EVENT_MERCHANT_TYPE_02 = "02";
        /**
         * 投诉事件-被投诉对象分类-A级景区
         */
        public static final String CRS_COMPLAINT_EVENT_MERCHANT_TYPE_03 = "03";
        /**
         * 投诉事件-被投诉对象分类-其他
         */
        public static final String CRS_COMPLAINT_EVENT_MERCHANT_TYPE_04 = "04";
        /**
         * 投诉事件-旅游方式-国内
         */
        public static final String CRS_COMPLAINT_EVENT_TOURISM_WAY_01 = "01";
        /**
         * 投诉事件-旅游方式-入境
         */
        public static final String CRS_COMPLAINT_EVENT_TOURISM_WAY_02 = "02";
        /**
         * 投诉事件-旅游方式-出境
         */
        public static final String CRS_COMPLAINT_EVENT_TOURISM_WAY_03 = "03";
        /**
         * 投诉事件-状态-办理
         */
        public static final String CRS_COMPLAINT_EVENT_STATE_01 = "01";
        /**
         * 投诉事件-状态-结案
         */
        public static final String CRS_COMPLAINT_EVENT_STATE_02 = "02";
        /**
         * 投诉事件-状态-不受理
         */
        public static final String CRS_COMPLAINT_EVENT_STATE_03 = "03";
        /**
         * 举报事件-任务状态-新增
         */
        public static final String CRS_REPORT_EVENT_TASK_STATE_01 = "01";
        /**
         * 举报事件-任务状态-待一审
         */
        public static final String CRS_REPORT_EVENT_TASK_STATE_02 = "02";
        /**
         * 举报事件-任务状态-一审驳回
         */
        public static final String CRS_REPORT_EVENT_TASK_STATE_03 = "03";
        /**
         * 举报事件-任务状态-待二审
         */
        public static final String CRS_REPORT_EVENT_TASK_STATE_04 = "04";
        /**
         * 举报事件-任务状态-二审驳回
         */
        public static final String CRS_REPORT_EVENT_TASK_STATE_05 = "05";
        /**
         * 举报事件-任务状态-待三审
         */
        public static final String CRS_REPORT_EVENT_TASK_STATE_06 = "06";
        /**
         * 举报事件-任务状态-三审驳回
         */
        public static final String CRS_REPORT_EVENT_TASK_STATE_07 = "07";
        /**
         * 举报事件-任务状态-待分派
         */
        public static final String CRS_REPORT_EVENT_TASK_STATE_08 = "08";
        /**
         * 举报事件-任务状态-待反馈
         */
        public static final String CRS_REPORT_EVENT_TASK_STATE_09 = "09";
        /**
         * 举报事件-任务状态-待办结
         */
        public static final String CRS_REPORT_EVENT_TASK_STATE_10 = "10";
        /**
         * 举报事件-任务状态-已办结
         */
        public static final String CRS_REPORT_EVENT_TASK_STATE_11 = "11";
        /**
         * 事件-事件状态-待处理
         */
        public static final String CRS_EVENT_EVENT_STATUS_01 = "01";
        /**
         * 事件-事件状态-处理中
         */
        public static final String CRS_EVENT_EVENT_STATUS_02 = "02";
        /**
         * 事件-事件状态-已结束
         */
        public static final String CRS_EVENT_EVENT_STATUS_03 = "03";
        /**
         * 地图-显示级别-省级
         */
        public static final String CRS_MAP_DISPLAY_LEVEL_01 = "1";
        /**
         * 地图-显示级别-市级
         */
        public static final String CRS_MAP_DISPLAY_LEVEL_02 = "2";
        /**
         * 地图-显示级别-区级
         */
        public static final String CRS_MAP_DISPLAY_LEVEL_03 = "3";
        /**
         * 地图-显示级别-街道级
         */
        public static final String CRS_MAP_DISPLAY_LEVEL_04 = "4";
        /**
         * 设备-设备类型-监控
         */
        public static final String CRS_DEVICE_DEVICE_TYPE_01 = "01";
        /**
         * 设备-设备类型-单兵执法仪
         */
        public static final String CRS_DEVICE_DEVICE_TYPE_02 = "02";
        /**
         * 设备-设备类型-无人机
         */
        public static final String CRS_DEVICE_DEVICE_TYPE_03 = "03";
        /**
         * 设备-设备类型-移动指挥工作站
         */
        public static final String CRS_DEVICE_DEVICE_TYPE_04 = "04";
        /**
         * 地图-显示数量限制
         */
        public static final String CRS_DISPLAY_NUMBER_LIMIT = "50";
        /**
         * 法度云数据同步-同步类型-投诉事件同步
         */
        public static final String FADUYUN_SYNCHRONIZE_TYPE_01 = "01";
        /**
         * 法度云数据同步-同步类型-检查事件同步
         */
        public static final String FADUYUN_SYNCHRONIZE_TYPE_02 = "02";
        /**
         * 法度云数据同步-同步类型-处罚记录同步
         */
        public static final String FADUYUN_SYNCHRONIZE_TYPE_03 = "03";
        /**
         * 法度云数据同步-同步类型-举报事件同步
         */
        public static final String FADUYUN_SYNCHRONIZE_TYPE_04 = "04";

        /**
         * 事件-事件参与类型-发起方
         */
        public static final String CRS_EVENT_EVENT_JOIN_TYPE_01 = "01";
        /**
         * 事件-事件参与类型-参与方
         */
        public static final String CRS_EVENT_EVENT_JOIN_TYPE_02 = "02";
        /**
         * 事件-事件参与角色-指挥人员
         */
        public static final String CRS_EVENT_EVENT_JOIN_ROLE_01 = "01";
        /**
         * 事件-事件参与角色-队长
         */
        public static final String CRS_EVENT_EVENT_JOIN_ROLE_02 = "02";
        /**
         * 事件-事件参与角色-队员
         */
        public static final String CRS_EVENT_EVENT_JOIN_ROLE_03 = "03";
        /**
         * 事件-事件接入方式-指挥中心
         */
        public static final String CRS_EVENT_EVENT_DEVICE_TYPE_01 = "01";
        /**
         * 事件-事件接入方式-移动设备接入
         */
        public static final String CRS_EVENT_EVENT_DEVICE_TYPE_02 = "02";
        /**
         * 专项行动-行动类型-全国级
         */
        public static final String CRS_SPECIALACTION_ACTION_TYPE_01 = "01";
        /**
         * 专项行动-行动类型-省级
         */
        public static final String CRS_SPECIALACTION_ACTION_TYPE_02 = "02";
        /**
         * 专项行动-行动类型-市级
         */
        public static final String CRS_SPECIALACTION_ACTION_TYPE_03 = "03";
        /**
         * 专项行动-行动状态-进行中
         */
        public static final String CRS_SPECIALACTION_ACTION_STATUS_01 = "01";
        /**
         * 专项行动-行动状态-已结束
         */
        public static final String CRS_SPECIALACTION_ACTION_STATUS_02 = "02";
        /**
         * 人员状态-设备使用状态-使用中
         */
        public static final String CRS_ORG_USER_STATUS_DEVICE_USE_STATUS_01 = "01";
        /**
         * 人员状态-设备使用状态-离线
         */
        public static final String CRS_ORG_USER_STATUS_DEVICE_USE_STATUS_02 = "02";
        /**
         * 人员状态-事件处理状态-处理中
         */
        public static final String CRS_ORG_USER_STATUS_EVENT_DEAL_STATUS_01 = "01";
        /**
         * 人员状态-事件处理状态-空闲
         */
        public static final String CRS_ORG_USER_STATUS_EVENT_DEAL_STATUS_02 = "02";
        /**
         * 调度-调度类型-投诉事件会议
         */
        public static final String CRS_MEETING_MEETING_TYPE_01 = "01";
        /**
         * 调度-调度类型-举报事件会议
         */
        public static final String CRS_MEETING_MEETING_TYPE_02 = "02";
        /**
         * 调度-调度类型-应急处置事件会议
         */
        public static final String CRS_MEETING_MEETING_TYPE_03 = "03";
        /**
         * 调度-调度类型-临时调度事件会议
         */
        public static final String CRS_MEETING_MEETING_TYPE_04 = "04";
        /**
         * 调度-调度类型-执法检查事件会议
         */
        public static final String CRS_MEETING_MEETING_TYPE_05 = "05";
        /**
         * 调度-调度类型-行政处罚事件会议
         */
        public static final String CRS_MEETING_MEETING_TYPE_06 = "06";
        /**
         * 调度-调度类型-专项行动会议
         */
        public static final String CRS_MEETING_MEETING_TYPE_07 = "07";
        /**
         * 调度-调度类型-临时会议
         */
        public static final String CRS_MEETING_MEETING_TYPE_08 = "08";
    }

    /**
     * 文件常量
     */
    public static class FileConstants {
        /**
         * 附件上传根路径
         */
        public static final String attachRootPath = "home/ftpuser/test";
        /**
         * 前置机附件根路径
         */
        public static final String FRONT_ATTACH_ROOT_PATH = "ggaq";
        /**
         * 前置机拉取附件地址
         */
        public static final String FRONT_PULL_PATH = FRONT_ATTACH_ROOT_PATH + "/recv/FROM_SFJ2/SFJDATA";
        /**
         * 前置机上传附件地址
         */
        public static final String FRONT_PUSH_PATH = FRONT_ATTACH_ROOT_PATH + "/cobweb/send/TOSFJ";
    }

    /**
     * 城市代码常量
     */
    public static class AreaCodeConstants {
        /**
         * 级别-省
         */
        public static final String LEVEL_PROVINCE = "province";
        /**
         * 级别-市
         */
        public static final String LEVEL_CITY = "city";
        /**
         * 级别-区
         */
        public static final String LEVEL_COUNTRY = "country";
        /**
         * 级别-街道
         */
        public static final String LEVEL_TOWN = "town";
        /**
         * 级别-社区
         */
        public static final String LEVEL_VILLAGE = "village";
        /**
         * 根父级编码
         */
        public static final String ROOT_PARENT_CODE = "0";
    }

    /**
     * 系统参数类型编码
     */
    public static class SysParamTypeConstants {
        /**
         * 法度云对接配置
         */
        public static final String RUN_TIME_FADUYUN_CONFIG = "RUN_TIME_FADUYUN_CONFIG";
        /**
         * 短信消息模板
         */
        public static final String RUN_TIME_MS_SMS_MSG_TEMPLATE = "RUN_TIME_MS_SMS_MSG_TEMPLATE";
        /**
         * 微信消息模板
         */
        public static final String RUN_TIME_WECHAT_MSG_TEMPLATE = "RUN_TIME_WECHAT_MSG_TEMPLATE";
        /**
         * 美亚柏科对接配置
         */
        public static final String RUN_TIME_MEIYAPICO_CONFIG = "RUN_TIME_MEIYAPICO_CONFIG";
        /**
         * i厦门系统参数配置
         */
        public static final String RUN_TIME_IXM_CONFIG = "RUN_TIME_IXM_CONFIG";
        /**
         * 微信参数配置
         */
        public static final String RUN_TIME_WECHAT_BASE_CONFIG = "RUN_TIME_WECHAT_BASE_CONFIG";
        /**
         * 腾讯实时音视频参数配置
         */
        public static final String RUN_TIME_TENCENT_RTC_CONFIG = "RUN_TIME_TENCENT_RTC_CONFIG";
        /**
         * 高危预警配置
         */
        public static final String RUN_TIME_HIGH_RISK_CONFIG = "RUN_TIME_HIGH_RISK_CONFIG";
        /**
         * 远程视频小程序首页请求参数key
         */
        public static final String WECHAT_MINI_VIDEO_INDEX_REQ_PARAM_KEY = "WECHAT_MINI_VIDEO_INDEX_REQ_PARAM_KEY";
        /**
         * 远程调解预约提醒
         */
        public static final String VIDEO_REMOTE_MEDIATE_CONFIG_TYPE = "VIDEO_REMOTE_MEDIATE_CONFIG_TYPE";
        /**
         * 分色预警颜色配置
         */
        public static final String COLOR_SEPARATION_WARN_COLOR_CONFIGURE = "COLOR_SEPARATION_WARN_COLOR_CONFIGURE";
        /**
         * 分色预警配置信息
         */
        public static final String COLOR_SEPARATION_WARNING_CONFIG_INFO = "COLOR_SEPARATION_WARNING_CONFIG_INFO";
    }

    /**
     * 系统参数编码
     */
    public static class SysParamConstants {
        /**
         * 法度云-请求地址
         */
        public static final String FADUYUN_API_HOST = "FADUYUN_API_HOST";
        /**
         * 法度云-投诉列表地址
         */
        public static final String FADUYUN_COMPLAINSINGLELIST_API_URL = "FADUYUN_COMPLAINSINGLELIST_API_URL";
        /**
         * 法度云-请求token
         */
        public static final String FADUNYUN_TOKEN = "FADUNYUN_TOKEN";
        /**
         * 法度云-举报列表地址
         */
        public static final String FADUYUN_REPORTACCEPTLIST_API_URL = "FADUYUN_REPORTACCEPTLIST_API_URL";
        /**
         * 法度云-行政处罚列表地址
         */
        public static final String FADUYUN_PENALTYLIST_API_URL = "FADUYUN_PENALTYLIST_API_URL";
        /**
         * 法度云-商户列表地址
         */
        public static final String FADUYUN_MERCHANTLIST_API_URL = "FADUYUN_MERCHANTLIST_API_URL";
        /**
         * 法度云-检查记录列表地址
         */
        public static final String FADUYUN_CHECKRECORDLIST_API_URL = "FADUYUN_CHECKRECORDLIST_API_URL";
        /**
         * 法度云-机构列表地址
         */
        public static final String FADUYUN_ORGLIST_API_URL = "FADUYUN_ORGLIST_API_URL";
        /**
         * 法度云-用户列表地址
         */
        public static final String FADUYUN_USERLIST_API_URL = "FADUYUN_USERLIST_API_URL";



        /**
         * 短信----司法确认不予确认
         */
        public static final String MS_JUDICIAL_CONFIRM_NOAPPLY_EFFECTIVE_SMS = "MS_JUDICIAL_CONFIRM_NOAPPLY_EFFECTIVE_SMS";

        /**
         * 短信----司法确认申请已受理通知
         */
        public static final String MS_JUDICIAL_CONFIRM_APPLY_ACCEPT_NOTICE_SMS = "MS_JUDICIAL_CONFIRM_APPLY_ACCEPT_NOTICE_SMS";
        /**
         * 短信----司法确认视频审查通知
         */
        public static final String MS_JUDICIAL_CONFIRM_VIDEO_EXAM_NOTICE_SMS = "MS_JUDICIAL_CONFIRM_VIDEO_EXAM_NOTICE_SMS";
        /**
         * 短信----参加调解提醒
         */
        public static final String MS_PARTY_MEDIATION_REMINDER_SMS = "MS_PARTY_MEDIATION_REMINDER_SMS";
        /**
         * 短信----司法确认申请待处理提醒
         */
        public static final String MS_JUDICIAL_CONFIRM_APPLY_WAIT_HANDLE_REMINDER_SMS = "MS_JUDICIAL_CONFIRM_APPLY_WAIT_HANDLE_REMINDER_SMS";
        /**
         * 短信----司法确认申请不予受理通知
         */
        public static final String MS_JUDICIAL_CONFIRM_APPLY_REFUSE_NOTICE_SMS = "MS_JUDICIAL_CONFIRM_APPLY_REFUSE_NOTICE_SMS";
        /**
         * 短信----调解求助提醒
         */
        public static final String MS_MEDIATION_HELP_REMINDER_SMS = "MS_MEDIATION_HELP_REMINDER_SMS";
        /**
         * 短信----调解即将到期提醒
         */
        public static final String MS_MEDIATION_BE_EXPIRE_SMS = "MS_MEDIATION_BE_EXPIRE_SMS";
        /**
         * 短信----调解案件待处理提醒(现场)
         */
        public static final String MS_MEDIATION_CASE_WAIT_HANDLE_NOTICE_SMS = "MS_MEDIATION_CASE_WAIT_HANDLE_NOTICE_SMS";
        /**
         * 短信----调解案件待处理提醒(非现场)
         */
        public static final String MS_MEDIATION_CASE_WAIT_HANDLE_NOLIVE_SMS = "MS_MEDIATION_CASE_WAIT_HANDLE_NOLIVE_SMS";
        /**
         * 短信----司法确认申请确认有效通知
         */
        public static final String MS_JUDICIAL_CONFIRM_APPLY_EFFECTIVE_SMS = "MS_JUDICIAL_CONFIRM_APPLY_EFFECTIVE_SMS";
        /**
         * 短信----调解信息变更通知(现场：编辑调解信息)
         */
        public static final String MS_MEDIATION_INFO_UPDATE_NOTICE_SMS = "MS_MEDIATION_INFO_UPDATE_NOTICE_SMS";
        /**
         * 短信----调解信息变更通知(修改调解员)
         */
        public static final String MS_MEDIATION_INFO_UPDATE_NOLIVE_SMS = "MS_MEDIATION_INFO_UPDATE_NOLIVE_SMS";
        /**
         * 短信----验证码
         */
        public static final String MS_AUTH_CODE_NOTICE_SMS = "MS_AUTH_CODE_NOTICE_SMS";
        /**
         * 短信----登录密码
         */
        public static final String MS_LOGIN_PWD_NOTICE_SMS = "MS_LOGIN_PWD_NOTICE_SMS";
        /**
         * 短信----重置密码
         */
        public static final String MS_CHANGE_PWD_NOTICE_SMS = "MS_CHANGE_PWD_NOTICE_SMS";
        /**
         * 短信----重点关注案件通知警员/调解员
         */
        public static final String MS_KEY_POINT_CASE_NOTICE_SMS = "MS_KEY_POINT_CASE_NOTICE_SMS";
        /**
         * 短信----重点关注当事人通知警员/调解员
         */
        public static final String MS_KEY_POINT_PARTERS_NOTICE_SMS = "MS_KEY_POINT_PARTERS_NOTICE_SMS";
        /**
         * 短信----远程视频调解
         */
        public static final String MS_REMOTE_VIDEO_MEDIATE_NOTICE_SMS = "MS_REMOTE_VIDEO_MEDIATE_NOTICE_SMS";
        /**
         * 短信----分配调解员
         */
        public static final String MS_MEDIATION_ALLOT_MEDIATOR_SMS = "MS_MEDIATION_ALLOT_MEDIATOR_SMS";
        /**
         * 短信----调解结束
         */
        public static final String MS_MEDIATION_MEDIATE_FINISH_SMS = "MS_MEDIATION_MEDIATE_FINISH_SMS";
        /**
         * 短信----不愿意接受调解
         */
        public static final String MS_MEDIATION_NO_ACCEPT_MEDIATION = "MS_MEDIATION_NO_ACCEPT_MEDIATION";
        /**
         * 短信----案件流转---接收提醒
         */
        public static final String MS_CASE_CIRCULATION_RECEIVE = "MS_CASE_CIRCULATION_RECEIVE";
        /**
         * 短信----案件流转---退回提醒
         */
        public static final String MS_CASE_CIRCULATION_SEND_BACK = "MS_CASE_CIRCULATION_SEND_BACK";
        /**
         * 短信----案件流转---反馈提醒
         */
        public static final String MS_CASE_CIRCULATION_RESPONSE = "MS_CASE_CIRCULATION_RESPONSE";

        /**
         * 短信----案件纠错----审核提醒
         */
        public static final String MS_CASE_CORRECTION_REVIEWEW_REMIND = "MS_CASE_CORRECTION_REVIEWEW_REMIND";

        /**
         * 短信----案件纠错---审核不通过
         */
        public static final String MS_CASE_CORRECTION_REVIEWEW_NO_THROUGH = "MS_CASE_CORRECTION_REVIEWEW_NO_THROUGH";

        /**
         * 短信----案件纠错--审核通过
         */
        public static final String MS_CASE_CORRECTION_REVIEWEW_THROUGH = "MS_CASE_CORRECTION_REVIEWEW_THROUGH";
        /**
         * 短信----文旅局--分配通知
         */
        public static final String MS_CRS_ASSIGN_NOTICE = "MS_CRS_ASSIGN_NOTICE";
        /**
         * 短信----文旅局--指派通知
         */
        public static final String MS_CRS_DISPATCH_NOTICE = "MS_CRS_DISPATCH_NOTICE";
        /**
         * 短信----文旅局--驳回通知
         */
        public static final String MS_CRS_REJECT_NOTICE = "MS_CRS_REJECT_NOTICE";
        /**
         * 短信----文旅局--上报通知
         */
        public static final String MS_CRS_REPORT_NOTICE = "MS_CRS_REPORT_NOTICE";
        /**
         * 短信----文旅局--结案通知
         */
        public static final String MS_CRS_FINISH_EVENT_NOTICE = "MS_CRS_FINISH_EVENT_NOTICE";
        /**
         * 短信----文旅局--会议通知
         */
        public static final String MS_CRS_MEETING_NOTICE = "MS_CRS_MEETING_NOTICE";

        /**
         * 微信小程序APPID
         */
        public static final String WECHAT_MINI_APP_ID = "WECHAT_MINI_APP_ID";
        /**
         * 微信小程序环境值
         */
        public static final String WECHAT_MINI_REQ_VALUE_DEV = "WECHAT_MINI_REQ_VALUE_DEV";
        /**
         * 微信小程序环境值-微信小程序视频房间页面地址
         */
        public static final String WECHAT_MINI_VIDEO_ROOM_PAGE = "WECHAT_MINI_VIDEO_ROOM_PAGE";
        /**
         * 微信小程序环境值
         */
        public static final String WECHAT_MINI_VIDEO_INDEX_PAGE = "WECHAT_MINI_VIDEO_INDEX_PAGE";
        /**
         * 微信小程序请求域名值
         */
        public static final String WECHAT_MINI_REQ_VALUE_DOMAIN = "WECHAT_MINI_REQ_VALUE_DOMAIN";
        /**
         * 微信小程序请求远程应用名值
         */
        public static final String WECHAT_MINI_REQ_VALUE_REMOTE_APP = "WECHAT_MINI_REQ_VALUE_REMOTE_APP";

        /**
         * 小程序请求参数-请求域名KEY
         */
        public static final String WECHAT_MINI_REQ_KEY_DOMAIN = "WECHAT_MINI_REQ_KEY_DOMAIN";

        /**
         * 小程序视频请求参数-用户标识KEY
         */
        public static final String WECHAT_MINI_VIDEO_REQ_KEY_USER_ID = "WECHAT_MINI_VIDEO_REQ_KEY_USER_ID";

        /**
         * 小程序视频请求参数-用户身份KEY
         */
        public static final String WECHAT_MINI_VIDEO_REQ_KEY_USER_IDENTITY = "WECHAT_MINI_VIDEO_REQ_KEY_USER_IDENTITY";

        /**
         * 小程序请求参数-环境变量KEY
         */
        public static final String WECHAT_MINI_REQ_KEY_ENV = "WECHAT_MINI_REQ_KEY_ENV";
        /**
         * 小程序请求参数-远程应用名KEY
         */
        public static final String WECHAT_MINI_REQ_KEY_REMOTE_APP = "WECHAT_MINI_REQ_KEY_REMOTE_APP";
        /**
         * 小程序视频请求参数-案件标识KEY
         */
        public static final String WECHAT_MINI_VIDEO_REQ_KEY_CASE_ID = "WECHAT_MINI_VIDEO_REQ_KEY_CASE_ID";
        /**
         * 小程序视频请求参数-房间号KEY
         */
        public static final String WECHAT_MINI_VIDEO_REQ_KEY_ROOM_NO = "WECHAT_MINI_VIDEO_REQ_KEY_ROOM_NO";
        /**
         * 司法确认申请已受理通知
         */
        public static final String JUDICIAL_CONFIRM_APPLY_ACCEPT_NOTICE = "JUDICIAL_CONFIRM_APPLY_ACCEPT_NOTICE";
        /**
         * 司法确认视频审查通知
         */
        public static final String JUDICIAL_CONFIRM_VIDEO_EXAM_NOTICE = "JUDICIAL_CONFIRM_VIDEO_EXAM_NOTICE";
        /**
         * 参加调解提醒
         */
        public static final String PARTY_MEDIATION_REMINDER = "PARTY_MEDIATION_REMINDER";
        /**
         * 司法确认申请待处理提醒
         */
        public static final String JUDICIAL_CONFIRM_APPLY_WAIT_HANDLE_REMINDER = "JUDICIAL_CONFIRM_APPLY_WAIT_HANDLE_REMINDER";
        /**
         * 司法确认申请不予受理通知
         */
        public static final String JUDICIAL_CONFIRM_APPLY_REFUSE_NOTICE = "JUDICIAL_CONFIRM_APPLY_REFUSE_NOTICE";
        /**
         * 调解求助提醒
         */
        public static final String MEDIATION_HELP_REMINDER = "MEDIATION_HELP_REMINDER";
        /**
         * 调解即将到期提醒
         */
        public static final String MEDIATION_BE_EXPIRE = "MEDIATION_BE_EXPIRE";
        /**
         * 调解案件待处理提醒
         */
        public static final String MEDIATION_CASE_WAIT_HANDLE_NOTICE = "MEDIATION_CASE_WAIT_HANDLE_NOTICE";
        /**
         * 司法确认申请确认有效通知
         */
        public static final String JUDICIAL_CONFIRM_APPLY_EFFECTIVE = "JUDICIAL_CONFIRM_APPLY_EFFECTIVE";
        /**
         * 调解信息变更通知
         */
        public static final String MEDIATION_INFO_UPDATE_NOTICE = "MEDIATION_INFO_UPDATE_NOTICE";
        /**
         * 修改调解员通知
         */
        public static final String MODIFY_MEDIATOR_NOTICE = "MODIFY_MEDIATOR_NOTICE";
        /**
         * 调解结束通知警员
         */
        public static final String MEDIATION_FINISH_NOTICE_POLICE = "MEDIATION_FINISH_NOTICE_POLICE";
        /**
         * 指派成功通知警员
         */
        public static final String APPOINT_SUCCESS_NOTICE_POLICE = "APPOINT_SUCCESS_NOTICE_POLICE";
        /**
         * 快速新增案件通知调解员
         */
        public static final String FAST_ADD_SUCCESS_NOTICE_MEDIATOR = "FAST_ADD_SUCCESS_NOTICE_MEDIATOR";
        /**
         * 重点关注案件通知警员/调解员
         */
        public static final String KEY_POINT_CASE_NOTICE = "KEY_POINT_CASE_NOTICE";
        /**
         * 重点关注当事人通知警员/调解员
         */
        public static final String KEY_POINT_PARTERS_NOTICE = "KEY_POINT_PARTERS_NOTICE";
        /**
         * 远程视频调解
         */
        public static final String REMOTE_VIDEO_MEDIATE_NOTICE = "REMOTE_VIDEO_MEDIATE_NOTICE";
        /**
         * 美亚柏科-请求地址
         */
        public static final String MEIYAPICO_API_HOST = "MEIYAPICO_API_HOST";
        /**
         * 美亚柏科-警情平台请求方法
         */
        public static final String MEIYAPICO_POLICE_PLATFORM_API_URL = "MEIYAPICO_POLICE_PLATFORM_API_URL";
        /**
         * 美亚柏科-appId
         */
        public static final String MEIYAPICO_APP_ID = "MEIYAPICO_APP_ID";
        /**
         * 美亚柏科-appSecret
         */
        public static final String MEIYAPICO_APP_SECRET = "MEIYAPICO_APP_SECRET";
        /**
         * 美亚柏科-timestamp
         */
        public static final String MEIYAPICO_TIME_STAMP = "MEIYAPICO_TIME_STAMP";
        /**
         * i厦门系统参数配置-----应用名
         */
        public static final String IXM_APPNAME = "IXM_APPNAME";

        /**
         * i厦门系统参数配置-----密钥
         */
        public static final String IXM_SECRETKEY = "IXM_SECRETKEY";

        /**
         * i厦门系统参数配置-----pc接收token参数名
         */
        public static final String IXM_TOKEN_PC = "IXM_TOKEN_PC";

        /**
         * i厦门系统参数配置-----微信端token参数名
         */
        public static final String IXM_TOKEN_WECHAT = "IXM_TOKEN_WECHAT";

        /**
         * i厦门系统参数配置-----正式-ids服务地址
         */
        public static final String IXM_PROD_URL_SERVICE_IDS = "IXM_PROD_URL_SERVICE_IDS";

        /**
         * i厦门系统参数配置-----findUserSSO地址
         */
        public static final String IXM_URL_SERVICE_FINDUSERSSO = "IXM_URL_SERVICE_FINDUSERSSO";

        /**
         * i厦门系统参数配置-----正式-公众登录地址
         */
        public static final String IXM_URL_PROD_CITIZEN = "IXM_URL_PROD_CITIZEN";
        /**
         * i厦门系统参数配置-----公众登录后返回地址
         */
        public static final String IXM_RETURN_URL_PROD_CITIZEN = "IXM_RETURN_URL_PROD_CITIZEN";
        /**
         * i厦门系统参数配置-----正式-法人登录地址
         */
        public static final String IXM_URL_PROD_ENTERPRISE = "IXM_URL_PROD_ENTERPRISE";

        /**
         * i厦门系统参数配置-----登出url后缀
         */
        public static final String IXM_LOGINOUT_URL = "IXM_LOGINOUT_URL";
        /**
         * 回调接口成功的重定向地址
         */
        public static final String IXM_REDIRECT_URL = "IXM_REDIRECT_URL";
        /**
         * 调用i厦门的服务器地址
         */
        public static final String IXM_REQUEST_REMOTE_ADDRESS = "IXM_REQUEST_REMOTE_ADDRESS";
        /**
         * i厦门系统参数配置-微信-surl
         */
        public static final String IXM_WECHAT_SURL = "IXM_WECHAT_SURL";

        /**
         * i厦门系统参数配置---微信--正式-公众登录地址
         */
        public static final String IXM_WECHAT_URL_PROD_CITIZEN = "IXM_WECHAT_URL_PROD_CITIZEN";
        /**
         * i厦门系统参数配置--微信--回调接口成功的重定向地址
         */
        public static final String IXM_WECHAT_REDIRECT_URL = "IXM_WECHAT_REDIRECT_URL";
        /**
         * 微信模板消息跳转url
         */
        public static final String WECHAT_TEMPLATE_MSG_RETURN_URL = "WECHAT_TEMPLATE_MSG_RETURN_URL";
        /**
         * 腾讯实时音视频参数配置-公钥
         */
        public static final String TRTC_PUBLIC_KEY = "TRTC_PUBLIC_KEY";
        /**
         * 腾讯实时音视频参数配置-秘钥
         */
        public static final String TRTC_PRIVATE_KEY = "TRTC_PRIVATE_KEY";
        /**
         * 腾讯实时音视频参数配置-SDKappId
         */
        public static final String TRTC_SDK_APP_ID = "TRTC_SDK_APP_ID";
        /**
         * 腾讯实时音视频参数配置-加密秘钥
         */
        public static final String TRTC_SECRET_KEY = "TRTC_SECRET_KEY";
        /**
         * 腾讯实时音视频参数配置-加密标识
         */
        public static final String TRTC_SECRET_ID = "TRTC_SECRET_ID";
        /**
         * 腾讯实时音视频参数配置-bizid
         */
        public static final String TRTC_BIZ_ID = "TRTC_BIZ_ID";
        /**
         * 统计月数
         */
        public static final String STATISTICAL_DAYS = "STATISTICAL_DAYS";
        /**
         * 发生次数
         */
        public static final String HAPPEN_TIMES = "HAPPEN_TIMES";
        /**
         * 高危预警案件展示-发生次数
         */
        public static final String HIGH_RISK_HAPPEN_TIMES = "HIGH_RISK_HAPPEN_TIMES";
        /**
         * 是否同一纠纷
         */
        public static final String THE_SAME_DISPUTE_FLAG = "THE_SAME_DISPUTE_FLAG";

        /**
         * 预警信息配置----------预约提醒第一次
         */
        public static final String VIDEO_REMOTE_MEDIATE_REMIND_FIRST = "VIDEO_REMOTE_MEDIATE_REMIND_FIRST";

        /**
         * 预警信息配置----------预约提醒第二次
         */
        public static final String VIDEO_REMOTE_MEDIATE_REMIND_TWO = "VIDEO_REMOTE_MEDIATE_REMIND_TWO";

        /**
         * 预警信息配置----------预约提醒第三次
         */
        public static final String VIDEO_REMOTE_MEDIATE_REMIND_THREE = "VIDEO_REMOTE_MEDIATE_REMIND_THREE";

        /**
         * 预警信息配置----------预约提醒 当事人 调解员
         */
        public static final String VIDEO_REMOTE_MEDIATE_REMIND_PARTER_MEDIATOR = "VIDEO_REMOTE_MEDIATE_REMIND_PARTER_MEDIATOR";

        /**
         * 预警信息配置----------预约提醒 短信 微信
         */
        public static final String VIDEO_REMOTE_MEDIATE_REMIND_PHONE_WECHAT = "VIDEO_REMOTE_MEDIATE_REMIND_PHONE_WECHAT";

        /**
         * 分色预警颜色配置----------配置颜色一 蓝色
         */
        public static final String CONFIGURE_COLOR_ONE = "CONFIGURE_COLOR_ONE";

        /**
         * 分色预警颜色配置----------配置颜色二 黄色
         */
        public static final String CONFIGURE_COLOR_TWO = "CONFIGURE_COLOR_TWO";

        /**
         * 分色预警颜色配置----------配置颜色三 红色
         */
        public static final String CONFIGURE_COLOR_THREE = "CONFIGURE_COLOR_THREE";

        /**
         * 分色预警颜色配置----------配置颜色四 蓝色预警值以下颜色
         */
        public static final String CONFIGURE_COLOR_FOUR = "CONFIGURE_COLOR_FOUR";


    }

    /**
     * 生成文书常量
     */
    public static class DocumentConstants {
        /**
         * 文书存放下载路径
         */
        public static final String DOCUMENT_DOWNLOAD = "/api/mps-platform-web/download?filePath=";
//        public static final String DOCUMENT_DOWNLOAD = "/api/download?filePath=";
        /**
         * 文书编辑保存路径
         */
        public static final String DOCUMENT_ANA_SAVE = " /api/mps-platform-web/outputDocument/edit/editWordSave?fileUrl=";
//        public static final String DOCUMENT_ANA_SAVE = "/api/outputDocument/edit/editWordSave?fileUrl=";
        /**
         * 文书模板编辑保存路径
         */
        public static final String DOCUMENT_EDIT_SAVE = "/api/mps-platform-web/outputDocument/edit/save?documentId=";
//        public static final String DOCUMENT_EDIT_SAVE = "  /api/outputDocument/edit/save?documentId=";

        /**
         * 对已经生成的文书进行编辑操作
         */
        public static final String DOCUMENT_EDIT_EXIT_SAVE = "/api/mps-platform-web/outputDocument/edit/editAnaSave?saveUrl=";
//        public static final String DOCUMENT_EDIT_EXIT_SAVE = "/api/outputDocument/edit/editAnaSave?saveUrl=";

        /**
         * 对打印生成的文书进行保存操作
         */
        public static final String DOCUMENT_EDIT_PRINT_SAVE = "/api/mps-platform-web/outputDocument/edit/printWordSave?saveUrl=";
//        public static final String DOCUMENT_EDIT_PRINT_SAVE = "/api/outputDocument/edit/printWordSave?saveUrl=";

    }

    /**
     * 分色预警配置常量
     */
    public static class ColorSeparationWarningConfigConstants {
        /**
         *  人物、事项预警配置
         */
        public static final String PEOPLE_AND_EVENTS_WARNING_CONFIG = "peopleAndEventsWarningConfig";
        /**
         *  纠纷类型预警配置
         */
        public static final String DISPUTE_TYPE_WARNING_CONFIG = "disputeTypeWarningConfig";
        /**
         *  纠纷场所预警配置
         */
        public static final String DISPUTE_PLACE_WARNING_CONFIG = "disputePlaceWarningConfig";
        /**
         *  区域预警配置
         */
        public static final String AREA_WARNING_CONFIG = "areaWarningConfig";
        /**
         *  同一人物同一事项预警配置
         */
        public static final String SAME_PERSON_AND_SAME_MATTER_WARNING_CONFIG = "samePersonAndSameMatterWarningConfig";
        /**
         *  同一人物不同事项预警配置
         */
        public static final String SAME_PERSON_AND_DIFFERENT_MATTER_WARNING_CONFIG = "samePersonAndDifferentMatterWarningConfig";
        /**
         *  同一事项不同人物的预警
         */
        public static final String DIFFERENT_PERSON_AND_SAME_MATTER_WARNING_CONFIG = "differentPersonAndSameMatterWarningConfig";
        /**
         *  纠纷类型预警值
         */
        public static final String DISPUTE_TYPE_WARNING_CONFIG_VALUE = "disputeTypeWarningConfigValue";
        /**
         *  纠纷场所预警值
         */
        public static final String DISPUTE_PLACE_WARNING_CONFIG_VALUE = "disputePlaceWarningConfigValue";
        /**
         * 蓝色
         */
        public static final String BLUE = "blue";
        /**
         *  黄色
         */
        public static final String YELLOW = "yellow";
        /**
         *  红色
         */
        public static final String RED = "red";
        /**
         * 颜色一rgb值（默认蓝色）
         */
        public static final String CONFIGURE_COLOR_ONE =  "#369ffd";
        /**
         * 颜色一rgb值（默认黄色）
         */
        public static final String CONFIGURE_COLOR_TWO =  "#ecd036";
        /**
         * 颜色一rgb值（默认红色）
         */
        public static final String CONFIGURE_COLOR_THREE =  "#fd5a58";
        /**
         * 颜色一rgb值（默认绿色）
         */
        public static final String CONFIGURE_COLOR_FOUR =  "#7fb89c";

        /**
         * 民事案件纠纷类型预警分析
         */
        public static final Integer COLOR_SEPARATION_WARN_CHART_FLAG_1 = 1;
        /**
         * 纠纷场所预警分析
         */
        public static final Integer COLOR_SEPARATION_WARN_CHART_FLAG_2 = 2;
        /**
         * 同一人物同一事项预警分析
         */
        public static final Integer COLOR_SEPARATION_WARN_CHART_FLAG_3 = 3;
        /**
         * 同一人物不同事项预警分析
         */
        public static final Integer COLOR_SEPARATION_WARN_CHART_FLAG_4 = 4;
        /**
         * 同一事项不同人物预警分析
         */
        public static final Integer COLOR_SEPARATION_WARN_CHART_FLAG_5 = 5;

        /**
         * 纠纷诱因作为一级
         */
        public static final String DISPUTE_CAUSE_FIRST_STAGE = "0";
    }
}
