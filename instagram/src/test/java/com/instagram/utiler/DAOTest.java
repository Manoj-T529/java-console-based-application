package com.instagram.utiler;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.instagram.DAO.instagramDAOInterface;
import com.instagram.Entity.instagramUser;
import com.instagram.Service.instagramServiceInterface;

public class DAOTest {

	private instagramDAOInterface ii;
	
	@Before
	public void setUp() throws Exception {
		ii=DAOFactory.createObject();
	}

	@After
	public void tearDown() throws Exception {
		ii=null;
	}

	@Test
	public void testLoginPageDAO() {
		
		instagramUser iu=new instagramUser();
		
		iu.setEmail("W@gmail.com");
		iu.setPassword("W@1");
		
		instagramUser i=ii.loginPageDAO(iu);
		
		assert i != null: "Login Failed";
	}

//	@Test
//	public void testCreateProfileDAO() {
//		instagramUser iu=new instagramUser();
//		
//		iu.setMobile(1234567811);
//		iu.setName("BBC");
//		iu.setEmail("BBC@gmail.com");
//		iu.setPassword("BBC@1");
//		iu.setAddress("chennai");
//		
//		
//		int i=ii.createProfileDAO(iu);
//		
//		assert i>0: "Profile Creation Failed";
//	}

	
	@Test
	public void testEditProfileDAO() {
		
		instagramUser iu=new instagramUser();
		int echoice=0;
		
		if(echoice==1)
		{
			iu.setMobile(1234567890);
			iu.setEmail("JJ@g");
		}
		else if(echoice==2)
		{	
		
					iu.setName("JJ");
					iu.setEmail("JJ@g");
		}
 	else if(echoice==3)
		{	
			
			 iu.setPassword("2356");
			 iu.setEmail("JJ@g");
		}
		else if(echoice==4)
		{
			 iu.setAddress("chennai");
			 iu.setEmail("JJ@");
		}
	else
	{
		iu.setMobile(1234567890);
		iu.setName("JJ");
		iu.setPassword("2356");
		 iu.setAddress("chennai");
		 iu.setEmail("JJ@g");
	}
		int i=ii.editProfileDAO(iu, echoice);
		
		assert i>0: "Editing Failed";
	}

//	@Test
//	public void testDeleteProfileDAO() {
//		
//		instagramUser iu=new instagramUser();
//		
//		iu.setEmail("BBC@gmail.com");
//		
//		int i=ii.deleteProfileDAO(iu); 
//		
//		assert i>0: "Deletion Failed";
//	}

	@Test
	public void testViewProfileDAO() {
		
		instagramUser iu=new instagramUser();
		
		iu.setEmail("JJ@g");
		
		instagramUser i=ii.viewProfileDAO(iu);
	
		assert i != null: "No Records";
	}

	@Test
	public void testCreateOtpDAO() {
		
		instagramUser iu=new instagramUser();
		
		iu.setMobile(1234567890);
		
		instagramUser i=ii.createOtpDAO(iu);
		
		assert i != null: "OTP Generation Failed";
	}


	@Test
	public void testSearchProfileDAO() {
		
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
		
		List<instagramUser> i=ii.searchProfileDAO(iu,echoice);
		
		assert i != null : "Searching Failed";
	}


	@Test
	public void testViewAllProfileDAO() {
		
		
		List<instagramUser> i=ii.viewAllProfileDAO();
	
		
		assert i != null: "No Records Found";
	}

}
