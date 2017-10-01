package com.annotation;

import com.smartzhe.utils.annotation.CheckString;
import com.smartzhe.utils.annotation.Constants;
import com.smartzhe.utils.annotation.ValidatorUtils;
import lombok.Data;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by IntelliJ IDEA.
 * User: luohuahua
 * Date: 2017/9/22
 * Time: 14:21  .
 */
public class CheckStringValidatorTest {

    @Test
    public void testCheckString() {
        Person person = new Person();
        person.setName("");
        try {
            ValidatorUtils.validate(person);
        } catch (Exception e) {
            assertThat(e.getMessage()).isEqualTo("name:不能为空");
        }

        person.setName("12");
        try {
            ValidatorUtils.validate(person);
        } catch (Exception e) {
            assertThat(e.getMessage()).isEqualTo("name:长度小于3");
        }

        person.setName("12245678902354353535345352353452355");
        try {
            ValidatorUtils.validate(person);
        } catch (Exception e) {
            assertThat(e.getMessage()).isEqualTo("name:长度大于20");
        }

        person.setName("1224567890235435353");
        try {
            ValidatorUtils.validate(person);
        } catch (Exception e) {
            assertThat(e.getMessage()).isEqualTo("name:格式不对");
        }
    }
}

@Data
class Person {
    @CheckString(minLength = 3, maxLength = 20, isNeedPattern = true, pattern = Constants.REGEX_EMAIL)
    private String name;
}
