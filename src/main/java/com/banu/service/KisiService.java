package com.banu.service;

import com.banu.repository.KisiRepository;
import com.banu.repository.entity.Kisi;
import com.banu.utility.MyFactorySevice;

import java.util.Optional;

public class KisiService extends MyFactorySevice<KisiRepository, Kisi,Long> {

    KisiRepository kisiRepository;
    public KisiService(){
        super(new KisiRepository());
        this.kisiRepository=new KisiRepository();
    }


    public Optional<Kisi> findByUserName(String username) {
        return kisiRepository.findByUserName(username);
    }
}
