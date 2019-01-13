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
	
	//��ȫ����Ƭ��ʼ��
	public static void init() {
		// ��Mario����ͼƬ���뾲̬������
		for(int i = 1; i <= 10; i++) {
		//	ImageIO.read(new File(System.getProperty("user.dir")"/bin/"+i+".gif"));
		//	ImageIO.read(new File(System.getProperty("user.dir")"/src"+i+".gif"));
			try {
				allMarioImage.add(ImageIO.read(new File(imagePath+i+".gif")));
			}catch (IOException e) {
				e.printStackTrace();
			} 
			
		}
		// ����ȫ������ͼƬ
		try {
			startImage = ImageIO.read(new File(imagePath+"start.gif"));
			bgImage = ImageIO.read(new File(imagePath+"firststage.gif"));
			endImage = ImageIO.read(new File(imagePath+"firststageend.gif"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// �������е��˵���Ƭ
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
		
		// �����ϰ����ͼƬ
		for(int i = 1; i <= 12; i++ ) {
			try {
				allFlowerImage.add(ImageIO.read(new File(imagePath+"ob"+i+".gif")));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		// ����Mario��������Ƭ
		
		try {
			allFlowerImage.add(ImageIO.read(new File(imagePath+"over.gif")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
}
