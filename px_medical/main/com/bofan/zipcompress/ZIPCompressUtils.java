package com.bofan.zipcompress;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @Description
 * @author xlf
 * @version 2017-10-23
 */
public class ZIPCompressUtils {

    /**
     * @param srcFile 要压缩的目录或文件
     * @param zipFile 压缩后的文件名
     * @throws Exception
     */
    public static void doCompress(String srcFile, String zipFile) throws Exception {
        doCompress(new File(srcFile), new File(zipFile));
    }
    

    /**
     * 文件压缩
     * 
     * @param srcFile
     *            目录或者单个文件
     * @param zipFile
     *            压缩后的ZIP文件
     */
    public static void doCompress(File srcFile, File zipFile) throws Exception {
        ZipOutputStream out = null;
        try {
            out = new ZipOutputStream(new FileOutputStream(zipFile));
            doCompress(srcFile, out);
        } catch (Exception e) {
            throw e;
        } finally {
            out.close();
        }
    }

    /**
     * @param filelName 要压缩的文件名称或目录名称
     * @param out 压缩输出流对象
     * @throws IOException
     */
    public static void doCompress(String filelName, ZipOutputStream out) throws IOException {
        doCompress(new File(filelName), out);
    }

    /**
     * @param file 要压缩的文件或目录对象
     * @param out 压缩输出流对象
     * @throws IOException
     */
    public static void doCompress(File file, ZipOutputStream out) throws IOException {
        doCompress(file, out, "");
    }

    /**
     * 
     * @param inFile 要压缩的文件或目录对象
     * @param out 压缩输出流对象
     * @param dir 压缩后存放的目录
     * @throws IOException
     */
    public static void doCompress(File inFile, ZipOutputStream out, String dir) throws IOException {
        if (inFile.isDirectory()) {
            File[] files = inFile.listFiles();
            if (files != null && files.length > 0) {
                for (File file : files) {
                    String name = inFile.getName();
                    if (!"".equals(dir)) {
                        name = dir + "/" + name;
                    }
                    ZIPCompressUtils.doCompress(file, out, name);
                }
            }
        } else {
            ZIPCompressUtils.doZip(inFile, out, dir);
        }
    }

    /**
     * 压缩
     * @param inFile 要压缩的文件或目录对象
     * @param out 压缩输出流对象
     * @param dir 压缩后存放的目录
     * @throws IOException
     */
    public static void doZip(File inFile, ZipOutputStream out, String dir) throws IOException {
        String entryName = null;
        if (!"".equals(dir)) {
            entryName = dir + "/" + inFile.getName();
        } else {
            entryName = inFile.getName();
        }
        
        ZipEntry entry = new ZipEntry(entryName);
        out.putNextEntry(entry);

        int len = 0;
        byte[] buffer = new byte[1024];
        FileInputStream fis = new FileInputStream(inFile);
        while ((len = fis.read(buffer)) > 0) {
            out.write(buffer, 0, len);
            out.flush();
        }
        out.closeEntry();
        fis.close();
    }

    /**
     * 删除文件夹及子文件
     * @param directory
     * @return
     */
    public static boolean deleteFolder(File file) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null && files.length > 0) {
                // 递归删除目录中的子目录下
                for (int i = 0; i < files.length; i++) {
                    if (!files[i].delete()) {
                        return false;
                    }
                }
            }
            return file.delete();
        }
        return false;
    }
    
    /**
     * 判断目录是否存在文件
     * @param directory
     * @return
     */
    public static boolean existChild(File file) {    
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null && files.length > 0) {
                return true;
            }
        }
        return false;
    }
    
}
