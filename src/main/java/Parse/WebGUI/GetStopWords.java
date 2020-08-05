package Parse.WebGUI;

import Parse.googleSheets.GoogleSheetsClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.*;

@Controller
public class GetStopWords {
    @RequestMapping(value = "/getParseStopWord", method = RequestMethod.GET)
    public ModelAndView modelAndView() {
        return new ModelAndView("getParseStopWord", "getParseStopWord", null);
    }


GoogleSheetsClass googleSheetsClass = new GoogleSheetsClass();
    //@RequestMapping(value = "/getParseStopWord", method = RequestMethod.POST)


    @PostMapping("/getParseStopWord")
    public String submit(String stopWord, String text, String textFile, ModelMap model, HttpServletRequest req
                         ) throws IOException, GeneralSecurityException {
        List<String> ss = new ArrayList<>();
       if (text.equals("textValue")) {
            String[] stW = stopWord.split(";");
            for (String s : stW) {
                if (!s.equals(" ")) {
                    System.out.println("Word = " + s.trim());
                    ss.add(s.trim());
                }
            }
            googleSheetsClass.writeInSheets(ss);
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
model.addAttribute("model","model");

return "index";
    }


}
