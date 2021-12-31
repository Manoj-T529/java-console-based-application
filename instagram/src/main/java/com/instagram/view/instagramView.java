package com.instagram.view;
import java.io.IOException;
import java.util.*;
import java.util.logging.Logger;

import com.instagram.controller.instagramControllerInterface;
import com.instagram.utiler.controllerFactory;

public class instagramView {


	
	public static void main(String[] args)  {
		
		Logger log=Logger.getLogger("instagramView");
		
		Scanner s=new Scanner(System.in);

			
		System.out.println("\t\t\t\t\t\t\t<==================================================================================>");
		System.out.println();
		System.out.println( "\t\t\t\t\t\t\t\t\t\t\t INSTAGRAM HOME PAGE");
		System.out.println("");
		System.out.println("\t\t\t\t\t\t\t<===================================================================================>");
		
		
		instagramControllerInterface ic=controllerFactory.createObject();
		
		
		System.out.println();
		System.out.println();
		
		
		String strr;
		

				do
				{
				System.out.println("\t\t\t\t\t\t\t\t\t\t Don't have an account?Sign up!!");
				System.out.println("\t\t\t\t\t\t\t\t\t\t Have an account Login");
				System.out.println();
				System.out.println("**Enter 1 to Create Account**");
				System.out.println("**Enter 2 to Login**");
				
				int ch=s.nextInt();
				switch(ch)
				{
				
				case 1:int c=ic.createProfileController();
				if(c>0)
				{
					System.out.println("You Have Created Your Personal Account");
					
					int cc=ic.createOtpController();
					if(cc>0)
					{
						System.out.println();
						System.out.println("OTP Received");
					}
					else
					{
						System.out.println("Failed to Generate OTP");
					}
				}
				else
				{
					System.out.println("Account Creation Failed!!!");
				}
				break;
				
				case 2:	int c1=ic.loginPageController();
				if(c1>0)
				{
					String str;
					
					System.out.println("Login Successful");
					
					System.out.println("========>");
					System.out.println("========>");
					do
					{
					System.out.println(" 1. Enter 1 to Edit Profile");
					System.out.println(" 2. Enter 2 to Delete Profile");
					System.out.println(" 3. Enter 3 to View Profile");
					System.out.println(" 4. Enter 4 to Search Profile");
					System.out.println(" 5. Enter 5 to ViewAllProfile");
					System.out.println(" 6. Enter 6 to View TimeLine");
			

		
					int ch1=s.nextInt();
					
					switch(ch1)
					{
					
						case 1:int c2=ic.editProfileController();
							if(c2>0)
								{
									System.out.println("Profile Edited **See Updated Profile Using 3.ViewProfile");
								}
							else
								{
									System.out.println("Editing Failed");
								}
							break;
							
						case 2:int c3=ic.deleteProfileController();
							if(c3>0)
								{
									log.info(c3+" Profile Deleted");
								}
							else
								{
									System.out.println("Unable to Delete Your Profile");
								}
							break;
							
							
						case 3:int c4=ic.viewProfileController();
							if(c4>0)
								{
									log.info(c4+" Profile Viewed");
								}
							else
								{
									System.out.println("Not Able To View Your profile");
								}
							break;
							
							
						case 4:int c5=ic.searchProfileController();
						if(c5>0)
							{
								System.out.println("Search Completed");
							}
						else
							{
								System.out.println("Your Searches Have No Matches!!!");
							}
							break;
							
						case 5:int c6=ic.viewAllProfileController();
						if(c6>0)
						{
							log.info(c6+" Profiles Found");
							
							System.out.println();
							System.out.println();
							
							
							System.out.println("1. Enter 1 To Send Messages");
							
							int ch2=s.nextInt();
							String str1;
							
							do
							{
							switch(ch2)
							{
								case 1:int c7=ic.timelineController();
								
								if(c7>0)
								{
								System.out.println("Message Sent******TimeLine Is Accessible");
							
								}
								else
								{
								System.out.println("Can't Access Your TimeLine");
								}
								break;
																
								default:System.out.println("Please Select The Required Option");

							}
							System.out.println("Do You Want to Send Messages Again!  y/n");
							str1=s.next();
							
							}while(str1.equals("y"));
						}
						else
						{
							System.out.println("No Records Found");
						}
							break;
							
						case 6:int c8=ic.viewTimeLineController();
						
						if(c8>0)
						{
							System.out.println("TimeLine Details Showed");
						}
						else
						{
							System.out.println("Not Able to Show Your TimeLine Details");
						}
						break;

							
						default:System.out.println("Wrong Choice");
						}
					
					System.out.println();
					 System.out.println();
					 
					System.out.println("Do you want to Log Out y/n");
					str=s.next();
					}while(str.equals("n"));
					
				}
				
				else
				{
					System.out.println("Login Failed");
				}
				break;
				
				default:System.out.println("404 Error");
				}
				
				System.out.println();
				 System.out.println();
				 
				System.out.println("Do you Want To Go To CreateAccount/Login y/n");
				strr=s.next();
				
			}while(strr.equals("y"));

	}

}
