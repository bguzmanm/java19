package cl.awakelab.java19.controller;

import cl.awakelab.java19.model.dto.ActorDTO;
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

    ActorDTO actor = new ActorDTO(1, "Rocio", "Cortavista");

    model.addAttribute("actor", actor);
    return "actor";
  }

  @GetMapping("/new")
  public String newActor(){
    return "actorNew";
  }

  @PostMapping("/new")
  public String saveActor(@ModelAttribute ActorDTO actor){

    logger.info(actor.toString());

    return "actorNew";

  }



}
