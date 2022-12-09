package com.zkb.springredisstudy.base.classloader;

import lombok.SneakyThrows;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class OpsClassLoader extends ClassLoader {

    private String rooDirPath;

    public OpsClassLoader(String rooDirPath) {
        this.rooDirPath = rooDirPath;
    }

    private byte[] getClassDePass(String className) throws IOException {
        String classPath = rooDirPath + className;

        FileInputStream fis = new FileInputStream(classPath);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int bufferSize = 1024;
        int n = 0;
        byte[] buffer = new byte[bufferSize];
        while ((n = fis.read(buffer)) != -1) {
            baos.write(buffer, 0, n);
        }
        byte[] data = baos.toByteArray();
        return data;
    }

    @SneakyThrows
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        byte[] classData = getClassDePass(name);
        if (classData == null)
            throw new ClassNotFoundException();
        return defineClass(name, classData, 0, classData.length);
    }
}
