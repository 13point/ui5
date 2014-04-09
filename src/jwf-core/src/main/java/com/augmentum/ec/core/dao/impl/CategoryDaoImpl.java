/**
 * @author Adrian Yao <adrianYao@augmentum.com.cn>
 * @version 1.6
 * @since 2014 Mar 27, 2014
 */
package com.augmentum.ec.core.dao.impl;

import static com.augmentum.ec.core.constant.SQL.AND;
import static com.augmentum.ec.core.constant.SQL.COMMA;
import static com.augmentum.ec.core.constant.SQL.GROUP_BY;
import static com.augmentum.ec.core.constant.SQL.OR;
import static com.augmentum.ec.core.constant.SQL.ORDER_BY;
import static com.augmentum.ec.core.constant.SQL.WHERE;

import java.util.List;

import javax.persistence.Query;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import com.augmentum.ec.core.constant.Sort;
import com.augmentum.ec.core.criteria.CategoryCriteria;
import com.augmentum.ec.core.criteria.CategoryCriteria.GroupColumn;
import com.augmentum.ec.core.dao.CategoryDao;
import com.augmentum.ec.core.entity.Category;

/**
 * The Class CategoryDaoImpl.
 */
@Repository
public final class CategoryDaoImpl extends BaseCoreDaoImpl<Category> implements CategoryDao {

    /**
     * Instantiates a new category dao impl.
     */
    public CategoryDaoImpl() {
        setClazz(Category.class);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.augmentum.ec.core.dao.CategoryDao#queryCategories(com.augmentum.ec.core.criteria.
     * CategoryCriteria)
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<Category> queryCategories(final CategoryCriteria categoryCriteria) {
        return generateCategoriesQuery(categoryCriteria).getResultList();
    }

    /**
     * Generate categories query.
     * 
     * @param categoryCriteria the category criteria
     * @return the query
     */
    private Query generateCategoriesQuery(final CategoryCriteria categoryCriteria) {
        List<Integer> ids = categoryCriteria.getIds();
        Integer parentId = categoryCriteria.getParentId();
        List<Integer> parentIds = categoryCriteria.getParentIds();
        String keyword = categoryCriteria.getKeyword();
        Sort sortPostion = categoryCriteria.getSortPosition();
        List<GroupColumn> groupList = categoryCriteria.getGroupList();

        boolean ifIds = ids != null && !ids.isEmpty();
        boolean ifParentId = parentId != null;
        boolean ifParentIds = parentIds != null && !parentIds.isEmpty();
        boolean ifKeyword = StringUtils.isNotBlank(keyword);
        boolean ifSortPostion = sortPostion != null;
        boolean ifGroup = groupList != null && !groupList.isEmpty();

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT c.* FROM category c ");

        sql.append(WHERE);
        sql.append("1 = 1 ");

        if (ifIds) {
            sql.append(AND);
            sql.append("c.category_id IN (:ids) ");
        }

        if (ifParentId) {
            sql.append(AND);
            sql.append("c.parent_id = :parentId ");
        }

        if (ifParentIds) {
            sql.append(AND);
            sql.append("c.parent_id IN (:parentIds) ");
        }

        if (ifKeyword) {
            sql.append(AND);
            sql.append("c.name LIKE :keyword ");
            sql.append(OR);
            sql.append("c.description LIKE :keyword");
        }

        if (ifGroup) {
            sql.append(GROUP_BY);
            boolean firstGroup = true;
            for (GroupColumn groupColumn : groupList) {
                if (!firstGroup) {
                    sql.append(COMMA);
                } else {
                    firstGroup = false;
                }
                sql.append(groupColumn.getName());
            }
        }


        if (ifSortPostion) {
            sql.append(ORDER_BY);
            sql.append("c.position ");
            sql.append(sortPostion.getGrammar());
        }


        Query query = getEM(true).createNativeQuery(sql.toString(), Category.class);

        if (ifIds) {
            query.setParameter("ids", ids);
        }

        if (ifParentId) {
            query.setParameter("parentId", parentId);
        }

        if (ifParentIds) {
            query.setParameter("parentIds", parentIds);
        }

        if (ifKeyword) {
            query.setParameter("keyword", "%" + keyword + "%");
        }

        return query;
    }

}
