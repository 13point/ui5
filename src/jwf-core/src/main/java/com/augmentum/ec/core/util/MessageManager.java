/**
 * @author Adrian Yao <adrianYao@augmentum.com.cn>
 * @version 1.6
 * @since 2014 Mar 27, 2014
 */
package com.augmentum.ec.core.util;

import java.util.Locale;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * The Class MessageManager.
 */
@Component
public final class MessageManager implements ApplicationContextAware {

    /** The context. */
    private static ApplicationContext context = null;

    /** The locale. */
    private static Locale locale = new Locale("zh", "CN");

    /**
     * Gets the message.
     *
     * @param key the key
     * @return the message
     */
    public static String getMessage(final String key) {
        if (StringUtils.isEmpty(key)) {
            return "";
        } else {
            return context.getMessage(key, null, locale);
        }
    }

    /**
     * Gets the message.
     *
     * @param key the key
     * @param args the args
     * @return the message
     */
    public static String getMessage(final String key, final String... args) {
        if (StringUtils.isEmpty(key)) {
            return "";
        } else {
            return context.getMessage(key, args, locale);
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * org.springframework.context.ApplicationContextAware#setApplicationContext(org.springframework
     * .context.ApplicationContext)
     */
    @Override
    public void setApplicationContext(final ApplicationContext context) throws BeansException {
        MessageManager.context = context;
    }
}
