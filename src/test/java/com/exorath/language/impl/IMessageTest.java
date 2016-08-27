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
import com.exorath.language.impl.IMessage;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by toonsev on 8/26/2016.
 */
public class IMessageTest {
    private static final String MESSAGE_KEY = "exorath.welcome";
    private static final String MESSAGE_DEFAULT = "Welcome <USER_NAME> to <COMPANY>.";
    private Language language;
    private IMessage message;

    @Before
    public void setup(){
        language = mock(Language.class);
        when(language.getLanguageId()).thenReturn("EN");

        message = new IMessage(language, MESSAGE_KEY, MESSAGE_DEFAULT);
    }

    @Test
    public void getLanguageNotNullTest(){
        assertNotNull(message.getLanguage());
    }

    @Test
    public void getLanguageEqualsLanguageTest(){
        assertEquals(language, message.getLanguage());
    }

    @Test
    public void getMessageKeyNotNulLTest(){
        assertNotNull(message.getMessageKey());
    }

    @Test
    public void getMessageKeyEqualsMessageKeyTest(){
        assertEquals(MESSAGE_KEY, message.getMessageKey());
    }

    @Test
    public void getDefaultTemplateNotNullTest(){
        assertNotNull(message.getDefaultTemplate());
    }
    @Test
    public void getDefaultTemplateEqualsDefaultTemplateTest(){
        assertEquals(MESSAGE_KEY, message.getMessageKey());
    }

    @Test
    public void getParametersNotNullTest(){
        assertNotNull(message.getParameters());
    }
    @Test
    public void withParamAddsParameterToGetParametersTest(){
        message.withParam("key1", "value1");
        assertTrue(message.getParameters().containsKey("key1") && message.getParameters().containsValue("value1"));
    }
    @Test
    public void getParametersContainsParametersAddedWithWithParamTest(){
        message.withParam("key1", "value1").withParam("key2", "value2");
        assertTrue(message.getParameters().containsKey("key1") && message.getParameters().containsKey("key2"));
    }
}
