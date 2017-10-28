package com.happycity.project.jobme.activity;

import com.google.firebase.database.DataSnapshot;
import com.happycity.project.jobme.data.model.User;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 10/28/2017.
 */
public class LoginActivityTest {
    private String username = null;
    private String password = null;
    // LoginActivity loginActivity = null;
    @Before
    public void setUp() throws Exception {
        username = "tienle";
        password = "lvt123";
        // loginActivity = new LoginActivity();
    }
    @Test
    public void testTrueAll() {
        assertEquals("tienle", username);
        assertEquals("lvt123", password);
    }
    @Test
    public void testFalseUsername() {
        assertEquals("Username is not valid!", "tien", username);
        assertEquals("Right password!", "lvt123", password);
    }
    @Test
    public void testFalsePassword() {
        assertEquals("Right username!", "tienle", username);
        assertEquals("Password is not valid!", "lvt", password);
    }
    @Test
    public void testFalseAll() {
        assertEquals("Account is not valid!", "tien", username);
        assertEquals("Account is not valid!", "lvt", password);
    }
    @Test
    public void testEmptyAll() {
        assertEquals("You must fill the username and password!", "", username);
        assertEquals("You must fill the username and password!", "", password);
    }
    @Test
    public void testEmptyUsername() {
        assertEquals("", username);
        // loginActivity.edtUserID.setError("You must fill the username!");
        assertEquals("Right password", "lvt123", password);
    }
    @Test
    public void testEmptyPassword() {
        assertEquals("Right password", "tienle", username);
        assertEquals("", password);
        // loginActivity.edtPassword.setError("You must fill the password!");
    }
    @After
    public void tearDown() throws Exception {

    }

}