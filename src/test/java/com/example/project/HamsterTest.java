package com.example.project;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

public class HamsterTest {

    @Test
    public void testClassHasConstructor() {
        Class<Hamster> hamsterClass = Hamster.class;
        try {
            Constructor<Hamster> constructor = hamsterClass.getConstructor(String.class);
        } catch (NoSuchMethodException e) {
            fail("Expected constructor with parameters (String) was not found.");
        }
    }


    @Test
    public void testClassHasPrivateFieldName() {
        Class<Hamster> hamsterClass = Hamster.class;
        try {
            Field nameField = hamsterClass.getDeclaredField("name");
            assertNotNull(nameField, "Field 'name' should exist.");
            assertTrue(Modifier.isPrivate(nameField.getModifiers()), "Field 'name' should be private.");
        } catch (NoSuchFieldException e) {
            fail("Field does not exist: " + e.getMessage());
        }
    }

    @Test
    public void testClassHasGetterName() {
        Class<Hamster> hamsterClass = Hamster.class;
        try {
            Method getNameMethod = hamsterClass.getDeclaredMethod("getName");
            assertNotNull(getNameMethod, "Method 'getName' should exist.");
            assertTrue(Modifier.isPublic(getNameMethod.getModifiers()), "Method 'getName' should be public.");
        } catch (NoSuchMethodException e) {
            fail("Method does not exist: " + e.getMessage());
        }
    }

}
