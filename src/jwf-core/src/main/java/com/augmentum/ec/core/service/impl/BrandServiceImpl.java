/**
 * @author Adrian Yao <adrianYao@augmentum.com.cn>
 * @version 1.6
 * @since 2014 Mar 30, 2014
 */
package com.augmentum.ec.core.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.augmentum.ec.core.criteria.BrandCriteria;
import com.augmentum.ec.core.dao.BrandDao;
import com.augmentum.ec.core.entity.Brand;
import com.augmentum.ec.core.service.BrandService;
import com.augmentum.ec.core.vo.BrandVO;
import com.augmentum.ec.core.vo.Pagination;
import com.augmentum.ec.core.vo.request.BrandListRequest;

/**
 * The Class BrandServiceImpl.
 */
@Service
public final class BrandServiceImpl implements BrandService {

    /** The brand dao. */
    @Resource
    private BrandDao brandDao;

    /*
     * (non-Javadoc)
     *
     * @see com.augmentum.ec.core.service.BrandService#getBrands(com.augmentum.ec.core.vo.request.
     * BrandListRequest)
     */
    @Override
    public Pagination<BrandVO> getBrands(final BrandListRequest brandListRequest) {
        BrandCriteria brandCriteria = BrandCriteria.generateFromRequest(brandListRequest);
        List<Brand> brands = brandDao.queryBrands(brandCriteria);
        int count = brandDao.countBrands(brandCriteria);
        List<BrandVO> brandVOs = formatBrands(brands);
        Pagination<BrandVO> pagination = new Pagination<BrandVO>(brandVOs, count);
        return pagination;
    }

    /**
     * Format brands.
     *
     * @param brands the brands
     * @return the list
     */
    private List<BrandVO> formatBrands(final List<Brand> brands) {
        List<BrandVO> brandVOs = new ArrayList<BrandVO>();
        for (Brand brand : brands) {
            brandVOs.add(formatBrand(brand));
        }
        return brandVOs;
    }

    /**
     * Format brand.
     *
     * @param brand the brand
     * @return the brand vo
     */
    private BrandVO formatBrand(final Brand brand) {
        BrandVO brandVO = new BrandVO();
        brandVO.setBrandId(brand.getBrandId());
        brandVO.setDescription(brand.getDescription());
        brandVO.setName(brand.getName());
        brandVO.setIcon(brand.getIcon());
        return brandVO;
    }

}
