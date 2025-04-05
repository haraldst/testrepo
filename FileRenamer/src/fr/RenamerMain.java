package fr;

public class RenamerMain {

  /**
   * Rename folder names from dd.mm.yyyy to yyyy-mm-dd
   */
  public static void main(String[] args) {
    Renamer renamer = new Renamer("D:\\Harald\\Bilder\\Sony");
    renamer.renameAll();
  }
}