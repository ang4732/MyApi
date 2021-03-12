package com.gerardotataje.MyApi.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Categorias")
@Getter
@Setter
public class Category {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Column(name = "idCategoria")
    private Long id;

    @Column(name = "nombreCategoria")
    private String name;

    @OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
    Set<Product> products;
}
