package com.driver;

public class Email {

    private String emailId;
    private String password;

    public Email(String emailId){
        this.emailId = emailId;
        this.password = "Accio@123";
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public void changePassword(String oldPassword, String newPassword){
        if(oldPassword.equals(this.password)){
            if(isValid(newPassword)){
                System.out.println("Password changed successfully");
                this.password=newPassword;
            }

            System.out.println("The new password is not valid");

        }
        else{
            System.out.println("The given password doesn't match the current password");
        }
    }
    public boolean isValid(String newPassword){
        int capital=0;
        int small=0;
        int digit=0;
        int special=0;
        if(newPassword.length()<8){
            return false;
        }
        for(int i=0;i<newPassword.length();i++){
            char ch=newPassword.charAt(i);
            if((ch >= 'A')&& (ch <= 'Z')){
                capital++;
            }
            else if(ch >= 'a' && ch <= 'z'){
                small++;
            }
            else if (ch >='0' && ch <= '9') {
                digit++;
            }
            else{
                special++;
            }
        }
        if(capital !=0 && small !=0 && digit !=0 && special !=0){
            return true;
        }
        return false;
    }
}