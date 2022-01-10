package com.project.nftverse;

public class assetModel {

    private int asset_id;
    private String image_url;
    private String name;
    private String external_link;
    private String price;
    private String owned_by;
    private String description;
    private String is_fav;

    public assetModel(int asset_id, String image_url, String name, String external_link, String price, String owned_by, String description, String is_fav) {
        this.asset_id = asset_id;
        this.image_url = image_url;
        this.name = name;
        this.external_link = external_link;
        this.price = price;
        this.owned_by = owned_by;
        this.description = description;
        this.is_fav = is_fav;
    }

    public int getAsset_id() {
        return asset_id;
    }

    public void setAsset_id(int asset_id) {
        this.asset_id = asset_id;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExternal_link() {
        return external_link;
    }

    public void setExternal_link(String external_link) {
        this.external_link = external_link;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getOwned_by() {
        return owned_by;
    }

    public void setOwned_by(String owned_by) {
        this.owned_by = owned_by;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIs_fav() {
        return is_fav;
    }

    public void setIs_fav(String is_fav) {
        this.is_fav = is_fav;
    }

    @Override
    public String toString() {
        return "assetModel{" +
                "asset_id=" + asset_id +
                ", name='" + name + '\'' +
                '}';
    }
}
