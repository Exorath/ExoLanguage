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
