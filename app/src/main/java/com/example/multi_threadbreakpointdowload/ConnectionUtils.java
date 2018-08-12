package com.example.multi_threadbreakpointdowload;

import android.os.Environment;

import java.net.HttpURLConnection;
import java.net.URL;

public class ConnectionUtils {
    static HttpURLConnection connectNetSettings(String path) throws Exception {
        URL url = new URL(path);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setConnectTimeout(5000);
        return conn;
    }

    static String getFileName(String path) {
        int index = path.lastIndexOf("/") + 1;
        return Environment.getExternalStorageDirectory().getPath() + "/" + path.substring(index);
    }

    static <T extends java.io.Closeable> void close(T t) {
        try {
            if (t != null) {
                t.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
