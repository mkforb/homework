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

    private static Object createObject(Class<?> classObj) {
        if (classObj.isAnnotationPresent(Component.class)) {
            try {
                // Получить публичный конструктор без параметров
                Constructor<?> constructor = classObj.getConstructor();
                // Создать объект
                Object obj = constructor.newInstance();
                // Получить свойства класса
                Field[] fields = classObj.getDeclaredFields();
                // Прочитать параметры из файла properties
                Properties properties = readProperties();
                for (Field field : fields) {
                    if (field.isAnnotationPresent(Required.class)) {
                        // Получить метод сеттера для свойства
                        String methodName = "set" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1);
                        Method setMethod = classObj.getMethod(methodName, field.getType());
                        // Получить значение свойства из файла и преобразовать его к нужному типу
                        Object value = convert(properties.getProperty(classObj.getName() + "." + field.getName()), field.getType());
                        setMethod.invoke(obj, value);
                    }
                }
                return obj;
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    private static Properties readProperties() throws IOException {
        InputStream input = AnnotationApp.class.getClassLoader().getResourceAsStream("params.properties");
        Properties properties = new Properties();
        properties.load(input);
        return properties;
    }

    private static Object convert(String value, Class<?> type) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
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
