package com.augmentum.ec.core.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public final class ProductStoreId implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer storeId;
	private Integer productId;

	public ProductStoreId() {
	}

	@Column(name = "store_id", nullable = false)
	public Integer getStoreId() {
		return storeId;
	}

	public void setStoreId(final Integer storeId) {
		this.storeId = storeId;
	}

	@Column(name = "product_id", nullable = false)
	public Integer getProductId() {
		return productId;
	}

	public void setProductId(final Integer productId) {
		this.productId = productId;
	}
	
	public boolean equals(final Object other) {
        if ((this == other)) {
            return true;
        }
        if ((other == null)) {
            return false;
        }
        if (!(other instanceof ProductStoreId)) {
            return false;
        }
        ProductStoreId castOther = (ProductStoreId) other;

        return (this.getProductId() == castOther.getProductId()) && (this.getStoreId() == castOther.getStoreId());
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        int result = 17;

        result = 37 * result + (productId != null ? productId : 0);
        result = 37 * result + (storeId != null ? storeId : 0);
        return result;
    }

}
