package com.dratek.dragonmanu.dragonsetup;

import java.util.ArrayList;

public class SwitchBoard {
    private String houseId = "null";
    private String roomName = "null";
    private String boardID = "null";
    private ArrayList<Appliance> attachedAppliances = new ArrayList<>();

    public String getHouseId() {
        return houseId;
    }

    public String getRoomName() {
        return roomName;
    }

    public String getBoardID() {
        return boardID;
    }

    public ArrayList<Appliance> getAttachedAppliances() {
        return attachedAppliances;
    }

    public Appliance getItem(int i){
        return attachedAppliances.get(i);
    }

    public SwitchBoard() {
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public void setHouseId(String houseId) {

        this.houseId = houseId;
    }

    public void setBoardID(String boardID) {
        this.boardID = boardID;
    }

    public void setAttachedAppliances(ArrayList<Appliance> attachedAppliances) {
        this.attachedAppliances = attachedAppliances;
    }

}
