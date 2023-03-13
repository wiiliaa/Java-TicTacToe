package model;

import java.awt.Color;
import java.util.Random;

import javax.swing.JButton;

public class ViewModel {
	private boolean nguoi; // true la nguoi danh, false la may
	private int cheDo; // nguoi 0, de la 1;
	public int giaTriMang[];
	private int giaTriVT; // 0 la chua danh, danh
	private boolean quanX;	// x di
	private boolean CPF;
	private int Time;
	public ViewModel() {
		quanX = true;
		cheDo = 0;
		khoiTaoMang();
		nguoi = true;
		CPF = false;
		Time =10;
	}
	
	public void setTime (int Time) {
		this.Time= Time;
	}
	public int TimeMode() {
		return Time;
	}
	public boolean isX() {
		return quanX;
	}
	
	public void setX(boolean quanX) {
		this.quanX = quanX;
	}
	

	public boolean isCPF() {
		return CPF;
	}
	public void setCPF(boolean CPF) {
		this.CPF = CPF;
	}
	

	public boolean isNguoi() {
		return nguoi;
	}
	public void setNguoi(boolean nguoi) {
		this.nguoi = nguoi;
	}
	public int getCheDo() {
		return cheDo;
	}
	public void setCheDo(int cheDo) {
		this.cheDo = cheDo;
	}
	
	public int getGiaTriVT(int x) {
		return giaTriMang[x];
	}
	public void setGiaTriVT(int x, int a) {
		giaTriMang[x] = a;
	}
	
	public void khoiTaoMang() {
		giaTriMang = new int[10];
		for(int i=1; i<=9;i++) {
			giaTriMang[i] = 0;
		}
	}
	
	
	public boolean kiemTraDay() {
		int i;
		for(i=1;i <= 9; i++) {
			if(giaTriMang[i] == 0) {
				return false;
			}
		}
		return true;
	}
	
	
	public int easyMove() {
		
		Random rd = new Random();
		int x= rd.nextInt(9)+1;
		if(!kiemTraDay()) {
			while(giaTriMang[x]!=0) {
				x= rd.nextInt(9)+1;
			}
			return x;
		}
		return 0;
	}
	
	public int fakecheck() {
		if(giaTriMang[1] + giaTriMang[2] + giaTriMang[3] == 3
			|| giaTriMang[4] + giaTriMang[5] + giaTriMang[6] == 3
			|| giaTriMang[7] + giaTriMang[8] + giaTriMang[9] == 3
			|| giaTriMang[1] + giaTriMang[4] + giaTriMang[7] == 3
			|| giaTriMang[2] + giaTriMang[5] + giaTriMang[8] == 3
			|| giaTriMang[3] + giaTriMang[6] + giaTriMang[9] == 3
			|| giaTriMang[1] + giaTriMang[5] + giaTriMang[9] == 3
			|| giaTriMang[3] + giaTriMang[5] + giaTriMang[7] == 3) {
			return 1;
		}
		else if(giaTriMang[1] + giaTriMang[2] + giaTriMang[3] == -3
				|| giaTriMang[4] + giaTriMang[5] + giaTriMang[6] == -3
				|| giaTriMang[7] + giaTriMang[8] + giaTriMang[9] == -3
				|| giaTriMang[1] + giaTriMang[4] + giaTriMang[7] == -3
				|| giaTriMang[2] + giaTriMang[5] + giaTriMang[8] == -3
				|| giaTriMang[3] + giaTriMang[6] + giaTriMang[9] == -3
				|| giaTriMang[1] + giaTriMang[5] + giaTriMang[9] == -3
				|| giaTriMang[3] + giaTriMang[5] + giaTriMang[7] == -3) {
				return -1;
			}else if(kiemTraDay()==true) {
				return 0;
			}
		return 2;
	}
	
	public void changecolor(JButton jb) {
		jb.setBackground(Color.GREEN);
		jb.setForeground(Color.WHITE);
	}
	public void resetcolor(JButton jb) {
		jb.setForeground(new Color(255, 0, 153));
		jb.setBackground(Color.WHITE);
	}


	
	
}
