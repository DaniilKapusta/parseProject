package Parse.parseAlg;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParseSongText {
public List<ParseObjects> returnStopWords(List<String> word) throws IOException {

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


        List<String> stopWords = new ArrayList<>();
        Elements finalSongText = songText;
        word.forEach(w -> {
          //  System.out.println(w);
          //  System.out.println("///");
        if (finalSongText.text().contains(w)) {
           System.out.println(w);
           // System.out.println("///");
            stopWords.add(w);
        }
    });




if (stopWords.isEmpty()) {
    stopWords.add("No words");
    sg.setStopWord(stopWords);
}
else {
    sg.setStopWord(stopWords);
}

        parseObjects.add(sg);

    });

/*
    parseObjects.forEach(po -> {
        System.out.println(po.getTitle());
        System.out.println(po.getAuthor());
        System.out.println(po.getLink());
        System.out.println(po.getStopWord());
    });
    */

    return parseObjects;
}
}
