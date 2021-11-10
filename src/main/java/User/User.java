package User;

/**
 * Represents a User in the system (either Staff or Student)
 */
public abstract class User {
    /**
     * The username of a User
     */
    private String username;
    /**
     * User's password
     */
    private long Password;

    /**
     * A new User with username
     * @param username username
     */

    public User(String username) {
        this.username = username;
    }

    /**
     * To set up a User's password
     * @param password user's password
     */

    public void PasswordSetter(long password){

        this.Password = password;
    }

    /**
     * Return a User's password
     * @param username username
     * @return user's password
     */
    public long PasswordGetter(String username){

        return this.Password;
    }

    /**
     * Return the a User's username
     * @return username
     */
    public String UsernameGetter(){

        return this.username;
    }

}
