package com.ord.fiserv.exception;

public class ItemNotFoundException extends RuntimeException {

    private Long id;

    public ItemNotFoundException(Long id) {
        super("Could not find item " + id);
    }
}