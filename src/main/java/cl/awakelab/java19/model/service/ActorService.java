package cl.awakelab.java19.model.service;

import cl.awakelab.java19.model.dto.ActorDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ActorService {

  public List<ActorDTO> findAll(){
    List<ActorDTO> actorDTOList = new ArrayList<ActorDTO>();

    actorDTOList.add(new ActorDTO(1, "Rocio", "Cortavista"));
    actorDTOList.add(new ActorDTO(2, "Kevin", "Johansen"));
    actorDTOList.add(new ActorDTO(3, "Gallardo", "Caballero"));
    actorDTOList.add(new ActorDTO(4, "Boby", "Balboa"));
    actorDTOList.add(new ActorDTO(5, "Betty", "Boob"));

    return actorDTOList;
  }
}
