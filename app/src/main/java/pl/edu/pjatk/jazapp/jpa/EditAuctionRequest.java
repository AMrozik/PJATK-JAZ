package pl.edu.pjatk.jazapp.jpa;

import java.math.BigDecimal;

public class EditAuctionRequest {

    private Long id;
    private CategoryEntity category;
    private Long categoryId;
    private String title;
    private String description;
    private BigDecimal price;
    private Long owner_id;
    private String parameter0;
    private String parameter1;
    private String parameter2;
    private String parameter3;
    private String paramValue0;
    private String paramValue1;
    private String paramValue2;
    private String paramValue3;
    private String photo0;
    private String photo1;
    private String photo2;
    private String photo3;

    public String getParameter0() {
        return parameter0;
    }

    public void setParameter0(String parameter0) {
        this.parameter0 = parameter0;
    }

    public String getParameter1() {
        return parameter1;
    }

    public void setParameter1(String parameter1) {
        this.parameter1 = parameter1;
    }

    public String getParameter2() {
        return parameter2;
    }

    public void setParameter2(String parameter2) {
        this.parameter2 = parameter2;
    }

    public String getParameter3() {
        return parameter3;
    }

    public void setParameter3(String parameter3) {
        this.parameter3 = parameter3;
    }

    public String getParamValue0() {
        return paramValue0;
    }

    public void setParamValue0(String paramValue0) {
        this.paramValue0 = paramValue0;
    }

    public String getParamValue1() {
        return paramValue1;
    }

    public void setParamValue1(String paramValue1) {
        this.paramValue1 = paramValue1;
    }

    public String getParamValue2() {
        return paramValue2;
    }

    public void setParamValue2(String paramValue2) {
        this.paramValue2 = paramValue2;
    }

    public String getParamValue3() {
        return paramValue3;
    }

    public void setParamValue3(String paramValue3) {
        this.paramValue3 = paramValue3;
    }

    public String getPhoto0() {
        return photo0;
    }

    public void setPhoto0(String photo0) {
        this.photo0 = photo0;
    }

    public String getPhoto1() {
        return photo1;
    }

    public void setPhoto1(String photo1) {
        this.photo1 = photo1;
    }

    public String getPhoto2() {
        return photo2;
    }

    public void setPhoto2(String photo2) {
        this.photo2 = photo2;
    }

    public String getPhoto3() {
        return photo3;
    }

    public void setPhoto3(String photo3) {
        this.photo3 = photo3;
    }

    public EditAuctionRequest(Long id, CategoryEntity category, Long categoryId, String title, String description, BigDecimal price, Long owner_id) {
        this.id = id;
        this.category = category;
        this.categoryId = categoryId;
        this.title = title;
        this.description = description;
        this.price = price;
        this.owner_id = owner_id;
    }

    public EditAuctionRequest() {
    }

    public EditAuctionRequest(AuctionEntity auction) {
        this.id = auction.getId();
        this.title = auction.getTitle();
        this.price = auction.getPrice();
        this.description = auction.getDescription();
        this.owner_id = auction.getOwnerId();
        this.category = auction.getCategory();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(Long owner_id) {
        this.owner_id = owner_id;
    }
}
