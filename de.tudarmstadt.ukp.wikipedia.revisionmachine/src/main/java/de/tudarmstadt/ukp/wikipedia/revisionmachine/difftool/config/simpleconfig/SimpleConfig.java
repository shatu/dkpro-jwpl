/*******************************************************************************
 * Copyright 2015
 * Ubiquitous Knowledge Processing (UKP) Lab
 * Technische Universität Darmstadt
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package de.tudarmstadt.ukp.wikipedia.revisionmachine.difftool.config.simpleconfig;

import de.tudarmstadt.ukp.wikipedia.revisionmachine.difftool.config.gui.control.ConfigController;

/**
 * This class is an alternative to the ConfigGUI and can be used to produce
 * configuration files for the DiffTool.
 *
 */
public class SimpleConfig
{
	/** Reference to the ConfigController */
	private final ConfigController controller;

	/**
	 * (Constructor) Creates a new ConfigGUI object.
	 */
	public SimpleConfig()
	{
		this.controller = new ConfigController();
		controller.defaultConfiguration();
		//TODO nothing here yet...
	}
}
