package club.codezp.index;

/**
 * 索引接口，增、删、改、查
 */
public interface IndexAware<K, V> {

    /**
     * 获得索引
     * @param key
     * @return
     */
    V get(K key);

    /**
     * 添加索引
     * @param key
     * @param value
     */
    void add(K key, V value);

    /**
     * 更新索引
     * @param key
     * @param value
     */
    void update(K key, V value);

    /**
     * 删除索引
     * @param key
     * @param value
     */
    void delete(K key, V value);
}
