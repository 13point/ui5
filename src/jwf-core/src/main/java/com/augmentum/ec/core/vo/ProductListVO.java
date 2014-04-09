/**
 * @author Adrian Yao <adrianyao@augmentum.com.cn>
 * @version 1.6
 * @since 2014 Apr 1, 2014
 */
package com.augmentum.ec.core.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * The Class ProductListVO.
 */
public final class ProductListVO implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -6695873038272400636L;


    /** The id. */
    private Integer id;

    /** The category. */
    private CategoryVO category;

    /** The brands. */
    private List<BrandVO> brands;

    /** The images. */
    private ProductImageVO images;

    /** The product type. */
    private ProductTypeVO productType;

    /** The is active. */
    private boolean isActive;

    /** The name. */
    private String name;

    /** The price. */
    private BigDecimal price;

    /** The face price. */
    private BigDecimal facePrice;

    /** The exp datetime. */
    private Date expDatetime;

    /** The start datetime. */
    private Date startDatetime;

    /** The has stock. */
    private boolean hasStock;

    /** The need barcode. */
    private boolean needBarcode;

    /** The sell store limit. */
    private boolean sellStoreLimit;

    /** The redeem store limit. */
    private boolean redeemStoreLimit;

    /**
     * Gets the product id.
     * 
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the id.
     * 
     * @param id the new id
     */
    public void setId(final Integer id) {
        this.id = id;
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
     * Gets the brands.
     * 
     * @return the brands
     */
    public List<BrandVO> getBrands() {
        return brands;
    }

    /**
     * Sets the brands.
     * 
     * @param brands the new brands
     */
    public void setBrands(final List<BrandVO> brands) {
        this.brands = brands;
    }

    /**
     * Gets the images.
     * 
     * @return the images
     */
    public ProductImageVO getImages() {
        return images;
    }

    /**
     * Sets the images.
     * 
     * @param images the new images
     */
    public void setImages(final ProductImageVO images) {
        this.images = images;
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
    public Date getExpDatetime() {
        return expDatetime;
    }

    /**
     * Sets the exp datetime.
     * 
     * @param expDatetime the new exp datetime
     */
    public void setExpDatetime(final Date expDatetime) {
        this.expDatetime = expDatetime;
    }

    /**
     * Gets the start datetime.
     * 
     * @return the start datetime
     */
    public Date getStartDatetime() {
        return startDatetime;
    }

    /**
     * Sets the start datetime.
     * 
     * @param startDatetime the new start datetime
     */
    public void setStartDatetime(final Date startDatetime) {
        this.startDatetime = startDatetime;
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
}
