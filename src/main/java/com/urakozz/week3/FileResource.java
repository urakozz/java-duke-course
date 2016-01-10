package com.urakozz.week3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;

/**
 * Created by yury on 10/01/16.
 */
public class FileResource {

    private File file ;

    public FileResource(File f) {
        file = f;
    }

    public FileResource(String filename){
        this(new File(filename));
    }

    public String asString(){
        try {
            return new String(Files.readAllBytes(file.toPath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    public java.lang.Iterable<java.lang.String> lines() throws IOException {
        return Files.readAllLines(file.toPath());
    }

    public java.lang.Iterable<java.lang.String> words() throws IOException {
        String[] arr = asString().split("[\\s\\t\\n]+");

        return Arrays.asList(arr);
    }

    public static void main(String args[])
    {
        new FileResource("file");
    }
}
