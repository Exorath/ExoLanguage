package com.exorath.language.api.templates;

import com.exorath.language.api.Language;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by toonsev on 8/26/2016.
 */
public class LanguagePackTest {
    @Test
    public void createNotNullTest(){
        Language language = mock(Language.class);
        when(language.getLanguageId()).thenReturn("EN");
        assertNotNull(LanguagePack.create(language));
    }
}
