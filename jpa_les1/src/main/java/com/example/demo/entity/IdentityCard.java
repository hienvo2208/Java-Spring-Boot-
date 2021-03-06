package com.example.demo.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name="identity_card")
public class IdentityCard implements Serializable {
    @Id
    private String id;

    @Column(name="expired")
    private Date expired;

    @Column(name="issued")
    private Date issued;
}
