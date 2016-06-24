package com.app.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.*;

public class FileUtil {

    private final static Logger logger = LoggerFactory.getLogger(FileUtil.class);


    public static Boolean checkFileExists(String file_part) {

        File f = new File(file_part);
        if (f.exists() && !f.isDirectory()) {
            logger.info("file validation success for this file path: " + file_part);
            return true;
        } else {
            logger.error("file not exists for given file path: " + file_part);
            return false;
        }
    }

    public static BufferedReader createFileStream(String file_part) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(
                    new InputStreamReader(new FileInputStream(file_part), getFileEncoding(file_part)));
        } catch (IOException e) {
            logger.info("createFileStream throw exception : " + e);
        }

        return reader;
    }

    public static String getFileEncoding(String file_part) {
        String encoding = " ";
        try {
            FileInputStream fileInputStream = new FileInputStream(file_part);
            encoding = new InputStreamReader(fileInputStream).getEncoding();
            fileInputStream.close();
        } catch (IOException e) {
            logger.info("getFileEncoding method throw exception : " + e);
        }

        return encoding;
    }

}
