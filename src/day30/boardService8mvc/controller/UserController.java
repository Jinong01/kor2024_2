package day30.boardService8mvc.controller;

import day30.boardService8mvc.model.UserDao;
import day30.boardService8mvc.model.UserDto;

public class UserController {

    private static UserController userController = new UserController();
    private UserController (){}
    public static UserController getInstance() {
        return userController;
    }

    public boolean checkId(String id){
        for (UserDto userDto : UserDao.userDd){
            if (userDto.getId().equals(id)){
                return true;
            }
        }
        return false;
    }

    public void signUp(String id, String pwd, String name){
        UserDto userDto = new UserDto(id, pwd, name);
        UserDao.getInstance().userDd.add(userDto);
    }

    public UserDto logIn(String id, String pwd){
        UserDto user = new UserDto();
        return user;
    }
}
