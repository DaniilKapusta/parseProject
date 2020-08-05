package Parse;

import Parse.googleSheets.GoogleSheetsClass;

import java.io.IOException;
import java.security.GeneralSecurityException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class Application {

    public static void main(String[] args) throws IOException, GeneralSecurityException {
        SpringApplication.run(Application.class, args);
        //GoogleSheetsClass googleSheetsClass = new GoogleSheetsClass();
      //  googleSheetsClass.writeInSheets();

    }
}