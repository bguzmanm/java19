package cl.awakelab.java19.controller;

import cl.awakelab.java19.model.dto.Actor;
import cl.awakelab.java19.model.service.ActorService;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/actor")
public class ActorController {
  Log logger = LogFactory.getLog(ActorController.class);

  private final ActorService service;

  public ActorController(ActorService service) {
    this.service = service;
  }

  // GET:http://localhost:8080/actor
  @GetMapping
  public String listActors(Model model){
    model.addAttribute("actors", service.findAll());
    return "actors";
  }

  // GET:http://localhost:8080/actor/{actorId}
  @GetMapping("/{actorId}")
  public String getActor(
          @PathVariable int actorId,
          Model model){

    logger.info("el actor id es = " + actorId);

    Actor actor = service.findOne(actorId);

    model.addAttribute("actor", actor);
    return "actor";
  }

  @GetMapping("/new")
  public String newActor(){
    return "actorNew";
  }

  @PostMapping("/new")
  public String saveActor(@ModelAttribute Actor actor){

    logger.info(actor.toString());

    boolean ok = service.create(actor);
    if (ok){
      return "redirect:/actor";
    } else {
      return "error";
    }
  }

  @GetMapping("/{actorId}/edit")
  public String editActor(@PathVariable int actorId, Model model){
    model.addAttribute("actor", service.findOne(actorId));
    return "actorEdit";
  }
  @PostMapping("/edit")
  public String saveEditActor(
          @ModelAttribute Actor actor,
          Model model){

    boolean ok = service.update(actor);
    if (ok){
      return "redirect:/actor";
    } else {
      return "error";
    }
  }
  @GetMapping("/{actorId}/delete")
  public String delete(@PathVariable int actorId){
    boolean ok = service.delete(actorId);
    if (ok){
      return "redirect:/actor";
    } else {
      return "error";
    }
  }



}
