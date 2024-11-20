package day26.model;

import day25.boardService9mvc.model.BoardDto;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TodoDao {

    private static TodoDao todoDao = new TodoDao();
    private TodoDao(){
        File file = new File("./src/day26/TODOLIST.txt");
        if (file.exists()){fileLoad();}
        else {try {file.createNewFile();}
        catch (IOException e){e.printStackTrace();}}
    }
    public List<TodoDto> todoDb = new ArrayList<TodoDto>();
    public static TodoDao getInstance(){return todoDao;}

    public void todoWrite(TodoDto todoDto){
        todoDb.add(todoDto);
        fileSave();
    }

    public List<TodoDto> todoPrint(){
        return todoDb;
    }

    public boolean todoChange(int ch){
        return todoDb.get(ch).isComplete();
    }

    public void fileSave() {
        String outStr = "";
        for (int index = 0; index <= todoDb.size() - 1; index++) {
            outStr += todoDb.get(index).todo + "," + todoDb.get(index).todoDate + "," + todoDb.get(index).complete;
            outStr += "\n";
        }
        try {
            FileOutputStream outputStream = new FileOutputStream("./src/day26/TODOLIST.txt");
            outputStream.write(outStr.getBytes());

        } catch (FileNotFoundException e) {
            System.out.println("파일이 없습니다.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void fileLoad() {
        try {
            FileInputStream inputStream = new FileInputStream("./src/day26/TODOLIST.txt");
            File file = new File("./src/day26/TODOLIST.txt");
            byte[] bytes = new byte[(int)file.length()];
            inputStream.read(bytes);
            String inStr = new String(bytes);

            String[] objStr = inStr.split("\n");

            for (int i = 0; i <= objStr.length-1; i++) {
                String[] obj = objStr[i].split(",");
                String todo = obj[0];
                String todoDate = obj[1];
                boolean complete = Boolean.parseBoolean(obj[2]);
                TodoDto todoDto = new TodoDto(todo, todoDate, complete);
                todoDb.add(todoDto);
            }
        } catch (FileNotFoundException e) {e.printStackTrace();
        } catch (IOException e) {e.printStackTrace();}
    }
}
