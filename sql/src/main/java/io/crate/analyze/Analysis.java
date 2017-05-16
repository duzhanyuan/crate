/*
 * Licensed to CRATE Technology GmbH ("Crate") under one or more contributor
 * license agreements.  See the NOTICE file distributed with this work for
 * additional information regarding copyright ownership.  Crate licenses
 * this file to you under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.  You may
 * obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 *
 * However, if you have executed another commercial license agreement
 * with Crate these terms will supersede the license and you may use the
 * software solely pursuant to the terms of the relevant commercial agreement.
 */

package io.crate.analyze;

import io.crate.action.sql.SessionContext;
import io.crate.analyze.relations.AnalyzedRelation;
import io.crate.metadata.TransactionContext;

public class Analysis {

    private final ParameterContext parameterContext;
    private final TransactionContext transactionContext;

    private final ParamTypeHints paramTypeHints;
    private AnalyzedStatement analyzedStatement;
    private AnalyzedRelation rootRelation;

    public Analysis(SessionContext sessionContext, ParameterContext parameterContext, ParamTypeHints paramTypeHints) {
        this.paramTypeHints = paramTypeHints;
        this.transactionContext = new TransactionContext(sessionContext);
        this.parameterContext = parameterContext;
    }

    public void analyzedStatement(AnalyzedStatement analyzedStatement) {
        this.analyzedStatement = analyzedStatement;
    }

    public AnalyzedStatement analyzedStatement() {
        return analyzedStatement;
    }

    public ParameterContext parameterContext() {
        return parameterContext;
    }

    public void rootRelation(AnalyzedRelation rootRelation) {
        this.rootRelation = rootRelation;
    }

    public AnalyzedRelation rootRelation() {
        return rootRelation;
    }

    public TransactionContext transactionContext() {
        return transactionContext;
    }

    public SessionContext sessionContext() {
        return transactionContext.sessionContext();
    }

    public ParamTypeHints paramTypeHints() {
        return paramTypeHints;
    }
}
