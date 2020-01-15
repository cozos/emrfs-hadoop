package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.Immutable;
import java.util.EnumMap;
import java.util.Map;

@Immutable
public class ProgressEvent
{
  private final long bytes;
  private final ProgressEventType eventType;
  @Deprecated
  public static final int PREPARING_EVENT_CODE = 1;
  @Deprecated
  public static final int STARTED_EVENT_CODE = 2;
  @Deprecated
  public static final int COMPLETED_EVENT_CODE = 4;
  @Deprecated
  public static final int FAILED_EVENT_CODE = 8;
  @Deprecated
  public static final int CANCELED_EVENT_CODE = 16;
  @Deprecated
  public static final int RESET_EVENT_CODE = 32;
  @Deprecated
  public static final int PART_STARTED_EVENT_CODE = 1024;
  @Deprecated
  public static final int PART_COMPLETED_EVENT_CODE = 2048;
  @Deprecated
  public static final int PART_FAILED_EVENT_CODE = 4096;
  
  @Deprecated
  public ProgressEvent(long bytes)
  {
    this(ProgressEventType.BYTE_TRANSFER_EVENT, bytes);
  }
  
  public ProgressEvent(ProgressEventType eventType)
  {
    this(eventType, 0L);
  }
  
  public ProgressEvent(ProgressEventType eventType, long bytes)
  {
    if (eventType == null) {
      throw new IllegalArgumentException("eventType must not be null.");
    }
    if (bytes < 0L) {
      throw new IllegalArgumentException("bytes reported must be non-negative");
    }
    this.eventType = eventType;
    this.bytes = bytes;
  }
  
  public long getBytes()
  {
    return bytes;
  }
  
  public long getBytesTransferred()
  {
    switch (eventType)
    {
    case REQUEST_BYTE_TRANSFER_EVENT: 
    case RESPONSE_BYTE_TRANSFER_EVENT: 
      return bytes;
    case HTTP_RESPONSE_CONTENT_RESET_EVENT: 
    case HTTP_REQUEST_CONTENT_RESET_EVENT: 
    case RESPONSE_BYTE_DISCARD_EVENT: 
      return 0L - bytes;
    }
    return 0L;
  }
  
  @Deprecated
  public int getEventCode()
  {
    Integer legacyCode = (Integer)legacyEventCodes.get(eventType);
    
    return legacyCode == null ? -1 : legacyCode.intValue();
  }
  
  public ProgressEventType getEventType()
  {
    return eventType;
  }
  
  private static final Map<ProgressEventType, Integer> legacyEventCodes = new EnumMap(ProgressEventType.class);
  
  static
  {
    legacyEventCodes.put(ProgressEventType.BYTE_TRANSFER_EVENT, Integer.valueOf(0));
    legacyEventCodes.put(ProgressEventType.TRANSFER_PREPARING_EVENT, Integer.valueOf(1));
    legacyEventCodes.put(ProgressEventType.TRANSFER_STARTED_EVENT, Integer.valueOf(2));
    legacyEventCodes.put(ProgressEventType.TRANSFER_COMPLETED_EVENT, Integer.valueOf(4));
    legacyEventCodes.put(ProgressEventType.TRANSFER_FAILED_EVENT, Integer.valueOf(8));
    legacyEventCodes.put(ProgressEventType.TRANSFER_CANCELED_EVENT, Integer.valueOf(16));
    legacyEventCodes.put(ProgressEventType.HTTP_REQUEST_CONTENT_RESET_EVENT, Integer.valueOf(32));
    legacyEventCodes.put(ProgressEventType.HTTP_RESPONSE_CONTENT_RESET_EVENT, Integer.valueOf(32));
    legacyEventCodes.put(ProgressEventType.TRANSFER_PART_STARTED_EVENT, Integer.valueOf(1024));
    legacyEventCodes.put(ProgressEventType.TRANSFER_PART_COMPLETED_EVENT, Integer.valueOf(2048));
    legacyEventCodes.put(ProgressEventType.TRANSFER_PART_FAILED_EVENT, Integer.valueOf(4096));
  }
  
  public String toString()
  {
    return eventType + ", bytes: " + bytes;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event.ProgressEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */