package org.liky.mario;

import java.awt.image.BufferedImage;
import java.io.File;
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
	
	//将全部照片初始化
	public static void inti() {
		for(int i = 1; i <= 10; i++) {
		//	ImageIO.read(new File(System.getProperty("user.dir")"/bin/"+i+".gif"));
			ImageIO.read(new File(System.getProperty("user.dir")"/src"+i+".gif"));
		}
	}
	
}
