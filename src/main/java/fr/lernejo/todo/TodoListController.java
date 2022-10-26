package fr.lernejo.todo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TodoListController {

    private final List<Todo> list = new ArrayList<Todo>();

    @PostMapping
    public void addTodo(@RequestBody Todo t){
        this.list.add(t);
    }

    @GetMapping
    public List<Todo> getTodoList(){
        return this.list;
    }
}
