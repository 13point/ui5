/**
 * @author Adrian Yao <adrianYao@augmentum.com.cn>
 * @version 1.6
 * @since 2014 Mar 28, 2014
 */
package com.augmentum.ec.core.service;

import java.util.List;

import com.augmentum.ec.core.vo.CategoryVO;
import com.augmentum.ec.core.vo.request.CategoryListRequest;

/**
 * The Interface CategoryService.
 */
public interface CategoryService {

    /**
     * Gets the category list.
     *
     * @param categoryListRequest the category list request
     * @return the category list
     */
    List<CategoryVO> getCategoryList(CategoryListRequest categoryListRequest);

}
