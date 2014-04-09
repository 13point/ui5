/**
 * @author Adrian Yao <adrianYao@augmentum.com.cn>
 * @version 1.6
 * @since 2014 Mar 28, 2014
 */
package com.augmentum.ec.core.vo;

import java.io.Serializable;
import java.util.List;

/**
 * The Class CategoryVO.
 */
public final class CategoryVO implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -7464217305314861699L;

    /** The id. */
    private Integer id;

    /** The parent id. */
    private Integer parentId;

    /** The name. */
    private String name;

    /** The description. */
    private String description;

    /** The icon. */
    private String icon;

    /** The children. */
    private List<CategoryVO> children;

    /**
     * Gets the id.
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
     * Gets the parent id.
     *
     * @return the parent id
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * Sets the parent id.
     *
     * @param parentId the new parent id
     */
    public void setParentId(final Integer parentId) {
        this.parentId = parentId;
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

    /**
     * Gets the children.
     *
     * @return the children
     */
    public List<CategoryVO> getChildren() {
        return children;
    }

    /**
     * Sets the children.
     *
     * @param children the new children
     */
    public void setChildren(final List<CategoryVO> children) {
        this.children = children;
    }

}
