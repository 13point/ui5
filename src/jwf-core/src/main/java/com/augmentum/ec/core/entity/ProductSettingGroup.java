/**
 * @author Adrian Yao <adrianYao@augmentum.com.cn>
 * @version 1.6
 * @since 2014 Mar 27, 2014
 */
package com.augmentum.ec.core.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The Class ProductSettingGroup.
 */
@Entity
@Table(name = "product_setting_group", catalog = "ec_core")
public final class ProductSettingGroup implements java.io.Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 7693149545908544795L;

    /** The product setting group id. */
    private Integer productSettingGroupId;

    /** The name. */
    private String name;

    /** The description. */
    private String description;

    /** The icon. */
    private String icon;

    /**
     * Instantiates a new product setting group.
     */
    public ProductSettingGroup() {
    }

    /**
     * Gets the product setting group id.
     *
     * @return the product setting group id
     */
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "product_setting_group_id", unique = true, nullable = false)
    public Integer getProductSettingGroupId() {
        return this.productSettingGroupId;
    }

    /**
     * Sets the product setting group id.
     *
     * @param productSettingGroupId the new product setting group id
     */
    public void setProductSettingGroupId(final Integer productSettingGroupId) {
        this.productSettingGroupId = productSettingGroupId;
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    @Column(name = "name", nullable = false, length = 64)
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
     * Gets the description.
     *
     * @return the description
     */
    @Column(name = "description")
    public String getDescription() {
        return this.description;
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
     * Gets the icon.
     *
     * @return the icon
     */
    @Column(name = "icon")
    public String getIcon() {
        return this.icon;
    }

    /**
     * Sets the icon.
     *
     * @param icon the new icon
     */
    public void setIcon(final String icon) {
        this.icon = icon;
    }

}
