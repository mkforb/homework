package com.ifmo.jjd.homework18;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by User on 30.04.2021.
 */
public class XorInputStream extends FilterInputStream {
    private byte key;

    protected XorInputStream(InputStream in, byte key) {
        super(in);
        this.key = key;
    }

    @Override
    public int read() throws IOException {
        int b = super.read();
        if (b == -1) return b;
        return b ^ key;
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        int byteCount = super.read(b, off, len);
        for (int i = 0; i < b.length; i++) {
            b[i] = (byte) (b[i] ^ key);
        }
        return byteCount;
    }
}
