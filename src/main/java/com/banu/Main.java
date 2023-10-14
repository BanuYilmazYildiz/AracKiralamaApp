package com.banu;

import com.banu.controller.AracController;
import com.banu.controller.KiralamaController;
import com.banu.controller.KisiController;
import com.banu.repository.KisiRepository;
import com.banu.repository.entity.Arac;
import com.banu.repository.entity.Kiralama;
import com.banu.repository.entity.Kisi;
import com.banu.utility.Constants;
import com.banu.utility.UtilityClass;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    AracController aracController;

    KisiController kisiController;
    KiralamaController kiralamaController;

    public Main(){
        this.aracController=new AracController();
        this.kisiController=new KisiController();
        this.kiralamaController=new KiralamaController();
    }
    public static void main(String[] args) {

        Main main = new Main();
    main.uygulama();



    }
    
    public void uygulama(){
        boolean cikis=false;
        do {
            menu();
            int secim = UtilityClass.intDeger("Lutfen secim yapiniz = ");
            switch (secim) {
                case 1: {
                    kisiController.kisiEkle();
                }
                break;
                case 2: {
                    girisYap();
                }
                break;
                case 0: {
                    cikis=true;
                }
                break;
            }
        }while (!cikis);
    }

    public void girisYap(){
        String username;
        String password;
        Boolean dataIntegrity = false;
        Optional<Kisi> kisi = null;
        List<String> usernameList = kisiController.findAll().stream().map(k -> k.getUsername()).collect(Collectors.toList());
        do {
            username=UtilityClass.stringDeger("Username = ");
            if(usernameList.contains(username)){
                kisi = kisiController.findByUserName(username);
                do {
                    password = UtilityClass.stringDeger("Sifre : ");
                    if (kisi.get().getPassword().equals(password)){
                        dataIntegrity = true;
                        registerMenu(kisi.get());
                    } else {
                        System.out.println("Yanlis sifre girdiniz");
                        dataIntegrity = false;
                    }
                }while (!dataIntegrity);
            } else{
                System.out.println("Kullanıcı adınız hatalı");
                dataIntegrity = false;
            }

        }while(!dataIntegrity);
    }

    private void registerMenu(Kisi kisi) {
            boolean control = true;
            do {
                registerMenuGorunum();
                int secim = UtilityClass.intDeger("Lutfen secim yapiniz : ");
                switch (secim){
                    case 1: {
                        aracController.aracEkle();
                    }break;
                    case 2: {
                       aracController.markayaGoreAracAra().forEach(System.out::println);
                    }break;
                    case 3:{
                        kiralamaController.kiralamaYap(kisi);
                    }break;
                    case 4:{
                        aracController.kiralamaYapilabilecekAraclar().forEach(System.out::println);
                    }break;
                    case 5:{
                        aracController.musteriyeGoreKiraladagiAraclar().forEach(System.out::println);
                    }break;
                    case 0: {
                        control=false;
                        break;
                    }
                }
            }while (control);
    }

    private void registerMenuGorunum() {
        System.out.println("************************************");
        System.out.println("***   Arac Kiralama Uygulaması   ***");
        System.out.println("************************************");
        System.out.println("1- Arac Ekle");
        System.out.println("2- Arac Ara");
        System.out.println("3- Kiralama Yap");
        System.out.println("4- Boşta Olan Araçlar");
        System.out.println("5- Herhangi bir müşterinin kiralandığı araçlar");
        System.out.println("0- Çıkış Yap");
        System.out.println();
    }

    public void menu(){
        System.out.println("************************************");
        System.out.println("***   Arac Kiralama Uygulaması   ***");
        System.out.println("************************************");
        System.out.println("1- Kayıt Ol");
        System.out.println("2- Giris Yap");
        System.out.println("0- Çıkış Yap");
        System.out.println();
    }

}