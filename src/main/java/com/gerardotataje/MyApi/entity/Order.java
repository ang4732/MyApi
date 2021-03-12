package com.gerardotataje.MyApi.entity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Pedidos")
@Getter
@Setter
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPedido")
    private Long id;
    @Column(name = "numeroTracking")
    private String trackingNumber;
    @Column(name = "totalCantidad")
    private int totalQuantity;
    @Column(name = "totalPrecio")
    private BigDecimal totalPrice;
    @CreationTimestamp
    @Column(name = "fechaCreacion")
    private Date dateCreated;
    @UpdateTimestamp
    @Column(name = "fechaActualizacion")
    private Date lastUpdated;
    @ManyToOne
    @JoinColumn(name = "idCliente")
    private Customer customer;
    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL)
    private Set<OrderItem> orderItems;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "direccionFacturacion",referencedColumnName = "idDireccion")
    private Address billingAddress;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "direccionEnvio",referencedColumnName = "idDireccion")
    private Address shippingAddress;
    public void addOrdenItem(OrderItem item){
        if (orderItems==null){
            orderItems= new HashSet<>();
        }
        orderItems.add(item);
        item.setOrder(this);
    }
}
