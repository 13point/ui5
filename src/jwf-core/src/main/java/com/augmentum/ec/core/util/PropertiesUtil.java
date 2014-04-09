/**
 * @author Lila Zhou <lila.zhou@augmentum.com>
 * @version 1.6
 * @since 2013 Dec 4, 2013
 */
package com.augmentum.ec.core.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * The Class PropertiesUtil.
 */
public final class PropertiesUtil {

    /**
     * Instantiates a new properties util.
     */
    private PropertiesUtil() {
        // empty
    }

    /**
     * Gets the.
     *
     * @param properties the properties
     * @param key the key
     * @return the string
     */
    public static String get(final Properties properties, final String key) {
        String value = null;
        if (null != properties) {
            String str = properties.getProperty(key);
            if (null != str) {
                try {
                    value = new String(str.getBytes("ISO8859-1"), "utf-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        }
        return value;
    }

    /**
     * get properties.
     *
     * @param path the path
     * @return the properties
     */
    public static Properties getProperties(final String path) {
        InputStream in = PropertiesUtil.class.getResourceAsStream(path);
        Properties properties = new Properties();
        try {
            properties.load(in);
        } catch (IOException e) {
            throw new RuntimeException("properties can not load!");
        }
        return properties;
    }

    /**
     * get all key and values in properties file.
     *
     * @param path the path
     * @return the all
     */
    public static Map<String, String> getAll(final String path) {
        Map<String, String> parameters = new HashMap<String, String>();
        Properties pro = PropertiesUtil.getProperties(path);
        Enumeration<Object> keys = pro.keys();
        while (keys.hasMoreElements()) {
            String key = (String) keys.nextElement();
            parameters.put(key, pro.getProperty(key));
        }
        return parameters;
    }
}
