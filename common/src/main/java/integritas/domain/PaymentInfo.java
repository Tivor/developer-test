package integritas.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by polia on 03/12/2017.
 */
@Entity
@Table(name="payment")
public class PaymentInfo implements Serializable {

    @Id
    @GeneratedValue
    @Column(name="id")
    private Integer id;

    @Column(name="number")
    private String number;

    @Column(name="name")
    private String name;

    @Column(name="expiration")
    private String expiration;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExpiration() {
        return expiration;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }
}
