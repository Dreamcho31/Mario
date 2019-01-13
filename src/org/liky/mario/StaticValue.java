package org.liky.mario;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class StaticValue {
	
	public static List<BufferedImage>allMarioImage = new ArrayList<BufferedImage>();
	
	public static BufferedImage startImage = null;
	
	public static BufferedImage endImage = null;
	
	public static BufferedImage bgImage = null;
	
	public static List<BufferedImage>allFlowerImage = new ArrayList<BufferedImage>();
	
	public static List<BufferedImage>allTriangleImage = new ArrayList<BufferedImage>();
	
	public static List<BufferedImage>allTurtleImage = new ArrayList<BufferedImage>();
	
	public static List<BufferedImage>allObstructionImage = new ArrayList<BufferedImage>();
	
	public static BufferedImage marioDeadImge = null;
	
	public static String imagePath = System.getProperty("user.dir")+"/src";
	
	//将全部照片初始化
	public static void init() {
		// 将Mario所有图片导入静态属性中
		for(int i = 1; i <= 10; i++) {
		//	ImageIO.read(new File(System.getProperty("user.dir")"/bin/"+i+".gif"));
		//	ImageIO.read(new File(System.getProperty("user.dir")"/src"+i+".gif"));
			try {
				allMarioImage.add(ImageIO.read(new File(imagePath+i+".gif")));
			}catch (IOException e) {
				e.printStackTrace();
			} 
			
		}
		// 导入全部背景图片
		try {
			startImage = ImageIO.read(new File(imagePath+"start.gif"));
			bgImage = ImageIO.read(new File(imagePath+"firststage.gif"));
			endImage = ImageIO.read(new File(imagePath+"firststageend.gif"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 导入所有敌人的照片
		for(int i = 1; i <= 5; i++ ) {
			try {
				if(i <= 2 ) {
					allFlowerImage.add(ImageIO.read(new File(imagePath+"flower"+i+".gif")));
				}
				
				if(i <= 3 ) {
					allFlowerImage.add(ImageIO.read(new File(imagePath+"triangle"+i+".gif")));
				}
				
				allFlowerImage.add(ImageIO.read(new File(imagePath+"Turtle"+i+".gif")));
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		// 导入障碍物的图片
		for(int i = 1; i <= 12; i++ ) {
			try {
				allFlowerImage.add(ImageIO.read(new File(imagePath+"ob"+i+".gif")));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		// 导入Mario死亡的照片
		
		try {
			allFlowerImage.add(ImageIO.read(new File(imagePath+"over.gif")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
}
