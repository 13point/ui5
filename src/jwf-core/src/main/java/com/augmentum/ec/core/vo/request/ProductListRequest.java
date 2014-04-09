/**
 * @author Adrian.Yao <adrianyao@augmentum.com.cn>
 * @version 1.6
 * @since 2013 Dec 4, 2013
 */
package com.augmentum.ec.core.vo.request;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.augmentum.ec.core.constant.ProductStatus;
import com.augmentum.ec.core.constant.Sort;

/**
 * The Class ProductListRequest.
 */
public final class ProductListRequest extends PaginationRequest implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -7101706581823281641L;

    /** The keyword. */
    private String keyword;

    /** The status. */
    private ProductStatus status;

    /** The order by created. */
    private Sort orderByCreated = Sort.DESC;

    /** The order by price. */
    private Sort orderByPrice;

    /** The start time. */
    private Date startTime;

    /** The end time. */
    private Date endTime;

    /** The category. */
    private List<Integer> categories;

    /** The brand. */
    private List<Integer> brands;

    /** The top price. */
    private Float topPrice;

    /** The low price. */
    private Float lowPrice;

    /** The location. */
    private Integer location;

    /** The liker. */
    private Boolean like;

    /** The store. */
    private Integer store;

    /** The has stock. */
    private Boolean hasStock;

    /** The sell store. */
    private Boolean sellStore;

    /** The redeem store. */
    private Boolean redeemStore;

    /** The need barcode. */
    private Boolean needBarcode;

    /**
     * Gets the keyword.
     * 
     * @return the keyword
     */
    public String getKeyword() {
        return keyword;
    }

    /**
     * Gets the product status.
     * 
     * @return the product status
     */
    public ProductStatus getStatus() {
        return status;
    }

    /**
     * Sets the status.
     * 
     * @param status the new product status
     */
    public void setStatus(final ProductStatus status) {
        this.status = status;
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
     * Gets the order by created.
     * 
     * @return the order by created
     */
    public Sort getOrderByCreated() {
        return orderByCreated;
    }

    /**
     * Sets the order by created.
     * 
     * @param orderByCreated the new order by created
     */
    public void setOrderByCreated(final Sort orderByCreated) {
        this.orderByCreated = orderByCreated;
    }

    /**
     * Gets the order by price.
     * 
     * @return the order by price
     */
    public Sort getOrderByPrice() {
        return orderByPrice;
    }

    /**
     * Sets the order by price.
     * 
     * @param orderByPrice the new order by price
     */
    public void setOrderByPrice(final Sort orderByPrice) {
        this.orderByPrice = orderByPrice;
    }

    /**
     * Gets the start time.
     * 
     * @return the start time
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * Sets the start time.
     * 
     * @param startTime the new start time
     */
    public void setStartTime(final Date startTime) {
        this.startTime = startTime;
    }

    /**
     * Gets the end time.
     * 
     * @return the end time
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * Sets the end time.
     * 
     * @param endTime the new end time
     */
    public void setEndTime(final Date endTime) {
        this.endTime = endTime;
    }

    /**
     * Gets the categories.
     * 
     * @return the categories
     */
    public List<Integer> getCategories() {
        return categories;
    }

    /**
     * Sets the categories.
     * 
     * @param categories the new categories
     */
    public void setCategories(final List<Integer> categories) {
        this.categories = categories;
    }

    /**
     * Gets the brands.
     * 
     * @return the brands
     */
    public List<Integer> getBrands() {
        return brands;
    }

    /**
     * Sets the brands.
     * 
     * @param brands the new brands
     */
    public void setBrands(final List<Integer> brands) {
        this.brands = brands;
    }

    /**
     * Gets the top price.
     * 
     * @return the top price
     */
    public Float getTopPrice() {
        return topPrice;
    }

    /**
     * Sets the top price.
     * 
     * @param topPrice the new top price
     */
    public void setTopPrice(final Float topPrice) {
        this.topPrice = topPrice;
    }

    /**
     * Gets the low price.
     * 
     * @return the low price
     */
    public Float getLowPrice() {
        return lowPrice;
    }

    /**
     * Sets the low price.
     * 
     * @param lowPrice the new low price
     */
    public void setLowPrice(final Float lowPrice) {
        this.lowPrice = lowPrice;
    }

    /**
     * Gets the like.
     * 
     * @return the like
     */
    public Boolean getLike() {
        return like;
    }

    /**
     * Sets the like.
     * 
     * @param like the new like
     */
    public void setLike(final Boolean like) {
        this.like = like;
    }

    /**
     * Gets the location.
     * 
     * @return the location
     */
    public Integer getLocation() {
        return location;
    }

    /**
     * Sets the location.
     * 
     * @param location the new location
     */
    public void setLocation(final Integer location) {
        this.location = location;
    }

    /**
     * Gets the store.
     * 
     * @return the store
     */
    public Integer getStore() {
        return store;
    }

    /**
     * Sets the store.
     * 
     * @param store the new store
     */
    public void setStore(final Integer store) {
        this.store = store;
    }

    /**
     * Gets the checks for stock.
     * 
     * @return the checks for stock
     */
    public Boolean getHasStock() {
        return hasStock;
    }

    /**
     * Sets the checks for stock.
     * 
     * @param hasStock the new checks for stock
     */
    public void setHasStock(final Boolean hasStock) {
        this.hasStock = hasStock;
    }

    /**
     * Gets the sell store.
     * 
     * @return the sell store
     */
    public Boolean getSellStore() {
        return sellStore;
    }

    /**
     * Sets the sell store.
     * 
     * @param sellStore the new sell store
     */
    public void setSellStore(final Boolean sellStore) {
        this.sellStore = sellStore;
    }

    /**
     * Gets the redeem store.
     * 
     * @return the redeem store
     */
    public Boolean getRedeemStore() {
        return redeemStore;
    }

    /**
     * Sets the redeem store.
     * 
     * @param redeemStore the new redeem store
     */
    public void setRedeemStore(final Boolean redeemStore) {
        this.redeemStore = redeemStore;
    }

    /**
     * Gets the need barcode.
     * 
     * @return the need barcode
     */
    public Boolean getNeedBarcode() {
        return needBarcode;
    }

    /**
     * Sets the need barcode.
     * 
     * @param needBarcode the new need barcode
     */
    public void setNeedBarcode(final Boolean needBarcode) {
        this.needBarcode = needBarcode;
    }

}
