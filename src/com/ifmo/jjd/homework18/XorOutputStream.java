package com.ifmo.jjd.homework18;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by User on 30.04.2021.
 */
public class XorOutputStream extends FilterOutputStream {
    private final byte[] key;
    private int index;

    public XorOutputStream(OutputStream out, String sKey) {
        super(out);
        this.key = sKey.getBytes();
    }

    @Override
    public void write(int b) throws IOException {
        super.write(b ^ key[index]);
        if (index < key.length - 1) {
            index++;
        } else {
            index = 0;
        }
    }

    @Override
    public void write(byte[] b) throws IOException {
        index = 0;
        super.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        index = 0;
        super.write(b, off, len);
    }
}
