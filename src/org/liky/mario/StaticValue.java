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
	
	public static BufferedImage marioDeadImage = null;
	
	public static String imagePath = System.getProperty("user.dir")+"/src/";
	
	//public static String imagePath = System.getProperty("C:\Users\\Administrator\\Desktop\\Mario\\src");
	
	
<<<<<<< HEAD
=======
	public static String imagePath = System.getProperty("user.dir")+"/src/";
>>>>>>> 5c1793a32198be149019876d8d228dff7c35574a
	
	//将全部照片初始化
	public static void init() {
		
		// 将Mario所有图片导入静态属性中
		for(int i = 1; i <= 10; i++) {
		//	ImageIO.read(new File(System.getProperty("user.dir")"/bin/"+i+".gif"));
		//	ImageIO.read(new File(System.getProperty("user.dir")"/src"+i+".gif"));
			try {
<<<<<<< HEAD
		//		File filetest = new File(imagePath+i+".gif");
		//		System.out.println(filetest);
=======
	//			System.out.println(imagePath);
>>>>>>> 5c1793a32198be149019876d8d228dff7c35574a
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
					allTriangleImage.add(ImageIO.read(new File(imagePath+"triangle"+i+".gif")));
				}
				
				allTurtleImage.add(ImageIO.read(new File(imagePath+"Turtle"+i+".gif")));
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		// 导入障碍物的图片
		for(int i = 1; i <= 12; i++ ) {
			try {
				allObstructionImage.add(ImageIO.read(new File(imagePath+"ob"+i+".gif")));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		// 导入Mario死亡的照片
		
		try {
			marioDeadImage = ImageIO.read(new File(imagePath+"over.gif"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
}
