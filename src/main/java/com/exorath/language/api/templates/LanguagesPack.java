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

import java.util.HashMap;

/**
 * The {@link LanguagesPack} represents a collection of {@link LanguagePack}'s in different languages.
 * Created by toonsev on 8/26/2016.
 */
public interface LanguagesPack {
    /**
     * Gets the registered {@link LanguagePack}'s by their Language.
     *
     * If you override this method make sure it does not require any io.
     * The IO should be done when the {@link LanguagesPack} is instantiated.
     * Take a look at {@link com.exorath.language.impl.templates.MongoLanguagesPack} for an example.
     *
     * @return the registered {@link LanguagePack}'s by their Language.
     */
    HashMap<Language, LanguagePack> getTemplatePacks();
}
