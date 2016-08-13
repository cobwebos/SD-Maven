package org.apache.maven.feature;

import static org.assertj.core.api.Assertions.assertThat;

import org.apache.maven.feature.FeatureKnob.FeatureKnobNames;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Karl Heinz Marbaise <a href="mailto:khmarbaise@apache.org">khmarbaise@apache.org</a>
 * @since 3.4.0
 */
public class FeatureKnobTest
{

    private FeatureKnob fn;

    @Before
    public void before()
    {
        fn = new FeatureKnob();
    }

    @Test
    public void getActiveFeaturesShouldNotReturnNotNullAndSizeOfListZero()
    {
        // mvn -DfeatureKnob1=behaviour1
        // mvn .. => featureKnob1=defaultBehaviour
        //
        assertThat( fn.getFeatureKnob( FeatureKnobNames.FIRST ) ).isEqualTo( "XX" );
    }

}
