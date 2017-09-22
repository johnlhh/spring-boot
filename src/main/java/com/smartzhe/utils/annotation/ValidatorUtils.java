package com.smartzhe.utils.annotation;

import javax.validation.ConstraintValidatorContext;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.groups.Default;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: luohuahua
 * Date: 2017/9/22
 * Time: 14:17  .
 */
public class ValidatorUtils {

    private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    public static <T> void validate(T obj) {
        Map<String, StringBuffer> errorMap = null;
        Set<ConstraintViolation<T>> set = validator.validate(obj, Default.class);
        if (set != null && set.size() > 0) {
            errorMap = new HashMap<>();
            String property = null;
            for (ConstraintViolation<T> cv : set) {
                //这里循环获取错误信息，可以自定义格式
                property = cv.getPropertyPath().toString();
                if (errorMap.get(property) != null) {
                    errorMap.get(property).append("," + cv.getMessage());
                } else {
                    StringBuffer sb = new StringBuffer();
                    sb.append(cv.getMessage());
                    errorMap.put(property, sb);
                }
            }
            throw new IllegalArgumentException(print(errorMap));
        }

    }

    public static void changeDefaultMessage(String message, ConstraintValidatorContext context) {
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(message).addConstraintViolation();
    }

    private static String print(Map<String, StringBuffer> errorMap) {
        if (errorMap != null && !errorMap.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, StringBuffer> m : errorMap.entrySet()) {
                sb.append(m.getKey() + ":" + m.getValue().toString()).append(";");
            }
            return sb.substring(0, sb.length() - 1);
        }
        return null;
    }
}
