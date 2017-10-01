package com.smartzhe.utils.annotation;

import com.smartzhe.utils.annotation.validator.CheckIntegerValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Created by IntelliJ IDEA.
 * User: luohuahua
 * Date: 2017/9/25
 * Time: 13:42  .
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Constraint(validatedBy = CheckIntegerValidator.class)
@Documented
public @interface CheckInteger {

    String message() default "";


    String rangeFromTo() default "";

    String rangeIn() default "";

    /**
     * error code
     *
     * @return
     */
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
