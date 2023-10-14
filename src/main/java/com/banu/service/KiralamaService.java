package com.banu.service;

import com.banu.repository.KiralamaRepository;
import com.banu.repository.entity.Kiralama;
import com.banu.utility.MyFactorySevice;

public class KiralamaService extends MyFactorySevice<KiralamaRepository, Kiralama,Long> {

    public KiralamaService(){
        super(new KiralamaRepository());
    }
}
