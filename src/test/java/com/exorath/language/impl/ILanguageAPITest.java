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

package com.exorath.language.impl;

import com.exorath.language.api.Language;
import com.exorath.language.api.Message;
import com.exorath.language.api.MessageTest;
import com.exorath.language.api.templates.LanguagePack;
import com.exorath.language.api.templates.LanguagesPack;
import com.exorath.language.api.templates.Template;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by toonsev on 8/23/2016.
 */
public class ILanguageAPITest {
    private ILanguageAPI languageAPI;
    private Language english;
    private LanguagePack englishPack;
    LanguagesPack languagesPack;

    @Before
    public void setup(){
        languageAPI = new ILanguageAPI();

        english = mock(Language.class);
        when(english.getLanguageId()).thenReturn("EN");

        englishPack = mock(LanguagePack.class);
        when(englishPack.getLanguage()).thenReturn(english);

        languagesPack = mock(LanguagesPack.class);
    }

    @Test
    public void addTemplateToLanguagePackInALanguagesPackThatIsAddedToTheLanguageAPIThenCheckTheGetTranslatedMethodTest(){

        HashMap<String, Template> templates = new HashMap<>();
        templates.put("exomsg.onjoin", Template.create("Welcome to Exorath, <NAME>."));

        when(englishPack.getTemplates()).thenReturn(templates);

        HashMap<Language, LanguagePack> languagePacks = new HashMap<>();
        languagePacks.put(english, englishPack);

        when(languagesPack.getTemplatePacks()).thenReturn(languagePacks);


        languageAPI.addLanguagesPack(languagesPack);

        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put("NAME", "Toon Sevrin");

        Message message = mock(Message.class);
        when(message.getLanguage()).thenReturn(english);
        when(message.getMessageKey()).thenReturn("exomsg.onjoin");
        when(message.getParameters()).thenReturn(parameters);

        assertEquals("Welcome to Exorath, Toon Sevrin.", languageAPI.getTranslated(message));
    }


    @Test
    public void testIfDefaultTemplateIsReturnedWhenKeyWasNotFoundInTemplateRepositoriesTest(){
        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put("NAME", "Toon Sevrin");

        Message message = mock(Message.class);
        when(message.getLanguage()).thenReturn(english);
        when(message.getMessageKey()).thenReturn("exomsg.onjoin");
        when(message.getParameters()).thenReturn(parameters);
        when(message.getDefaultTemplate()).thenReturn("Welcome, <NAME>!");

        assertEquals("Welcome, Toon Sevrin!", languageAPI.getTranslated(message));
    }

    @Test
    public void idCanContainDotTest(){
        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put(".user.name.", "Toon Sevrin");

        Message message = mock(Message.class);
        when(message.getParameters()).thenReturn(parameters);

        String template = ".abc <.user.name.> abc.";
        assertEquals(".abc Toon Sevrin abc.", languageAPI.fillParameters(message, template));
    }
    @Test
    public void idCanContainDollarsTest(){
        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put("$user$name$", "Toon Sevrin");

        Message message = mock(Message.class);
        when(message.getParameters()).thenReturn(parameters);

        String template = ".abc <$user$name$> abc.";
        assertEquals(".abc Toon Sevrin abc.", languageAPI.fillParameters(message, template));
    }
    @Test
    public void fillThreeDifferentParametersTest(){
        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put("name", "Toon Sevrin");
        parameters.put("age", 18);
        parameters.put("gender", "male");

        Message message = mock(Message.class);
        when(message.getParameters()).thenReturn(parameters);

        String template = "<name>, aged <age> is a <gender>.";
        assertEquals("Toon Sevrin, aged 18 is a male.", languageAPI.fillParameters(message, template));
    }

    @Test
    public void fillParameterRepeatingTest(){
        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put("NAME", "Toon Sevrin");

        Message message = mock(Message.class);
        when(message.getParameters()).thenReturn(parameters);

        String template = "<NAME> <NAME> <NAME>";
        assertEquals("Toon Sevrin Toon Sevrin Toon Sevrin", languageAPI.fillParameters(message, template));
    }
}
