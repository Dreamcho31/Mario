package org.liky.mario;

import java.awt.image.BufferedImage;

public class Obstruction {
	// ����
	private int x;
	private int y;
	
	// ����
	private int type;
	// ��ʼ������		
	private int startType;
	// ��ʾͼƬ
	private BufferedImage showImage = null;
	
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
		showImage = StaticValue.allObstructionImage.get(type);
	}
	
	
}
