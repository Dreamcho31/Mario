package org.liky.mario;

import java.awt.List;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javafx.scene.layout.Background;

public class BackGroud {
	// ��ǰ��������ʾͼƬ
	private BufferedImage bgImage = null;
	public BufferedImage getBgImage() {
		return bgImage;
	}

	// ������˳��
	private int sort;
	
	// ��ǰ�����Ƿ�Ϊ���һ������
	private boolean flag;
	
	//ͨ�����������棻
	// ȫ���ĵ���   
//	List allEnemy = new ArrayList<>();     !!!!!! Attention  !!!! ���Ĳ�һ��

	private ArrayList allEnemy = new ArrayList();
	// ȫ�����ϰ���
	private ArrayList<Obstruction> allObstruction = new ArrayList<Obstruction>();
	// ������ĵ���
	private ArrayList removedEnemy = new ArrayList();
	// ��������ϰ���
	private ArrayList removedObstruction = new ArrayList();
	//���췽��
	public BackGroud(int sort, boolean flag) {
		this.sort = sort;
		this.flag = flag;
		if(flag) {
			bgImage = StaticValue.endImage;
		}else {
			bgImage = StaticValue.bgImage;
		}
		if(1 == sort) {
			for(int i = 0; i < 15; i++) {
				this.allObstruction.add(new Obstruction(i*60, 540, 9));
			}
		}
	}	
	
	//���÷����������е��ϰ���͵��˷��ص�ԭ�����꣬������״̬Ҳ�޸�
	public void reset() {
		;
	}
	
	
}
