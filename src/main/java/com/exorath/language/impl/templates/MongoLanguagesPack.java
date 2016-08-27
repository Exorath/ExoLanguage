package com.exorath.language.impl.templates;

import com.exorath.exodata.api.DataAPI;
import com.exorath.exodata.api.ExoCollection;
import com.exorath.exodata.api.ExoDatabase;
import com.exorath.language.api.Language;
import com.exorath.language.api.templates.LanguagesPack;
import com.exorath.language.api.templates.LanguagePack;
import com.exorath.language.api.templates.Template;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import org.bson.Document;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * TODO:
 * - Documentation
 * - Testing
 * Created by toonsev on 8/26/2016.
 */
public class MongoLanguagesPack implements LanguagesPack {
    private static final String LANGUAGE_KEY = "language";
    private static final String TEMPLATES_KEY = "templates";

    private HashMap<Language, LanguagePack> templatePacks = new HashMap<>();

    public MongoLanguagesPack(MongoClient client, String databaseName, String collectionName) {
        ExoCollection collection = getCollection(client, databaseName, collectionName);
        if (collection == null) {
            System.out.println("[ExoLanguage][ERROR] could not connect to collection: " + collectionName + " in db: " + databaseName);
            return;
        }
        loadLanguagePacks(collection.getMongoCollection());
    }

    private void loadLanguagePacks(MongoCollection collection) {
        MongoCursor<Document> cursor = collection.find().iterator();
        while (cursor.hasNext()) {
            Document document = cursor.next();
            try {
                loadLanguagePack(collection, document);
            } catch (Exception exception) {
                System.out.println("[ExoLanguage][ERROR] The following error was ignored:");
                exception.printStackTrace();
            }
        }
    }

    private void loadLanguagePack(MongoCollection collection, Document document) {
        if (!document.containsKey(LANGUAGE_KEY)) {
            System.out.println("document '" + document.getString("_id") + "' in collection '" + collection.getNamespace().getCollectionName() + "' does not have a 'language' field.");
        } else if (document.containsKey(TEMPLATES_KEY)) {
            Language language = Language.create(document.getString(LANGUAGE_KEY));
            LanguagePack pack = LanguagePack.create(language);

            loadTemplatesToLanguagePack(pack, document.get(TEMPLATES_KEY, Document.class));

            templatePacks.put(language, pack);
        }
    }

    private void loadTemplatesToLanguagePack(LanguagePack pack, Document templates){
        for (Map.Entry<String, Object> entry : templates.entrySet())
            if (entry.getValue() instanceof String)
                pack.addTemplate(entry.getKey(), Template.create((String) entry.getValue()));
    }

    private ExoCollection getCollection(MongoClient client, String databaseName, String collectionName) {
        DataAPI dataAPI = DataAPI.create(client);
        ExoDatabase database = dataAPI.getDatabase(databaseName).timeout(5, TimeUnit.SECONDS).toBlocking().first();
        if (database == null)
            return null;
        ExoCollection collection = database.getCollection(collectionName).timeout(5, TimeUnit.SECONDS).toBlocking().first();
        return collection;
    }

    @Override
    public HashMap<Language, LanguagePack> getTemplatePacks() {
        return templatePacks;
    }
}
