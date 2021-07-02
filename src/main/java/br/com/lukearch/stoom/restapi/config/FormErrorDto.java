package br.com.lukearch.stoom.restapi.config;

public class FormErrorDto {
  private String field;
  private String errorMessage;
  public FormErrorDto(String field, String errorMessage) {
    this.field = field;
    this.errorMessage = errorMessage;
  }
  
  /** 
   * @return String
   */
  public String getField() {
    return field;
  }
  
  /** 
   * @return String
   */
  public String getErrorMessage() {
    return errorMessage;
  }
}
