package com.instagram.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.instagram.Entity.instaTimeLine;
import com.instagram.Entity.instagramUser;

public class instagramDAO implements instagramDAOInterface {

	
	
	public instagramUser loginPageDAO(instagramUser iu) {
		
		instagramUser ii=null;
		
		 try {
			 Class.forName("oracle.jdbc.driver.OracleDriver");
			 
			 Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Manoj");
			 
			 PreparedStatement ps=con.prepareStatement("select name from instagramUser where email=? and password=?");
			 
			 ps.setString(1, iu.getEmail());
			 ps.setString(2, iu.getPassword());
			 
			 ResultSet res=ps.executeQuery();
			 
			 if(res.next())
			 {
				 ii=new instagramUser();
				 
				 ii.setName(res.getString("name"));
			 }
		 }
		 catch(ClassNotFoundException|SQLException e)
		 {
			 e.printStackTrace();
		 }
		return ii;
	}

	
	
	
	
	@Override
	public int createProfileDAO(instagramUser iu) {
		
			int i=0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Manoj");
			
			PreparedStatement ps=con.prepareStatement("insert into instagramUser(mobnum,email,name,password,address) values(?,?,?,?,?)");
			ps.setLong(1, iu.getMobile());
			ps.setString(2, iu.getEmail());
			ps.setString(3, iu.getName());
			ps.setString(4, iu.getPassword());
			ps.setString(5, iu.getAddress());
			
			 i=ps.executeUpdate();
			 
			
		}
		catch(ClassNotFoundException|SQLException e)
		{
			e.printStackTrace();
		}
		return i;
	}

	
	
	
	
	@Override
	public int editProfileDAO(instagramUser iu,int echoice) {
		
		int i=0;
		
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Manoj");
			PreparedStatement ps;
			
			if(echoice==1)
			{
			 ps=con.prepareStatement("update instagramUser set mobnum=? where email=?");
			ps.setLong(1, iu.getMobile());
			ps.setString(2, iu.getEmail());
			}
			else if(echoice==2)
			{	
				 ps=con.prepareStatement("update instagramUser set name=? where email=?");
				ps.setString(1, iu.getName());
				ps.setString(2, iu.getEmail());
			}
			else if(echoice==3)
			{
				 ps=con.prepareStatement("update instagramUser set password=? where email=?");
				ps.setString(1, iu.getPassword());
				ps.setString(2, iu.getEmail());
			}
			else if(echoice==4)
			{
				 ps=con.prepareStatement("update instagramUser set address=? where email=?");
				ps.setString(1, iu.getAddress());
				ps.setString(2, iu.getEmail());
			}
			else
			{
				ps=con.prepareStatement("update instagramUser set mobnum=?,name=?,password=?,address=? where email=?");
				ps.setLong(1, iu.getMobile());
				ps.setString(2, iu.getName());
				ps.setString(3, iu.getPassword());
				ps.setString(4, iu.getAddress());
				ps.setString(5, iu.getEmail());
			}
			
			i=ps.executeUpdate();
			
		}
		catch(ClassNotFoundException|SQLException e)
		{
			e.printStackTrace();
		}
		
		return i;
	}

	
	
	
	
	@Override
	public int deleteProfileDAO(instagramUser iu) {
		int i=0;
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Manoj");
			
			PreparedStatement ps=con.prepareStatement("delete from instagramUser where email=?");
			
			ps.setString(1, iu.getEmail());
			
			i=ps.executeUpdate();
		}
		catch(ClassNotFoundException|SQLException e)
		{
			e.printStackTrace();
		}
		
		return i;
	}

	
	
	
	
	@Override
	public instagramUser viewProfileDAO(instagramUser iu) {
		
		instagramUser ii=null;
		
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Manoj");
			
			PreparedStatement ps=con.prepareStatement("select * from instagramUser where email=?");
			ps.setString(1, iu.getEmail());
			
			ResultSet res=ps.executeQuery();
			
			if(res.next())
			{
				ii=new instagramUser();
				
				
				ii.setEmail(res.getString(2));
				ii.setName(res.getString(3));
				ii.setPassword(res.getString(4));
				ii.setAddress(res.getString(5));
				ii.setMobile(res.getLong(6));
			}
		}
		catch(ClassNotFoundException|SQLException e)
		{
			e.printStackTrace();
		}
		return ii;
	}

	
	@Override
	public instagramUser createOtpDAO(instagramUser iu) {
		
		instagramUser ii=null;
		
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Manoj");
			
			PreparedStatement ps=con.prepareStatement("select otp from instagramUser where mobnum=?");
			ps.setLong(1,iu.getMobile());
			
			ResultSet res=ps.executeQuery();
			
			if(res.next())
			{
				ii=new instagramUser();
				
				ii.setOtp(res.getLong(1));
				
			}
		}
		catch(ClassNotFoundException|SQLException e)
		{
			e.printStackTrace();
		}
		return ii;

	}

	
	
	
	
	@Override
	public List<instagramUser> searchProfileDAO(instagramUser iu, int echoice) {
		
		List<instagramUser> ii=new ArrayList<instagramUser>();
		
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Manoj");
			PreparedStatement ps;
			
			if(echoice==1)
			{
			 ps=con.prepareStatement("select email,name,address from instagramUser where name=?");
			 ps.setString(1, iu.getName());

			}
			else 
			{	
				 ps=con.prepareStatement("select email,name,address from instagramUser where address=?");
				 ps.setString(1, iu.getAddress());
			}
			
			
			ResultSet res=ps.executeQuery();
			
			while(res.next())
			{
				instagramUser i=new instagramUser();
				
				i.setEmail(res.getString("email"));
				i.setName(res.getString("name"));
				i.setAddress(res.getString("address"));
				
				ii.add(i);
			}
			
		}
		catch(ClassNotFoundException|SQLException e)
		{
			e.printStackTrace();
		}
		
		return ii;
	}

	
	
	
	
	
	@Override
	public int timelineDAO(instaTimeLine it) {
		
		int i=0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Manoj");
			
			PreparedStatement ps=con.prepareStatement("insert into instaTimeLine(sender,receiver,message,time,email) values(?,?,?,?,?)");
		
			ps.setString(1, it.getSender());
			ps.setString(2, it.getReceiver());
			ps.setString(3, it.getMessage());
			ps.setString(4, it.getTime());
			ps.setString(5, it.getEmail());
			
			 i=ps.executeUpdate();
			
		}
		catch(ClassNotFoundException|SQLException e)
		{
			e.printStackTrace();
		}
		
		return i;
	}





	@Override
	public List<instagramUser> viewAllProfileDAO() {
	
		List<instagramUser> ii=new ArrayList<instagramUser>();
		
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Manoj");
			PreparedStatement ps;
			
			
			
			 ps=con.prepareStatement("select * from instagramUser ");
			 

			
			
			
			ResultSet res=ps.executeQuery();
			
			while(res.next())
			{
				instagramUser i=new instagramUser();
				
				i.setOtp(res.getLong(1));
				i.setEmail(res.getString(2));
				i.setName(res.getString(3));
				i.setPassword(res.getString(4));
				i.setAddress(res.getString(5));
				i.setMobile((res.getLong(6)));
			
				
				ii.add(i);
			}
			
		}
		catch(ClassNotFoundException|SQLException e)
		{
			e.printStackTrace();
		}
		
		return ii;

	}





	@Override
	public List<instaTimeLine> viewTimeLineDAO(instagramUser iu) {
		
		List<instaTimeLine> ii=new ArrayList<instaTimeLine>();
		
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Manoj");
			PreparedStatement ps;
			
			
			
			 ps=con.prepareStatement("select * from instaTimeLine ");
			 

			
			
			
			ResultSet res=ps.executeQuery();
			
			while(res.next())
			{
				instaTimeLine i=new instaTimeLine();
				
				i.setSender(res.getString(1));
				i.setReceiver(res.getString(2));
				i.setMessage(res.getString(3));
				i.setTime(res.getString(4));
				i.setEmail(res.getString(5));
			
				
				ii.add(i);
			}
			
		}
		catch(ClassNotFoundException|SQLException e)
		{
			e.printStackTrace();
		}
		
		return ii;

	}






	

}
