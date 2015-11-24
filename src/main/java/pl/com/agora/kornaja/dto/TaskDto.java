package pl.com.agora.kornaja.dto;

import pl.com.agora.kornaja.domain.task.ListTask;
import pl.com.agora.kornaja.domain.task.NoteTask;
import pl.com.agora.kornaja.domain.task.Task;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by P on 2015-11-24.
 */
public class TaskDto {
    private Long id;
    private String title;
    private Date createDate;
    private List<String> tags;
    private TaskCategoryDto taskCategory;
    private UserDto user;
    private String content;
    private Map<String, Boolean> subtask;

    private TaskDto(Task task) {
        this.id = task.getId();
        this.title = task.getTitle();
        this.createDate = task.getCreateDate();
        this.tags = task.getTags();
        this.taskCategory = new TaskCategoryDto(task.getTaskCategory());
    }

    public static TaskDto createTaskWithUser(Task task) {
        TaskDto taskDto = new TaskDto(task);
        taskDto.setUser(new UserDto(task.getUser()));
        return taskDto;
    }

    public static TaskDto createTaskWithUser(ListTask task) {
        TaskDto taskDto = new TaskDto(task);
        taskDto.setUser(new UserDto(task.getUser()));
        taskDto.setSubtask(task.getSubtask());
        return taskDto;
    }

    public static TaskDto createTaskWithUser(NoteTask task) {
        TaskDto taskDto = new TaskDto(task);
        taskDto.setUser(new UserDto(task.getUser()));
        taskDto.setContent(task.getContent());
        return taskDto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public TaskCategoryDto getTaskCategory() {
        return taskCategory;
    }

    public void setTaskCategory(TaskCategoryDto taskCategory) {
        this.taskCategory = taskCategory;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public Map<String, Boolean> getSubtask() {
        return subtask;
    }

    public void setSubtask(Map<String, Boolean> subtask) {
        this.subtask = subtask;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
