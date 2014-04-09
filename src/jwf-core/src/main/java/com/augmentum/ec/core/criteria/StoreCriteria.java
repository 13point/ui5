/**
 * @author Charles xu <charlesxu@augmentum.com.cn>
 * @version 1.6
 * @since 2014 Apr 3, 2014
 */
package com.augmentum.ec.core.criteria;

import java.math.BigDecimal;
import java.util.List;

import com.augmentum.ec.core.vo.request.StoreListRequest;

// TODO: Auto-generated Javadoc
/**
 * The Class StoreCriteria.
 */
public final class StoreCriteria extends PaginationCriteria {

    /** The Constant DEFAULT_LIMIT. */
    private static final int DEFAULT_LIMIT = 1000;

    /** The Constant DEFAULT_DISTANCE. */
    private static final int DEFAULT_DISTANCE = 5000;

    /** The keyword. */
    private String keyword;

    /** The product ids. */
    private List<Integer> productIds;

    /** The has stock. */
    private Boolean hasStock;

    /** The longitude. */
    private BigDecimal longitude;

    /** The latitude. */
    private BigDecimal latitude;

    /** The distance. */
    private Integer distance;

    /** The department id. */
    private Integer departmentId;

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
     * Gets the longitude.
     * 
     * @return the longitude
     */
    public BigDecimal getLongitude() {
        return longitude;
    }

    /**
     * Sets the longitude.
     * 
     * @param longitude the new longitude
     */
    public void setLongitude(final BigDecimal longitude) {
        this.longitude = longitude;
    }

    /**
     * Gets the latitude.
     * 
     * @return the latitude
     */
    public BigDecimal getLatitude() {
        return latitude;
    }

    /**
     * Sets the latitude.
     * 
     * @param latitude the new latitude
     */
    public void setLatitude(final BigDecimal latitude) {
        this.latitude = latitude;
    }

    /**
     * Gets the distance.
     * 
     * @return the distance
     */
    public Integer getDistance() {
        return distance;
    }

    /**
     * Sets the distance.
     * 
     * @param distance the new distance
     */
    public void setDistance(final Integer distance) {
        this.distance = distance;
    }

    /**
     * Gets the department id.
     * 
     * @return the department id
     */
    public Integer getDepartmentId() {
        return departmentId;
    }

    /**
     * Sets the department id.
     * 
     * @param departmentId the new department id
     */
    public void setDepartmentId(final Integer departmentId) {
        this.departmentId = departmentId;
    }

    /**
     * Generate from request.
     * 
     * @param storeListRequest the store list request
     * @return the brand criteria
     */
    public static StoreCriteria generateFromRequest(final StoreListRequest storeListRequest) {
        StoreCriteria storeCriteria = new StoreCriteria();
        storeCriteria.setKeyword(storeListRequest.getKeyword());
        storeCriteria.setProductIds(storeListRequest.getProductIds());
        storeCriteria.setDepartmentId(storeListRequest.getDepartmentId());
        storeCriteria.setHasStock(storeListRequest.getHasStock());
        storeCriteria.setLongitude(storeListRequest.getLongitude());
        storeCriteria.setLatitude(storeListRequest.getLatitude());
        Integer distance = storeListRequest.getDistance();
        storeCriteria.setDistance(distance == null || distance <= 0 ? DEFAULT_DISTANCE : distance);
        Integer offset = storeListRequest.getOffset();
        storeCriteria.setOffset(offset != null && offset <= 0 ? null : offset);
        Integer limit = storeListRequest.getLimit();
        storeCriteria.setLimit(limit == null || limit <= 0 ? DEFAULT_LIMIT : limit);
        return storeCriteria;
    }
}
