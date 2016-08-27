package com.exorath.language.impl.templates;

import com.exorath.language.api.Language;
import com.github.fakemongo.Fongo;
import com.mongodb.MongoClient;
import org.bson.Document;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by toonsev on 8/27/2016.
 */
public class MongoLanguagesPackTest {
    private static final String DB_NAME = "testdb";
    private static final String COLL_NAME = "testcoll";
    private MongoClient client;
    MongoLanguagesPack mongoLanguagesPack;

    @Before
    public void setup(){
        client = new Fongo("testfongo").getMongo();
        mongoLanguagesPack = new MongoLanguagesPack(client, DB_NAME, COLL_NAME);
    }

    @Test
    public void getTemplatesPackNotNullTest(){
        assertNotNull(mongoLanguagesPack.getTemplatePacks());
    }

    @Test
    public void getTemplatesPackEmptyByDefaultTest(){
        assertTrue(mongoLanguagesPack.getTemplatePacks().isEmpty());
    }

    @Test
    public void getTemplatePacksContainsLanguageAddedToDatabaseTest(){
        client.getDatabase(DB_NAME).getCollection(COLL_NAME).insertOne(new Document("language", "EN")
                .append("templates", new Document("testkey", "testtemplate")));
        mongoLanguagesPack = new MongoLanguagesPack(client, DB_NAME, COLL_NAME);

        Language language = Language.create("EN");
        assertTrue( mongoLanguagesPack.getTemplatePacks().containsKey(language));
    }

    @Test
    public void getTemplatePacksLanguagePackcontainsTemplateAddedToDatabaseTest(){
        client.getDatabase(DB_NAME).getCollection(COLL_NAME).insertOne(new Document("language", "EN")
                .append("templates", new Document("testkey", "testtemplate")));
        mongoLanguagesPack = new MongoLanguagesPack(client, DB_NAME, COLL_NAME);
        assertEquals(new ITemplate("testtemplate") ,mongoLanguagesPack.getTemplatePacks().get(Language.create("EN")).getTemplates().get("testkey"));
    }
}
