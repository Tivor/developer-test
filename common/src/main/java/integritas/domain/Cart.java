package integritas.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by polia on 03/12/2017.
 */
@Entity
@Table(name="cart")
public class Cart implements Serializable {

    @Id
    @GeneratedValue
    @Column(name="id")
    private Integer id;

    @Column(name="idProd")
    private Integer idProd;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdProd() {
        return idProd;
    }

    public void setIdProd(Integer idProd) {
        this.idProd = idProd;
    }
}
