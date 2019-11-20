package com.basicappstructure.imageCompression;

public interface ImageCompressionListener {
    void onStart();

    void onCompressed(String filePath);
}
