package com.bestteam.helpers;

public enum NRPArea {
    PRIORITY_AREA_A("Future Network and Communications"),
    PRIORITY_AREA_B("Data Analytics, Management, Security and Privacy"),
    PRIORITY_AREA_C("Digital Platforms, Content and Applications"),
    PRIORITY_AREA_D("Connected Health and Independant Living"),
    PRIORITY_AREA_E("Medical Devices"),
    PRIORITY_AREA_F("Diagnostics"),
    PRIORITY_AREA_G("Therapeutics: Synthesis, Formulation, Processing and Drug Delivery"),
    PRIORITY_AREA_H("Food for Health"),
    PRIORITY_AREA_I("Sustainable Food Production and Processing"),
    PRIORITY_AREA_J("Marine Renewable Energy"),
    PRIORITY_AREA_K("Smarth Girds and Smart Cities"),
    PRIORITY_AREA_L("Manufacturing Competitiveness"),
    PRIORITY_AREA_M("Processing Technologies and Novel Materials"),
    PRIORITY_AREA_N("Innovation in Services and Business Processes"),
    SOFTWARE("Software"),
    OTHER("Other");

    private String content;

    NRPArea(String content){
        this.content = content;
    }

    public String getContent(){
        return content;
    }

    @Override
    public String toString(){
        return content;
    }
}
