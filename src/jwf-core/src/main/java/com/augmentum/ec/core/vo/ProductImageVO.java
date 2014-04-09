/**
 * @author Adrian Yao <adrianyao@augmentum.com.cn>
 * @version 1.6
 * @since 2014 Apr 2, 2014
 */
package com.augmentum.ec.core.vo;

import java.io.Serializable;

/**
 * The Class ProductImageVO.
 */
public final class ProductImageVO implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -5265154843400447454L;

    /** The original url. */
    private String originalUrl;

    /** The thumbnail small. */
    private String thumbnailSmall;

    /** The thumbnail small2x. */
    private String thumbnailSmall2x;

    /** The thumbnail large. */
    private String thumbnailLarge;

    /** The thumbnail large2x. */
    private String thumbnailLarge2x;

    /**
     * Gets the original url.
     * 
     * @return the original url
     */
    public String getOriginalUrl() {
        return originalUrl;
    }

    /**
     * Sets the original url.
     * 
     * @param originalUrl the new original url
     */
    public void setOriginalUrl(final String originalUrl) {
        this.originalUrl = originalUrl;
    }

    /**
     * Gets the thumbnail small.
     * 
     * @return the thumbnail small
     */
    public String getThumbnailSmall() {
        return thumbnailSmall;
    }

    /**
     * Sets the thumbnail small.
     * 
     * @param thumbnailSmall the new thumbnail small
     */
    public void setThumbnailSmall(final String thumbnailSmall) {
        this.thumbnailSmall = thumbnailSmall;
    }

    /**
     * Gets the thumbnail small2x.
     * 
     * @return the thumbnail small2x
     */
    public String getThumbnailSmall2x() {
        return thumbnailSmall2x;
    }

    /**
     * Sets the thumbnail small2x.
     * 
     * @param thumbnailSmall2x the new thumbnail small2x
     */
    public void setThumbnailSmall2x(final String thumbnailSmall2x) {
        this.thumbnailSmall2x = thumbnailSmall2x;
    }

    /**
     * Gets the thumbnail large.
     * 
     * @return the thumbnail large
     */
    public String getThumbnailLarge() {
        return thumbnailLarge;
    }

    /**
     * Sets the thumbnail large.
     * 
     * @param thumbnailLarge the new thumbnail large
     */
    public void setThumbnailLarge(final String thumbnailLarge) {
        this.thumbnailLarge = thumbnailLarge;
    }

    /**
     * Gets the thumbnail large2x.
     * 
     * @return the thumbnail large2x
     */
    public String getThumbnailLarge2x() {
        return thumbnailLarge2x;
    }

    /**
     * Sets the thumbnail large2x.
     * 
     * @param thumbnailLarge2x the new thumbnail large2x
     */
    public void setThumbnailLarge2x(final String thumbnailLarge2x) {
        this.thumbnailLarge2x = thumbnailLarge2x;
    }

}
