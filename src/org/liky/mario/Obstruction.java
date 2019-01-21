package org.liky.mario;

import java.awt.image.BufferedImage;

public class Obstruction {
	// ����
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
	
	// ����
	private int type;
	// ��ʼ������		
	private int startType;
	// ��ʾͼƬ
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

	//���췽��
	public Obstruction(int x, int y, int type) {
		this.x = x;
		this.y = y;
		this.type = type;
		setImage();
	}
	
	// ��ֵ����
	public void reset() {
		//�޸�����Ϊԭʼ����
		this.type = startType;
		// �ı���ʾͼƬ
		this.setImage();	
	}
	
	// �������͸ı���ʾͼƬ
	public void setImage() {
	//	StaticValue.init();
		showImage = StaticValue.allObstructionImage.get(type);
	}
	
	
}
