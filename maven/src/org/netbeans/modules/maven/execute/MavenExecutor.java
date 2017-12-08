/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.netbeans.modules.maven.execute;

import org.openide.execution.ExecutorTask;
import org.openide.windows.InputOutput;
import org.openide.windows.OutputListener;

/**
 * What the executors have in common.
 * @author mkleint
 */
public interface MavenExecutor extends Runnable {

    void setTask(ExecutorTask task);
    
    InputOutput getInputOutput();
    
    void addInitialMessage(String line, OutputListener listener);
}
