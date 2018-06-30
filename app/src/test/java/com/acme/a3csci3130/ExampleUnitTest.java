package com.acme.a3csci3130;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void check() {
        String name = "Lile";
        String busines = "999999999";
        String primary = "Fisher";
        String address = "Halifax";
        String province = "NS";

        boolean out = Contact.validate(name, busines, primary, address, province);
        assertEquals(true, out);
    }

    @Test
    public void check1() {
        String name = "Lile";
        String busines = "9";
        String primary = "Fisher";
        String address = "Halifax";
        String province = "NS";
        boolean out = Contact.validate(name, busines, primary, address, province);
        assertEquals(false, out);
    }

    @Test
    public void check2() {
        String name = "L";
        String busines = "999999999";
        String primary = "student";
        String address = "Halifax";
        String province = "NS";
        boolean out = Contact.validate(name, busines, primary, address, province);
        assertEquals(false, out);
    }

    public void check3() {
        String name = "Lile";
        String busines = "999999999";
        String primary = "Fisher";
        String address = "Halifax";
        String province = "N";
        boolean out = Contact.validate(name, busines, primary, address, province);
        assertEquals(false, out);
    }
}