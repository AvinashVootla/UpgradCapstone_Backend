package com.upgrad.FoodOrderingApp.service.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/*
 * This Entity class represents the "payment" table in DB
 * */
@Entity
@Table(name = "payment")


/*
 * NamedQuery to retrieve payment object from DB
 * */

@NamedQueries({
        @NamedQuery(name = "getAllPaymentMethods", query = "SELECT p FROM PaymentEntity p"),
        @NamedQuery(name = "getPaymentByUUID",query = "SELECT p FROM PaymentEntity p WHERE p.uuid = :uuid")
})

public class PaymentEntity implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "uuid")
    @Size(max = 200)
    @NotNull
    private String uuid;

    @Column(name = "payment_name")
    @Size(max = 255)
    private String paymentName;

    //    constructors for test case
    public PaymentEntity(){

    }

    public PaymentEntity(String uuid, String paymentName) {
        this.uuid = uuid;
        this.paymentName = paymentName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getPaymentName() {
        return paymentName;
    }

    public void setPaymentName(String paymentName) {
        this.paymentName = paymentName;
    }
}
