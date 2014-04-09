/**
 * @author Adrian Yao <adrianYao@augmentum.com.cn>
 * @version 1.6
 * @since 2014 Mar 27, 2014
 */
package com.augmentum.ec.core.vo;

import java.io.Serializable;
import java.util.List;

/**
 * The Class Pagination.
 *
 * @param <T> the generic type
 */
public final class Pagination<T extends Serializable> implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The list. */
    private List<T> list;

    /** The count. */
    private int count;

    /**
     * Instantiates a new pagination.
     */
    public Pagination() {
    }

    /**
     * Instantiates a new pagination.
     *
     * @param list the list
     * @param count the count
     */
    public Pagination(final List<T> list, final int count) {
        this.list = list;
        this.count = count;
    }

    /**
     * Gets the list.
     *
     * @return the list
     */
    public List<T> getList() {
        return list;
    }

    /**
     * Sets the list.
     *
     * @param list the new list
     */
    public void setList(final List<T> list) {
        this.list = list;
    }

    /**
     * Gets the count.
     *
     * @return the count
     */
    public int getCount() {
        return count;
    }

    /**
     * Sets the count.
     *
     * @param count the new count
     */
    public void setCount(final int count) {
        this.count = count;
    }

}
