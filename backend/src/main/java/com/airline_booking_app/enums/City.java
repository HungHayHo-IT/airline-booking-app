package com.airline_booking_app.enums;

import lombok.Getter;

@Getter
public enum City {

    // ===================== Việt Nam =====================
    HA_NOI(Country.VIETNAM),
    HO_CHI_MINH(Country.VIETNAM),
    DA_NANG(Country.VIETNAM),
    HAI_PHONG(Country.VIETNAM),
    CAN_THO(Country.VIETNAM),
    HUE(Country.VIETNAM),

    // ===================== Nigeria =====================
    LAGOS(Country.NIGERIA),
    ABUJA(Country.NIGERIA),
    KANO(Country.NIGERIA),
    IBADAN(Country.NIGERIA),

    // ===================== USA =====================
    NEW_YORK(Country.USA),
    LOS_ANGELES(Country.USA),
    CHICAGO(Country.USA),
    MIAMI(Country.USA),
    DALLAS(Country.USA),
    SAN_FRANCISCO(Country.USA),

    // ===================== UK =====================
    LONDON(Country.UK),
    MANCHESTER(Country.UK),
    BIRMINGHAM(Country.UK),
    LEEDS(Country.UK),
    EDINBURGH(Country.UK),

    // ===================== Nhật Bản =====================
    TOKYO(Country.JAPAN),
    OSAKA(Country.JAPAN),
    KYOTO(Country.JAPAN),
    NAGOYA(Country.JAPAN),
    YOKOHAMA(Country.JAPAN),
    SAPPORO(Country.JAPAN),

    // ===================== Hàn Quốc =====================
    SEOUL(Country.KOREA),
    BUSAN(Country.KOREA),
    INCHEON(Country.KOREA),
    DAEGU(Country.KOREA),
    DAEJEON(Country.KOREA),

    // ===================== Trung Quốc =====================
    BEIJING(Country.CHINA),
    SHANGHAI(Country.CHINA),
    GUANGZHOU(Country.CHINA),
    SHENZHEN(Country.CHINA),
    HONG_KONG(Country.CHINA),
    CHENGDU(Country.CHINA);


    private final Country country;

    City(Country country) {
        this.country = country;
    }
}
