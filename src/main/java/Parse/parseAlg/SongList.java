package Parse.parseAlg;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SongList {
    public List<ParseObjects> returnList() throws IOException {
        List<ParseObjects> parseObjectsList = new ArrayList<>();
        Document doc = Jsoup.connect("https://genius.com/").get();
        Elements h3Element = doc.getElementsByAttributeValue("class","PageGriddesktop-a6v82w-0 ChartItemdesktop__Row-sc-3bmioe-0 qsIlk");
        h3Element.forEach(h3 -> {

            ArrayList<Element> href = h3.getElementsByAttribute("href");
            href.forEach(hr -> {
                ParseObjects parseObjects = new ParseObjects();
                parseObjects.setLink(hr.attr("href"));
                parseObjects.setTitle(hr.getElementsByAttributeValue("class","ChartSongdesktop__Title-sc-18658hh-3 fODYHn").text());
                parseObjects.setAuthor(hr.getElementsByAttributeValue("class","ChartSongdesktop__Artist-sc-18658hh-5 kiggdb").text());
                parseObjectsList.add(parseObjects);
            });



        });

        return parseObjectsList;
    }

}
