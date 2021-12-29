package com.instagram.controller;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
//import java.io.Console;
import java.util.*;
import java.util.logging.Logger;

import com.instagram.Entity.instaTimeLine;
import com.instagram.Entity.instagramUser;
import com.instagram.Service.instagramServiceInterface;
import com.instagram.utiler.serviceFactory;

public class instagramController implements instagramControllerInterface {

	
	Logger log=Logger.getLogger("instagramController");
	
		Scanner s=new Scanner(System.in);
		

	
	
	
	
	
	
	@Override
	public int createProfileController() {
		int i=0;
		long mobile=0;

		instagramUser iu=new instagramUser();
		instagramServiceInterface is=serviceFactory.createObject();
		
		System.out.println();
		log.info("<<=====================Creating A Profile=================>");
		System.out.println();
		System.out.println();
	
		do
		{
			
		System.out.println("Enter Your Mobile Number");
		 mobile=s.nextLong();
		if(((Long.toString(mobile)).length()>10) || ((Long.toString(mobile)).length()<10))
		{
			System.out.println("Please Enter the valid Mobile Number!!!");
		}
		}while(((Long.toString(mobile)).length()<10) || ((Long.toString(mobile)).length()>10));
		
		System.out.println("Enter Your Email Id");
		String email=s.next();
		
		System.out.println("Enter Your UserName");
		String name=s.next();
		
		System.out.println("Enter Your PassWord");
		String password=s.next();
		
		System.out.println("Enter Your Address");
		String address=s.next();
		System.out.println();
		System.out.println();
		
		iu.setMobile(mobile);
		iu.setEmail(email);
		iu.setName(name);
		iu.setPassword(password);
		iu.setAddress(address);
		
		 i=is.createProfileService(iu);
		
		return i;
	}
	
	
	
	
	public int loginPageController() {
		
		

		instagramUser iu=new instagramUser();
		instagramServiceInterface is=serviceFactory.createObject();
		
		System.out.println();
		log.info("<<=====================Login PAGE=================>");
		System.out.println();
		
		int i=0;
		System.out.println();
		System.out.println();
		System.out.println("Enter Your Email");
		String email=s.next();
		System.out.println("Enter Your Password");
		String password=s.next();
		System.out.println();
		System.out.println();
//		Console con=System.console();
//		char[] ch=con.readPassword(".");
//		String password=new String(ch);
		
		iu.setEmail(email);
		iu.setPassword(password);
		
		instagramUser in=is.loginPageService(iu);
		
		if(in != null)
		{
			log.info("Welcome "+in.getName());
			i++;				
		}
			
		
		return i;
	}




	@Override
	public int editProfileController() {
		
		

		instagramUser iu=new instagramUser();
		instagramServiceInterface is=serviceFactory.createObject();
		
		System.out.println();
		log.info("<<=====================Editing A Profile=================>");
		System.out.println();
		
		int i=0;
		
		System.out.println("Enter your Email id to Edit Your Profile");
		String email=s.next();
		
		iu.setEmail(email);
		
		String st;
		int echoice;
		do
		{
			System.out.println();
			System.out.println();
		System.out.println("Enter 1 to Edit your Mobile Number");
		System.out.println("Enter 2 to Edit your Username");
		System.out.println("Enter 3 to Edit your Password");
		System.out.println("Enter 4 to Edit your Address");
		System.out.println("Enter 5 to Edit Whole Details at a Time");
			
		 echoice=s.nextInt();
		 
		 System.out.println();
			System.out.println();
		
		switch(echoice)
		{
		case 1:
			long mobile=0;
			do
			{
				System.out.println();
				System.out.println();
				
				System.out.println("Enter Your Updated Mobile Number");
				 mobile=s.nextLong();
				
				if(((Long.toString(mobile)).length()>10) || ((Long.toString(mobile)).length()<10))
				{
					System.out.println("Please Enter the valid Mobile Number!!!");
				}
				
			}while(((Long.toString(mobile)).length()<10) || ((Long.toString(mobile)).length()>10));
			
				iu.setMobile(mobile);
				
			break;
			
		case 2:System.out.println("Enter the Updated Name");
				String name=s.next();
				iu.setName(name);
			break;
			
			
		case 3:System.out.println("Enter the Updated Password");
				String password=s.next();
				iu.setPassword(password);
			break;
			
			
		case 4:System.out.println("Enter the Updated Address");
				String address=s.next();
				iu.setAddress(address);
				System.out.println();
				System.out.println();
			break;
			
			
		case 5:log.info("Updating Whole Records");;


		do
		{
			System.out.println();
			System.out.println();
			
			System.out.println("Enter Your Updated Mobile Number");
			 mobile=s.nextLong();
			
			if(((Long.toString(mobile)).length()>10) || ((Long.toString(mobile)).length()<10))
			{
				System.out.println("Please Enter the valid Mobile Number!!!");
			}
			
		}while(((Long.toString(mobile)).length()<10) || ((Long.toString(mobile)).length()>10));
		
			iu.setMobile(mobile);
		
			System.out.println("Enter the Updated Name");
			String name1=s.next();
			iu.setName(name1);
			
			System.out.println("Enter the Updated Password");
			String password1=s.next();
			iu.setPassword(password1);

			System.out.println("Enter the Updated Address");
			String address1=s.next();
			iu.setAddress(address1);
		
		System.out.println();
		System.out.println();
		
		break;
		
		default:System.out.println("Wrong Choice!!!");
		}
		System.out.println("Do you Want to Continue Editing y/n");
		st=s.next();
		
		}while(st.equals("y"));
		
		i=is.editProfileService(iu,echoice);
		
		return i;
	}




