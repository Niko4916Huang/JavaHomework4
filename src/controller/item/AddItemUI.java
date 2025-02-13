package controller.item;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import util.ClockPanel;
import model.Employee;
import model.Factory;
import model.Item;
import service.impl.FactoryServiceImpl;
import service.impl.ItemServiceImpl;
//import service.impl.ItemServiceImpl;
import util.Tool;
import controller.factory.FactoryUI;
import controller.employee.EmployUI;
import controller.ReceivingUI;
import controller.ReportUI;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class AddItemUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private JTextField Titemno;
	private JTextField Tname;
	private JTextField Tcost;
	private JTextField Tprice;
	private JTextField Tfactoryno;
	private JTextField Tqty;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddItemUI frame = new AddItemUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddItemUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setLocationRelativeTo(null); 

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(205, 255, 239));		// light green
		panel.setBounds(18, 6, 562, 32);
		contentPane.add(panel);
		panel.setLayout(null);
		
		Employee employee = (Employee) Tool.read("employee.txt");
		
		JLabel lblNewLabel = new JLabel("商品基本資料新增作業");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel.setForeground(new Color(12, 35, 255));		// font - blue
		lblNewLabel.setBounds(181, 3, 216, 26);
		panel.add(lblNewLabel);
		
		JLabel employeeNameLb = new JLabel("使用員工："+employee.getName());
		employeeNameLb.setBounds(6, 11, 124, 16);
		panel.add(employeeNameLb);
		
	// 小時鐘介面
        ClockPanel clockPanel = new ClockPanel();
        clockPanel.setBackground(new Color(205, 255, 239));
        clockPanel.setBounds(466, 3, 90, 32);
        panel.add(clockPanel);
     // 啟動時鐘更新
        new Timer(1000, e1 -> clockPanel.updateTime()).start();
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(240, 255, 240));
		panel_1.setBounds(18, 53, 95, 305);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnReceiving = new JButton("進貨作業");
		btnReceiving.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ReceivingUI frame = new ReceivingUI();
				frame.setVisible(true);
				dispose();
			}
		});
		btnReceiving.setBounds(2, 24, 89, 29);
		panel_1.add(btnReceiving);
		
		JButton btnReport = new JButton("報表作業");
		btnReport.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ReportUI frame = new ReportUI();
				frame.setVisible(true);
				dispose();
			}
		});
		btnReport.setBounds(2, 65, 89, 29);
		panel_1.add(btnReport);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 106, 76, 150);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel(" 基本資料");
		lblNewLabel_1.setForeground(new Color(128, 0, 0));
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(6, 6, 61, 16);
		panel_3.add(lblNewLabel_1);
		
		JButton btnItem = new JButton("商 品");
		btnItem.setEnabled(false);
		btnItem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ItemUI frame = new ItemUI();
				frame.setVisible(true);
				dispose();
			}
		});
		btnItem.setBounds(6, 34, 61, 29);
		panel_3.add(btnItem);
		
		JButton btnFactory = new JButton("廠 商");
		btnFactory.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FactoryUI frame = new FactoryUI();
				frame.setVisible(true);
				dispose();
			}
		});
		btnFactory.setBounds(6, 68, 61, 29);
		panel_3.add(btnFactory);
		
		JButton btnEmployee = new JButton("員 工");
		btnEmployee.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EmployUI frame = new EmployUI();
				frame.setVisible(true);
				dispose();
			}
		});
		btnEmployee.setBounds(6, 102, 61, 29);
		panel_3.add(btnEmployee);
		
		JButton btnExit = new JButton("登  出");
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(4, 268, 89, 29);
		panel_1.add(btnExit);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		panel_2.setBounds(125, 50, 455, 311);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("商品編號：");
		lblNewLabel_2.setBounds(40, 20, 75, 16);
		panel_2.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("商品名稱：");
		lblNewLabel_2_1.setBounds(40, 55, 75, 16);
		panel_2.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("進       價：");
		lblNewLabel_2_2.setBounds(40, 85, 75, 16);
		panel_2.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("售       價：");
		lblNewLabel_2_3.setBounds(40, 120, 75, 16);
		panel_2.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_4 = new JLabel("廠商編號：");
		lblNewLabel_2_4.setBounds(40, 155, 75, 16);
		panel_2.add(lblNewLabel_2_4);
		
		JLabel lblNewLabel_2_5 = new JLabel("庫  存  量：");
		lblNewLabel_2_5.setBounds(40, 190, 75, 16);
		panel_2.add(lblNewLabel_2_5);
			
		Titemno = new JTextField();
		Titemno.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String sItemno = Titemno.getText().trim();
				Item thisItem = new ItemServiceImpl().findByItemno(sItemno);
				if(thisItem != null)
				{
					Tool.alert(" 商品編號已存在， 請重新輸入！");
				}
				
			}
		});
		Titemno.addActionListener(		// press ENTER will work
			new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e) {	
					// TODO Auto-generated method stub
					String sItemno = Titemno.getText().trim();
					Item thisItem = new ItemServiceImpl().findByItemno(sItemno);
					if(thisItem != null)
					{
						Tool.alert(" 商品編號已存在， 請重新輸入！");
					}
				}			
			} );
		Titemno.setBounds(137, 15, 69, 26);
		panel_2.add(Titemno);
		Titemno.setColumns(10);
		
		Tname = new JTextField();
		Tname.setColumns(10);
		Tname.setBounds(137, 50, 250, 26);
		panel_2.add(Tname);
		
		Tcost = new JTextField();
		Tcost.setColumns(10);
		Tcost.setBounds(137, 80, 69, 26);
		panel_2.add(Tcost);
		
		Tprice = new JTextField();
		Tprice.setColumns(10);
		Tprice.setBounds(137, 115, 69, 26);
		panel_2.add(Tprice);
		
		
		// https://docs.pingcode.com/baike/186094
		// 使用DocumentListener监听文本变化
		// https://stackoverflow.com/questions/26264880/smarter-way-to-use-java-documentlistener
		//  Smarter way to use Java DocumentListener
		
		/*
		 * How do I check the value change of JTextField:
		 * 
		 * 	JTextField input;
			input.addActionListener(
			new ActionListener()
			{
				public void actionPerformed( ActionEvent e )
				{ 
					String s = input.getText().trim();
					//do whatever you want here the user has entered some text
					//and pressed the enter button on the keyboard. Whatever
					//was in the textbox is now in s.
				}			
			} );
		 * 
		 */
				
		JLabel lblFactoryName = new JLabel("");
		lblFactoryName.setBounds(218, 155, 157, 21);
		panel_2.add(lblFactoryName);
				
		Tfactoryno = new JTextField();
		Tfactoryno.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String sFactoryno = Tfactoryno.getText().trim();
				Factory Thisfactory = new FactoryServiceImpl().findByFactoryno(sFactoryno);
				// if(new FactoryServiceImpl().isFactorynoBeenUse(sFactoryno))
				if(Thisfactory != null)
				{
					lblFactoryName.setText(Thisfactory.getFactoryname());
				}
				else
				{
					Tool.alert(" 廠商編號不存在， 請重新輸入！");
				}
				
			}
		});
		Tfactoryno.addActionListener(		// press ENTER will work
			new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e) {	
					// TODO Auto-generated method stub
					String sFactoryno = Tfactoryno.getText().trim();
					Factory Thisfactory = new FactoryServiceImpl().findByFactoryno(sFactoryno);
					// if(new FactoryServiceImpl().isFactorynoBeenUse(sFactoryno))
					if(Thisfactory != null)
					{
						lblFactoryName.setText(Thisfactory.getFactoryname());
					}
					else
					{
						Tool.alert(" 廠商編號不存在， 請重新輸入！");
					}
				}			
			} );
		/*
		Tfactoryno.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				
				System.out.println("Factory no changed!");
			}
		});
		*/
		Tfactoryno.setColumns(10);
		Tfactoryno.setBounds(137, 150, 69, 26);
		panel_2.add(Tfactoryno);
		
		Tqty = new JTextField();
		Tqty.setColumns(10);
		Tqty.setBounds(137, 185, 69, 26);
		panel_2.add(Tqty);
		
		JLabel lblNewLabel_2_5_1 = new JLabel("元");
		lblNewLabel_2_5_1.setBounds(216, 85, 75, 16);
		panel_2.add(lblNewLabel_2_5_1);
		
		JLabel lblNewLabel_2_5_1_1 = new JLabel("元");
		lblNewLabel_2_5_1_1.setBounds(218, 120, 75, 16);
		panel_2.add(lblNewLabel_2_5_1_1);
		
		JButton bntQuery = new JButton("回上頁");
		bntQuery.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ItemUI frame = new ItemUI();
				frame.setVisible(true);
				dispose();
			}
		});
		bntQuery.setBounds(49, 245, 117, 29);
		panel_2.add(bntQuery);
		
		JButton btnNewAdd = new JButton("新  增");
		btnNewAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (!Titemno.getText().equals("") && !Tname.getText().equals("") &&
					!Tcost.getText().equals("") && !Tprice.getText().equals("") &&
					!Tfactoryno.getText().equals("") && !Tqty.getText().equals("") )
				{
				// check itemno
					String Itemno=Titemno.getText();
					if(new ItemServiceImpl().isItemnoBeenUse(Itemno))
					{
						Tool.alert(" 商品編號 已被使用， 請重新輸入！");
					}
					else
					{
						String Item_no=Titemno.getText();
						String item_name=Tname.getText();
						int Item_cost=Integer.parseInt(Tcost.getText());
						int item_price=Integer.parseInt(Tprice.getText());
						String Item_factoryno=Tfactoryno.getText();
						int item_qty=Integer.parseInt(Tqty.getText());
						
						Item oneitem = new Item(Item_no, item_name, Item_cost, item_price, Item_factoryno, item_qty );
						new ItemServiceImpl().addItem(oneitem);
						
						Tool.alert(" 商品， 新增成功！");
						Titemno.setText("");
						Tname.setText("");
						Tcost.setText("");
						Tprice.setText("");
						Tfactoryno.setText("");
						Tqty.setText("");
					}
				}
				else
				{
					Tool.alert(" 輸入錯誤， 不可有空欄位，\n    請重新輸入！");
				}
			}
		});
		btnNewAdd.setBounds(216, 245, 117, 29);
		panel_2.add(btnNewAdd);

	}
}
