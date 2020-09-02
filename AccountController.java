package com.example.userRecords;

import org.springframework.stereotype.Controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AccountController {

    static Map<String,UserAccount> userAccountMap = new HashMap<>();
    static Map<Integer,String> userDetailsMap = new HashMap<>();
    static int userCount=0;

    @RequestMapping(value = "/app/user")
    public UserAccountResponseData  createNewAccount(@RequestParam UserAccountRequestData userRequest){
        UserAccount userAccount=new UserAccount();
        userAccount.setUserName(userRequest.getUserName());
        userAccount.setPassword(userRequest.getPassword());
        userCount++;
        StringBuilder userHash = new StringBuilder();
        userHash.append(userRequest.getUserName()).append(userRequest.getPassword());
        userAccount.setUserId(userCount);
        userDetailsMap.put(userCount, userHash.toString());
        userAccountMap.put(userHash.toString(),userAccount);
        UserAccountResponseData userResponse=new UserAccountResponseData();
        userResponse.setStatus("account created");
        return userResponse;
    }

    @RequestMapping(value = "/app/user/auth")
    public UserAccountResponseData loginUser(@RequestParam UserAccountRequestData userRequest){
        StringBuilder userHash = new StringBuilder();
        userHash.append(userRequest.getUserName()).append(userRequest.getPassword());
        UserAccountResponseData userResponse=new UserAccountResponseData();
        if(userAccountMap.containsKey(userHash.toString())) {
            UserAccount userAccount = userAccountMap.get(userHash.toString());
            userResponse.setUserId(userAccount.getUserId());
            userResponse.setStatus("success");
        }else{
            userResponse.setStatus("unsuccessful");
        }
        return userResponse;
    }

    @RequestMapping(value = "/app/sites/list")
    public UserAccountResponseData getUserNotes(@RequestParam int userId){
        String userDetails= userDetailsMap.get(userId);
        UserAccount userAccount=userAccountMap.get(userDetails);
        UserAccountResponseData userResponse=new UserAccountResponseData();
        userResponse.setNotes(userAccount.getNotesList());
        return userResponse;
    }

    @RequestMapping(value = "/app/sites")
    public UserAccountResponseData addUserNote(@RequestParam UserAccountRequestData userRequest ,int userId){
        String userDetails= userDetailsMap.get(userId);
        UserAccount userAccount=userAccountMap.get(userDetails);
        userAccount.addNotes(Collections.singletonList(userRequest.getNotes()));
        UserAccountResponseData userResponse=new UserAccountResponseData();
        userResponse.setStatus("success");
        return userResponse;
    }
}
