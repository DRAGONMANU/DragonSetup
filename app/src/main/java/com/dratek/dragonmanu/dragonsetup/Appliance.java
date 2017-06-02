package com.dratek.dragonmanu.dragonsetup;

import android.widget.Switch;

public class Appliance {
    private String relayId;
    private String name;
    private String rating;
    private String action;

    public String getAction() {
        return action;
    }

    public String getRating() {
        return rating;
    }

    public String getName() {

        return name;
    }

    public String getRelayId() {

        return relayId;
    }

    public Appliance(String relayId, String name, String rating, String action) {
        this.relayId = relayId;
        this.name = name;
        this.rating = rating;
        this.action = action;
    }

    public void setRelayId(String relayId) {
        this.relayId = relayId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public void setAction(String action) {
        this.action = action;
    }

    @Override
    public String toString(){
        return name;
    }


}
