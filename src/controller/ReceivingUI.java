package controller;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JFormattedTextField;

import model.Employee;
import model.Received;
import util.ClockPanel;
import util.Tool;
import controller.item.ItemUI;
import controller.factory.FactoryUI;
import controller.employee.EmployUI;
import controller.receiving.AddReceivingUI;
import controller.receiving.QueryReceivingUI;



public class ReceivingUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReceivingUI frame = new ReceivingUI();
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
	public ReceivingUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setLocationRelativeTo(null); 

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Employee employee = (Employee) Tool.read("employee.txt");
		//Received received  = (Received) Tool.read("received.txt");
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(205, 255, 239));		// light green
		panel.setBounds(18, 6, 562, 32);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		
		JLabel lblNewLabel = new JLabel("進 貨 作 業");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel.setForeground(new Color(12, 35, 255));		// font - blue
		lblNewLabel.setBounds(228, 3, 118, 26);
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
		btnReceiving.setEnabled(false);
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
		
/*******************************************************************/
		
		/*
		 * 
		 * DateFormat dateFormat = new SimpleDateFormat("dd MMM YYYY");
      		JFormattedTextField today = new JFormattedTextField(dateFormat);
      
      //  直接格式化輸出現在時間的方法
         SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd 
                                     HH:mm:ss.SSS");
         Date current = new Date();
         System.out.println(sdFormat.format(current));
      
		 */
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date current = new Date();
		JFormattedTextField formattedTextField = new JFormattedTextField(sdFormat.format(current));
		formattedTextField.setBounds(176, 92, 107, 26);
		panel_2.add(formattedTextField);
		
		JLabel lblNewLabel_2 = new JLabel("進貨日期：");
		lblNewLabel_2.setBounds(91, 97, 81, 16);
		panel_2.add(lblNewLabel_2);
		
		JButton btnNewadd = new JButton("新  增");
		btnNewadd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Querydate = formattedTextField.getText();
				//System.out.println("Querydate:"+Querydate);
				Received received = new Received(Querydate, "0000", "0000", 0);				
				Tool.save(received, "received.txt");
				
				AddReceivingUI frame = new AddReceivingUI();
				frame.setVisible(true);
				dispose();
			}
		});
		btnNewadd.setBounds(232, 191, 117, 29);
		panel_2.add(btnNewadd);
		
		JButton btnQuery = new JButton("查  詢");
		btnQuery.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String Querydate = formattedTextField.getText();
				
				//System.out.println("Querydate:"+Querydate);
				Received received = new Received(Querydate, "0000", "0000", 0);				
				Tool.save(received, "received.txt");
				
				QueryReceivingUI frame = new QueryReceivingUI();
				frame.setVisible(true);
				dispose();
				
			}
		});
		btnQuery.setBounds(55, 191, 117, 29);
		panel_2.add(btnQuery);
	}
}
