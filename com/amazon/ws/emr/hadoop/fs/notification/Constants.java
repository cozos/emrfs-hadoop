package com.amazon.ws.emr.hadoop.fs.notification;

public class Constants
{
  private static final String EMRFS = "EMRFS";
  public static final String CW_ENABLE_CONF = "fs.s3.consistent.notification.CloudWatch";
  public static final String CW_NAMESPACE = "EMRFS";
  public static final String CW_JOBFLOWID_DIMENSION_NAME = "JobFlowId";
  public static final String CW_API_DIMENSION_NAME = "API";
  public static final String CW_INCONSISTENCY_METRIC_NAME = "Inconsistency";
  public static final String SQS_ENABLE_CONF = "fs.s3.consistent.notification.SQS";
  public static final String SQS_QUEUE_NAME_CONF = "fs.s3.consistent.notification.SQS.queueName";
  public static final String SQS_DEFAULT_QUEUE_NAME_TEMPLATE = "EMRFS-Inconsistency-%s";
  public static final String SQS_BATCH_SIZE_CONF = "fs.s3.consistent.notification.SQS.batchSize";
  public static final int SQS_BATCH_SIZE_VALUE = 10;
  public static final String SQS_PULL_WAIT_TIME_SECONDS_CONF = "fs.s3.consistent.notification.SQS.pullWaitTimeSeconds";
  public static final int SQS_PULL_WAIT_TIME_SECONDS_VALUE = 3;
  public static final String SQS_PATH_REPORT_LIMIT_CONF = "fs.s3.consistent.notification.SQS.pathReportLimit";
  public static final int SQS_PATH_REPORT_LIMIT_VALUE = 10;
  public static final String SQS_CUSTOM_MSG_CONF = "fs.s3.consistent.notification.SQS.customMsg";
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.notification.Constants
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */