/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/LouisRenWeiWei">allinbox</a> All rights reserved.
 */
package com.fyjf.common.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

import org.apache.shiro.io.ResourceUtils;
import org.jsoup.Jsoup;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.w3c.dom.Document;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.BaseFont;

import freemarker.template.Configuration;
import freemarker.template.Template;

/**
 * FreeMarkers工具类
 * 
 * @author renweiwei
 * @version 2013-01-15
 */
public class FreeMarkers {

	public static void renderToFile(String templateString, Map<String, ?> model, String outFilePath) {
		try {
			File outHtmFile = new File(outFilePath);
			if (!outHtmFile.exists()) {
				outHtmFile.createNewFile();
			}
			Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outHtmFile), "UTF-8"));
			Configuration configuration = new Configuration();
			configuration.setClassicCompatible(true);
			configuration.setDefaultEncoding("UTF-8");
			Template t = new Template("name", new StringReader(templateString), configuration);
			t.process(model, out);
		} catch (Exception e) {
			throw Exceptions.unchecked(e);
		}
	}

	public static String renderString(String templateString, Map<String, ?> model) {
		try {
			StringWriter result = new StringWriter();
			Template t = new Template("name", new StringReader(templateString), new Configuration());
			t.process(model, result);
			return result.toString();
		} catch (Exception e) {
			throw Exceptions.unchecked(e);
		}
	}

	public static String renderTemplate(Template template, Object model) {
		try {
			StringWriter result = new StringWriter();
			template.process(model, result);
			return result.toString();
		} catch (Exception e) {
			throw Exceptions.unchecked(e);
		}
	}

	public static Configuration buildConfiguration(String directory) throws IOException {
		Configuration cfg = new Configuration();
		Resource path = new DefaultResourceLoader().getResource(directory);
		cfg.setDirectoryForTemplateLoading(path.getFile());
		return cfg;
	}

	/**
	 * 生成html格式
	 */
	public static void renderToHtml(String templateName, String htmUrl, Map<String, Object> paramMap)
			throws Exception {
		Configuration cfg = new Configuration();
		cfg.setDefaultEncoding("UTF-8");
		Resource path = new DefaultResourceLoader().getResource(ResourceUtils.CLASSPATH_PREFIX + "template");
		cfg.setDirectoryForTemplateLoading(path.getFile());

		Template template = cfg.getTemplate(templateName);// 加载的模板名

		File outHtmFile = new File(htmUrl);

		Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outHtmFile)));
		template.process(paramMap, out);

		out.close();
	}

	

	public static void pdfHandler(String htmUrl, String pdfUrl)
				throws DocumentException, IOException {
			File htmFile = new File(htmUrl);
			File pdfFile = new File(pdfUrl);

			String url = htmFile.toURI().toURL().toString();

			OutputStream os = new FileOutputStream(pdfFile);

			org.xhtmlrenderer.pdf.ITextRenderer renderer = new ITextRenderer();
			renderer.setDocument(url);

			org.xhtmlrenderer.pdf.ITextFontResolver fontResolver = renderer.getFontResolver();
			// 解决中文支持问题
			Resource path = new DefaultResourceLoader().getResource(ResourceUtils.CLASSPATH_PREFIX+"simsun.ttc");
			fontResolver.addFont(path.getFile().getAbsolutePath(),BaseFont.IDENTITY_H,BaseFont.NOT_EMBEDDED);

			renderer.layout();
			renderer.createPDF(os);
			os.close();
		}
	
	

	public static void main(String[] args){
		try {
			pdfHandler("E:/work/other/fyjf/fyjf/fyjf/report/file/html/3d40a8e0dc3c4780a51fbb45299965dd-test.html","E:/work/other/fyjf/fyjf/fyjf/report/file/pdf/3d40a8e0dc3c4780a51fbb45299965dd.pdf");
			//pdfHandler("F:/download/PdfDemo/resource/contract/pdfDemo.html","F:/download/PdfDemo/resource/contract/pdfDemo.pdf");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
