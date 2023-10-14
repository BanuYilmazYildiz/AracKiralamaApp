package com.banu.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "tbl_kisi")
public class Kisi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;
    private String surname;
    private String username;
    private String password;
    @Embedded
    private BaseEntity baseEntity;

    @OneToMany(mappedBy = "kisi")
    List<Kiralama> kiralamalar;

    @Override
    public String toString(){
        return "id = "+id +", Name = "+name+ ", Username = "+username;
    }
}
