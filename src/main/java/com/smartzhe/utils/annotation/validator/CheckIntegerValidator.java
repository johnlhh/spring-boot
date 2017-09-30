package com.smartzhe.utils.annotation.validator;

import com.smartzhe.utils.annotation.CheckInteger;
import com.smartzhe.utils.annotation.Constants;
import com.smartzhe.utils.annotation.ValidatorUtils;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * User: luohuahua
 * Date: 2017/9/25
 * Time: 13:55  .
 */
public class CheckIntegerValidator implements ConstraintValidator<CheckInteger, Integer> {

    private String rangeFromTo;

    private String rangeIn;

    @Override
    public void initialize(CheckInteger checkInteger) {
        this.rangeFromTo = checkInteger.rangeFromTo();
        this.rangeIn = checkInteger.rangeIn();

    }

    private boolean isNotNull(Integer integer, ConstraintValidatorContext constraintValidatorContext) {
        boolean result = true;
        if (integer == null) {
            ValidatorUtils.changeDefaultMessage(Constants.CONSTRAINT_STRING_PARAM_EMPTY_ERROR, constraintValidatorContext);
            result = false;
        }
        return result;
    }

    private boolean isRangeFromTo(Integer integer, ConstraintValidatorContext constraintValidatorContext) {
        boolean result = true;
        if (!StringUtils.isEmpty(rangeFromTo) && rangeFromTo.contains("-")) {
            int min = Integer.MIN_VALUE, max = Integer.MAX_VALUE;
            try {
                String fromTo[] = rangeFromTo.split("-");
                if (fromTo.length == 1) {
                    min = Integer.parseInt(fromTo[0]);
                } else if (fromTo.length == 2) {
                    if (!StringUtils.isEmpty(fromTo[0])) {
                        min = Integer.parseInt(fromTo[0]);
                    }
                    max = Integer.parseInt(fromTo[1]);
                    if (min > max) {
                        throw new RuntimeException(Constants.CONSTRAINT_OPERATE_RANGE_FROM_TO_ERROR);
                    }
                } else {
                    throw new RuntimeException(Constants.CONSTRAINT_OPERATE_RANGE_FROM_TO_ERROR);
                }
            } catch (Exception e) {
                ValidatorUtils.changeDefaultMessage(Constants.CONSTRAINT_OPERATE_RANGE_FROM_TO_ERROR, constraintValidatorContext);
                return false;
            }
            if (integer.intValue() > max || integer.intValue() < min) {
                ValidatorUtils.changeDefaultMessage(String.format(Constants.CONSTRAINT_INTEGER_RANGE_FROM_TO_ERROR, "[" + rangeFromTo + "]"), constraintValidatorContext);
                result = false;
            }
        }
        return result;
    }

    private boolean isRangeIn(Integer integer, ConstraintValidatorContext constraintValidatorContext) {
        boolean result = true;
        if (!StringUtils.isEmpty(rangeIn) && rangeIn.contains(",")) {
            String ins[] = rangeIn.split(",");
            if (!Arrays.asList(ins).contains(String.valueOf(integer))) {
                ValidatorUtils.changeDefaultMessage(String.format(Constants.CONSTRAINT_INTEGER_RANGE_FROM_TO_ERROR, "(" + rangeIn + ")"), constraintValidatorContext);
                result = false;
            }
        }
        return result;
    }

    @Override
    public boolean isValid(Integer integer, ConstraintValidatorContext constraintValidatorContext) {
        return isNotNull(integer, constraintValidatorContext) &&
                isRangeFromTo(integer, constraintValidatorContext) &&
                isRangeIn(integer, constraintValidatorContext);
    }

}
