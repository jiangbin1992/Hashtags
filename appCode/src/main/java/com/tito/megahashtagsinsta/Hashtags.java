package com.tito.megahashtagsinsta;

public class Hashtags
{
    private String mCategory;
    private String mSubCategory;
    private String mHashtags;
    private int mThumbnail;
    public static final String HASHTAGS_TO_SHOW="HASHTAGSTOSHOW";
    public static final String THUMBNAIL_CONTENT="THUMBNAIL_CONTENT";
    public static final String CONTENT_CATEGORY="CONTENT_CATEGORY";

    public Hashtags(String mCategory, String mSubCategory, String mHashtags, int mThumbnail) {
        this.mCategory = mCategory;
        this.mSubCategory = mSubCategory;
        this.mHashtags = mHashtags;
        this.mThumbnail = mThumbnail;
    }

    public String getmCategory() {
        return mCategory;
    }

    public void setmCategory(String mCategory) {
        this.mCategory = mCategory;
    }

    public String getmSubCategory() {
        return mSubCategory;
    }

    public void setmSubCategory(String mSubCategory) {
        this.mSubCategory = mSubCategory;
    }

    public String getmHashtags() {
        return mHashtags;
    }

    public void setmHashtags(String mHashtags) {
        this.mHashtags = mHashtags;
    }

    public int getmThumbnail() {
        return mThumbnail;
    }

    public void setmThumbnail(int mThumbnail) {
        this.mThumbnail = mThumbnail;
    }
}
