/**
 * @author Adrian Yao <adrianyao@augmentum.com.cn>
 * @version 1.6
 * @since 2014 Apr 2, 2014
 */
package com.augmentum.ec.core.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.augmentum.ec.core.constant.CommonConstant;
import com.augmentum.ec.core.constant.ProductSettingGroup;
import com.augmentum.ec.core.constant.ProductSettingKey;
import com.augmentum.ec.core.criteria.CategoryCriteria;
import com.augmentum.ec.core.criteria.ProductCriteria;
import com.augmentum.ec.core.criteria.ProductInventoryCriteria;
import com.augmentum.ec.core.dao.BrandDao;
import com.augmentum.ec.core.dao.CategoryDao;
import com.augmentum.ec.core.dao.ProductBrandDao;
import com.augmentum.ec.core.dao.ProductDao;
import com.augmentum.ec.core.dao.ProductSettingDao;
import com.augmentum.ec.core.entity.Brand;
import com.augmentum.ec.core.entity.Category;
import com.augmentum.ec.core.entity.Product;
import com.augmentum.ec.core.entity.ProductBrand;
import com.augmentum.ec.core.entity.ProductSetting;
import com.augmentum.ec.core.entity.ProductStockStore;
import com.augmentum.ec.core.entity.ProductType;
import com.augmentum.ec.core.service.ProductService;
import com.augmentum.ec.core.util.DateUtil;
import com.augmentum.ec.core.vo.BrandVO;
import com.augmentum.ec.core.vo.CategoryVO;
import com.augmentum.ec.core.vo.Pagination;
import com.augmentum.ec.core.vo.ProductImageVO;
import com.augmentum.ec.core.vo.ProductListVO;
import com.augmentum.ec.core.vo.ProductStockStoreVO;
import com.augmentum.ec.core.vo.ProductTypeVO;
import com.augmentum.ec.core.vo.ProductVO;
import com.augmentum.ec.core.vo.request.ProductInventoryListRequest;
import com.augmentum.ec.core.vo.request.ProductListRequest;
import com.augmentum.ec.core.vo.request.ProductRequest;

// TODO: Auto-generated Javadoc
/**
 * The Class ProductServiceImpl.
 */
@Service
public final class ProductServiceImpl implements ProductService {

    /** The product dao. */
    @Resource
    private ProductDao productDao;

    /** The category dao. */
    @Resource
    private CategoryDao categoryDao;

    /** The product brand dao. */
    @Resource
    private ProductBrandDao productBrandDao;

    /** The brand dao. */
    @Resource
    private BrandDao brandDao;

    /** The product setting dao. */
    @Resource
    private ProductSettingDao productSettingDao;

    /*
     * (non-Javadoc)
     *
     * @see
     * com.augmentum.ec.core.
     *      service.ProductService#getProducts
     * (com.augmentum.ec.core.vo.request.ProductListRequest)
     */
    @Override
    public Pagination<ProductListVO> getProducts(
             final ProductListRequest productListRequest) {
        ProductCriteria productCriteria =
                ProductCriteria.generateFromRequest(productListRequest);
        List<Product> products = productDao.queryProducts(productCriteria);
        int count = productDao.countProducts(productCriteria);
        return new Pagination<ProductListVO>(formatProducts(products), count);
    }

    /**
     * Format products.
     *
     * @param products the products
     * @return the list
     */
    private List<ProductListVO> formatProducts(final List<Product> products) {
        List<ProductListVO> productListVOs = new ArrayList<ProductListVO>();
        Set<Integer> categoryIds = new HashSet<Integer>();
        List<Integer> productIds = new ArrayList<Integer>();

        for (Product product : products) {
            ProductListVO productListVO = formatToProductListVO(product);
            productListVOs.add(productListVO);
            categoryIds.add(product.getCategoryId());
            productIds.add(product.getProductId());
        }

        if (!productListVOs.isEmpty()) {
            if (!categoryIds.isEmpty()) {
                setCategories(productListVOs, categoryIds);
            }
            setBrands(productListVOs, productIds);
            setImages(productListVOs, productIds);
        }
        return productListVOs;
    }

