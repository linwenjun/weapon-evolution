package com.thoughtworks.academy;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {

    public static String replace(String template, Map<String, Object> data) {
        if(null == template) {
            return "";
        }
        if(null == data) {
            return template;
        }

        String result = template;
        Pattern pattern = Pattern.compile("(?:\\{\\{)(\\w+)(?:\\}\\})");
        Matcher matcher = pattern.matcher(template);

        while(matcher.find()) {
            String group = matcher.group();
            String key = matcher.group(1);
            if(null != data.get(key)) {
                result = result.replace(group, data.get(key).toString());
            }
        }

        return result;
    }
}
