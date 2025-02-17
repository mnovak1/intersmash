/**
 * Copyright (C) 2023 Red Hat, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.intersmash.application.openshift;

import java.util.Collections;
import java.util.List;

import org.jboss.intersmash.application.openshift.input.BinarySourceBuilder;
import org.jboss.intersmash.application.openshift.input.BuildInput;
import org.jboss.intersmash.application.openshift.input.BuildInputBuilder;
import org.jboss.intersmash.application.openshift.input.GitSourceBuilder;
import org.jboss.intersmash.provision.openshift.Eap7ImageOpenShiftProvisioner;

import io.fabric8.kubernetes.api.model.EnvVar;

/**
 * End user Application descriptor interface which presents a AP 7.z (i.e. Jakarta EE 8 based WildFly) application on
 * OpenShift Container Platform.
 *
 * The application will be deployed by:
 * <ul>
 *     <li>{@link Eap7ImageOpenShiftProvisioner}</li>
 * </ul>
 */
public interface Eap7ImageOpenShiftApplication extends WildflyImageOpenShiftApplication, HasEnvVars {

	/**
	 * Use the {@link BuildInputBuilder} to get instances
	 * implementing the {@link BuildInput} interface.
	 *
	 * @see GitSourceBuilder
	 * @see BinarySourceBuilder
	 * @return {@link BuildInput} instance for application
	 */
	BuildInput getBuildInput();

	@Override
	default List<EnvVar> getEnvVars() {
		return Collections.emptyList();
	}

	/**
	 * Override this in the implementation class to return a non-null value in case you want to create a ping service
	 * to be used for DNS_PING clustering. The provisioner will take care of setting up all the ENV variables needed
	 * for clustering to work.
	 * If this method returns null, no service will be created.
	 *
	 * @return The name of the ping-service that will be created.
	 */
	default String getPingServiceName() {
		return null;
	}
}
