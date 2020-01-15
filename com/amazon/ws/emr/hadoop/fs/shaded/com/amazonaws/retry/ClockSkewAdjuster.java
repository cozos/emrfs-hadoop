package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.retry;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonServiceException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkBaseException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.NotThreadSafe;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkTestInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.ThreadSafe;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.DateUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.ValidationUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.Header;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpResponse;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@ThreadSafe
@SdkInternalApi
public final class ClockSkewAdjuster
{
  private static final Log log = LogFactory.getLog(ClockSkewAdjuster.class);
  private static final Set<Integer> AUTHENTICATION_ERROR_STATUS_CODES;
  private static final int CLOCK_SKEW_ADJUST_THRESHOLD_IN_SECONDS = 240;
  
  static
  {
    Set<Integer> statusCodes = new HashSet();
    statusCodes.add(Integer.valueOf(401));
    statusCodes.add(Integer.valueOf(403));
    AUTHENTICATION_ERROR_STATUS_CODES = Collections.unmodifiableSet(statusCodes);
  }
  
  public ClockSkewAdjustment getAdjustment(AdjustmentRequest adjustmentRequest)
  {
    ValidationUtils.assertNotNull(adjustmentRequest, "adjustmentRequest");
    ValidationUtils.assertNotNull(exception, "adjustmentRequest.exception");
    ValidationUtils.assertNotNull(clientRequest, "adjustmentRequest.clientRequest");
    ValidationUtils.assertNotNull(serviceResponse, "adjustmentRequest.serviceResponse");
    
    int timeSkewInSeconds = 0;
    boolean isAdjustmentRecommended = false;
    try
    {
      if (isAdjustmentRecommended(adjustmentRequest))
      {
        Date serverDate = getServerDate(adjustmentRequest);
        if (serverDate != null)
        {
          timeSkewInSeconds = timeSkewInSeconds(getCurrentDate(adjustmentRequest), serverDate);
          isAdjustmentRecommended = true;
        }
      }
    }
    catch (RuntimeException e)
    {
      log.warn("Unable to correct for clock skew.", e);
    }
    return new ClockSkewAdjustment(isAdjustmentRecommended, timeSkewInSeconds, null);
  }
  
  private boolean isAdjustmentRecommended(AdjustmentRequest adjustmentRequest)
  {
    if (!(exception instanceof AmazonServiceException)) {
      return false;
    }
    AmazonServiceException exception = (AmazonServiceException)exception;
    
    return (isDefinitelyClockSkewError(exception)) || (
      (mayBeClockSkewError(exception)) && (clientRequestWasSkewed(adjustmentRequest)));
  }
  
  private boolean isDefinitelyClockSkewError(AmazonServiceException exception)
  {
    return RetryUtils.isClockSkewError(exception);
  }
  
  private boolean mayBeClockSkewError(AmazonServiceException exception)
  {
    return AUTHENTICATION_ERROR_STATUS_CODES.contains(Integer.valueOf(exception.getStatusCode()));
  }
  
  private boolean clientRequestWasSkewed(AdjustmentRequest adjustmentRequest)
  {
    Date serverDate = getServerDate(adjustmentRequest);
    if (serverDate == null) {
      return false;
    }
    int requestClockSkew = timeSkewInSeconds(getClientDate(adjustmentRequest), serverDate);
    return Math.abs(requestClockSkew) > 240;
  }
  
  private int timeSkewInSeconds(Date clientTime, Date serverTime)
  {
    ValidationUtils.assertNotNull(clientTime, "clientTime");
    ValidationUtils.assertNotNull(serverTime, "serverTime");
    
    long value = (clientTime.getTime() - serverTime.getTime()) / 1000L;
    if ((int)value != value) {
      throw new IllegalStateException("Time is too skewed to adjust: (clientTime: " + clientTime.getTime() + ", serverTime: " + serverTime.getTime() + ")");
    }
    return (int)value;
  }
  
  private Date getCurrentDate(AdjustmentRequest adjustmentRequest)
  {
    return new Date(currentTime);
  }
  
  private Date getClientDate(AdjustmentRequest adjustmentRequest)
  {
    return new Date(currentTime - clientRequest.getTimeOffset() * 1000);
  }
  
  private Date getServerDate(AdjustmentRequest adjustmentRequest)
  {
    String serverDateStr = null;
    try
    {
      Header[] responseDateHeader = serviceResponse.getHeaders("Date");
      if (responseDateHeader.length > 0)
      {
        serverDateStr = responseDateHeader[0].getValue();
        log.debug("Reported server date (from 'Date' header): " + serverDateStr);
        return DateUtils.parseRFC822Date(serverDateStr);
      }
      String exceptionMessage = exception.getMessage();
      serverDateStr = getServerDateFromException(exceptionMessage);
      if (serverDateStr != null)
      {
        log.debug("Reported server date (from exception message): " + serverDateStr);
        return DateUtils.parseCompressedISO8601Date(serverDateStr);
      }
      log.debug("Server did not return a date, so clock skew adjustments will not be applied.");
      return null;
    }
    catch (RuntimeException e)
    {
      log.warn("Unable to parse clock skew offset from response: " + serverDateStr, e);
    }
    return null;
  }
  
  private String getServerDateFromException(String body)
  {
    int startPos = body.indexOf("(");
    int endPos = body.indexOf(" + ");
    if (endPos == -1) {
      endPos = body.indexOf(" - ");
    }
    return endPos == -1 ? null : body.substring(startPos + 1, endPos);
  }
  
  @NotThreadSafe
  public static final class AdjustmentRequest
  {
    private Request<?> clientRequest;
    private HttpResponse serviceResponse;
    private SdkBaseException exception;
    private long currentTime = System.currentTimeMillis();
    
    public AdjustmentRequest clientRequest(Request<?> clientRequest)
    {
      this.clientRequest = clientRequest;
      return this;
    }
    
    public AdjustmentRequest serviceResponse(HttpResponse serviceResponse)
    {
      this.serviceResponse = serviceResponse;
      return this;
    }
    
    public AdjustmentRequest exception(SdkBaseException exception)
    {
      this.exception = exception;
      return this;
    }
    
    @SdkTestInternalApi
    public AdjustmentRequest currentTime(long currentTime)
    {
      this.currentTime = currentTime;
      return this;
    }
  }
  
  @ThreadSafe
  public static final class ClockSkewAdjustment
  {
    private final boolean shouldAdjustForSkew;
    private final int adjustmentInSeconds;
    
    private ClockSkewAdjustment(boolean shouldAdjust, int adjustmentInSeconds)
    {
      shouldAdjustForSkew = shouldAdjust;
      this.adjustmentInSeconds = adjustmentInSeconds;
    }
    
    public boolean shouldAdjustForSkew()
    {
      return shouldAdjustForSkew;
    }
    
    public int inSeconds()
    {
      if (!shouldAdjustForSkew) {
        throw new IllegalStateException("An adjustment is not recommended.");
      }
      return adjustmentInSeconds;
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.retry.ClockSkewAdjuster
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */