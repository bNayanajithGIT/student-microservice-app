package com.book.booktransactions.enums;

public enum BookStatus {

    IN_STOCK(1, "In Stock"), OUT_OF_STOCK(2, "Out of Stock");

    private int id;
    private String name;

    BookStatus(int id, String name){
        this.id = id;
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public String getName() {
		return name;
	}
    public static BookStatus getById(int id) {
        for(BookStatus e : values()) {
            if(e.id == id) return e;
        }
        return null;
    }
}
