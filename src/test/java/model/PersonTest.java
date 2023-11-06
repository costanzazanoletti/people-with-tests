package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import exceptions.EmptyNameException;
import exceptions.InvalidDateOfBirthException;
import java.time.LocalDate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PersonTest {

  @Test
  @DisplayName("computes correct age")
  void getAge() {
    Person mockPerson = new Person("mock", LocalDate.now().minusYears(23));
    assertEquals(23, mockPerson.getAge());
    assertNotEquals(30, mockPerson.getAge());

  }

  @Test
  @DisplayName("throws EmptyNameException when name is null or empty")
  void emptyNameConstructor() {
    assertThrows(EmptyNameException.class, () -> {
      new Person(null, LocalDate.parse("2000-01-01"));
    });
    assertThrows(EmptyNameException.class, () -> {
      new Person("", LocalDate.parse("2000-01-01"));
    });
  }

  @Test
  @DisplayName("throws InvalidDateOfBirthException when date is in the future")
  void invalidDateConstructor() {
    assertThrows(InvalidDateOfBirthException.class, () -> {
      new Person("mock", null);
    });
    assertThrows(InvalidDateOfBirthException.class, () -> {
      new Person("mock", LocalDate.now().plusDays(1));
    });
  }
}