    /**
     * Sets the images.
     *
     * @param productListVOs the product list v os
     * @param productIds the product ids
     */
    private void setImages(
            final List<ProductListVO> productListVOs,
            final List<Integer> productIds) {
        List<ProductSetting> productSettings =
                productSettingDao.getByProductIdsAndGroupIds(
                 productIds,
                 ProductSettingGroup.GENERAL.getId());
        Map<Integer, ProductImageVO> productImageRepository =
                new HashMap<Integer, ProductImageVO>();
        for (ProductSetting productSetting : productSettings) {
            Integer productId = productSetting.getId().getProductId();
            String path = productSetting.getId().getPath();
            String data = productSetting.getData();

            ProductImageVO productImageVO = null;
            if (productImageRepository.containsKey(productId)) {
                productImageVO = productImageRepository.get(productId);
            } else {
                productImageVO = new ProductImageVO();
                productImageRepository.put(productId, productImageVO);
            }

            if (ProductSettingKey.ORIGINAL_URL.equals(path)) {
                productImageVO.setOriginalUrl(data);
            } else if (ProductSettingKey.THUMBNAIL_L.equals(path)) {
                productImageVO.setThumbnailLarge(data);
            } else if (ProductSettingKey.THUMBNAIL_L_2X.equals(path)) {
                productImageVO.setThumbnailLarge2x(data);
            } else if (ProductSettingKey.THUMBNAIL_S.equals(path)) {
                productImageVO.setThumbnailSmall(data);
            } else if (ProductSettingKey.THUMBNAIL_S_2X.equals(path)) {
                productImageVO.setThumbnailSmall2x(data);
            }
        }

        ProductImageVO emptyImageVO = new ProductImageVO();
        for (ProductListVO productListVO : productListVOs) {
            Integer proudctId = productListVO.getId();
            ProductImageVO productImageVO =
                    productImageRepository.get(proudctId);
            if (productImageVO == null) {
                productListVO.setImages(emptyImageVO);
            } else {
                productListVO.setImages(productImageVO);
            }
        }
    }

    /**
     * Sets the categories.
     *
     * @param productListVOs the product list v os
     * @param categoryIds the category ids
     */
    private void setCategories(
            final List<ProductListVO> productListVOs,
            final Set<Integer> categoryIds) {
        CategoryCriteria categoryCriteria =
                new CategoryCriteria();
        categoryCriteria.setIds(
                    new ArrayList<Integer>(categoryIds));
        List<Category> categories =
                categoryDao.queryCategories(categoryCriteria);
        Map<Integer, CategoryVO> categoryRepository =
                new HashMap<Integer, CategoryVO>();
        for (Category category : categories) {
            CategoryVO categoryVO = new CategoryVO();
            categoryVO.setId(category.getCategoryId());
            categoryVO.setName(category.getName());
            categoryVO.setParentId(category.getParentId());
            categoryRepository.put(category.getCategoryId(), categoryVO);
        }

        for (ProductListVO productListVO : productListVOs) {
            CategoryVO categoryVO = productListVO.getCategory();
            if (null != categoryVO && null != categoryVO.getId()) {
                productListVO.setCategory(
                      categoryRepository.get(categoryVO.getId()));
            }
        }
    }

    /**
     * Sets the brands.
     *
     * @param productListVOs the product list v os
     * @param productIds the product ids
     */
    private void setBrands(
            final List<ProductListVO> productListVOs,
            final List<Integer> productIds) {
        List<ProductBrand> productBrands =
                productBrandDao.getByProductIds(productIds);
        Map<Integer, List<Integer>> productIdToBrandIds =
                new HashMap<Integer, List<Integer>>();
        Set<Integer> brandIdsForQuery = new HashSet<Integer>();

        for (ProductBrand productBrand : productBrands) {
            Integer productId = productBrand.getId().getProductId();
            Integer brandId = productBrand.getId().getBrandId();
            List<Integer> brandIds = productIdToBrandIds.get(productId);
            if (null != brandIds) {
                brandIds.add(brandId);
            } else {
                List<Integer> brandIdsNew = new ArrayList<Integer>();
                brandIdsNew.add(brandId);
                productIdToBrandIds.put(productId, brandIdsNew);
            }
            brandIdsForQuery.add(brandId);
        }

        if (!brandIdsForQuery.isEmpty()) {
            List<Brand> brands = brandDao.getByBrandIds(
                        new ArrayList<Integer>(brandIdsForQuery));
            Map<Integer, BrandVO> brandRepository =
                    new HashMap<Integer, BrandVO>();
            for (Brand brand : brands) {
                BrandVO brandVO = new BrandVO();
                brandVO.setBrandId(brand.getBrandId());
                brandVO.setName(brand.getName());
                brandVO.setIcon(brandVO.getIcon());
                brandRepository.put(brand.getBrandId(), brandVO);
            }

            for (ProductListVO productListVO : productListVOs) {
                Integer productId = productListVO.getId();
                List<Integer> brandIds = productIdToBrandIds.get(productId);
                List<BrandVO> brandVOs = new ArrayList<BrandVO>();
                if (null != brandIds) {
                    for (Integer brandId : brandIds) {
                        BrandVO brandVO = brandRepository.get(brandId);
                        if (null != brandVO) {
                            brandVOs.add(brandVO);
                        }
                    }
                }
                productListVO.setBrands(brandVOs);
            }
        }
    }

