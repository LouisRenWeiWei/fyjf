package com.fyjf.common.utils;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;
//import org.apache.poi.xwpf.converter.pdf.PdfConverter;
//import org.apache.poi.xwpf.converter.pdf.PdfOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.docx4j.Docx4J;  
import org.docx4j.Docx4jProperties;  
import org.docx4j.convert.out.FOSettings;  
import org.docx4j.convert.out.HTMLSettings;
import org.docx4j.convert.out.pdf.PdfConversion;
import org.docx4j.convert.out.pdf.viaXSLFO.PdfSettings;
import org.docx4j.fonts.BestMatchingMapper;
import org.docx4j.fonts.IdentityPlusMapper;  
import org.docx4j.fonts.Mapper;  
import org.docx4j.fonts.PhysicalFonts;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage; 

import com.alibaba.fastjson.JSONObject;

/**
 * Created by Fuxudong on 2017-5-19.
 * @author Fuxudong
 * @description 利用模板动态生成Word文件
 */
public class DocUtil {
    public Configuration configure=null;

    public DocUtil(){
        configure=new Configuration();
        configure.setDefaultEncoding("utf-8");
    }
    /**
     * 根据Doc模板生成word文件
     * @param dataMap 需要填入模板的数据
     * @param downloadType 文件名称
     * @param savePath 保存路径
     */
    public void createDoc(Map<String,Object> dataMap, String templateFileName, String xmlPath, String savePath,String pdfPath,String type){
        try {
            //加载需要装填的模板
            Template template;
            //设置模板装置方法和路径，FreeMarker支持多种模板装载方法。可以从servlet，classpath,数据库装载。
            //加载模板文件，放在testDoc下
            //configure.setClassForTemplateLoading(this.getClass(), xmlPath);
            //configure.set
            configure.setDirectoryForTemplateLoading(new File(xmlPath));
            //设置对象包装器
//            configure.setObjectWrapper(new DefaultObjectWrapper());
            //设置异常处理器
            configure.setTemplateExceptionHandler(TemplateExceptionHandler.IGNORE_HANDLER);
            //定义Template对象，注意模板类型名字与downloadType要一致
            template=configure.getTemplate(templateFileName+".ftl");
            File outFile=new File(savePath);
            Writer out;
            out=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "utf-8"));
            //传入数据，生成word
            template.process(dataMap, out);
            out.close();

            if ("pdf".equals(type.toLowerCase())){
                //将生成的word文件使用FileInputStream读入
                FileInputStream fileInputStream = new FileInputStream(outFile);
//                PdfUtil.word2Pdf(fileInputStream,pdfPath);
                fileInputStream.close();
//                if (outFile.exists()){
//                    outFile.delete();
//                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    

 
    //使用offic
    public static void soffice2PDF(String outputPath, String filename) {
		// 命令行例子
		// "c:\Program Files (x86)\LibreOffice 5\program\soffice.exe" --headless \
		// --invisible --norestore --nodefault --nolockcheck \
		// --nofirststartwizard --convert-to pdf:writer_pdf_Export --outdir
		// e:\Workspace\xdocreport\template liangchuan.docx
		//测试环境
		final String sofficeCommand ="soffice --headless --invisible --norestore --nodefault --nolockcheck  --nofirststartwizard --convert-to pdf:writer_pdf_Export";
		//本地测试
//		final String sofficeCommand = "C:/Program Files/LibreOffice 5/program/soffice.exe  --headless --invisible --norestore --nodefault --nolockcheck  --nofirststartwizard --convert-to pdf:writer_pdf_Export";
		String output = "--outdir " + outputPath;
		Process process;

		String command = sofficeCommand + " " + output + " " + filename;
		try {
			long start_i = System.currentTimeMillis();
			process = Runtime.getRuntime().exec(command);
			process.waitFor();
			long end_i = System.currentTimeMillis();
			process = null;
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	/**
	 * word转pdf
	 * @param source
	 *  word文件路径
	 * @param target
	 * 转换后pdf路径
	 * @throws Exception
	 */	
    public static void exportDocToPDF(String source,String target){
    	try {
			long start = System.currentTimeMillis();
			InputStream is = new FileInputStream(new File(source));
			WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage.load(is);
			List sections = wordMLPackage.getDocumentModel().getSections();
			for (int i = 0; i < sections.size(); i++) {
				wordMLPackage.getDocumentModel().getSections().get(i).getPageDimensions();
			}
			// 中文乱码就是没有字体
			Mapper fontMapper = new BestMatchingMapper();
			wordMLPackage.setFontMapper(fontMapper);
			PdfSettings pdfSettings = new PdfSettings();
			org.docx4j.convert.out.pdf.PdfConversion conversion = new org.docx4j.convert.out.pdf.viaXSLFO.Conversion(wordMLPackage);
			OutputStream out = new FileOutputStream(new File(target));
			conversion.output(out, pdfSettings);
			System.err.println("转pdf耗时::::::>><>><><><><><><><><><><><>" + (System.currentTimeMillis() - start) + "ms");
			is.close();
			out.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public static void convertDocxToPDF(String docxPath, String pdfPath) throws Exception {  
    	try {
            long start = System.currentTimeMillis();
 
            // 1) Load DOCX into WordprocessingMLPackage
            InputStream is = new FileInputStream(new File(docxPath));
            WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage
                    .load(is);
 
            // 2) Prepare Pdf settings
            PdfSettings pdfSettings = new PdfSettings();
 
            // 3) Convert WordprocessingMLPackage to Pdf
            OutputStream out = new FileOutputStream(new File(pdfPath));
            PdfConversion converter = new org.docx4j.convert.out.pdf.viaXSLFO.Conversion(
                    wordMLPackage);
            converter.output(out, pdfSettings);
 
            System.err.println("Generate pdf  with " + (System.currentTimeMillis() - start) + "ms");
 
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
    
//    public static void convertDocxToPDFByPOI(String docxPath, String pdfPath) throws Exception {  
//    	try {
//            long start = System.currentTimeMillis();
// 
//            // 1) Load DOCX into XWPFDocument
//            InputStream is = new FileInputStream(new File(docxPath));
//            XWPFDocument document = new XWPFDocument(is);
// 
//            // 2) Prepare Pdf options
//            PdfOptions options = PdfOptions.create();
// 
//            // 3) Convert XWPFDocument to Pdf
//            OutputStream out = new FileOutputStream(new File(pdfPath));
//            PdfConverter.getInstance().convert(document, out, options);
//             
//            System.err.println("Generate pdf with " + (System.currentTimeMillis() - start) + "ms");
//             
//        } catch (Throwable e) {
//            e.printStackTrace();
//        }
//    }
//    
    
    public static void main(String[] args) {
//    	DocUtil docutil = new DocUtil();
//    	Map<String,Object> data = new HashMap<>();
//    	JSONObject report = new JSONObject();    	
//    	report.put("year","2017");
//    	report.put("reportNo","6");
//    	data.put("report", report);
//    	docutil.createDoc(data, "rww", "E:/work/other/fyjf/system/fyjf/src/main/resources/template", "E:/work/other/fyjf/system/fyjf/src/main/resources/template/rww1.doc", "E:/work/other/fyjf/system/fyjf/src/main/resources/template/rww1.pdf", "pdf");
    	
    	try {
    		exportDocToPDF("E:/work/ufashion/设计文档/系统设计/后台接口文档/新建 Microsoft Word 文档.docx", "E:/work/ufashion/设计文档/系统设计/后台接口文档/新建 Microsoft Word 文档.pdf");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}