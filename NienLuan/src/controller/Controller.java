package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import view.ViewMain;
import model.ViewModel;


public class Controller implements ActionListener,MouseListener{
	private ViewMain viewMain;	
	private Random random;
	private ViewModel viewModel;

	public Controller(ViewMain viewMain) {
		this.viewMain = viewMain;
	
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();
		if(s.equals("HELP")) {
			this.viewMain.HelpForm();
		}else if(s.equals("Exit")) {
			System.exit(0);
		}else if(s.equals("Main Page")) {
			viewMain.MainPage();
			viewMain.Reset_GP();
		}else if(s.equals("BACK")) {
			viewMain.MainPage();
			viewMain.Reset_GP();
		}else if(s.equals("SETTING")) {
			viewMain.SettingForm();
		}else if(s.equals("Player vs Player")) {
			viewMain.GPForm1();
			viewMain.viewModel.setNguoi(false);
			viewMain.viewModel.setTime(10);
		}else if(s.equals("Player vs AI")) {
			viewMain.GPForm1();
			viewMain.WhoFirst();
			viewMain.viewModel.setNguoi(true);
		}else if(s.equals("RESET")) {
			viewMain.Reset_GP();
		}else if(s.equals("Choose X")) {
			viewMain.setX();
		}else if(s.equals("Choose O")) {
			viewMain.setO();
		}else if(s.equals("EASY")) {
			viewMain.viewModel.setCheDo(0);
			viewMain.viewModel.setTime(10);
			viewMain.viewModel.changecolor(viewMain.btn_chon_easy_setting);
			viewMain.viewModel.resetcolor(viewMain.btn_chon_hard_setting);
		}else if(s.equals("HARD")) {
			viewMain.viewModel.setCheDo(1);
			viewMain.viewModel.setTime(5);
			viewMain.viewModel.changecolor(viewMain.btn_chon_hard_setting);
			viewMain.viewModel.resetcolor(viewMain.btn_chon_easy_setting);
		}else if(s.equals("You First")) {
			viewMain.viewModel.setCPF(false);
			viewMain.HMF();
		}else if(s.equals("Computer First")) {
			viewMain.viewModel.setCPF(true);
			viewMain.CPTF();
		}
		
		
		
		
		
		for(int i=1;i<10;i++) {
			if(e.getSource()==viewMain.btn_GP[i]) {
				viewMain.AIGP(viewMain.btn_GP[i]);
			}
		}
		
		
		
		
	}
		
		
		
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	
	
	
}