    /**
     * Format to product list vo.
     *
     * @param product the product
     * @return the product list vo
     */
    private ProductListVO formatToProductListVO(final Product product) {
        ProductListVO productListVO = new ProductListVO();
        productListVO.setId(product.getProductId());
        productListVO.setActive(product.isIsActive());
        CategoryVO categoryVO = new CategoryVO();
        categoryVO.setId(product.getCategoryId());
        productListVO.setCategory(categoryVO);
        productListVO.setExpDatetime(product.getExpDatetime());
        productListVO.setStartDatetime(product.getStartDatetime());
        productListVO.setFacePrice(product.getFacePrice());
        productListVO.setPrice(product.getPrice());
        productListVO.setHasStock(product.isHasStock());
        productListVO.setName(product.getName());
        productListVO.setNeedBarcode(product.isNeedBarcode());
//        ProductTypeVO productTypeVO = new ProductTypeVO();
//        productTypeVO.setId(product.getProductTypeId());
        ProductTypeVO productTypeVO =
                this.formatProductTypeVO(product.getProductType());
        productListVO.setProductType(productTypeVO);
        productListVO.setRedeemStoreLimit(product.isRedeemStoreLimit());
        productListVO.setSellStoreLimit(product.isSellStoreLimit());
        return productListVO;
    }

    /*
     * (non-Javadoc)
     *
     * @see com.augmentum.ec.core.service.ProductService#getProductDetail
     * (java.lang.Integer)
     */
    @Override
    public ProductVO getProductDetail(final Integer productId) {
        return null;
    }

    /* (non-Javadoc)
     * @see com.augmentum.ec
     *      .core.service.ProductService#getInventoryStatus
     *      (com.augmentum.ec.core.vo.request.ProductInventoryListRequest)
     */
    @Override
    public Pagination<ProductStockStoreVO> getInventoryStatus(
          final ProductInventoryListRequest productInventoryListRequest) {
        ProductInventoryCriteria criteria = ProductInventoryCriteria
                .getInventoryQuerySql(productInventoryListRequest);
        List<ProductStockStore> stores = productDao
                .queryInventoryStatusList(criteria);
        Integer count = productDao.countInventoryStatus(criteria);
        List<ProductStockStoreVO> storeVOs = formatInventoryStatus(stores);
        Pagination<ProductStockStoreVO> pagination =
                new Pagination<ProductStockStoreVO>(
                        storeVOs, count);
        return pagination;
    }

    /**
     * Format inventory status.
     *
     * @param stores the stores
     * @return the list
     */
    private List<ProductStockStoreVO> formatInventoryStatus(
                final List<ProductStockStore> stores) {
        List<ProductStockStoreVO> storeVOs =
                new ArrayList<ProductStockStoreVO>();
        for (ProductStockStore store : stores) {
            storeVOs.add(formatStore(store));
        }
        return storeVOs;
    }

    /**
     * Format store.
     *
     * @param store the store
     * @return the product stock store vo
     */
    private ProductStockStoreVO formatStore(final ProductStockStore store) {
        ProductStockStoreVO s = new ProductStockStoreVO();
        s.setName(store.getName());
        s.setStoreId(store.getId().getStoreId());
        s.setQtyAvailable(store.getQtyAvailable());
        return s;
    }

    /* (non-Javadoc)
     * @see com.augmentum.ec.core
     *      .service.ProductService#getProductDetailById
     *      (com.augmentum.ec.core.vo.request.ProductRequest)
     */
    @Override
    public ProductVO getProductDetailById(final ProductRequest productRequest) {
        ProductCriteria criteria = ProductCriteria
                .getProductDetailQueryCriteria(productRequest);
    Product product = productDao.getProductDetailById(criteria);
    ProductVO vo = formatProduct(product);
    return vo;
    }

