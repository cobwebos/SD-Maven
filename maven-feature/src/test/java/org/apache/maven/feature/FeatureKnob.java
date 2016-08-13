package org.apache.maven.feature;

import org.apache.commons.lang3.StringUtils;

public class FeatureKnob
{

    public enum FeatureKnobNames
    {
        FIRST,
        SECOND
    }
    
    public static class FeatureNobFirst {
        public enum FeatureNobValues {
            First,
            Second,
            Third
        }
    }

    boolean doesFeatureKnobExist( FeatureKnobNames name )
    {
        String property = System.getProperty( name.toString() );
        if ( StringUtils.isEmpty( property ) )
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    public String getFeatureKnob( FeatureKnobNames first )
    {
        if (doesFeatureKnobExist( first )) {
            return StringUtils.EMPTY;
        } else 
        {
            //Good Idea?
            return StringUtils.EMPTY;
        }
    }
}