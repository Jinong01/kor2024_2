package day30.boardService8mvc.model;

import java.util.ArrayList;

public class UserDao {

    private static UserDao userDao = new UserDao();

    private UserDao(){}

    public static UserDao getInstance(){
        return userDao;
    }

    public static ArrayList<UserDto> userDd = new ArrayList<>();


}
