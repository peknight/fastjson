package com.peknight.fastjson.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * 测试类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FooBar {
    /**
     * 日期
     */
    // @JSONField(format = "yyyyMMdd")
    private LocalDate date;
    /**
     * 时间
     */
    private LocalTime time;
}
