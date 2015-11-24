package pl.com.agora.kornaja.dto;

/**
 * Created by P on 2015-11-24.
 */
public class UserTaskDto {

    private Long userId;
    private Long taskId;
    private String userLogin;
    private String taskTitle;

    public UserTaskDto(Long userId, Long taskId, String userLogin, String taskTitle) {
        this.userId = userId;
        this.taskId = taskId;
        this.userLogin = userLogin;
        this.taskTitle = taskTitle;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }
}
