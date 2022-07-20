package com.zkb.springredisstudy;

import com.zkb.springredisstudy.event.scan.SimpleClassScan;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class ScanTest {

    @Test
    public void test() {
        SimpleClassScan simpleClassScan = new SimpleClassScan();
        Set<Class<?>> scan = simpleClassScan.scan("com.zkb");
        for (Class<?> aClass : scan) {
            System.out.println(aClass);
        }
    }
}
