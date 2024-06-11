package course2.part3;

import com.google.gson.Gson;
import course2.model3.Member;

public class GsonToJson {

    public static void main(String[] args) {

        Member mvo = new Member("홍길동", 30, "bit@gmail.com");
        // JSON -> { "name" : "홍길동", "age" : 30, "email" : "bit@gmail.com" }

        // 객체 생성
        Gson gson = new Gson();

        // Object(Member) -> JSON
        String json = gson.toJson(mvo);

        System.out.println("json = " + json);

    }
}
