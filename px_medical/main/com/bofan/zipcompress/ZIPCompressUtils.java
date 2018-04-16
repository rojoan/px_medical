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
     * @param srcFile Ҫѹ����Ŀ¼���ļ�
     * @param zipFile ѹ������ļ���
     * @throws Exception
     */
    public static void doCompress(String srcFile, String zipFile) throws Exception {
        doCompress(new File(srcFile), new File(zipFile));
    }
    

    /**
     * �ļ�ѹ��
     * 
     * @param srcFile
     *            Ŀ¼���ߵ����ļ�
     * @param zipFile
     *            ѹ�����ZIP�ļ�
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
     * @param filelName Ҫѹ�����ļ����ƻ�Ŀ¼����
     * @param out ѹ�����������
     * @throws IOException
     */
    public static void doCompress(String filelName, ZipOutputStream out) throws IOException {
        doCompress(new File(filelName), out);
    }

    /**
     * @param file Ҫѹ�����ļ���Ŀ¼����
     * @param out ѹ�����������
     * @throws IOException
     */
    public static void doCompress(File file, ZipOutputStream out) throws IOException {
        doCompress(file, out, "");
    }

    /**
     * 
     * @param inFile Ҫѹ�����ļ���Ŀ¼����
     * @param out ѹ�����������
     * @param dir ѹ�����ŵ�Ŀ¼
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
     * ѹ��
     * @param inFile Ҫѹ�����ļ���Ŀ¼����
     * @param out ѹ�����������
     * @param dir ѹ�����ŵ�Ŀ¼
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
     * ɾ���ļ��м����ļ�
     * @param directory
     * @return
     */
    public static boolean deleteFolder(File file) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null && files.length > 0) {
                // �ݹ�ɾ��Ŀ¼�е���Ŀ¼��
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
     * �ж�Ŀ¼�Ƿ�����ļ�
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
