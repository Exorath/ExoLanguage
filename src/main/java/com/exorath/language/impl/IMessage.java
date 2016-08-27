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
