package pl.project.externalservice.tools;

import pl.project.externalservice.entities.FeignEurekaUser;

public class RequestAction {

    public static final int ID=1, USER_NAME=2, REAL_NAME=3, LAST_NAME=4;

    public static boolean filterEurekaUser(int filterValue, String requestValue,FeignEurekaUser feignEurekaUser) {

        switch(filterValue) {
            case ID:
                return String.valueOf(feignEurekaUser.getId()).equals(requestValue);
            case USER_NAME:
                return feignEurekaUser.getUserName().equals(requestValue);
            case REAL_NAME:
                return feignEurekaUser.getRealName().equals(requestValue);
            case LAST_NAME:
                return feignEurekaUser.getLastName().equals(requestValue);
            default:
                return false;
        }
    }
}
