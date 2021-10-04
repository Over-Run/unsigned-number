package org.overrun.unsigno;

import org.overrrun.unsigno.UByte;

/**
 * @author squid233
 */
public class Test {
    private static void print(UByte uByte) {
        System.out.println(uByte.toStringB());
        System.out.println(uByte);
    }

    public static void main(String[] args) {
        //219
        UByte uByte = new UByte(11011011);
        print(uByte);
        //220
        print(uByte.add(1));
        //255
        print(uByte.add(35));
        //0(overflow)
        print(uByte.add(1));
        //255(underflow)
        print(uByte.sub(1));
        //254
        print(uByte.sub(1));
        //54
        print(uByte.sub(200));
        //162
        print(uByte.mul(3));
        //128
        print(uByte.sub(34));
        //0(overflow)
        print(uByte.mul(2));
        //9
        print(uByte.add(9));
        //3
        print(uByte.div(3));
    }
}
