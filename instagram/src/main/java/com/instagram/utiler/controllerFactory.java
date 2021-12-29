package com.instagram.utiler;

import com.instagram.controller.instagramController;
import com.instagram.controller.instagramControllerInterface;

public class controllerFactory {

	private controllerFactory()
	{
		
	}
	
	public static instagramControllerInterface ii;
	
	public static instagramControllerInterface createObject()
	{
		if(ii==null)
		{
			ii=new instagramController();
		}
		
		return ii;
	}
	
}
