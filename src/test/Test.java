/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tuank
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

      
        //C2 generate from quizlet follow format Question | Answer:
        // Must answer before => answer
        /*  EXAMPLE:
            B
            QN=210 Theo quan điểm của Đại hội Đảng XI, nước ta hiện tồn tại
            a. 5 thành phần kinh tế
            b. 4 thành phần kinh tế
            c. 3 thành phần kinh tế
            -------
        */
        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader(
                    "D:\\FPT_Course\\Nam4(final)\\ki9\\KEY\\ITA of tranthu.txt"));
            String line = reader.readLine();
            while (line != null) {
                List<String> temp = new ArrayList<>();
                // read next line
                while (!line.startsWith("--")) {
                    temp.add(line);
                    line = reader.readLine();
                }

                String answer = temp.get(0);
                if (temp.size() == 2) {
                    System.out.print(temp.get(1) + " | ");
                    System.out.println(answer);
                    temp.clear();
                    line = reader.readLine();
                    continue;
                }
                //split answer if have more 1 answer
                String[] ans = answer.split(" ");
                for (int j = 2; j < temp.size(); j++) {
                    if (ans.length > 1) {
                        for (String as : ans) {
                            if (temp.get(j).toLowerCase().startsWith(as.trim().toLowerCase())) {
                                System.out.print(temp.get(1) + " | ");
                                System.out.println(temp.get(j));
                                break;
                            }
                        }
                    } else {
                        if (temp.get(j).toLowerCase().startsWith(answer.trim().toLowerCase())) {
                            System.out.print(temp.get(1) + " | ");
                            System.out.println(temp.get(j));
                            break;
                        }
                    }
                }
                temp.clear();
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
