package mwt;

import java.io.*;

/**
 * 文件操作
 * File 文件类
 *  .exists() 判断文件夹/文件是否存在
 *  .mkdir() 创建单层文件目录
 *  .mkdir() 创建多层文件目录
 *  .createNewFile()  创建新文件
 *
 * FileWriter 文件写
 *  .writer() 将内容写入文件中
 *  .close()  关闭文件写
 *
 * FileInputStream   文件输入流
 * InputStreamReader 输入流读取字符
 * BufferedReader    缓冲读取
 *  .read() 读取一个字符
 *  .readLine() 读取一行字符
 */
public class Demo7 {
    public static void main(String[] args) throws IOException {
        String content = "hello world!";
        String filePath = "./resources/files/";
        String fileName = "fileClassText1.txt";

        File dir = new File(filePath);
        //判断目录是否存在并创建
        if(!dir.exists()){
            dir.mkdirs();
        }

        File file = new File(filePath + fileName);
        //判断文件是否存在并创建
        if(!file.exists()){
            file.createNewFile();
            //在文件中写内容
            FileWriter fileWriter = new FileWriter(filePath + fileName);
            fileWriter.write(content);
            fileWriter.close();
        }

        //逐行读取文件中的内容
        FileInputStream fileInputStream = new FileInputStream(filePath + fileName);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String str = "";
        while((str = bufferedReader.readLine())!=null){
            System.out.println(str);
        }
    }
}
