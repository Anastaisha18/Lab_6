package lab6.ann;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Аннотация {@code @Validate} определяет список классов для валидации.
 * <p>
 * Указывает, какие типы должны использоваться при валидации данных класса.
 * </p>
 *
 * <h2>Пример использования:</h2>
 * <pre>{@code
 * @Validate({String.class, Integer.class, Email.class})
 * public class UserForm {
 *     // форма должна валидироваться с указанными валидаторами
 * }
 * }</pre>
 *
 * @author Student
 * @version 1.0
 * @since JDK 21
 * @see lab6.proc.Processor#processValidate(Class)
 */
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Validate {

    /**
     * Массив классов, которые будут использоваться для валидации.
     *
     * @return массив классов-валидаторов
     */
    Class<?>[] value();
}