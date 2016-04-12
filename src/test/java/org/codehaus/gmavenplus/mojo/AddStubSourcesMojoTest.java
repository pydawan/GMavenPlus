/*
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * You may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.codehaus.gmavenplus.mojo;

import org.apache.maven.project.MavenProject;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.File;

import static org.mockito.Mockito.verify;


/**
 * Unit tests for the AddStubSourcesMojo class.
 *
 * @author Keegan Witt
 */
public class AddStubSourcesMojoTest {
    private AddStubSourcesMojo mojo;
    @Mock
    private MavenProject project;
    @Mock
    private File stubsOutputDirectory;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mojo = new AddStubSourcesMojo();
        mojo.project = project;
        mojo.stubsOutputDirectory = stubsOutputDirectory;
    }

    @Test
    public void testAddsStubsToSources() throws Exception {
        mojo.execute();
        verify(project).addCompileSourceRoot(stubsOutputDirectory.getAbsolutePath());
    }

}
