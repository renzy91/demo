package poi;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/**
 * 创建excel
 * @ClassName: ExcelUtils 
 * @author renzy 
 * @date 2017年5月4日 下午3:26:19 
 *
 */
public class ExcelUtil {
	/**
	 * excel版本信息
	 * @ClassName: ExcelVersion 
	 * @author renzy 
	 * @date 2017年7月6日 上午11:30:31 
	 *
	 */
	public enum ExcelVersion {
		//2003及以前版本的excel
		EXCEL2003L(".xls"),
		//2007及以后版本的excel
		EXCEL2007U(".xlsx");
		
		private ExcelVersion(String value) {
			this.value = value;
		}
		private String value;
	}
	
	/**
	 * 在磁盘中创建excel
	 * @Title: writeToDisk
	 * @param directory	目录	example: c:/example
	 * @param fileName	excel名称  example: excelName
	 * @param excelVersion	excel版本
	 * @param title 标题，此项不为空则按照title顺序写入内容，否则列顺序按照实体类中的字段定义顺序
	 * @param content	要写入的内容
	 * @param clazz	内容类型
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 */
	public static <T> void writeToDisk(String directory, String fileName, ExcelVersion excelVersion,String[] title, List<T> content, Class<T> clazz) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		//检查目录是否存在，不存在则创建
		File dir = new File(directory);
		if(!dir.exists()) {
			dir.mkdirs();
		}
		try {
			File file = new File(directory+"/"+fileName+excelVersion.value);
			FileOutputStream fos = new FileOutputStream(file);
			Workbook workBook = getWorkBook(excelVersion, title, content, clazz);
			workBook.write(fos);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 在磁盘中写入excel,列顺序按照实体类中的字段定义顺序
	 * @Title: writeToDisk
	 * @param directory	目录	example: c:/example
	 * @param fileName	excel名称  example: excelName
	 * @param excelVersion	excel版本
	 * @param content	要写入的内容
	 * @param clazz	内容类型
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 */
	public static <T> void writeToDisk(String directory, String fileName, ExcelVersion excelVersion, List<T> content, Class<T> clazz) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		writeToDisk(directory, fileName, excelVersion, null, content, clazz);
	}
	
	/**
	 * 分片输出,将content内容分片创建excel,压缩为zip文件输出到磁盘
	 * excel名称从1开始
	 * 列顺序按照title给出的顺序输出,title=null 则列顺序按照实体类中的字段定义顺序
	 * @Title: writeToDiskSplit
	 * @param directory 目录	example: c:/example
	 * @param zipName zip文件名称  example: zipName
	 * @param excelVersion excel版本
	 * @param title 标题，此项不为空则按照title顺序写入内容，否则列顺序按照实体类中的字段定义顺序
	 * @param content 要写入的内容
	 * @param clazz 内容类型
	 * @param splitSize 分片大小
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws IOException
	 */
	public static <T> void writeToDiskSplit(String directory, String zipName, ExcelVersion excelVersion,String[] title, List<T> content, Class<T> clazz, int splitSize) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, IOException {
		//检查存放目录是否存在，不存在创建
		File dir = new File(directory);
		if(!dir.exists()) {
			dir.mkdirs();
		}
		FileOutputStream fos = new FileOutputStream(new File(directory+"/"+zipName+".zip"));
		ZipOutputStream zos = new ZipOutputStream(fos);
		int start=0;
		int end = 0;
		int excelName = 1;
		Workbook workBook = null;
		while (start < content.size()) {
			end += splitSize;
			if(end > content.size()) {
				end = content.size();
			}
			workBook = getWorkBook(excelVersion, title, content.subList(start, end), clazz);
			zos.putNextEntry(new ZipEntry(excelName+".xls"));
			workBook.write(zos);
			start = end;
			excelName++;
		}
		zos.flush();
		zos.close();
		fos.close();
	}
	
	/**
	 * 分片输出,将content内容分片创建excel,压缩为zip文件输出到磁盘
	 * excel名称从1开始
	 * 否则列顺序按照实体类中的字段定义顺序
	 * @Title: writeToDiskSplit
	 * @param directory 目录	example: c:/example
	 * @param zipName zip文件名称  example: zipName
	 * @param excelVersion excel版本
	 * @param content 要写入的内容
	 * @param clazz 内容类型
	 * @param splitSize 分片大小
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws IOException
	 */
	public static <T> void writeToDiskSplit(String directory, String zipName, ExcelVersion excelVersion, List<T> content, Class<T> clazz, int splitSize) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, IOException {
		writeToDiskSplit(directory, zipName, excelVersion, null, content, clazz, splitSize);
	}
	
