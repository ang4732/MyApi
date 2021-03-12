package com.gerardotataje.MyApi.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;

@Entity
@Table(name = "DetallesPedido")
@Getter
@Setter
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDetallePedido")
    private Long id;
    @Column(name = "precio")
    private BigDecimal unitPrice;
    @Column(name = "cantidad")
    private int quantity;
    @Column(name = "imageUrl")
    private String imageUrl;
    @Column(name = "idProducto")
    private int productId;
    @ManyToOne
    @JoinColumn(name = "idPedido")
    private Order order;
}
