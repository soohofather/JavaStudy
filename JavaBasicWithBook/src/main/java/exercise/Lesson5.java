package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Lesson5 {

    public static void main(String[] args) throws IOException {
        System.out.println("2개 정수를 입력하십시오.");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            String str1 = br.readLine();
            String str2 = br.readLine();

            int num1 = Integer.parseInt(str1);
            int num2 = Integer.parseInt(str2);

            if (num1 == num2) {
                System.out.println("두 숫자는 같습니다.");
            } else if (num1 > num2) {
                System.out.println(num1 + "이 " + num2 + "보다 큽니다.");
            } else {
                System.out.println(num2 + "이 " + num1 + "보다 큽니다.");
            }

        } catch (NumberFormatException e) {
            System.out.println("정수가 아닌 값을 넣었습니다.");
        }
    }
}
