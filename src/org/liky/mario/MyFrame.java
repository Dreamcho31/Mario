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
		this.setTitle("�������Ϸ����");
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
		 
		
		//��ʼ��ȫ����Ƭ
		StaticValue.init();
		
		// ����ȫ������
		 for(int i = 1; i <= 3; i++) {
			 this.allBG.add(new BackGroud(i,i==3?true:false));	
		 }
		// ����һ����������Ϊ��ǰ����
		this.nowBG = this.allBG.get(0);
		
		// ��ʼ��Mario����
		this.mario = new Mario(0, 480);
		
		//����������Mario�����������
		this.mario.setBg(nowBG);
		
		
		t.start();
		
		this.repaint();
	}
	
	
	//  �������Ƶ�Ĳ�һ���� ��Ƶ�� public void paint��Graphics g��  !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		//super.paintComponents(arg0);
		// ������ʱ�Ļ���ͼƬ
		BufferedImage image = new BufferedImage(900, 600, BufferedImage.TYPE_3BYTE_BGR);
		Graphics g2 = image.getGraphics();
		//���Ʊ���
		g2.drawImage(this.nowBG.getBgImage(), 0, 0, this);
		//�����ϰ���(����)
		Iterator<Obstruction>iter = this.nowBG.getAllObstruction().iterator();
		while(iter.hasNext()) {
			Obstruction ob = iter.next();
			g2.drawImage(ob.getShowImage(), ob.getX(), ob.getY(), this);
		}
		
		
		g2.drawImage(this.mario.getShowImage(), this.mario.getX(), this.mario.getY(), this);
		
		//�ѻ���ͼƬ���Ƶ�������
		g.drawImage(image, 0, 0, this);
		  
	}

	// ����������ϵ�ĳһ����ʱ
	@Override
	public void keyPressed(KeyEvent ke) {
		// TODO Auto-generated method stub
//		arg0.getKeyChar();
//		arg0.getKeyCode();
//		System.out.println(arg0.getKeyCode());
		//������39ʱ��--����,mario �����ƶ�
		if(ke.getKeyCode() == 39) {
			this.mario.rightMove();
		}
		//������37ʱ��--����,mario �����ƶ�
		if(ke.getKeyCode() == 37) {
			this.mario.leftMove();
		}
	}

	//��̧�������ĳһ����ʱ
	@Override
	public void keyReleased(KeyEvent ke) {
		// TODO Auto-generated method stub
		if(ke.getKeyCode() == 39) {
			this.mario.rightStop();
		}
		//������37ʱ��--����,mario �����ƶ�
		if(ke.getKeyCode() == 37) {
			this.mario.lefeStop();
		}
	}

	//����������һЩ��Ϣʱ
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
