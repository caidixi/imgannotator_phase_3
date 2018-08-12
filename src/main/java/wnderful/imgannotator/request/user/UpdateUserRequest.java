package wnderful.imgannotator.request.user;

public class UpdateUserRequest {
    private String newEmail;
    private String oldPassword;
    private String newPassword;
    private String role;

    public UpdateUserRequest() {
    }

    public UpdateUserRequest(String newEmail, String oldPassword, String newPassword, String role) {
        this.newEmail = newEmail;
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
        this.role = role;
    }

    public String getNewEmail() {
        return newEmail;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public String getRole() {
        return role;
    }
}
