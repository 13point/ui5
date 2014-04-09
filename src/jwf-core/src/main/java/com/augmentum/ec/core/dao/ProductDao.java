/**
 * @author Adrian Yao <adrianYao@augmentum.com.cn>
 * @version 1.6
 * @since 2014 Mar 31, 2014
 */
package com.augmentum.ec.core.dao;

import java.util.List;

import com.augmentum.ec.core.criteria.ProductCriteria;
import com.augmentum.ec.core.criteria.ProductInventoryCriteria;
import com.augmentum.ec.core.entity.Product;
import com.augmentum.ec.core.entity.ProductStockStore;

// TODO: Auto-generated Javadoc
/**
 * The Interface ProductDao.
 */
public interface ProductDao extends BaseCoreDao<Product> {


    /**
     * Query products.
     *
     * @param productCriteria the product criteria
     * @return the list
     */
    List<Product> queryProducts(ProductCriteria productCriteria);

    /**
     * Count products.
     *
     * @param productCriteria the product criteria
     * @return the int
     */
    int countProducts(ProductCriteria productCriteria);

    /**
     * Query inventory status list.
     *
     * @param criteria the criteria
     * @return the list
     */
    List<ProductStockStore> queryInventoryStatusList(
             ProductInventoryCriteria criteria);

    /**
     * Count inventory status.
     *
     * @param criteria the criteria
     * @return the integer
     */
    Integer countInventoryStatus(ProductInventoryCriteria criteria);

    /**
     * Gets the product detail by id.
     *
     * @param criteria the criteria
     * @return the product detail by id
     */
    Product getProductDetailById(ProductCriteria criteria);

    /**
     * Query linked product list.
     *
     * @param criteria the criteria
     * @return the list
     */
    List<Product> queryLinkedProductList(ProductCriteria criteria);
}
