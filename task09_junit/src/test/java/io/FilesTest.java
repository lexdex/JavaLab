package io;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.BufferedReader;
import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class FilesTest {

    private Files files;

    @BeforeEach
    public void setUp(){
        this.files = new Files("text.txt");
    }
    @Test
    public void readLinesTest() throws IOException {

        BufferedReader bufferedReader = Mockito.mock(BufferedReader.class);
        when(bufferedReader.readLine()).thenReturn("line1").thenReturn("line2").thenReturn("line3").thenReturn(null);
        String lines = files.readLines(bufferedReader);
        verify(bufferedReader).close();
        assertThat(lines, containsString("line3"));
    }

    @Test
    public void changeFileNameTest() {
        String newFileName = "poem.txt";
        files.setFileName(newFileName);
        assertEquals(files.getFileName(), newFileName);
    }
}