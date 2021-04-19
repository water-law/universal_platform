package com.weitu.mpsplatform.commons.enums;

/**
 * 数据权限级别枚举
 */
public enum DataPermissionLevelEnum {
    /**
     * 都不可见
     */
    LEVEL_NONE(1),
    /**
     * 只能查看自身
     */
    LEVEL_SELF(2),
    /**
     * 只能查看本部门及本部门的子部门所有人员
     */
    LEVEL_ORG(3),
    /**
     * 可以查看全部
     */
    LEVEL_ALL(4);

    private int levelValue;

    DataPermissionLevelEnum(int levelValue) {
        this.levelValue = levelValue;
    }

    public int getLevelValue() {
        return levelValue;
    }

    public static DataPermissionLevelEnum getByLevelValue(int levelValue) {
        for(DataPermissionLevelEnum tmp : DataPermissionLevelEnum.values()) {
            if (tmp.levelValue == levelValue) {
                return tmp;
            }
        }
        return null;
    }


}
