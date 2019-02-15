package com.tidtech.mydatabase;

public class noteItem {


    private String ItemName;
    private String ItemId;
    private String ItemCourse;
    private String ItemUnit;
    private String ItemLec;

    public noteItem(String itemName,String Title,String itemCourse,String itemUnit, String itemLec) {
        this.ItemName = itemName;
        this.ItemId=Title;
        this.ItemCourse=itemCourse;
        this.ItemUnit=itemUnit;
        this.ItemLec=itemLec;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String itemName) {
        ItemName = itemName;
    }

    public String getItemId() {
        return ItemId;
    }

    public void setItemId(String itemId) {
        ItemId = itemId;
    }

    public String getItemCourse() {
        return ItemCourse;
    }

    public void setItemCourse(String itemCourse) {
        ItemCourse = itemCourse;
    }
    public String getItemUnit() {
        return ItemUnit;
    }

    public void setItemUnit(String itemUnit) {
        ItemUnit = itemUnit;
    }

    public String getItemLec() {
        return ItemLec;
    }

    public void setItemLec(String itemLec) {
        ItemLec = itemLec;
    }



}


