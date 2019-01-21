package org.liky.mario;

import java.awt.Graphics;
import java.awt.List;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;

public class MyFrame extends JFrame implements KeyListener,Runnable {

	private ArrayList<BackGroud> allBG= new ArrayList<BackGroud>();
	
	private Mario mario = null;
		
	private BackGroud nowBG = null;
	
	private Thread t = new Thread(this); 
	
	public static void main(String[] args) {
		new MyFrame();
	}
	
	public MyFrame() {
		this.setTitle("马里奥游戏程序");
		this.setSize(900,600);
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
		
		int height = Toolkit.getDefaultToolkit().getScreenSize().height;
		
		//System.out.println(height);
		//this.setLocation(0, 0);
		
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
		
		// 初始化Mario对象
		this.mario = new Mario(0, 480);
		
		//将场景放入Mario对象的属性中
		this.mario.setBg(nowBG);
		
		
		t.start();
		
		this.repaint();
	}
	
	
	//  这里跟视频的不一样， 视频是 public void paint（Graphics g）  !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		//super.paintComponents(arg0);
		// 建立临时的缓冲图片
		BufferedImage image = new BufferedImage(900, 600, BufferedImage.TYPE_3BYTE_BGR);
		Graphics g2 = image.getGraphics();
		//绘制背景
		g2.drawImage(this.nowBG.getBgImage(), 0, 0, this);
		//绘制障碍物(地面)
		Iterator<Obstruction>iter = this.nowBG.getAllObstruction().iterator();
		while(iter.hasNext()) {
			Obstruction ob = iter.next();
			g2.drawImage(ob.getShowImage(), ob.getX(), ob.getY(), this);
		}
		
		
		g2.drawImage(this.mario.getShowImage(), this.mario.getX(), this.mario.getY(), this);
		
		//把缓冲图片绘制到窗体中
		g.drawImage(image, 0, 0, this);
		  
	}

	// 当点击键盘上的某一个键时
	@Override
	public void keyPressed(KeyEvent ke) {
		// TODO Auto-generated method stub
//		arg0.getKeyChar();
//		arg0.getKeyCode();
//		System.out.println(arg0.getKeyCode());
		//当摁下39时（--》）,mario 向右移动
		if(ke.getKeyCode() == 39) {
			this.mario.rightMove();
		}
		//当摁下37时（--》）,mario 向右移动
		if(ke.getKeyCode() == 37) {
			this.mario.leftMove();
		}
	}

	//当抬起键盘上某一个键时
	@Override
	public void keyReleased(KeyEvent ke) {
		// TODO Auto-generated method stub
		if(ke.getKeyCode() == 39) {
			this.mario.rightStop();
		}
		//当摁下37时（--》）,mario 向右移动
		if(ke.getKeyCode() == 37) {
			this.mario.lefeStop();
		}
	}

	//当键盘输入一些信息时
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			this.repaint();
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
