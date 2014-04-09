/**
 * @author Adrian Yao <adrianYao@augmentum.com.cn>
 * @version 1.6
 * @since 2014 Mar 27, 2014
 */
package com.augmentum.ec.core.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

// TODO: Auto-generated Javadoc
/**
 * The Class Product.
 */
@Entity
@Table(name = "product", catalog = "ec_core")
public final class Product implements java.io.Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 7318090641739162847L;

    /** The product id. */
    private Integer productId;

    /** The category id. */
    private Integer categoryId;

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

    /** The created. */
    private Date created;

    /** The updated. */
    private Date updated;

    /** The sell store limit. */
    private boolean sellStoreLimit;

    /** The redeem store limit. */
    private boolean redeemStoreLimit;

    /** The product type. */
    private ProductType productType;

    /** The product settings. */
    private Set<ProductSetting> productSettings;

    /**
     * Instantiates a new product.
     */
    public Product() {
    }

    /**
     * Gets the product id.
     * 
     * @return the product id
     */
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "product_id", unique = true, nullable = false)
    public Integer getProductId() {
        return this.productId;
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
     * Gets the category id.
     * 
     * @return the category id
     */
    @Column(name = "category_id", nullable = false)
    public Integer getCategoryId() {
        return this.categoryId;
    }

    /**
     * Sets the category id.
     * 
     * @param categoryId the new category id
     */
    public void setCategoryId(final Integer categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * Checks if is checks if is active.
     * 
     * @return true, if is checks if is active
     */
    @Column(name = "is_active", nullable = false)
    public boolean isIsActive() {
        return this.isActive;
    }

    /**
     * Sets the checks if is active.
     * 
     * @param isActive the new checks if is active
     */
    public void setIsActive(final boolean isActive) {
        this.isActive = isActive;
    }

    /**
     * Checks if is checks if is listed.
     * 
     * @return true, if is checks if is listed
     */
    @Column(name = "is_listed", nullable = false)
    public boolean isIsListed() {
        return this.isListed;
    }

    /**
     * Sets the checks if is listed.
     * 
     * @param isListed the new checks if is listed
     */
    public void setIsListed(final boolean isListed) {
        this.isListed = isListed;
    }

    /**
     * Gets the position.
     * 
     * @return the position
     */
    @Column(name = "position", nullable = false)
    public Integer getPosition() {
        return this.position;
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
    @Column(name = "name", nullable = false)
    public String getName() {
        return this.name;
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
    @Column(name = "merchant_user_id", nullable = false)
    public Integer getMerchantUserId() {
        return this.merchantUserId;
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
     * Gets the price.
     * 
     * @return the price
     */
    @Column(name = "price", nullable = false, precision = 8)
    public BigDecimal getPrice() {
        return this.price;
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
    @Column(name = "face_price", nullable = false, precision = 8)
    public BigDecimal getFacePrice() {
        return this.facePrice;
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
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "exp_datetime", nullable = false, length = 19)
    public Date getExpDatetime() {
        return this.expDatetime;
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
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "start_datetime", nullable = false, length = 19)
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
    @Column(name = "has_stock", nullable = false)
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
    @Column(name = "need_barcode", nullable = false)
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
     * Gets the created.
     * 
     * @return the created
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created", length = 19)
    public Date getCreated() {
        return this.created;
    }

    /**
     * Sets the created.
     * 
     * @param created the new created
     */
    public void setCreated(final Date created) {
        this.created = created;
    }

    /**
     * Gets the updated.
     * 
     * @return the updated
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated", length = 19)
    public Date getUpdated() {
        return this.updated;
    }

    /**
     * Sets the updated.
     * 
     * @param updated the new updated
     */
    public void setUpdated(final Date updated) {
        this.updated = updated;
    }

    /**
     * Checks if is sell store limit.
     * 
     * @return true, if is sell store limit
     */
    @Column(name = "sell_store_limit", nullable = false)
    public boolean isSellStoreLimit() {
        return this.sellStoreLimit;
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
    @Column(name = "redeem_store_limit", nullable = false)
    public boolean isRedeemStoreLimit() {
        return this.redeemStoreLimit;
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
     * Gets the product type.
     * 
     * @return the product type
     */
    @ManyToOne
    @JoinColumn(name = "product_type_id")
    public ProductType getProductType() {
        return productType;
    }

    /**
     * Sets the product type.
     * 
     * @param productType the new product type
     */
    public void setProductType(final ProductType productType) {
        this.productType = productType;
    }

    /**
     * Gets the product settings.
     * 
     * @return the product settings
     */
    @OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    public Set<ProductSetting> getProductSettings() {
        return productSettings;
    }

    /**
     * Sets the product settings.
     * 
     * @param productSettings the new product settings
     */
    public void setProductSettings(final Set<ProductSetting> productSettings) {
        this.productSettings = productSettings;
    }

}
