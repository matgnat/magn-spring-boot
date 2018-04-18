package com.magn.magnspringboot.service;

import com.magn.magnspringboot.dao.FakeDataDao;
import com.magn.magnspringboot.model.User;
import jersey.repackaged.com.google.common.collect.ImmutableList;
import org.junit.Before;
import org.junit.Test;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.BDDMockito.given;


/**
 * Created by magn on 4/12/2018.
 */

public class UserServiceTest {

    @Mock
    private FakeDataDao fakeDataDao;
    private UserService userService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        userService = new UserService(fakeDataDao);
    }

    @Test
    public void shouldGetAllUsers() throws Exception {

        UUID uuid = UUID.randomUUID();
        User test_user = new User(uuid,"ana", "maniana", User.Gender.FEMAIL, 30, "ana.maniana@gmail.com");

        ImmutableList<User> fake_table_users = new ImmutableList.Builder<User>().add(test_user).build();
        given(fakeDataDao.selectAllUsers()).willReturn(fake_table_users);

        List<User> allUsers = userService.getAllUsers(Optional.empty());
        assertThat(allUsers).hasSize(1);

        User baseUser = allUsers.get(0);
        System.out.println(baseUser);
    }

    @Test
    public void shouldGetUser() throws Exception {
        UUID uuid = UUID.randomUUID();
        User test_user = new User(uuid,"ana", "maniana", User.Gender.FEMAIL, 30, "ana.maniana@gmail.com");

        given(fakeDataDao.selectUserByUserUid(uuid)).willReturn(Optional.of(test_user));

        Optional<User> user = userService.getUser(uuid);
        assertThat(user.isPresent()).isTrue();
        assertThat(user.equals(test_user));

    }

    @Test
    public void updateUser() throws Exception {
        UUID uuid = UUID.randomUUID();
        User user_test = new User(uuid,"ana", "maniana", User.Gender.FEMAIL, 30, "ana.maniana@gmail.com");

        given(fakeDataDao.selectUserByUserUid(uuid)).willReturn(Optional.of(user_test));
        given(fakeDataDao.updateUser(user_test)).willReturn(1);

        int update_resoult = userService.updateUser(user_test);

        assertThat(update_resoult).isEqualTo(1);

    }

    @Test
    public void removeUser() throws Exception {
    }

    @Test
    public void insertUser() throws Exception {
    }

}