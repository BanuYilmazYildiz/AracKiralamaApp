package com.banu.controller;

import com.banu.repository.entity.Arac;
import com.banu.repository.entity.Kiralama;
import com.banu.repository.entity.Kisi;
import com.banu.service.KiralamaService;
import com.banu.utility.Constants;
import com.banu.utility.UtilityClass;

import java.time.LocalDate;
import java.util.List;

public class KiralamaController {

    KiralamaService kiralamaService;
    AracController aracController;

    public KiralamaController(){
       this.kiralamaService=new KiralamaService();
       this.aracController=new AracController();
    }

    public List<Kiralama> findAll() {
        return kiralamaService.findALl();
    }

    public Kiralama save(Kiralama kiralama) {
        return kiralamaService.save(kiralama);
    }

    public Kiralama kiralamaYap(Kisi kisi){
        aracController.kiralamaYapilabilecekAraclar().forEach(System.out::println);
        kiralamaService.findALl().forEach(kiralama->{
            if (kiralama.getBitisTarihi().isBefore(LocalDate.now())){
                kiralama.getArac().setDurum(true);
                aracController.update(kiralama.getArac());
            }
        });
        Long id = UtilityClass.longDeger("id giriniz = ");
        Arac arac = aracController.findById(id).get();
        System.out.println("Başlangıç tarihi için;");
        int yil = UtilityClass.intDeger("Yıl : ");
        int ay = UtilityClass.intDeger("Ay : ");
        int gun = UtilityClass.intDeger("Gun : ");
        LocalDate baslangicTarihi = LocalDate.of(yil,ay,gun);
        System.out.println("Bitiş tarihi için;");
        int byil = UtilityClass.intDeger("Yıl : ");
        int bay = UtilityClass.intDeger("Ay : ");
        int bgun = UtilityClass.intDeger("Gun : ");
        LocalDate bitisTarihi = LocalDate.of(byil,bay,bgun);
        Kiralama kiralama = Kiralama.builder()
                .arac(arac)
                .kisi(kisi)
                .baslangicTarihi(baslangicTarihi)
                .bitisTarihi(bitisTarihi)
                .baseEntity(Constants.getBaseEntity())
                .build();
        arac.setDurum(false);
        if (LocalDate.now().isAfter(kiralama.getBitisTarihi())){
            arac.setDurum(true);
        }
        aracController.update(arac);
        return kiralamaService.save(kiralama);


    }
}
