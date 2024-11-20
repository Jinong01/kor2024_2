package day26.controller;

import day25.boardService9mvc.model.BoardDto;
import day26.model.TodoDao;
import day26.model.TodoDto;

import java.util.ArrayList;
import java.util.List;

public class TodoController {

    private static TodoController todoController = new TodoController();
    private TodoController(){}
    public static TodoController getInstance(){return todoController;}


    public void todoWrite(String todo, String todoDate, boolean complete){
        TodoDto todoDto = new TodoDto(todo, todoDate, complete);
        TodoDao.getInstance().todoWrite(todoDto);
    }

    public List<TodoDto> todoPrint(){
        TodoDao.getInstance().todoPrint();
        return TodoDao.getInstance().todoDb;
    }

    public boolean todoChange(int ch){
        boolean result = TodoDao.getInstance().todoChange(ch);
        if (result) {
            result = false;
        } else if (!result) {
            result = true;
        }
        TodoDao.getInstance().todoDb.get(ch).setComplete(result);
        TodoDao.getInstance().fileSave();
        return result;
    }
}
