package lab6.ann;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Аннотация {@code @Cache} предназначена для пометки классов, которые поддерживают кеширование.
 * <p>
 * Позволяет указать список областей (сущностей), которые должны кешироваться.
 * </p>
 *
 * <h2>Пример использования:</h2>
 * <pre>{@code
 * @Cache({"users", "products"})
 * public class UserService {
 *     // класс поддерживает кеширование users и products
 * }
 * }</pre>
 *
 * @author Student
 * @version 1.0
 * @since JDK 21
 * @see lab6.proc.Processor#processCache(Class)
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Cache {

    /**
     * Массив строк, определяющих области кеширования.
     * <p>
     * Каждая строка представляет собой имя кешируемой сущности
     * (например, "users", "products", "orders").
     * </p>
     *
     * @return массив имен кешируемых областей (по умолчанию пустой массив)
     */
    String[] value() default {};
}