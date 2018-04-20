package com.ater.lvbao.common.validator;

import com.ater.lvbao.common.exception.MyException;
import org.apache.commons.lang.StringUtils;

/**
 * 数据校验
 *
 * @author
 * @create 2017-04-01
 **/
public abstract class Assert {
    /**
     * 判断null和空字符串
     *
     * @param str
     * @param message
     */
    public static void isBlank(String str, String message) {
        if (StringUtils.isBlank(str)) {
            throw new MyException(message);
        }
    }

    /**
     * 判断null
     *
     * @param object
     * @param message
     */
    public static void isNull(Object object, String message) {
        if (object == null) {
            throw new MyException(message);
        }
    }
}
