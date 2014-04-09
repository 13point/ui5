/**
 * @author Adrian Yao <adrianYao@augmentum.com.cn>
 * @version 1.6
 * @since 2014 Mar 30, 2014
 */
package com.augmentum.ec.core.vo.request;

import java.io.Serializable;
import java.util.List;

/**
 * The Class BrandListRequest.
 */
public final class BrandListRequest extends PaginationRequest implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 4625400945702980400L;

    /** The keyword. */
    private String keyword;

    /** The product ids. */
    private List<Integer> productIds;

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

    /**
     * Gets the product ids.
     *
     * @return the product ids
     */
    public List<Integer> getProductIds() {
        return productIds;
    }

    /**
     * Sets the product ids.
     *
     * @param productIds the new product ids
     */
    public void setProductIds(final List<Integer> productIds) {
        this.productIds = productIds;
    }

}
