package com.amazon.ws.emr.hadoop.fs.util;

import java.net.URI;
import java.net.URISyntaxException;
import lombok.NonNull;

public final class Uris
{
  private Uris()
  {
    throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
  }
  
  public static URI withOriginOnly(@NonNull URI uri)
  {
    if (uri == null) {
      throw new NullPointerException("uri");
    }
    String path = (uri.getScheme() != null) && (uri.getAuthority() == null) ? "/" : null;
    try
    {
      return new URI(uri.getScheme(), uri.getAuthority(), path, null, null);
    }
    catch (URISyntaxException e)
    {
      throw new RuntimeException("URI composed is expected to always be syntactically valid", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.util.Uris
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */