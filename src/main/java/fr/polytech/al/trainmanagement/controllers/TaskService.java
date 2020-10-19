package fr.polytech.al.trainmanagement.controllers;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.polytech.al.trainmanagement.components.CreateTask;
import fr.polytech.al.trainmanagement.components.TaskAction;
import fr.polytech.al.trainmanagement.models.Task;
import fr.polytech.al.trainmanagement.models.TaskBody;

import static org.springframework.http.ResponseEntity.ok;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
@ComponentScan("fr.polytech.al.trainmanagement")
public class TaskService {

    @Autowired
    TaskAction taskAction;

    @Autowired
    CreateTask createTask;

    @CrossOrigin
	@GetMapping("/task")
	public ResponseEntity<List<Task>> getTasks() {
		return ok().body(taskAction.getTasks());
    }
    
    @CrossOrigin
	@GetMapping("/task/{id}")
	public ResponseEntity<Task> getTask(@PathVariable(value="id") Long id) {
		return ok().body(taskAction.getTask(id));
    }

    @CrossOrigin
	@PostMapping("/task")
	public ResponseEntity<Task> createTask(@RequestBody TaskBody taskBody) {
        Task task = createTask.createTask(taskBody.name, taskBody.type);
		return ok().body(task);
    }
    
    @CrossOrigin
	@PutMapping("/task/{id}")
	public ResponseEntity<Task> updateTask(@RequestBody TaskBody taskBody, @PathVariable(value="id") Long id) {
        Task task = taskAction.updateTask(id, taskBody.name, taskBody.type, taskBody.status);
		return ok().body(task);
    }

    @CrossOrigin
	@DeleteMapping("/task/{id}")
	public ResponseEntity<String> deleteTask(@PathVariable(value="id") Long id) {
        taskAction.deleteTask(id);
		return ok().body("Removed");
    }
    
}
