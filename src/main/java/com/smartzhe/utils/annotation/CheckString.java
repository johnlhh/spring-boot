package com.smartzhe.utils.annotation;

import com.smartzhe.utils.annotation.validator.CheckStringValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Created by IntelliJ IDEA.
 * User: luohuahua
 * Date: 2017/9/12
 * Time: 14:30  .
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Constraint(validatedBy = CheckStringValidator.class)
@Documented
public @interface CheckString {
    /**
     * error msg
     *
     * @return
     */
    String message() default "字符串不能为空";

    int minLength() default -1;

    int maxLength() default -1;

    boolean isNeedPattern() default false;

    String pattern() default "";

    /**
     * error code
     *
     * @return
     */
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
