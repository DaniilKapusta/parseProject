package Parse.parseAlg;

import java.util.List;

public class ParseObjects {
    private String link;
    private String title;
    private List<String> stopWord;
    private String author;
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }



    public List<String> getStopWord() {
        return stopWord;
    }

    public void setStopWord(List<String> stopWord) {
        this.stopWord = stopWord;
    }



    public void parseObjects() {
        this.link = link;
        this.title = title;
        this.stopWord = stopWord;
        this.author = author;
    }
    public String getLink() {
        return link;
    }

    public void setLink(String url) {
        this.link = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
