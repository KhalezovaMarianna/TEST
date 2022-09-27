package com.qaprosoft.carina.demo.web;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.demo.gui.webPages.utils.AuthenticationService;
import com.qaprosoft.carina.demo.gui.webPages.utils.OpeningService;

public class BaseTest extends AbstractTest {

    protected AuthenticationService authenticationService = new AuthenticationService();
    protected OpeningService openingService = new OpeningService();
}
