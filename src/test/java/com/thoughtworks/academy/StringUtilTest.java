package com.thoughtworks.academy;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StringUtilTest {

    @Test
    public void testReplace() throws Exception {

        Map<String, Object> data = new HashMap<String, Object>();
        data.put("name", "张三");
        String result = StringUtil.replace("{{name}}来了", data);
        assertThat(result, is("张三来了"));
    }

    @Test
    public void testReplaceWhenKeyNotExist() throws Exception {

        Map<String, Object> data = new HashMap<String, Object>();
        data.put("existName", "张三");
        String result = StringUtil.replace("{{name}}来了", data);
        assertThat(result, is("{{name}}来了"));
    }

    @Test
    public void testReplaceWhenDataNotExist() throws Exception {

        Map<String, Object> data = new HashMap<String, Object>();
        String result = StringUtil.replace("{{name}}来了", data);
        assertThat(result, is("{{name}}来了"));
    }

}
