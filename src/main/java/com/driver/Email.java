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
        //Change password only if the oldPassword is equal to current password and the new password meets all of the following:
        // 1. It contains at least 8 characters
        // 2. It contains at least one uppercase letter
        // 3. It contains at least one lowercase letter
        // 4. It contains at least one digit
        // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character

        if( password.contains(oldPassword)){
            if( newPassword.length() >= 8){
                boolean upcase = true;
                boolean lowcase = true;
                boolean digit = true;
                boolean special_char = true;
                for(char ch : newPassword.toCharArray()){
                    if(Character.isDigit(ch)){
                        digit = false;
                    }
                    else if( Character.isUpperCase(ch)){
                        upcase = false;
                    }
                    else if( Character.isLowerCase(ch)){
                        lowcase = false;
                    }
                    else{
                        special_char = false;
                    }
                }
                if( upcase  ){
                    System.out.println("It contains at least one uppercase letter");
                    return ;
                }
                else if (lowcase){
                    System.out.println("It contains at least one lowercase letter");
                }
                else if ( digit){
                    System.out.println("It contains at least one digit");
                }
                else if( special_char){
                    System.out.println( "It contains at least one special character");
                }
                else{
                    this.password = newPassword;
                    System.out.println("Password changed successfully.");
                }


            } else {
                System.out.println("It contains at least 8 characters");
            }


        } else {
            System.out.println("Invalid password");
        }

    }
}
