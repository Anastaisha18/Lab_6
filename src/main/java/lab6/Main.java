package lab6;

import lab6.ex.*;
import lab6.proc.Processor;

/**
 * Главный класс для демонстрации работы всех аннотаций и их обработчиков.
 * <p>
 * Создает объекты всех классов-примеров и запускает обработчики аннотаций
 * для демонстрации их функциональности.
 * </p>
 *
 * @author Student
 * @version 1.0
 * @since JDK 21
 * @see lab6.proc.Processor
 * @see lab6.ex.InvokeEx
 * @see lab6.ex.DefaultEx
 * @see lab6.ex.ToStringEx
 * @see lab6.ex.ValidateEx
 * @see lab6.ex.TwoEx
 * @see lab6.ex.CacheEx
 * @see lab6.ex.EmptyCacheEx
 */
public class Main {

    /**
     * Главный метод программы.
     * <p>
     * Демонстрирует работу всех аннотаций и их обработчиков.
     * Создает объекты всех классов-примеров и передает их в {@link Processor#processAll}.
     * </p>
     *
     * @param args аргументы командной строки (не используются)
     */
    public static void main(String[] args) {
        System.out.println("ЛАБОРАТОРНАЯ РАБОТА №6 - АННОТАЦИИ");

        try {
            // Создание объектов для демонстрации
            InvokeEx invokeEx = new InvokeEx();
            DefaultEx defaultEx = new DefaultEx();
            ToStringEx toStringEx = new ToStringEx();
            ValidateEx validateEx = new ValidateEx();
            TwoEx twoEx = new TwoEx();
            CacheEx cacheEx = new CacheEx();
            EmptyCacheEx emptyCacheEx = new EmptyCacheEx();

            // Демонстрация работы всех обработчиков
            Processor.processAll(
                    invokeEx, defaultEx, toStringEx,
                    validateEx, twoEx, cacheEx, emptyCacheEx
            );

        } catch (Exception e) {
            System.err.println("Ошибка: " + e.getMessage());
            e.printStackTrace();
        }
    }
}