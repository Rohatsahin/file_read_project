package com.app.util;

import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.*;

public class FileUtilTest {

    @Test
    public void shouldReturnTrueIfFileExist(){
        String file_part = "D:\\proje\\src\\test\\resources\\Rohat Şahin--CV.docx";

        assertTrue(FileUtil.checkFileExists(file_part));
    }

    @Test
    public void shouldReturnFalseIfFileNotExist(){
        String file_part = "D:\\proje\\src\\test\\resources\\Rohat Şahin--CV.pdf";

        assertFalse(FileUtil.checkFileExists(file_part));
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowFileNotFoundException(){
        String file_part = "D:\\proje\\src\\test\\resources\\Rohat Şahin--CV.pdf";
        
        assertThat(FileUtil.createFileStream(file_part),null);
    }

}