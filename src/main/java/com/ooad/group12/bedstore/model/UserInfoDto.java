package com.ooad.group12.bedstore.model;

import com.ooad.group12.bedstore.entity.MBaseEntity;
import com.ooad.group12.bedstore.entity.User;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.Hibernate;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;

import java.util.Objects;

@Getter
@Setter
@ToString
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoDto{

    private Long id;

    private String fullName;

    private String email;

    private String address;

    public UserInfoDto(User user) {
        BeanUtils.copyProperties(user, this);
    }
}
