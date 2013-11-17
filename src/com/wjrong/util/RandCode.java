package com.wjrong.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;



@SuppressWarnings({ "serial" })
public class RandCode extends HttpServlet {

	protected Color getRandColor(int fc, int bc) {
		// 给定范围获得随机颜色
		Random random = new Random();
		if (fc > 255)
			fc = 255;
		if (bc > 255)
			bc = 255;
		int r = fc + random.nextInt(bc - fc);
		int g = fc + random.nextInt(bc - fc);
		int b = fc + random.nextInt(bc - fc);
		return new Color(r, g, b);
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("image/jpeg"); // 设置输出类型为jpeg图片
		
		// 在内存中创建图象
		int width = 65, height = 18;
		BufferedImage image = new BufferedImage(width, height,BufferedImage.TYPE_INT_RGB);
		
		// 获取图形上下文
		Graphics g = image.getGraphics();

		// 生成随机类
		Random random = new Random();

		// 设定背景色
		g.setColor(getRandColor(200, 250));
		g.fillRect(0, 0, width, height);

		// 设定字体
		g.setFont(new Font("Times   New   Roman", Font.PLAIN, 18));

		// 画边框
		g.setColor(new Color(100, 100, 100));
		g.drawRect(0, 0, width - 1, height - 1);

		// 随机产生155条干扰线，使图象中的认证码不易被其它程序探测到
		g.setColor(getRandColor(160, 200));
		for (int i = 0; i < 155; i++) {
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			int xl = random.nextInt(12);
			int yl = random.nextInt(12);
			g.drawLine(x, y, x + xl, y + yl);
		}

		// 取随机产生的认证码(4位数字)
		String code = "";
		String old="23456789abcdefghijkmnopqrstuvwxyzABCDEFGHIJKLMNPQRSTUVWXYZ"; //验证图片上面的随机字符
		int j=0;
		for (int i = 0; i < 4; i++) {
			j = random.nextInt(old.length());
			String rand=old.substring(j,j+1);
			code += rand;
			// 将认证码显示到图象中
			g.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110)));
			// 调用函数出来的颜色相同，可能是因为种子太接近，所以只能直接生成
			g.drawString(rand,14*i+4,15);
		}
		// 将认证码存入SESSION
		request.getSession().setAttribute("rand", code.toLowerCase());

		// 图象生效
		g.dispose();

		// 输出图象到页面
		ServletOutputStream so=response.getOutputStream();  //得到二进制输出流 
		JPEGImageEncoder je=JPEGCodec.createJPEGEncoder(so); //对图片进行编码成jpeg格式
		je.encode(image);                    
		so.flush(); //刷新缓存
		so.close();

	}
}

