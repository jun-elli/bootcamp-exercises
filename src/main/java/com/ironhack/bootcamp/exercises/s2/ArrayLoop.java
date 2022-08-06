package com.ironhack.bootcamp.exercises.s2;

public class ArrayLoop {
    private Float saldo;

    public void setSaldo(float nuevoSaldo) throws Exception{
        if(nuevoSaldo > 1000) {
            throw new Exception("Saldo no permitodo");
        } else {
            this.saldo = nuevoSaldo;
        }
    }

    public Float getSaldo() {
        if (this.saldo == null) {
            this.saldo = new Float(0);
        }
        return this.saldo;
    }

    public void setPassword(String plainPass) {
        String encoded = encodePass(plainPass);
    }

    private String encodePass(String plain) {
        return plain;
    }





    public void execute(int i) {
        int[] srcArray = {1,2,3,4,5};
        switch (i) {
            case 1:
                // To be done
                initializeArray(10);
                break;
            case 2:
                // To be done
                multiplyArrayDescWithWhile(srcArray, 100);
                break;
            case 3:
                multiplyArrayAsc(srcArray, 100);
                break;
            case 4:
                multiplyArrayDesc(srcArray, 100);
                break;

        }
    }

    /**
     * Initialize an array with the n first numbers, starting from 1
     * @return
     */
    public int[] initializeArray(int n) {
        // Not yet implemented
        return null;
    }

    public int[] multiplyArrayDesc(int[] srcArray, int multiplier) {
        for (int i=srcArray.length-1; i >= 0; i--) {
            srcArray[i] = srcArray[i] * 100;
            System.out.println(srcArray[i]);
        }

        return srcArray;
    }

    /**
     * Convert the previous method loop in a while loop, you can also give it a try with a do while
     * @param srcArray Source array
     * @param multiplier the number to which we need to multiply array items
     * @return
     */
    public int[] multiplyArrayDescWithWhile(int[] srcArray, int multiplier) {
        // Not yet implemented
        return null;
    }


    public int[] multiplyArrayAsc(int[] srcArray, int multiplier) {

        for (int i = 0; i < srcArray.length; i++) {
            srcArray[i] = srcArray[i] * 100;
            System.out.println(srcArray[i]);
        }

        return srcArray;
    }

    public int[] invertArray (int[] srcArray) {
        int arrayLength = srcArray.length;
        int[] dstArray = new int[arrayLength];

        /*
            We can initialize and modify several variables when declaring the loop
         */
        for (int i=arrayLength -1, j=0; i >= 0; i--, j++) {
            dstArray[j] = srcArray[i];
        }

        /*
            With no extra variable
            {1, 2, 3, 4, 5}
            steps:
            1-  src i= 5-1, dst i= (5-1)-(5-1) = 0    {1, 2, 3, 4, *5*}, {*5*,,,,}
            2-  src i= 3,   dst i= (5-1) - 3 = 1      {1, 2, 3, *4*, 5}, {5,4,,,}
            3-  src i= 2,   dst i= (5-1) - 2 = 2      {1, 2, *3*, 4, 5}, {5,4,3,,}
            4-  src i= 1,   dst i= (5-1) - 1 = 3      {1, *2*, 3, 4, 5}, {5,4,3,*2*,}
            5-  src i= 0,   dst i= (5-1) - 0 = 4      {1, 2, 3, 4, *5*}, {5,4,3,2,*1*}


            for (int i=arrayLength -1; i >= 0; i++) {
                dstArray[(arrayLength-1) -i] = srcArray[i];
            }
         */

        return dstArray;
    }
}
