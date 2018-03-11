package com.example.kongcw.testing.viewmodel;

/**
 * Created by kongcw on 3/11/2018.
 */

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class myViewModel extends ViewModel {

    private String name;
    private int age;
    private MutableLiveData<Integer> count;

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

    public MutableLiveData<Integer> getCount() {
        return count;
    }

    public void setCount(MutableLiveData<Integer> count) {
        this.count = count;
    }
}
