package com.banu.repository;

import com.banu.repository.entity.Kisi;
import com.banu.utility.HibernateUtility;
import com.banu.utility.MyFactoryRepository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

public class KisiRepository extends MyFactoryRepository<Kisi,Long> {

    EntityManager entityManager;
    public KisiRepository(){
        super(new Kisi());
        this.entityManager= HibernateUtility.getSessionFactory().createEntityManager();
    }


    public Optional<Kisi> findByUserName(String username) {
        String sql = "SELECT * FROM tbl_kisi as k WHERE k.username=:username";
        Query query = entityManager.createNativeQuery(sql,Kisi.class);
        query.setParameter("username",username);
        List<Kisi> kisiList = query.getResultList();
        Optional<Kisi> kisi = Optional.ofNullable(kisiList.get(0));
        return kisi;
    }
}
