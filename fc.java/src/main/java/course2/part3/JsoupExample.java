package course2.part3;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsoupExample {
    public static void main(String[] args) {
        String url = "https://sum.su.or.kr:8888/bible/today";

        // .get()은 예외처리를 해줘야함
        try{

        Document document = Jsoup.connect(url).get();

        Element bibleText = document.getElementById("bible_text");
        Element bibleinfobox = document.getElementById("bibleinfo_box");

        System.out.println("bibleiText = " + bibleText.text());
        System.out.println("bibleinfobox = " + bibleinfobox.text());

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
