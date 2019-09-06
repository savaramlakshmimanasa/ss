package com.BigBasket.dao;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;



import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.BigBasket.entity.BigBasketConsumer;

public class BigBasketDAO implements BigBasketDAOInterface
{
	
	private BigBasketDAO()
	{}

	public static BigBasketDAOInterface createDAOOject() {
		// TODO Auto-generated method stub
		return new BigBasketDAO();
	}

	@Override
	public int createDAOProfile(BigBasketConsumer bbc) {
		// TODO Auto-generated method stub
		
		int i=0;
		try {
			InitialContext ctx=new InitialContext();
			DataSource ds;
			ds=(DataSource)ctx.lookup("java:/zensar2");
			
			Connection con= ds.getConnection();
			
			PreparedStatement ps=con.prepareStatement("insert into BigBasketConsumer values(?,?,?,?)");
			ps.setString(1, bbc.getName());
			ps.setString(2, bbc.getMobileno());
			ps.setString(3, bbc.getEmail());
			ps.setString(4, bbc.getLocation());
			i=ps.executeUpdate();
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return i;
	}

}
