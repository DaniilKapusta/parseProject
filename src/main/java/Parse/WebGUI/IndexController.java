package Parse.WebGUI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
@RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView showForm() {
    return new ModelAndView("index", "index", null);
}
}
