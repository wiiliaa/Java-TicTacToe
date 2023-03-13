package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controller.Controller;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JToolBar;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.Console;
import java.text.DecimalFormat;
import java.util.Random;

import javax.swing.JMenu;
import java.awt.SystemColor;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.JTextArea;

import model.ViewModel;

public class ViewMain extends JFrame{
	public ViewModel viewModel;
	private JPanel MainPage,HelpPage,SettingPage;
	public JPanel GPPage1;
	public int a=0;
	//khai báo page help
	private JButton button_back_help;
	private JTextArea JLBText_Help;
	private JLabel jlabel_help_title;
	
	//ảnh
	ImageIcon imgbackground = new ImageIcon("src/Tictactoe.png");
	ImageIcon imgGP = new ImageIcon("src/GPBackGround.png");
	//sự kiện
	Controller ct = new Controller(this);
	

	
	
	//khai báo page setting
	private JLabel jlabel_setting_title_chose;
	private JLabel jlabel_setting_title_mode;
	private JButton btn_back_setting;
	private JRadioButton jrd_chon_quanx_setting,jrd_chon_quano_setting;
	public JButton btn_chon_easy_setting,btn_chon_hard_setting;
	private JRadioButton jrd_Yfirst_setting,jrd_Cfirst_setting;

	
	
	//khai báo gp
	public JPanel jpn_contain_btn_GP;
	public JButton[] btn_GP = new JButton[10];
	private JButton btn_back_GP;
	private JLabel JBL_BG_GP;
	private JButton btn_reset_GP;
	private JPanel jpanel_win_GP;
	private JLabel jlabel_thongbao_GP;
	public boolean tie = true;
	public int CM;
	
	//thoi gian
	private JLabel showtime;
	int second;
	String cdSecond;
	DecimalFormat dFormat = new DecimalFormat("");
	public Timer timer;
	
