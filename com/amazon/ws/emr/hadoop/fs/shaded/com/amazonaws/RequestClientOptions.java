package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.NotThreadSafe;
import java.util.EnumMap;

@NotThreadSafe
public final class RequestClientOptions
{
  public static final int DEFAULT_STREAM_BUFFER_SIZE = 131073;
  
  public static enum Marker
  {
    USER_AGENT;
    
    private Marker() {}
  }
  
  private final EnumMap<Marker, String> markers = new EnumMap(Marker.class);
  private int readLimit = 131073;
  private boolean skipAppendUriPath = false;
  
  public String getClientMarker(Marker marker)
  {
    return (String)markers.get(marker);
  }
  
  public void putClientMarker(Marker marker, String value)
  {
    markers.put(marker, value);
  }
  
  public void appendUserAgent(String userAgent)
  {
    String marker = (String)markers.get(Marker.USER_AGENT);
    if (marker == null) {
      marker = "";
    }
    marker = createUserAgentMarkerString(marker, userAgent);
    putClientMarker(Marker.USER_AGENT, marker);
  }
  
  private String createUserAgentMarkerString(String marker, String userAgent)
  {
    return marker + " " + userAgent;
  }
  
  public final int getReadLimit()
  {
    return readLimit;
  }
  
  public final void setReadLimit(int readLimit)
  {
    this.readLimit = readLimit;
  }
  
  public boolean isSkipAppendUriPath()
  {
    return skipAppendUriPath;
  }
  
  public void setSkipAppendUriPath(boolean skipAppendUriPath)
  {
    this.skipAppendUriPath = skipAppendUriPath;
  }
  
  void copyTo(RequestClientOptions target)
  {
    target.setReadLimit(getReadLimit());
    target.setSkipAppendUriPath(isSkipAppendUriPath());
    for (Marker marker : Marker.values()) {
      target.putClientMarker(marker, getClientMarker(marker));
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.RequestClientOptions
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */