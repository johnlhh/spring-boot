package com.smartzhe.utils.annotation;

/**
 * Created by IntelliJ IDEA.
 * User: luohuahua
 * Date: 2017/9/12
 * Time: 14:32  .
 */
public class Constants {

    /**
     * 参数错误提示信息 START
     */
    public static final String CONSTRAINT_STRING_PARAM_MINLENGTH_ERROR = "长度小于";
    public static final String CONSTRAINT_STRING_PARAM_MAXLENGTH_ERROR = "长度大于";
    public static final String CONSTRAINT_STRING_PARAM_EMPTY_ERROR = "不能为空";
    public static final String CONSTRAINT_STRING_PARAM_PATTERN_ERROR = "格式不对";
    public static final String CONSTRAINT_INTEGER_RANGE_FROM_TO_ERROR = "不在%s范围内"; //%s 占位符，配合String.format()使用
    /**
     * 参数错误提示信息 END
     */



    /**
     * 注解操作错误START
     */
    public static final String CONSTRAINT_OPERATE_RANGE_FROM_TO_ERROR = "系统范围设置错误";


    /**
     * 注解操作错误END
     */



    /**
     * 正则表达式 START
     *  ^ ：匹配输入的开始位置。
     *  \：将下一个字符标记为特殊字符或字面值
     *  * ：匹配前一个字符零次或几次
     *  + ：匹配前一个字符一次或多次
     *  (pattern) 与模式匹配并记住匹配
     *  x|y：匹配 x 或 y
     *  [a-z] ：表示某个范围内的字符。与指定区间内的任何字符匹配
     *  \w ：与任何单词字符匹配，包括下划线
     *  {n,m} 最少匹配 n 次且最多匹配 m 次
     *  $ ：匹配输入的结尾
     *
     */
    public static final String REGEX_EMAIL = "^(\\w)+(\\.\\w+)*@(\\w)+((\\.\\w+)+)$";

    public static final String REGEX_PHONE = "^1[3|4|5|8][0-9]\\d{4,8}$";

    public static final String REGEX_NO_SPECIAL_WORD = "^(\\w)+$";


    /**
     * 正则表达式 END
     */
}
