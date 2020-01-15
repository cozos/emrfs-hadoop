package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.policy.actions;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.policy.Action;

public enum CloudWatchActions
  implements Action
{
  AllCloudWatchActions("cloudwatch:*"),  DeleteAlarms("cloudwatch:DeleteAlarms"),  DeleteAnomalyDetector("cloudwatch:DeleteAnomalyDetector"),  DeleteDashboards("cloudwatch:DeleteDashboards"),  DescribeAlarmHistory("cloudwatch:DescribeAlarmHistory"),  DescribeAlarms("cloudwatch:DescribeAlarms"),  DescribeAlarmsForMetric("cloudwatch:DescribeAlarmsForMetric"),  DescribeAnomalyDetectors("cloudwatch:DescribeAnomalyDetectors"),  DisableAlarmActions("cloudwatch:DisableAlarmActions"),  EnableAlarmActions("cloudwatch:EnableAlarmActions"),  GetDashboard("cloudwatch:GetDashboard"),  GetMetricData("cloudwatch:GetMetricData"),  GetMetricStatistics("cloudwatch:GetMetricStatistics"),  GetMetricWidgetImage("cloudwatch:GetMetricWidgetImage"),  ListDashboards("cloudwatch:ListDashboards"),  ListMetrics("cloudwatch:ListMetrics"),  ListTagsForResource("cloudwatch:ListTagsForResource"),  PutAnomalyDetector("cloudwatch:PutAnomalyDetector"),  PutDashboard("cloudwatch:PutDashboard"),  PutMetricAlarm("cloudwatch:PutMetricAlarm"),  PutMetricData("cloudwatch:PutMetricData"),  SetAlarmState("cloudwatch:SetAlarmState"),  TagResource("cloudwatch:TagResource"),  UntagResource("cloudwatch:UntagResource");
  
  private final String action;
  
  private CloudWatchActions(String action)
  {
    this.action = action;
  }
  
  public String getActionName()
  {
    return action;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.policy.actions.CloudWatchActions
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */