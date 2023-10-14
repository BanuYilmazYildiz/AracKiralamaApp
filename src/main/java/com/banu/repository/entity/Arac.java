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
@Table(name = "tbl_arac")
public class Arac {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String marka;

    private String model;

    @Builder.Default
    private Boolean durum=true;

   // @OneToMany(mappedBy = "arac",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
   // List<Kiralama> kiralamaList;

    @Embedded
    private BaseEntity baseEntity;

    @Override
    public String toString(){
        return "id = "+id +", Marka = "+marka+ ", Model = "+model;
    }

}
