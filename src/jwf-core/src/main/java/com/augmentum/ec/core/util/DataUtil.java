/**
 * @author Adrian Yao <adrianyao@augmentum.com.cn>
 * @version 1.6
 * @since 2013 Dec 4, 2013
 */
package com.augmentum.ec.core.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.StringUtils;

import com.augmentum.ec.core.constant.CommonConstant;
import com.augmentum.ec.core.vo.Pagination;

/**
 * The Class DataUtil.
 */
public final class DataUtil {

    /** The Constant BOOLEAN_CLASS_NAME. */
    private static final String BOOLEAN_CLASS_NAME = Boolean.class.getName();

    /** The Constant BOOLEAN_BASIC_CLASS_NAME. */
    private static final String BOOLEAN_BASIC_CLASS_NAME = "boolean";

    /**
     * Data util.
     */
    private DataUtil() {
        // empty
    }

    /**
     * Format float.
     * 
     * @param f the f
     * @param commas the commas
     * @param decimalPlaces the decimal places
     * @return the stringBoolean.class.getName()
     */
    public static String formatFloat(final Float f, final boolean commas, final int decimalPlaces) {
        StringBuilder rule = new StringBuilder();
        if (commas) {
            rule.append("#,##0");
        } else {
            rule.append("0");
        }
        if (decimalPlaces > 0) {
            rule.append(".");
            for (int i = 0; i < decimalPlaces; i++) {
                rule.append("0");
            }
        }
        NumberFormat nf = new DecimalFormat(rule.toString());
        return nf.format(f);
    }

    /**
     * Format string.
     * 
     * @param string the string
     * @return the string
     */
    public static String formatString(final String string) {
        if (null != string) {
            StringBuffer sb = new StringBuffer();
            for (int i = 0, length = string.length(); i < length; i++) {
                char c = string.charAt(i);
                switch (c) {
                    case '&':
                        sb.append("&amp;");
                        break;
                    case '<':
                        sb.append("&lt;");
                        break;
                    case '>':
                        sb.append("&gt;");
                        break;
                    case '"':
                        sb.append("&quot;");
                        break;
                    case '\'':
                        sb.append("&apos;");
                        break;
                    default:
                        sb.append(c);
                }
            }
            return sb.toString();
        } else {
            return null;
        }
    }

    /**
     * Translate to list.
     * 
     * @param s the s
     * @return the list
     */
    public static List<String> translateToList(final String s) {
        List<String> list = new ArrayList<String>();
        String[] sArr = s.split(",");
        for (String temp : sArr) {
            list.add(temp);
        }
        return list;
    }

    /**
     * To upper case first character.
     * 
     * @param s the s
     * @return the string
     */
    public static String toUpperCaseFirstCharacter(final String s) {
        return new StringBuffer().append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).toString();
    }

    /**
     * Format api response.
     * 
     * @param response the response
     * @return the object
     */
    @SuppressWarnings("unchecked")
    public static Object formatApiResponse(final Object response) {
        Object result = null;
        if (response == null) {
            return null;
        }
        Class<?> responseClass = response.getClass();
        if (response instanceof Map) {
            Map<String, Object> responseMap = (Map<String, Object>) response;
            Map<String, Object> resultMap = new HashMap<String, Object>();
            for (Entry<String, Object> entry : responseMap.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                Object formatValue = formatApiResponse(value);
                if (formatValue != null) {
                    resultMap.put(key, formatValue);
                }
            }
            result = resultMap;
        } else if (response instanceof List) {
            List<Object> responseList = (List<Object>) response;
            List<Object> resultList = new ArrayList<Object>();
            for (Object obj : responseList) {
                Object formatValue = formatApiResponse(obj);
                if (formatValue != null) {
                    resultList.add(formatValue);
                }
            }
            result = resultList;
        } else if (response instanceof Pagination) {
            int count = ((Pagination<?>) response).getCount();
            List<?> list = ((Pagination<?>) response).getList();
            Map<String, Object> resultMap = new HashMap<String, Object>();
            resultMap.put("count", count);
            resultMap.put("list", formatApiResponse(list));
            result = resultMap;
        } else if (responseClass.getName().endsWith("VO")) {
            result = formatVO(response);
        } else if (response instanceof String) {
            if (StringUtils.isEmpty((String) response)) {
                result = "";
            } else {
                result = response;
            }
        } else if ((response instanceof Number) || (response instanceof Boolean)) {
            result = response;
        } else if (response instanceof Date) {
            result = DateUtil.formatDate((Date) response, CommonConstant.UTC_FORMAT);
        } else {
            result = response;
        }
        return result;
    }

    /**
     * Format input sql string.
     * 
     * @param string the string
     * @return the string
     */
    public static String formatInputSqlString(final String string) {
        if (null != string) {
            StringBuffer sb = new StringBuffer();
            for (int i = 0, length = string.length(); i < length; i++) {
                char c = string.charAt(i);
                switch (c) {
                    case '_':
                        sb.append("/_");
                        break;
                    case '%':
                        sb.append("/%");
                        break;
                    case '/':
                        sb.append("//");
                        break;
                    default:
                        sb.append(c);
                }
            }
            return sb.toString();
        } else {
            return null;
        }
    }

    /**
     * Format vo.
     * 
     * @param vo the vo
     * @return the object
     */
    private static Object formatVO(final Object vo) {
        Map<String, Object> obj = new HashMap<String, Object>();
        Class<?> classz = vo.getClass();

        Field[] fields = classz.getDeclaredFields();
        for (Field field : fields) {
            String fieldName = field.getName();
            String fieldClassName = field.getType().getName();
            Method method = null;
            try {
                if (BOOLEAN_CLASS_NAME.equals(fieldClassName) || BOOLEAN_BASIC_CLASS_NAME.equals(fieldClassName)) {
                    method =
                            classz.getMethod("is" + fieldName.substring(0, 1).toUpperCase()
                                    + fieldName.substring(1, fieldName.length()));
                } else {
                    method =
                            classz.getMethod("get" + fieldName.substring(0, 1).toUpperCase()
                                    + fieldName.substring(1, fieldName.length()));
                }
            } catch (NoSuchMethodException e) {
                method = null;
            } catch (SecurityException e) {
                method = null;
            }

            if (method != null) {
                Object value = null;
                try {
                    value = method.invoke(vo);
                } catch (IllegalAccessException e) {
                    value = null;
                } catch (IllegalArgumentException e) {
                    value = null;
                } catch (InvocationTargetException e) {
                    value = null;
                }
                if (value != null) {
                    obj.put(fieldName, formatApiResponse(value));
                }
            }

        }
        return obj;
    }
}
