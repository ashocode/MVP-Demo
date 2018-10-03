package com.example.android.mvpdemo;

import com.example.android.mvpdemo.Model.BackgroundObjectColor;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Asen.Pichurov on 03-Oct-18.
 */

public class BackgroundObjectColorTest {

    @Test
    public void testGetObjectColor(){
        String color = "#FFFFFF";
        BackgroundObjectColor objectColor = new BackgroundObjectColor(color);

        assertEquals("Failure when getting the object color. Check getObjectColor().",objectColor.getObjectColor(), color);
    }

    @Test
    public void testChangeObjectColor(){
        String color = "#FFFFFF";
        BackgroundObjectColor objectColor = new BackgroundObjectColor();

        objectColor.setObjectColor(color);

        assertEquals("Failure when setting the object color. Check setObjectColor().",objectColor.getObjectColor(), color);
    }

}
