package com.banu.service;

import com.banu.repository.AracRepository;
import com.banu.repository.entity.Arac;
import com.banu.utility.MyFactorySevice;

import java.util.List;

public class AracService extends MyFactorySevice<AracRepository, Arac,Long> {
    AracRepository aracRepository;
    public AracService(){
        super(new AracRepository());
        this.aracRepository=new AracRepository();
    }

    public List<Arac> kiralamaYapilabilecekAraclar() {
        return aracRepository.kiralamaYapilabilecekAraclar();
    }

    public List<Arac> musteriyeGoreKiraladagiAraclar(Long id) {
        return aracRepository.musteriyeGoreKiraladagiAraclar(id);
    }
}
