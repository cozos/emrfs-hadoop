package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.io.input;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.io.ByteOrderMark;
import java.util.Comparator;

final class BOMInputStream$1
  implements Comparator<ByteOrderMark>
{
  public int compare(ByteOrderMark bom1, ByteOrderMark bom2)
  {
    int len1 = bom1.length();
    int len2 = bom2.length();
    if (len1 > len2) {
      return -1;
    }
    if (len2 > len1) {
      return 1;
    }
    return 0;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.io.input.BOMInputStream.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */