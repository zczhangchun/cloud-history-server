package com.zhangchun.history.server.dao;

import com.zhangchun.history.server.dto.History;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HistoryDao {

    List<History> selectByUidAndItemType(@Param("userType") Integer userType, @Param("uid") String uid, @Param("itemType") int itemType);

    void deleteByGid(@Param("userType") Integer userType, @Param("uid") String uid, @Param("itemType") Integer itemType, @Param("gid") Integer gid);

    void deleteByItemType(@Param("userType") Integer userType, @Param("uid") String uid, @Param("itemType") Integer itemType);
}