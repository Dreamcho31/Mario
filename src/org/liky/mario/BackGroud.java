package org.liky.mario;

import java.awt.List;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javafx.scene.layout.Background;

public class BackGroud {
	// 当前场景的显示图片
	private BufferedImage bgImage = null;
	public BufferedImage getBgImage() {
		return bgImage;
	}

	// 场景的顺序
	private int sort;
	
	// 当前场景是否为最后一个场景
	private boolean flag;
	
	//通过集合来保存；
	// 全部的敌人   
//	List allEnemy = new ArrayList<>();     !!!!!! Attention  !!!! 更改不一样

	private ArrayList allEnemy = new ArrayList();
	// 全部的障碍物
	private ArrayList<Obstruction> allObstruction = new ArrayList<Obstruction>();
	// 被消灭的敌人
	private ArrayList removedEnemy = new ArrayList();
	// 被消灭的障碍物
	private ArrayList removedObstruction = new ArrayList();
	//构造方法
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
	
	//重置方法，将所有的障碍物和敌人返回到原有坐标，并将其状态也修改
	public void reset() {
		;
	}
	
	
}
