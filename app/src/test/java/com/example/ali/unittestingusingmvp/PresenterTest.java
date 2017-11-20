package com.example.ali.unittestingusingmvp;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * Created by ali on 20/11/17.
 */

@RunWith(MockitoJUnitRunner.class)
public class PresenterTest {
    @Mock
    private MainActivity mainActivityMock;
    private LoginView loginViewMock;
    private Presenter presenter;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        loginViewMock = Mockito.mock(LoginView.class);
        presenter = new Presenter(loginViewMock);
    }

    @Test
    public void shouldShowPasswordIsEmpty() throws Exception {
        Mockito.when(loginViewMock.getUsername()).thenReturn("ali");
        Mockito.when(loginViewMock.getPassword()).thenReturn("");
        presenter.onLogin();
        Mockito.verify(loginViewMock, Mockito.times(1)).showEmptyPassword();
    }

    @Test
    public void shouldShowUsernameIsEmpty() throws Exception {
        Mockito.when(loginViewMock.getUsername()).thenReturn("");
        Mockito.when(loginViewMock.getPassword()).thenReturn("12345");
        presenter.onLogin();
        Mockito.verify(loginViewMock, Mockito.times(1)).showEmptyUsername();
    }

    @Test
    public void shouldShowEmptyPasswordAndUsername() throws Exception {
        Mockito.when(loginViewMock.getUsername()).thenReturn("");
        Mockito.when(loginViewMock.getPassword()).thenReturn("");
        presenter.onLogin();
        Mockito.verify(loginViewMock, Mockito.times(1)).showEmptyUsernameAndPassword();
    }

    @Test
    public void shouldGoToWellcome() throws Exception {
        Mockito.when(loginViewMock.getUsername()).thenReturn("ali");
        Mockito.when(loginViewMock.getPassword()).thenReturn("12345");
        presenter.onLogin();
        Mockito.verify(loginViewMock).goToWellcome();
    }
}