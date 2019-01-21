package org.liky.mario;

import java.awt.image.BufferedImage;

public class Mario implements Runnable{
	//����
	private int x;
	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}


	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}


	/**
	 * @return the showImage
	 */
	public BufferedImage getShowImage() {
		return showImage;
	}

	private int y;
	//״̬
	
	//����һ���������󣬱��浱ǰMario���ڵĳ���
	private BackGroud bg ;
	
	/**
	 * @param bg the bg to set
	 */
	public void setBg(BackGroud bg) {
		this.bg = bg;
	}

	private String status;
	// ��ʾ��ͼƬ
	private BufferedImage showImage;
	//�����߳�
	private Thread t = null;
	//�����ƶ��ٶ�
	private int xmove = 0;
	
	//��ʾ�������ͷ���
	private int score;
	private int life;
	
	// ��ǰ�ƶ�����ʾ��ͼƬ����
	private int moving = 0;
	
	
	//���췽��
	public Mario(int x, int y) {
		this.x = x;
		this.y = y;
		//��ʼ��MarioͼƬ
		this.showImage = StaticValue.allMarioImage.get(0);
		this.score = 0;
		this.life = 3;
		
		t = new Thread(this);
		t.start();
		
		
		this.status = "right--standing";
	}
	
	
	public void leftMove() {
		//�ı��ٶ�
		xmove = -5;
		//�ı�״̬
		this.status = "left--moving";
	}
	
	public void rightMove() {
		xmove = 5;
		this.status = "right--moving";
	}
	
	public void lefeStop() {
		this.xmove = 0;
		this.status = "left--standing";
	}
	
	public void rightStop() {
		this.xmove = 0;
		this.status = "right--standing";
	}
	
	
	public void jump() {
		
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			//�жϵ�ǰMario�Ƿ����ϰ�����ײ
			//������
			boolean canLeft = true;
			boolean canRight = true;
			for(int i = 0; i < this.bg.getAllObstruction().size(); i++) {
				Obstruction ob = this.bg.getAllObstruction().get(1);
				//��������������ƶ�
				if(ob.getX() == this.x + 60 && (ob.getY() + 60 > this.y && ob.getY() - 60 < this.y)) {
					canRight = false;
				}
				
				//��������������ƶ�
				if(ob.getX() == this.x - 60 && (ob.getY() + 60 > this.y && ob.getY() - 60 < this.y)) {
					canLeft = false;
				}
			}
			
			if(canLeft && xmove < 0 || (canRight && xmove > 0 )) {
				//�ı�����
				x += xmove;
			}
			
			
			//����һ��ͼƬȡ�õĳ�ʼ������
			int temp = 0;
			//��ǰΪ������
			if(this.status.indexOf("right") == -1) {
				temp += 5 ;
			}
			
			
			
			//�жϵ�ǰ�Ƿ�Ϊ�ƶ�
			if(this.status.indexOf("moving") != -1) {
				temp += this.moving;
				moving++;
				if(moving == 4) {
					moving = 0;
				}
			}
			
			//�ı���ʵͼƬ
			this.showImage = StaticValue.allMarioImage.get(temp);
			
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	 
}
