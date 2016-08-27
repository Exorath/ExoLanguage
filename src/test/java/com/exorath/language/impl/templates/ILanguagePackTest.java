/*
 * Copyright 2016 Exorath
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

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
