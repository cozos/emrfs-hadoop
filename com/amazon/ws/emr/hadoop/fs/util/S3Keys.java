package com.amazon.ws.emr.hadoop.fs.util;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Joiner;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Splitter;
import java.util.List;
import java.util.Optional;
import lombok.NonNull;

public final class S3Keys
{
  private S3Keys()
  {
    throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
  }
  
  public static Optional<String> getParent(@NonNull String key)
  {
    if (key == null) {
      throw new NullPointerException("key");
    }
    List<String> splits = Splitter.on("/").omitEmptyStrings().splitToList(key);
    if (splits.isEmpty()) {
      return Optional.empty();
    }
    List<String> parentSplits = splits.subList(0, splits.size() - 1);
    return Optional.of(Joiner.on("/").join(parentSplits));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.util.S3Keys
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */