package org.liky.mario;

import java.awt.image.BufferedImage;

//import com.sun.deploy.model.DownloadDelegate;

public class Mario implements Runnable{
	//坐标
	private int x;
	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}




	/**
	 * @return the showImage
	 */
	public BufferedImage getShowImage() {
		return showImage;
	}

	private int y;
	//状态
	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	//定义一个场景对象，保存当前Mario所在的场景
	private BackGroud bg ;
	
	/**
	 * @param bg the bg to set
	 */
	public void setBg(BackGroud bg) {
		this.bg = bg;
	}

	private String status;
	// 显示的图片
	private BufferedImage showImage;
	//加入线程
	private Thread t = null;
	//定义移动速度
	private int xmove = 0;
	
	//定义一个垂直方向的速度
	private int ymove = 0; 
	
	//定义上升的时间
	private int upTime = 0;
	
	//显示生命数和分数
	private int score;
	private int life;
	
	// 当前移动中显示的图片索引
	private int moving = 0;
	
	
	//构造方法
	public Mario(int x, int y) {
		this.x = x;
		this.y = y;
		//初始化Mario图片
		this.showImage = StaticValue.allMarioImage.get(0);
		this.score = 0;
		this.life = 3;
		
		t = new Thread(this);
		t.start();
		
		
		this.status = "right--standing";
	}
	
	
	public void leftMove() {
		//改变速度
		xmove = -5;
		//改变状态
		this.status = "left--moving";
	}
	
	public void rightMove() {
		xmove = 5;
		this.status = "right--moving";
	}
	
	public void leftStop() {
		this.xmove = 0;
		this.status = "left--standing";
	}
	
	public void rightStop() {
		this.xmove = 0;
		this.status = "right--standing";
	}
	
	
	public void jump() {
		if(this.status.indexOf("jumping") == -1) {
			if(this.status.indexOf("left") != -1) {
				this.status = "left--jumping";
			}else {
				this.status = "right--jumping";
			}
			ymove = -5;
			
			upTime = 36 ;
		}
	}
	
	//加入下落的方法
	public void down() {
		if(this.status.indexOf("left") == -1) {
			if(this.status.indexOf("left") != -1) {
				this.status = "left--jumping";
			}else {
				this.status = "right--jumping";
			}
			ymove = 5;
		}	
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			//判断当前Mario是否与障碍物碰撞
			//定义标记
			boolean canLeft = true;
			boolean canRight = true;
			//定义判断当前Mario是否处于障碍物上面
			boolean onLand = false;
			
	//		System.out.println(this.bg.getAllObstruction().size());
			for(int i = 0; i < this.bg.getAllObstruction().size(); i++) {
				Obstruction ob = this.bg.getAllObstruction().get(i);
				//不允许继续向右移动
				if(ob.getX() == this.x + 60 && (ob.getY() + 60 > this.y && ob.getY() - 60 < this.y) ){
					canRight = false;
				}
				
				//不允许继续向左移动
				if(ob.getX() == this.x - 60 && (ob.getY() + 60 > this.y && ob.getY() - 60 < this.y)) {
					canLeft = false; 
				}
				//如果符合条件，则表示Mario处在一个障碍物上面
				if(ob.getY() == this.y+60 && (ob.getX() + 60 > this.x && ob.getY() -60 < this.x)){
					onLand = true; 
				} 
				
			}
			
			if(onLand && (upTime == 0)) {
				if(this.status.indexOf("left") != -1) {
					if(xmove != 0) {
						this.status = "left--moving";
					}else {
						this.status = "left--standing";
					}
					
				}else {
						this.status = "right-standing";
				}
					
				}else{
					if(xmove != 0) {
						this.status = "right--moving";
					}else {
						this.status = "right--standing";
				}
					//表示上升的状态
					if(upTime != 0) {
						upTime--;
					}else {
					this.down();
					}
					y += ymove; 
				}						
			
		/*
		}else {
				//表示当前为上升的状态
				if(upTime != 0) {
					upTime--;
				}else {
					this.down();
				}
				y += ymove;
				
			}
		*/	
			
			if(canLeft && xmove < 0 || (canRight && xmove > 0 )) {
				//改变坐标
				x += xmove;
			}
			
			
			//定义一个图片取得的初始索引数
			int temp = 0;
			//当前为面向右
			if(this.status.indexOf("right") == -1) {
				temp += 5 ;
			}
			
			
			
			//判断当前是否为移动
			if(this.status.indexOf("moving") != -1) {
				temp += this.moving;
				moving++;
				if(moving == 4) {
					moving = 0;
				}
			}
			
			//改变现实图片
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
