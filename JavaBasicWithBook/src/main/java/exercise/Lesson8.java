package exercise;

public class Lesson8{

    private int x;
    private int y;

    public void setNum(int px, int py){
        x = px;
        y = py;

        System.out.println("x 값은" + x + " y 값은" + y + " 로 설정 되었습니다.");
    }

}

class MyPoint{
    public static void main(String[] args) {
        Lesson8 xy = new Lesson8();

        xy.setNum(123, 123);
    }
}
