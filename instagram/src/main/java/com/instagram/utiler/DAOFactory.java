package com.instagram.utiler;

import com.instagram.DAO.instagramDAO;
import com.instagram.DAO.instagramDAOInterface;

public class DAOFactory {

	private DAOFactory()
	{
		
	}
	
	public static instagramDAOInterface ii;
	
	public static instagramDAOInterface createObject()
	{
		if(ii==null)
		{
			ii=new instagramDAO();
		}
		return ii;
	}
}
