package course2.part3;

import course2.model3.Address;
import course2.model3.Person;
import com.google.gson.Gson;

public class GsonMemAddToJson {

    public static void main(String[] args) {

        Address address = new Address("서울", "대한민국");
        Person member = new Person("홍길동",  30, "bit@gmail.com", address);

        // Person -> JSON
        Gson gson = new Gson();
        String json = gson.toJson(member);
        System.out.println("json = " + json);

    }
}
