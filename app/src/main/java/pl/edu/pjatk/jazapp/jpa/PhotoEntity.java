package pl.edu.pjatk.jazapp.jpa;

import javax.persistence.*;

@Entity
@Table(name = "photo")
public class PhotoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "auction_id")
    private AuctionEntity auction;

    private String url;

    private int order_by;

    public int getOrder_by() {
        return order_by;
    }

    public void setOrder_by(int order_by) {
        this.order_by = order_by;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AuctionEntity getAuction() {
        return auction;
    }

    public void setAuction(AuctionEntity auction) {
        this.auction = auction;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public PhotoEntity() {
    }

    public PhotoEntity(String url) {
        this.url = url;
    }
}
