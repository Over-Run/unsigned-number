package org.overrrun.unsigno;

import java.util.Objects;

/**
 * @author squid233
 * @since 0.1.0
 */
public class Bit {
    private boolean b;

    public Bit(boolean b) {
        this.b = b;
    }

    public Bit(int b) {
        this.b = toBool(b);
    }

    public Bit() {
        b = false;
    }

    public static boolean toBool(int i) {
        return i == 1;
    }

    public boolean getValue() {
        return b;
    }

    public int getIntValue() {
        return b ? 1 : 0;
    }

    public void setValue(boolean b) {
        this.b = b;
    }

    public void setValue(int b) {
        this.b = toBool(b);
    }

    public Bit reverse(Bit dist) {
        dist.b = !b;
        return dist;
    }

    public Bit reverse() {
        return reverse(this);
    }

    public boolean isOn() {
        return b;
    }

    public boolean isOff() {
        return !b;
    }

    @Override
    public int hashCode() {
        return Objects.hash(b);
    }

    @Override
    public String toString() {
        return String.valueOf(getIntValue());
    }
}
