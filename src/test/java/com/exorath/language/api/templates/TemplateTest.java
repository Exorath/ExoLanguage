package com.exorath.language.api.templates;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Created by toonsev on 8/26/2016.
 */
public class TemplateTest {
    @Test
    public void createNotNullTest(){
        assertNotNull(Template.create("This is a template: <SAMPLE_PARAMETER>"));
    }
}
