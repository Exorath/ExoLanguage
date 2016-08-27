package com.exorath.language.api;

import com.exorath.language.api.Language;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by toonsev on 8/23/2016.
 */
public class LanguageTest {

    @Test
    public void createNotNullTest(){
        assertNotNull(Language.create("abc"));
    }
    @Test
    public void languageIdEqualsIdProvidedInCreateMethodTest(){
        assertEquals("abc", Language.create("abc").getLanguageId());
    }
}
