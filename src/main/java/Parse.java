import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.UpdateValuesResponse;
import com.google.api.services.sheets.v4.model.ValueRange;

import java.io.*;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Parse {



    public static void main(String[] args) throws IOException, GeneralSecurityException {


        // Build a new authorized API client service.

     //   final String range = "A2:A4";
       /* Sheets service = new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                .setApplicationName(APPLICATION_NAME)
                .build(); */
       /* ValueRange response = getSheetsService().spreadsheets().values()
                .get(spreadsheetId, range)
                .execute();
        List<List<Object>> values = response.getValues();
        if (values == null || values.isEmpty()) {
            System.out.println("No data found.");
        } else {
            System.out.println("Name, Major");
            for (List row : values) {
                // Print columns A and E, which correspond to indices 0 and 4.
                System.out.printf("%s, %s\n", row.get(0), row.get(4));
            }
        }
*/
        GoogleSheetsClass googleSheetsClass = new GoogleSheetsClass();
        googleSheetsClass.writeInSheets();

/*ParseSongText parseSongText = new ParseSongText();
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
        } */
    }
}