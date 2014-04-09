package com.augmentum.ec.core.vo.request;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

// TODO: Auto-generated Javadoc
/**
 * The Class ProductRequest.
 */
public final class ProductRequest extends PaginationRequest implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 4625400945756980400L;

    /** The product id. */
    @NotNull
    private Integer productId;

    /**
     * Gets the product id.
     *
     * @return the product id
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * Sets the product id.
     *
     * @param productId the new product id
     */
    public void setProductId(final Integer productId) {
        this.productId = productId;
    }

}
