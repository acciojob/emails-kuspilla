package com.driver;

import java.util.ArrayList;
import java.util.Date;

public class Gmail extends Email {
   public ArrayList<Mail>  mail;
   public ArrayList<Mail>  trash;
   public String emailId ;
   class Mail{
       Date date;
       String sender ;
       String message;
       Mail( Date date, String sender , String message){
           this.date = date;
           this.sender = sender;
           this.message = message;
       }
       public Date getDate(){
           return this.date;
       }
       public String getMessage( ){
           return this.message;
       }
   }

    int inboxCapacity; //maximum number of mails inbox can store
    //Inbox: Stores mails. Each mail has date (Date), sender (String), message (String). It is guaranteed that message is distinct for all mails.
    //Trash: Stores mails. Each mail has date (Date), sender (String), message (String)
    public Gmail(String emailId, int inboxCapacity) {
        super(emailId);
        this.inboxCapacity = inboxCapacity;
        mail = new ArrayList<>();
        trash = new ArrayList<>();
    }

    public void receiveMail(Date date, String sender, String message){
        // If the inbox is full, move the oldest mail in the inbox to trash and add the new mail to inbox.
        // It is guaranteed that:
        // 1. Each mail in the inbox is distinct.
        // 2. The mails are received in non-decreasing order. This means that the date of a new mail is greater than equal to the dates of mails received already.
        int n =mail.size();
        if(inboxCapacity ==  mail.size() ){
               Mail oldmail = mail.remove(0);
               trash.add(oldmail);
           }

        mail.add(new Mail(date, sender, message));
        System.out.println("received ok");

    }

    public void deleteMail(String message){
        // Each message is distinct
        // If the given message is found in any mail in the inbox, move the mail to trash, else do nothing
         Mail removemail = null;
        for( Mail m : mail){
            if( m.getMessage().equals(message)){
                removemail = m;
                break;
            }
            }

        if( removemail != null ) {
            mail.remove(removemail);
            trash.add(removemail);
            System.out.println("done");

        }
        else{
            System.out.println("not done");
        }
    }

    public String findLatestMessage(){
        // If the inbox is empty, return null
        // Else, return the message of the latest mail present in the inbox
        if( mail.size() == 0) return null;
        else{
            String mess = mail.get( mail.size() -1 ).message;
            return mess;
        }

    }

    public String findOldestMessage(){
        // If the inbox is empty, return null
        // Else, return the message of the oldest mail present in the inbox
         if(mail.isEmpty())return null;
         else{
             String mess = mail.get( 0 ).message;
             return mess;
         }
    }

    public int findMailsBetweenDates(Date start, Date end){
        //find number of mails in the inbox which are received between given dates
        //It is guaranteed that start date <= end date
      int count =0;
      for( Mail m : mail){
          if( m.getDate().after(start) && m.getDate().after(end) ) {
              count++;
          }
      }
      return count;
    }

    public int getInboxSize(){
        // Return number of mails in inbox
          return mail.size();
    }

    public int getTrashSize(){
        // Return number of mails in Trash
      return trash.size();
    }

    public void emptyTrash(){
        // clear all mails in the trash
         trash.clear();
    }

    public int getInboxCapacity() {
        // Return the maximum number of mails that can be stored in the inbox
        return inboxCapacity;
    }
}
