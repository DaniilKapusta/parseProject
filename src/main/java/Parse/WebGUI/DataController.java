package Parse.WebGUI;

import Parse.parseAlg.ParseObjects;
import com.google.api.client.json.Json;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DataController {
private List<ParseObjects> parseObjectsList = new ArrayList<>();
    @RequestMapping(value = "/ass", method = RequestMethod.GET)
    public String ss(@ModelAttribute("data") List<ParseObjects> parseObjects) {
        parseObjectsList = parseObjects;
        return "index.html";
    }
    @ResponseBody
    @RequestMapping(value = "/GiveData", method = RequestMethod.GET)
    public List<ParseObjects> giveData() {

        return parseObjectsList;
    }
}
