package cl.awakelab.java19.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/actor")
public class ActorController {

  @GetMapping
  public String listActors(Model model){
    model.addAttribute("nombre", "Brian");
    return "actors";
  }

}
