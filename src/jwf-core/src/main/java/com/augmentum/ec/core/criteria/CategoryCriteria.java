/**
 * @author Adrian Yao <adrianYao@augmentum.com.cn>
 * @version 1.6
 * @since 2014 Mar 28, 2014
 */
package com.augmentum.ec.core.criteria;

import java.util.List;

import com.augmentum.ec.core.constant.Sort;
import com.augmentum.ec.core.vo.request.CategoryListRequest;

/**
 * The Class CategoryCriteria.
 */
public final class CategoryCriteria {

    /** The ids. */
    private List<Integer> ids;

    /** The parent id. */
    private Integer parentId;

    /** The parent id. */
    private List<Integer> parentIds;

    /** The keyword. */
    private String keyword;

    /** The order by position. */
    private Sort sortPosition;

    /** The group list. */
    private List<GroupColumn> groupList;

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
     * Gets the parent ids.
     *
     * @return the parent ids
     */
    public List<Integer> getParentIds() {
        return parentIds;
    }

    /**
     * Sets the parent ids.
     *
     * @param parentIds the new parent ids
     */
    public void setParentIds(final List<Integer> parentIds) {
        this.parentIds = parentIds;
    }

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
     * Gets the sort position.
     *
     * @return the sort position
     */
    public Sort getSortPosition() {
        return sortPosition;
    }

    /**
     * Sets the sort position.
     *
     * @param sortPosition the new sort position
     */
    public void setSortPosition(final Sort sortPosition) {
        this.sortPosition = sortPosition;
    }

    /**
     * Gets the ids.
     *
     * @return the ids
     */
    public List<Integer> getIds() {
        return ids;
    }

    /**
     * Sets the ids.
     *
     * @param ids the new ids
     */
    public void setIds(final List<Integer> ids) {
        this.ids = ids;
    }

    /**
     * Gets the group list.
     *
     * @return the group list
     */
    public List<GroupColumn> getGroupList() {
        return groupList;
    }

    /**
     * Sets the group list.
     *
     * @param groupList the new group list
     */
    public void setGroupList(final List<GroupColumn> groupList) {
        this.groupList = groupList;
    }

    /**
     * Generate from request.
     *
     * @param categoryListRequest the category list request
     * @return the category criteria
     */
    public static CategoryCriteria generateFromRequest(final CategoryListRequest categoryListRequest) {
        CategoryCriteria categoryCriteria = null;
        if (null != categoryListRequest) {
            categoryCriteria = new CategoryCriteria();
            Integer parentId = categoryListRequest.getParentId();
            categoryCriteria.setParentId(null == parentId ? 0 : parentId);
            categoryCriteria.setKeyword(categoryListRequest.getKeyword());
            categoryCriteria.setSortPosition(Sort.DESC);
        }
        return categoryCriteria;
    }

    /**
     * The Enum GroupColumn.
     */
    public enum GroupColumn {

        /** The category id. */
        CATEGORY_ID("category_id"),

        /** The parent id. */
        PARENT_ID("parent_id"),

        /** The name. */
        NAME("name");

        /** The name. */
        private final String name;

        /**
         * Instantiates a new group column.
         *
         * @param name the name
         */
        private GroupColumn(final String name) {
            this.name = name;
        }

        /**
         * Gets the name.
         *
         * @return the name
         */
        public String getName() {
            return name;
        }
    }

}
