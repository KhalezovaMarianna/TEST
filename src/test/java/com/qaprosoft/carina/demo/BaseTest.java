package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.demo.gui.webPages.services.AuthenticationService;

public class BaseTest extends AbstractTest {

    protected AuthenticationService authenticationService = new AuthenticationService();
}
