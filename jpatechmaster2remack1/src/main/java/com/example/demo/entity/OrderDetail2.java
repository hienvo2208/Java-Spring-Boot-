package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="order_detail2")
public class OrderDetail2 {
    @EmbeddedId
    private OrderDetailId2 orderDetailId2;
    @Column(name="quantity", nullable = false)
    private int quantity;
    @Column(name ="price", nullable = false)
    private float price;

    @Column(name ="amount", nullable = false)
    private float amount;


}
