package fr.polytech.al.trainmanagement.components;

import fr.polytech.al.trainmanagement.models.Task;

public interface CreateTask {
    
	Task createTask(String name, String type);

}
