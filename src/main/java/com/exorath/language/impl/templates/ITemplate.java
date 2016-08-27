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

package com.exorath.language.impl.templates;

import com.exorath.language.api.Language;
import com.exorath.language.api.templates.Template;
import com.exorath.language.impl.ILanguage;

/**
 * Created by toonsev on 8/26/2016.
 */
public class ITemplate implements Template{
    private String templateString;

    public ITemplate(String templateString){
        this.templateString = templateString;
    }

    @Override
    public String getTemplateString() {
        return templateString;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) return true;
        if(!(obj instanceof Template))
            return false;
        return this.getTemplateString().equals(((Template) obj).getTemplateString());
    }

    @Override
    public int hashCode() {
        return templateString.hashCode();
    }
}
