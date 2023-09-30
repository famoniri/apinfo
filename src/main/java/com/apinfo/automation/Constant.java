package com.apinfo.automation;

import java.util.HashMap;

public final class Constant {

    final static String DOMESTIC_ARRIVALS = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/button[1]";
    final static String DOMESTIC_DEPARTURES = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/button[2]";
    final static String INTERNATIONAL_ARRIVALS = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/button[3]";
    final static String INTERNATIONAL_DEPARTURES ="/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/button[4]";

    final static HashMap<String, String> DAY_EN     = new HashMap<String, String>();
    final static HashMap<String, String> AIRLINE = new HashMap<String, String>();
    final static HashMap<String, String> AIRPORT = new HashMap<String, String>();
    final static HashMap<String, String> STATUS = new HashMap<String, String>();


    public static void init(){
        System.out.println("init constant .... ");
        DAY_EN.put("شنبه", "sat");
        DAY_EN.put("یکشنبه", "sun");
        DAY_EN.put("دوشنبه", "mon");
        DAY_EN.put("سه شنبه", "tue");
        DAY_EN.put("چهارشنبه", "wed");
        DAY_EN.put("پنجشنبه", "thu");
        DAY_EN.put("جمعه", "Fri");

        STATUS.put("نشست | پایان دریافت بار", "{\"STATUS\":\"LANDED - FINISHED BAGGAGE DELIVERY \",\"STATUS_FA\":\"نشست | پایان دریافت بار\"}");
        STATUS.put("نشست | دریافت بار از نقاله", "{\"STATUS\":\"LANDED - BAGGAGE DELIVERY\",\"STATUS_FA\":\"نشست | دریافت بار از نقاله\"}");
        STATUS.put("منتظر اعلام باشید", "{\"STATUS\":\"EXPECTED\",\"STATUS_FA\":\"منتظر اعلام باشید\"}");
        STATUS.put("طبق برنامه", "{\"STATUS\":\"ON-TIME\",\"STATUS_FA\":\"طبق برنامه\"}");
        STATUS.put("تاخیر", "{\"STATUS\":\"DELAYED\",\"STATUS_FA\":\"تاخیر\"}");
        STATUS.put("لغو", "{\"STATUS\":\"CANCELED\",\"STATUS_FA\":\"لغو\"}");

        //AIRLINE.put("ایران ایر", "{\"IATA\":\"IR\",\"ICAO\":\"IRA\",\"AIRLINE\":\"Iran Air\",\"CALLSSIGN\":\"IRANAIR\",\"HUB\":\"Tehran\",\"FA\":\"ایران ایر\"}");
        //AIRLINE.put("قشم ایر",   "{\"IATA\":\"QB\",\"ICAO\":\"IRQ\",\"AIRLINE\":\"Qeshm Airlines\",\"CALLSSIGN\":\"QESHM AIR\",\"HUB\":\"Qeshm Island'\",\"FA\":\"قشم ایر\"}");
        AIRLINE.put("ایران ایر","{\"IATA\":\"IR\",\"ICAO\":\"IRA\",\"CALLSSIGN\":\"IRANAIR\",\"AIRLINE\":\"Iran Air\",\"HUB\":\"Tehran- Tehran IKA\",\"FA\":\"ایران ایر\"}");
        AIRLINE.put("ایران ایرتور","{\"IATA\":\"B9\",\"ICAO\":\"IRB\",\"CALLSSIGN\":\"AIRTOUR\",\"AIRLINE\":\"Iran Air Tours\",\"HUB\":\"Mashhad- Tabriz\",\"FA\":\"ایران ایرتور\"}");
        AIRLINE.put("آسمان","{\"IATA\":\"EP\",\"ICAO\":\"IRC\",\"CALLSSIGN\":\"ASEMAN\",\"AIRLINE\":\"Iran Aseman Airlines\",\"HUB\":\"Tehran- Tehran IKA\",\"FA\":\"آسمان\"}");
        AIRLINE.put("زاگرس","{\"IATA\":\"ZV\",\"ICAO\":\"IZG\",\"CALLSSIGN\":\"ZAGROS\",\"AIRLINE\":\"Zagros Airlines\",\"HUB\":\"Abadan\",\"FA\":\"زاگرس\"}");
        AIRLINE.put("کیش ایر","{\"IATA\":\"Y9\",\"ICAO\":\"IRK\",\"CALLSSIGN\":\"KISHAIR\",\"AIRLINE\":\"Kish Air\",\"HUB\":\"Kish Island\",\"FA\":\"کیش ایر\"}");
        AIRLINE.put("قشم ایر","{\"IATA\":\"QB\",\"ICAO\":\"IRQ\",\"CALLSSIGN\":\"QESHM AIR\",\"AIRLINE\":\"Qeshm Airlines\",\"HUB\":\"Qeshm Island\",\"FA\":\"قشم ایر\"}");
        AIRLINE.put("ماهان","{\"IATA\":\"W5\",\"ICAO\":\"IRM\",\"CALLSSIGN\":\"MAHAN AIR\",\"AIRLINE\":\"Mahan Air\",\"HUB\":\"Kerman\",\"FA\":\"ماهان\"}");
        AIRLINE.put("آتا","{\"IATA\":\"I3\",\"ICAO\":\"TBZ\",\"CALLSSIGN\":\"ATAAIR\",\"AIRLINE\":\"ATA Airlines\",\"HUB\":\"Tabriz\",\"FA\":\"آتا\"}");
        AIRLINE.put("معراج","{\"IATA\":\"JI\",\"ICAO\":\"MRJ\",\"CALLSSIGN\":\"MERAJ\",\"AIRLINE\":\"Meraj Airlines\",\"HUB\":\"Tehran IKA\",\"FA\":\"معراج\"}");
        AIRLINE.put("تابان","{\"IATA\":\"HH\",\"ICAO\":\"TBM\",\"CALLSSIGN\":\"TABAN AIR\",\"AIRLINE\":\"Taban Air\",\"HUB\":\"Mashhad\",\"FA\":\"تابان\"}");
        AIRLINE.put("کاسپین","{\"IATA\":\"RV\",\"ICAO\":\"CPN\",\"CALLSSIGN\":\"CASPIAN\",\"AIRLINE\":\"Caspian Airlines\",\"HUB\":\"Tehran IKA\",\"FA\":\"کاسپین\"}");
        AIRLINE.put("کارون","{\"IATA\":\"NV\",\"ICAO\":\"IRG\",\"CALLSSIGN\":\"NAFT\",\"AIRLINE\":\"Karun Airlines\",\"HUB\":\"Ahvaz\",\"FA\":\"کارون\"}");
        AIRLINE.put("سپهران","{\"IATA\":\"IS\",\"ICAO\":\"SHI\",\"CALLSSIGN\":\"SHIRAZI\",\"AIRLINE\":\"Sepehran Airlines\",\"HUB\":\"Shiraz\",\"FA\":\"سپهران\"}");
        AIRLINE.put("وارش","{\"IATA\":\"VR\",\"ICAO\":\"VRH\",\"CALLSSIGN\":\"VARESH\",\"AIRLINE\":\"Varesh Air\",\"HUB\":\"Sari\",\"FA\":\"وارش\"}");
        AIRLINE.put("فلای پرشیا","{\"IATA\":\"FP\",\"ICAO\":\"FPI\",\"CALLSSIGN\":\"FLYPERSIA\",\"AIRLINE\":\"FlyPersia\",\"HUB\":\"Shiraz\",\"FA\":\"فلای پرشیا\"}");
        AIRLINE.put("پارس ایر","{\"IATA\":\"PR\",\"ICAO\":\"PRS\",\"CALLSSIGN\":\"PARS AIR\",\"AIRLINE\":\"Pars Air\",\"HUB\":\"Shiraz\",\"FA\":\"پارس ایر\"}");
        AIRLINE.put("فارس ایر قشم","{\"IATA\":\"--\",\"ICAO\":\"QFZ\",\"CALLSSIGN\":\"FARSAIR\",\"AIRLINE\":\"Fars Air Qeshm\",\"HUB\":\"Tehran-Imam Khomeini\",\"FA\":\"فارس ایر قشم\"}");
        AIRLINE.put("پیام","{\"IATA\":\"2F\",\"ICAO\":\"IRP\",\"CALLSSIGN\":\"PAYAMAIR\",\"AIRLINE\":\"Payam Air\",\"HUB\":\"Karaj-Payam\",\"FA\":\"پیام\"}");
        AIRLINE.put("پويا","{\"IATA\":\"PY\",\"ICAO\":\"PYA\",\"CALLSSIGN\":\"POUYA\",\"AIRLINE\":\"Pouya Cargo Air\",\"HUB\":\"Tehran-Mehrabad\",\"FA\":\"ایران ایر\"}");
        AIRLINE.put("ساها","{\"IATA\":\"--\",\"ICAO\":\"IRZ\",\"CALLSSIGN\":\"SAHA\",\"AIRLINE\":\"Saha Airlines\",\"HUB\":\"Tehran-Mehrabad\",\"FA\":\"ساها\"}");


        AIRPORT.put("تهران", "{\"IATA\":\"THR\",\"ICAO\":\"OIII\",\"NAME\":\"Mehrabad International Airport\",\"CITY\":\"Tehran\",\"CITY_FA\":\"تهران\"}");
        AIRPORT.put("اصفهان", "{\"IATA\":\"IFN\",\"ICAO\":\"OIFM\",\"NAME\":\"Isfahan International Airport\",\"CITY\":\"Isfahan\",\"CITY_FA\":\"اصفهان\"}");

    }
}

