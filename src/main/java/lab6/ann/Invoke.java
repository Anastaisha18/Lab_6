package lab6.ann;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Аннотация {@code @Invoke} помечает методы, которые должны быть вызваны автоматически.
 * <p>
 * Используется для автоматического запуска методов инициализации,
 * обработки или других действий без явного вызова.
 * </p>
 *
 * <h2>Пример использования:</h2>
 * <pre>{@code
 * public class Application {
 *     @Invoke
 *     public void initialize() {
 *         System.out.println("Автоматический запуск");
 *     }
 * }
 * }</pre>
 *
 * @author Student
 * @version 1.0
 * @since JDK 21
 * @see lab6.proc.Processor#processInvoke(Object)
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Invoke {
}