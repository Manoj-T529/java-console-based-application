package com.instagram.utiler;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.instagram.controller.instagramControllerInterface;

public class ControllerTest {

	private instagramControllerInterface ii;
	
	@Before
	public void setUp() throws Exception {
		ii=controllerFactory.createObject();
	}

	@After
	public void tearDown() throws Exception {
		ii=null;
	}

	@Test
	public void testCreateProfileController() {
		
		int i=ii.createProfileController(); 
		
		assert i>0:"Profile Creation Failed";
	}

	@Test
	public void testLoginPageController() {
		
		int i=ii.loginPageController(); 
		
		assert i>0:"Login Failed";
	}

	@Test
	public void testEditProfileController() {
		
		int i=ii.editProfileController(); 
		
		assert i>0:"Editing Failed";
	}

	@Test
	public void testDeleteProfileController() {
		
		int i=ii.deleteProfileController(); 
		
		assert i>0:"Deletion Failed";
	}

	@Test
	public void testViewProfileController() {
		
		int i=ii.viewProfileController(); 
		
		assert i>0:"Your Profile is Missing";
	}

	@Test
	public void testCreateOtpController() {

		int i=ii.createOtpController(); 
		
		assert i>0:"OTP Generation Failed";
	}

	@Test
	public void testSearchProfileController() {
		
		int i=ii.searchProfileController(); 
		
		assert i>0:"Searching Failed";
	}

//	@Test
//	public void testTimelineController() {
//
//		int i=ii.timelineController(); 
//		
//		assert i>0:"TimeLine Not Found";
//	}

	@Test
	public void testViewAllProfileController() {
		
		int i=ii.viewAllProfileController(); 
		
		assert i>0:"No Records Found";
	}

}
