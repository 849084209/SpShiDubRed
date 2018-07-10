package top.bowenlee.notes.shiro.redis;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;

/**
 * 自定义缓存管理器
 * @author libowen1
 *
 */
public class CustomCacheManager implements CacheManager{
	@Override
	public <K, V> Cache<K, V> getCache(String name) throws CacheException {
		return new RedisCache<K, V>();
	}
}
