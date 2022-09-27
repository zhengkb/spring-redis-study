package com.zkb.springredisstudy.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

public class TestFileInput {

    private static final String FILENAME = "F:/pond_cache_2.data";

    private static final Logger logger = LoggerFactory.getLogger(TestFileInput.class);

    public static void readByByte(String fileName) {

        File file = new File(fileName);

        InputStream in = null;

        System.out.println("read file content by byte:");

        try {

            in = new FileInputStream(file);

            int tempbyte = 0;

            while ((tempbyte = in.read()) != -1) {

                System.out.write(tempbyte);

            }

            in.close();

        } catch (Exception e) {

            logger.info("readByByte error!");

            e.printStackTrace();

            return;

        }

        try {

            System.out.println("read by more byte:");

            byte[] tempbytes = new byte[10];

            int byteread = 0;

            in = new FileInputStream(fileName);

            while ((byteread = in.read(tempbytes)) != -1) {

                System.out.write(tempbytes, 0, byteread);

            }

        } catch (Exception e) {

            logger.info("read by more byte error!");

            e.printStackTrace();

        } finally {

            if (in != null) {

                try {

                    in.close();

                } catch (Exception e) {

// do nothing

                }

            }

        }

    }

    public static void readByChars(String fileName) {

        File file = new File(fileName);

        Reader reader = null;

        System.out.println(" read by chars:");

        try {

            reader = new InputStreamReader(new FileInputStream(file));

            int tempchar;

            while ((tempchar = reader.read()) != -1) {

                if (((char) tempchar) != '\r') {

                    System.out.println((char) tempchar);

                }

            }

            reader.close();

        } catch (Exception e) {

            logger.info("read by chars error!");

            e.printStackTrace();

        }

        System.out.println("read by more chars:");

        try {

            reader = new InputStreamReader(new FileInputStream(fileName));

            char[] tempchars = new char[50];

            int charread;

            while ((charread = reader.read(tempchars)) != -1) {

                if ((charread == tempchars.length) && (tempchars[tempchars.length - 1] != '\r')) {

                    System.out.print(tempchars);

                } else {

                    for (int i = 0; i < charread; i++) {

                        if (tempchars[i] == '\r') {

                            continue;

                        } else {

                            System.out.print(tempchars[i]);

                        }

                    }

                }

            }

        } catch (Exception e) {

            logger.info("read by more chars error");

            e.printStackTrace();

        } finally {

            if (reader != null) {

                try {

                    reader.close();

                } catch (IOException e) {

                    e.printStackTrace();

                }

            }

        }

    }

    public static void readByLines(String fileName) {

        File file = new File(fileName);

        BufferedReader reader = null;

        System.out.println("read by line:");

        try {

            reader = new BufferedReader(new FileReader(file));

            String tempString = null;

            int line = 1;

            while ((tempString = reader.readLine()) != null) {

                System.out.println("line " + line + "is :" + tempString);

                line++;

            }

            reader.close();

        } catch (Exception e) {

            logger.info("read by line error!");

            e.printStackTrace();

        } finally {

            if (reader != null) {

                try {

                    reader.close();

                } catch (Exception e) {

// do nothing

                }

            }

        }

    }

    public static void readByRandomAccess(String fileName) {

        RandomAccessFile file = null;

        System.out.println("read by randomAccessFile:");

        try {

            file = new RandomAccessFile(fileName, "r");

            long length = file.length();

            int beginIndex = (length > 4) ? 4 : 0;

            file.seek(beginIndex);

            byte[] bytes = new byte[10];

            int byteread = 0;

            while ((byteread = file.read(bytes)) != -1) {

                System.out.write(bytes, 0, byteread);

            }

        } catch (Exception e) {

            logger.info("read by randomAccess error");

        } finally {

            if (file != null) {

                try {

                    file.close();

                } catch (Exception e) {

// do nothing

                }

            }

        }

    }

    public static void main(String[] args) {

        readByByte(FILENAME);

//        readByChars(FILENAME);
//
//        readByLines(FILENAME);
//
//        readByRandomAccess(FILENAME);

    }

}
