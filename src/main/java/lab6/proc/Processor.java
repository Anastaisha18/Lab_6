package lab6.proc;

import lab6.ann.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Обработчик аннотаций, реализующий логику работы с пользовательскими аннотациями.
 * <p>
 * Содержит статические методы для обработки каждой аннотации:
 * {@link Invoke}, {@link Default}, {@link ToString}, {@link Validate}, {@link Two}, {@link Cache}.
 * </p>
 *
 * @author Student
 * @version 1.0
 * @since JDK 21
 */
public class Processor {

    /**
     * Обрабатывает аннотацию {@link Invoke} - вызывает все методы с этой аннотацией.
     * <p>
     * Метод использует Reflection API для поиска и вызова методов,
     * помеченных {@code @Invoke}, даже если они приватные.
     * </p>
     *
     * @param obj объект, методы которого нужно вызвать
     * @throws Exception если возникнет ошибка при вызове метода
     * @see Invoke
     */
    public static void processInvoke(Object obj) throws Exception {
        Class<?> clazz = obj.getClass();
        Method[] methods = clazz.getDeclaredMethods();

        boolean found = false;
        for (Method method : methods) {
            if (method.isAnnotationPresent(Invoke.class)) {
                method.setAccessible(true);
                method.invoke(obj);
                System.out.println("  Вызван метод: " + method.getName());
            }
        }
    }

    /**
     * Обрабатывает аннотацию {@link Default} - выводит классы по умолчанию.
     * <p>
     * Анализирует класс и его поля на наличие аннотации {@code @Default}
     * и выводит указанные классы.
     * </p>
     *
     * @param clazz класс для анализа
     * @see Default
     */
    public static void processDefault(Class<?> clazz) {
        boolean hasDefaultOnClass = clazz.isAnnotationPresent(Default.class);
        boolean hasDefaultOnField = false;

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Default.class)) {
                hasDefaultOnField = true;
                break;
            }
        }

        if (!hasDefaultOnClass && !hasDefaultOnField) {
            return; // Нет аннотации @Default - ничего не выводим
        }

        System.out.println("\nАнализ @Default в " + clazz.getSimpleName());

        if (hasDefaultOnClass) {
            Default annotation = clazz.getAnnotation(Default.class);
            System.out.println("  Класс: значение по умолчанию = " + annotation.value().getSimpleName());
        }

        for (Field field : fields) {
            if (field.isAnnotationPresent(Default.class)) {
                Default annotation = field.getAnnotation(Default.class);
                System.out.println("  Поле '" + field.getName() + "': значение = " + annotation.value().getSimpleName());
            }
        }
    }

    /**
     * Обрабатывает аннотацию {@link ToString} - создает строковое представление объекта.
     * <p>
     * Формирует строку вида "ИмяКласса{поле1=значение1, поле2=значение2}",
     * включая только те поля, для которых {@code @ToString} имеет значение YES.
     * </p>
     *
     * @param obj объект для преобразования
     * @return строковое представление объекта
     * @throws IllegalAccessException если нет доступа к полям
     * @see ToString
     */
    public static String processToString(Object obj) throws IllegalAccessException {
        Class<?> clazz = obj.getClass();
        StringBuilder result = new StringBuilder(clazz.getSimpleName() + "{");

        boolean classInclude = false;
        if (clazz.isAnnotationPresent(ToString.class)) {
            ToString annotation = clazz.getAnnotation(ToString.class);
            classInclude = (annotation.value() == ToString.Mode.YES);
        }

        List<String> parts = new ArrayList<>();
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            Object value = field.get(obj);

            boolean include = false;

            if (field.isAnnotationPresent(ToString.class)) {
                ToString annotation = field.getAnnotation(ToString.class);
                include = (annotation.value() == ToString.Mode.YES);
            } else {
                include = classInclude;
            }

            if (include) {
                parts.add(field.getName() + "=" + value);
            }
        }

        result.append(String.join(", ", parts));
        result.append("}");
        return result.toString();
    }

    /**
     * Обрабатывает аннотацию {@link Validate} - выводит список классов для валидации.
     *
     * @param clazz класс для анализа
     * @see Validate
     */
    public static void processValidate(Class<?> clazz) {
        if (!clazz.isAnnotationPresent(Validate.class)) {
            return; // Нет аннотации @Validate - ничего не выводим
        }

        System.out.println("\nАнализ @Validate в " + clazz.getSimpleName());

        Validate annotation = clazz.getAnnotation(Validate.class);
        Class<?>[] classes = annotation.value();

        System.out.print("  Классы для валидации: ");
        for (Class<?> c : classes) {
            System.out.print(c.getSimpleName() + " ");
        }
        System.out.println();
    }

    /**
     * Обрабатывает аннотацию {@link Two} - выводит значения свойств first и second.
     *
     * @param clazz класс для анализа
     * @see Two
     */
    public static void processTwo(Class<?> clazz) {
        if (!clazz.isAnnotationPresent(Two.class)) {
            return; // Нет аннотации @Two - ничего не выводим
        }

        System.out.println("\nАнализ @Two в " + clazz.getSimpleName());

        Two annotation = clazz.getAnnotation(Two.class);
        System.out.println("  first = \"" + annotation.first() + "\", second = " + annotation.second());
    }

    /**
     * Обрабатывает аннотацию {@link Cache} - выводит список кешируемых областей.
     *
     * @param clazz класс для анализа
     * @see Cache
     */
    public static void processCache(Class<?> clazz) {
        if (!clazz.isAnnotationPresent(Cache.class)) {
            return; // Нет аннотации @Cache - ничего не выводим
        }

        System.out.println("\nАнализ @Cache в " + clazz.getSimpleName());

        Cache annotation = clazz.getAnnotation(Cache.class);
        String[] caches = annotation.value();

        if (caches.length == 0) {
            System.out.println("  Список кешируемых областей пуст");
        } else {
            System.out.print("  Кешируемые области: ");
            for (String cache : caches) {
                System.out.print(cache + " ");
            }
            System.out.println();
        }
    }

    /**
     * Запускает все обработчики для массива объектов.
     * <p>
     * Последовательно применяет все методы обработки к каждому объекту.
     * </p>
     *
     * @param objects массив объектов для обработки
     * @throws Exception если возникнет ошибка при обработке
     */
    public static void processAll(Object... objects) throws Exception {
        System.out.println("ЛАБОРАТОРНАЯ РАБОТА №6 - АННОТАЦИИ");
        System.out.println("ЗАПУСК ОБРАБОТЧИКОВ АННОТАЦИЙ\n");

        for (Object obj : objects) {
            System.out.println("--- Обработка объекта: " + obj.getClass().getSimpleName() + " ---");

            // @Invoke
            try {
                processInvoke(obj);
            } catch (Exception e) {
                System.err.println("Ошибка при processInvoke: " + e.getMessage());
            }

            // @ToString - ТОЛЬКО для ToStringEx
            if (obj instanceof ToStringEx) {
                try {
                    String str = processToString(obj);
                    System.out.println("  toString: " + str);
                } catch (Exception e) {
                    System.err.println("Ошибка при processToString: " + e.getMessage());
                }
            }

            // Обработка остальных аннотаций
            Class<?> clazz = obj.getClass();
            processDefault(clazz);
            processValidate(clazz);
            processTwo(clazz);
            processCache(clazz);

            System.out.println();
        }
        System.out.println("ОБРАБОТКА ЗАВЕРШЕНА");
    }
}

