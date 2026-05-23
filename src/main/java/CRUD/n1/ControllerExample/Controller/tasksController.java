package CRUD.n1.ControllerExample.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tools.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

@RestController
public class tasksController {

    private List<String> tasks = new ArrayList<>();

    private ObjectMapper objectMapper;

    public tasksController(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @GetMapping(path = "/tasks")
    public ResponseEntity<String> listTasks() {

        return ResponseEntity.ok(objectMapper.writeValueAsString(tasks));
    }

    @PostMapping(path = "/tasks")
    public ResponseEntity<Void> createTask(@RequestBody String task) {
        tasks.add(task);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping(path = "/tasks")
    public ResponseEntity<Void> deleteTasks() {
        tasks = new ArrayList<>();

        return ResponseEntity.ok().build();
    }
}
