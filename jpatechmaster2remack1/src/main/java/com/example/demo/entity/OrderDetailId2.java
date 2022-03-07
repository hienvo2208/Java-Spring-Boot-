package com.example.demo.entity;

import lombok.*;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Embeddable
@Table(name ="order_detail2")
public class OrderDetailId2 implements Serializable {
   private int oderId;
   private int productId;
}
