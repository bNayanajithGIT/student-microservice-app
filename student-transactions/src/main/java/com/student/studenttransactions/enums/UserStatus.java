package com.student.studenttransactions.enums;

public enum UserStatus {

    ACTIVE(1, "Active"), DEACTIVATED(2, "Deactivated");

    private int id;
    private String name;

    UserStatus(int id, String name){
        this.id = id;
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public String getName() {
		return name;
	}
    public static UserStatus getById(int id) {
        for(UserStatus e : values()) {
            if(e.id == id) return e;
        }
        return null;
    }
}
