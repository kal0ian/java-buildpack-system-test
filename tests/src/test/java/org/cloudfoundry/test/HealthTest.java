/*
 * Copyright 2016 the original author or authors.
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

package org.cloudfoundry.test;


import org.cloudfoundry.test.support.application.Application;
import reactor.test.StepVerifier;

import java.time.Duration;

@TestType("health")
public final class HealthTest extends AbstractTest {

    @Override
    protected void test(Application application) {
        application
            .request("/")
            .as(StepVerifier::create)
            .expectNext("ok")
            .expectComplete()
            .verify(Duration.ofMinutes(5));
    }

}
