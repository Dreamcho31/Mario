package org.liky.mario;

import java.awt.image.BufferedImage;

public class Obstruction {
	// 坐标
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

	private int y;
	
	// 类型
	private int type;
	// 初始的类型		
	private int startType;
	// 显示图片
	private BufferedImage showImage = null;
	
	/**
	 * @return the showImage
	 */
	public BufferedImage getShowImage() {
		return showImage;
	}

	/**
	 * @param showImage the showImage to set
	 */
	public void setShowImage(BufferedImage showImage) {
		this.showImage = showImage;
	}

	//构造方法
	public Obstruction(int x, int y, int type) {
		this.x = x;
		this.y = y;
		this.type = type;
		setImage();
	}
	
	// 充值方法
	public void reset() {
		//修改类型为原始类型
		this.type = startType;
		// 改变显示图片
		this.setImage();	
	}
	
	// 根据类型改变显示图片
	public void setImage() {
	//	StaticValue.init();
		showImage = StaticValue.allObstructionImage.get(type);
	}
	
	
}
