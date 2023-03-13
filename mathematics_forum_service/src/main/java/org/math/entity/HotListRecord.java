package org.math.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class HotListRecord implements Serializable {
    /**
     * 主键 id
     */
    private int id;
    /**
     * 日期
     */
    private LocalDate date;
    /**
     * post id 列表
     */
    private String hotIdList;
}
