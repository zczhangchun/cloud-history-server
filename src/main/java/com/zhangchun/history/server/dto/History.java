package com.zhangchun.history.server.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhangchun
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class History {

    private Integer itemId;

    private Long firstTime;

    private Long lastTime;

    private Integer count;
}
