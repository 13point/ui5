/**
 * @author Adrian Yao <adrianYao@augmentum.com.cn>
 * @version 1.6
 * @since 2014 Apr 1, 2014
 */
package com.augmentum.ec.core.criteria;

import java.util.Date;
import java.util.List;

import com.augmentum.ec.core.constant.ProductStatus;
import com.augmentum.ec.core.constant.Sort;
import com.augmentum.ec.core.vo.request.ProductListRequest;
import com.augmentum.ec.core.vo.request.ProductRequest;

// TODO: Auto-generated Javadoc
/**
 * The Class ProductCriteria.
 */
public final class ProductCriteria extends PaginationCriteria {

    /** The keyword. */
    private String keyword;

    /** The status. */
    private Boolean status;

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

    /** The product id. */
    private Integer productId;

    /** The linked type. */
    private String linkedType;

    /** The Constant DEFAULT_LIMIT. */
    private static final int DEFAULT_LIMIT = 1000;

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
     * @param keyword
     *            the new keyword
     */
    public void setKeyword(final String keyword) {
        this.keyword = keyword;
    }

    /**
     * Gets the status.
     *
     * @return the status
     */
    public Boolean getStatus() {
        return status;
    }

    /**
     * Sets the status.
     *
     * @param status
     *            the new status
     */
    public void setStatus(final Boolean status) {
        this.status = status;
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
     * @param orderByCreated
     *            the new order by created
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
     * @param orderByPrice
     *            the new order by price
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
     * @param startTime
     *            the new start time
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
     * @param endTime
     *            the new end time
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
     * @param categories
     *            the new categories
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
     * @param brands
     *            the new brands
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
     * @param topPrice
     *            the new top price
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
     * @param lowPrice
     *            the new low price
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
     * @param like
     *            the new like
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
     * @param location
     *            the new location
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
     * @param store
     *            the new store
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
     * @param hasStock
     *            the new checks for stock
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
     * @param sellStore
     *            the new sell store
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
     * @param redeemStore
     *            the new redeem store
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
     * @param needBarcode
     *            the new need barcode
     */
    public void setNeedBarcode(final Boolean needBarcode) {
        this.needBarcode = needBarcode;
    }

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
     * Gets the linked type.
     *
     * @return the linked type
     */
    public String getLinkedType() {
        return linkedType;
    }

    /**
     * Sets the linked type.
     *
     * @param linkedType the new linked type
     */
    public void setLinkedType(final String linkedType) {
        this.linkedType = linkedType;
    }

    /**
     * Gets the default limit.
     *
     * @return the default limit
     */
    public static int getDefaultLimit() {
        return DEFAULT_LIMIT;
    }

    /**
     * Generate from request.
     *
     * @param productListRequest
     *            the product list request
     * @return the product criteria
     */
    public static ProductCriteria generateFromRequest(
            final ProductListRequest productListRequest) {
        ProductCriteria productCriteria = new ProductCriteria();
        productCriteria.setKeyword(productListRequest.getKeyword());
        ProductStatus productStatus = productListRequest.getStatus();
        productCriteria.setStatus(
              productStatus == null ? null 
               : (productStatus.equals(ProductStatus.ACTIVE) ? true : false));
        productCriteria.setBrands(productListRequest.getBrands());
        productCriteria.setCategories(
                            productListRequest.getCategories());
        productCriteria.setStartTime(productListRequest.getStartTime());
        productCriteria.setEndTime(productListRequest.getEndTime());
        productCriteria.setHasStock(productListRequest.getHasStock());
        productCriteria.setLike(productListRequest.getLike());
        productCriteria.setLocation(productListRequest.getLocation());
        productCriteria.setTopPrice(productListRequest.getTopPrice());
        productCriteria.setLowPrice(productListRequest.getLowPrice());
        productCriteria.setOrderByCreated(productListRequest
                          .getOrderByCreated());
        productCriteria.setOrderByPrice(
                        productListRequest.getOrderByPrice());
        productCriteria.setStore(productListRequest.getStore());
        productCriteria.setRedeemStore(
                        productListRequest.getRedeemStore());
        productCriteria.setSellStore(
                        productListRequest.getSellStore());
        productCriteria.setNeedBarcode(
                        productListRequest.getNeedBarcode());
        productCriteria.setOffset(productListRequest.getOffset());
        productCriteria.setLimit(productListRequest.getLimit());
        return productCriteria;
    }

    /**
     * Gets the product detail query criteria.
     *
     * @param request the request
     * @return the product detail query criteria
     */
    public static ProductCriteria getProductDetailQueryCriteria(
            final ProductRequest request) {
        ProductCriteria criteria = new ProductCriteria();
        criteria.setProductId(request.getProductId());
        Integer offset = request.getOffset();
        criteria.setOffset(offset != null 
                && offset <= 0 ? null : offset);
        Integer limit = request.getLimit();
        criteria.setLimit(limit == null
                     || limit <= 0 ? DEFAULT_LIMIT : limit);
        return criteria;
    }

    /**
     * Gets the linked product query criteria.
     *
     * @param productId the product id
     * @param linkedType the linked type
     * @return the linked product query criteria
     */
    public static ProductCriteria getLinkedProductQueryCriteria(
            final Integer productId, final String linkedType) {
        ProductCriteria criteria = new ProductCriteria();
        criteria.setProductId(productId);
        criteria.setLinkedType(linkedType);
        return criteria;
    }
}
