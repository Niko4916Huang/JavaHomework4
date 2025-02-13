package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Tool2 {
	/*
	 * 註冊+存成檔案方法
	 * 1.static
	 * 2.void
	 * 3.引數-->輸入-->name,chi,eng-->new Student
	 * 4.檔案-->名+地點
	 * 
	 */
	
	public static void save(Object s,String filename)
	{
		
		try {
			
			FileOutputStream fos=new FileOutputStream(filename);
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			
			oos.writeObject(s);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/*
	 * 1.static
	 * 2.Object
	 * 3.引數-->檔名
	 * 
	 * 
	 */
	
	public static Object read(String filename)
	{
		Object o=null;
		
		try {
			FileInputStream fis=new FileInputStream(filename);
			ObjectInputStream ois=new ObjectInputStream(fis);
			o=ois.readObject();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return o;
	}

}