    /**
     * Format product.
     *
     * @param product the product
     * @return the product vo
     */
    private ProductVO formatProduct(final Product product) {
        ProductVO vo = new ProductVO();
        vo.setCreated(DateUtil.formatDate(product.getCreated(),
                  CommonConstant.UTC_FORMAT));
        vo.setExpDatetime(DateUtil.formatDate(product.getExpDatetime(),
                  CommonConstant.UTC_FORMAT));
        vo.setFacePrice(product.getFacePrice());
        vo.setListed(product.isIsListed());
        vo.setActive(product.isIsActive());
        vo.setMerchantUserId(product.getMerchantUserId());
        vo.setName(product.getName());
        vo.setPosition(product.getPosition());
        vo.setPrice(product.getPrice());
        vo.setProductId(product.getProductId());
        vo.setRedeemStoreLimit(product.isRedeemStoreLimit());
        vo.setSellStoreLimit(product.isSellStoreLimit());
        vo.setUpdated(DateUtil.formatDate(product.getUpdated(),
                  CommonConstant.UTC_FORMAT));
        vo.setHasStock(product.isHasStock());
        vo.setStartDatetime(DateUtil.formatDate(product.getStartDatetime(),
                  CommonConstant.UTC_FORMAT));
        vo.setNeedBarcode(product.isNeedBarcode());
        ProductTypeVO productTypeVO =
                formatProductTypeVO(product.getProductType());
        vo.setProductType(productTypeVO);

        Set<Integer> categoryIds = new HashSet<Integer>();
        categoryIds.add(product.getCategoryId());
        CategoryCriteria categoryCriteria = new CategoryCriteria();
        categoryCriteria.setIds(new ArrayList<Integer>(categoryIds));
        List<Category> categories =
                categoryDao.queryCategories(categoryCriteria);
        if (categories != null && categories.size() > 0) {
            CategoryVO categoryVO = formatCategoryVO(categories.get(0));
            vo.setCategory(categoryVO);
        }
        setProductSettings(vo, product.getProductSettings());
        return vo;
    }

    /**
     * Sets the product settings.
     *
     * @param vo the vo
     * @param productSettings the product settings
     */
    private void setProductSettings(final ProductVO vo,
            final Set<ProductSetting> productSettings) {
        Iterator<ProductSetting> it = productSettings.iterator();
        while (it.hasNext()) {
            ProductSetting setting = it.next();
            if (CommonConstant.PRODUCT_SETTING_DESCRIPTION
                    .equals(setting.getId().getPath())) {
                vo.setDescription(setting.getData());
            } else if (CommonConstant.PRODUCT_SETTING_AFTER_SERVICE
                    .equals(setting.getId().getPath())) {
                vo.setAfterService(setting.getData());
            } else if (CommonConstant.PRODUCT_SETTING_INVENTORY_ALERT
                    .equals(setting.getId().getPath())) {
                vo.setInventoryAlert(setting.getData());
            } else if (CommonConstant.PRODUCT_SETTING_SHORT_DESC
                    .equals(setting.getId().getPath())) {
                vo.setShortDescription(setting.getData());
            } else if (CommonConstant.PRODUCT_SETTING_SKU
                    .equals(setting.getId().getPath())) {
                vo.setSku(setting.getData());
            }
        }
    }

    /**
     * Format category vo.
     *
     * @param category the category
     * @return the category vo
     */
    private CategoryVO formatCategoryVO(final Category category) {
        CategoryVO vo = new CategoryVO();
        vo.setId(category.getCategoryId());
        vo.setDescription(category.getDescription());
        vo.setIcon(category.getIcon());
        vo.setName(category.getName());
        vo.setParentId(category.getParentId());
        return vo;
    }

    /**
     * Format product type vo.
     *
     * @param productType the product type
     * @return the product type vo
     */
    private ProductTypeVO formatProductTypeVO(
                final ProductType productType) {
        ProductTypeVO vo = new ProductTypeVO();
        vo.setId(productType.getProductTypeId());
        vo.setName(productType.getName());
        return vo;
    }

    /* (non-Javadoc)
     * @see com.augmentum.ec.core
     *      .service.ProductService#getLinkedProductList
     *      (java.lang.Integer, java.lang.String)
     */
    @Override
    public List<ProductListVO> getLinkedProductList(
                final Integer productId, final String linkedType) {
        ProductCriteria criteria = ProductCriteria
                .getLinkedProductQueryCriteria(productId, linkedType);
        List<Product> relatedProductList =
                productDao.queryLinkedProductList(criteria);
        List<ProductListVO> vos =
                formatProducts(relatedProductList);
        return vos;
    }

}
