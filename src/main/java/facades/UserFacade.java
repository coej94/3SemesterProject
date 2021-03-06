package facades;

import entity.FlightReservation;
import security.IUserFacade;
import entity.User;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;
import security.IUser;
import security.PasswordStorage;

public class UserFacade implements IUserFacade {

    private EntityManagerFactory emf;

    public UserFacade(String persistenceUnit) {
        this.emf = Persistence.createEntityManagerFactory(persistenceUnit);
    }

//    public static void main(String[] args) {
//        new UserFacade("pu_development").starter();
//    }
//    
//    public void starter(){
//        User u = getUser("admin");
//        System.out.println(getFlightReservations(u));
//    }
    public List<FlightReservation> getFlightReservations(String user) {
        User u = getUser(user);
        u.getReservations().isEmpty();
        System.out.println(u.getReservations());
        return u.getReservations();
    }
    
    public User getUser(String user){
        return getEntityManager().find(User.class, user);
    }

    public User updateReservation(User user) {
        EntityManager em = getEntityManager();
        User u = em.find(User.class, user.getUserName());
        u.addReservations(user.getReservations().get(0));
        try {
            em.getTransaction().begin();
            em.merge(u);
            em.getTransaction().commit();
        } catch (RollbackException e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return user;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    @Override
    public IUser getUserByUserId(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(User.class, id);
        } finally {
            em.close();
        }
    }

    /*
  Return the Roles if users could be authenticated, otherwise null
     */
    @Override
    public List<String> authenticateUser(String userName, String password) {
        IUser user = getUserByUserId(userName);
        if (user == null) {
            return null;
        }
        boolean passwordOK = false;
        try {
            passwordOK = PasswordStorage.verifyPassword(password, user.getPassword());
        } catch (PasswordStorage.CannotPerformOperationException | PasswordStorage.InvalidHashException ex) {
            Logger.getLogger(UserFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user != null && passwordOK ? user.getRolesAsStrings() : null;
    }

    @Override
    public IUser addUser(String userName, String password) {
        EntityManager em = getEntityManager();
        try {
            User user = new User(userName, password);
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
            return user;

        } catch (PasswordStorage.CannotPerformOperationException ex) {
            Logger.getLogger(UserFacade.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            em.close();
        }
    }

}
