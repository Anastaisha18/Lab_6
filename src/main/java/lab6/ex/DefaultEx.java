package lab6.ex;

import lab6.ann.Default;

/**
 * Пример класса с аннотацией {@link Default} на классе и на поле.
 * <p>
 * Демонстрирует использование @Default для указания типов по умолчанию.
 * </p>
 *
 * @author Student
 * @version 1.0
 * @since JDK 21
 * @see lab6.ann.Default
 */
@Default(String.class)
public class DefaultEx {

    /** Поле с типом по умолчанию Integer */
    @Default(Integer.class)
    private Object data;

    /**
     * Конструктор по умолчанию, инициализирующий поле.
     */
    public DefaultEx() {
        this.data = "тестовые данные";
    }

    /**
     * Возвращает значение поля data.
     *
     * @return объект data
     */
    public Object getData() {
        return data;
    }

    /**
     * Устанавливает значение поля data.
     *
     * @param data новое значение
     */
    public void setData(Object data) {
        this.data = data;
    }
}