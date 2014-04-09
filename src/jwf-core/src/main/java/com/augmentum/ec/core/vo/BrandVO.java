/**
 * @author Adrian Yao <adrianYao@augmentum.com.cn>
 * @version 1.6
 * @since 2014 Mar 30, 2014
 */
package com.augmentum.ec.core.vo;

import java.io.Serializable;

/**
 * The Class BrandVO.
 */
public final class BrandVO implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 7075083359014349315L;

    /** The brand id. */
    private Integer brandId;

    /** The name. */
    private String name;

    /** The description. */
    private String description;

    /** The icon. */
    private String icon;

    /**
     * Gets the brand id.
     *
     * @return the brand id
     */
    public Integer getBrandId() {
        return brandId;
    }

    /**
     * Sets the brand id.
     *
     * @param brandId the new brand id
     */
    public void setBrandId(final Integer brandId) {
        this.brandId = brandId;
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
     * Gets the icon.
     *
     * @return the icon
     */
    public String getIcon() {
        return icon;
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