	/**
	 * 导出excel，输出流输出，
	 * title不为空则按照title给出顺序，否则列顺序按照实体类中的字段定义顺序
	 * @Title: writeToResponse
	 * @param response 响应
	 * @param fileName 文件名
	 * @param charset 编码格式，默认UTF-8
	 * @param excelVersion excel版本
	 * @param title 标题
	 * @param content 内容
	 * @param clazz 内容所属的实体类
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws IOException
	 */
	public static <T> void writeToResponse(HttpServletResponse response, String fileName, String charset, ExcelVersion excelVersion,String[] title, List<T> content, Class<T> clazz) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, IOException {
		//设置默认编码格式 UTF-8
		if(charset == null) {
			charset =  "UTF-8";
		}
		//设置响应类型
		response.setContentType("application/vnd.ms-excel;charset="+charset);
		//设置响应头
		response.setHeader("content-disposition", "attachment;filename="+fileName+excelVersion.value);
		//获取输出流
		ServletOutputStream outputStream = response.getOutputStream();
		//创建excel
		Workbook workBook = getWorkBook(excelVersion, title, content, clazz);
		//输出对象
		workBook.write(outputStream);
	}
	/**
	 * 导出excel，输出流输出,默认标题,列顺序按照实体类中的字段定义顺序
	 * @Title: writeToResponse
	 * @param response 响应
	 * @param fileName 文件名
	 * @param charset 编码格式，默认UTF-8
	 * @param excelVersion excel版本
	 * @param content 内容
	 * @param clazz 内容所属的实体类
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws IOException
	 */
	public static <T> void writeToResponse(HttpServletResponse response, String fileName, String charset, ExcelVersion excelVersion, List<T> content, Class<T> clazz) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, IOException {
		writeToResponse(response, fileName, charset, excelVersion, null, content, clazz);
	}
	/**
	 * 分片导出excel,输出流输出zip文件
	 * 列顺序按照title给出的顺序输出,title为空按照实体类中的字段定义顺序
	 * excel名称从1开始
	 * @Title: writeToResponseSplit
	 * @param response 响应
	 * @param zipName 文件名
	 * @param charset 编码格式，默认UTF-8
	 * @param excelVersion excel版本
	 * @param title 标题
	 * @param content 内容
	 * @param clazz 内容所属的实体类
	 * @param splitSize 分片大小
	 * @throws IOException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 */
	public static <T> void writeToResponseSplit(HttpServletResponse response, String zipName, String charset, ExcelVersion excelVersion, String[] title, List<T> content, Class<T> clazz, int splitSize) throws IOException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		//设置默认编码格式 UTF-8
		if(charset == null) {
			charset =  "UTF-8";
		}
		//设置响应类型
		response.setContentType("application/zip;charset="+charset);
		//设置响应头
		response.setHeader("content-disposition", "attachment;filename="+zipName+".zip");
		//获取输出流
		ServletOutputStream outputStream = response.getOutputStream();
		
