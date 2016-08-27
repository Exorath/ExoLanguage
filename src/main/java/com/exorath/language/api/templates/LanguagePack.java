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

package com.exorath.language.api.templates;

import com.exorath.language.api.Language;
import com.exorath.language.impl.templates.ILanguagePack;

import java.util.HashMap;

/**
 * The {@link LanguagePack} represents a collection of templates in a specific language.
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
     * @param key the key that identifies this template (the message key).
     * @param template the template to add
     */
    void addTemplate(String key, Template template);

    /**
     * Creates a new instance of this {@link LanguagePack}.
     * @param language the language the templates of this {@link LanguagePack} are in
     * @return the newly created instance
     */
    static LanguagePack create(Language language){
        return new ILanguagePack(language);
    }
}
