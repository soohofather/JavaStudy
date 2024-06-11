package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Lesson7 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("몇개의 점수를 입력하실건가요? (정수만)");

        try{

            String str = br.readLine();
            int num = Integer.parseInt(str);

            int[] test = new int[num];

            for (int jj = 0; jj < test.length; jj++){
                System.out.println("점수를 입력하세요 (정수만)");
                String str1 = br.readLine();
                int num1 = Integer.parseInt(str1);
                test[jj] = num1;
            }

            System.out.println("입력된 순서대로의 점수는");
            for (int iii = 0; iii <test.length; iii++){
                System.out.println(test[iii]);
            }

            for(int i = 0; i < test.length - 1; i++){
                for(int j = i + 1; j <= test.length - 1; j++){
                    if (test[i] < test[j]){
                        int temp = test[i];
                        test[i] = test[j];
                        test[j] = temp;
                    }
                }
            }
            System.out.println("점수가 높은 순서대로는");
            for(int ii = 0; ii < test.length; ii++){
                System.out.println(test[ii]);
            }

        }catch (NumberFormatException e) {
            System.out.println("정수가 아닌 값을 넣었습니다.");
        }


    }
}
