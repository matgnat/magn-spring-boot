package com.magn.magnspringboot.dao;

import com.magn.magnspringboot.model.User;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.doesNotHave;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


/**
 * Created by magn on 4/12/2018.
 */
public class FakeDataDaoTest {

    private FakeDataDao fakeDataDao;

    @Before
    public void setUp() throws Exception {
        fakeDataDao = new FakeDataDao();
    }

    @Test
    public void shouldSelectAllUsers() throws Exception {
        List<User> users = fakeDataDao.selectAllUsers();
        assertThat(users).hasSize(1);
        User user = users.get(0);
        assertThat(user.getAge()).isEqualTo(22);
        assertThat(user.getGender()).isEqualTo(User.Gender.MAIL);
        assertThat(user.getUserUid()).isNotNull();
    }

    @Test
    public void shouldSelectUserByUserUid() throws Exception {
        UUID uuid = UUID.randomUUID();
        User user = new User(uuid,"ana", "maniana", User.Gender.FEMAIL, 30, "ana.maniana@gmail.com");

        fakeDataDao.insertUser(uuid, user);
        assertThat(fakeDataDao.selectAllUsers()).hasSize(2);

        Optional<User> userOptional = fakeDataDao.selectUserByUserUid(uuid);
        assertThat(userOptional).isNotNull();
        assertThat(userOptional.isPresent()).isTrue();
        assertThat(user.getUserUid()).isEqualTo(uuid);
        System.out.println(user.toString());
    }

    @Test
    public void shouldNotSelectUserByUserUid() throws Exception {
        UUID uuid = UUID.randomUUID();
        Optional<User> userFake = fakeDataDao.selectUserByUserUid(uuid);
        assertThat(userFake.isPresent()).isFalse();
    }

    @Test
    public void updateUser() throws Exception {
        UUID firstUserUid = fakeDataDao.selectAllUsers().get(0).getUserUid();
        User newUser = new User(firstUserUid,"ana", "maniana", User.Gender.FEMAIL, 30, "ana.maniana@gmail.com");

        fakeDataDao.updateUser(newUser);
        Optional<User> userUpdate = fakeDataDao.selectUserByUserUid(firstUserUid);
        assertThat(userUpdate.isPresent()).isTrue();
        assertThat(fakeDataDao.selectAllUsers()).hasSize(1);
        assertThat(fakeDataDao.selectUserByUserUid(firstUserUid).get().getFirstName()).isEqualTo("ana");
        assertThat(userUpdate.get()).isEqualToComparingFieldByField(newUser);
        System.out.println(userUpdate.toString());

    }

    @Test
    public void deleteUserByUserUid() throws Exception {
        UUID userUid = fakeDataDao.selectAllUsers().get(0).getUserUid();
        fakeDataDao.deleteUserByUserUid(userUid);
        assertThat(fakeDataDao.selectAllUsers()).isEmpty();

    }

    @Test
    public void insertUser() throws Exception {

        UUID userUid = UUID.randomUUID();
        User user = new User(userUid,"joe", "manianana", User.Gender.MAIL, 30, "joe.manianana@gmail.com");
        fakeDataDao.insertUser(userUid, user);

        assertThat(fakeDataDao.selectUserByUserUid(userUid).get()).isEqualToComparingFieldByField(user);
        System.out.println(fakeDataDao.selectUserByUserUid(userUid).toString());

    }

}