package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Lesson6 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            System.out.println("2이상의 큰 수를 입력하세요.");
            String str = br.readLine();
            int num = Integer.parseInt(str);

            for(int i = 2; i <= num; i++){
                if (i == num){
                    System.out.println(num +" 은 소수입니다.");
                }else if(num % i == 0){
                    System.out.println(num +" 은 소수가 아닙니다.");
                    break;
                }
            }

        } catch (NumberFormatException e) {
            System.out.println("정수가 아닌 값을 넣었습니다.");
        }
    }
}