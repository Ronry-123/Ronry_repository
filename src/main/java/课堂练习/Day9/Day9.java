package 课堂练习.Day9;

import java.io.*;
import java.util.Arrays;

public class Day9 {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\12707\\Desktop\\Ronry\\2035\\codes\\Works\\src\\main\\java\\课堂练习");
        System.out.println(file.isDirectory());
        File[] files= file.listFiles();
        for (File value : files) {
            System.out.println(value.getName());
        }

        //写入 file
        String content = "Hello, world!\nHello, world";
        File file2 = new File("C:\\Users\\12707\\Desktop\\Ronry\\2035\\codes\\Works\\src\\main\\java\\课堂练习\\Day9\\TXT.txt");
        BufferedWriter bufferedWriter = null;
        try{
            bufferedWriter = new BufferedWriter(new FileWriter(file2));
            bufferedWriter.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try{
                bufferedWriter.close();
            } catch(Exception e){
                e.printStackTrace();
            }
        }

        //读入 file
        String con;
        BufferedReader bufferedReader = null;
        try{
            bufferedReader = new BufferedReader(new FileReader(file2));
            String s = bufferedReader.readLine();
            System.out.println(s);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                bufferedReader.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
