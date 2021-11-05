package src.main.java.User;

public abstract class User {
    private String username;
    private long Password;

    public User(String username) {
        this.username = username;
    }

    public void PasswordSetter(long password){

        this.Password = password;
    }
    public long PasswordGetter(String username){

        return this.Password;
    }
    public String UsernameGetter(){

        return this.username;
    }

}
