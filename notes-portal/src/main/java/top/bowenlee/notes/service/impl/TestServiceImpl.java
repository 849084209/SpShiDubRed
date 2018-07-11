package top.bowenlee.notes.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import top.bowenlee.notes.service.TestService;

@SuppressWarnings("rawtypes")
@Service
public class TestServiceImpl implements TestService{
	
	@Autowired
	private RedisTemplate template;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<String> test(){
		Map<String,String> maps = new HashMap<String, String>();
        maps.put("multi1","multi1");
        maps.put("multi2","multi2");
        template.opsForValue().multiSet(maps);
        Map<String,String> maps2 = new HashMap<String, String>();
        maps2.put("multi3","multi3");
        template.opsForValue().multiSet(maps2);
        List<String> keys = new ArrayList<String>();
        keys.add("multi1");
        keys.add("multi2");
        keys.add("multi3");
        return template.opsForValue().multiGet(keys);
	}
}
