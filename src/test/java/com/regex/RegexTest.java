package com.regex;

import com.smartzhe.utils.annotation.Constants;
import org.junit.Test;

import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by IntelliJ IDEA.
 * User: luohuahua
 * Date: 2017/9/25
 * Time: 17:43  .
 */
public class RegexTest {

    @Test
    public void testEmail() {

        assertThat(Pattern.matches(Constants.REGEX_EMAIL, "")).isFalse();
        assertThat(Pattern.matches(Constants.REGEX_EMAIL, "sdfslsdcom")).isFalse();
        assertThat(Pattern.matches(Constants.REGEX_EMAIL, "sdf@slscom")).isFalse();
        assertThat(Pattern.matches(Constants.REGEX_EMAIL, "sdfls.com")).isFalse();
        assertThat(Pattern.matches(Constants.REGEX_EMAIL, "sdfsl@sdf-cds.f")).isFalse();
        assertThat(Pattern.matches(Constants.REGEX_EMAIL, "sdfsl@sdf_cds.f")).isTrue();
    }

    @Test
    public void testNotSpecial(){
        assertThat(Pattern.matches(Constants.REGEX_NO_SPECIAL_WORD, "")).isFalse();
        assertThat(Pattern.matches(Constants.REGEX_NO_SPECIAL_WORD, "@")).isFalse();
        assertThat(Pattern.matches(Constants.REGEX_NO_SPECIAL_WORD, "-")).isFalse();
        assertThat(Pattern.matches(Constants.REGEX_NO_SPECIAL_WORD, "+")).isFalse();
        assertThat(Pattern.matches(Constants.REGEX_NO_SPECIAL_WORD, "/")).isFalse();
        assertThat(Pattern.matches(Constants.REGEX_NO_SPECIAL_WORD, "*")).isFalse();
        assertThat(Pattern.matches(Constants.REGEX_NO_SPECIAL_WORD, "1")).isTrue();
        assertThat(Pattern.matches(Constants.REGEX_NO_SPECIAL_WORD, "A")).isTrue();
        assertThat(Pattern.matches(Constants.REGEX_NO_SPECIAL_WORD, "a")).isTrue();
        assertThat(Pattern.matches(Constants.REGEX_NO_SPECIAL_WORD, "_")).isTrue();
    }

    @Test
    public void testOnlyUnSignNumber(){
        assertThat(Pattern.matches("^[0-9]+$", "1234a")).isFalse();
        assertThat(Pattern.matches("^[0-9]+$", "-1")).isFalse();
        assertThat(Pattern.matches("^[0-9]+$", "")).isFalse();
    }
}
