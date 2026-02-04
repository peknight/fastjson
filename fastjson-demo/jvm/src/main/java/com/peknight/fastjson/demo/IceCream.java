package com.peknight.fastjson.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 测试类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class IceCream {
    /**
     * 名称
     */
    private String name;
    /**
     * 数量
     */
    private Integer numCherries;
    /**
     * 蛋筒
     */
    private Boolean inCone;
}
