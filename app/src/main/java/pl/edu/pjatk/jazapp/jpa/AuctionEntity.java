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

    @OneToMany(cascade = CascadeType.PERSIST, orphanRemoval = true, mappedBy = "auction")
    @OrderColumn(name = "order_by")
    private List<PhotoEntity> photos;

    @OneToMany(cascade = CascadeType.PERSIST, orphanRemoval = true, mappedBy = "auction")
    private List<AuctionParameterEntity> parameters;

    private BigDecimal price;

    @Column(name = "owner_id")
    private Long ownerId;
}
