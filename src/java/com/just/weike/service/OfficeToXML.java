package com.just.weike.service;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.*;

public class OfficeToXML {

    private final static OfficeToXML oOfficeToXML = new OfficeToXML();
    private static final int ppSaveAsPDF = 32;

    public static OfficeToXML getInstance() {
        return oOfficeToXML;
    }

    public OfficeToXML() {
    }

    public boolean WordtoHtml(String s, String s1) {
        ComThread.InitSTA();
        ActiveXComponent activexcomponent = new ActiveXComponent(
                "Word.Application");
        String s2 = s;
        String s3 = s1;
        boolean flag = false;
        try {
            activexcomponent.setProperty("Visible", new Variant(false));
            Dispatch dispatch = activexcomponent.getProperty("Documents").toDispatch();
            Dispatch dispatch1 = Dispatch.invoke(dispatch, "Open", 1,
                    new Object[]{s2, new Variant(false), new Variant(true)},
                    new int[1]).toDispatch();
            Dispatch.invoke(dispatch1, "SaveAs", 1, new Object[]{s3,
                new Variant(8)}, new int[1]);
            Variant variant = new Variant(false);
            Dispatch.call(dispatch1, "Close", variant);
            flag = true;
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            activexcomponent.invoke("Quit", new Variant[0]);
            ComThread.Release();
            ComThread.quitMainSTA();
        }
        return flag;
    }

    public boolean PPttoHtml(String s, String s1) {
        ComThread.InitSTA();
        ActiveXComponent activexcomponent = new ActiveXComponent(
                "PowerPoint.Application");
        String s2 = s;
        String s3 = s1;
        boolean flag = false;
        try {
            Dispatch dispatch = activexcomponent.getProperty("Presentations")
                    .toDispatch();
            Dispatch dispatch1 = Dispatch.call(dispatch, "Open", s2,
                    new Variant(-1), new Variant(-1), new Variant(0))
                    .toDispatch();
            Dispatch.call(dispatch1, "SaveAs", s3, new Variant(12));
            Variant variant = new Variant(-1);
            Dispatch.call(dispatch1, "Close");
            flag = true;
        } catch (Exception exception) {
            System.out.println("|||" + exception.toString());
        } finally {
            activexcomponent.invoke("Quit", new Variant[0]);
            ComThread.Release();
            ComThread.quitMainSTA();
        }
        return flag;
    }

    public boolean ExceltoHtml(String s, String s1) {
        ComThread.InitSTA();
        ActiveXComponent activexcomponent = new ActiveXComponent("Excel.Application");
        String s2 = s;
        String s3 = s1;
        boolean flag = false;
        try {
            activexcomponent.setProperty("Visible", new Variant(false));
            Dispatch dispatch
                    = activexcomponent.getProperty("Workbooks").toDispatch();
            Dispatch dispatch1 = Dispatch.invoke(dispatch, "Open", 1, new Object[]{
                s2, new Variant(false), new Variant(true)
            }, new int[1]).toDispatch();
            Dispatch.call(dispatch1, "SaveAs", s3, new Variant(44));
            Variant variant = new Variant(false);
            Dispatch.call(dispatch1, "Close", variant);
            flag = true;
        } catch (Exception exception) {
            System.out.println("|||" + exception.toString());
        } finally {
            activexcomponent.invoke("Quit", new Variant[0]);
            ComThread.Release();
            ComThread.quitMainSTA();
        }
        return flag;
    }

    public boolean ppt2PDF(String inputFile, String pdfFile) {
        try {
            ActiveXComponent app = new ActiveXComponent("PowerPoint.Application");
            //app.setProperty("Visible", msofalse);
            Dispatch ppts = app.getProperty("Presentations").toDispatch();

            Dispatch ppt = Dispatch.call(ppts,
                    "Open",
                    inputFile,
                    true,//ReadOnly
                    true,//Untitledָ���ļ��Ƿ��б���
                    false//WithWindowָ���ļ��Ƿ�ɼ�
            ).toDispatch();

            Dispatch.call(ppt,
                    "SaveAs",
                    pdfFile,
                    ppSaveAsPDF
            );

            Dispatch.call(ppt, "Close");

            app.invoke("Quit");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void pptToHtml(String pptPath, String htmlPath) {
        ActiveXComponent offCom = new ActiveXComponent("PowerPoint.Application");
        try {
            offCom.setProperty("Visible", new Variant(true));
            Dispatch excels = offCom.getProperty("Presentations").toDispatch();
            Dispatch excel = Dispatch.invoke(
                    excels,
                    "Open",
                    Dispatch.Method,
                    new Object[]{pptPath, new Variant(false),
                        new Variant(false)}, new int[1]).toDispatch();
            Dispatch.invoke(excel, "SaveAs", Dispatch.Method, new Object[]{
                htmlPath, new Variant(12)}, new int[1]);
            Variant f = new Variant(false);
            Dispatch.call(excel, "Close");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            offCom.invoke("Quit", new Variant[]{});
        }
    }

/*	public static void main(String args[]) {
		OfficeToXML otx = OfficeToXML.getInstance();
		boolean flag1 = otx.PPttoHtml("e:/test/test3.ppt", "e:/test/test5.html");
	//	otx.pptToHtml("e:/test/test3.ppt", "e:/test/test3x.html");
		otx.ppt2PDF("e:/test/test3.ppt", "e:/test/test5.pdf");
		if(flag1){
			System.out.println("PPT�ļ�ת����HTML�ɹ���");
		}else{
			System.out.println("PPT�ļ�ת����HTMLʧ�ܣ�");
		}
		boolean flag2 = otx.WordtoHtml("e:/test/test2.docx", "e:/test/test2.html");
		if(flag2){
			System.out.println("WORD�ļ�ת����HTML�ɹ���");
		}else{
			System.out.println("WORD�ļ�ת����HTMLʧ�ܣ�");
		}
		boolean flag3 = otx.ExceltoHtml("e:/test/test1.xlsx", "e:/test/test1.html");
		if(flag3){
			System.out.println("EXCEL�ļ�ת����HTML�ɹ���");
		}else{
			System.out.println("EXCEL�ļ�ת����HTMLʧ�ܣ�");
		}
	}
         */
}