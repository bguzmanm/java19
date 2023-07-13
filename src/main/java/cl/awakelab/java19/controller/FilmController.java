package cl.awakelab.java19.controller;

import cl.awakelab.java19.model.dto.Film;
import cl.awakelab.java19.model.service.FilmService;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/film")
public class FilmController {
  Log logger = LogFactory.getLog(FilmController.class);

  private final FilmService service;

  public FilmController(FilmService service) {
    this.service = service;
  }

  @GetMapping
  public String findAll(Model model){
    model.addAttribute("films", service.findAll());
    return "films";
  }

  @GetMapping("/{filmId}")
  public String findOne(
          @PathVariable int filmId,
          Model model){

    model.addAttribute("film", service.findById(filmId));

    return "film";
  }

  @GetMapping("/e/{filmId}")
  public String edit(@PathVariable int filmId, Model model){
    model.addAttribute("film", service.findById(filmId));
    model.addAttribute("op", "e");
    return "film";
  }

  @PostMapping("/e")
  public String saveEdit(@ModelAttribute Film film){
    logger.info(film.toString());

    boolean ok = service.update(film);

    if (ok){
      return "redirect:/film";
    } else {
      return "error";
    }
  }
}
