package org.apache.maven.feature;

import java.util.Arrays;
import java.util.List;

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

/**
 * This enumeration contains those features which are activated by default.
 * Those features can be deactivated via <code>--deactivate-features MNGXXXX</code>.
 * 
 * @author Karl Heinz Marbaise <a href="mailto:khmarbaise@apache.org">khmarbaise@apache.org</a>
 *
 * @since 3.4.0
 */
public enum ActivatedFeatureToggles
{

    //FIXME: Only some examples given. Nothing which exists in reality.

    /**
     * MNG8000 this feature toggle is intended to do the following.. 
     */
    MNG8000( "MNG-8000", "This feature is activated by default and can only "
        + "deactivated by --deactivate-features MNG8000" ),

    /**
     * This is an feature toggle which will never being used nor does it exist.
     * This is only to mark the end of feature toggles. Also used for unit tests.
     * Furthermore by using this you can remove all other features but this
     * type keep a single entry. 
     * 
     * Keep it at the last position in this enumeration.
     */
    UNKNOWN ("UNKNOWN", "The unknown feature.");

    private String issue;

    private String description;

    private ActivatedFeatureToggles( String issue, String description )
    {
        this.issue = issue;
        this.description = description;
    }

    /**
     * @return The list of features without {@code #UNKNOWN}.
     */
    public static ActivatedFeatureToggles[] getActivatedFeatureToggles() {
        List<ActivatedFeatureToggles> asList = Arrays.asList( ActivatedFeatureToggles.values());

        ActivatedFeatureToggles[] result = new ActivatedFeatureToggles[asList.size() - 1];
        
        for ( int i = 0; i < asList.size() - 1; i++ )
        {
            if (asList.get( i ) != UNKNOWN) {
                result[i] = asList.get( i );
            }
        }
        return result;
    }
    
    public String getDescription()
    {
        return this.description;
    }

    public String getIssue()
    {
        return this.issue;
    }
}
