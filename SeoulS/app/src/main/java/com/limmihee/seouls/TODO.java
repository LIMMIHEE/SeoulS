package com.limmihee.seouls;

public class TODO {
    private String name;
    private  String info;
    private  int time;


    public TODO(String name, String info, int time) {
        this.name = name;
        this.info = info;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
