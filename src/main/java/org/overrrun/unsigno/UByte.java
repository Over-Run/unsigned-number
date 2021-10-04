package org.overrrun.unsigno;

import static java.lang.Integer.parseInt;
import static java.lang.Integer.toBinaryString;

/**
 * @author squid233
 * @since 0.1.0
 */
public class UByte implements UNumber {
    private final Bit[] bits = {
            new Bit(),
            new Bit(),
            new Bit(),
            new Bit(),
            new Bit(),
            new Bit(),
            new Bit(),
            new Bit()
    };

    public UByte(String b) {
        setValue(b);
    }

    public UByte(int b, boolean isRawBin) {
        if (isRawBin) {
            setValueRB(b);
        } else {
            setValue(b);
        }
    }

    public UByte(int b) {
        this(b, false);
    }

    public UByte(byte b) {
        setValue(b);
    }

    public UByte(UByte b) {
        setValue(b);
    }

    public UByte() {
    }

    public static UByte add(int i, UByte dist) {
        for (int j = 0; j < i; j++) {
            for (int k = 7; k >= 0; k--) {
                if (dist.bits[k].reverse().isOn()) {
                    break;
                }
            }
        }
        return dist;
    }

    public UByte add(int i) {
        return add(i, this);
    }

    public static UByte sub(int i, UByte dist) {
        for (int j = 0; j < i; j++) {
            for (int k = 7; k >= 0; k--) {
                if (dist.bits[k].reverse().isOff()) {
                    break;
                }
            }
        }
        return dist;
    }

    public UByte sub(int i) {
        return sub(i, this);
    }

    public static UByte mul(int i, UByte dist) {
        if (i == 0) {
            dist.setValue(0);
        } else {
            dist.setValue(toBinaryString(parseInt(dist.toString()) * i));
        }
        return dist;
    }

    public UByte mul(int i) {
        return mul(i, this);
    }

    public static UByte div(int i, UByte dist) {
        if (i == 0) {
            throw new ArithmeticException("/ by zero");
        } else {
            dist.setValue(toBinaryString(parseInt(dist.toString()) / i));
        }
        return dist;
    }

    public UByte div(int i) {
        return div(i, this);
    }

    public void setValue(String b) {
        int l = b.length();
        if (l < 8) {
            b = String.format("%08d", parseInt(b));
        } else {
            b = b.substring(l - 8);
        }
        for (int i = 0; i < bits.length; i++) {
            bits[i].setValue(b.charAt(i) == '1');
        }
    }

    public void setValueRB(int b) {
        setValue(toBinaryString(b));
    }

    public void setValue(int b) {
        setValue(String.valueOf(b));
    }

    public void setValue(byte b) {
        setValueRB(b);
    }

    public void setValue(UByte b) {
        System.arraycopy(b.bits, 0, bits, 0, bits.length);
    }

    public void setBit(int i, boolean v) {
        bits[i].setValue(v);
    }

    public void setBit(int i, int v) {
        bits[i].setValue(v);
    }

    @Override
    public boolean isUnsigned() {
        return true;
    }

    @Override
    public int getBytes() {
        return 1;
    }

    public String toStringB() {
        StringBuilder sb = new StringBuilder();
        for (Bit bit : bits) {
            sb.append(bit);
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        int r = 0;
        for (int i = 0; i < bits.length; i++) {
            r += bits[i].getIntValue() << 7 - i;
        }
        return String.valueOf(r);
    }
}
