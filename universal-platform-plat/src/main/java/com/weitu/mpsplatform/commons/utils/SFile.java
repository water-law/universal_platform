package com.weitu.mpsplatform.commons.utils;

import com.google.common.base.Preconditions;
import com.google.common.io.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;


/**
 *
 *
 * @author
 */
public final class SFile {
    private static Logger log = LoggerFactory.getLogger(SFile.class);

	private SFile(){

	}

    public static boolean isExists(String filePath) {
    	filePath=SPath.getFormatFilePathWithoutPrefix(filePath);
    	if("".equals(filePath)){
    		return false;
    	}
        File file = new File(filePath);
        return file.exists();
    }

    /**
     * 文件是否存在
     *
     * @param filePath
     *            文件名称
     * @return boolean
     */
    public static boolean isFile(String filePath) {
    	filePath=SPath.getFormatFilePathWithoutPrefix(filePath);
    	if("".equals(filePath)){
    		return false;
    	}

        File file = new File(filePath);
        if (isExists(filePath)) {
        	return file.isFile();
        } else{
            return (false);
        }
    }

    /**
     * 文件夹是否存在
     *
     * @param dirPath
     *            文件夹名称
     * @return boolean
     */

    public static boolean isDir(String dirPath) {
    	dirPath=SPath.getFormatFilePathWithoutPrefix(dirPath);
    	if("".equals(dirPath)){
    		return false;
    	}
        File file = new File(dirPath);
        if (isExists(dirPath)) {
        	return file.isDirectory();
        } else{
            return false;
        }
    }

    public static boolean createDir(String dirName){
    	dirName=SPath.getFormatFilePath(dirName);
        boolean dirflag=isDir(dirName);
        if(!dirflag){
            File dir=new File(dirName);
            return dir.mkdirs();
        }else{
        	return false;
        }
    }

