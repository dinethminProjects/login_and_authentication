package com.ooad.group12.bedstore.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.Hibernate;

import java.util.Objects;

@Getter
@Setter
@ToString
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "BEDSTORE_USER")
@SequenceGenerator(name = "BEDSTORE_USER_SEQ_GENERATOR", sequenceName = "ID_SEQ_BEDSTORE_USER", allocationSize = 1)
public class User extends MBaseEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BEDSTORE_USER_SEQ_GENERATOR")
    private Long id;

    @Column(name = "FULL_NAME" ,nullable = false,length = 100)
    private String fullName;

    @Column(name = "ADDRESS" ,nullable = false)
    private String address;

    @Column(name = "EMAIL" ,nullable = false,length = 50,unique = true)
    private String email;

    @Column(name = "PASSWORD" ,nullable = false)
    private String password;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        User module = (User) o;
        return getId() != null && Objects.equals(getId(), module.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
