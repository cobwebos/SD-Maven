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

import java.util.List;

/**
 * This gives access to the feature toggles which can be used during the run of Maven.
 * 
 * @author Karl Heinz Marbaise <a href="mailto:khmarbaise@apache.org">khmarbaise@apache.org</a>
 * @since 3.4.0
 */
public interface FeatureToggles
{

    /**
     * @return The list of features which will be activated.
     * @see AvailableFeatureToggles
     * @since 3.4.0
     */
    void setActivatedFeatureToggles( List<AvailableFeatureToggles> activatedFeatures );

    /**
     * Example code looks like this:
     * <pre>
     * <code>
     *  if (feature.isToggleActive( AvailableFeatureToggles.MNG10000 )) {
     *      // Do what is needed for the particular feature
     *  }
     * </code>
     * </pre>
     * 
     * @param feature The feature toggle to check for if it is activated or not.
     * @return <code>true</code> in case of feature has been activated via command line.
     *         <code>--activate-features MNG10000</code>, <code>false</code> otherwise.
     * @see AvailableFeatureToggles
     * @since 3.4.0
     */
    boolean isToggleActive( AvailableFeatureToggles feature );

    /**
     * @return The list of feature toggles which have been activated.
     * @see AvailableFeatureToggles
     * @since 3.4.0
     */
    List<AvailableFeatureToggles> getActiveFeatureToggles();

}
