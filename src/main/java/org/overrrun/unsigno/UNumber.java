package org.overrrun.unsigno;

/**
 * @author squid233
 * @since 0.1.0
 */
public interface UNumber {
    boolean isUnsigned();

    int getBytes();

    default int getBits() {
        return getBytes() * 8;
    }

    @Override
    String toString();
}
