package com.lyt.apache;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.LineIterator;
import org.junit.Test;

/**
 * @Title: CommonsIo.java 
 * @Package com.lyt.apache 
 * @Description: TODO
 * @author liyintao
 * @date 2016年10月17日 下午4:40:39 
 * @version V1.0
 * commons-io 流操作
 */
public class CommonsIo {
	
	@Test
	public void readLinesByIs() throws MalformedURLException, IOException{
		System.out.println("IOUtils.readLines(is) 的用法：");
		InputStream is = new URL("https://www.baidu.com/").openStream();
		 /**
         * readLines(InputStream input)
         * readLines(InputStream input, String encoding)
         * readLines(Reader input)
         */
		List<String> lines = IOUtils.readLines(is);
		/*for (int i = 0; i < lines.size(); i++) {
			System.out.println(lines.get(i));
		}*/
		for(String line:lines){
            System.out.println(line);
        }
	}
	
	@Test
    public void lineIterator() throws MalformedURLException, IOException{
       System.out.println("IOUtils.lineIterator(InputStream,'') 的用法：");
		InputStream is = new URL("https://www.baidu.com/").openStream();
        LineIterator it = IOUtils.lineIterator(is, "UTF-8");
        while(it.hasNext()){
            String line = it.nextLine();
            if("</body>".equals(line)){
                continue;
            }
            System.out.println(line);
        }
    }

	@Test
    public void tostring() throws MalformedURLException, IOException{
        System.out.println("IOUtils.toString(is)的用法： ");
		InputStream is = new URL("https://www.baidu.com/").openStream();
        try {
            /**读取文件
             * toString(InputStream input)
             * toString(InputStream input, String encoding)
             * toString(Reader input)
             * [toString(byte[] input)]
             * [toString(byte[] input, String encoding)]
             */
            System.out.println(IOUtils.toString(is));
        } finally {
            IOUtils.closeQuietly(is);
        }
    }
	@Test
	public void readLinesByFile() throws IOException{
		System.out.println("File 读取配置文件信息build.xml：");
		File file = new File("src/main/resources/build.xml");
		List<String> lines = FileUtils.readLines(file/*, "UTF-8"*/);
		for (String line : lines) {
			System.out.println("一行一行读取：" + line);
		}
		//readFileToString(File),  readFileToString(File,encoding)
		String result = FileUtils.readFileToString(file/*, "UTF-8"*/);
		System.out.println("result = " + result);
	}
	@Test
    public void copyFile() throws IOException{
		System.out.println("build.xml拷贝到build.txt文件中：");
        File srcFile = new File("src/main/resources/build.xml");
        File destFile = new File("target/classes/build.txt");
//        File destFile = new File("D:/build.txt");
        /**自动关闭相关流
         * copyFile(File srcFile, File destFile)
         * copyFile(File srcFile, File destFile,boolean preserveFileDate)
         */
        FileUtils.copyFile(srcFile, destFile);
    }
	
	 @Test
	    public void copy() throws IOException{
	     System.out.println("**************拷贝IO流开始************");   
		 InputStream is = new URL("https://www.baidu.com/").openStream();
	        OutputStream os = new FileOutputStream(new File("target/classes/baidu.txt"));
	        try {
	            /**拷贝流【输入->输出】
	             * copy(InputStream input, OutputStream output)
	             * copy(InputStream input, Writer output)
	             * copy(InputStream input, Writer output, String encoding)
	             * copy(Reader input, Writer output)
	             * copy(Reader input, OutputStream output)
	             * copy(Reader input, OutputStream output, String encoding)
	             * copyLarge(Reader input, Writer output)
	             * copyLarge(InputStream input, OutputStream output)
	             */
	            IOUtils.copy(is, os);
	        } finally{
	            IOUtils.closeQuietly(is);
	            IOUtils.closeQuietly(os);
	        }
	        System.out.println("**************拷贝IO流结束************");   
	    }
	 @Test
	    public void toByteArray() throws MalformedURLException, IOException{
	     System.out.println("---------toByteArray()转换为字节数组---------");   
		 InputStream is = new URL("https://www.baidu.com/").openStream();
	        try {
	            /**转换为字节数组
	             * toByteArray(InputStream input)
	             * toByteArray(Reader input)
	             * toByteArray(Reader input, String encoding)
	             * [toByteArray(String input)]
	             */
	            byte[] buff = IOUtils.toByteArray(is);
	            System.out.println("转换为字节数组:IOUtils.toByteArray(is)"+Hex.encodeHexString(buff));
	        } finally{
	            IOUtils.closeQuietly(is);
	        }
	    }
	 @Test
	    public void toCharArray() throws MalformedURLException, IOException{
	     System.out.println("-----------toCharArray转换为字符数组------------");   
		 InputStream is = new URL("https://www.baidu.com/").openStream();
	        try {
	            /**转换为字符数组
	             * toCharArray(InputStream is)
	             * toCharArray(InputStream is, String encoding)
	             * toCharArray(Reader input)
	             */
	            char[] buff = IOUtils.toCharArray(is);
	            System.out.println("转换为字符数组IOUtils.toCharArray(is)"+Arrays.toString(buff));
	        } finally{
	            IOUtils.closeQuietly(is);
	        }
	    }

	    @Test
	    public void toInputStream() throws IOException{
	    	 System.out.println("-----------toInputStream转换为输入流------------");   
	        /**转换为输入流
	         * toInputStream(String input)
	         * toInputStream(String input, String encoding)
	         * toInputStream(CharSequence input)
	         * toInputStream(CharSequence input, String encoding)
	         */
	        InputStream is = IOUtils.toInputStream("https://www.baidu.com/");
	        byte[] buf = new byte[128];
	        int len = 0;
	        while((len = is.read(buf))!=-1){
	            System.out.print(new String(buf,0,len));
	            System.out.println("[读取到的长度："+len+"]");
	        }
	    }
	    
	    @Test
	    public void write() throws IOException{
	    	System.out.println("-----------write()写数据------------");   
	        OutputStream os = new FileOutputStream(new File("target/classes/Somnus.txt"));
//	        OutputStream os = new FileOutputStream(new File("D:/liyintao.txt"));
	        try {
	            /**写数据
	             * write(byte[] data, OutputStream output)
	             * write(byte[] data, Writer output)
	             * write(byte[] data, Writer output, String encoding)
	             * write(char[] data, Writer output)
	             * write(char[] data, OutputStream output)
	             * write(char[] data, OutputStream output, String encoding)
	             * write(CharSequence data, Writer output)
	             * write(CharSequence data, OutputStream output)
	             * write(CharSequence data, OutputStream output, String encoding)
	             * write(String data, Writer output)
	             * write(String data, OutputStream output)
	             * write(String data, OutputStream output, String encoding)
	             */
	            IOUtils.write("Somnus罂粟花", os);
	        } finally{
	            IOUtils.closeQuietly(os);
	        }
	    }
	    
	    @Test
	    public void FilenameUtils(){
	        System.out.println(FilenameUtils.getExtension("src/main/resources/build.xml"));
	        System.out.println(FilenameUtils.getBaseName("src/main/resources/build.xml"));
	        System.out.println(FilenameUtils.getFullPathNoEndSeparator("src/main/resources/build.xml"));
	        System.out.println(FilenameUtils.getPathNoEndSeparator("src/main/resources/build.xml"));
	        
	    }
	 
}
