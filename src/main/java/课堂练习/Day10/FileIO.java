package 课堂练习.Day10;

import java.io.*;


public class FileIO {
    private static final String srcPath = "C:\\Users\\12707\\Desktop\\Ronry\\2035\\codes\\Works\\src\\main\\java\\课堂练习\\Day10\\阿狸.png";
    private static final String outPath = "C:\\Users\\12707\\Desktop\\Ronry\\2035\\codes\\Works\\src\\main\\java\\课堂练习\\Day10\\阿狸New.png";
    // 读入图像
    public static void main(String[] args) {
        File originalFile = new File(srcPath);
        FileInputStream input = null;
        FileOutputStream output = null;
        try{
            File resultFile = new File(outPath);
            if(resultFile.exists()){
                resultFile.delete();
                resultFile = new File(outPath);
            }
            if (!resultFile.exists()){
                resultFile.createNewFile();
            }
            input = new FileInputStream(originalFile);
            output = new FileOutputStream(resultFile);
            int len;
            byte[] buffer = new byte[1024];
            while((len = input.read(buffer)) != -1){
                output.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                output.close();
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
