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

package com.exorath.language.api;

import com.exorath.language.api.templates.LanguagesPack;
import com.exorath.language.impl.ILanguageAPI;


/**
 * This is the base class you will be interacting with.
 * If your project wants to send messages using the LanguageAPI. It should create an instance of this class with the {@link #create()} method.
 * You can translate a message with the {@link #getTranslated(Message)} method, which will cycle through the added {@link LanguagesPack}'s to find the appropriate translation.
 * Created by toonsev on 8/23/2016.
 */
public interface LanguageAPI {
    /**
     * Adds a language pack to the LanguageAPI. When a message needs to be translated it checks the templates in the appropriate language in this pack for a translation.
     * The LanguageAPI may clone all templates as soon as this message is called, or call the {@link LanguagesPack#getTemplatePacks()} anytime a message needs to be translated. Your LanguagesPack should be able to handle both.
     * @param languagesPack the {@link LanguagesPack} to add
     */
    void addLanguagesPack(LanguagesPack languagesPack);

    /**
     * Translates an {@link Message} in the language of {@link Message#getLanguage()} and fills the {@link Message#getParameters()} in.
     * Translation templates should be added through {@link LanguagesPack}'s.
     * @param message the message you wish to translate
     * @return the translated message.
     */
    String getTranslated(Message message);

    /**
     * Creates a new instance of the {@link LanguageAPI}. Instances of this API do not share LanguagePacks so do not try to access keys of other projects.
     * @return a new instance of the {@link LanguageAPI}.
     */
    static LanguageAPI create(){
        return new ILanguageAPI();
    }
}
