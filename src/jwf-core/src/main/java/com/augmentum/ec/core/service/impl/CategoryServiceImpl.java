/**
 * @author Adrian Yao <adrianYao@augmentum.com.cn>
 * @version 1.6
 * @since 2014 Mar 28, 2014
 */
package com.augmentum.ec.core.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.augmentum.ec.core.constant.Sort;
import com.augmentum.ec.core.criteria.CategoryCriteria;
import com.augmentum.ec.core.dao.CategoryDao;
import com.augmentum.ec.core.entity.Category;
import com.augmentum.ec.core.service.CategoryService;
import com.augmentum.ec.core.vo.CategoryVO;
import com.augmentum.ec.core.vo.request.CategoryListRequest;

/**
 * The Class CategoryServiceImpl.
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    /** The category dao. */
    @Resource
    private CategoryDao categoryDao;

    /*
     * (non-Javadoc)
     *
     * @see
     * com.augmentum.ec.core.service.CategoryService#getCategoryList(com.augmentum.ec.core.vo.request
     * .CategoryListRequest)
     */
    @Override
    public final List<CategoryVO> getCategoryList(final CategoryListRequest categoryListRequest) {

        CategoryCriteria categoryCriteria = CategoryCriteria.generateFromRequest(categoryListRequest);
        List<Category> categories = categoryDao.queryCategories(categoryCriteria);
        List<CategoryVO> categoryVOs = formatCategories(categories);

        Map<Integer, CategoryVO> categoryVORepository = new HashMap<Integer, CategoryVO>();

        List<Integer> categoryIds = new ArrayList<Integer>();
        for (CategoryVO categoryVO : categoryVOs) {
            Integer categoryId = categoryVO.getId();
            categoryVORepository.put(categoryId, categoryVO);
            categoryIds.add(categoryId);
        }

        Boolean fetchAll = categoryListRequest.getFetchAll();

        if (null != fetchAll && fetchAll) {
            setChildren(categoryVORepository, categoryIds);
        }
        return categoryVOs;
    }

    /**
     * Format categories.
     *
     * @param categories the categories
     * @return the list
     */
    private List<CategoryVO> formatCategories(final List<Category> categories) {
        List<CategoryVO> categoryVOs = new ArrayList<CategoryVO>();
        for (Category category : categories) {
            categoryVOs.add(formatCategory(category));
        }
        return categoryVOs;

    }

    /**
     * Format category.
     *
     * @param category the category
     * @return the category vo
     */
    private CategoryVO formatCategory(final Category category) {
        CategoryVO categoryVO = null;
        if (null != category) {
            categoryVO = new CategoryVO();
            categoryVO.setId(category.getCategoryId());
            categoryVO.setParentId(category.getParentId());
            categoryVO.setIcon(category.getIcon());
            categoryVO.setName(category.getName());
            categoryVO.setDescription(category.getDescription());
        }
        return categoryVO;
    }

    /**
     * Sets the children.
     *
     * @param categoryVORepository the category vo repository
     * @param categoryIds the category ids
     */
    private void setChildren(final Map<Integer, CategoryVO> categoryVORepository, final List<Integer> categoryIds) {
        CategoryCriteria categoryCriteria = new CategoryCriteria();
        categoryCriteria = new CategoryCriteria();
        categoryCriteria.setParentIds(categoryIds);
        categoryCriteria.setSortPosition(Sort.DESC);
        List<Category> categoriesTemp = categoryDao.queryCategories(categoryCriteria);

        if (null != categoriesTemp && !categoriesTemp.isEmpty()) {

            List<Integer> categoryIdsTemp = new ArrayList<Integer>();

            for (Category category : categoriesTemp) {
                Integer parentId = category.getParentId();
                CategoryVO categoryVO = categoryVORepository.get(parentId);

                if (null != categoryVO) {
                    CategoryVO childCategoryVO = formatCategory(category);
                    List<CategoryVO> children = categoryVO.getChildren();

                    if (null == children) {
                        children = new ArrayList<CategoryVO>();
                        children.add(childCategoryVO);
                        categoryVO.setChildren(children);
                    } else {
                        children.add(childCategoryVO);
                    }
                    Integer childCategoryVOId = childCategoryVO.getId();
                    categoryIdsTemp.add(childCategoryVOId);
                    categoryVORepository.put(childCategoryVOId, childCategoryVO);
                }
            }
            setChildren(categoryVORepository, categoryIdsTemp);
        }
    }

}
