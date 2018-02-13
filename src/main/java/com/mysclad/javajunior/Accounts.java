package com.mysclad.javajunior;

import java.util.HashMap;
import java.util.Map;

public class Accounts {
    private Map<String, Double> accs;

    Accounts(){
        accs = new HashMap<>();
    }

    private boolean accountNumberCheck(String str){
        return (str.chars().allMatch(Character::isDigit)) && (str.length() == 5);
    }
    private boolean valueCheck(String str){
        try{
            Double db = Double.parseDouble(str);
            return db >= 0;
        } catch (NumberFormatException e){
            return false;
        }
    }

    public boolean newAccount(String accNumber) {
        if(accountNumberCheck(accNumber)){
            if(accs.containsKey(accNumber)){
                return false;
            } else {
                accs.put(accNumber, 0.0);
                return true;
            }
        } else {
            return false;
        }
    }

    public boolean deposit(String accNumber, String amount){
        Double value;
        if(accountNumberCheck(accNumber) && valueCheck(amount)){
            if(accs.containsKey(accNumber)){
                value = accs.get(accNumber) + Double.parseDouble(amount);
                accs.put(accNumber, value);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean withdraw(String accNumber, String amount) {
        if(accountNumberCheck(accNumber) && valueCheck(amount)){
            if(accs.containsKey(accNumber)){
                Double value = Double.parseDouble(amount);
                Double prev = accs.get(accNumber);
                if(prev >= value){
                    accs.put(accNumber, prev - value);
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public Double balance(String accNumber) {
        if(accountNumberCheck(accNumber)){
            if(accs.containsKey(accNumber)){
                return accs.get(accNumber);
            } else {
                return -1.0;
            }
        } else {
            return -1.0;
        }
    }
}

