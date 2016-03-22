package ru.easyjava.data.jpa.hibernate.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ru.easyjava.data.jpa.hibernate.entity.keys.CustomerKey;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * Customer definition.
 */
@SuppressWarnings("PMD")
@ToString
@Entity
@Table(name = "customers")
@IdClass(CustomerKey.class)
public class Customer {

    /**
     * Customer's passport series value.
     */
    @Id
    @Getter
    @Setter
    private String passportSeries;

    /**
     * Customer's passport number value.
     */
    @Id
    @Getter
    @Setter
    private String passportSNo;

    /**
     * Customer name.
     */
    @Getter
    @Setter
    private String name;
}
