package lab6_test;

import lab6.ann.Default;
import lab6.ex.DefaultEx;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.lang.reflect.Field;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Тестовый класс для проверки аннотации {@link Default}.
 * <p>
 * Содержит тесты для проверки наличия аннотации на классе и поле,
 * проверки значений, работы с Reflection API и параметризованные тесты.
 * </p>
 *
 * @author Student
 * @version 1.0
 * @since JDK 21
 * @see lab6.ann.Default
 * @see lab6.ex.DefaultEx
 */
public class DefaultTest {

    /**
     * Тест 1: Проверка наличия аннотации на классе.
     * <p>
     * Ожидается, что класс DefaultEx имеет аннотацию @Default.
     * </p>
     */
    @Test
    public void testAnnotationPresentOnClass() {
        Default annotation = DefaultEx.class.getAnnotation(Default.class);
        assertNotNull(annotation, "Аннотация @Default должна быть на классе DefaultEx");
    }

    /**
     * Тест 2: Проверка значения свойства value на классе.
     * <p>
     * Ожидается, что значение равно String.class.
     * </p>
     */
    @Test
    public void testClassDefaultValue() {
        Default annotation = DefaultEx.class.getAnnotation(Default.class);
        assertEquals(String.class, annotation.value(), "Значение на классе должно быть String.class");
    }

    /**
     * Тест 3: Проверка наличия аннотации на поле.
     * <p>
     * Ожидается, что поле data имеет аннотацию @Default.
     * </p>
     *
     * @throws Exception если поле не найдено
     */
    @Test
    public void testAnnotationPresentOnField() throws Exception {
        Field field = DefaultEx.class.getDeclaredField("data");
        Default annotation = field.getAnnotation(Default.class);
        assertNotNull(annotation, "Аннотация @Default должна быть на поле data");
    }

    /**
     * Тест 4: Проверка значения свойства value на поле.
     * <p>
     * Ожидается, что значение равно Integer.class.
     * </p>
     *
     * @throws Exception если поле не найдено
     */
    @Test
    public void testFieldDefaultValue() throws Exception {
        Field field = DefaultEx.class.getDeclaredField("data");
        Default annotation = field.getAnnotation(Default.class);
        assertEquals(Integer.class, annotation.value(), "Значение на поле должно быть Integer.class");
    }

    /**
     * Тест 5: Проверка через Reflection API.
     * <p>
     * Проверяет, что объект аннотации является экземпляром Default.
     * </p>
     */
    @Test
    public void testReflection() {
        Default annotation = DefaultEx.class.getAnnotation(Default.class);
        assertTrue(annotation instanceof Default, "Объект должен быть экземпляром Default");
    }

    /**
     * Тест 6: Проверка создания объекта с аннотацией.
     * <p>
     * Проверяет, что объект создается и имеет правильное начальное значение.
     * </p>
     */
    @Test
    public void testObjectCreation() {
        DefaultEx obj = new DefaultEx();
        assertNotNull(obj, "Объект должен создаваться");
        assertEquals("тестовые данные", obj.getData(), "Начальное значение должно быть 'тестовые данные'");
    }

    /**
     * Параметризованный тест для проверки разных классов с аннотацией @Default.
     * <p>
     * Проверяет несколько тестовых классов с разными типами по умолчанию.
     * </p>
     *
     * @param testClass тестовый класс
     * @param expectedClass ожидаемый класс по умолчанию
     */
    @ParameterizedTest
    @MethodSource("provideTestClasses")
    public void testParameterizedDefault(Class<?> testClass, Class<?> expectedClass) {
        Default annotation = testClass.getAnnotation(Default.class);
        assertNotNull(annotation, "Аннотация должна присутствовать на " + testClass.getSimpleName());
        assertEquals(expectedClass, annotation.value(),
                "Неверное значение для " + testClass.getSimpleName());

        System.out.println("✓ Тест для " + testClass.getSimpleName() +
                ": ожидалось " + expectedClass.getSimpleName() +
                ", получено " + annotation.value().getSimpleName());
    }

    /**
     * Предоставляет данные для параметризованного теста.
     *
     * @return поток аргументов для теста
     */
    private static Stream<Arguments> provideTestClasses() {
        return Stream.of(
                Arguments.of(DefaultEx.class, String.class),
                Arguments.of(TestStringClass.class, String.class),
                Arguments.of(TestIntegerClass.class, Integer.class),
                Arguments.of(TestDoubleClass.class, Double.class),
                Arguments.of(TestBooleanClass.class, Boolean.class)
        );
    }

    /** Вспомогательный класс для тестирования с типом String */
    @Default(String.class)
    private static class TestStringClass {}

    /** Вспомогательный класс для тестирования с типом Integer */
    @Default(Integer.class)
    private static class TestIntegerClass {}

    /** Вспомогательный класс для тестирования с типом Double */
    @Default(Double.class)
    private static class TestDoubleClass {}

    /** Вспомогательный класс для тестирования с типом Boolean */
    @Default(Boolean.class)
    private static class TestBooleanClass {}
}