	@Override
	public int deleteProfileController() {
		

		instagramUser iu=new instagramUser();
		instagramServiceInterface is=serviceFactory.createObject();
		
		System.out.println();
		log.info("<<=====================Deleting A Profile=================>");
		System.out.println();
		
		int i=0;
		
		System.out.println("Enter the Email Id of the Profile you want to Delete!!!");
		String email=s.next();
		
		iu.setEmail(email);
		
		i=is.deleteProfileService(iu);
		
		return i;
	}




	@Override
	public int viewProfileController() {
		

		instagramUser iu=new instagramUser();
		instagramServiceInterface is=serviceFactory.createObject();
		
		System.out.println();
		log.info("<<=====================To View Your Profile=================>");
		System.out.println();
		
		int i=0;
		instagramUser in;
		
		System.out.println("Enter Your Email Id to View Profile");
		String email=s.next();
		
		iu.setEmail(email);
		in=is.viewProfileService(iu);
		
		if(in !=null)
		{
			System.out.println();
			System.out.println();
			System.out.println("<<======================================================>>");
			System.out.println("   | 		Your Name is "+in.getName());
			System.out.println("   |		Your Email Id is "+in.getEmail());
			System.out.println("   | 		Your PassWord is "+in.getPassword());
			System.out.println("   | 		Your Address is "+in.getAddress());
			System.out.println("   | 		Your Mobile Number is "+in.getMobile());
			System.out.println("<<======================================================>>");
			System.out.println();
			System.out.println();
			i++;
		}
		
		return i;
	}

	@Override
	public int createOtpController() {
		

		instagramUser iu=new instagramUser();
		instagramServiceInterface is=serviceFactory.createObject();
		
		System.out.println();
		log.info("<<=====================For OTP Generation=================>");
		System.out.println();
		
		int i=0;
		
		instagramUser in;
		long mobile=0;
		
		System.out.println();
		System.out.println();
		do
		{
			System.out.println();
			System.out.println();
			
			System.out.println("Enter Your Mobile Number to verify");
			 mobile=s.nextLong();
			
			if(((Long.toString(mobile)).length()>10) || ((Long.toString(mobile)).length()<10))
			{
				System.out.println("Please Enter the valid Mobile Number!!!");
			}
			
		}while(((Long.toString(mobile)).length()<10) || ((Long.toString(mobile)).length()>10));
	
		
		
		iu.setMobile(mobile);
		
		 in=is.createOtpService(iu);
		 
		 if(in != null)
		 {
			 System.out.println();
			 System.out.println();
			 System.out.println("Your OTP is "+in.getOtp());
			 System.out.println();
			 System.out.println();
			 
			 i++;
		 }
		 
		return i;
	}


