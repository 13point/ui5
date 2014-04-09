/**
 * @author Adrian Yao <adrianyao@augmentum.com.cn>
 * @version 1.6
 * @since 2013 Dec 4, 2013
 */
package com.augmentum.ec.core.constant;

import java.util.Properties;

import com.augmentum.ec.core.util.PropertiesUtil;


/**
 * The Class GlobalProperties.
 */
public final class GlobalProperties {

    /** The Constant PROPERTIES_PATH. */
    private static final String PROPERTIES_PATH = "/global.properties";

    /** The app name. */
    public static String AUTO_LOGIN_TOKEN_KEY;

    /** The domain. */
    public static String DOMAIN = "";

    /** The page limitation. */
    public static Integer PAGE_LIMITATION = 0;

    /** The tag limitation. */
    public static Integer TAG_LIMITATION = 0;

    static {
        Properties globalProperties = PropertiesUtil.getProperties(PROPERTIES_PATH);
        if (PropertiesUtil.get(globalProperties, "auto_login_token_key") != null) {
            AUTO_LOGIN_TOKEN_KEY = PropertiesUtil.get(globalProperties, "auto_login_token_key");
        }
        if (PropertiesUtil.get(globalProperties, "generalPageLimit") != null) {
            PAGE_LIMITATION = Integer.parseInt(PropertiesUtil.get(globalProperties, "generalPageLimit"));
        }
        if (PropertiesUtil.get(globalProperties, "tag_limitation") != null) {
            TAG_LIMITATION = Integer.parseInt(PropertiesUtil.get(globalProperties, "tag_limitation"));
        }
        if (PropertiesUtil.get(globalProperties, "frontDomain") != null) {
            DOMAIN = PropertiesUtil.get(globalProperties, "frontDomain");
        }
    }

    /**
     * Instantiates a new global properties.
     */
    private GlobalProperties() {
        // empty
    }
}
