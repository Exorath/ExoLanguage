package com.exorath.language.impl.templates;

import com.exorath.language.api.Language;
import com.exorath.language.api.templates.LanguagePack;
import com.exorath.language.api.templates.Template;

import java.util.HashMap;

/**
 * Created by toonsev on 8/26/2016.
 */
public class ILanguagePack implements LanguagePack {
    private Language language;
    private HashMap<String, Template> templates = new HashMap<>();

    public ILanguagePack(Language language){
        this.language = language;
    }
    @Override
    public Language getLanguage() {
        return language;
    }

    @Override
    public void addTemplate(String key, Template template) {
        templates.put(key, template);
    }

    @Override
    public HashMap<String, Template> getTemplates() {
        return templates;
    }
}
