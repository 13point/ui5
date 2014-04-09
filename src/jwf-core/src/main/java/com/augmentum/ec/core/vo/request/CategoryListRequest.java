/**
 * @author Adrian Yao <adrianYao@augmentum.com.cn>
 * @version 1.6
 * @since 2014 Mar 28, 2014
 */
package com.augmentum.ec.core.vo.request;

import java.io.Serializable;

/**
 * The Class CategoryListRequest.
 */
public final class CategoryListRequest implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -187903838376960125L;

    /** The parent id. */
    private Integer parentId;

    /** The fetch all. */
    private Boolean fetchAll;

    /** The keyword. */
    private String keyword;

    /**
     * Gets the parent id.
     *
     * @return the parent id
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * Sets the parent id.
     *
     * @param parentId the new parent id
     */
    public void setParentId(final Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * Gets the fetch all.
     *
     * @return the fetch all
     */
    public Boolean getFetchAll() {
        return fetchAll;
    }

    /**
     * Sets the fetch all.
     *
     * @param fetchAll the new fetch all
     */
    public void setFetchAll(final Boolean fetchAll) {
        this.fetchAll = fetchAll;
    }

    /**
     * Gets the keyword.
     *
     * @return the keyword
     */
    public String getKeyword() {
        return keyword;
    }

    /**
     * Sets the keyword.
     *
     * @param keyword the new keyword
     */
    public void setKeyword(final String keyword) {
        this.keyword = keyword;
    }

}
