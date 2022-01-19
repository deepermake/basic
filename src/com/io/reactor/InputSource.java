package com.io.reactor;

/**
 * @description 输入对象，reactor模式中处理端原始输入对象
 * @Date 2022/1/19 10:00
 * @Created by lianhai.deng
 */

public class InputSource {

    private Object data;

    private Long id;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
