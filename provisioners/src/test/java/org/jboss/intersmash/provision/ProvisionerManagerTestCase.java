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
package org.jboss.intersmash.provision;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.jboss.intersmash.application.Application;
import org.jboss.intersmash.application.openshift.ActiveMQOperatorApplication;
import org.jboss.intersmash.application.openshift.BootableJarOpenShiftApplication;
import org.jboss.intersmash.application.openshift.Eap7LegacyS2iBuildTemplateApplication;
import org.jboss.intersmash.application.openshift.KafkaOperatorApplication;
import org.jboss.intersmash.application.openshift.MysqlImageOpenShiftApplication;
import org.jboss.intersmash.application.openshift.PostgreSQLImageOpenShiftApplication;
import org.jboss.intersmash.application.openshift.PostgreSQLTemplateOpenShiftApplication;
import org.jboss.intersmash.application.openshift.RhSsoTemplateOpenShiftApplication;
import org.jboss.intersmash.application.openshift.WildflyImageOpenShiftApplication;
import org.jboss.intersmash.application.openshift.WildflyOperatorApplication;
import org.jboss.intersmash.application.openshift.template.PostgreSQLTemplate;
import org.jboss.intersmash.application.openshift.template.RhSsoTemplate;
import org.jboss.intersmash.provision.openshift.ActiveMQOperatorProvisioner;
import org.jboss.intersmash.provision.openshift.Eap7LegacyS2iBuildTemplateProvisioner;
import org.jboss.intersmash.provision.openshift.KafkaOperatorProvisioner;
import org.jboss.intersmash.provision.openshift.MysqlImageOpenShiftProvisioner;
import org.jboss.intersmash.provision.openshift.PostgreSQLImageOpenShiftProvisioner;
import org.jboss.intersmash.provision.openshift.PostgreSQLTemplateOpenShiftProvisioner;
import org.jboss.intersmash.provision.openshift.RhSsoTemplateOpenShiftProvisioner;
import org.jboss.intersmash.provision.openshift.WildflyBootableJarImageOpenShiftProvisioner;
import org.jboss.intersmash.provision.openshift.WildflyImageOpenShiftProvisioner;
import org.jboss.intersmash.provision.openshift.WildflyOperatorProvisioner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * | Service                                 | Source   | Provisioner                             		|
 * |-----------------------------------------|----------|-----------------------------------------------|
*  | WildflyImageOpenShiftApplication        | IMAGE    | WildflymageOpenShiftProvisioner         		|
 * | InfinispanImageOpenShiftApplication     | IMAGE    | InfinispanImageOpenShiftProvisioner     		|
 * | MysqlImageOpenShiftApplication          | IMAGE    | MysqlImageOpenShiftProvisioner          		|
 * | PostgreSQLImageOpenShiftApplication     | IMAGE    | PostgreSQLImageOpenShiftProvisioner     		|
 * | Eap7LegacyS2iBuildTemplateApplication   | TEMPLATE | Eap7LegacyS2iBuildTemplateProvisioner    		|
 * | WildflyOperatorApplication              | OPERATOR | WildflyOperatorProvisioner              		|
*  | ActiveMQOperatorApplication             | OPERATOR | ActiveMQOperatorProvisioner             		|
 * | KafkaOperatorApplication           	 | OPERATOR | KafkaOperatorProvisioner           	  		|
 * | WildflyBootableJarOpenShiftApplication  | IMAGE    | WildflyBootableJarImageOpenShiftProvisioner	|
 * | RhSsoTemplateOpenShiftApplication       | TEMPLATE | RhSsoTemplateOpenShiftProvisioner   			|
 */
public class ProvisionerManagerTestCase {
	private Application application;

	/**
	 * | WildflyImageOpenShiftApplication        | IMAGE    | WildflyImageOpenShiftProvisioner        |
	 */
	@Test
	public void openShiftWildflyImageProvisioner() {
		application = mock(WildflyImageOpenShiftApplication.class);

		Provisioner actual = ProvisionerManager.getProvisioner(application);
		Assertions.assertEquals(WildflyImageOpenShiftProvisioner.class, actual.getClass());
	}

