package com.mysclad.javajunior;

import java.util.Scanner;

/**
 *
 * @author STEELLEX
 */
public class Main {
    private static void okErrPrint(boolean flag){
        if(flag){
            System.out.println("OK");
        } else {
            System.out.println("ERROR");
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String command;
        String[] param;
        Accounts accs = new Accounts();
        while(true) {
            command = in.nextLine();
            param = command.split(" ");
            switch (param[0]) {
                case "NEWACCOUNT":
                    if(param.length == 2) okErrPrint(accs.newAccount(param[1]));
                    else System.out.println("ERROR");
                    break;
                case "DEPOSIT":
                    if(param.length == 3) okErrPrint(accs.deposit(param[1], param[2]));
                    else System.out.println("ERROR");
                    break;
                case "WITHDRAW":
                    if(param.length == 3) okErrPrint(accs.withdraw(param[1], param[2]));
                    else System.out.println("ERROR");
                    break;
                case "BALANCE":
                    if(param.length == 2) {
                        Double value = accs.balance(param[1]);
                        if(value == -1){
                            System.out.println("ERROR");
                        } else {
                            System.out.println(value.toString());
                        }
                    } else {
                        System.out.println("ERROR");
                    }
                    break;
                default:
                    System.out.println("ERROR");

            }

        }
    }
}