    public static boolean createFile(String filePath){
    	filePath=SPath.getFormatFilePath(filePath);
    	if(isExists(filePath)){
    		return true;
    	}
        String newfilepath = SString.getPreString(filePath, "/");
        if (!isExists(newfilepath)) {
            File directory = new File(newfilepath);
            directory.mkdirs();
        }
        File newFile = new File(filePath);
        try {
			return newFile.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
    }

    public static boolean deleteFile(String filePath){
    	if(!isExists(filePath)){
    		return true;
    	}
    	File file=new File(filePath);
    	return file.delete();
    }

    public static InputStream getInputStream(String filePath) throws IOException{
    	return newInputStreamSupplier(new File(SPath.getFormatFilePath(filePath))).getInput();
    }

    public static OutputStream getOutputStream(String filePath,boolean append) throws IOException{
    	return newOutputStreamSupplier(new File(SPath.getFormatFilePath(filePath)), append).getOutput();
    }

    /**
     * guava 18版本已删除，自行添加
     * @param file
     * @return
     */
    private static InputSupplier<FileInputStream> newInputStreamSupplier(File file) {
       return asInputSupplier(Files.asByteSource(file));
    }

    /**
     * guava 18版本已删除，自行添加
     * @param source
     * @return
     */
    private static <S extends InputStream> InputSupplier<S> asInputSupplier(final ByteSource source) {
        return (InputSupplier) Preconditions.checkNotNull(source);
    }

    /**
     * guava 18版本已删除，自行添加
     * @param file
     * @return
     */
    private static OutputSupplier<FileOutputStream> newOutputStreamSupplier(File file) {
        return newOutputStreamSupplier(file, false);
    }
    /**
     * guava 18版本已删除，自行添加
     * @param file
     * @return
     */
    private static OutputSupplier<FileOutputStream> newOutputStreamSupplier(File file, final boolean append) {
        return asOutputSupplier(Files.asByteSink(file, modes(append)));
    }
    /**
     * guava 18版本已删除，自行添加
     * @param sink
     * @return
     */
    private static <S extends OutputStream> OutputSupplier<S> asOutputSupplier(final ByteSink sink) {
        return (OutputSupplier) Preconditions.checkNotNull(sink);
    }
    /**
     * guava 18版本已删除，自行添加
     * @param append
     * @return
     */
    private static FileWriteMode[] modes(boolean append) {
        return append ? new FileWriteMode[]{FileWriteMode.APPEND} : new FileWriteMode[0];
    }

    /**
     * 复制文件
     * @param inputFilePath
     * @param outputFilePath
     * @throws IOException
     */
    public static void copyFile(String inputFilePath,String outputFilePath) throws IOException{
    	FileInputStream inputStream=(FileInputStream)getInputStream(inputFilePath);
    	FileChannel inChannel=inputStream.getChannel();

    	createFile(outputFilePath);

    	FileOutputStream outputStream=(FileOutputStream)getOutputStream(outputFilePath, false);
    	FileChannel outChannel=outputStream.getChannel();

    	ByteBuffer byteBuffer=ByteBuffer.allocate(1024);
    	while(true){
    		byteBuffer.clear();
    		int r=inChannel.read(byteBuffer);
    		if(r==-1){
    			break;
    		}
    		byteBuffer.flip();
    		outChannel.write(byteBuffer);
    	}

    	outChannel.close();
    	inChannel.close();

    }

    public static void moveFile(String inputFilePath,String outputFilePath) throws IOException{
    	copyFile(inputFilePath,outputFilePath);
    	SFile.deleteFile(inputFilePath);
    }

    /**
     * 文件改名
     * @param fileName
     * @param toFileName
     * @return boolean
     */
    public static boolean renameFile(String fileName,String toFileName){
    	if(!isFile(fileName)){
    		return false;
    	}
    	fileName=SPath.getFormatFilePath(fileName);
    	toFileName=SPath.getFormatFilePath(toFileName);
        File file=new File(fileName);
        File fileto=new File(toFileName);
        return file.renameTo(fileto);
    }

    /**
     * 文件改名
     * @param fileName
     * @param toFileName
     * @return boolean
     */
    public static boolean renameFile(File fileName,File toFileName){
    	if(!fileName.isFile()){
    		return false;
    	}
        return fileName.renameTo(toFileName);
    }

    /**
     * 删除文件夹
     *
     * @param folderPath
     *            String 文件夹路径及名称 如c:/fqf
     * @return boolean
     */

    public static boolean delFolder(String folderPath) {
    	folderPath=SPath.getFormatFilePath(folderPath);
    	boolean flag=true;
        try {
            // 删除完里面所有内容
            delAllFile(folderPath);
            File filePath = new File(folderPath);
            // 删除空文件夹
            filePath.delete();
            flag=true;
        } catch (Exception e) {
        	flag=false;
        }
        return flag;
    }

    /**
     * 删除文件夹里面的所有文件
     *
     * @param path
     *            String 文件夹路径 如 c:/fqf
     * @return boolean
     */

    public static boolean delAllFile(String path) {
    	path=SPath.getFormatFilePath(path);
        File file = new File(path);
        boolean flag=true;
        if (!isDir(path)) {
            return false;
        }
        String[] tempList = file.list();
        File temp = null;
        for (int i = 0; i < tempList.length; i++) {
            if (path.endsWith(File.separator)) {
                temp = new File(path + tempList[i]);
            } else {
                temp = new File(path + File.separator + tempList[i]);
            }
            if (temp.isFile()) {
                temp.delete();
            }
            if (temp.isDirectory()) {
                // 先删除文件夹里面的文件
                delAllFile(path + "/" + tempList[i]);
                // 再删除空文件夹
                delFolder(path + "/" + tempList[i]);
            }
        }
        return flag;
    }

	/**
	 * 获取文件夹下的所以文件列表
	 * @param path
	 * @return String[]
	 */
	public static String[] getList(String path) {
		path=SPath.getFormatFilePath(path);
		if(!isDir(path)) {
			return null;
		}
		File file=new File(path);
		String[] list=file.list();
		return list;
	}

    /**
     * 返回路径path下所有文件列表,不包括子文件夹
     * @param path 文件路径
     * @return ArrayList
     */
    public static List getFileList(String path){
        path=SPath.getFormatFilePath(path);
        path=path+"/";
        File filePath=new File(path);
        if(!isDir(path)){
            return null;
        }
        final String theFilepath=path;
        final List filelistFilter=new ArrayList();
        filePath.listFiles(new FileFilter(){
            @Override
            public boolean accept(File pathname) {
                if( !pathname.isDirectory() ){
                    String tempfilename=SPath.getFormatFilePath(theFilepath+pathname.getName());
                    filelistFilter.add(tempfilename);
                }
                return false;
            }
        });

        return filelistFilter;
    }

    /**
     * 返回路径path下所有文件列表,包括子文件夹
     * @param path 文件路径
     * @return ArrayList
     */
    public static List getAllFileList(String path){
        path=SPath.getFormatFilePath(path);
        path=path+"/";
        File filePath=new File(path);
        if(!isDir(path)){
            return null;
        }
//      String[] filelist=filePath.list();

        final String theFilepath=path;
        final List filelistFilter=new ArrayList();

        filePath.listFiles(new FileFilter(){
            @Override
            public boolean accept(File pathname) {
                String tempfilename=SPath.getFormatFilePath(theFilepath+pathname.getName());
                if( !pathname.isDirectory() ){
                    filelistFilter.add(tempfilename);
                }else{
                    filelistFilter.addAll(getAllFileList(tempfilename));
                }
                return false;
            }
        });

        return filelistFilter;
    }

    /**
     * 返回路径path下所有文件夹列表,不包括子文件夹
     * @param path 文件路径
     * @return ArrayList
     */
    public static List getDirList(String path){

        path=SPath.getFormatFilePath(path);
        path=path+"/";
        File filePath=new File(path);
        if(!isDir(path)){
            return null;
        }

        final String theFilepath=path;
        final List dirList=new ArrayList();
        filePath.listFiles(new FileFilter(){
            @Override
            public boolean accept(File pathname) {
                if( pathname.isDirectory() ){
                    String tempfilename=SPath.getFormatFilePath(theFilepath+pathname.getName());
                    dirList.add(tempfilename);
                }
                return false;
            }
        });
        return dirList;
    }

	/**
	 * 返回路径path下所有文件夹列表,包括子文件夹
	 * @param path 文件路径
	 * @return ArrayList
	 */
	public static List getAllDirList(String path){
		path=SPath.getFormatFilePath(path);
		path=path+"/";
		File filePath=new File(path);
		if(!isDir(path)){
			return null;
		}
        final String theFilepath=path;
        final List dirList=new ArrayList();
		filePath.listFiles(new FileFilter(){
            @Override
            public boolean accept(File pathname) {
                if( pathname.isDirectory() ){
                    String tempfilename=SPath.getFormatFilePath(theFilepath+pathname.getName());
                    dirList.add(tempfilename);
                    dirList.addAll(getAllDirList(tempfilename));
                }
                return false;
            }
        });

		return dirList;
	}


    /**
     * 将文件内容读到字符串中
     * @param filename 文件名
     * @return String
     * @throws IOException
     */
    public static String fileToString(String filename) throws IOException{
    	return fileToString(filename,null);
    }

    /**
     * 将文件内容读到字符串中
     * @param filename 文件名
     * @param charsetName 字符集
     * @return String
     * @throws IOException
     */
    public static String fileToString(String filename,String charsetName) throws IOException{
    	filename=SPath.getFormatFilePath(filename);
    	if(!isFile(filename)){
    		return "";
    	}
    	StringWriter writer=new StringWriter();
    	append(writer,new File(filename),charsetName);

    	String content= writer.toString();
    	writer.close();
    	return content;
    }

    public static void append(Writer writer,File file,String charsetName) throws IOException{
    	InputStream inputStream=new FileInputStream(file);
    	try{
    		append(writer,inputStream,charsetName);
    	}finally{
    		if(inputStream!=null){
				inputStream.close();
    		}
    	}
    }

    public static void append(Writer writer,InputStream fileInputStream,String charsetName) throws IOException{
    	Reader reader=null;
    	try{
        	if(charsetName==null){
        		reader=new InputStreamReader(fileInputStream);
        	}else{
        		reader=new InputStreamReader(fileInputStream,charsetName);
        	}
            int c;
            while((c=reader.read())>-1){
                writer.append((char)c);
            }
            writer.flush();
    	}finally{
    		if(reader!=null){
    			reader.close();
    		}
        }
    }

    public static void append(OutputStream os,InputStream fileInputStream) throws IOException{
        byte[] buffer = new byte[1024 * 5];
        int bytesum = 0;
        int byteread = 0;
        while ((byteread = fileInputStream.read(buffer)) != -1) {
            bytesum += byteread;
            os.write(buffer, 0, byteread);
        }
        os.flush();
    }

	/**
	 * 将byte[]转为文件
	 * @param theBytes
	 * @param tofilename
	 * @throws IOException
	 */
	public static void byteToFile(byte[] theBytes,String tofilename) throws IOException{

		InputStream in = new ByteArrayInputStream(theBytes);
		try{
			DataInputStream dataInputStream = new DataInputStream(in);
			inputStreamToFile(dataInputStream, tofilename);
		}finally{
			in.close();
		}

	}


    /**
     * 把InputStream读到文件中
     * @param inputStream
     * @param destFile
     * @return boolean
     * @throws IOException
     */
    public static void inputStreamToFile(InputStream inputStream,String destFile) throws IOException{
    	destFile=SPath.getFormatFilePath(destFile);
    	if(!isFile(destFile)){
    		createFile(destFile);
    	}

    	BufferedOutputStream bufferedOutputStream = null;
        try{
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(destFile));
            append(bufferedOutputStream,inputStream);
        }finally{
        	if(bufferedOutputStream!=null) {
        		bufferedOutputStream.close();
        	}
        	if(inputStream!=null) {
        		inputStream.close();
        	}
        }
    }

