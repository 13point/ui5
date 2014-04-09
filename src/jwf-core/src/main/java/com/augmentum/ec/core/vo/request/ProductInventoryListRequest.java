package com.augmentum.ec.core.vo.request;

import java.io.Serializable;

public class ProductInventoryListRequest extends PaginationRequest implements
		Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer productId;

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

}