	/**
	 * | WildflyBootableJarOpenShiftApplication | IMAGE    | WildflyBootableJarImageOpenShiftProvisioner |
	 */
	@Test
	public void openShiftWildflyBootableJarImageProvisioner() {
		application = mock(BootableJarOpenShiftApplication.class);

		Provisioner actual = ProvisionerManager.getProvisioner(application);
		Assertions.assertEquals(WildflyBootableJarImageOpenShiftProvisioner.class, actual.getClass());
	}

	/**
	 * | MysqlImageOpenShiftApplication      | IMAGE    | MysqlImageOpenShiftProvisioner      |
	 */
	@Test
	public void openShiftMysqlImageProvisioner() {
		application = mock(MysqlImageOpenShiftApplication.class);

		Provisioner actual = ProvisionerManager.getProvisioner(application);
		Assertions.assertEquals(MysqlImageOpenShiftProvisioner.class, actual.getClass());
	}

	/**
	 * | PostgreSQLImageOpenShiftApplication | IMAGE    | PostgreSQLImageOpenShiftProvisioner |
	 */
	@Test
	public void openShiftPostgreSQLImageProvisioner() {
		application = mock(PostgreSQLImageOpenShiftApplication.class);

		Provisioner actual = ProvisionerManager.getProvisioner(application);
		Assertions.assertEquals(PostgreSQLImageOpenShiftProvisioner.class, actual.getClass());
	}

	/**
	 * | WildflyOperatorApplication          |          | WildflyOperatorProvisioner              |
	 */
	@Test
	public void wildflyOperatorProvisioner() {
		application = mock(WildflyOperatorApplication.class);

		Provisioner actual = ProvisionerManager.getProvisioner(application);
		Assertions.assertEquals(WildflyOperatorProvisioner.class, actual.getClass());
	}

	/**
	 * | ActiveMQOperatorApplication    |          | ActiveMQOperatorProvisioner        |
	 */
	@Test
	public void activeMQOperatorProvisioner() {
		application = mock(ActiveMQOperatorApplication.class);

		Provisioner actual = ProvisionerManager.getProvisioner(application);
		Assertions.assertEquals(ActiveMQOperatorProvisioner.class, actual.getClass());
	}

	/**
	 * | KafkaOperatorApplication    |          | KafkaOperatorProvisioner        |
	 */
	@Test
	public void kafkaOperatorProvisioner() {
		application = mock(KafkaOperatorApplication.class);

		Provisioner actual = ProvisionerManager.getProvisioner(application);
		Assertions.assertEquals(KafkaOperatorProvisioner.class, actual.getClass());
	}

	/**
	 * Eap7LegacyS2iBuildTemplateApplication / Eap7LegacyS2iBuildTemplateProvisioner
	 */
	@Test
	public void eapS2iBuildTemplateProvisioner() {
		application = mock(Eap7LegacyS2iBuildTemplateApplication.class);

		Provisioner actual = ProvisionerManager.getProvisioner(application);
		Assertions.assertEquals(Eap7LegacyS2iBuildTemplateProvisioner.class, actual.getClass());
	}

	/**
	 * | RhSsoTemplateOpenShiftApplication      | TEMPLATE | RhSsoTemplateOpenShiftProvisioner   |
	 */
	@Test
	public void openShiftRhSsoTemplateProvisioner() {
		application = mock(RhSsoTemplateOpenShiftApplication.class);
		when(((RhSsoTemplateOpenShiftApplication) application).getTemplate()).thenReturn(RhSsoTemplate.X509_HTTPS);

		Provisioner actual = ProvisionerManager.getProvisioner(application);
		Assertions.assertEquals(RhSsoTemplateOpenShiftProvisioner.class, actual.getClass());
	}

	/**
	 * | PostgreSQLTemplateOpenShiftApplication / PostgreSQLTemplateOpenShiftProvisioner  |
	 */
	@Test
	public void openShiftPostgreSQLTemplateProvisioner() {
		application = mock(PostgreSQLTemplateOpenShiftApplication.class);
		when(((PostgreSQLTemplateOpenShiftApplication) application).getTemplate())
				.thenReturn(PostgreSQLTemplate.POSTGRESQL_PERSISTENT);

		Provisioner actual = ProvisionerManager.getProvisioner(application);
		Assertions.assertEquals(PostgreSQLTemplateOpenShiftProvisioner.class, actual.getClass());
	}

	@Test
	public void unsupportedProvisioner() {
		Assertions.assertThrows(UnsupportedOperationException.class,
				() -> ProvisionerManager.getProvisioner(() -> "dummy"));
	}
}
