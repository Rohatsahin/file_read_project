package com.app.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProcessUtil {

    private final static Logger logger = LoggerFactory.getLogger(ProcessUtil.class);

    public static void processByline(String file_line) {

        logger.debug("process start for given string: " +file_line);

        String line[] = file_line.split("\\s+");

        for (int i = 0; i < line.length; i++) {

            System.out.println(process(line, i));
        }
    }

    public static String process(String[] line, int i) {
        if (i % 2 == 0) {
            return "word is even : " + new StringBuilder(line[i]).reverse().toString();
        } else {
            return "word is odd : " + line[i];
        }
    }

}
