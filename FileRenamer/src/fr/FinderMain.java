package fr;

public class FinderMain {

  public static void main(String[] args) {
    FileFinder finder = new FileFinder("C:\\Harald\\Bilder");
    finder.findAll("2018-11-10_Voksenmessen", true);
    System.out.println("DONE");
  }
}