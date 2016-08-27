package com.exorath.language.api.templates;

import com.exorath.language.api.Language;
import com.exorath.language.impl.templates.ILanguagePack;

import java.util.HashMap;

/**
 * Created by toonsev on 8/26/2016.
 */
public interface LanguagePack {
    /**
     * Gets the language of the templates in this repository.
     * @return the language of the templates in this repository
     */
     Language getLanguage();

    /**
     * Gets a map of all templates in this pack.
     * @return a map of all templates in this pack
     */
    HashMap<String, Template> getTemplates();


    /**
     * Adds a template to this pack. Tbis template should be in the pack's language.
     * @param key the key that identifies this template
     * @param template the template to add
     */
    void addTemplate(String key, Template template);

    static LanguagePack create(Language language){
        return new ILanguagePack(language);
    }
}
