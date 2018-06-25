package org.litespring.beans.factory.config;

/**
 * 每一条 <property><property/> 标签 中的 value = "" 的值
 * @author luqi
 * @data 2018/6/24
 */
public class TypedStringValue {

    private String value;
    public TypedStringValue(String value) {
        this.value = value;
    }
    public String getValue() {
        return this.value;
    }
}
