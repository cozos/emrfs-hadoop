package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.io;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.TreeTraverser;
import java.io.File;
import java.util.Arrays;
import java.util.Collections;

final class Files$2
  extends TreeTraverser<File>
{
  public Iterable<File> children(File file)
  {
    if (file.isDirectory())
    {
      File[] files = file.listFiles();
      if (files != null) {
        return Collections.unmodifiableList(Arrays.asList(files));
      }
    }
    return Collections.emptyList();
  }
  
  public String toString()
  {
    return "Files.fileTreeTraverser()";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.io.Files.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */