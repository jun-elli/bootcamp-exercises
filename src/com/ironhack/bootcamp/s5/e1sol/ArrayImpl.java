package com.ironhack.bootcamp.s5.e1sol;


public class ArrayImpl {

    public static final int DEFAULT_SIZE=5;

    private int[] itemList;
    private int idx;

    public ArrayImpl () {
        this.itemList = new int[DEFAULT_SIZE];
        this.idx = 0;
    }

    public void addItem(int a) {
        if (idx == this.itemList.length-1) {
            this.increaseSize();
        }
        this.itemList[++idx] = a;
    }

    public Integer last() {
        return this.itemList[idx];
    }

    public Integer first() {
        return this.itemList[0];
    }

    public void increaseSize() {
        int[] newItemList = new int[this.itemList.length * 5];
        for (int idx = 0; idx < this.itemList.length -1 ; idx++) {
            newItemList[idx] = this.itemList[idx];
        }

        this.itemList = newItemList;
    }


}
