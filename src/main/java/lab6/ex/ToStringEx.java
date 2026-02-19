package lab6.ex;

import lab6.ann.ToString;

/**
 * Пример класса с аннотацией {@link ToString} на классе и полях.
 * <p>
 * Демонстрирует фильтрацию полей при формировании строкового представления.
 * </p>
 *
 * @author Student
 * @version 1.0
 * @since JDK 21
 * @see lab6.ann.ToString
 */
@ToString
public class ToStringEx {

    /** Поле, которое должно включаться в toString (явно указано YES) */
    @ToString
    private String name = "Иван";

    /** Поле, которое не должно включаться в toString (явно указано NO) */
    @ToString(ToString.Mode.NO)
    private String password = "секрет";

    /** Поле без аннотации - наследует значение от класса (YES) */
    private int age = 25;

    /** Поле, которое должно включаться в toString (явно указано YES) */
    @ToString
    private boolean active = true;
}