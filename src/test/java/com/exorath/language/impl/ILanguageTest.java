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
