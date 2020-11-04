package www.glaway.assetmanagementsystem.util;

/**
 * 正则表达式
 */
public class RegexUtil {
    //非负整数（正整数   +   0）
    public static final String NOTNEGATIVEINTEGER = "^\\d+$";
    //正整数
    public static final String POSITIVEINTEGER =  "^[0-9]*[1-9][0-9]*$";
    //非正整数（负整数   +   0）
    public static final String NOPOSITIVEINTEGER =  "^((-\\d+)|(0+))$";
    //负整数
    public static final String NEGATIVEINTEGER =   "^-[0-9]*[1-9][0-9]*$";
    //整数
    public static final String INTEGERNUMBER =    "^-?\\d+$";
    ///非负浮点数（正浮点数   +   0）
    public static final String NOTNEGATIVEFLOAT =    "^\\d+(\\.\\d+)?$";
    //正浮点数
    public static final String POSITIVEFLOAT =     "^(([0-9]+\\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\\.[0-9]+)|([0-9]*[1-9][0-9]*))$";
    //非正浮点数（负浮点数   +   0）
    public static final String NOTPOSITIVEFLOAT =    "^((-\\d+(\\.\\d+)?)|(0+(\\.0+)?))$";
    //负浮点数
    public static final String NEGATIVEFLOAT =    "^(-(([0-9]+\\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\\.[0-9]+)|([0-9]*[1-9][0-9]*)))$";
    //浮点数
    public static final String FLOATNUMBER = "^(-?\\d+)(\\.\\d+)?$";
    //提起数字（带小数）
    public static final String GETFLOATNUMBER = "(\\d+\\.\\d+)|(\\d+)";
    //提起非数字（带小数）
    public static final String GETNOTFLOATNUMBER = "[^(\\d+\\.\\d+)|(\\d+)]";
    //提起非数字
    public static final String GETNOTNUMBER = "[^\\d]";
    //提起数字
    public static final String GETNUMBER = "[\\d]";
}
