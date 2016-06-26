package com.app.util;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

public class FileUtilTest {

    private String file_part;

    private String dummy_part = "D:\\proje\\src\\test\\resources\\test.docx";

    @Rule
    public TemporaryFolder temporaryFolder = new TemporaryFolder();

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setUp() throws IOException {
        File file = temporaryFolder.newFile("test.pdf");
        file_part = file.getPath();
    }

    @Test
    public void shouldReturnTrueIfFileExist() {

        assertTrue(FileUtil.checkFileExists(file_part));
    }

    @Test
    public void shouldReturnFalseIfFileNotExist() {

        assertFalse(FileUtil.checkFileExists(dummy_part));
    }

    @Test
    public void shouldCreateFileStreamIFileExists() throws Exception {

        assertNotNull(FileUtil.createFileStream(file_part));
    }

    @Test
    public void shouldReturnNullWhenFileNotExist() throws Exception {
        expectedException.expect(FileNotFoundException.class);

        assertNull(FileUtil.createFileStream(dummy_part));
    }

    @Test
    public void shouldReturnFileNotFoundException() throws Exception {
        expectedException.expect(FileNotFoundException.class);

        FileUtil.createFileStream(dummy_part);
    }

    @Test
    public void shouldReturnUTF8FileEncoding() throws Exception {

        assertThat(FileUtil.getFileEncoding(file_part), equalTo("UTF8"));
    }

    @Test
    public void shouldReturnFileNotFountExceptionForGivenDummyPart() throws Exception {

        expectedException.expect(FileNotFoundException.class);

        assertNull(FileUtil.getFileEncoding(dummy_part));
    }

}