    /**
     * 把文件读到OutputStream中
     * @param filename
     * @return OutputStream
     * @throws FileNotFoundException
     */
    public static OutputStream fileToOutputStream(String filename) throws FileNotFoundException{
    	filename=SPath.getFormatFilePath(filename);
		FileOutputStream output = new FileOutputStream(filename);
		return output;
    }

    /**
     * 把文件读到InputStream中
     * @param filename
     * @return InputStream
     * @throws FileNotFoundException
     */
    public static InputStream fileToInputStream(String filename) throws FileNotFoundException{
    	filename=SPath.getFormatFilePath(filename);
        BufferedInputStream bufferedInputStream=new BufferedInputStream(new FileInputStream(filename));
		return bufferedInputStream;
    }

    public static byte[] fileToByte(String filename) throws Exception{
        InputStream inputStream=null;
        try{
            inputStream=fileToInputStream(filename);
            byte[] fileByte=SInputStreamUtil.getBytes(inputStream);
            return fileByte;
        }finally{
            if(inputStream!=null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 检测文件是否传输完成
     * @param fileName
     * @return
     * @throws Exception
     */
    public static boolean checkFileWritingOn(String fileName) throws Exception{
        long oldLen = 0;
        long newLen = 0;
        File file = new File(fileName);
        while(true){
            newLen = file.length();
            if ((newLen - oldLen) > 0) {
                oldLen = newLen;
                log.info(fileName + " being transferred");
                Thread.sleep(1000);
            } else {
                log.info(fileName + " transmit complete");
                return true;
            }
        }
    }
}
