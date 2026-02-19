package lab6.ann;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Аннотация {@code @Default} указывает класс по умолчанию для типа или поля.
 * <p>
 * Может использоваться для определения типа, который должен использоваться
 * по умолчанию при создании объектов или для валидации.
 * </p>
 *
 * <h2>Пример использования:</h2>
 * <pre>{@code
 * @Default(String.class)
 * public class Example {
 *     @Default(Integer.class)
 *     private Object value;
 * }
 * }</pre>
 *
 * @author Student
 * @version 1.0
 * @since JDK 21
 * @see lab6.proc.Processor#processDefault(Class)
 */
@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Default {

    /**
     * Класс, который должен использоваться по умолчанию.
     *
     * @return класс по умолчанию
     */
    Class<?> value();
}