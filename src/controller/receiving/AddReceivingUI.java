package controller.receiving;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controller.ReceivingUI;
import controller.ReportUI;
import controller.employee.EmployUI;
import controller.factory.FactoryUI;
import controller.item.ItemUI;
import dao.impl.ReceivedDaoImpl;
import model.Employee;
import model.Item;
import model.Received;
import service.impl.ItemServiceImpl;
import util.ClockPanel;
import util.Tool;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class AddReceivingUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField Titemno;
	private JTextField Tinqty;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddReceivingUI frame = new AddReceivingUI();
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
	public AddReceivingUI() {
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
		Received received  = (Received) Tool.read("received.txt");
		//String show = new ReceivedDaoImpl().orderbyItemno(received.getIndate(), received.getIndate());
		String ReceivingDate = received.getIndate();
		
		JLabel lblNewLabel = new JLabel("商品進貨新增作業");
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

/*******************************************************************/			
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		panel_2.setBounds(125, 50, 455, 311);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		String outputMsg = "進貨日期："+ ReceivingDate +"\n";
				outputMsg += "商品編號\t商品名稱\t  廠商編號\t進 價\t進貨量\n";
				outputMsg += "============================================\n";
				
		JTextArea output = new JTextArea();
		output.setBounds(6, 6, 443, 226);
		panel_2.add(output);
		output.setText(outputMsg);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(6, 244, 443, 61);
		panel_2.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("商品編號：");
		lblNewLabel_2.setBounds(6, 21, 79, 16);
		panel_4.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("進貨量：");
		lblNewLabel_2_1.setBounds(166, 21, 62, 16);
		panel_4.add(lblNewLabel_2_1);
		
		Titemno = new JTextField();
		Titemno.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				
				String sItemno = Titemno.getText().trim();
				if (sItemno.length() > 0)
				{
					Item thisItem = new ItemServiceImpl().findByItemno(sItemno);
					if(thisItem == null)
					{
						Tool.alert(" 商品編號不存在， 請重新輸入！");
					}
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
					if (sItemno.length() > 0)
					{
						Item thisItem = new ItemServiceImpl().findByItemno(sItemno);
						if(thisItem == null)
						{
							Tool.alert(" 商品編號不存在， 請重新輸入！");
						}
					}
					
				}			
			} );
		Titemno.setBounds(75, 16, 79, 26);
		panel_4.add(Titemno);
		Titemno.setColumns(10);
		
		Tinqty = new JTextField();
		Tinqty.setColumns(10);
		Tinqty.setBounds(223, 16, 71, 26);
		panel_4.add(Tinqty);
		
		JButton btnNewButton = new JButton("結 束");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ReceivingUI frame = new ReceivingUI();
				frame.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(350, 0, 87, 29);
		panel_4.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("新 增");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if ((Titemno.getText().length() > 0) && (Tinqty.getText().length() > 0))
				{
					String sItemno = Titemno.getText().trim();
					int Inqty=Integer.parseInt(Tinqty.getText());
					Item thisItem = new ItemServiceImpl().findByItemno(sItemno);
					if(thisItem == null)
					{
						Tool.alert(" 商品編號不存在， 請重新輸入！");
					}
					else
					{
						if (Inqty > 0)
						{//outputMsg += "商品編號\t商品名稱\t廠商編號 進 價 進貨量\n";
							Received received = new Received(ReceivingDate, sItemno, thisItem.getFactoryno(), Inqty);
							new ReceivedDaoImpl().add(received);
							String Msg = output.getText();
							Msg += sItemno +"\t"+ thisItem.getItemname() +"\t "+ thisItem.getFactoryno() +"\t";
							Msg += thisItem.getCost()+"\t" + Inqty +"\n";
							output.setText(Msg);
							Titemno.setText("");
							Tinqty.setText("");
						}
						else
						{
							Tool.alert(" 沒有進貨量， 請重新輸入！");
						}
					}
				}				
			}
		});
		btnNewButton_1.setBounds(350, 30, 87, 29);
		panel_4.add(btnNewButton_1);

		
	}
}
