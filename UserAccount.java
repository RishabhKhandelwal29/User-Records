package com.example.userRecords;

import java.util.ArrayList;
import java.util.List;

public class UserAccount {
    private int userId;
    private String userName;
    private String password;
    private List<String> notes;

    public String getUserName(){
        return this.userName;
    }
    public void setUserName(String userName){
        this.userName=userName;
    }
    public String getPassword(){
        return this.password;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public int getUserId(){
        return this.userId;
    }
    public void setUserId(int userId){
        this.userId=userId;
    }

    public List<String> getNotesList(){
        return this.notes;
    }
    public void addNotes(List<String> notes){
        if(this.notes==null){
            this.notes=new ArrayList<>();
        }
        for(String str : notes){
            this.notes.add(str);
        }
    }
}

class UserAccountRequestData{
    private String userName;
    private String password;
    private String notes;

    public String getUserName(){
        return this.userName;
    }
    public void setUserName(String userName){
        this.userName=userName;
    }
    public String getPassword(){
        return this.password;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public String getNotes(){
        return this.notes;
    }
    public void setNotes(String notes){
        this.notes=notes;
    }
}

class UserAccountResponseData{
    private String status;
    private int userId;
    private List<String> notes;

    public String getStatus(){
        return this.status;
    }
    public void setStatus(String status){
        this.status=status;
    }

    public int getUserId(){
        return this.userId;
    }
    public void setUserId(int userId){
        this.userId=userId;
    }

    public List<String> getNotesList(){
        return this.notes;
    }
    public void setNotes(List<String> notes){
        this.notes = notes;
    }


}
