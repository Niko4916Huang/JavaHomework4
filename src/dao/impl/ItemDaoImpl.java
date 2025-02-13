package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.ItemDao;
import model.Item;
import util.DbConnection;

public class ItemDaoImpl implements ItemDao{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	/*
	  // add 
		Item item = new Item("I003", "可樂果原味", 20, 35, "F003", 50);
		new ItemDaoImpl().add(item);
		item = new Item("I004", "可樂果酷辣", 20, 35, "F003", 50);
		new ItemDaoImpl().add(item);
		item = new Item("I005", "甘草芭樂乾50g", 25, 40, "F004", 35);
		new ItemDaoImpl().add(item);
	*/	
	
	/*
	//list all item	
		List<Item> listItem=new ItemDaoImpl().selectAll();
		for(Item oneItem:listItem)
		{
			System.out.println(oneItem.getId()+"\t"+oneItem.getItemno()+
								"\t"+oneItem.getItemname()+"\t"+oneItem.getCost()+
								"\t"+oneItem.getPrice()+"\t"+oneItem.getFactoryno()+
								"\t"+oneItem.getQty()
								);
		}
		
	*/
		// result
		/*
		 * 	1	I001	奶油椰子餅		12	20	F001	20
			2	I002	福義軒-檸檬薄片	12	20	F005	14
			3	I003	可樂果原味		20	35	F003	50
			4	I004	可樂果酷辣		20	35	F003	50
			5	I005	甘草芭樂乾50g		25	40	F004	35
		 * 
		 */
	/*
		// find factory by id
				System.out.println(new FactoryDaoImpl().selectById(1));
		// result:  
	 * 
	 */

	/*
		// find item by itemno		
			System.out.println(new ItemDaoImpl().selectByItemno("I002"));
			// result: [model.Item@1a04f701]
	*/
		
	/*
		// update itemname
				List<Item> listItem=new ItemDaoImpl().selectById(6);
				Item oneItem=listItem.get(0);
				oneItem.setItemname("無籽冰心話梅13g");
				
				new ItemDaoImpl().update(oneItem);
	*/

	}
	
	// connect mysql database
		private static Connection conn= DbConnection.getDb();

		@Override
		public void add(Item item) {
			// TODO Auto-generated method stub
			String sql="insert into item(itemno, itemname, cost, price, factoryno, qty) "
					+ "values(?,?,?,?,?,?)";
			try {
				PreparedStatement preparedstatement=conn.prepareStatement(sql);
				preparedstatement.setString(1,item.getItemno());
				preparedstatement.setString(2,item.getItemname());
				preparedstatement.setInt(3,item.getCost());
				preparedstatement.setInt(4,item.getPrice());
				preparedstatement.setString(5,item.getFactoryno());
				preparedstatement.setInt(6,item.getQty());
				

				preparedstatement.executeUpdate();
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

		@Override
		public List<Item> selectAll() {
			// TODO Auto-generated method stub
			String SQL="select * from item";
			List<Item> allItem = new ArrayList();
			
			try {
				PreparedStatement preparedstatement=conn.prepareStatement(SQL);
				ResultSet resultset=preparedstatement.executeQuery();
				
				while(resultset.next())
				{
					Item oneItem=new Item();
					oneItem.setId(resultset.getInt("id"));
					oneItem.setItemno(resultset.getString("itemno"));
					oneItem.setItemname(resultset.getString("itemname"));
					oneItem.setCost(resultset.getInt("cost"));
					oneItem.setPrice(resultset.getInt("price"));
					oneItem.setFactoryno(resultset.getString("factoryno"));
					oneItem.setQty(resultset.getInt("qty"));
					
					allItem.add(oneItem);
					
				}
			
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return allItem;
		}

		@Override
		public List<Item> selectById(int id) {
			// TODO Auto-generated method stub
			String sql = "select * from item where id = ?";
			List<Item> oneItem = new ArrayList();
			
			try {
				PreparedStatement preparedstatement=conn.prepareStatement(sql);
				preparedstatement.setInt(1,id);
				ResultSet resultset=preparedstatement.executeQuery();
				
				while(resultset.next())
				{

					Item item=new Item();
					item.setId(resultset.getInt("id"));
					item.setItemno(resultset.getString("itemno"));
					item.setItemname(resultset.getString("itemname"));
					item.setCost(resultset.getInt("cost"));
					item.setPrice(resultset.getInt("price"));
					item.setFactoryno(resultset.getString("factoryno"));
					item.setQty(resultset.getInt("qty"));
					
					oneItem.add(item);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return oneItem;
		}

		@Override
		public List<Item> selectByItemno(String itemno) {
			// TODO Auto-generated method stub
			String sql = "select * from item where itemno = ?";
			List<Item> oneItem = new ArrayList();
			
			try {
				PreparedStatement preparedstatement=conn.prepareStatement(sql);
				preparedstatement.setString(1,itemno);
				ResultSet resultset=preparedstatement.executeQuery();
				
				while(resultset.next())
				{

					Item item=new Item();
					item.setId(resultset.getInt("id"));
					item.setItemno(resultset.getString("itemno"));
					item.setItemname(resultset.getString("itemname"));
					item.setCost(resultset.getInt("cost"));
					item.setPrice(resultset.getInt("price"));
					item.setFactoryno(resultset.getString("factoryno"));
					item.setQty(resultset.getInt("qty"));
					
					oneItem.add(item);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return oneItem;
		}

		@Override
		public void update(Item item) {
			// TODO Auto-generated method stub
			String sql="update item set itemno=?,itemname=?,cost=?, price=?, factoryno=?,qty=? where id=?";
			
			try {
				PreparedStatement preparedstatement=conn.prepareStatement(sql);
				preparedstatement.setString(1,item.getItemno());
				preparedstatement.setString(2,item.getItemname());
				preparedstatement.setInt(3,item.getCost());
				preparedstatement.setInt(4,item.getPrice());	
				preparedstatement.setString(5,item.getFactoryno());
				preparedstatement.setInt(6,item.getQty());
				preparedstatement.setInt(7,item.getId());
				
				preparedstatement.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		@Override
		public void delete(int id) {
			// TODO Auto-generated method stub
			String sql="delete from item where id=?";
			try {
				PreparedStatement preparedstatement=conn.prepareStatement(sql);
				preparedstatement.setInt(1,id);
				
				preparedstatement.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	

}
