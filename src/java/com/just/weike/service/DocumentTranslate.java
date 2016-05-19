package com.just.weike.service;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import static java.lang.System.out;
import org.apache.jasper.tagplugins.jstl.core.Catch;
import org.apache.poi.hslf.model.Slide;

import org.apache.poi.hslf.model.TextRun;
import org.apache.poi.hslf.usermodel.RichTextRun;
import org.apache.poi.hslf.usermodel.SlideShow;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFSlide;

public class DocumentTranslate {

    public static boolean doPPTtoImage(File file) {
        boolean isppt = checkFile(file);
        if (!isppt) {
            System.out.println("The image you specify don't exit!");
            return false;
        }
        try {

            FileInputStream is = new FileInputStream(file);
            SlideShow ppt = new SlideShow(is);
            is.close();
            Dimension pgsize = ppt.getPageSize();
            org.apache.poi.hslf.model.Slide[] slide = ppt.getSlides();
            for (int i = 0; i < slide.length; i++) {
                System.out.print("��" + i + "ҳ��");

                TextRun[] truns = slide[i].getTextRuns();
                for (int k = 0; k < truns.length; k++) {
                    RichTextRun[] rtruns = truns[k].getRichTextRuns();
                    for (int l = 0; l < rtruns.length; l++) {
                        int index = rtruns[l].getFontIndex();
                        String name = rtruns[l].getFontName();
                        rtruns[l].setFontIndex(1);
                        rtruns[l].setFontName("����");
                    }
                }
                BufferedImage img = new BufferedImage(pgsize.width,
                        pgsize.height, BufferedImage.TYPE_INT_RGB);

                Graphics2D graphics = img.createGraphics();
                graphics.setPaint(Color.white);
                graphics.fill(new Rectangle2D.Float(0, 0, pgsize.width,
                        pgsize.height));
                slide[i].draw(graphics);

                // ��������ͼƬ�Ĵ��·����ͼƬ�ĸ�ʽ(jpeg,png,bmp�ȵ�),ע�������ļ�·��
                System.out.print(getFileNameNoEX(file.getName()));

                File path = new File("E:\\tempupload\\" + getFileNameNoEX(file.getName()));

                if (!path.exists()) {
                    path.mkdir();
                }
                FileOutputStream out = new FileOutputStream(path + "\\pict_"
                        + (i + 1) + ".jpeg");
                javax.imageio.ImageIO.write(img, "jpeg", out);
                out.close();

            }
            System.out.println("success!!");
            return true;
        } catch (FileNotFoundException e) {
            System.out.println(e);
            // System.out.println("Can't find the image!");
        } catch (IOException e) {
        }
        return false;
    }

    // function ����ļ��Ƿ�ΪPPT
    public static boolean checkFile(File file) {

        boolean isppt = false;
        String filename = file.getName();
        String suffixname = null;
        if (filename != null && filename.indexOf(".") != -1) {
            suffixname = filename.substring(filename.lastIndexOf("."));
            if (suffixname.equals(".ppt")) {
                isppt = true;
            }
            return isppt;
        } else {
            return isppt;
        }
    }

    private static String getFileNameNoEX(String name) {
        if (name != null && name.length() > 0) {
            int dot = name.lastIndexOf(".");
            if (dot > -1 && dot < name.length()) {
                return name.substring(0, dot);
            }
        }
        return name;
    }

    public static boolean doPPTtoImage2007(File file, String path, String picName, String picType, int width, int height) {
        try {
            boolean isppt = checkFile(file);
            if (!isppt) {
                return false;
            }
            FileInputStream is = new FileInputStream(file);
            XMLSlideShow xmlSlideShow = new XMLSlideShow(is);
            XSLFSlide[] xslfSlides = xmlSlideShow.getSlides();

            is.close();
            for (int i = 0; i < xslfSlides.length; i++) {

                System.out.print("第" + i + "页。");
                BufferedImage img = new BufferedImage(width,
                        height, BufferedImage.TYPE_INT_RGB);

                Graphics2D graphics = img.createGraphics();
                graphics.setPaint(Color.white);
                graphics.fill(new Rectangle2D.Float(0, 0, width,
                        height));
                xslfSlides[i].draw(graphics);

                FileOutputStream out = new FileOutputStream(path + "/" + picName + "_"
                        + (i + 1) + "." + picType);
                javax.imageio.ImageIO.write(img, "jpeg", out);
                out.close();
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * PPT转图片 （jpeg）(2003)
     *
     * @param file
     * @param path 存放路径
     * @param picName 图片前缀名称 如 a 生成后为a_1,a_2 ...
     * @param picType 转成图片的类型，无点 如 jpg bmp png ...
     * @return true/false
     */
    public static boolean doPPTtoImage(File file, String path, String picName, String picType, int width, int height) {
        boolean isppt = checkFile(file);
        if (!isppt) {
            return false;
        }
        try {
            FileInputStream is = new FileInputStream(file);
            SlideShow ppt = new SlideShow(is);
            is.close();
            Dimension pgsize = ppt.getPageSize();
            if(height >= 480){
                width =  (int)pgsize.getWidth();
                height = (int)pgsize.getHeight();
            }
            Slide[] slide = ppt.getSlides();
            for (int i = 0; i < slide.length; i++) {

                System.out.print("第" + i + "页。");
                BufferedImage img = new BufferedImage(width,
                        height, BufferedImage.TYPE_INT_RGB);

                Graphics2D graphics = img.createGraphics();
                int backgroundColor = slide[i].getColorScheme()
                        .getBackgroundColourRGB();
                graphics.setPaint(new Color(backgroundColor));
                graphics.fill(new Rectangle2D.Float(0, 0, width,
                        height));
                slide[i].getBackground().draw(graphics);
                slide[i].draw(graphics);

                FileOutputStream out = new FileOutputStream(path + "/" + picName + "_"
                        + (i + 1) + "." + picType);
                javax.imageio.ImageIO.write(img, "png", out);
                out.close();

            }
            return true;
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
        }
        return false;
    }

}
