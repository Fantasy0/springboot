package com.example.mybatisdemo.base;

public class BaseDTO {
    private static final long serialVersionUID = 1L;

    /**
     * 成功
     */
    public static final int CODE_SUCCESS = 200;

    /**
     * 参数问题不对
     */
    public static final int CODE_PARAM = 400;

    /**
     * 条件不满足
     */
    public static final int CODE_NOT_ACCEPT = 406;

    /**
     * 前端订单弹框
     */
    public static final int CODE_NOT_ACCEPT_ORDER = 4061;

    /**
     * 用户请登录
     */
    public static final int CODE_LOGIN = 401;

    /**
     * 未授予权限
     */
    public static final int CODE_AUTHORITY = 403;

    /**
     * 程序错误，内部服务器错误
     */
    public static final int CODE_ERROR = 500;


    /**
     * 200: 正常
     * 400: 前端可处理的问题
     * 500: 前端不可处理的问题
     * **/
    private Integer code = CODE_SUCCESS;
    /**
     * 消息
     * */
    private String message ;
    /**
     * 返回数据
     * **/
    private Object data;

    public BaseDTO(){

    }

    public BaseDTO(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public BaseDTO setCode(Integer code) {
        this.code = code;
        return this;
    }
    public String getMessage() {
        return message;
    }

    public BaseDTO setMessage(String message) {
        this.message = message;
        return this;
    }
    public Object getData() {
        return data;
    }

    public BaseDTO setData(Object data) {
        this.data = data;
        return this;
    }

    public static BaseDTO successBaseDTO(){
        return new BaseDTO(CODE_SUCCESS, "操作成功", null);
    }

    public static BaseDTO successBaseDTO(Object data){
        return new BaseDTO(CODE_SUCCESS, "操作成功", data);
    }

    public static BaseDTO failBaseDTO(){
        return new BaseDTO(CODE_ERROR, "操作失败", null);
    }

    public static BaseDTO failBaseDTO(Object data){
        return new BaseDTO(CODE_ERROR, "操作失败", data);
    }

    @Override
    public String toString() {
        return "BaseDTO{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

}
