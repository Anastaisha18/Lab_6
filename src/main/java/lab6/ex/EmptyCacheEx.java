package lab6.ex;

import lab6.ann.Cache;

/**
 * Пример класса с аннотацией {@link Cache} без указания областей кеширования.
 * <p>
 * Демонстрирует использование @Cache со значением по умолчанию (пустой массив).
 * </p>
 *
 * @author Student
 * @version 1.0
 * @since JDK 21
 * @see lab6.ann.Cache
 */
@Cache
public class EmptyCacheEx {

    /** Тестовые данные */
    private String data = "тест";

    /**
     * Возвращает тестовые данные.
     *
     * @return строка с данными
     */
    public String getData() {
        return data;
    }
}