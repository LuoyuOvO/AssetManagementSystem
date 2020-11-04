package www.glaway.assetmanagementsystem.util;

import com.blankj.utilcode.util.StringUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * json工具
 */
public class JSONUtil {
    /**
     * 除去jsonObject中空值
     */
    public static String removeNullAttr(String jsonArrray) {
        JSONArray jsonArray = null;
        try {
            jsonArray = new JSONArray(jsonArrray);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                // 去掉value为空的键值对
                Iterator<String> keys = jsonObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (StringUtils.isEmpty(jsonObject.getString(next))) {
                        keys.remove();
                    }
                }
            }
        } catch (JSONException e) {
            return null;
        }
        return jsonArray.toString();
    }

    /**
     * lombok的toString转json
     */
    public static String toJsonStr(String str) {
        if (StringUtils.isEmpty(str)) {
            return null;
        }
        str = str.replace(")", "}");
        while (str.indexOf("(") != -1) {
            int i = str.indexOf("(");
            str = str.substring(0, str.lastIndexOf("=", i) + 1) + "{" + str.substring(i + 1);
        }
        str = str.replace(" ", "")
                .replace("=", "\"=\"")
                .replace(",", "\",\"")
                .replace("\"null\"", "null")
                .replace("\"{", "{\"")
                .replace("}\"", "}")
                .replace("}", "\"}")
                .replace("\"}\"}", "\"}}");

        str = "\"" + str.replace("=", ":");
        if ("\"{".equals(str.substring(0, 2))) {
            str = "{\"" + str.substring(2);
        } else {
            str = str.substring(str.indexOf(":") + 1);
        }
        str = str.replace("\"null\"", "\"\"");
        str = str.replace("null", "\"\"");
        return str;
    }

    /**
     * ListData转换成jsonarrary
     */
    public static String ListStringToJsonArr(List<String> list) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("{\"RECORDS\":[");
        list.forEach(f -> {
            stringBuffer.append(f + ",");
        });
        if (list.size() > 0) stringBuffer.delete(stringBuffer.length() - 1, stringBuffer.length());
        stringBuffer.append("]}");
        return stringBuffer.toString();
    }
}
