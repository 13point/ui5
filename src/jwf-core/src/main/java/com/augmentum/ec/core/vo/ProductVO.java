/**
 * @author Adrian Yao <adrianyao@augmentum.com.cn>
 * @version 1.6
 * @since 2014 Apr 2, 2014
 */
package com.augmentum.ec.core.vo;

import java.io.Serializable;
import java.math.BigDecimal;

// TODO: Auto-generated Javadoc
/**
 * The Class ProductVO.
 */
public final class ProductVO implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -6695873038272400636L;

    /** The product id. */
    private Integer productId;

    /** The is active. */
    private boolean isActive;

    /** The is listed. */
    private boolean isListed;

    /** The position. */
    private Integer position;

    /** The name. */
    private String name;

    /** The merchant user id. */
    private Integer merchantUserId;

    /** The merchant id. */
    private Integer merchantId;

    /** The price. */
    private BigDecimal price;

    /** The face price. */
    private BigDecimal facePrice;

    /** The exp datetime. */
    private String expDatetime;

    /** The created. */
    private String created;

    /** The updated. */
    private String updated;

    /** The sell store limit. */
    private boolean sellStoreLimit;

    /** The redeem store limit. */
    private boolean redeemStoreLimit;

    /** The has stock. */
    private boolean hasStock;

    /** The start datetime. */
    private String startDatetime;

    /** The need barcode. */
    private boolean needBarcode;

    /** The product type. */
    private ProductTypeVO productType;

    /** The category. */
    private CategoryVO category;

    /** The description. */
    private String description;

    /** The sku. */
    private String sku;

    /** The inventory alert. */
    private String inventoryAlert;

    /** The short description. */
    private String shortDescription;

    /** The after service. */
    private String afterService;

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

    /**
     * Checks if is active.
     *
     * @return true, if is active
     */
    public boolean isActive() {
        return isActive;
    }

    /**
     * Sets the active.
     *
     * @param isActive the new active
     */
    public void setActive(final boolean isActive) {
        this.isActive = isActive;
    }

    /**
     * Checks if is listed.
     *
     * @return true, if is listed
     */
    public boolean isListed() {
        return isListed;
    }

    /**
     * Sets the listed.
     *
     * @param isListed the new listed
     */
    public void setListed(final boolean isListed) {
        this.isListed = isListed;
    }

    /**
     * Gets the position.
     *
     * @return the position
     */
    public Integer getPosition() {
        return position;
    }

    /**
     * Sets the position.
     *
     * @param position the new position
     */
    public void setPosition(final Integer position) {
        this.position = position;
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name.
     *
     * @param name the new name
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Gets the merchant user id.
     *
     * @return the merchant user id
     */
    public Integer getMerchantUserId() {
        return merchantUserId;
    }

    /**
     * Sets the merchant user id.
     *
     * @param merchantUserId the new merchant user id
     */
    public void setMerchantUserId(final Integer merchantUserId) {
        this.merchantUserId = merchantUserId;
    }

    /**
     * Gets the merchant id.
     *
     * @return the merchant id
     */
    public Integer getMerchantId() {
        return merchantId;
    }

    /**
     * Sets the merchant id.
     *
     * @param merchantId the new merchant id
     */
    public void setMerchantId(final Integer merchantId) {
        this.merchantId = merchantId;
    }

    /**
     * Gets the price.
     *
     * @return the price
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * Sets the price.
     *
     * @param price the new price
     */
    public void setPrice(final BigDecimal price) {
        this.price = price;
    }

    /**
     * Gets the face price.
     *
     * @return the face price
     */
    public BigDecimal getFacePrice() {
        return facePrice;
    }

    /**
     * Sets the face price.
     *
     * @param facePrice the new face price
     */
    public void setFacePrice(final BigDecimal facePrice) {
        this.facePrice = facePrice;
    }

    /**
     * Gets the exp datetime.
     *
     * @return the exp datetime
     */
    public String getExpDatetime() {
        return expDatetime;
    }

    /**
     * Sets the exp datetime.
     *
     * @param expDatetime the new exp datetime
     */
    public void setExpDatetime(final String expDatetime) {
        this.expDatetime = expDatetime;
    }

    /**
     * Gets the created.
     *
     * @return the created
     */
    public String getCreated() {
        return created;
    }

    /**
     * Sets the created.
     *
     * @param created the new created
     */
    public void setCreated(final String created) {
        this.created = created;
    }

    /**
     * Gets the updated.
     *
     * @return the updated
     */
    public String getUpdated() {
        return updated;
    }

    /**
     * Sets the updated.
     *
     * @param updated the new updated
     */
    public void setUpdated(final String updated) {
        this.updated = updated;
    }

    /**
     * Sets the start datetime.
     *
     * @param startDatetime the new start datetime
     */
    public void setStartDatetime(final String startDatetime) {
        this.startDatetime = startDatetime;
    }

    /**
     * Checks if is sell store limit.
     *
     * @return true, if is sell store limit
     */
    public boolean isSellStoreLimit() {
        return sellStoreLimit;
    }

    /**
     * Sets the sell store limit.
     *
     * @param sellStoreLimit the new sell store limit
     */
    public void setSellStoreLimit(final boolean sellStoreLimit) {
        this.sellStoreLimit = sellStoreLimit;
    }

    /**
     * Checks if is redeem store limit.
     *
     * @return true, if is redeem store limit
     */
    public boolean isRedeemStoreLimit() {
        return redeemStoreLimit;
    }

    /**
     * Sets the redeem store limit.
     *
     * @param redeemStoreLimit the new redeem store limit
     */
    public void setRedeemStoreLimit(final boolean redeemStoreLimit) {
        this.redeemStoreLimit = redeemStoreLimit;
    }

    /**
     * Checks if is checks for stock.
     *
     * @return true, if is checks for stock
     */
    public boolean isHasStock() {
        return hasStock;
    }

    /**
     * Sets the checks for stock.
     *
     * @param hasStock the new checks for stock
     */
    public void setHasStock(final boolean hasStock) {
        this.hasStock = hasStock;
    }

    /**
     * Gets the start datetime.
     *
     * @return the start datetime
     */
    public String getStartDatetime() {
        return startDatetime;
    }

    /**
     * Checks if is need barcode.
     *
     * @return true, if is need barcode
     */
    public boolean isNeedBarcode() {
        return needBarcode;
    }

    /**
     * Sets the need barcode.
     *
     * @param needBarcode the new need barcode
     */
    public void setNeedBarcode(final boolean needBarcode) {
        this.needBarcode = needBarcode;
    }

    /**
     * Gets the product type.
     *
     * @return the product type
     */
    public ProductTypeVO getProductType() {
        return productType;
    }

    /**
     * Sets the product type.
     *
     * @param productType the new product type
     */
    public void setProductType(final ProductTypeVO productType) {
        this.productType = productType;
    }

    /**
     * Gets the category.
     *
     * @return the category
     */
    public CategoryVO getCategory() {
        return category;
    }

    /**
     * Sets the category.
     *
     * @param category the new category
     */
    public void setCategory(final CategoryVO category) {
        this.category = category;
    }

    /**
     * Gets the description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description.
     *
     * @param description the new description
     */
    public void setDescription(final String description) {
        this.description = description;
    }

    /**
     * Gets the sku.
     *
     * @return the sku
     */
    public String getSku() {
        return sku;
    }

    /**
     * Sets the sku.
     *
     * @param sku the new sku
     */
    public void setSku(final String sku) {
        this.sku = sku;
    }

    /**
     * Gets the inventory alert.
     *
     * @return the inventory alert
     */
    public String getInventoryAlert() {
        return inventoryAlert;
    }

    /**
     * Sets the inventory alert.
     *
     * @param inventoryAlert the new inventory alert
     */
    public void setInventoryAlert(final String inventoryAlert) {
        this.inventoryAlert = inventoryAlert;
    }

    /**
     * Gets the short description.
     *
     * @return the short description
     */
    public String getShortDescription() {
        return shortDescription;
    }

    /**
     * Sets the short description.
     *
     * @param shortDescription the new short description
     */
    public void setShortDescription(final String shortDescription) {
        this.shortDescription = shortDescription;
    }

    /**
     * Gets the after service.
     *
     * @return the after service
     */
    public String getAfterService() {
        return afterService;
    }

    /**
     * Sets the after service.
     *
     * @param afterService the new after service
     */
    public void setAfterService(final String afterService) {
        this.afterService = afterService;
    }

}
