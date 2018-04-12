package com.magn.magnspringboot.dao;

import com.magn.magnspringboot.model.User;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

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
    public void selectUserByUserUid() throws Exception {
    }

    @Test
    public void updateUser() throws Exception {
    }

    @Test
    public void deleteUserByUserUid() throws Exception {
    }

    @Test
    public void insertUser() throws Exception {
    }

}