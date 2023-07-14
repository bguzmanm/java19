package cl.awakelab.java19.model.dao;

import cl.awakelab.java19.model.dto.Language;

import java.util.List;

public interface LanguageDAO {
  Language findById(int id);
  List<Language> findAll();
  boolean create(Language language);
  boolean update(Language language);
  boolean delete(int id);
}