	public ViewMain() {
		this.viewModel = new ViewModel();
		this.init();
	}
	
	
	public void  init() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 550);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		setTitle("TICTACTOE");
		this.setLayout(null);
		
		//trang help
		
		HelpPage = new JPanel();
		HelpPage.setBounds(0, 0,500,500);
		HelpPage.setLayout(null);
	
		
		//help button
		button_back_help = new JButton("BACK");
		button_back_help.setFont(new Font("Arial", Font.BOLD, 25));
		button_back_help.setBounds(10, 405, 76, 30);
		button_back_help.setForeground(new Color(255, 0, 153));
		button_back_help.setCursor(new Cursor(HAND_CURSOR));
		button_back_help.setBorder(null);
		button_back_help.addActionListener(ct);
		button_back_help.setBorder(null);
		button_back_help.setOpaque(false);
		button_back_help.setContentAreaFilled(false);
		button_back_help.setBorderPainted(false);
		
		//background help
		JLBText_Help = new JTextArea("Tic-tac-toe is a popular board game written on a nine-square, 3x3 board. Two players, one using the symbol O, the other using the symbol X, take turns filling in their symbols in the boxes. The winner is the one who can create a sequence of three of their own symbols first, horizontal, vertical or diagonal");
		JLBText_Help.setLineWrap(true);
		JLBText_Help.setEditable(false);
		JLBText_Help.setFont(new Font("Arial", Font.BOLD, 16));
		JLBText_Help.setBounds(8, 185,481,200);
		JLBText_Help.setForeground(Color.WHITE);
		JLBText_Help.setOpaque(false);
		JLBText_Help.setBorder(null);
		
		//huongdan lable
		jlabel_help_title = new JLabel("GUIDE");
		jlabel_help_title.setFont(new Font("Arial",Font.BOLD,35));
		jlabel_help_title.setBounds(230, 112, 200, 40);
		jlabel_help_title.setForeground(new Color(255, 0, 153));

		//panel help
		HelpPage.add(jlabel_help_title);
		HelpPage.add(JLBText_Help);
		HelpPage.add(button_back_help);
		HelpPage.setOpaque(false);
		HelpPage.setVisible(false);
		this.add(HelpPage);
		
		//trang setting
		SettingPage = new JPanel();
		SettingPage.setBounds(0,0,500,500);
		SettingPage.setLayout(null);
		
		//buton setting
		
		//back button
		btn_back_setting = new JButton("BACK");
		btn_back_setting.setFont(new Font("Arial", Font.BOLD, 25));
		btn_back_setting.setBounds(10, 405, 76, 30);
		btn_back_setting.setForeground(new Color(255, 0, 153));
		btn_back_setting.setCursor(new Cursor(HAND_CURSOR));
		btn_back_setting.setBorder(null);
		btn_back_setting.addActionListener(ct);
		btn_back_setting.setContentAreaFilled(false);
		btn_back_setting.setBorderPainted(false); 
	
		
		//button chọn x,o
		jrd_chon_quanx_setting = new JRadioButton("Choose X");
		jrd_chon_quanx_setting.setFont(new Font("Arial", Font.BOLD, 15));
		jrd_chon_quanx_setting.setBounds(218, 52, 95, 30);
		jrd_chon_quanx_setting.setForeground(new Color(255, 0, 153));
		jrd_chon_quanx_setting.setBackground(Color.WHITE);
		jrd_chon_quanx_setting.setCursor(new Cursor(HAND_CURSOR));
		jrd_chon_quanx_setting.addActionListener(ct);
		jrd_chon_quanx_setting.setBorder(null);
		jrd_chon_quanx_setting.setBorderPainted(false);
		
		//button chọn
		jrd_chon_quano_setting = new JRadioButton("Choose O");
		jrd_chon_quano_setting.addActionListener(ct);
		jrd_chon_quano_setting.setFont(new Font("Arial", Font.BOLD, 15));
		jrd_chon_quano_setting.setBounds(345, 52, 95, 30);
		jrd_chon_quano_setting.setForeground(new Color(255, 0, 153));
		jrd_chon_quano_setting.setBackground(Color.WHITE);
		jrd_chon_quano_setting.setCursor(new Cursor(HAND_CURSOR));
		jrd_chon_quano_setting.addActionListener(ct);
		jrd_chon_quano_setting.setBorder(null);
		jrd_chon_quano_setting.setBorderPainted(false);
		
		//btn group
		ButtonGroup CBG = new ButtonGroup();
		CBG.add(jrd_chon_quanx_setting);
		CBG.add(jrd_chon_quano_setting);
		
		//chon mode
		btn_chon_easy_setting = new JButton("EASY");
		btn_chon_easy_setting.setFont(new Font("Arial", Font.BOLD, 20));
		btn_chon_easy_setting.setBounds(218,145, 95, 30);
		btn_chon_easy_setting.setForeground(new Color(255, 0, 153));
		btn_chon_easy_setting.setBackground(Color.WHITE);
		btn_chon_easy_setting.setCursor(new Cursor(HAND_CURSOR));
		btn_chon_easy_setting.addActionListener(ct);
		btn_chon_easy_setting.setBorder(null);
		btn_chon_easy_setting.setBorderPainted(false);
		
		
		btn_chon_hard_setting = new JButton("HARD");
		btn_chon_hard_setting.setFont(new Font("Arial", Font.BOLD, 20));
		btn_chon_hard_setting.setBounds(345,145, 95, 30);
		btn_chon_hard_setting.setForeground(new Color(255, 0, 153));
		btn_chon_hard_setting.setBackground(Color.WHITE);
		btn_chon_hard_setting.setCursor(new Cursor(HAND_CURSOR));
		btn_chon_hard_setting.addActionListener(ct);
		btn_chon_hard_setting.setBorder(null);
		btn_chon_hard_setting.setBorderPainted(false);
		
		//Label ten 
		jlabel_setting_title_chose = new JLabel("Choose Symbol");
		jlabel_setting_title_chose.setFont(new Font("Arial",Font.BOLD,25));
		jlabel_setting_title_chose.setBounds(255, 10, 200, 40);
		jlabel_setting_title_chose.setForeground(Color.WHITE);
		jlabel_setting_title_chose.setOpaque(false);
		jlabel_setting_title_chose.setBorder(null);
		
		jlabel_setting_title_mode = new JLabel("Choose Mode");
		jlabel_setting_title_mode.setFont(new Font("Arial",Font.BOLD,25));
		jlabel_setting_title_mode.setBounds(270, 105, 200, 40);
		jlabel_setting_title_mode.setForeground(Color.WHITE);
		jlabel_setting_title_mode .setOpaque(false);
		jlabel_setting_title_mode .setBorder(null);
		

		
		// go first button
		jrd_Yfirst_setting = new JRadioButton("You First");
		jrd_Yfirst_setting.setFont(new Font("Arial", Font.BOLD, 20));
		jrd_Yfirst_setting.setBounds(60,242, 127, 30);
		jrd_Yfirst_setting.setForeground(new Color(255, 0, 153));
		jrd_Yfirst_setting.setBackground(Color.WHITE);
		jrd_Yfirst_setting.setCursor(new Cursor(HAND_CURSOR));
		jrd_Yfirst_setting.addActionListener(ct);
		jrd_Yfirst_setting.setBorder(null);
		jrd_Yfirst_setting.setBorderPainted(false);
		
		jrd_Cfirst_setting = new JRadioButton("Computer First");
		jrd_Cfirst_setting.setFont(new Font("Arial", Font.BOLD, 20));
		jrd_Cfirst_setting.setBounds(280,242, 160, 30);
		jrd_Cfirst_setting.setForeground(new Color(255, 0, 153));
		jrd_Cfirst_setting.setBackground(Color.WHITE);
		jrd_Cfirst_setting.setCursor(new Cursor(HAND_CURSOR));
		jrd_Cfirst_setting.addActionListener(ct);
		jrd_Cfirst_setting.setBorder(null);
		jrd_Cfirst_setting.setBorderPainted(false);
		
		//btn group
		ButtonGroup GFBT = new ButtonGroup();
		GFBT.add(jrd_Yfirst_setting);
		GFBT.add(jrd_Cfirst_setting);
		
		//panel setting
		SettingPage.add(btn_back_setting);
		SettingPage.add(jrd_chon_quanx_setting);
		SettingPage.add(jrd_chon_quano_setting);
		SettingPage.add(btn_chon_easy_setting);
		SettingPage.add(btn_chon_hard_setting);
		SettingPage.add(jlabel_setting_title_chose);
		SettingPage.add(jlabel_setting_title_mode);
		SettingPage.add(jrd_Yfirst_setting);
		SettingPage.add(jrd_Cfirst_setting);
	
		SettingPage.setOpaque(false);
		SettingPage.setVisible(false);
		this.add(SettingPage); 
		
		//trang game play
		
		//khung chơi
		jpn_contain_btn_GP = new JPanel();
		jpn_contain_btn_GP.setBounds(47,40,395,395);
		jpn_contain_btn_GP.setLayout(new GridLayout(3, 3));
		jpn_contain_btn_GP.setOpaque(false);
		jpn_contain_btn_GP.setBackground(Color.black);
		
		
		
		//tạo ra 9 ô trong bàn cờ
		//button gameplay
		for(int i=1;i<10;i++) {
			btn_GP[i] = new JButton("");
			jpn_contain_btn_GP.add(btn_GP[i]);
			btn_GP[i].setFont(new Font("Arial",Font.BOLD,100));
			btn_GP[i].setForeground(new Color(255, 0, 153));
			btn_GP[i].setFocusable(false);
			btn_GP[i].setBackground(new Color(161,222,245));
			btn_GP[i].setBorder(new LineBorder(Color.BLACK));
			btn_GP[i].addActionListener(ct);
		}
		
		
		
		//button back gameplay
		btn_back_GP = new JButton("BACK");
		btn_back_GP .setFont(new Font("Arial", Font.BOLD, 25));
		btn_back_GP .setBounds(400, 0, 76, 30);
		btn_back_GP .setForeground(new Color(255, 0, 153));
		btn_back_GP .setCursor(new Cursor(HAND_CURSOR));
		btn_back_GP .setBorder(null);
		btn_back_GP .addActionListener(ct);
		btn_back_GP .setContentAreaFilled(false);
		btn_back_GP .setBorderPainted(false);
	
		
		btn_reset_GP = new JButton("RESET");
		btn_reset_GP .setFont(new Font("Arial", Font.BOLD, 25));
		btn_reset_GP .setBounds(10, 0, 90, 35);
		btn_reset_GP .setForeground(new Color(255, 0, 153));
		btn_reset_GP .setCursor(new Cursor(HAND_CURSOR));
		btn_reset_GP .setBorder(null);
		btn_reset_GP .addActionListener(ct);
		btn_reset_GP .setContentAreaFilled(false);
		btn_reset_GP .setBorderPainted(false);
		
	
		
	
		

		
		//jlb show time
		showtime = new JLabel("" + viewModel.TimeMode(),JLabel.CENTER);
		showtime.setFont(new Font("Arial", Font.BOLD, 25));
		showtime.setBounds(227, 5, 30, 35);
		showtime.setBackground(Color.WHITE);
		showtime.setForeground(new Color(255, 0, 153));
    
		second=viewModel.TimeMode();
		countdownTimer();
		
		
		//thông báo win
		jpanel_win_GP = new JPanel();
		jpanel_win_GP.setBounds(176,0,137,36);
		jpanel_win_GP.setLayout(null);
		jpanel_win_GP.setBackground(new Color(65,65,65));
		jpanel_win_GP.setVisible(false);
		
		jlabel_thongbao_GP = new JLabel();
		jlabel_thongbao_GP.setBounds(35, 1, 100, 35);
		jlabel_thongbao_GP.setFont(new Font("Arial", Font.BOLD, 25));
		jlabel_thongbao_GP.setForeground(Color.WHITE);
		jpanel_win_GP.add(jlabel_thongbao_GP);
		
	
		//panel game play
		GPPage1 = new JPanel();
		GPPage1.setBounds(0, 0, 500, 500);
		GPPage1.setLayout(null);
		
		
		
		JBL_BG_GP = new JLabel(imgGP);
		JBL_BG_GP.setBounds(0, 0, 490, 500);
		
		GPPage1.add(showtime);
		GPPage1.add(jpanel_win_GP);
		GPPage1.add(btn_reset_GP);
		GPPage1.add(jpn_contain_btn_GP);
		GPPage1.add(btn_back_GP);
		GPPage1.add(JBL_BG_GP);
	
		GPPage1.setOpaque(false);
		GPPage1.setVisible(false);
		
	
		this.add(GPPage1);
	
		
		
	
		
		//trang main
		MainPage = new JPanel();
		MainPage.setSize(500, 500);
		MainPage.setLayout(null);
		
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(255, 255, 255));
		menuBar.setFont(new Font("Arial", Font.BOLD, 12));
		menuBar.setForeground(SystemColor.text);
		setJMenuBar(menuBar);
		
		JMenu menuBar_File = new JMenu("File");
		menuBar_File.setFont(new Font("Arial", Font.PLAIN, 12));
		menuBar.add(menuBar_File);
		
		JMenuItem MenuItem_MainPage = new JMenuItem("Main Page");
		menuBar_File.setFont(new Font("Arial", Font.PLAIN, 12));
		menuBar_File.add(MenuItem_MainPage);
		MenuItem_MainPage.addActionListener(ct);
		
		
	
		JMenuItem MenuItem_exit = new JMenuItem("Exit");
		menuBar_File.add(MenuItem_exit);
		MenuItem_exit.addActionListener(ct);
		
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(255, 255, 255));
		menuBar.add(separator);
		
		JMenu menuBar_Author = new JMenu("Author");
		menuBar_Author.setFont(new Font("Arial", Font.PLAIN, 12));
		menuBar.add(menuBar_Author);
		
		JLabel ATDetail = new JLabel("D\u01B0\u01A1ng T\u1EA5n \u0110\u1EA1t \r\nB1906643");
		menuBar_Author.add(ATDetail);
		
		JLabel JLimgBG = new JLabel(imgbackground);
		JLimgBG.setBounds(0, 0, 500, 500);
		
		
		this.add(MainPage);
		
	
	
		JLabel lblTitleHD = new JLabel("TICTACTOE");
		lblTitleHD.setForeground(new Color(40, 255, 13));
		lblTitleHD.setFont(new Font("Arial", Font.BOLD, 65));
		lblTitleHD.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitleHD.setBounds(0, 55, 490, 50);
		MainPage.add(lblTitleHD);
		
		
		JButton btnSetting = new JButton("SETTING");
		btnSetting.setToolTipText("C\u00E0i \u0110\u1EB7t");
		btnSetting.setBackground(SystemColor.control);
		btnSetting.addActionListener(ct);
		btnSetting.setForeground(new Color(255, 0, 153));
		btnSetting.setFont(new Font("Arial", Font.BOLD, 25));
		btnSetting.setBounds(331, 405, 145, 30);
		btnSetting.setCursor(new Cursor(HAND_CURSOR));
		btnSetting.setBorder(null);
		btnSetting.setOpaque(false);
        btnSetting.setContentAreaFilled(false);
        btnSetting.setBorderPainted(false);
        MainPage.add(btnSetting);
		
		JButton btnHelp = new JButton("HELP");
		btnHelp.setToolTipText("Tr\u1EE3 gi\u00FAp ng\u01B0\u1EDDi ch\u01A1i");
		btnHelp.setBackground(SystemColor.control);
		btnHelp.addActionListener(ct);
		btnHelp.setForeground(new Color(255, 0, 153));
		btnHelp.setFont(new Font("Arial", Font.BOLD, 25));
		btnHelp.setBounds(40, 405, 76, 30);
		btnHelp.setCursor(new Cursor(HAND_CURSOR));
		btnHelp.setBorder(null);
		btnHelp.setOpaque(false);
		btnHelp.setContentAreaFilled(false);
		btnHelp.setBorderPainted(false);
		MainPage.add(btnHelp);
		
	
		
		JButton btnModeAI = new JButton("Player vs AI");
		btnModeAI.setToolTipText("Ch\u01A1i v\u1EDBi M\u00E1y");
		btnModeAI.addActionListener(ct);
		btnModeAI.setForeground(SystemColor.text);
		btnModeAI.setFont(new Font("Arial Black", Font.BOLD, 30));
		btnModeAI.setBounds(105, 168, 260, 45);
		btnModeAI.setCursor(new Cursor(HAND_CURSOR));
		btnModeAI.setOpaque(false);
		btnModeAI.setContentAreaFilled(false);
		btnModeAI.setBorderPainted(false);
		MainPage.add(btnModeAI);
		
		
		JButton btnPlayers = new JButton("Player vs Player");
		btnPlayers.addActionListener(ct);
		btnPlayers.setToolTipText("2 ng\u01B0\u1EDDi ch\u01A1i");
		btnPlayers.setForeground(SystemColor.textHighlightText);
		btnPlayers.setFont(new Font("Arial Black", Font.BOLD, 30));
		btnPlayers.setBounds(60, 264, 350, 45);
		btnPlayers.setCursor(new Cursor(HAND_CURSOR));
		btnPlayers.setOpaque(false);
		btnPlayers.setContentAreaFilled(false);
		btnPlayers.setBorderPainted(false);
		MainPage.add(btnPlayers);
		
		MainPage.setOpaque(false);
		MainPage.setVisible(true);
		
		this.add(JLimgBG);
		this.setVisible(true);
	}
	public void MainPage() {
		MainPage.setVisible(true);
		HelpPage.setVisible(false);
		SettingPage.setVisible(false);
		GPPage1.setVisible(false);

	}
	
	public void HelpForm() {
		MainPage.setVisible(false);
		HelpPage.setVisible(true);
		SettingPage.setVisible(false);
		GPPage1.setVisible(false);

	}
	public void SettingForm() {
		MainPage.setVisible(false);
		HelpPage.setVisible(false);
		SettingPage.setVisible(true);
		GPPage1.setVisible(false);
	}
	public void GPForm1() {
		GPPage1.setVisible(true);
		MainPage.setVisible(false);
		HelpPage.setVisible(false);
		SettingPage.setVisible(false);
		WhoFirst();
	}	
		
	
	

	public void Reset_GP() {
		for(int i=1;i<=9;i++) {
			btn_GP[i].addActionListener(ct);
			btn_GP[i].setText("");
			viewModel.giaTriMang[i] = 0;
			btn_GP[i].setFocusable(false);
			btn_GP[i].setBackground(new Color(161,222,245));
			
		}
		jlabel_thongbao_GP.setText("");
		jpanel_win_GP.setVisible(false);
		showtime.setVisible(true);
		tie=true;
		showtime.setText("" + viewModel.TimeMode());
		second=viewModel.TimeMode();
		timer.stop();
			if(SB==1) {
				viewModel.setX(true);
			}else {
				viewModel.setX(false);
			}
			
			if(a==1) {
				viewModel.setCPF(true);
			}
			WhoFirst();
	}

	public void CPTF() {
		a=1;
	}
	public void HMF() {
		a=0;
	}
	
	
	public void xoaEvent() {
		for(int i=1;i<=9;i++) {
			btn_GP[i].removeActionListener(ct);
		}
	}
	
	int SB=1;
	public void setO() {
		viewModel.setX(false);
		SB=0;
	}
	
	public void setX() {
		viewModel.setX(true);
		SB=1;
	}
	
	public int ChooseMode() {
		if(viewModel.getCheDo()==0) {
			return viewModel.easyMove();
		}else if(viewModel.getCheDo()==1) {
			return bestmove();
		}return 0;
	}
	
	public void WhoFirst() {
		if(viewModel.isCPF()) {
			SetAI();
			viewModel.setCPF(false);
		} 
	}
	
	public void SetAI() {
		if(viewModel.isNguoi()==true) {
			viewModel.setNguoi(false);
			AIGP(btn_GP[ChooseMode()]);
			viewModel.setNguoi(true);
		}else {
			viewModel.setNguoi(false);
		}
	}
	

	
	public void AIGP(JButton jb) {
		for(int i=1; i<10;i++) {
			if(jb == btn_GP[i] && viewModel.giaTriMang[i]==0) {
				if (viewModel.isX()) {
					resettime();
					timer.start();
					
					
					btn_GP[i].setText("X");
					btn_GP[i].setForeground(Color.blue);
					viewModel.giaTriMang[i] = 1;
					viewModel.setX(false);
					check();
					
					if(check() == 2 && viewModel.isNguoi()) {
						SetAI();
					}
				}else {
					resettime();
					timer.start();
					
					
					btn_GP[i].setText("O");
					btn_GP[i].setForeground(Color.RED);
					viewModel.giaTriMang[i] = -1;
					viewModel.setX(true);
					check();
					
					if(check() == 2 && viewModel.isNguoi()) {
						SetAI();
					}
					
				}
			}
		}
	}
	
	//check
	public int check() {
		if(btn_GP[1].getText() == "X" &&
           btn_GP[2].getText() == "X" &&
           btn_GP[3].getText() == "X"   ) 
		{	XWin(1,2,3);tie = false;return 1;}
		if(btn_GP[4].getText() == "X" &&
		   btn_GP[5].getText() == "X" &&
		   btn_GP[6].getText() == "X"   )
		{		XWin(4,5,6);tie = false;return 1;}
		if(btn_GP[7].getText() == "X" &&
		   btn_GP[8].getText() == "X" &&
		   btn_GP[9].getText() == "X"   )
		{	XWin(7,8,9);tie = false;return 1;}
		if(btn_GP[1].getText() == "X" &&
		   btn_GP[5].getText() == "X" &&
		   btn_GP[9].getText() == "X"   )
		{	XWin(1,5,9);tie = false;return 1;}
		if(btn_GP[3].getText() == "X" &&
		   btn_GP[5].getText() == "X" &&
		   btn_GP[7].getText() == "X"   )
		{	XWin(3,5,7);	tie = false;return 1;}
		if(btn_GP[1].getText() == "X" &&
		   btn_GP[4].getText() == "X" &&
	   	   btn_GP[7].getText() == "X"   )
		{	XWin(1,4,7);	tie = false;return 1;}
		if(btn_GP[2].getText() == "X" &&
		   btn_GP[5].getText() == "X" &&
		   btn_GP[8].getText() == "X"   )
		{	XWin(2,5,8);tie = false;return 1;}
		if(btn_GP[3].getText() == "X" &&
		   btn_GP[6].getText() == "X" &&
		   btn_GP[9].getText() == "X"   )
		{	XWin(3,6,9);tie = false;return 1;	}
		
				if(btn_GP[1].getText() == "O" &&
		           btn_GP[2].getText() == "O" &&
		           btn_GP[3].getText() == "O"   ) 
				{	OWin(1,2,3);tie = false;return -1;}
				if(btn_GP[4].getText() == "O" &&
				   btn_GP[5].getText() == "O" &&
				   btn_GP[6].getText() == "O"   )
				{	OWin(4,5,6);tie = false;return -1;}
				if(btn_GP[7].getText() == "O" &&
				   btn_GP[8].getText() == "O" &&
				   btn_GP[9].getText() == "O"   )
				{	OWin(7,8,9);tie = false;return -1;}
				if(btn_GP[1].getText() == "O" &&
				   btn_GP[5].getText() == "O" &&
				   btn_GP[9].getText() == "O"   )
				{	OWin(1,5,9);tie = false;return -1;}
				if(btn_GP[3].getText() == "O" &&
				   btn_GP[5].getText() == "O" &&
				   btn_GP[7].getText() == "O"   )
				{	OWin(3,5,7);tie = false;return -1;}
				if(btn_GP[1].getText() == "O" &&
				   btn_GP[4].getText() == "O" &&
			   	   btn_GP[7].getText() == "O"   )
				{	OWin(1,4,7);	tie = false;return -1;}
				if(btn_GP[2].getText() == "O" &&
				   btn_GP[5].getText() == "O" &&
				   btn_GP[8].getText() == "O"   )
				{	OWin(2,5,8);	tie = false;return -1;}
				if(btn_GP[3].getText() == "O" &&
				   btn_GP[6].getText() == "O" &&
				   btn_GP[9].getText() == "O"   )
				{	OWin(3,6,9);	tie = false;return -1;}
				if(tie ==true && viewModel.kiemTraDay()==true) {
					draw();
					return 0;
				
				}
				return 2;
	}
	
	
	public void draw() {
		xoaEvent();
		jpanel_win_GP.setVisible(true);
		jlabel_thongbao_GP.setText("DRAW");
		showtime.setVisible(false);
		timer.stop();
	}
	

	
	public void XWin(int a,int b,int c) {
		for(int i=1;i<10;i++) {
			btn_GP[i].removeActionListener(ct);
		}
			btn_GP[a].setContentAreaFilled(true);
			btn_GP[a].setBackground(Color.GREEN);
			btn_GP[b].setContentAreaFilled(true);
			btn_GP[b].setBackground(Color.GREEN);
			btn_GP[c].setContentAreaFilled(true);
			btn_GP[c].setBackground(Color.GREEN);
		showtime.setVisible(false);
		jpanel_win_GP.setVisible(true);
		jlabel_thongbao_GP.setText("X WIN");
		timer.stop();
	}
	
	public void OWin(int a,int b,int c) {
		for(int i=1;i<10;i++) {
			btn_GP[i].removeActionListener(ct);
		}
			btn_GP[a].setContentAreaFilled(true);
			btn_GP[a].setBackground(Color.GREEN);
			btn_GP[b].setContentAreaFilled(true);
			btn_GP[b].setBackground(Color.GREEN);
			btn_GP[c].setContentAreaFilled(true);
			btn_GP[c].setBackground(Color.GREEN);
			showtime.setVisible(false);
			jpanel_win_GP.setVisible(true);
			jlabel_thongbao_GP.setText("O WIN");
		timer.stop();
	}
	
	//time
	public void resettime() {
		showtime.setText("" +viewModel.TimeMode());
		second=viewModel.TimeMode();
	}
	public void countdownTimer() {
		
		timer = new Timer(1000, new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				second--;
				cdSecond = dFormat.format(second);
				showtime.setText(cdSecond);
				
				if(second==0) {
					timer.stop();
					if(viewModel.isNguoi() == true) {
						xoaEvent();
						jpanel_win_GP.setVisible(true);
						jlabel_thongbao_GP.setText("O WIN");
						showtime.setVisible(false);
					}else  {
						xoaEvent();
						jpanel_win_GP.setVisible(true);
						jlabel_thongbao_GP.setText("X WIN");
						showtime.setVisible(false);
					}
				}
			
			}
			
	
		});
	}
	
	public int bestmove() {
		int bestscore = -999;
		int x=0;
		for(int i=1;i<10;i++) {
			if(viewModel.giaTriMang[i]== 0 && !viewModel.isX()) {
				viewModel.giaTriMang[i]= -1;
				int score =  minimax(viewModel.giaTriMang,false);
				viewModel.giaTriMang[i]= 0;
				if(score > bestscore) {
					x=i;
					bestscore = score;
				}
			}else if (viewModel.giaTriMang[i]== 0 && viewModel.isX()) {
				viewModel.giaTriMang[i]= 1;
				int score =  minimax(viewModel.giaTriMang,false);
				viewModel.giaTriMang[i]= 0;
				if(score > bestscore) {
					x=i;
					bestscore = score;
				}
			}
		
		}return x;
	}
	
	public int scores(int kq) {
		if(!viewModel.isX()) {
			if(kq == 1) {
				return -10;
			}else if(kq == -1) {
				return 10;
			}
			if (kq == 0)
				return 0;
			return -100;
		}
		else {
			if(kq == 1) {
				return 10;
			}else if(kq == -1) {
				return -10;
			}
			if (kq == 0)
				return 0;
			return -100;
			
		}
	}
	
	public int minimax(int giaTriMang[],boolean isMax) {
		int ketQua = viewModel.fakecheck();
		if (ketQua !=2) {
			return scores(ketQua);
		}
		if(isMax) {
			int bestScore = -999;
			for (int i = 1; i < 10;i++) {
				if (viewModel.giaTriMang[i] ==0) {
					if(viewModel.isX()) {
						viewModel.giaTriMang[i] = 1;
					}else {
						viewModel.giaTriMang[i] = -1;
					}
					int score = minimax(viewModel.giaTriMang, false);
					viewModel.giaTriMang[i] = 0;
					bestScore = Math.max(score, bestScore);
				}
			}
			return bestScore;
		} else {
			int bestScore = +999;
			for (int i = 1; i < 10;i++) {
				if (viewModel.giaTriMang[i] ==0) {
					if(viewModel.isX()) {
						viewModel.giaTriMang[i] = -1;
					}else {
						viewModel.giaTriMang[i] = 1;
					}
					int score = minimax(viewModel.giaTriMang, true);
					viewModel.giaTriMang[i] = 0;
					bestScore = Math.min(score, bestScore);
				}
			}
			return bestScore;
		}
	}
	
	
}	






