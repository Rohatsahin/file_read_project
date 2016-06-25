package com.app;


import com.app.util.FileUtil;
import com.app.util.ProcessUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        System.out.println("Please enter file path : ");
        String file_path = new Scanner(System.in).nextLine(); //example path : C:\\Users\\rohat\\Desktop\\Rohat Şahin--CV.docx

        BufferedReader reader = null;

        if (FileUtil.checkFileExists(file_path)) {
            reader = FileUtil.createFileStream(file_path);
        }

        for (String line; (line = reader.readLine()) != null; ) {
            ProcessUtil.processByline(line);
        }
    }
}
