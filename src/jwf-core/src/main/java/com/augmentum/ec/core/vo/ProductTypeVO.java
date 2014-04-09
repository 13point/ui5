/**
 * @author Adrian Yao <adrianyao@augmentum.com.cn>
 * @version 1.6
 * @since 2014 Apr 1, 2014
 */
package com.augmentum.ec.core.vo;

import java.io.Serializable;

/**
 * The Class ProductTypeVO.
 */
public final class ProductTypeVO implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -6947039108993952099L;

    /** The id. */
    private Integer id;

    /** The name. */
    private String name;

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

}
