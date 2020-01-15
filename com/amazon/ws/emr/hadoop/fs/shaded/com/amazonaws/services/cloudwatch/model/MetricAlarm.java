package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class MetricAlarm
  implements Serializable, Cloneable
{
  private String alarmName;
  private String alarmArn;
  private String alarmDescription;
  private Date alarmConfigurationUpdatedTimestamp;
  private Boolean actionsEnabled;
  private SdkInternalList<String> oKActions;
  private SdkInternalList<String> alarmActions;
  private SdkInternalList<String> insufficientDataActions;
  private String stateValue;
  private String stateReason;
  private String stateReasonData;
  private Date stateUpdatedTimestamp;
  private String metricName;
  private String namespace;
  private String statistic;
  private String extendedStatistic;
  private SdkInternalList<Dimension> dimensions;
  private Integer period;
  private String unit;
  private Integer evaluationPeriods;
  private Integer datapointsToAlarm;
  private Double threshold;
  private String comparisonOperator;
  private String treatMissingData;
  private String evaluateLowSampleCountPercentile;
  private SdkInternalList<MetricDataQuery> metrics;
  private String thresholdMetricId;
  
  public void setAlarmName(String alarmName)
  {
    this.alarmName = alarmName;
  }
  
  public String getAlarmName()
  {
    return alarmName;
  }
  
  public MetricAlarm withAlarmName(String alarmName)
  {
    setAlarmName(alarmName);
    return this;
  }
  
  public void setAlarmArn(String alarmArn)
  {
    this.alarmArn = alarmArn;
  }
  
  public String getAlarmArn()
  {
    return alarmArn;
  }
  
  public MetricAlarm withAlarmArn(String alarmArn)
  {
    setAlarmArn(alarmArn);
    return this;
  }
  
  public void setAlarmDescription(String alarmDescription)
  {
    this.alarmDescription = alarmDescription;
  }
  
  public String getAlarmDescription()
  {
    return alarmDescription;
  }
  
  public MetricAlarm withAlarmDescription(String alarmDescription)
  {
    setAlarmDescription(alarmDescription);
    return this;
  }
  
  public void setAlarmConfigurationUpdatedTimestamp(Date alarmConfigurationUpdatedTimestamp)
  {
    this.alarmConfigurationUpdatedTimestamp = alarmConfigurationUpdatedTimestamp;
  }
  
  public Date getAlarmConfigurationUpdatedTimestamp()
  {
    return alarmConfigurationUpdatedTimestamp;
  }
  
  public MetricAlarm withAlarmConfigurationUpdatedTimestamp(Date alarmConfigurationUpdatedTimestamp)
  {
    setAlarmConfigurationUpdatedTimestamp(alarmConfigurationUpdatedTimestamp);
    return this;
  }
  
  public void setActionsEnabled(Boolean actionsEnabled)
  {
    this.actionsEnabled = actionsEnabled;
  }
  
  public Boolean getActionsEnabled()
  {
    return actionsEnabled;
  }
  
  public MetricAlarm withActionsEnabled(Boolean actionsEnabled)
  {
    setActionsEnabled(actionsEnabled);
    return this;
  }
  
  public Boolean isActionsEnabled()
  {
    return actionsEnabled;
  }
  
  public List<String> getOKActions()
  {
    if (oKActions == null) {
      oKActions = new SdkInternalList();
    }
    return oKActions;
  }
  
  public void setOKActions(Collection<String> oKActions)
  {
    if (oKActions == null)
    {
      this.oKActions = null;
      return;
    }
    this.oKActions = new SdkInternalList(oKActions);
  }
  
  public MetricAlarm withOKActions(String... oKActions)
  {
    if (this.oKActions == null) {
      setOKActions(new SdkInternalList(oKActions.length));
    }
    for (String ele : oKActions) {
      this.oKActions.add(ele);
    }
    return this;
  }
  
  public MetricAlarm withOKActions(Collection<String> oKActions)
  {
    setOKActions(oKActions);
    return this;
  }
  
  public List<String> getAlarmActions()
  {
    if (alarmActions == null) {
      alarmActions = new SdkInternalList();
    }
    return alarmActions;
  }
  
  public void setAlarmActions(Collection<String> alarmActions)
  {
    if (alarmActions == null)
    {
      this.alarmActions = null;
      return;
    }
    this.alarmActions = new SdkInternalList(alarmActions);
  }
  
  public MetricAlarm withAlarmActions(String... alarmActions)
  {
    if (this.alarmActions == null) {
      setAlarmActions(new SdkInternalList(alarmActions.length));
    }
    for (String ele : alarmActions) {
      this.alarmActions.add(ele);
    }
    return this;
  }
  
  public MetricAlarm withAlarmActions(Collection<String> alarmActions)
  {
    setAlarmActions(alarmActions);
    return this;
  }
  
  public List<String> getInsufficientDataActions()
  {
    if (insufficientDataActions == null) {
      insufficientDataActions = new SdkInternalList();
    }
    return insufficientDataActions;
  }
  
  public void setInsufficientDataActions(Collection<String> insufficientDataActions)
  {
    if (insufficientDataActions == null)
    {
      this.insufficientDataActions = null;
      return;
    }
    this.insufficientDataActions = new SdkInternalList(insufficientDataActions);
  }
  
  public MetricAlarm withInsufficientDataActions(String... insufficientDataActions)
  {
    if (this.insufficientDataActions == null) {
      setInsufficientDataActions(new SdkInternalList(insufficientDataActions.length));
    }
    for (String ele : insufficientDataActions) {
      this.insufficientDataActions.add(ele);
    }
    return this;
  }
  
  public MetricAlarm withInsufficientDataActions(Collection<String> insufficientDataActions)
  {
    setInsufficientDataActions(insufficientDataActions);
    return this;
  }
  
  public void setStateValue(String stateValue)
  {
    this.stateValue = stateValue;
  }
  
  public String getStateValue()
  {
    return stateValue;
  }
  
  public MetricAlarm withStateValue(String stateValue)
  {
    setStateValue(stateValue);
    return this;
  }
  
  public void setStateValue(StateValue stateValue)
  {
    withStateValue(stateValue);
  }
  
  public MetricAlarm withStateValue(StateValue stateValue)
  {
    this.stateValue = stateValue.toString();
    return this;
  }
  
  public void setStateReason(String stateReason)
  {
    this.stateReason = stateReason;
  }
  
  public String getStateReason()
  {
    return stateReason;
  }
  
  public MetricAlarm withStateReason(String stateReason)
  {
    setStateReason(stateReason);
    return this;
  }
  
  public void setStateReasonData(String stateReasonData)
  {
    this.stateReasonData = stateReasonData;
  }
  
  public String getStateReasonData()
  {
    return stateReasonData;
  }
  
  public MetricAlarm withStateReasonData(String stateReasonData)
  {
    setStateReasonData(stateReasonData);
    return this;
  }
  
  public void setStateUpdatedTimestamp(Date stateUpdatedTimestamp)
  {
    this.stateUpdatedTimestamp = stateUpdatedTimestamp;
  }
  
  public Date getStateUpdatedTimestamp()
  {
    return stateUpdatedTimestamp;
  }
  
  public MetricAlarm withStateUpdatedTimestamp(Date stateUpdatedTimestamp)
  {
    setStateUpdatedTimestamp(stateUpdatedTimestamp);
    return this;
  }
  
  public void setMetricName(String metricName)
  {
    this.metricName = metricName;
  }
  
  public String getMetricName()
  {
    return metricName;
  }
  
  public MetricAlarm withMetricName(String metricName)
  {
    setMetricName(metricName);
    return this;
  }
  
  public void setNamespace(String namespace)
  {
    this.namespace = namespace;
  }
  
  public String getNamespace()
  {
    return namespace;
  }
  
  public MetricAlarm withNamespace(String namespace)
  {
    setNamespace(namespace);
    return this;
  }
  
  public void setStatistic(String statistic)
  {
    this.statistic = statistic;
  }
  
  public String getStatistic()
  {
    return statistic;
  }
  
  public MetricAlarm withStatistic(String statistic)
  {
    setStatistic(statistic);
    return this;
  }
  
  public void setStatistic(Statistic statistic)
  {
    withStatistic(statistic);
  }
  
  public MetricAlarm withStatistic(Statistic statistic)
  {
    this.statistic = statistic.toString();
    return this;
  }
  
  public void setExtendedStatistic(String extendedStatistic)
  {
    this.extendedStatistic = extendedStatistic;
  }
  
  public String getExtendedStatistic()
  {
    return extendedStatistic;
  }
  
  public MetricAlarm withExtendedStatistic(String extendedStatistic)
  {
    setExtendedStatistic(extendedStatistic);
    return this;
  }
  
  public List<Dimension> getDimensions()
  {
    if (dimensions == null) {
      dimensions = new SdkInternalList();
    }
    return dimensions;
  }
  
  public void setDimensions(Collection<Dimension> dimensions)
  {
    if (dimensions == null)
    {
      this.dimensions = null;
      return;
    }
    this.dimensions = new SdkInternalList(dimensions);
  }
  
  public MetricAlarm withDimensions(Dimension... dimensions)
  {
    if (this.dimensions == null) {
      setDimensions(new SdkInternalList(dimensions.length));
    }
    for (Dimension ele : dimensions) {
      this.dimensions.add(ele);
    }
    return this;
  }
  
  public MetricAlarm withDimensions(Collection<Dimension> dimensions)
  {
    setDimensions(dimensions);
    return this;
  }
  
  public void setPeriod(Integer period)
  {
    this.period = period;
  }
  
  public Integer getPeriod()
  {
    return period;
  }
  
  public MetricAlarm withPeriod(Integer period)
  {
    setPeriod(period);
    return this;
  }
  
  public void setUnit(String unit)
  {
    this.unit = unit;
  }
  
  public String getUnit()
  {
    return unit;
  }
  
  public MetricAlarm withUnit(String unit)
  {
    setUnit(unit);
    return this;
  }
  
  public void setUnit(StandardUnit unit)
  {
    withUnit(unit);
  }
  
  public MetricAlarm withUnit(StandardUnit unit)
  {
    this.unit = unit.toString();
    return this;
  }
  
  public void setEvaluationPeriods(Integer evaluationPeriods)
  {
    this.evaluationPeriods = evaluationPeriods;
  }
  
  public Integer getEvaluationPeriods()
  {
    return evaluationPeriods;
  }
  
  public MetricAlarm withEvaluationPeriods(Integer evaluationPeriods)
  {
    setEvaluationPeriods(evaluationPeriods);
    return this;
  }
  
  public void setDatapointsToAlarm(Integer datapointsToAlarm)
  {
    this.datapointsToAlarm = datapointsToAlarm;
  }
  
  public Integer getDatapointsToAlarm()
  {
    return datapointsToAlarm;
  }
  
  public MetricAlarm withDatapointsToAlarm(Integer datapointsToAlarm)
  {
    setDatapointsToAlarm(datapointsToAlarm);
    return this;
  }
  
  public void setThreshold(Double threshold)
  {
    this.threshold = threshold;
  }
  
  public Double getThreshold()
  {
    return threshold;
  }
  
  public MetricAlarm withThreshold(Double threshold)
  {
    setThreshold(threshold);
    return this;
  }
  
  public void setComparisonOperator(String comparisonOperator)
  {
    this.comparisonOperator = comparisonOperator;
  }
  
  public String getComparisonOperator()
  {
    return comparisonOperator;
  }
  
  public MetricAlarm withComparisonOperator(String comparisonOperator)
  {
    setComparisonOperator(comparisonOperator);
    return this;
  }
  
  public void setComparisonOperator(ComparisonOperator comparisonOperator)
  {
    withComparisonOperator(comparisonOperator);
  }
  
  public MetricAlarm withComparisonOperator(ComparisonOperator comparisonOperator)
  {
    this.comparisonOperator = comparisonOperator.toString();
    return this;
  }
  
  public void setTreatMissingData(String treatMissingData)
  {
    this.treatMissingData = treatMissingData;
  }
  
  public String getTreatMissingData()
  {
    return treatMissingData;
  }
  
  public MetricAlarm withTreatMissingData(String treatMissingData)
  {
    setTreatMissingData(treatMissingData);
    return this;
  }
  
  public void setEvaluateLowSampleCountPercentile(String evaluateLowSampleCountPercentile)
  {
    this.evaluateLowSampleCountPercentile = evaluateLowSampleCountPercentile;
  }
  
  public String getEvaluateLowSampleCountPercentile()
  {
    return evaluateLowSampleCountPercentile;
  }
  
  public MetricAlarm withEvaluateLowSampleCountPercentile(String evaluateLowSampleCountPercentile)
  {
    setEvaluateLowSampleCountPercentile(evaluateLowSampleCountPercentile);
    return this;
  }
  
  public List<MetricDataQuery> getMetrics()
  {
    if (metrics == null) {
      metrics = new SdkInternalList();
    }
    return metrics;
  }
  
  public void setMetrics(Collection<MetricDataQuery> metrics)
  {
    if (metrics == null)
    {
      this.metrics = null;
      return;
    }
    this.metrics = new SdkInternalList(metrics);
  }
  
  public MetricAlarm withMetrics(MetricDataQuery... metrics)
  {
    if (this.metrics == null) {
      setMetrics(new SdkInternalList(metrics.length));
    }
    for (MetricDataQuery ele : metrics) {
      this.metrics.add(ele);
    }
    return this;
  }
  
  public MetricAlarm withMetrics(Collection<MetricDataQuery> metrics)
  {
    setMetrics(metrics);
    return this;
  }
  
  public void setThresholdMetricId(String thresholdMetricId)
  {
    this.thresholdMetricId = thresholdMetricId;
  }
  
  public String getThresholdMetricId()
  {
    return thresholdMetricId;
  }
  
  public MetricAlarm withThresholdMetricId(String thresholdMetricId)
  {
    setThresholdMetricId(thresholdMetricId);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getAlarmName() != null) {
      sb.append("AlarmName: ").append(getAlarmName()).append(",");
    }
    if (getAlarmArn() != null) {
      sb.append("AlarmArn: ").append(getAlarmArn()).append(",");
    }
    if (getAlarmDescription() != null) {
      sb.append("AlarmDescription: ").append(getAlarmDescription()).append(",");
    }
    if (getAlarmConfigurationUpdatedTimestamp() != null) {
      sb.append("AlarmConfigurationUpdatedTimestamp: ").append(getAlarmConfigurationUpdatedTimestamp()).append(",");
    }
    if (getActionsEnabled() != null) {
      sb.append("ActionsEnabled: ").append(getActionsEnabled()).append(",");
    }
    if (getOKActions() != null) {
      sb.append("OKActions: ").append(getOKActions()).append(",");
    }
    if (getAlarmActions() != null) {
      sb.append("AlarmActions: ").append(getAlarmActions()).append(",");
    }
    if (getInsufficientDataActions() != null) {
      sb.append("InsufficientDataActions: ").append(getInsufficientDataActions()).append(",");
    }
    if (getStateValue() != null) {
      sb.append("StateValue: ").append(getStateValue()).append(",");
    }
    if (getStateReason() != null) {
      sb.append("StateReason: ").append(getStateReason()).append(",");
    }
    if (getStateReasonData() != null) {
      sb.append("StateReasonData: ").append(getStateReasonData()).append(",");
    }
    if (getStateUpdatedTimestamp() != null) {
      sb.append("StateUpdatedTimestamp: ").append(getStateUpdatedTimestamp()).append(",");
    }
    if (getMetricName() != null) {
      sb.append("MetricName: ").append(getMetricName()).append(",");
    }
    if (getNamespace() != null) {
      sb.append("Namespace: ").append(getNamespace()).append(",");
    }
    if (getStatistic() != null) {
      sb.append("Statistic: ").append(getStatistic()).append(",");
    }
    if (getExtendedStatistic() != null) {
      sb.append("ExtendedStatistic: ").append(getExtendedStatistic()).append(",");
    }
    if (getDimensions() != null) {
      sb.append("Dimensions: ").append(getDimensions()).append(",");
    }
    if (getPeriod() != null) {
      sb.append("Period: ").append(getPeriod()).append(",");
    }
    if (getUnit() != null) {
      sb.append("Unit: ").append(getUnit()).append(",");
    }
    if (getEvaluationPeriods() != null) {
      sb.append("EvaluationPeriods: ").append(getEvaluationPeriods()).append(",");
    }
    if (getDatapointsToAlarm() != null) {
      sb.append("DatapointsToAlarm: ").append(getDatapointsToAlarm()).append(",");
    }
    if (getThreshold() != null) {
      sb.append("Threshold: ").append(getThreshold()).append(",");
    }
    if (getComparisonOperator() != null) {
      sb.append("ComparisonOperator: ").append(getComparisonOperator()).append(",");
    }
    if (getTreatMissingData() != null) {
      sb.append("TreatMissingData: ").append(getTreatMissingData()).append(",");
    }
    if (getEvaluateLowSampleCountPercentile() != null) {
      sb.append("EvaluateLowSampleCountPercentile: ").append(getEvaluateLowSampleCountPercentile()).append(",");
    }
    if (getMetrics() != null) {
      sb.append("Metrics: ").append(getMetrics()).append(",");
    }
    if (getThresholdMetricId() != null) {
      sb.append("ThresholdMetricId: ").append(getThresholdMetricId());
    }
    sb.append("}");
    return sb.toString();
  }
  
  public boolean equals(Object obj)
  {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (!(obj instanceof MetricAlarm)) {
      return false;
    }
    MetricAlarm other = (MetricAlarm)obj;
    if (((other.getAlarmName() == null ? 1 : 0) ^ (getAlarmName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getAlarmName() != null) && (!other.getAlarmName().equals(getAlarmName()))) {
      return false;
    }
    if (((other.getAlarmArn() == null ? 1 : 0) ^ (getAlarmArn() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getAlarmArn() != null) && (!other.getAlarmArn().equals(getAlarmArn()))) {
      return false;
    }
    if (((other.getAlarmDescription() == null ? 1 : 0) ^ (getAlarmDescription() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getAlarmDescription() != null) && (!other.getAlarmDescription().equals(getAlarmDescription()))) {
      return false;
    }
    if (((other.getAlarmConfigurationUpdatedTimestamp() == null ? 1 : 0) ^ (getAlarmConfigurationUpdatedTimestamp() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getAlarmConfigurationUpdatedTimestamp() != null) && 
      (!other.getAlarmConfigurationUpdatedTimestamp().equals(getAlarmConfigurationUpdatedTimestamp()))) {
      return false;
    }
    if (((other.getActionsEnabled() == null ? 1 : 0) ^ (getActionsEnabled() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getActionsEnabled() != null) && (!other.getActionsEnabled().equals(getActionsEnabled()))) {
      return false;
    }
    if (((other.getOKActions() == null ? 1 : 0) ^ (getOKActions() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getOKActions() != null) && (!other.getOKActions().equals(getOKActions()))) {
      return false;
    }
    if (((other.getAlarmActions() == null ? 1 : 0) ^ (getAlarmActions() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getAlarmActions() != null) && (!other.getAlarmActions().equals(getAlarmActions()))) {
      return false;
    }
    if (((other.getInsufficientDataActions() == null ? 1 : 0) ^ (getInsufficientDataActions() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getInsufficientDataActions() != null) && (!other.getInsufficientDataActions().equals(getInsufficientDataActions()))) {
      return false;
    }
    if (((other.getStateValue() == null ? 1 : 0) ^ (getStateValue() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getStateValue() != null) && (!other.getStateValue().equals(getStateValue()))) {
      return false;
    }
    if (((other.getStateReason() == null ? 1 : 0) ^ (getStateReason() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getStateReason() != null) && (!other.getStateReason().equals(getStateReason()))) {
      return false;
    }
    if (((other.getStateReasonData() == null ? 1 : 0) ^ (getStateReasonData() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getStateReasonData() != null) && (!other.getStateReasonData().equals(getStateReasonData()))) {
      return false;
    }
    if (((other.getStateUpdatedTimestamp() == null ? 1 : 0) ^ (getStateUpdatedTimestamp() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getStateUpdatedTimestamp() != null) && (!other.getStateUpdatedTimestamp().equals(getStateUpdatedTimestamp()))) {
      return false;
    }
    if (((other.getMetricName() == null ? 1 : 0) ^ (getMetricName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getMetricName() != null) && (!other.getMetricName().equals(getMetricName()))) {
      return false;
    }
    if (((other.getNamespace() == null ? 1 : 0) ^ (getNamespace() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getNamespace() != null) && (!other.getNamespace().equals(getNamespace()))) {
      return false;
    }
    if (((other.getStatistic() == null ? 1 : 0) ^ (getStatistic() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getStatistic() != null) && (!other.getStatistic().equals(getStatistic()))) {
      return false;
    }
    if (((other.getExtendedStatistic() == null ? 1 : 0) ^ (getExtendedStatistic() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getExtendedStatistic() != null) && (!other.getExtendedStatistic().equals(getExtendedStatistic()))) {
      return false;
    }
    if (((other.getDimensions() == null ? 1 : 0) ^ (getDimensions() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getDimensions() != null) && (!other.getDimensions().equals(getDimensions()))) {
      return false;
    }
    if (((other.getPeriod() == null ? 1 : 0) ^ (getPeriod() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getPeriod() != null) && (!other.getPeriod().equals(getPeriod()))) {
      return false;
    }
    if (((other.getUnit() == null ? 1 : 0) ^ (getUnit() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getUnit() != null) && (!other.getUnit().equals(getUnit()))) {
      return false;
    }
    if (((other.getEvaluationPeriods() == null ? 1 : 0) ^ (getEvaluationPeriods() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getEvaluationPeriods() != null) && (!other.getEvaluationPeriods().equals(getEvaluationPeriods()))) {
      return false;
    }
    if (((other.getDatapointsToAlarm() == null ? 1 : 0) ^ (getDatapointsToAlarm() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getDatapointsToAlarm() != null) && (!other.getDatapointsToAlarm().equals(getDatapointsToAlarm()))) {
      return false;
    }
    if (((other.getThreshold() == null ? 1 : 0) ^ (getThreshold() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getThreshold() != null) && (!other.getThreshold().equals(getThreshold()))) {
      return false;
    }
    if (((other.getComparisonOperator() == null ? 1 : 0) ^ (getComparisonOperator() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getComparisonOperator() != null) && (!other.getComparisonOperator().equals(getComparisonOperator()))) {
      return false;
    }
    if (((other.getTreatMissingData() == null ? 1 : 0) ^ (getTreatMissingData() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getTreatMissingData() != null) && (!other.getTreatMissingData().equals(getTreatMissingData()))) {
      return false;
    }
    if (((other.getEvaluateLowSampleCountPercentile() == null ? 1 : 0) ^ (getEvaluateLowSampleCountPercentile() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getEvaluateLowSampleCountPercentile() != null) && 
      (!other.getEvaluateLowSampleCountPercentile().equals(getEvaluateLowSampleCountPercentile()))) {
      return false;
    }
    if (((other.getMetrics() == null ? 1 : 0) ^ (getMetrics() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getMetrics() != null) && (!other.getMetrics().equals(getMetrics()))) {
      return false;
    }
    if (((other.getThresholdMetricId() == null ? 1 : 0) ^ (getThresholdMetricId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getThresholdMetricId() != null) && (!other.getThresholdMetricId().equals(getThresholdMetricId()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getAlarmName() == null ? 0 : getAlarmName().hashCode());
    hashCode = 31 * hashCode + (getAlarmArn() == null ? 0 : getAlarmArn().hashCode());
    hashCode = 31 * hashCode + (getAlarmDescription() == null ? 0 : getAlarmDescription().hashCode());
    hashCode = 31 * hashCode + (getAlarmConfigurationUpdatedTimestamp() == null ? 0 : getAlarmConfigurationUpdatedTimestamp().hashCode());
    hashCode = 31 * hashCode + (getActionsEnabled() == null ? 0 : getActionsEnabled().hashCode());
    hashCode = 31 * hashCode + (getOKActions() == null ? 0 : getOKActions().hashCode());
    hashCode = 31 * hashCode + (getAlarmActions() == null ? 0 : getAlarmActions().hashCode());
    hashCode = 31 * hashCode + (getInsufficientDataActions() == null ? 0 : getInsufficientDataActions().hashCode());
    hashCode = 31 * hashCode + (getStateValue() == null ? 0 : getStateValue().hashCode());
    hashCode = 31 * hashCode + (getStateReason() == null ? 0 : getStateReason().hashCode());
    hashCode = 31 * hashCode + (getStateReasonData() == null ? 0 : getStateReasonData().hashCode());
    hashCode = 31 * hashCode + (getStateUpdatedTimestamp() == null ? 0 : getStateUpdatedTimestamp().hashCode());
    hashCode = 31 * hashCode + (getMetricName() == null ? 0 : getMetricName().hashCode());
    hashCode = 31 * hashCode + (getNamespace() == null ? 0 : getNamespace().hashCode());
    hashCode = 31 * hashCode + (getStatistic() == null ? 0 : getStatistic().hashCode());
    hashCode = 31 * hashCode + (getExtendedStatistic() == null ? 0 : getExtendedStatistic().hashCode());
    hashCode = 31 * hashCode + (getDimensions() == null ? 0 : getDimensions().hashCode());
    hashCode = 31 * hashCode + (getPeriod() == null ? 0 : getPeriod().hashCode());
    hashCode = 31 * hashCode + (getUnit() == null ? 0 : getUnit().hashCode());
    hashCode = 31 * hashCode + (getEvaluationPeriods() == null ? 0 : getEvaluationPeriods().hashCode());
    hashCode = 31 * hashCode + (getDatapointsToAlarm() == null ? 0 : getDatapointsToAlarm().hashCode());
    hashCode = 31 * hashCode + (getThreshold() == null ? 0 : getThreshold().hashCode());
    hashCode = 31 * hashCode + (getComparisonOperator() == null ? 0 : getComparisonOperator().hashCode());
    hashCode = 31 * hashCode + (getTreatMissingData() == null ? 0 : getTreatMissingData().hashCode());
    hashCode = 31 * hashCode + (getEvaluateLowSampleCountPercentile() == null ? 0 : getEvaluateLowSampleCountPercentile().hashCode());
    hashCode = 31 * hashCode + (getMetrics() == null ? 0 : getMetrics().hashCode());
    hashCode = 31 * hashCode + (getThresholdMetricId() == null ? 0 : getThresholdMetricId().hashCode());
    return hashCode;
  }
  
  public MetricAlarm clone()
  {
    try
    {
      return (MetricAlarm)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.MetricAlarm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */