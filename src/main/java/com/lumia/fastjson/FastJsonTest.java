package com.lumia.fastjson;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;

public class FastJsonTest {
	
	private static final Logger L = LoggerFactory.getLogger( FastJsonTest.class );

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Group group = new Group();
		group.setId(0L);
		group.setName("admin");

		User guestUser = new User();
		guestUser.setId(2L);
		guestUser.setName("guest");

		User rootUser = new User();
		rootUser.setId(3L);
		rootUser.setName("root");

		group.getUsers().add(guestUser);
		group.getUsers().add(rootUser);

		String jsonString = JSON.toJSONString(group);

		System.out.println(jsonString);
		
		String str = "{'id':0,'name':'admin','users':[{'id':2,'name':'guest'},{'id':3,'name':'root'}]}";
		Group group1 = JSON.parseObject(jsonString, Group.class);
	}

}
