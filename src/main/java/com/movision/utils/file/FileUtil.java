package com.movision.utils.file;

import com.movision.utils.UUIDGenerator;

import java.io.File;
import java.util.Date;

/**
 * @Author shuxf
 * @Date 2017/6/16 15:01
 */
public class FileUtil {

    /**
     * 重新命名文件
     *
     * @param file
     * @return
     */
    public static File renameFile(File file) {

        int index = file.getName().lastIndexOf("."); // 获取文件名中【.】的下标
        String body = UUIDGenerator.genShortUuid();// file.getName().substring(0,
        // index);//文件名
        String postfix; // 表示文件名的后缀，即【.ccc】
        String timer; // 代表当前系统时间的数字

        // 如果该文件的名字中，没有【.】的话，那么lastIndexOf(".")将返回-1
        if (index != -1) {
            timer = new Date().getTime() + ""; // 在文件的名字前面，添加的表示当前系统时间的数字
            postfix = file.getName().substring(index); // 获取到文件名当中的【.ccc】
        } else {
            timer = new Date().getTime() + "";
            postfix = ""; // 如果lastIndexOf(".")返回-1，说明该文件名中没有【.】即没有后缀
        }
        String newName = body + timer + postfix; // 构造新的文件名
        return new File(file.getParent(), newName); // 返回重命名后的文件
    }
}
