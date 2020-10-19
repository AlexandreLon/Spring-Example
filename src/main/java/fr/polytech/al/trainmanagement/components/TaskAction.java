package fr.polytech.al.trainmanagement.components;

import java.util.List;

import fr.polytech.al.trainmanagement.models.Task;

public interface TaskAction {
    
    List<Task> getTasks();

	Task getTask(Long id);

	void deleteTask(Long id);

	Task updateTask(Long id, String name, String type, String status);
}
