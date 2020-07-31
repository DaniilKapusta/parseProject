public class ParseObjects {
    private String link;
    private String title;

    public String getStopWord() {
        return stopWord;
    }

    public void setStopWord(String stopWord) {
        this.stopWord = stopWord;
    }

    private String stopWord;

    public void parseObjects() {
        this.link = link;
        this.title = title;
        this.stopWord = stopWord;
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
