package org.jboss.intersmash.testsuite.junit5.categories;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.junit.jupiter.api.Tag;

/**
 * Mark a test that does not support productized deliverables.
 * Used per class.
 */
@Tag("ts.not-for-prod")
@Retention(RetentionPolicy.RUNTIME)
@Target({ java.lang.annotation.ElementType.TYPE })
public @interface NotForProductizedExecutionProfile {
}
