package lab6.ann;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Аннотация {@code @Two} содержит два обязательных свойства для конфигурации класса.
 * <p>
 * Используется для передачи пары "строка-число" в класс для настройки его поведения.
 * </p>
 *
 * <h2>Пример использования:</h2>
 * <pre>{@code
 * @Two(first = "timeout", second = 5000)
 * public class Connection {
 *     // класс использует таймаут 5000 мс
 * }
 * }</pre>
 *
 * @author Student
 * @version 1.0
 * @since JDK 21
 * @see lab6.proc.Processor#processTwo(Class)
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Two {

    /**
     * Строковое свойство аннотации.
     *
     * @return строковое значение
     */
    String first();

    /**
     * Числовое свойство аннотации.
     *
     * @return целочисленное значение
     */
    int second();
}