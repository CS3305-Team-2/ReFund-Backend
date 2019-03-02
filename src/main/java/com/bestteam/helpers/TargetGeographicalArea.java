package com.bestteam.helpers;

public enum TargetGeographicalArea {
    LOCAL("Local (a specific county in Ireland)"),
    NATIONAL("National"),
    INTERNATIONAL("International");

    private String content;

    TargetGeographicalArea(String content){
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
