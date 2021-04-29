package com.ifmo.jjd.homework18;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by User on 30.04.2021.
 */
public class XorOutputStream extends FilterOutputStream {
    private byte key;

    public XorOutputStream(OutputStream out, byte key) {
        super(out);
        this.key = key;
    }

    @Override
    public void write(int b) throws IOException {
        super.write(b ^ key);
    }
}
