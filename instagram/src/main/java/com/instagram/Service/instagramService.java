package com.instagram.Service;

import java.util.List;

import com.instagram.DAO.instagramDAOInterface;
import com.instagram.Entity.instaTimeLine;
import com.instagram.Entity.instagramUser;
import com.instagram.utiler.DAOFactory;
import com.instagram.utiler.serviceFactory;

public class instagramService implements instagramServiceInterface {
	
	

	@Override
	public int createProfileService(instagramUser iu) {
		
		instagramDAOInterface id=DAOFactory.createObject();
		
		return id.createProfileDAO(iu);
	}
	
	
	
	public instagramUser loginPageService(instagramUser iu) {
		
		instagramDAOInterface id=DAOFactory.createObject();
		
		return id.loginPageDAO(iu);
	}
	


	@Override
	public int editProfileService(instagramUser iu,int echoice) {
		
		instagramDAOInterface id=DAOFactory.createObject();
		
		return id.editProfileDAO(iu,echoice);
	}
	

	@Override
	public int deleteProfileService(instagramUser iu) {
	
		instagramDAOInterface id=DAOFactory.createObject();
		
		return id.deleteProfileDAO(iu);
	}
	

	@Override
	public instagramUser viewProfileService(instagramUser iu) {
		
		instagramDAOInterface id=DAOFactory.createObject();
		
		return id.viewProfileDAO(iu);
	}

	
	@Override
	public List<instagramUser> searchProfileService(instagramUser iu, int echoice) {
	
		instagramDAOInterface id=DAOFactory.createObject();
		
		return id.searchProfileDAO(iu,echoice);
	}

	@Override
	public int timelineService(instaTimeLine it) {
		
		instagramDAOInterface id=DAOFactory.createObject();
		
		return id.timelineDAO(it);
	}

	@Override
	public instagramUser createOtpService(instagramUser iu) {
	
		instagramDAOInterface id=DAOFactory.createObject();
		
		return id.createOtpDAO(iu);
	}

	@Override
	public List<instagramUser> viewAllProfileService() {
		
		instagramDAOInterface id=DAOFactory.createObject();
		
		return id.viewAllProfileDAO();
	}

	@Override
	public List<instaTimeLine> viewTimeLineService(instagramUser iu) {
		
		instagramDAOInterface id=DAOFactory.createObject();
		
		return id.viewTimeLineDAO(iu);
	}

	

}
