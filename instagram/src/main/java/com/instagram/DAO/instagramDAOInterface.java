package com.instagram.DAO;

import java.util.List;

import com.instagram.Entity.instaTimeLine;
import com.instagram.Entity.instagramUser;

public interface instagramDAOInterface {

	public instagramUser loginPageDAO(instagramUser iu);

	int createProfileDAO(instagramUser iu);

	int editProfileDAO(instagramUser iu,int echoice);

	int deleteProfileDAO(instagramUser iu);

	instagramUser viewProfileDAO(instagramUser iu);
	
	public List<instagramUser> searchProfileDAO(instagramUser iu, int echoice);


	public int timelineDAO(instaTimeLine iu);

	public instagramUser createOtpDAO(instagramUser iu);

	public List<instagramUser> viewAllProfileDAO();

	public List<instaTimeLine> viewTimeLineDAO(instagramUser iu);
}
