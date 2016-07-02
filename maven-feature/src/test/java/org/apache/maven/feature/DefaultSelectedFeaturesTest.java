package org.apache.maven.feature;

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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * This implements some unit tests for checking the behaviour of the implementation.
 * 
 * @author Karl Heinz Marbaise <a href="mailto:khmarbaise@apache.org">khmarbaise@apache.org</a>
 * @since 3.4.0
 */
public class DefaultSelectedFeaturesTest
{
    private FeatureToggles sf;

    @Before
    public void before()
    {
        sf = new DefaultFeatureToggles();
    }

    @Test
    public void getActiveFeaturesShouldNotReturnNotNullAndSizeOfListZero()
    {
        assertNotNull( sf.getActiveFeatureToggles() );
        assertEquals( sf.getActiveFeatureToggles().size(), 0 );
    }

    @Test
    public void isToggleActiveShouldReturnFalseIfNoTogglesHadBeenActivatedAtAll()
    {
        assertFalse( sf.isToggleActive( AvailableFeatureToggles.UNKNOWN ) );
    }

    @Test
    public void isToggleActiveShouldReturnFalseIfNotTheCorrectFeatureIsActivated()
    {
        sf.setActivatedFeatureToggles( Arrays.asList( AvailableFeatureToggles.UNKNOWN ) );
        assertFalse( sf.isToggleActive( AvailableFeatureToggles.MNG10000 ) );
        assertTrue( sf.isToggleActive( AvailableFeatureToggles.UNKNOWN ) );
    }


    @Test
    public void getActiveFeatureTogglesShouldReturnFalse()
    {
        List<AvailableFeatureToggles> activeFeatureToggles = sf.getActiveFeatureToggles();
        assertEquals( 2, activeFeatureToggles.size() );
        assertFalse( sf.isToggleActive( AvailableFeatureToggles.MNG10000 ) );
        assertTrue( sf.isToggleActive( AvailableFeatureToggles.UNKNOWN ) );
    }
}
