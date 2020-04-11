package com.kastking.salesforcastInfo.util;

public class UsersUtil {

    public static int userUtils(String UserName) {
        if (UserName == "Ivy" || UserName == "Rita" || UserName == "Cassie" || UserName == "Wendy"
                || UserName == "Barry" || UserName == "Twinkle" || UserName == "Maggie" || UserName == "Nicole"
                || UserName == "Echo" || UserName == "Faith" || UserName == "May" || UserName == "Deshou") {
            return 0;
        }
        if (UserName == "Vivian") {
            return 1;
        }
        if (UserName == "Jason") {
            return 2;
        }
        if (UserName == "Louis") {
            return 3;
        }
        return -1;
    }
}

