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
    	
    	if(!oldPassword.equals(password)) {
    		//System.out.println("Old Password doesn't matches");
    		return;
    	}
    	if(isValidPassword(newPassword)) {
    		password = newPassword;
    		//System.out.println("New Password Created");
    	}
    	else {
    		//System.out.println("Invalid New Password");
    	}
    }
    
    // Method to check the conditions of a new Password
    public boolean isValidPassword(String pass) {
    	
    	boolean containsUpperCase = false;
    	boolean containsLowerCase = false;
    	boolean containsDigit = false;
    	boolean containsSpecial = false;
    	
    	// check at least 8 characters
    	if(pass.length() < 8) {
    		return false;
    	}
    	
    	// check for other validations
    	for(char c : pass.toCharArray()) {
    		if(Character.isLowerCase(c)) 
    			containsLowerCase = true;
    		else if(Character.isUpperCase(c))
    			containsUpperCase = true;
    		else if(Character.isDigit(c))
    			containsDigit = true;
    		else if(!Character.isLetterOrDigit(c))
    			containsSpecial = true;
    		
    	}
    	return containsUpperCase && containsLowerCase && containsDigit && containsSpecial;
    }
}
