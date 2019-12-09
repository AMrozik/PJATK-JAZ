package pl.edu.pjatk.jazapp.jpa;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "auction_parameter")
public class AuctionParameterEntity implements Serializable {
    private static final long serialVersion = 1L;

    // embedded id
    @Id
    @ManyToOne(optional = false)
    @JoinColumn(name = "auction_id")
    private AuctionEntity auction;

    @Id
    @ManyToOne(optional = false)
    @JoinColumn(name = "parameter_id")
    private ParameterEntity parameter;

    private String value;
}
