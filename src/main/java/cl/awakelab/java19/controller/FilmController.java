package cl.awakelab.java19.controller;

import cl.awakelab.java19.model.dto.Film;
import cl.awakelab.java19.model.service.FilmService;
import cl.awakelab.java19.model.service.LanguageService;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Mapeo de rutas
 * GET /film/
 * GET /film/{id}
 * GET /film/e/{id}
 * POST /film/e
 * GET /film/n
 * POST /film/n
 * GET /film/d/{id}
 */

@Controller
@RequestMapping("/film")
public class FilmController {
  Log logger = LogFactory.getLog(FilmController.class);

  private final FilmService service;
  private final LanguageService languageService;

  public FilmController(FilmService service, LanguageService languageService) {
    this.service = service;
    this.languageService = languageService;
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
    model.addAttribute("languages", languageService.findAll());

    return "film";
  }

  @GetMapping("/e/{filmId}")
  public String edit(@PathVariable int filmId, Model model){
    model.addAttribute("film", service.findById(filmId));
    model.addAttribute("languages", languageService.findAll());
    model.addAttribute("op", "e");
    return "film";
  }

  @PostMapping("/e")
  public String saveEdit(@ModelAttribute Film film){
    logger.info(film.toString());

    boolean ok = service.update(film);
    if (ok){
      return "redirect:/film";
    }
    logger.error("ha ocurrido un error al actualizar un film");
    return "error";
  }
  @GetMapping("/n")
  public String create(Model model){
    model.addAttribute("languages", languageService.findAll());
    model.addAttribute("op", "n");
    return "film";
  }

  @PostMapping("/n")
  public String saveCreate(@ModelAttribute Film film){
    logger.info(film.toString());

    boolean ok = service.create(film);
    if (ok){
      return "redirect:/film";
    }
    logger.error("ha ocurrido un error al crear un film");
    return "error";
  }

  @GetMapping("/d/{filmId}")
  public String delete(@PathVariable int filmId){
    boolean ok = service.delete(filmId);
    if (ok){
      return "redirect:/film";
    }

    logger.error("ha ocurrido una catastrofe, y mataste un gatito");
    return "error";
  }

}