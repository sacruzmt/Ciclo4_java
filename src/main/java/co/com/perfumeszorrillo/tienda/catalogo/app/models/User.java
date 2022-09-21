package co.com.perfumeszorrillo.tienda.catalogo.app.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customUser")
public class User {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "email", unique = true, nullable = false)
    @Size(min=5, max=50)
    private String email;

    @Column(name = "password", nullable = false)
    @Size(min=5, max=50)
    private String password;

    @Column(name = "name", nullable = false)
    @Size(min=5, max=50)
    private String name;


}
