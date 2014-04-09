/**
 * @author Adrian Yao <adrianYao@augmentum.com.cn>
 * @version 1.6
 * @since 2014 Mar 30, 2014
 */
package com.augmentum.ec.core.criteria;

import java.util.List;

import com.augmentum.ec.core.vo.request.BrandListRequest;

/**
 * The Class BrandCriteria.
 */
public final class BrandCriteria extends PaginationCriteria {

    /** The Constant DEFAULT_LIMIT. */
    private static final int DEFAULT_LIMIT = 1000;

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

    /**
     * Generate from request.
     *
     * @param brandListRequest the brand list request
     * @return the brand criteria
     */
    public static BrandCriteria generateFromRequest(final BrandListRequest brandListRequest) {
        BrandCriteria brandCriteria = new BrandCriteria();
        brandCriteria.setKeyword(brandListRequest.getKeyword());
        brandCriteria.setProductIds(brandListRequest.getProductIds());
        Integer offset = brandListRequest.getOffset();
        brandCriteria.setOffset(offset != null && offset <= 0 ? null : offset);
        Integer limit = brandListRequest.getLimit();
        brandCriteria.setLimit(limit == null || limit <= 0 ? DEFAULT_LIMIT : limit);
        return brandCriteria;
    }
}
