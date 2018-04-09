package examples.teamboard.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/boards")
public class BoardController {

    @GetMapping
    public String boards(){

        return "boards_list";
    }
}
