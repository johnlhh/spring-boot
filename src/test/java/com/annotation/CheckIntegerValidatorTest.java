package com.annotation;

import com.smartzhe.utils.annotation.CheckInteger;
import com.smartzhe.utils.annotation.ValidatorUtils;
import lombok.Data;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by IntelliJ IDEA.
 * User: luohuahua
 * Date: 2017/9/25
 * Time: 14:53  .
 */
public class CheckIntegerValidatorTest {

    @Test
    public void testCheckString() {
        User user = new User();

        user.setGender(2);
        user.setStatus(2);
        try {
            ValidatorUtils.validate(user);
        } catch (Exception e) {
            assertThat(e.getMessage()).isEqualTo("gender:不在[0-1]范围内");
        }

        user.setGender(1);
        user.setStatus(1);
        try {
            ValidatorUtils.validate(user);
        } catch (Exception e) {
            assertThat(e.getMessage()).isEqualTo("status:不在(2,4,6,7,8)范围内");
            assertThat(e.getMessage()).isEqualTo("status:不在(2,4,6,7,8)范围内");
        }
    }

}


@Data
class User {

    @CheckInteger(rangeFromTo = "0-1")
    private Integer gender;

    @CheckInteger(rangeIn = "2,4,6,7,8")
    private Integer status;
}