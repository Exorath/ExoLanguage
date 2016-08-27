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

import com.exorath.language.impl.ILanguage;

/**
 * This class represents a language, the id should be an unique identifier for the language. For convenience we recommend using codes like EN, FR, DE, NL, IT, ES...
 * {@link Language#equals(Object)} will equal languages with the same id, just as the HashCodes will be equal.
 * Created by toonsev on 8/23/2016.
 */
public interface Language {
    /**
     * Gets the identifier of this language (fe. EN, ES, FR, NL...).
     * @return the identifier of this language
      */
    String getLanguageId();

    /**
     * Creates a new Language instance with a specified identifier.
     * @param languageId the identifier of this language (EN, ES, FR...)
     * @return a new language instance.
     */
    static Language create(String languageId){
        return new ILanguage(languageId);
    }
}
