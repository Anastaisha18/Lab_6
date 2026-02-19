package lab6_test;

import lab6.ann.Cache;
import lab6.ex.CacheEx;
import lab6.ex.EmptyCacheEx;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Тестовый класс для проверки аннотации {@link Cache}.
 * <p>
 * Содержит тесты для проверки считывания значений аннотации,
 * работы с моками и обработки пустого массива.
 * </p>
 *
 * @author Student
 * @version 1.0
 * @since JDK 21
 * @see lab6.ann.Cache
 * @see lab6.ex.CacheEx
 * @see lab6.ex.EmptyCacheEx
 */
@ExtendWith(MockitoExtension.class)
public class CacheTest {

    /** Мок-объект сервиса кеширования */
    @Mock
    private CacheService cacheService;

    /**
     * Тест проверяет корректность считывания значений аннотации {@code @Cache}.
     * <p>
     * Ожидается, что аннотация содержит массив из трех строк:
     * "users", "products", "orders".
     * </p>
     */
    @Test
    public void testCacheValues() {
        Cache cache = CacheEx.class.getAnnotation(Cache.class);
        assertNotNull(cache);

        String[] expected = {"users", "products", "orders"};
        assertArrayEquals(expected, cache.value());

        System.out.println("✓ testCacheValues: массив = [users, products, orders]");
    }

    /**
     * Тест проверяет обработку аннотации {@code @Cache} с пустым массивом.
     * <p>
     * Ожидается, что аннотация существует, но массив значений пуст.
     * </p>
     */
    @Test
    public void testEmptyCache() {
        Cache cache = EmptyCacheEx.class.getAnnotation(Cache.class);
        assertNotNull(cache);
        assertEquals(0, cache.value().length);

        System.out.println("✓ testEmptyCache: массив пустой");
    }

    /**
     * Тест проверяет работу с мок-объектом сервиса кеширования.
     * <p>
     * Использует Mockito для имитации поведения кеша и проверки вызовов методов.
     * </p>
     */
    @Test
    public void testCacheMock() {
        String key = "users";
        String value = "test_data";

        when(cacheService.get(key)).thenReturn(value);
        when(cacheService.contains(key)).thenReturn(true);

        assertEquals(value, cacheService.get(key));
        assertTrue(cacheService.contains(key));

        verify(cacheService, times(1)).get(key);
        verify(cacheService, times(1)).contains(key);

        System.out.println("✓ testCacheMock: мок-тест пройден");
    }

    /**
     * Тест проверяет наличие нескольких именованных областей кеширования.
     * <p>
     * Проверяет, что массив содержит все ожидаемые области.
     * </p>
     */
    @Test
    public void testMultipleRegions() {
        Cache cache = CacheEx.class.getAnnotation(Cache.class);
        String[] regions = cache.value();

        assertEquals(3, regions.length);
        assertTrue(contains(regions, "users"));
        assertTrue(contains(regions, "products"));
        assertTrue(contains(regions, "orders"));

        System.out.println("✓ testMultipleRegions: найдены users, products, orders");
    }

    /**
     * Вспомогательный метод для проверки наличия строки в массиве.
     *
     * @param array массив для проверки
     * @param value искомое значение
     * @return true если значение найдено, иначе false
     */
    private boolean contains(String[] array, String value) {
        for (String s : array) {
            if (s.equals(value)) return true;
        }
        return false;
    }
}