	@Override
	public int searchProfileController() {
		
		

		instagramUser iu=new instagramUser();
		instagramServiceInterface is=serviceFactory.createObject();
		
		System.out.println();
		log.info("<<=====================For Searching A Profile=================>");
		System.out.println();
		
		int i=0;
		String st;
		
		int echoice;
		do
		{
		System.out.println("Enter 1 to Search Using UserName");
		System.out.println("Enter 2 to Search Using City");
		
		 echoice=s.nextInt();
		s.nextLine();
		switch(echoice)
		{
		case 1:System.out.println("Enter the Name You Want to Search");
				String name=s.next();
				iu.setName(name);
				
				List<instagramUser> in=is.searchProfileService(iu,echoice);
				
				for(instagramUser ins:in)
				{
					System.out.println();
					System.out.println();
					System.out.println("<<======================================================>>");
					System.out.println("   | 		Your Name is "+ins.getName());
					System.out.println("   |		Your Email Id is "+ins.getEmail());
					System.out.println("   | 		Your Address is "+ins.getAddress());
					System.out.println("<<======================================================>>");
					System.out.println();
					System.out.println();
					i++;
				}
				log.info("Totally "+i+" Found");
			break;
		case 2:System.out.println("Enter the City You Want to Search");
				String address=s.next();
				iu.setAddress(address);
				
				List<instagramUser> ins=is.searchProfileService(iu,echoice);
				
				for(instagramUser inst:ins)
				{
					System.out.println();
					System.out.println();
					System.out.println("<<======================================================>>");
					System.out.println("   | 		Your Name is "+inst.getName());
					System.out.println("   |		Your Email Id is "+inst.getEmail());
					System.out.println("   | 		Your Address is "+inst.getAddress());
					System.out.println("<<======================================================>>");
					System.out.println();
					System.out.println();
					i++;
				}
				System.out.println("Totally "+i+"Found");
			break;
		default:System.out.println("Wrong Choice!!!");
		}
		System.out.println("Do you Want to Continue Searching y/n");
		st=s.next();
		
		}while(st.equals("y"));
		
		
		
		
		return i;
	}




	@Override
	public int timelineController() {
		
		

		instagramUser iu=new instagramUser();
		instagramServiceInterface is=serviceFactory.createObject();
		instaTimeLine it=new instaTimeLine();
		
		System.out.println();
		log.info("<<=====================To View TimeLine=================>");
		System.out.println();
		
		
		
		System.out.println();
		System.out.println();
		System.out.println("Enter Your MailId");
		String email=s.next();
		System.out.println("Enter the name of Sender");
		String sender=s.next();
		System.out.println("Enter the name of Receiver ");
		String receiver=s.next();
		System.out.println("Enter Your message");
		String message=s.next();
		
		
//		  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MM dd");
//		  
//		  LocalDate date = LocalDate.now();
//		  
//		  String text = date.format(formatter);
//		  LocalDate parsedDate = LocalDate.parse(text, formatter);
		  
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime currentTime = LocalDateTime.now();
		String dateString;
		dateString = dtf.format(currentTime).toString();
	//	it.setTime(dateString.substring(dateString.indexOf(" ")));
		
		  
		System.out.println();
		System.out.println();
		
			it.setSender(sender);
			it.setReceiver(receiver);
			it.setMessage(message);
			it.setTime(dateString.substring(dateString.indexOf(" ")));
			it.setEmail(email);
			
		int i=is.timelineService(it);
		
		return i;
	}




	@Override
	public int viewAllProfileController() {
		

		
		instagramServiceInterface is=serviceFactory.createObject();
		instaTimeLine it=new instaTimeLine();
		
		System.out.println();
		log.info("<<=====================To View Every Records in a Database=================>");
		System.out.println();
	
		int i=0;
		
		List<instagramUser> in=is.viewAllProfileService();
		
		for(instagramUser ins:in)
		{
			System.out.println();
			System.out.println();
			System.out.println("<<======================================================>>");
			System.out.println("   | 		Your Name is "+ins.getName());
			System.out.println("   |		Your Email Id is "+ins.getEmail());
			System.out.println("   | 		Your Address is "+ins.getAddress());
			System.out.println("   | 		Your Address is "+ins.getMobile());
			System.out.println("<<======================================================>>");
			System.out.println();
			System.out.println();
			i++;
		}
		
		
		return i;
	}




	@Override
	public int viewTimeLineController() {
		
		

		instagramUser iu=new instagramUser();
		instagramServiceInterface is=serviceFactory.createObject();
		
		
		System.out.println();
		log.info("<<=====================To View TimeLine=================>");
		System.out.println();
	
		int i=0;
		
		List<instaTimeLine> in=is.viewTimeLineService(iu);
		
		for(instaTimeLine ins:in)
		{
			System.out.println();
			System.out.println();
			System.out.println("<<======================================================>>");
			System.out.println("   | 		Sender is: "+ins.getSender());
			System.out.println("   |		Receiver is: "+ins.getReceiver());
			System.out.println("   | 		 Message is: "+ins.getMessage());
			System.out.println("   | 		Message Time is: "+ins.getTime());
			System.out.println("<<======================================================>>");
			System.out.println();
			System.out.println();
			i++;
		}
		
		return i;
	}




	


	

}
