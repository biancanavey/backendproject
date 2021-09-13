package com.example.demo.ward;

public class Ward {

    private int wardId;
    private String wardName;

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

    @Override
    public String toString() {
        return "Ward{" +
                "wardId=" + wardId +
                ", wardName='" + wardName + '\'' +
                '}';
    }
}
