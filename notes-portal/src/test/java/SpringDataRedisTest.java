

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import redis.clients.jedis.Jedis;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:spring/spring-dao-test.xml")
public class SpringDataRedisTest {

	protected final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private RedisTemplate<String, Object> template;

	@Test
	public void testFirst() {
		try {
			template.opsForValue().set("username", "wlwlwlwl015");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			logger.info("username:{}", template.opsForValue().get("username"));
		}
	}

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Jedis jedis = new Jedis("95.163.202.156", 6379);
		System.out.println("连接成功" + jedis.toString());
		System.out.println("服务正在运行: " + jedis.ping());
	}
}