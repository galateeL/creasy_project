package com.example.creasy.model;

public enum SortType {

    ORDER_BY_LASTNAME_DESC("ZA"),
    ORDER_BY_LASTNAME_ASC("AZ"),
    ORDER_BY_REGISTER_DATE_DESC("ON"),
    ORDER_BY_REGISTER_DATE_ASC("NO");
    private String value;

    SortType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static SortType fromValue(String value) {

        for(SortType sortType :  SortType.values()) {
           if(sortType.getValue().equals(value)) {
               return sortType;
            }
        }
        return ORDER_BY_LASTNAME_ASC;
    }


}


