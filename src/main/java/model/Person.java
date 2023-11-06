package model;

import exceptions.EmptyNameException;
import exceptions.InvalidDateOfBirthException;
import java.time.LocalDate;

public class Person {

  // ATTRIBUTI
  private String name;
  private LocalDate dateOfBirth;

  // COSTRUTTORI
  public Person(String name, LocalDate dateOfBirth)
      throws EmptyNameException, InvalidDateOfBirthException {
    if (name == null || name.isEmpty()) {
      throw new EmptyNameException();
    }
    if (dateOfBirth == null || dateOfBirth.isAfter(LocalDate.now())) {
      throw new InvalidDateOfBirthException(dateOfBirth != null ? dateOfBirth.toString() : "null");
    }
    this.name = name;
    this.dateOfBirth = dateOfBirth;
  }

  // GETTER E SETTER
  public String getName() {
    return name;
  }

  public LocalDate getDateOfBirth() {
    return dateOfBirth;
  }

  // METODI
  public int getAge() {
    LocalDate now = LocalDate.now();
    return now.getYear() - dateOfBirth.getYear();
  }
}
