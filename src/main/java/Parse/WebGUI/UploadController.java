package Parse.WebGUI;

import Parse.googleSheets.GoogleSheetsClass;
import Parse.parseAlg.ParseObjects;
import Parse.parseAlg.ParseSongText;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UploadController {
    ParseSongText parseSongText = new ParseSongText();
GoogleSheetsClass googleSheetsClass = new GoogleSheetsClass();
    //Save the uploaded file to this folder
    private static String UPLOADED__FOLDER = "./src/main/resources/data/";

    @GetMapping("/upload")
    public String index() {
        return "upload";
    }

    @PostMapping("/upload")////new annotation since 4.3
    public String singleFileUpload(@RequestParam("textFile") MultipartFile file,
                                   RedirectAttributes redirectAttributes) throws IOException, GeneralSecurityException {

List<String> stopWords = new ArrayList<>();
String[] stW = null;

        try {

            //Get the file and save it somewhere
            byte[]bytes = file.getBytes();
            Path path = Paths.get(UPLOADED__FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);



        } catch (IOException e) {
            e.printStackTrace();
        }
        /*
        File fileSt = new File(UPLOADED__FOLDER + file.getOriginalFilename());
        //создаем объект FileReader для объекта File
        FileReader fr = new FileReader(fileSt);
        //создаем BufferedReader с существующего FileReader для построчного считывания
        BufferedReader reader = new BufferedReader(fr);
        // считаем сначала первую строку
        String line = reader.readLine();
        while (line != null) {

            String s = line.replaceAll(";", " ");
            stopWords.add(s.trim());
            System.out.println(s.trim());
            // считываем остальные строки в цикле
            line = reader.readLine();
        }
        */
        // считываем содержимое файла в String с помощью BufferedReader

            BufferedReader reader = new BufferedReader( new FileReader (UPLOADED__FOLDER + file.getOriginalFilename()));
            String line = null;
            StringBuilder stringBuilder = new StringBuilder();
            String ls = System.getProperty("line.separator");
            while( ( line = reader.readLine() ) != null ) {
                stringBuilder.append( line );
                stringBuilder.append( ls );
            }

            stringBuilder.deleteCharAt(stringBuilder.length()-1);
            stW = stringBuilder.toString().split(";");
        for (String s : stW) {
            if (!s.equals(" ")) {
                System.out.println("Word = " + s.trim());
                stopWords.add(s.trim());
            }
        }

List<ParseObjects> parseObjects = new ArrayList<>();
        parseObjects = parseSongText.returnStopWords(stopWords);
googleSheetsClass.writeInSheets(parseObjects);
       redirectAttributes.addFlashAttribute("data",parseObjects);
        return "redirect:/ass";
    }



}