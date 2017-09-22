package com.annotation;

import com.smartzhe.utils.annotation.CheckString;
import com.smartzhe.utils.annotation.ValidatorUtils;
import lombok.Data;

/**
 * Created by IntelliJ IDEA.
 * User: luohuahua
 * Date: 2017/9/22
 * Time: 14:21  .
 */
public class ValidatorTest {

    public static void main(String[] args) {
        Person person = new Person();
        person.setName("");
        ValidatorUtils.validate(person);

    }
}

@Data
class Person {
    @CheckString
    private String name;

}
