package com.tmb.utils;

import lombok.Getter;
import lombok.Setter;

//@Builder(setterPrefix = "set")
@Getter
@Setter
public class myCounter {
    private int count;

    public myCounter() {
        count = 0;
    }

    public int increment() {
        count++;
        return count;
    }

    public void decrement() {
        count--;
    }

    public int getCount() {
        return count;
    }
}



