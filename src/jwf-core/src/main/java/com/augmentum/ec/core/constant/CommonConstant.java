/**
 * @author vincent wang <vincentwang@augmentum.com.cn>
 * @version 1.6
 * @since 2013 Dec 6, 2013
 */
package com.augmentum.ec.core.constant;

// TODO: Auto-generated Javadoc
/**
 * The Interface CommonConstant.
 */
public interface CommonConstant {
    // date format style
    /** The date format long. */
    String DATE_FORMAT_LONG = "yyyy-MM-dd HH:mm:ss";

    /** The date format. */
    String DATE_FORMAT = "yyyy-M-d H:mm:ss";

    /** The utc format. */
    String UTC_FORMAT = "EEE MMM d HH:mm:ss Z yyyy";

    // image setting
    /** The image typs. */
    String[] IMAGE_TYPS = { "bmp", "jpeg", "jpg", "gif", "png" };

    /** The image max size. */
    int IMAGE_MAX_SIZE = 2048 * 1024; // 2MB

    /** The image min size. */
    int IMAGE_MIN_SIZE = -1; // sans nombre

    /** The image max width. */
    int IMAGE_MAX_WIDTH = 1024;

    /** The image max height. */
    int IMAGE_MAX_HEIGHT = 1024;

    /** The image min width. */
    int IMAGE_MIN_WIDTH = 50;

    /** The image min height. */
    int IMAGE_MIN_HEIGHT = 50;

    // properties path
    /** The log message properties path. */
    String LOG_MESSAGE_PROPERTIES_PATH = "/log_message.properties";

    // HttpClient result
    /** The status. */
    String STATUS = "status";

    /** The body. */
    String BODY = "body";

    // split
    /** The comma. */
    String COMMA = ",";

    // common user role id
    /** The common user role. */
    int COMMON_USER_ROLE = 1;

    /** The count. */
    String COUNT = "count";

    /** product_link type. */
    String PRODUCT_LINK_RELATION = "relation";

    /**
     * The product link up sell.
     *
     * @author Adrian Yao <adrianYao@augmentum.com.cn>
     * @version 1.6
     * @since 2014 Mar 31, 2014
     */
    String PRODUCT_LINK_UP_SELL = "up_sell";

    /** The product link cross sell. */
    String PRODUCT_LINK_CROSS_SELL = "cross_sell";

    /** product setting path. */
    String PRODUCT_SETTING_DESCRIPTION = "description";

    /** The product setting sku. */
    String PRODUCT_SETTING_SKU = "sku";

    /** The product setting inventory alert. */
    String PRODUCT_SETTING_INVENTORY_ALERT = "inventory_alert";

    /** The product setting short desc. */
    String PRODUCT_SETTING_SHORT_DESC = "short_description";

    /** The product setting after service. */
    String PRODUCT_SETTING_AFTER_SERVICE = "after_service";
}
