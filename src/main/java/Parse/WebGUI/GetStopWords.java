package Parse.WebGUI;

import Parse.googleSheets.GoogleSheetsClass;
import Parse.parseAlg.ParseObjects;
import Parse.parseAlg.ParseSongText;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class GetStopWords {

   @RequestMapping(value = "/eeee", method = RequestMethod.GET)
    public ModelAndView modelAndView(ModelMap model) {
         return new ModelAndView("getParseStopWord.html","model",model);
    }


ParseSongText parseSongText = new ParseSongText();
GoogleSheetsClass googleSheetsClass = new GoogleSheetsClass();


    @PostMapping("/getParseStopWord")
    public String submit(String stopWord, String text, String textFile, ModelMap model, HttpServletRequest req
                   ,  RedirectAttributes redirectAttributes    ) throws IOException, GeneralSecurityException {
        List<String> ss = new ArrayList<>();
        List<ParseObjects> parseObjects = new ArrayList<>();
       if (text.equals("textValue")) {
            String[] stW = stopWord.split(";");
            for (String s : stW) {
                if (!s.equals(" ")) {
                    System.out.println("Word = " + s.trim());
                    ss.add(s.trim());
                }
            }
           parseObjects = parseSongText.returnStopWords(ss);
           googleSheetsClass.writeInSheets(parseObjects);
        }
        if (text.equals("fileValue")) {
/*
            FileReader fr = new FileReader(textFile);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                // считываем остальные строки в цикле
                line = reader.readLine();
            }
            */

            System.out.println(textFile);

        }
model.addAttribute("str",parseObjects);
redirectAttributes.addFlashAttribute("data",parseObjects);

return "redirect:/ass";
    }


}
