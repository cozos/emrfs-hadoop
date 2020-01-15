package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.policy.actions;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.policy.Action;

public enum SQSActions
  implements Action
{
  AllSQSActions("sqs:*"),  AddPermission("sqs:AddPermission"),  ChangeMessageVisibility("sqs:ChangeMessageVisibility"),  ChangeMessageVisibilityBatch("sqs:ChangeMessageVisibilityBatch"),  CreateQueue("sqs:CreateQueue"),  DeleteMessage("sqs:DeleteMessage"),  DeleteMessageBatch("sqs:DeleteMessageBatch"),  DeleteQueue("sqs:DeleteQueue"),  GetQueueAttributes("sqs:GetQueueAttributes"),  GetQueueUrl("sqs:GetQueueUrl"),  ListDeadLetterSourceQueues("sqs:ListDeadLetterSourceQueues"),  ListQueueTags("sqs:ListQueueTags"),  ListQueues("sqs:ListQueues"),  PurgeQueue("sqs:PurgeQueue"),  ReceiveMessage("sqs:ReceiveMessage"),  RemovePermission("sqs:RemovePermission"),  SendMessage("sqs:SendMessage"),  SendMessageBatch("sqs:SendMessageBatch"),  SetQueueAttributes("sqs:SetQueueAttributes"),  TagQueue("sqs:TagQueue"),  UntagQueue("sqs:UntagQueue");
  
  private final String action;
  
  private SQSActions(String action)
  {
    this.action = action;
  }
  
  public String getActionName()
  {
    return action;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.policy.actions.SQSActions
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */