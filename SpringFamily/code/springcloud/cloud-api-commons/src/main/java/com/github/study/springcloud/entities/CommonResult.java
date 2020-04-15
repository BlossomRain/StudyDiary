package com.github.study.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Auther: lxz
 * @Date: 2020/4/14 0014
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
//JSON通用结果集
public class CommonResult<T> {
    private Integer code;
    private String message;
    private T data;

    public CommonResult(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
