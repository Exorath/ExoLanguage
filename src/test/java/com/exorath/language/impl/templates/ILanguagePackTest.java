package com.exorath.language.impl.templates;

import com.exorath.language.api.Language;
import com.exorath.language.api.templates.Template;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by toonsev on 8/27/2016.
 */
public class ILanguagePackTest {
    private Language language;
    private ILanguagePack languagePack;

    @Before
    public void setup(){
        this.language = mock(Language.class);
        when(language.getLanguageId()).thenReturn("EN");
        languagePack = new ILanguagePack(language);
    }

    @Test
    public void getLanguageNotNullTest(){
        assertNotNull(languagePack.getLanguage());
    }

    @Test
    public void getLanguageEqualsLanguageTest(){
        assertEquals(language, languagePack.getLanguage());
    }

    @Test
    public void getTemplatesNotNullTest(){
        assertNotNull(languagePack.getTemplates());
    }

    @Test
    public void getTemplatesContainsAddedTemplateAddTemplateMethodTest(){
        Template template = mock(Template.class);
        when(template.getTemplateString()).thenReturn("This is a mock template");
        languagePack.addTemplate("testkey", template);

        assertEquals(template, languagePack.getTemplates().get("testkey"));
    }
}
