package com.exorath.language.api;

import com.exorath.language.impl.IMessage;

import java.util.HashMap;

/**
 * Created by toonsev on 8/24/2016.
 */
public interface Message {
    /**
     * Gets the language you would like to get this message translated into
     * @return the language you would like to get this message translated into
     */
    Language getLanguage();

    /**
     * Gets the id of the message you would like to retrieve. This is the message identifier.
     * @return the id of the message you would like to retrieve
     */
    String getMessageKey();

    /**
     * The message may contain parameters with the following syntax: <PARAMETER_ID>, these parameters will be replaced by the parameters in this HashMap
     *
     * @return
     */
    HashMap<String, Object> getParameters();

    /**
     * Adds a default template to the message. This template will be used if no template was found within the language's registered templates.
     * @param defaultTemplate the default template to use in case no template was found
     * @return this Message instance
     */
    Message withDefault(String defaultTemplate);

    /**
     * Adds a parameter value to the message. This parameter may be used in the language specific templates.
     *
     * @param key the identifier of the parameter (used in the template: <KEY>)
     * @param parameter the value of this parameter
     * @return  this Message instance
     */
    Message withParam(String key, Object parameter);

    /**
     * Gets the default template (assigned with the {@link #withDefault(String)}
     * @return the default template
     */
    String getDefaultTemplate();

    static Message create(Language language, String messageKey, String defaultMsg){
        return new IMessage(language, messageKey, defaultMsg);
    }
}