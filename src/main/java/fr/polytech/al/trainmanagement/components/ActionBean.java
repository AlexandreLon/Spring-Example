package fr.polytech.al.trainmanagement.components;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.polytech.al.trainmanagement.models.Task;
import fr.polytech.al.trainmanagement.repositories.TaskRepository;

@Component
public class ActionBean implements CreateTask, TaskAction {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Task createTask(String name, String type) {
        Task task = new Task();
        task.setId(taskRepository.getMaxId()+1);
        task.setName(name);
        task.setType(type);
        task.setStatus("en cours");
        taskRepository.save(task);
        return task;
    }

    @Override
    public List<Task> getTasks() {
        return (List<Task>) taskRepository.findAll();
    }

    @Override
    public Task getTask(Long id) {
        Optional<Task> opt = taskRepository.findById(id);
        if(opt.isPresent()) return opt.get();
        return null;
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public Task updateTask(Long id, String name, String type, String status) {
        Optional<Task> opt = taskRepository.findById(id);
        if(opt.isPresent()) {
            Task task = opt.get();
            task.setName(name);
            task.setStatus(status);
            task.setType(type);
            taskRepository.save(task);
            return opt.get();
        }
        return null;
    }
    
}
