package dev_AnilOrhan.GetirCase.Controller;

import dev_AnilOrhan.GetirCase.Controller.UserRepository.BookRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookOrderController {
    @Autowired
    private BookRep bookRep;

    @RequestMapping(value = "/BookOrder")
    ModelAndView submitBookOrder(){
        ModelAndView mav = new ModelAndView("BookOrder");
        mav.addObject("Books", bookRep.findAll());
        return mav;
    }



}
