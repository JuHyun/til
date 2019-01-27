package javabasic;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.stream.Stream;

public class ReflectionTest {

    @Test
    public void test() throws ClassNotFoundException {
        Class<?> a = Class.forName("javabasic.ReflectSample");
        Field[] declaredFields = a.getDeclaredFields();
        Method[] declaredMethods = a.getDeclaredMethods();

        assertEquals("STRING", declaredFields[0].getName());
        assertEquals("print", declaredMethods[0].getName());
    }

    @Test
    public void test2() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> a = Class.forName("javabasic.ReflectSample");
        Object instance = a.newInstance();
        Field[] declaredFields = a.getDeclaredFields();
        Method[] declaredMethods = a.getDeclaredMethods();

        Stream.of(declaredFields).forEach(field -> {
            try {
                assertEquals(ReflectSample.STRING, field.get(instance));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });

        Stream.of(declaredMethods).forEach(method -> {
            try {
                assertEquals(ReflectSample.STRING + " Another String.", method.invoke(instance));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        });
    }
}
