package com.braincs.nativebytes;

/**
 * Created by Shuai
 * 4/11/21.
 */
public class NativeAPI {
    static {
        System.loadLibrary("abytes");
    }

    public static native void passBytes(byte[] data);
}
