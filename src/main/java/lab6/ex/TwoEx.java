package lab6.ex;

import lab6.ann.Two;

/**
 * Пример класса с аннотацией {@link Two}, содержащей два обязательных свойства.
 * <p>
 * Демонстрирует использование @Two с строковым и числовым параметрами.
 * </p>
 *
 * @author Student
 * @version 1.0
 * @since JDK 21
 * @see lab6.ann.Two
 */
@Two(first = "Hello", second = 100)
public class TwoEx {

    /** Сообщение для демонстрации */
    private String message = "работает";

    /**
     * Возвращает сообщение.
     *
     * @return строка с сообщением
     */
    public String getMessage() {
        return message;
    }
}