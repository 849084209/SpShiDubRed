package com.wilmar.itm.web.shiro.redis;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;

import com.wilmar.itm.web.shiro.ByteSourceUtils;
import com.wilmar.itm.web.util.JedisClientSingle;

import redis.clients.jedis.Jedis;

public class RedisCache<K, V> implements Cache<K, V> {
	public String getKeyPrefix() {
		return keyPrefix;
	}

	public void setKeyPrefix(String keyPrefix) {
		this.keyPrefix = keyPrefix;
	}

	private String keyPrefix = "shiro_redis_session:";

	/**
	 * 获得byte[]型的key
	 * 
	 * @param key
	 * @return
	 */
	private byte[] getByteKey(Object key) {
		if (key instanceof String) {
			String preKey = this.keyPrefix + key;
			return preKey.getBytes();
		} else {
			return ByteSourceUtils.serialize(key);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object get(Object key) throws CacheException {

		byte[] bytes = getByteKey(key);
		byte[] value = JedisClientSingle.getJedis().get(bytes);
		if (value == null) {
			return null;
		}
		return ByteSourceUtils.unserialize(value);
	}

	/**
	 * 将shiro的缓存保存到redis中
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Object put(Object key, Object value) throws CacheException {
		Jedis jedis = JedisClientSingle.getJedis();
		jedis.set(ByteSourceUtils.serialize(key), ByteSourceUtils.serialize(value));
		return jedis.get(ByteSourceUtils.serialize(key));

	}

	@SuppressWarnings("unchecked")
	@Override
	public Object remove(Object key) throws CacheException {
		Jedis jedis = JedisClientSingle.getJedis();

		byte[] bytes = jedis.get(getByteKey(key));

		jedis.del(getByteKey(key));

		return ByteSourceUtils.unserialize(bytes);
	}

	/**
	 * 清空所有缓存
	 */
	@Override
	public void clear() throws CacheException {
		JedisClientSingle.getJedis().flushDB();
	}

	/**
	 * 缓存的个数
	 */
	@Override
	public int size() {
		Long size = JedisClientSingle.getJedis().dbSize();
		return size.intValue();
	}

	/**
	 * 获取所有的key
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Set keys() {
		Set<byte[]> keys = JedisClientSingle.getJedis().keys(new String("*").getBytes());
		Set<Object> set = new HashSet<Object>();
		for (byte[] bs : keys) {
			set.add(ByteSourceUtils.unserialize(bs));
		}
		return set;
	}

	/**
	 * 获取所有的value
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Collection values() {
		Set keys = this.keys();

		List<Object> values = new ArrayList<Object>();
		for (Object key : keys) {
			byte[] bytes = JedisClientSingle.getJedis().get(getByteKey(key));
			values.add(ByteSourceUtils.unserialize(bytes));
		}
		return values;
	}
}
