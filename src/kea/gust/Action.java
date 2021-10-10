package kea.gust;

public interface Action {

  default String move() {
    return "Swiggity Swoggity";
  }

  default String eat() {
    return "Yum";
  }

  default String mate() {
    return "Uhm?" ;
  }

  default String sleep() {
    return "Zzzz";
  }

  default String specialMove() {
    return "*Dash*";
  }

  default String danger() {
    return "!!!";
  }

  default String die() {
    return "*Bite*";
  }
}