package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import security.IUser;
import security.PasswordStorage;

@Entity(name = "SEED_USER")
public class User implements IUser, Serializable {

    //You will need to change this to save a Hashed/salted password 
    @Column(length = 255, name = "PASSWORD_HASH", nullable = false)
    private String passwordHash;

    @Id
    @Column(length = 35, name = "USER_NAME", nullable = false)
    private String userName;

    @ManyToMany
    List<Role> roles;

    @OneToMany
    List<FlightReservation> reservations;

    public User() {
    }

    public User(String userName, String password) throws PasswordStorage.CannotPerformOperationException {
        this.userName = userName;
        this.passwordHash = PasswordStorage.createHash(password);
    }

    public User(String passwordHash, String userName, List<FlightReservation> reservations) {
        this.passwordHash = passwordHash;
        this.userName = userName;
        this.reservations = reservations;
    }

    public List<FlightReservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<FlightReservation> reservations) {
        this.reservations = reservations;
    }

    public void addRole(Role role) {
        if (roles == null) {
            roles = new ArrayList();
        }
        roles.add(role);
        role.addUser(this);
    }

    public List<Role> getRoles() {
        return roles;
    }

    @Override
    public List<String> getRolesAsStrings() {
        if (roles.isEmpty()) {
            return null;
        }
        List<String> rolesAsStrings = new ArrayList();
        for (Role role : roles) {
            rolesAsStrings.add(role.getRoleName());
        }
        return rolesAsStrings;
    }

    @Override
    public String getPassword() {
        return passwordHash;
    }

    public void setPassword(String password) throws PasswordStorage.CannotPerformOperationException {
        this.passwordHash = this.passwordHash = PasswordStorage.createHash(password);
    }

    @Override
    public String getUserName() {
        return userName;
    }

}
