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

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by toonsev on 8/26/2016.
 */
public class ITemplateTest {
    private ITemplate template;

    @Before
    public void setup(){
        template = new ITemplate("templateid");
    }

    @Test
    public void getTemplateStringNotNullTest(){
        assertNotNull(template.getTemplateString());
    }

    @Test
    public void getTemplateStringEqualsTemplateStringTest(){
        assertEquals("templateid", template.getTemplateString());
    }

    @Test
    public void templateEqualsNewTemplateWithIdenticTemplateStringTestTest(){
        assertEquals(new ITemplate("templateid"), template);
    }
}
