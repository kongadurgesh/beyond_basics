package entity;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileTester {
    public void test() throws IOException {
        FileReader reader_1 = new FileReader(
                "C:\\Users\\konga\\Study\\LEX\\Java_Beyond_Basics\\beyond_basics\\src\\entity\\JohnTerm1.txt");
        FileReader reader_2 = new FileReader(
                "C:\\Users\\konga\\Study\\LEX\\Java_Beyond_Basics\\beyond_basics\\src\\entity\\JohnTerm2.txt");

        BufferedReader bufferedReader_1 = new BufferedReader(reader_1);

        BufferedReader bufferedReader_2 = new BufferedReader(reader_2);

        String line_1 = bufferedReader_1.readLine();
        String line_2 = bufferedReader_2.readLine();

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(
                "C:\\Users\\konga\\Study\\LEX\\Java_Beyond_Basics\\beyond_basics\\src\\entity\\JohnTotal.txt"));

        while (line_1 != null && line_2 != null) {
            bufferedWriter.write(String.valueOf(Integer.parseInt(line_1) + Integer.parseInt(line_2)));
            bufferedWriter.newLine();
            line_1 = bufferedReader_1.readLine();
            line_2 = bufferedReader_2.readLine();
        }
        bufferedReader_1.close();
        bufferedReader_2.close();
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    public void test2() {
        try (FileReader reader_1 = new FileReader(
                "C:\\Users\\konga\\Study\\LEX\\Java_Beyond_Basics\\beyond_basics\\src\\entity\\JohnTerm1.txt");
                FileReader reader_2 = new FileReader(
                        "C:\\Users\\konga\\Study\\LEX\\Java_Beyond_Basics\\beyond_basics\\src\\entity\\JohnTerm2.txt");
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(
                        "C:\\Users\\konga\\Study\\LEX\\Java_Beyond_Basics\\beyond_basics\\src\\entity\\JohnTotal.txt"));) {
            BufferedReader bufferedReader_1 = new BufferedReader(reader_1);

            BufferedReader bufferedReader_2 = new BufferedReader(reader_2);
            String line_1 = bufferedReader_1.readLine();
            String line_2 = bufferedReader_2.readLine();
            while (line_1 != null && line_2 != null) {
                bufferedWriter.write(String.valueOf(Integer.parseInt(line_1) + Integer.parseInt(line_2)));
                bufferedWriter.newLine();
                line_1 = bufferedReader_1.readLine();
                line_2 = bufferedReader_2.readLine();
            }
            bufferedReader_1.close();
            bufferedReader_2.close();
            bufferedWriter.flush();
            bufferedWriter.close();

        } catch (Exception e) {
            System.out.println("Exception Occured");
        }
    }
}
