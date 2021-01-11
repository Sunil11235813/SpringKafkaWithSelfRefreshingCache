package com.example.demo.config;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

@Component
public class NodeTypeCache {
	private Map<String,String> cache;
	
	private Map<String, String> createFreshCache() throws Exception {
	    Map<String, String> map = new HashMap<>();
	    
	    DefaultHttpClient httpClient = new DefaultHttpClient();
	   
	        
	        HttpGet getRequest = new HttpGet("https://api.printful.com/countries");	        
	        getRequest.addHeader("accept", "application/json");        
	        HttpResponse response = httpClient.execute(getRequest);
	        HttpEntity httpEntity = response.getEntity();
	        String apiOutput = EntityUtils.toString(httpEntity);	        
	        System.out.println(apiOutput);	    
	        map.put("2240", "DC");
	        map.put("2240", "DC");
	   
	    return map;
	}
	
	    @PostConstruct
	    private void populateCache() throws Exception{
	        cache = createFreshCache();
	    }
	    
	    public String getData(String key){
	        return cache.get(key);
	    }
	    
	    public String setData(final String key, final String value){
	        return cache.put(key, value);
	    }

}
