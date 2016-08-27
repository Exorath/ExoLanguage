package com.exorath.language.impl;

import com.exorath.language.impl.ILanguage;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by toonsev on 8/26/2016.
 */
public class ILanguageTest {
    ILanguage language;

    @Before
    public void setup(){
        language = new ILanguage("EN");
    }

    @Test
    public void languageIdNotNullTest(){
        assertNotNull(language.getLanguageId());
    }

    @Test
    public void languageIdEqualsIdTest(){
        assertEquals("EN", language.getLanguageId());
    }

    @Test
    public void languageEqualsNewLanguageTest(){
        assertEquals(new ILanguage("EN"), language);
    }
}
