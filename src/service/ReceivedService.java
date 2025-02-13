package service;

import java.util.List;

import model.Received;

public interface ReceivedService {
	//create
	void addItem(Received received);
	
	//read
	String AllItem();
	List<Received> selectById(int id);
	List<Received> findAllItem();
	List<Received> findByIndate(String indateFrom, String indateTo);
	String findByIndateOrderbyItemno(String indateFrom, String indateTo);
	String findByIndateOrderbyFactoryno(String indateFrom, String indateTo);
	
	
	boolean isItemnoExist(String itemno);
	
	//update
	void updateItem(Received received);
	
	
	//delete
	void deleteItemById(int id);

}
