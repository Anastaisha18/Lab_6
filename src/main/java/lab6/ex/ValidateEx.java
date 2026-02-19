package lab6.ex;

import lab6.ann.Validate;

/**
 * Пример класса с аннотацией {@link Validate}, содержащей список классов для валидации.
 * <p>
 * Демонстрирует использование @Validate с массивом классов.
 * </p>
 *
 * @author Student
 * @version 1.0
 * @since JDK 21
 * @see lab6.ann.Validate
 */
@Validate({String.class, Integer.class, Double.class, Boolean.class})
public class ValidateEx {

    /** Значение для валидации */
    private String value = "тест";

    /**
     * Возвращает значение для валидации.
     *
     * @return строка с значением
     */
    public String getValue() {
        return value;
    }

    /**
     * Устанавливает значение для валидации.
     *
     * @param value новое значение
     */
    public void setValue(String value) {
        this.value = value;
    }
}