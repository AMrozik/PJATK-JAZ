package pl.edu.pjatk.jazapp.jpa;

import pl.edu.pjatk.jazapp.auth.ProfileEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "auction")
public class AuctionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private CategoryEntity category;

    private String title;
    private String description;

    @OneToMany(cascade = CascadeType.PERSIST, orphanRemoval = true, mappedBy = "auction", fetch = FetchType.EAGER)
    @OrderColumn(name = "order_by") // order by w photos
    private List<PhotoEntity> photos;

    @OneToMany(cascade = CascadeType.PERSIST, orphanRemoval = true, mappedBy = "auction")
    private List<AuctionParameterEntity> parameters;

    private BigDecimal price;

    @Column(name = "owner_id")
    private Long ownerId;

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

    public AuctionEntity(CategoryEntity category, String title, String description, List<PhotoEntity> photos, List<AuctionParameterEntity> parameters, BigDecimal price, Long ownerId) {
        this.category = category;
        this.title = title;
        this.description = description;
        this.photos = photos;
        this.parameters = parameters;
        this.price = price;
        this.ownerId = ownerId;
    }

    public AuctionEntity() {
    }
}
