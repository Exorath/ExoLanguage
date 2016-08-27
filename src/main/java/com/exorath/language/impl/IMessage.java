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

package com.exorath.language.impl;

import com.exorath.language.api.Language;
import com.exorath.language.api.Message;

import java.util.HashMap;

/**
 * Created by toonsev on 8/25/2016.
 */
public class IMessage implements Message {
    private Language language;
    private String messageKey;
    private String defaultTemplate;
    private HashMap<String, Object> arguments = new HashMap<>();

    public IMessage(Language language, String messageKey, String defaultMsg) {
        this.language = language;
        this.messageKey = messageKey;
    }

    @Override
    public Language getLanguage() {
        return language;
    }

    @Override
    public String getMessageKey() {
        return messageKey;
    }

    @Override
    public HashMap<String, Object> getParameters() {
        return arguments;
    }

    @Override
    public Message withParam(String key, Object parameter) {
        arguments.put(key, parameter);
        return this;
    }

    @Override
    public Message withDefault(String defaultTemplate) {
        this.defaultTemplate = defaultTemplate;
        return this;
    }

    @Override
    public String getDefaultTemplate() {
        return defaultTemplate;
    }
}
