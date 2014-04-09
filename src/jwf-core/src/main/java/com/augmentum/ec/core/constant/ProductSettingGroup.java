/**
 * @author Adrian Yao <adrianyao@augmentum.com.cn>
 * @version 1.6
 * @since 2014 Apr 2, 2014
 */
package com.augmentum.ec.core.constant;

/**
 * The Enum ProductSettingGroup.
 */
public enum ProductSettingGroup {

    /** The general. */
    GENERAL(1);

    /** The id. */
    private int id;

    /**
     * Instantiates a new product setting group.
     * 
     * @param id the id
     */
    private ProductSettingGroup(final int id) {
        this.id = id;
    }

    /**
     * Gets the id.
     * 
     * @return the id
     */
    public int getId() {
        return id;
    }
}
