package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.ReceivedDao;
import model.Received;
import util.DbConnection;

public class ReceivedDaoImpl implements ReceivedDao{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		  // add 
			Received received = new Received("2025/02/11", "I009", "F008", 50);
			new ReceivedDaoImpl().add(received);
			received = new Received("2025/02/11", "I008", "F008", 50);
			new ReceivedDaoImpl().add(received);
			received = new Received("2025/02/11", "I007", "F006", 35);
			new ReceivedDaoImpl().add(received);
		*/
		
		/*
		//list all item	
			List<Received> listItem=new ReceivedDaoImpl().selectAll();
			for(Received oneItem:listItem)
			{
				System.out.println(oneItem.getId()+"\t"+oneItem.getIndate()+"\t"+oneItem.getItemno()+
							"\t"+oneItem.getFactoryno()+"\t"+oneItem.getInqty());
			}
			*/
		
			// result
			/*
			 * 	1	2025/02/12	I003	F003	50
				2	2025/02/12	I004	F003	50
				3	2025/02/12	I005	F004	35
			 * 
			 */
		/*
			// find received by id
					System.out.println(new ReceivedDaoImpl().selectById(1));
			// result:  [model.Received@1a04f701]
		 */
		
		//System.out.println(new ReceivedDaoImpl().orderbyItemno("2025/02/11", "2025/02/12"));
		//new ReceivedDaoImpl().orderbyItemno("2025/02/12", "2025/02/12");
		/*
		 * result:
		 * 	2025/02/12	I003	可樂果原味	F003	20	35	50
			2025/02/12	I004	可樂果酷辣	F003	20	35	50
			2025/02/12	I005	甘草芭樂乾50g	F004	25	40	35
		 * 
		 * 
		 */
		
		
		//new ReceivedDaoImpl().orderbyFactoryno("2025/02/12", "2025/02/12");
		/*
		 * result:
		 * 	2025/02/12	I003	可樂果原味	F003	20	35	50
			2025/02/12	I004	可樂果酷辣	F003	20	35	50
			2025/02/12	I005	甘草芭樂乾50g	F004	25	40	35
		 */
		

		/*
			// find received by indateFrom - indateTo	
				List<Received> listItem=new ReceivedDaoImpl().selectByIndate("2025/02/11", "2025/02/12");
				for(Received oneItem:listItem)
				{
					System.out.println(oneItem.getId()+"\t"+oneItem.getIndate()+"\t"+oneItem.getItemno()+
								"\t"+oneItem.getFactoryno()+"\t"+oneItem.getInqty());
				}*/
			/*
				// result: "2025/02/12", "2025/02/12"
				  	1	2025/02/12	I003	F003	50
					2	2025/02/12	I004	F003	50
					3	2025/02/12	I005	F004	35
					
				// result: "2025/02/11", "2025/02/12"
				 	1	2025/02/12	I003	F003	50
					2	2025/02/12	I004	F003	50
					3	2025/02/12	I005	F004	35
					4	2025/02/11	I009	F008	50
					5	2025/02/11	I008	F008	50
					6	2025/02/11	I007	F006	35
			*/
			
		/*
			// update Received
					List<Received> listItem=new ItemDaoImpl().selectById(6);
					Received oneItem=listItem.get(0);
					oneItem.setItemno("I008");
					oneItem.setFactoryno("F008");
					
					new ReceivedDaoImpl().update(oneItem);
		*/
	}
	
