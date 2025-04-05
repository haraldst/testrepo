package fr;

import java.io.File;
import java.util.regex.Pattern;

public class FileFinder {

  private File root = null;
  private Pattern pattern = null;

  public FileFinder(String rootFolder) {
    root = new File(rootFolder);
  }

  public void findAll(String fileNamePattern, boolean recurseSubFolders) {
    pattern = Pattern.compile(fileNamePattern);
    this.findAll(root, recurseSubFolders);
  }

  private void findAll(File folder, boolean recurseSubFolders) {
    for (File f : folder.listFiles()) {
      if (pattern.matcher(f.getName()).find()) {
        System.out.println(f.getPath());
      }
      if (f.isDirectory()) {
        if (recurseSubFolders) {
          this.findAll(f, recurseSubFolders);
        }
      }
    }
  }
}
