package com.zhangchun.history.server.controller;

import com.zhangchun.history.server.dto.History;
import com.zhangchun.history.server.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zhangchun
 */
@RestController
@RequestMapping("history")
public class HistoryController {

    @Autowired
    private HistoryService historyService;


    @RequestMapping(value = "{userType}/{uid}/{itemType}")
    public ResponseEntity<List<History>> getHistoryByUidAndItemType(@PathVariable("userType") Integer userType,
                                                                    @PathVariable("uid") String uid,
                                                                    @PathVariable("itemType") Integer itemType) {

        return ResponseEntity.ok(historyService.getHistoryByUidAndItemType(userType, uid, itemType));

    }

    @RequestMapping("{userType}/{uid}/{itemType}/{gid}")
    public ResponseEntity<Void> deleteHistoryByGid(@PathVariable("userType") Integer userType,
                                                   @PathVariable("uid") String uid,
                                                   @PathVariable("itemType") Integer itemType,
                                                   @PathVariable("gid") Integer gid) {

        historyService.deleteHistoryByGid(userType, uid, itemType, gid);
        return ResponseEntity.ok().build();
    }

    @RequestMapping("delete/{userType}/{uid}/{itemType}")
    public ResponseEntity<Void> clearHistoryByItemType(@PathVariable("userType") Integer userType,
                                                       @PathVariable("uid") String uid,
                                                       @PathVariable("itemType") Integer itemType) {

        historyService.clearHistoryByItemType(userType, uid, itemType);
        return ResponseEntity.ok().build();
    }
}
