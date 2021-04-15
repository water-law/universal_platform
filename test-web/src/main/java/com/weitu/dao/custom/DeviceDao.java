package com.weitu.dao.custom;

import com.weitu.model.gen.Device;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 设备信息Dao
 */
public interface DeviceDao {

    /**
     * 查询记录列表
     *
     * @param record
     * @return
     */
    List<Device> selectByPage(@Param("record") Device record,
    @Param("pageBegin") int pageBegin,
    @Param("pageSize") int pageSize);

    /**
    * 查询记录总数
    *
    * @param record
    * @return
    */
    int selectCount(@Param("record") Device record);

}