package com.example.demo.Ward;


public class Ward {
    private int wardId;
    private String wardName;



    public Ward() {}

    public Ward(int wardId, String wardName) {
        this.wardId = wardId;
        this.wardName = wardName;
    }

    public int getWardId() {
        return wardId;
    }

    public void setWardId(int wardId) {
        this.wardId = wardId;
    }

    public String getWardName() {
        return wardName;
    }

    public void setWardName(String wardName) {
        this.wardName = wardName;
    }


}