		ZipOutputStream zos = new ZipOutputStream(outputStream);
		int start=0;
		int end = 0;
		int excelName = 1;
		Workbook workBook = null;
		while (start < content.size()) {
			end += splitSize;
			if(end > content.size()) {
				end = content.size();
			}
			workBook = getWorkBook(excelVersion, title, content.subList(start, end), clazz);
			zos.putNextEntry(new ZipEntry(excelName+".xls"));
			workBook.write(zos);
			start = end;
			excelName++;
		}
		zos.flush();
		zos.close();
		outputStream.close();
	}
	/**
	 * 分片导出excel,输出流输出zip文件
	 * 列顺序按照实体类中的字段定义顺序,excel名称从1开始
	 * @Title: writeToResponseSplit
	 * @param response 响应
	 * @param zipName 文件名
	 * @param charset 编码格式，默认UTF-8
	 * @param excelVersion excel版本
	 * @param content 内容
	 * @param clazz 内容所属的实体类
	 * @param splitSize 分片大小
	 * @throws IOException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 */
	public static <T> void writeToResponseSplit(HttpServletResponse response, String zipName, String charset, ExcelVersion excelVersion, List<T> content, Class<T> clazz, int splitSize) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, IOException {
		writeToResponseSplit(response, zipName, charset, excelVersion, null, content, clazz, splitSize);
	}
	
	/**
	 * 读取excel内容，此版本支持读取第一张sheet数据 
	 * 文件类型限定 .xls 或 .xlsx
	 * @Title: readExcel
	 * @param inputStream 输入流
	 * @param fileName 文件名  example: example.xls
	 * @return	List<List<String>>: List<String>为一行数据
	 * @throws IOException
	 */
	public static List<List<String>> readExcel(InputStream inputStream, String fileName) throws IOException {
		//根据excel文件后缀创建对应版本Workbook
		Workbook workBook = null;
		if(fileName.endsWith(ExcelVersion.EXCEL2003L.value)) {
			workBook = new HSSFWorkbook(inputStream);
		} else if(fileName.endsWith(ExcelVersion.EXCEL2007U.value)){
			workBook =new XSSFWorkbook(inputStream);
		} else {
			throw new RuntimeException("不支持的文件类型");
		}
		
		//获取第一张表单
		Sheet sheet = workBook.getSheetAt(0);
		if(sheet == null) {
			throw new RuntimeException("sheet0没有数据");
		}
		ArrayList<List<String>> supList = new ArrayList<List<String>>();
		List<String> subList = null;
		//循环读取表单内容
		for (int i = sheet.getFirstRowNum(); i < sheet.getLastRowNum(); i++) {
			Row row = sheet.getRow(i);
			if(row != null) {
				subList = new ArrayList<String>();
				for (int j = row.getFirstCellNum(); j < row.getLastCellNum(); j++) {
					Cell cell = row.getCell(j);
					cell.setCellType(CellType.STRING);
					String value = cell.getStringCellValue();
					subList.add(value);
				}
				supList.add(subList);
			}
		}
		inputStream.close();
		return supList;
	}
	
	/**
	 * 写入内容并返回 Workbook 
	 * 列顺序按照title给出的顺序输出 
	 * title为空则按照实体类中的字段定义顺序
	 * @Title: getWorkBook
	 * @param content	内容
	 * @param clazz	类型
	 * @param excelVersion	版本
	 * @param title	标题，此项不为空则按照title顺序写入内容，否则列为默认顺序
	 * @return
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 */
	public static Workbook getWorkBook(ExcelVersion excelVersion, String[] title, List<?> content,Class<?> clazz) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Workbook workBook = getWorkBook(excelVersion);
		int rownum = 0;
		Sheet sheet = workBook.createSheet();
		Row row = sheet.createRow(rownum++);
		//创建标题
		createTitle(row, title, clazz);
		//写入内容
		if(title == null) {
			writeContent(clazz, sheet, content, rownum);
		} else {
			writeContent(clazz, sheet, title, content, rownum);
		}
		
		return workBook;
	}
	
	/**
	 * 写入标题,标题由实体中注解 @ColumnName 获取
	 * @Title: createTitle
	 * @param clazz	实体类
	 * @param row 行
	 */
	private static void writeLine(Row row, Class<?> clazz) {
		Map<String, String> fieldNameMapping = getFieldNameMapping(clazz);
		int cellNum = 0;
		for (Map.Entry<String, String> map : fieldNameMapping.entrySet()) {
			row.createCell(cellNum++).setCellValue(map.getKey());
		}
	}
	
	/**
	 * 写入一行自定义内容
	 * @Title: createTitle
	 * @param row 行
	 * @param title	标题
	 */
	private static void writeLine(Row row, String[] title) {
		for (int i = 0; i < title.length; i++) {
			row.createCell(i).setCellValue(title[i]);
		}
	}
	
	/**
	 * 创建标题，title为空根据clazz注解创建，否则根据title创建
	 * @Title: createTitle
	 * @param row
	 * @param title
	 * @param clazz
	 */
	private static void createTitle(Row row, String[] title, Class<?> clazz) {
		if(title == null) {
			writeLine(row, clazz);
		} else {
			writeLine(row, title);
		}
	}
	
	/**
	 * 写入内容，列顺序按照title给出
	 * @Title: writeContent
	 * @param clazz 要写入内容所属的实体类
	 * @param sheet	表单
	 * @param title	标题
	 * @param content 内容
	 * @param rownum 起始行号
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 */
	private static void writeContent(Class<?> clazz, Sheet sheet,String[] title, List<?> content, int rownum) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		/** 获取实体中 注释名-字段名 的映射关系 **/
		Map<String, String> fieldNameMapping = getFieldNameMapping(clazz);
		/** 获取实体中 字段名-类型 的映射关系 **/
		Map<String, Class<?>> fieldTypeMapping = getFieldTypeMapping(clazz);
		//写入内容
		int cellnum = 0;
		for (Object obj : content) {
			Row row = sheet.createRow(rownum++);
			for (String t : title) {
				//获取字段名
				String field = fieldNameMapping.get(t);
				//构建字段的get方法
				String method = "get"+field.substring(0, 1).toUpperCase()+field.substring(1);
				//获取字段的值
				Object arg = clazz.getMethod(method).invoke(obj);
				//获取字段的类型
				Class<?> argType = fieldTypeMapping.get(field);
				//创建单元格
				Cell cell = row.createCell(cellnum++);
				//写入单元格
				writeCell(cell, arg, argType);
			}
			cellnum = 0;
		}
	}
	
	/**
	 * 写入内容，列顺序默认
	 * @Title: writeContent
	 * @param clazz 要写入内容所属的实体类
	 * @param sheet	表单
	 * @param content 内容
	 * @param rownum 起始行号
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 */
	private static void writeContent(Class<?> clazz, Sheet sheet, List<?> content, int rownum) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		/** 获取实体中 注释名-字段名 的映射关系 **/
		Map<String, String> fieldNameMapping = getFieldNameMapping(clazz);
		/** 获取实体中 字段名-类型 的映射关系 **/
		Map<String, Class<?>> fieldTypeMapping = getFieldTypeMapping(clazz);
		//写入内容
		if(content == null) {
			return ;
		}
		int cellnum = 0;
		for (Object obj : content) {
			Row row = sheet.createRow(rownum++);
			for (Map.Entry<String, String> map : fieldNameMapping.entrySet()) {
				//获取字段名
				String field = map.getValue();
				//构建字段的get方法
				String method = "get"+field.substring(0, 1).toUpperCase()+field.substring(1);
				//获取字段的值
				Object arg = clazz.getMethod(method).invoke(obj);
				//获取字段的类型
				Class<?> argType = fieldTypeMapping.get(field);
				//创建单元格
				Cell cell = row.createCell(cellnum++);
				//写入单元格
				writeCell(cell, arg, argType);
			}
			cellnum = 0;
		}
	}
	
	/**
	 * 写一个单元格
	 * @Title: writeCell
	 * @param cell	单元格
	 * @param arg	内容
	 * @param argType	内容类型
	 */
	private static void writeCell(Cell cell, Object arg, Class<?> argType) {
		if(arg == null) {
			cell.setCellValue("");
		}
		if (argType.equals(Integer.class)) {
			cell.setCellValue((Integer)arg);
			return;
		}
		if (argType.equals(String.class)) {
			cell.setCellValue((String)arg);
			return;
		}
		if (argType.equals(Date.class)) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String data = sdf.format((Date)arg);
			cell.setCellValue(data);
			return;
		}
		if (argType.equals(Boolean.class)) {
			cell.setCellValue((Boolean)arg);
			return;
		}
	}
	
	/**
	 * 根据版本信息创建 Workbook 
	 * @param excelVersion 版本信息
	 */
	private static Workbook getWorkBook(ExcelVersion excelVersion) {
		Workbook workbook = null;
		switch (excelVersion) {
			case EXCEL2003L: 
				workbook = new HSSFWorkbook(); 
				break;
			case EXCEL2007U: 
				workbook = new XSSFWorkbook(); 
				break;
			default:throw new RuntimeException("版本错误");
		}
		return workbook;
	}
	
	/**
	 * 获取实体中字段名称与注释名称的映射关系
	 * @Title: getFieldNameMapping
	 * @param clazz
	 * @return map<注释名，字段名>
	 */
	private static Map<String,String> getFieldNameMapping(Class<?> clazz){
		Map<String, String> map = new LinkedHashMap<String,String>();
		//获取类中所有成员变量
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			//获取字段的注释
			ColumnName annotation = field.getAnnotation(ColumnName.class);
			if(annotation != null) {
				//获取成员变量名
				String name = field.getName();
				//获取列名
				String fieldAnnotationName = annotation.value();
				map.put(fieldAnnotationName, name);
			}
		}
		return map;
	}
	/**
	 * 获取实体中字段与类型的映射关系
	 * @Title: getFieldTypeMapping
	 * @param clazz
	 * @return map<字段名，类型>
	 */
	private static Map<String,Class<?>> getFieldTypeMapping(Class<?> clazz){
		HashMap<String, Class<?>> map = new HashMap<String,Class<?>>();
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			String name = field.getName();
			Class<?> type = field.getType();
			map.put(name, type);
		}
		return map;
	}
}