package com.subra.springcloudfoundry;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {
	Logger log = LoggerFactory.getLogger(BasicController.class);
	
	@Autowired
	StringRedisTemplate redisTemplate;
	
	@RequestMapping("/welcome")
	public String welcome(){
		String msg = "Welcome to Pivotal Cloud";
		log.info( msg);
		return msg;
	}
	
	@RequestMapping("/redis")
	public String redistry(){
		int hitCount = 0;
		ValueOperations<String, String> ops = redisTemplate.opsForValue();
		String key = "redis.counter";
		if(!redisTemplate.hasKey(key)){
			ops.set(key, Integer.toString(hitCount));
		}else{
			hitCount = Integer.parseInt(ops.get(key));
			hitCount++;
			ops.set(key, Integer.toString(hitCount));				
		}
		String totalHit = ops.get(key);
		log.info("Total hit count=" + totalHit );	
		return totalHit;
	}
	
	@GetMapping("/spin")
	public String spin() {//scaling
		for(int i=0; i< 1000; i++){
			log.info("Spin: " + i);
			for(int j=0; j<1000000; j++){
				double foo = 1.0 * 2.0 + 3000000.0/ 200004444.2001;
			}		
		}
		String msg = "return spin completed";
		log.info("Spin ends: " + msg);
		return msg;
	}
	@RequestMapping("/hibyname/{name}")
	public String welcomePersonate(@PathVariable("name") final String nameinpath){
		String msg = "Hi " + nameinpath  +  "! Welcome to Pivotal Cloud";
		log.info("welcomePersonate() " + msg);
		return msg;
	}

}
