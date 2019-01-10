package org.liky.mario;

import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class MyFrame extends JFrame implements KeyListener {

	public static void main(String[] args) {
		new MyFrame();
	}
	
	public MyFrame() {
		this.setTitle("�������Ϸ����");
		this.setSize(900,600);
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
		int height = Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setLocation((width-900)/2, (height-600)/2);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		
		this.setResizable(false);
		
		this.addKeyListener(this);
		
		
	}
	
	// ����������ϵ�ĳһ����ʱ
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
//		arg0.getKeyChar();
//		arg0.getKeyCode();
		System.out.println(arg0.getKeyCode());
	}

	//��̧�������ĳһ����ʱ
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	//����������һЩ��Ϣʱ
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}
