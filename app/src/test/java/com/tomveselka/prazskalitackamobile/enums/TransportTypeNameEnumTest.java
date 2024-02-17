package com.tomveselka.prazskalitackamobile.enums;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TransportTypeNameEnumTest {
    @Test
    public void convertCzEnNamesCorrect() {
        assertEquals("přívoz", TransportTypeNameEnum.getCzNameFromEnName("ferry"));
        assertEquals("ferry", TransportTypeNameEnum.getEnNameFromCzName("přívoz"));

    }
}
