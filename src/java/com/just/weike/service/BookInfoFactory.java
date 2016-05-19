/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.just.weike.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import org.apache.poi.hslf.usermodel.SlideShow;

/**
 *
 * @author PC
 */
public class BookInfoFactory {

    public static int getBookPages(String path) {
        try {
            InputStream myppt = new FileInputStream(path);
            SlideShow ppt = new SlideShow(myppt);

            int result = ppt.getSlides().length;
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }

    }
    
    public static String getFileKind(String path)
    {
      File f =new File(path);
      String fileName=f.getName();
      String prefix=fileName.substring(fileName.lastIndexOf(".")+1);
      return prefix;
    }
    
    public static String getFileSizeMb(String path)

	{   
                File file = new File(path);
		DecimalFormat df = new DecimalFormat("#.00");
		long size = 0;
		String sizemb;

		FileInputStream fis = null;

		try {
			fis = new FileInputStream(file);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			size = fis.available();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (size / 1048576 > 0) {
			sizemb = df.format((double) size / 1048576) + "MB";
		} else {
			sizemb = "0" + df.format((double) size / 1048576) + "MB";
		}

		return sizemb;

	}
    
}
