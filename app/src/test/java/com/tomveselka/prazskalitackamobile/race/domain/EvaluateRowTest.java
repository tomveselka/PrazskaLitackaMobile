package com.tomveselka.prazskalitackamobile.race.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class EvaluateRowTest {

    EvaluateRow evaluateRow = new EvaluateRow();
    @Test
    public void getLinePointsCorrect(){
        assertEquals(2,evaluateRow.getLinePointsByType("B", "metro"));
        assertEquals(6,evaluateRow.getLinePointsByType("425", "bus"));
        assertEquals(5,evaluateRow.getLinePointsByType("300", "bus"));
        assertEquals(3,evaluateRow.getLinePointsByType("X-25", "bus"));
        assertEquals(3,evaluateRow.getLinePointsByType("201", "bus"));
        assertEquals(7,evaluateRow.getLinePointsByType("S41", "train"));
        assertEquals(8,evaluateRow.getLinePointsByType("R5", "train"));
    }

    @Test
    public void calculatePointsForLineCorrect(){
        assertEquals(2,evaluateRow.calculatePointsForLine("B", "metro", false));
        assertEquals(13,evaluateRow.calculatePointsForLine("P2", "ferry", true));

    }
}
