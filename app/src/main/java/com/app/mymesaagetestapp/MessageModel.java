package com.app.mymesaagetestapp;

import java.util.List;

public class MessageModel {
   public List<MessageList> string;


   public class MessageList{

      public int EntryID;
      public String   DateAndTime;
      public String EntryDate;
      public String Alerttype;
      public String    SenderId;

      public String getSenderName() {
         return SenderName;
      }

      public void setSenderName(String senderName) {
         SenderName = senderName;
      }

      public String       SenderName;

      public String getSenderImage() {
         return SenderImage;
      }

      public void setSenderImage(String senderImage) {
         SenderImage = senderImage;
      }

      public String     SenderImage;

      public String getSubjectHeader() {
         return SubjectHeader;
      }

      public void setSubjectHeader(String subjectHeader) {
         SubjectHeader = subjectHeader;
      }

      public String       SubjectHeader;

      public String getMessage() {
         return Message;
      }

      public void setMessage(String message) {
         Message = message;
      }

      public String         Message;
      public String        Attachment;
      public String         AttachmentFile;
      public String        Template_id;
      public String        TempalteName;
      public int      ReadMessages;
   }
}
