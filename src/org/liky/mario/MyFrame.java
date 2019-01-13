package org.liky.mario;

import java.awt.Graphics;
import java.awt.List;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JFrame;

public class MyFrame extends JFrame implements KeyListener {

	private ArrayList<BackGroud> allBG= new ArrayList<BackGroud>();
		
	private BackGroud nowBG = null;
	
	
	
	public static void main(String[] args) {
		new MyFrame();
	}
	
	public MyFrame() {
		this.setTitle("马里奥游戏程序");
		this.setSize(900,600);
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
		int height = Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setLocation((width-900)/2, (height-600)/2);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		
		this.setResizable(false);
		
		this.addKeyListener(this);	
		
		//初始化全部照片
		StaticValue.init();
		
		// 创建全部场景
		 for(int i = 1; i <= 3; i++) {
			 this.allBG.add(new BackGroud(i,i==3?true:false));	
		 }
		// 将第一个场景设置为当前场景
		this.nowBG = this.allBG.get(0);
		
		this.repaint();
	}
	
	
	
	@Override
	public void paintComponents(Graphics g) {
		// TODO Auto-generated method stub
		//super.paintComponents(arg0);
		// 建立临时的缓冲图片
		BufferedImage image = new BufferedImage(900, 600, BufferedImage.TYPE_3BYTE_BGR);
		Graphics g2 = image.getGraphics();
		g2.drawImage(this.nowBG.getBgImage(),0, 0, this);
		
		//把缓冲图片绘制到窗体中
		g.drawImage(image, 0, 0, this);
		 
	}

	// 当点击键盘上的某一个键时
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
//		arg0.getKeyChar();
//		arg0.getKeyCode();
		System.out.println(arg0.getKeyCode());
	}

	//当抬起键盘上某一个键时
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	//当键盘输入一些信息时
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}
