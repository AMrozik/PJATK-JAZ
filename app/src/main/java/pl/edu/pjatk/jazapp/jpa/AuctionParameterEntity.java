package pl.edu.pjatk.jazapp.jpa;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "auction_parameter")
public class AuctionParameterEntity implements Serializable {
    private static final long serialVersion = 1L;

    @EmbeddedId
    private AuctionParameterId auctionParameterId = new AuctionParameterId();

    @MapsId("auctionId")
    @ManyToOne(optional = false)
    @JoinColumn(name = "auction_id")
    private AuctionEntity auction;

    @MapsId("parameterId")
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "parameter_id")
    private ParameterEntity parameter;

    private String value;

    public static long getSerialVersion() {
        return serialVersion;
    }

    public AuctionEntity getAuction() {
        return auction;
    }

    public void setAuction(AuctionEntity auction) {
        this.auction = auction;
    }

    public ParameterEntity getParameter() {
        return parameter;
    }

    public void setParameter(ParameterEntity parameter) {
        this.parameter = parameter;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public AuctionParameterId getAuctionParameterId() {
        return auctionParameterId;
    }

    public void setAuctionParameterId(AuctionParameterId auctionParameterId) {
        this.auctionParameterId = auctionParameterId;
    }

    public AuctionParameterEntity(ParameterEntity parameter, String value) {
        this.parameter = parameter;
        this.value = value;
    }

    public AuctionParameterEntity() {
    }
}
