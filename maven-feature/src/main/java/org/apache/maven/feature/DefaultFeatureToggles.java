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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.codehaus.plexus.component.annotations.Component;
import org.codehaus.plexus.component.annotations.Requirement;
import org.codehaus.plexus.logging.Logger;

/**
 * This implements features toggles which can activated or 
 * asked if a particular feature toggle is active or not.
 * 
 * @author Karl Heinz Marbaise <a href="mailto:khmarbaise@apache.org">khmarbaise@apache.org</a>
 *
 * @since 3.4.0
 */
@Component( instantiationStrategy = "singleton", role = FeatureToggles.class )
public class DefaultFeatureToggles
    implements FeatureToggles
{
    @Requirement
    private Logger logger;

    private List<AvailableFeatureToggles> activatedFeatureToggles;

    /** {@inheritDoc} */
    public void setActivatedFeatureToggles( List<AvailableFeatureToggles> featuresToBeActivated )
    {
        if ( featuresToBeActivated == null )
        {
            this.activatedFeatureToggles = new ArrayList<>();
        }
        else
        {
            this.activatedFeatureToggles = featuresToBeActivated;
        }
    }

    /** {@inheritDoc} */
    public boolean isToggleActive( AvailableFeatureToggles feature )
    {
        if ( activatedFeatureToggles != null )
        {
            return activatedFeatureToggles.contains( feature );
        }
        return false;
    }

    public List<AvailableFeatureToggles> getActiveFeatureToggles()
    {
        if ( activatedFeatureToggles == null )
        {
            return Collections.emptyList();
        }
        else
        {
            return activatedFeatureToggles;
        }
    }
    
}
