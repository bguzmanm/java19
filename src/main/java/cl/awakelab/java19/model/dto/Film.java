package cl.awakelab.java19.model.dto;

public class Film {
  private int id;
  private String title;
  private String description;
  private int releaseYear;
  private int languageId;
  private int length;
  private String rating;
  private String specialFeatures;

  public Film() {
  }

  public Film(int id, String title, String description, int releaseYear, int languageId, int length, String rating, String specialFeatures) {
    this.id = id;
    this.title = title;
    this.description = description;
    this.releaseYear = releaseYear;
    this.languageId = languageId;
    this.length = length;
    this.rating = rating;
    this.specialFeatures = specialFeatures;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public int getReleaseYear() {
    return releaseYear;
  }

  public void setReleaseYear(int releaseYear) {
    this.releaseYear = releaseYear;
  }

  public int getLanguageId() {
    return languageId;
  }

  public void setLanguageId(int languageId) {
    this.languageId = languageId;
  }

  public int getLength() {
    return length;
  }

  public void setLength(int length) {
    this.length = length;
  }

  public String getRating() {
    return rating;
  }

  public void setRating(String rating) {
    this.rating = rating;
  }

  public String getSpecialFeatures() {
    return specialFeatures;
  }

  public void setSpecialFeatures(String specialFeatures) {
    this.specialFeatures = specialFeatures;
  }

  @Override
  public String toString() {
    return "Film{" +
            "id=" + id +
            ", title='" + title + '\'' +
            ", description='" + description + '\'' +
            ", releaseYear=" + releaseYear +
            ", languageId=" + languageId +
            ", length=" + length +
            ", rating='" + rating + '\'' +
            ", specialFeatures='" + specialFeatures + '\'' +
            '}';
  }
}
