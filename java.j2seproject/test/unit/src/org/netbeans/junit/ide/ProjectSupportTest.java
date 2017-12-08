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
package org.netbeans.junit.ide;

import java.io.File;
import java.io.IOException;
import org.netbeans.api.project.Project;
import org.netbeans.junit.NbTestCase;
import org.netbeans.junit.RandomlyFails;
import org.netbeans.modules.project.ui.OpenProjectList;
import org.openide.util.test.MockLookup;

/** Test of ProjectSupport class.
 * @author Jiri Skrivanek 
 */
@RandomlyFails
public class ProjectSupportTest extends NbTestCase {
    
    /** Creates a new test. 
     * @param testName name of test
     */
    public ProjectSupportTest(String testName) {
        super(testName);
    }

    /** Set up. */
    protected @Override void setUp() throws IOException {
        MockLookup.setLayersAndInstances();
        clearWorkDir();
        System.out.println("########  "+getName()+"  #######");
    }

    private static final String PROJECT_NAME = "SampleProject";
    private static File projectParentDir;
    
    /** Test createProject method. */
    public void testCreateProject() throws Exception {
        projectParentDir = this.getWorkDir();
        Project project = (Project)ProjectSupport.createProject(this.getWorkDir(), PROJECT_NAME);
        Project[] projects = OpenProjectList.getDefault().getOpenProjects();
        assertEquals("Only 1 project should be opened.", 1, projects.length);
        assertSame("Created project not opened.", project, projects[0]);
    }
    
    /** Test closeProject method. */
    @SuppressWarnings("deprecation")
    public void testCloseProject() {
        assertTrue("Should return true if succeeded.", ProjectSupport.closeProject(PROJECT_NAME));
        Project[] projects = OpenProjectList.getDefault().getOpenProjects();
        assertEquals("None project should be opened.", 0, projects.length);
        assertFalse("Should return false if project doesn't exist.", ProjectSupport.closeProject("Dummy"));
    }
    
    /** Test openProject method. */
    @SuppressWarnings("deprecation")
    public void testOpenProject() throws Exception {
        Project project = (Project)ProjectSupport.openProject(new File(projectParentDir, PROJECT_NAME));
        Project[] projects = OpenProjectList.getDefault().getOpenProjects();
        assertEquals("Only 1 project should be opened.", 1, projects.length);
        assertSame("Opened project not opened.", project, projects[0]);
        assertNull("Should return null if project doesn't exist.", ProjectSupport.openProject(new File(projectParentDir, "Dummy")));
    }
    
    /** Test waitScanFinished method. */
    public void testWaitScanFinished() {
        // TODO - somehow check this functionality
        ProjectSupport.waitScanFinished();
    }
}
