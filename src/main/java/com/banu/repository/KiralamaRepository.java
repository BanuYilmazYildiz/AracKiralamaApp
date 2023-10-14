package com.banu.repository;

import com.banu.repository.entity.Kiralama;
import com.banu.utility.MyFactoryRepository;

public class KiralamaRepository extends MyFactoryRepository<Kiralama,Long> {

    public KiralamaRepository(){
        super(new Kiralama());
    }
}
