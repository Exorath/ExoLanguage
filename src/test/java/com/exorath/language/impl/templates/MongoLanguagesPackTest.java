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
