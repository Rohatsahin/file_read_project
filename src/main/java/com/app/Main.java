package com.app;


import com.app.util.FileUtil;
import com.app.util.ProcessUtil;

import java.io.BufferedReader;
import java.io.IOException;

public class Main {


    public static void main(String[] args) throws IOException {

        String file_path = "C:\\Users\\rohat\\Desktop\\Rohat Şahin--CV.docx";

        BufferedReader reader = null;

        if(FileUtil.checkFileExists(file_path)) {

            reader = FileUtil.createFileStream(file_path);
        }

        for(String line ; (line = reader.readLine()) != null;){
            ProcessUtil.processByline(line);
        }

    }
}
