package com.example.kongcw.testing.viewmodel;

/**
 * Created by kongcw on 3/11/2018.
 */

import android.arch.lifecycle.ViewModel;

public class myViewModel extends ViewModel {

    private String name;
    private int age;
    private int count;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
