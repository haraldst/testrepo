package fr;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Renamer {
  final File root;
  final Pattern pattern;

  public Renamer(String string) {
    root = new File(string);
    pattern = Pattern.compile("^(\\d+)\\.(\\d+)\\.(\\d+)");
  }

  public void renameAll() {
    if (!root.isDirectory()) {
      System.out.println(root.getAbsolutePath() + "is not a directory");
      return;
    }
    for (File f : root.listFiles()) {
      if (!f.isDirectory()) {
        continue;
      }

      Matcher matcher = pattern.matcher(f.getName());
      int day = 0, month = 0, year = 0;
      if (matcher.find()) {
        day = Integer.parseInt(matcher.group(1));
        month = Integer.parseInt(matcher.group(2));
        year = Integer.parseInt(matcher.group(3));
        String newName = String.format("%04d-%02d-%02d", year, month, day);
        rename(f, new File(newName));
      }
    }
  }

  private void rename(File oldName, File newName) {
    System.out.println(oldName.getAbsolutePath() + " -> " + newName.getAbsolutePath());
    if (!oldName.renameTo(newName)) {
      System.out.println("Failed to rename " + oldName.getName());
    }
  }
}