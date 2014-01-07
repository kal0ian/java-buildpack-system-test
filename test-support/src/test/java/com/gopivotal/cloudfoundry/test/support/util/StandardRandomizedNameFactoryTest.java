/*
 * Copyright 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.gopivotal.cloudfoundry.test.support.util;

import org.junit.Test;

import java.util.regex.Pattern;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public final class StandardRandomizedNameFactoryTest {

    private static final Pattern NAME_PATTERN = Pattern.compile("system-test-discriminator-stem-[\\d]{6}");

    private final StandardRandomizedNameFactory randomizedNameFactory = new StandardRandomizedNameFactory
            ("discriminator");

    @Test
    public void create() {
        assertTrue(NAME_PATTERN.matcher(this.randomizedNameFactory.create("stem")).matches());
    }

    @Test
    public void doesMatch() {
        assertTrue(this.randomizedNameFactory.matches("system-test-discriminator-stem-012345"));
    }

    @Test
    public void doesNotMatch() {
        assertFalse(this.randomizedNameFactory.matches("system-test-not-discriminator-stem-012345"));
    }

}
