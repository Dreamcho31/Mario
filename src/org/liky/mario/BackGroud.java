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
	/**
	 * @return the allObstruction
	 */
	public ArrayList<Obstruction> getAllObstruction() {
		return allObstruction;
	}

	/**
	 * @param allObstruction the allObstruction to set
	 */
	public void setAllObstruction(ArrayList<Obstruction> allObstruction) {
		this.allObstruction = allObstruction;
	}

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
			//���Ƶ���
			for(int i = 0; i < 15; i++) {
				this.allObstruction.add(new Obstruction(i*60, 540, 9));
			}
			//����ש��
			this.allObstruction.add(new Obstruction(120, 360, 4));
			this.allObstruction.add(new Obstruction(300, 360, 0));
			this.allObstruction.add(new Obstruction(360, 360, 4)); 
			this.allObstruction.add(new Obstruction(420, 360, 0));
			this.allObstruction.add(new Obstruction(480, 360, 4));
			this.allObstruction.add(new Obstruction(540, 360, 0));
			this.allObstruction.add(new Obstruction(420, 180, 4));
			//����ˮ��
			this.allObstruction.add(new Obstruction(660, 540, 6));
			this.allObstruction.add(new Obstruction(720, 540, 5));
			this.allObstruction.add(new Obstruction(660, 480, 8));
			this.allObstruction.add(new Obstruction(720, 480, 7));
		}
	}	
	
	//���÷����������е��ϰ���͵��˷��ص�ԭ�����꣬������״̬Ҳ�޸�
	public void reset() {
		;
	}
	
	
}
