package com.banu.controller;

import com.banu.repository.entity.Kisi;
import com.banu.service.KisiService;
import com.banu.utility.Constants;
import com.banu.utility.UtilityClass;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class KisiController {
    KisiService kisiService;

    public KisiController(){
        this.kisiService=new KisiService();
    }

    public Kisi save(Kisi kisi) {
        return kisiService.save(kisi);
    }


    public List<Kisi> findAll() {
        return (List<Kisi>) kisiService.findALl();
    }

    public Optional<Kisi> findByUserName(String username) {
        return kisiService.findByUserName(username);
    }

    public List<Kisi> findByName(String isim) {
        return kisiService.findByColumnNameAndValue("name",isim);
    }

    public Kisi kisiEkle(){
        String name = UtilityClass.stringDeger("İsim = ");
        String surname = UtilityClass.stringDeger("Soyisim = ");
        String username = UtilityClass.stringDeger("Kullanıcı adı = ");
        String password = UtilityClass.stringDeger("Şifre = ");
        Kisi kisi = Kisi.builder()
                .name(name)
                .surname(surname)
                .username(username)
                .password(password)
                .baseEntity(Constants.getBaseEntity())
                .build();
        return save(kisi);
    }


}
