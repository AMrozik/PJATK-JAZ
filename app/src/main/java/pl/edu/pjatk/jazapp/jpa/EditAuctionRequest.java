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
