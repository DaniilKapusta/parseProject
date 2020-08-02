import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ParseSongText {
public List<ParseObjects> returnStopWords(String word) throws IOException {

    SongList songList = new SongList();
    List<ParseObjects> parseObjects = new ArrayList<>();
    songList.returnList().forEach(sg -> {

    Document doc = null;
    try {
        doc = Jsoup.connect(sg.getLink()).get();
    } catch (IOException e) {
        e.printStackTrace();
    }

    Elements songText = doc.getElementsByAttributeValue("class", "Lyrics__Container-sc-1ynbvzw-2 jgQsqn");

    while (songText.text().isEmpty()) {
        try {
            doc = Jsoup.connect(sg.getLink()).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        songText = doc.getElementsByAttributeValue("class", "Lyrics__Container-sc-1ynbvzw-2 jgQsqn");
    }




        int index = songText.text().indexOf(word);



if (index == - 1) {
    sg.setStopWord("No");
}
else {
    sg.setStopWord("Yes");
}

        parseObjects.add(sg);

    });


    parseObjects.forEach(po -> {
        System.out.println(po.getTitle());
        System.out.println(po.getAuthor());
        System.out.println(po.getLink());
        System.out.println(po.getStopWord());
    });
    return parseObjects;
}
}
