package pl.umk.mat.library.utils;

public class AuthDto<T> {
    private T data;

    private String username;

    private String password;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
