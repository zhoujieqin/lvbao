package com.ater.lvbao.common.utils;

/**
 * Redis所有Keys
 *
 * @author
 * @create 2017-04-01
 */
public class RedisKeys {
    /**
     * 取得系统设置缓存key
     *
     * @param key
     * @return
     */
    public static String getSysConfigKey(String key) {
        return "sys:config:" + key;
    }
}
