package com.weibin.vm;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/4/10
 **/
public enum  EnumTest {

    key("key");

    private String code;

    public String getCode(){
        return code;
    }

    EnumTest(String code){
        this.code = code;
    }

    void setCode(String code){
        this.code = code;
    }

    public static void main(String[] args) {
        EnumTest.key.setCode("111");
        System.out.println(EnumTest.key.getCode());
    }


}
