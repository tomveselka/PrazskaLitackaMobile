package com.tomveselka.prazskalitackamobile.enums;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TransportTypePointsEnumTest {
    @Test
    public void pointsForMetroCorrect() {
        assertEquals(2, TransportTypePointsEnum.METRO.getPoints());
    }
}
