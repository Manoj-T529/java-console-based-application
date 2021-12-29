package com.instagram.utiler;

import com.instagram.Service.instagramService;
import com.instagram.Service.instagramServiceInterface;

public class serviceFactory {

	private serviceFactory()
	{
		
	}
	
	public  static instagramServiceInterface ii;
	
	public static instagramServiceInterface createObject()
	{
		if(ii==null)
		{
			ii=new instagramService();
		}
		return ii;
	}
}
