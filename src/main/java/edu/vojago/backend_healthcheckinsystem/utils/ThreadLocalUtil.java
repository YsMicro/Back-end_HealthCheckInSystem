package edu.vojago.backend_healthcheckinsystem.utils;

import java.util.Map;

public class ThreadLocalUtil {

    //提供ThreadLocal对象
    private static final ThreadLocal<Map<String, Object>> THREAD_LOCAL = new ThreadLocal<>();

    //根据键获取值
    public static <T> T get() {
        return (T) THREAD_LOCAL.get();
    }

    //存储键值对
    public static void set(Map<String, Object> value) {
        THREAD_LOCAL.set(value);
    }

    //清除ThreadLocal，防止内存泄露
    public static void remove() {
        THREAD_LOCAL.remove();
    }

    //获取管理员ID
    public static Integer getAdminId() {
        Map<String, Object> claims = THREAD_LOCAL.get();
        return (Integer) claims.get("admin_id");
    }
}