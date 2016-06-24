package com.app.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProcessUtil {

    private final static Logger logger = LoggerFactory.getLogger(ProcessUtil.class);

    public static void processByline(String file_line) {

        String line[] = file_line.split("\\s+");

        for (int i = 0; i < line.length; i++) {

            if (i % 2 == 0) {
                logger.info("word is even :  " + line[i]);
            } else {
                logger.info("word is odd : " + new StringBuilder(line[i]).reverse().toString());
            }
        }
    }

}
