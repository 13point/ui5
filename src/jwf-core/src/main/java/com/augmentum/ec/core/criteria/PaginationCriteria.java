/**
 * @author Adrian Yao <adrianYao@augmentum.com.cn>
 * @version 1.6
 * @since 2014 Mar 30, 2014
 */
package com.augmentum.ec.core.criteria;

/**
 * The Class PaginationCriteria.
 */
public class PaginationCriteria {

    /** The offset. */
    private Integer offset;

    /** The limit. */
    private Integer limit;

    /**
     * Gets the offset.
     *
     * @return the offset
     */
    public final Integer getOffset() {
        return offset;
    }

    /**
     * Sets the offset.
     *
     * @param offset the new offset
     */
    public final void setOffset(final Integer offset) {
        this.offset = offset;
    }

    /**
     * Gets the limit.
     *
     * @return the limit
     */
    public final Integer getLimit() {
        return limit;
    }

    /**
     * Sets the limit.
     *
     * @param limit the new limit
     */
    public final void setLimit(final Integer limit) {
        this.limit = limit;
    }

}
