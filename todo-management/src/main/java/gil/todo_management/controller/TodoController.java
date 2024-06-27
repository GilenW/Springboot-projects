package gil.todo_management.controller;


import gil.todo_management.dto.TodoDto;
import gil.todo_management.entity.Todo;
import gil.todo_management.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/todos")
@CrossOrigin("*")
public class TodoController {

    private TodoService todoService;

    @PostMapping
    public ResponseEntity<TodoDto> addTodo(@RequestBody TodoDto todoDto){
        TodoDto savedTodo = todoService.addTodo(todoDto);
        return new ResponseEntity<>(savedTodo, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<TodoDto> getTodo(@PathVariable("id") Long todoId){
        TodoDto todoDto = todoService.getTodo(todoId);
        return new ResponseEntity<>(todoDto, HttpStatus.OK);

    }

    @GetMapping
    public ResponseEntity<List<TodoDto>> getAllTodos(){
        List<TodoDto> todoDtos = todoService.getAllTodos();
        return ResponseEntity.ok(todoDtos);
    }


    @PutMapping("{id}")
    public ResponseEntity<TodoDto> updateTodo(@RequestBody
                                              TodoDto todoDto, @PathVariable("id") Long todoId){

        TodoDto updatedDto = todoService.updateTodo(todoDto, todoId);
        return ResponseEntity.ok(updatedDto);


    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable("id") Long todoId){
        todoService.deleteTodo(todoId);
        return ResponseEntity.ok("Todo deleted successfully!");
    }

    @PatchMapping("{id}/complete")
    public ResponseEntity<TodoDto> completeTodo(@PathVariable("id")
                                                Long todoId){
        TodoDto todoDto = todoService.completeTodo(todoId);
        return ResponseEntity.ok(todoDto);
    }

    @PatchMapping("{id}/in-complete")
    public ResponseEntity<TodoDto> inCompleteTodo(@PathVariable("id")
                                                Long todoId){
        TodoDto todoDto = todoService.inCompleteTodo(todoId);
        return ResponseEntity.ok(todoDto);
    }



}
