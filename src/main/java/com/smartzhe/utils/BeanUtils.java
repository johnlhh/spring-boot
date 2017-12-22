package com.smartzhe.utils;


import com.google.common.base.Optional;
import org.springframework.cglib.beans.BeanCopier;


/**
 * @Description
 * @Author andy.chen
 * @CreateDate 2017/6/7
 */
public class BeanUtils {

    /**
     * use the way of bytecode
     * @param targetClazz
     * @param source
     * @param <T>
     * @return
     */
    public static <T> T copyBean(Class<T> targetClazz,Object source){
        T target = null;
        try {
            final BeanCopier copier = BeanCopier.create(source.getClass(), targetClazz, false);
            target = targetClazz.newInstance();
            copier.copy(source,target,null);
        }catch(Exception e){
            e.printStackTrace();
        }
        return target;
    }

    public static <T> T optional(T t, T defaultValue) {
        return Optional.fromNullable(t).or(defaultValue);
    }
}
