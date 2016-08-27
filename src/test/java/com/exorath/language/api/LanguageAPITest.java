package com.exorath.language.api;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Created by toonsev on 8/26/2016.
 */
public class LanguageAPITest {

    @Test
    public void createNotNullTest(){
        assertNotNull(LanguageAPI.create());
    }
}
