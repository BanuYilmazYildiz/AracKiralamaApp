package com.banu.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "tbl_kiralama")
public class Kiralama {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private LocalDate baslangicTarihi;
    private LocalDate bitisTarihi;

    @Embedded
    private BaseEntity baseEntity;

    @ManyToOne
    Arac arac;

    @ManyToOne
    Kisi kisi;

  //  @Override
    //public String toString(){
   //     return "id = "+id +", baslangicTarihi = "+baslangicTarihi+ ", bitisTarihi = "+bitisTarihi;
    //}
}
