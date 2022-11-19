package fr.lernejo.todo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TodoListController {

    TodoRepository todoRepository;
    public TodoListController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @PostMapping("/api/todo")
    public void addTodo(@RequestBody TodoEntity t){
        this.todoRepository.save(t);
    }

    @GetMapping("/api/todo")
    public List<TodoEntity> getTodoList(){
        List<TodoEntity> l = new ArrayList<>();
        this.todoRepository.findAll().forEach(l::add);
        return l;
    }
}
