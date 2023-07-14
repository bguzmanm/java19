package cl.awakelab.java19.model.service;

import cl.awakelab.java19.model.dao.LanguageDAO;
import cl.awakelab.java19.model.dto.Language;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageService {
  LanguageDAO dao;
  public LanguageService(LanguageDAO dao) {
    this.dao = dao;
  }

  public List<Language> findAll(){
    return dao.findAll();
  }

}
