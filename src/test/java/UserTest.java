import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.persistence.*;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Tommy on 15/09/2016.
 */

@RunWith(Arquillian.class)
public class UserTest {

    private EntityManagerFactory factory;
    private EntityManager em;

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(User.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Before
    public void init(){
        factory = Persistence.createEntityManagerFactory("DB");
        em = factory.createEntityManager();
        addDefaultData();
    }

    @After
    public void tearDown() {
        em.close();
        factory.close();
    }

    private void addDefaultData() {
        User a = new User();
        a.setEmail("name.family@email.com");
        a.setPassword("passord123");
        a.getAddress().setCity("Oslo");
        a.getAddress().setCountry("Norway");

        User b = new User();
        a.setName("Tommy Nordli");
        a.setEmail("tommy.nordli@me.com");
        a.setPassword("safepassword");
        a.getAddress().setCity("Trondheim");
        a.getAddress().setCountry("Norway");

        User c = new User();
        a.setName("Tommy Nordli");
        a.setEmail("nortom13@student.westerdals.no");
        a.setPassword("safepassword");
        a.getAddress().setCity("Oslo");
        a.getAddress().setCountry("Norway");

        User d = new User();
        a.setEmail("name.another@gmail.com");
        a.setPassword("passord");
        a.getAddress().setCity("Stockholm");
        a.getAddress().setCountry("Sweden");

        User e = new User();
        a.setEmail("anononym@safemail.com");
        a.setPassword("vqkF3Lp}Vc2");

        assertTrue(persistInATransaction(a,b,c,d,e));
    }

    @Test
    public void testGetAll(){
        Query query = em.createNamedQuery(User.GET_ALL);

        //being a read operation, no need to have an explicit transaction here
        List<User> users = query.getResultList();

        assertEquals(5, users.size());
    }

    @Test
    public void testGetCity(){
        Query query = em.createQuery("select u from User u where u.address.city = 'Stockholm'");
        List<User> users = query.getResultList();
        assertEquals(1, users.size());
    }

    private boolean persistInATransaction(Object... obj) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            for(Object o : obj) {
                em.persist(o);
            }
            tx.commit();
        } catch (Exception e) {
            System.out.println("FAILED TRANSACTION: " + e.toString());
            tx.rollback();
            return false;
        }

        return true;
    }

}
