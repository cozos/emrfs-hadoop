package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.io;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Lists;
import java.util.List;

final class Resources$1
  implements LineProcessor<List<String>>
{
  final List<String> result = Lists.newArrayList();
  
  public boolean processLine(String line)
  {
    result.add(line);
    return true;
  }
  
  public List<String> getResult()
  {
    return result;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.io.Resources.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */