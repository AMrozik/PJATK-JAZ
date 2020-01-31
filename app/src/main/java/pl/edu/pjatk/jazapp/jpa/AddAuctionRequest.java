package pl.edu.pjatk.jazapp.jpa;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.math.BigDecimal;
import java.util.List;

@Named
@RequestScoped
public class AddAuctionRequest {

    private CategoryEntity category;
    private String title;
    private String description;
    private List<PhotoEntity> photos;
    private List<AuctionParameterEntity> parameters;
    private BigDecimal price;
    private Long ownerId;

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
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

    public List<PhotoEntity> getPhotos() {
        return photos;
    }

    public void setPhotos(List<PhotoEntity> photos) {
        this.photos = photos;
    }

    public List<AuctionParameterEntity> getParameters() {
        return parameters;
    }

    public void setParameters(List<AuctionParameterEntity> parameters) {
        this.parameters = parameters;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public AddAuctionRequest(CategoryEntity category, String title, String description, List<PhotoEntity> photos, List<AuctionParameterEntity> parameters, BigDecimal price, Long ownerId) {
        this.category = category;
        this.title = title;
        this.description = description;
        this.photos = photos;
        this.parameters = parameters;
        this.price = price;
        this.ownerId = ownerId;
    }

    public AddAuctionRequest() {
    }
}
