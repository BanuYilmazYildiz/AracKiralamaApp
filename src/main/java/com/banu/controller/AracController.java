package com.banu.controller;

import com.banu.repository.entity.Arac;
import com.banu.service.AracService;
import com.banu.utility.Constants;
import com.banu.utility.UtilityClass;

import java.util.List;
import java.util.Optional;

public class AracController {

    AracService aracService;
    KisiController kisiController;

    public AracController(){
        this.aracService=new AracService();
        this.kisiController=new KisiController();
    }

    public Arac save(Arac arac) {
        return aracService.save(arac);
    }

    public List<Arac> findByColumnNameAndValue(String columnname,String value){
        return aracService.findByColumnNameAndValue(columnname,value);
    }

    public List<Arac> findAll() {
        return aracService.findALl();
    }

    public List<Arac> kiralamaYapilabilecekAraclar() {
        return aracService.kiralamaYapilabilecekAraclar();
    }

    public Optional<Arac> findById(Long id) {
        return aracService.finById(id);
    }

    public void update(Arac arac) {
        aracService.update(arac);
    }


    public List<Arac> musteriyeGoreKiraladagiAraclar() {
        String isim = UtilityClass.stringDeger("Kisi adı giriniz : ");
        kisiController.findByName(isim).forEach(System.out::println);
        Long id = UtilityClass.longDeger("Kişi idsi seçiniz : ");
        return aracService.musteriyeGoreKiraladagiAraclar(id);
    }



    public Arac aracEkle(){
        String marka = UtilityClass.stringDeger("Marka = ");
        String model = UtilityClass.stringDeger("Model = ");

        Arac arac = Arac.builder()
                .marka(marka)
                .model(model)
                .baseEntity(Constants.getBaseEntity())
                .build();
        return save(arac);
    }

    public List<Arac> markayaGoreAracAra(){
        String marka=UtilityClass.stringDeger("Aramak istediğiniz marka = ");
        return aracService.findByColumnNameAndValue("marka",marka);
    }
}
