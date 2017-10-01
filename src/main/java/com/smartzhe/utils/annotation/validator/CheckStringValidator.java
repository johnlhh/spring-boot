package com.smartzhe.utils.annotation.validator;

import com.smartzhe.utils.annotation.CheckString;
import com.smartzhe.utils.annotation.Constants;
import com.smartzhe.utils.annotation.ValidatorUtils;
import lombok.Data;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

/**
 * Created by IntelliJ IDEA.
 * User: luohuahua
 * Date: 2017/9/12
 * Time: 14:31  .
 */
@Data
public  class CheckStringValidator implements ConstraintValidator<CheckString, String> {

    private int minLength;

    private int maxLength;

    private boolean isNeedPattern = false;

    private String pattern = "";

    @Override
    public void initialize(CheckString check) {
        this.maxLength = check.maxLength();
        this.minLength = check.minLength();
        this.isNeedPattern = check.isNeedPattern();
        this.pattern = check.pattern();
    }

    private boolean validatorEmpty(String field, ConstraintValidatorContext constraintValidatorContext) {
        boolean result = true;
        if (StringUtils.isEmpty(field)) {
            ValidatorUtils.changeDefaultMessage(Constants.CONSTRAINT_STRING_PARAM_EMPTY_ERROR, constraintValidatorContext);
            result = false;
        }
        return result;
    }

    private boolean validatorMinLength(String field, ConstraintValidatorContext constraintValidatorContext) {
        boolean result = true;
        if (minLength != -1 && field.length() < minLength) {
            ValidatorUtils.changeDefaultMessage(Constants.CONSTRAINT_STRING_PARAM_MINLENGTH_ERROR + minLength, constraintValidatorContext);
            result = false;
        }
        return result;
    }

    private final boolean validatorMaxLength(String field, ConstraintValidatorContext constraintValidatorContext) {
        boolean result = true;
        if (minLength != -1 && field.length() > maxLength) {
            ValidatorUtils.changeDefaultMessage(Constants.CONSTRAINT_STRING_PARAM_MAXLENGTH_ERROR + maxLength, constraintValidatorContext);
            result = false;
        }
        return result;
    }

    private boolean validatorPattern(String field, ConstraintValidatorContext constraintValidatorContext) {
        if (isNeedPattern) {
            boolean result = Pattern.matches(this.pattern, field);
            if (!result) {
                ValidatorUtils.changeDefaultMessage(Constants.CONSTRAINT_STRING_PARAM_PATTERN_ERROR, constraintValidatorContext);
                return result;
            }
        }
        return true;
    }


    public  boolean validatorAdditional(String field, ConstraintValidatorContext constraintValidatorContext){
        return true;
    }

    @Override
    public boolean isValid(String field, ConstraintValidatorContext constraintValidatorContext) {
        boolean result = validatorEmpty(field, constraintValidatorContext) &&
                validatorMinLength(field, constraintValidatorContext) &&
                validatorMaxLength(field, constraintValidatorContext) &&
                validatorPattern(field, constraintValidatorContext) &&
                validatorAdditional(field, constraintValidatorContext);
        return result;
    }
}
