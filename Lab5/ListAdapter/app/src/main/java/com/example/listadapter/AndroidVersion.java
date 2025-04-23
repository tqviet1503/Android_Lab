package com.example.listadapter;

public class AndroidVersion {
    private String name;
    private String versionNumber;
    private int iconId;

    public AndroidVersion(String name, String versionNumber, int iconId) {
        this.name = name;
        this.versionNumber = versionNumber;
        this.iconId = iconId;
    }

    public String getName() {
        return name;
    }

    public String getVersionNumber() {
        return versionNumber;
    }

    public int getIconId() {
        return iconId;
    }
}