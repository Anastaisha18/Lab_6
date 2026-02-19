package lab6.ex;

import lab6.ann.Cache;

/**
 * Пример класса с аннотацией {@link Cache}, содержащей несколько кешируемых областей.
 * <p>
 * Демонстрирует использование аннотации @Cache с массивом значений.
 * </p>
 *
 * @author Student
 * @version 1.0
 * @since JDK 21
 * @see lab6.ann.Cache
 */
@Cache({"users", "products", "orders"})
public class CacheEx {

    /** Данные, которые могут кешироваться */
    private String data = "кешируемые данные";

    /**
     * Возвращает кешируемые данные.
     *
     * @return строка с данными
     */
    public String getData() {
        return data;
    }
}