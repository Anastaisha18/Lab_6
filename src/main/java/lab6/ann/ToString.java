package lab6.ann;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Аннотация {@code @ToString} управляет включением полей в строковое представление объекта.
 * <p>
 * Позволяет указать, должно ли поле или все поля класса включаться
 * в результат метода toString().
 * </p>
 *
 * <h2>Пример использования:</h2>
 * <pre>{@code
 * @ToString
 * public class User {
 *     @ToString
 *     private String name;
 *
 *     @ToString(Mode.NO)
 *     private String password;
 * }
 * }</pre>
 *
 * @author Student
 * @version 1.0
 * @since JDK 21
 * @see lab6.proc.Processor#processToString(Object)
 */
@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ToString {

    /**
     * Режим включения поля в строковое представление.
     */
    enum Mode {
        /** Поле включается в строковое представление */
        YES,
        /** Поле не включается в строковое представление */
        NO
    }

    /**
     * Определяет, включать ли элемент в строковое представление.
     *
     * @return {@link Mode#YES} если включать, {@link Mode#NO} если не включать
     */
    Mode value() default Mode.YES;
}