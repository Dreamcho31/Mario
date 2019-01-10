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
		this.setTitle("马里奥游戏程序");
		this.setSize(900,600);
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
		int height = Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setLocation((width-900)/2, (height-600)/2);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		
		this.setResizable(false);
		
		this.addKeyListener(this);
		
		
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
