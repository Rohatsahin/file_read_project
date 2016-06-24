package com.app.util;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.Assert.*;

public class FileUtilTest {

    private String file_part;

    private String dummy_part = "D:\\proje\\src\\test\\resources\\Rohat Şahin--CV.docx";

    @Rule
    public TemporaryFolder temporaryFolder = new TemporaryFolder();

    @Before
    public void setUp() throws IOException {
        File file = temporaryFolder.newFile("test.pdf");
        file_part = file.getPath();
    }

    @Test
    public void shouldReturnTrueIfFileExist() throws IOException{

        assertTrue(FileUtil.checkFileExists(file_part));
    }

    @Test
    public void shouldReturnFalseIfFileNotExist(){

        assertFalse(FileUtil.checkFileExists(dummy_part));
    }

    @Test
    public void shouldReturnNullWhenFileNotExist(){

        assertNull(FileUtil.createFileStream(dummy_part));
    }

    @Test(expected = FileNotFoundException.class)
    public void shouldReturnFileNotFoundException(){

        FileUtil.createFileStream(file_part);
    }

}