// connect mysql database
	private static Connection conn= DbConnection.getDb();

	@Override
	public void add(Received received) {
		// TODO Auto-generated method stub
		 String sql="insert into received(indate, itemno, factoryno, inqty) "
					+ "values(?,?,?,?)";
			try {
				PreparedStatement preparedstatement=conn.prepareStatement(sql);
				preparedstatement.setString(1,received.getIndate());
				preparedstatement.setString(2,received.getItemno());				;
				preparedstatement.setString(3,received.getFactoryno());
				preparedstatement.setInt(4,received.getInqty());				

				preparedstatement.executeUpdate();
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
	}

	@Override
	public List<Received> selectAll() {
		// TODO Auto-generated method stub
		String SQL="select * from received";
		List<Received> allItem = new ArrayList();
		
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(SQL);
			ResultSet resultset=preparedstatement.executeQuery();
			
			while(resultset.next())
			{
				Received oneItem=new Received();
				oneItem.setId(resultset.getInt("id"));
				oneItem.setIndate(resultset.getString("indate"));
				oneItem.setItemno(resultset.getString("itemno"));
				oneItem.setFactoryno(resultset.getString("factoryno"));
				oneItem.setInqty(resultset.getInt("inqty"));
				
				allItem.add(oneItem);
				
			}
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return allItem;

	}

	@Override
	public List<Received> selectById(int id) {
		// TODO Auto-generated method stub
	 	String sql = "select * from received where id = ?";
		List<Received> oneItem = new ArrayList();
		
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(sql);
			preparedstatement.setInt(1,id);
			ResultSet resultset=preparedstatement.executeQuery();
			
			while(resultset.next())
			{

				Received item=new Received();
				item.setId(resultset.getInt("id"));
				item.setIndate(resultset.getString("indate"));
				item.setItemno(resultset.getString("itemno"));
				item.setFactoryno(resultset.getString("factoryno"));
				item.setInqty(resultset.getInt("inqty"));
				
				oneItem.add(item);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return oneItem;

	}

	@Override
	public List<Received> selectByIndate(String indateFrom, String indateTo) {
		// TODO Auto-generated method stub
		String SQL="select * from received where indate >= ? and indate <= ? ";
		List<Received> allItem = new ArrayList();
		
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(SQL);
			preparedstatement.setString(1,indateFrom);
			preparedstatement.setString(2,indateTo);
			ResultSet resultset=preparedstatement.executeQuery();
			
			while(resultset.next())
			{
				Received oneItem=new Received();
				oneItem.setId(resultset.getInt("id"));
				oneItem.setIndate(resultset.getString("indate"));
				oneItem.setItemno(resultset.getString("itemno"));
				oneItem.setFactoryno(resultset.getString("factoryno"));
				oneItem.setInqty(resultset.getInt("inqty"));
				
				allItem.add(oneItem);
				
			}		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return allItem;
	}

	@Override
	public void update(Received received) {
		// TODO Auto-generated method stub
	  	String sql="update received set indate=?, itemno=?, factoryno=?, inqty=? where id=?";
			
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(sql);
			preparedstatement.setString(1,received.getIndate());
			preparedstatement.setString(2,received.getItemno());	
			preparedstatement.setString(3,received.getFactoryno());
			preparedstatement.setInt(4,received.getInqty());
			preparedstatement.setInt(5,received.getId());
			
			preparedstatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		String sql="delete from received where id=?";
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(sql);
			preparedstatement.setInt(1,id);			
			preparedstatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public String orderbyItemno(String indateFrom, String indateTo) {
		// TODO Auto-generated method stub
		String sQuery = "";
		//String SQL="select * from received where indate >= ? and indate <= ? ";
		String 	SQL="select ";
				SQL += "received.indate,";
				SQL += "received.itemno, ";
				SQL += "item.itemname, ";
				SQL += "received.factoryno, ";
				SQL += "item.cost, ";
				SQL += "item.price, ";
				SQL += "received.inqty ";
				SQL += "FROM received INNER JOIN item ";
				SQL += "ON  item.itemno =received.itemno ";
				SQL += "WHERE indate >= ? and indate <= ? ";
				SQL += "ORDER BY received.indate, received.itemno ";
		
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(SQL);
			preparedstatement.setString(1,indateFrom);
			preparedstatement.setString(2,indateTo);
			ResultSet resultset=preparedstatement.executeQuery();
			
			int sum = 0;
			while(resultset.next())
			{
				sQuery += resultset.getString("indate") + "\t";			
				sQuery += resultset.getString("itemno") + "\t";	
				sQuery += resultset.getString("itemname") + "\t";	
				sQuery += resultset.getString("factoryno") + "\t";	
				sQuery += Integer.toString(resultset.getInt("cost")) + "\t";
				sQuery += Integer.toString(resultset.getInt("price")) + "\t";
				sQuery += Integer.toString(resultset.getInt("inqty")) + "\r\n";
				sum += resultset.getInt("cost") * resultset.getInt("inqty");
			}	
			if (sum > 0)
			{
				sQuery += "==============================================================\n";
				sQuery += " 總計金額： "+Integer.toString(sum)+ "\r\n";				
			}		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sQuery;
	}

	@Override
	public String orderbyFactoryno(String indateFrom, String indateTo) {
		// TODO Auto-generated method stub
		String sQuery = "";
		
		String 	SQL="select ";
		SQL += "received.indate,";
		SQL += "received.itemno, ";
		SQL += "item.itemname, ";
		SQL += "received.factoryno, ";
		SQL += "item.cost, ";
		SQL += "item.price, ";
		SQL += "received.inqty ";
		SQL += "FROM received INNER JOIN item ";
		SQL += "ON  item.itemno =received.itemno ";
		SQL += "WHERE indate >= ? and indate <= ? ";
		SQL += "ORDER BY received.indate, received.factoryno ";
		
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(SQL);
			preparedstatement.setString(1,indateFrom);
			preparedstatement.setString(2,indateTo);
			ResultSet resultset=preparedstatement.executeQuery();
			
			int sum = 0;
			while(resultset.next())
			{
				sQuery += resultset.getString("indate") + "\t";			
				sQuery += resultset.getString("itemno") + "\t";	
				sQuery += resultset.getString("itemname") + "\t";	
				sQuery += resultset.getString("factoryno") + "\t";	
				sQuery += Integer.toString(resultset.getInt("cost")) + "\t";
				sQuery += Integer.toString(resultset.getInt("price")) + "\t";
				sQuery += Integer.toString(resultset.getInt("inqty")) + "\r\n";
				sum += resultset.getInt("cost") * resultset.getInt("inqty");
			}	
			if (sum > 0)
			{
				sQuery += "==============================================================\n";
				sQuery += " 總計金額： "+Integer.toString(sum)+ "\r\n";				
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sQuery;
	}


}
