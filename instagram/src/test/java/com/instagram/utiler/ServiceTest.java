package com.instagram.utiler;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.instagram.Entity.instagramUser;
import com.instagram.Service.instagramServiceInterface;

public class ServiceTest {

	private instagramServiceInterface ii;
	
	@Before
	public void setUp() throws Exception {
		
		ii=serviceFactory.createObject();
	}
	

	@After
	public void tearDown() throws Exception {
		ii=null;
	}

	@Test
	public void testCreateProfileService() {

		instagramUser iu=new instagramUser();
		

		iu.setMobile(1234567890);
		iu.setName("ABC");
		iu.setEmail("ABC@gmail.com");
		iu.setPassword("ABC@1");
		iu.setAddress("chennai");
		
		
		int i=ii.createProfileService(iu);
		
		assert i>0: "Profile Creation Failed";
	}

	@Test
	public void testLoginPageService() {
		
		instagramUser iu=new instagramUser();
		
		iu.setEmail("K@g");
		iu.setPassword("1234");
		
		instagramUser i=ii.loginPageService(iu);
		
		assert i != null: "Login Failed";
	}

	@Test
	public void testEditProfileService() {
		instagramUser iu=new instagramUser();
		int echoice=0;
		
		if(echoice==1)
		{
			iu.setMobile(1234567890);
			iu.setEmail("I@gmail.com");
		}
		else if(echoice==2)
		{	
			
					iu.setName("II");
					iu.setEmail("I@gmail.com");
		}
		else if(echoice==3)
		{	
			
			 iu.setPassword("I@1");
			 iu.setEmail("I@gmail.com");
		}
		else if(echoice==4)
		{
			 iu.setAddress("chennai");
			 iu.setEmail("I@gmail.com");
			 

		}
		else
		{
			iu.setMobile(1234567890);
			iu.setName("II");
			iu.setPassword("I@1");
			 iu.setAddress("chennai");
			 iu.setEmail("I@gmail.com");
		}
		int i=ii.editProfileService(iu, echoice);
		
		assert i>0: "Editing Failed";
	}

	@Test
	public void testDeleteProfileService() {
		
		instagramUser iu=new instagramUser();
		
		iu.setEmail("ABC@gmail.com");
		
		int i=ii.deleteProfileService(iu); 
		
		assert i>0: "Deletion Failed";
	}

	@Test
	public void testViewProfileService() {

		instagramUser iu=new instagramUser();
		
		iu.setEmail("I@gmail.com");
		
		instagramUser i=ii.viewProfileService(iu);
	
		assert i != null: "No Records";
	}

	@Test
	public void testSearchProfileService() {
		
		instagramUser iu=new instagramUser();
		int echoice=0;
		
		if(echoice==1)
		{
		iu.setName("ABC");
		}
		else
		{
			iu.setAddress("chennai");
		}
		
		List<instagramUser> i=ii.searchProfileService(iu,echoice);
		
		assert i != null : "Searching Failed";
	}
//
//	@Test
//	public void testTimelineService() {
//	
//		
//	}

	@Test
	public void testCreateOtpService() {
	
		instagramUser iu=new instagramUser();
		
		iu.setMobile(1234567890);
		
		instagramUser i=ii.createOtpService(iu);
		
		assert i != null: "OTP Generation Failed";
	}

	@Test
	public void testViewAllProfileService() {
	
		List<instagramUser> i=ii.viewAllProfileService();
	
		
		assert i != null: "No Records Found";
	}

}
