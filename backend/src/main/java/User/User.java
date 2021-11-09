package User;

public abstract class User {
    /**
     * The username
     */
    private String username;
    /**
     * The password
     */
    private long Password;

    /**
     *
     * @param username username
     */

    public User(String username) {
        this.username = username;
    }

    /**
     *
     * @param password user's password
     */

    public void PasswordSetter(long password){

        this.Password = password;
    }

    /**
     *
     * @param username username
     * @return user's password
     */
    public long PasswordGetter(String username){

        return this.Password;
    }

    /**
     *
     * @return username
     */
    public String UsernameGetter(){

        return this.username;
    }

}
