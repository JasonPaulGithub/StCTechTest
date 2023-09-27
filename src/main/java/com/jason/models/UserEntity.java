package com.jason.models;

import com.jason.encryption.Encrypt;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
//@Table(name="user")
public class UserEntity {

    @Id
    @SequenceGenerator(
            name = "user_id_sequence",
            sequenceName = "user_id_sequence",
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_id_sequence"
    )

    @Setter
    @Getter
    private int id;

    @Setter
    @Getter
    @Convert(converter = Encrypt.class)
    private String name;

    @Setter
    @Getter
    @Convert(converter = Encrypt.class)
    private String email;

    public UserEntity(String name, String email) {
        this.name = name;
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }


}