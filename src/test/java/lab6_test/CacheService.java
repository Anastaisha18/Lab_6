package lab6_test;

/**
 * Интерфейс сервиса кеширования для тестирования аннотации {@link lab6.ann.Cache}.
 * <p>
 * Определяет базовые операции для работы с кешем: получение, сохранение и проверка наличия.
 * </p>
 *
 * @author Student
 * @version 1.0
 * @since JDK 21
 * @see lab6_test.CacheTest
 */
public interface CacheService {

    /**
     * Получает значение из кеша по ключу.
     *
     * @param key ключ для поиска
     * @return значение, соответствующее ключу, или null если не найдено
     */
    String get(String key);

    /**
     * Сохраняет значение в кеш по указанному ключу.
     *
     * @param key ключ для сохранения
     * @param value сохраняемое значение
     */
    void put(String key, String value);

    /**
     * Проверяет наличие ключа в кеше.
     *
     * @param key ключ для проверки
     * @return true если ключ существует в кеше, иначе false
     */
    boolean contains(String key);
}