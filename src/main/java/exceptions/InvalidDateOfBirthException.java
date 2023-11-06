package exceptions;

public class InvalidDateOfBirthException extends IllegalArgumentException {

  public InvalidDateOfBirthException(String s) {
    super(s);
  }
}
