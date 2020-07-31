import java.io.FileWriter;
import java.io.IOException;

public class Parse {
    public static void main(String[] args) throws IOException {
        ParseSongText parseSongText = new ParseSongText();

        try (FileWriter writer = new FileWriter("notes3.txt", false)) {
            parseSongText.returnStopWords().forEach(tx -> {
                try {
                    writer.write(tx.getTitle()+"\n");
                    writer.write(tx.getLink()+"\n");
                    writer.write(tx.getStopWord()+"\n");

                } catch (IOException e) {
                    e.printStackTrace();
                }

            });


            writer.flush();
        } catch (IOException ex) {
        }
    }
}