package com.exorath.language.api;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by toonsev on 8/26/2016.
 */
public class MessageTest {
    @Test
    public void createNotNullTest(){
        Language language = mock(Language.class);
        when(language.getLanguageId()).thenReturn("EN");
        assertNotNull(Message.create(language, "message_key", "default_msg"));
    }
}
