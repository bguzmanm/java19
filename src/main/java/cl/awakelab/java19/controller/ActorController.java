package cl.awakelab.java19.controller;

import cl.awakelab.java19.model.dto.ActorDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/actor")
public class ActorController {

  // GET:http://localhost:8080/actor
  @GetMapping
  public String listActors(Model model){

    List<ActorDTO> actorDTOList = new ArrayList<ActorDTO>();

    actorDTOList.add(new ActorDTO(1, "Rocio", "Cortavista"));
    actorDTOList.add(new ActorDTO(2, "Kevin", "Johansen"));
    actorDTOList.add(new ActorDTO(3, "Gallardo", "Caballero"));

    model.addAttribute("actors", actorDTOList);
    return "actors";
  }

  // GET:http://localhost:8080/actor/{actorId}
  @GetMapping("/{actorId}")
  public String getActor(
          @PathVariable("actorId") int actorId,
          Model model){

    System.out.println("el actor id es = " + actorId);

    ActorDTO actor = new ActorDTO(1, "Rocio", "Cortavista");

    model.addAttribute("actor", actor);
    return "actor";
  }

  // POST:http://localhost:8080/actor
  @PostMapping
  public String addActor(Model model){
    return "newActor";
  }
}
