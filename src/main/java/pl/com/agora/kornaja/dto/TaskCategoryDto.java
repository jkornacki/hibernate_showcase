package pl.com.agora.kornaja.dto;

import pl.com.agora.kornaja.domain.task.TaskCategory;

/**
 * Created by P on 2015-11-24.
 */
public class TaskCategoryDto {

    private Long id;
    private String name;

    public TaskCategoryDto(TaskCategory taskCategory) {
        this.id = taskCategory.getId();
        this.name = taskCategory.getName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
