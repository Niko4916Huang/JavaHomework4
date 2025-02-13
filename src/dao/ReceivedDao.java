package dao;

import java.util.List;

import model.Received;

public interface ReceivedDao {
	// create
	void add(Received received);
	
	// read
	//select * from received
	List <Received> selectAll();
	
	List <Received> selectById(int id);
	List <Received> selectByIndate(String indateFrom, String indateTo);
	String orderbyItemno(String indateFrom, String indateTo);
	String orderbyFactoryno(String indateFrom, String indateTo);
	
	// update
	void update(Received received);
	
	// delete
	void delete(int id);

}
