package lab6.ex;

import lab6.ann.Invoke;

/**
 * Пример класса с методами, помеченными аннотацией {@link Invoke}.
 * <p>
 * Демонстрирует автоматический вызов методов с @Invoke.
 * </p>
 *
 * @author Student
 * @version 1.0
 * @since JDK 21
 * @see lab6.ann.Invoke
 */
public class InvokeEx {

    /**
     * Метод, который будет вызван автоматически (помечен @Invoke).
     */
    @Invoke
    public void start() {
        System.out.println("→ start() вызван автоматически");
    }

    /**
     * Метод, который будет вызван автоматически (помечен @Invoke).
     */
    @Invoke
    public void process() {
        System.out.println("→ process() вызван автоматически");
    }

    /**
     * Метод без аннотации @Invoke - не будет вызван автоматически.
     */
    public void stop() {
        System.out.println("→ stop() НЕ вызван (нет @Invoke)");
    }
}