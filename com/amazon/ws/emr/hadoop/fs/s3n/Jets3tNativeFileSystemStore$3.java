package com.amazon.ws.emr.hadoop.fs.s3n;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.MultiObjectDeleteException.DeleteError;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Function;

final class Jets3tNativeFileSystemStore$3
  implements Function<MultiObjectDeleteException.DeleteError, String>
{
  public String apply(MultiObjectDeleteException.DeleteError error)
  {
    return error.getKey();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3n.Jets3tNativeFileSystemStore.3
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */