package com.ifmo.jjd.homework23;

import javax.lang.model.type.PrimitiveType;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Properties;

/**
 * Created by User on 13.05.2021.
 */
public class AnnotationApp {
    public static void main(String[] args) {
        // Д/з:
        // Если класс аннотирован Component
        // Создать объект данного класса рефлексивно (получить конструктор без параметров, создать объект)
        // Взять поля, проверить если поле аннотировано Required,
        // установтиь значение (из properties файла) данного поля, используя сеттер!!!
        // Обращаемся к рефлексивно созданному оъекту
        // Если поле int x, то метод setX(int x), если String name - setName(String name)
        // Тип данных взять из поля
        Object obj = createObject(Point.class);
        System.out.println(obj);
    }

    private static <T> T createObject(Class<?> cl) {
        Object o = null;
        if (cl.isAnnotationPresent(Component.class)) {
            Component component = cl.getDeclaredAnnotation(Component.class);
            String fileName = component.fileName();
            // Прочитать параметры из файла properties
            Properties properties = readProperties(fileName);
            try {
                // Получить публичный конструктор без параметров
                Constructor<?> constructor = cl.getDeclaredConstructor();
                // Создать объект
                o = constructor.newInstance();
                // Получить свойства класса
                Field[] fields = cl.getDeclaredFields();
                for (Field field : fields) {
                    if (field.isAnnotationPresent(Required.class)) {
                        // Получить метод сеттера для свойства
                        String methodName = "set" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1);
                        Method setMethod = cl.getDeclaredMethod(methodName, field.getType());
                        // Получить значение свойства из файла и преобразовать его
                        setMethod.invoke(o, convert(properties.getProperty(field.getName()), field.getType())); // Гужно делать проверку на тип данных поля. В зависимости от типа делать преобразование. Это будет отдельный класс
                    }
                }
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return (T) o;
    }

    private static Properties readProperties(String fileName) {
        Properties properties = new Properties();
        try (InputStream input = AnnotationApp.class.getClassLoader().getResourceAsStream(fileName)) {
            properties.load(input);
        } catch (IOException e) {
            // Выбросить новый runtime exception, что не удается прочитать файл с настройками
            throw new RuntimeException("Файл не удалось прочитать");
        }
        return properties;
    }

    private static Object convert(String value, Class<?> type) {
        if (type.isPrimitive()) {
            if (type.getName().equals("int")) {
                return Integer.valueOf(value);
            }
        } else if (type.getName().equals("java.lang.String")) {
            return value;
        }
        return null;
    }
}
