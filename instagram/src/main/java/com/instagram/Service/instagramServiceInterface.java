package com.instagram.Service;

import java.util.List;

import com.instagram.Entity.instaTimeLine;
import com.instagram.Entity.instagramUser;

public interface instagramServiceInterface {

	public instagramUser loginPageService(instagramUser iu);

	public int createProfileService(instagramUser iu);

	public int editProfileService(instagramUser iu,int echoice);

	public int deleteProfileService(instagramUser iu);

	public instagramUser viewProfileService(instagramUser iu);

	public List<instagramUser> searchProfileService(instagramUser iu, int echoice);

	public int timelineService(instaTimeLine it);

	public instagramUser createOtpService(instagramUser iu);

	public List<instagramUser> viewAllProfileService();

	public List<instaTimeLine> viewTimeLineService(instagramUser iu);



}
